package org.eclipse.jgit.dircache;

import com.google.common.primitives.SignedBytes;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.text.MessageFormat;
import java.time.Instant;
import java.util.Arrays;
import kotlin.time.DurationKt;
import org.eclipse.jgit.errors.CorruptObjectException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.FileMode;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.util.IO;
import org.eclipse.jgit.util.MutableInteger;
import org.eclipse.jgit.util.NB;
import org.eclipse.jgit.util.SystemReader;

/* JADX INFO: loaded from: classes5.dex */
public class DirCacheEntry {
    private static final int ASSUME_VALID = 128;
    private static final int EXTENDED = 64;
    private static final int EXTENDED_FLAGS = 1610612736;
    private static final int INFO_LEN = 62;
    private static final int INFO_LEN_EXTENDED = 64;
    private static final int INTENT_TO_ADD = 536870912;
    private static final int NAME_MASK = 4095;
    private static final int P_CTIME = 0;
    private static final int P_FLAGS = 60;
    private static final int P_FLAGS2 = 62;
    private static final int P_MODE = 24;
    private static final int P_MTIME = 8;
    private static final int P_OBJECTID = 40;
    private static final int P_SIZE = 36;
    private static final int SKIP_WORKTREE = 1073741824;
    public static final int STAGE_0 = 0;
    public static final int STAGE_1 = 1;
    public static final int STAGE_2 = 2;
    public static final int STAGE_3 = 3;
    private static final int UPDATE_NEEDED = 1;
    private static final byte[] nullpad = new byte[8];
    private byte inCoreFlags;
    private final byte[] info;
    private final int infoOffset;
    final byte[] path;

    static int getMaximumInfoLength(boolean z) {
        return z ? 64 : 62;
    }

    DirCacheEntry(byte[] bArr, MutableInteger mutableInteger, InputStream inputStream, MessageDigest messageDigest, Instant instant, DirCache.DirCacheVersion dirCacheVersion, DirCacheEntry dirCacheEntry) throws IOException {
        int i;
        int i2;
        this.info = bArr;
        int i3 = mutableInteger.value;
        this.infoOffset = i3;
        int i4 = 62;
        IO.readFully(inputStream, bArr, i3, 62);
        if (isExtended()) {
            IO.readFully(inputStream, bArr, i3 + 62, 2);
            if ((getExtendedFlags() & (-1610612737)) != 0) {
                throw new IOException(MessageFormat.format(JGitText.get().DIRCUnrecognizedExtendedFlags, String.valueOf(getExtendedFlags())));
            }
            i4 = 64;
        }
        mutableInteger.value += i4;
        messageDigest.update(bArr, i3, i4);
        if (dirCacheVersion == DirCache.DirCacheVersion.DIRC_VERSION_PATHCOMPRESS) {
            int i5 = inputStream.read();
            messageDigest.update((byte) i5);
            i = i5 & 127;
            while ((i5 & 128) != 0) {
                i5 = inputStream.read();
                messageDigest.update((byte) i5);
                i = ((i + 1) << 7) | (i5 & 127);
            }
            if (i < 0 || (dirCacheEntry != null && i > dirCacheEntry.path.length)) {
                if (dirCacheEntry == null) {
                    throw new IOException(MessageFormat.format(JGitText.get().DIRCCorruptLengthFirst, Integer.valueOf(i)));
                }
                throw new IOException(MessageFormat.format(JGitText.get().DIRCCorruptLength, Integer.valueOf(i), dirCacheEntry.getPathString()));
            }
        } else {
            i = 0;
        }
        int iDecodeUInt16 = NB.decodeUInt16(this.info, this.infoOffset + 60) & NAME_MASK;
        if (iDecodeUInt16 < NAME_MASK) {
            byte[] bArr2 = new byte[iDecodeUInt16];
            this.path = bArr2;
            if (dirCacheVersion == DirCache.DirCacheVersion.DIRC_VERSION_PATHCOMPRESS && dirCacheEntry != null) {
                byte[] bArr3 = dirCacheEntry.path;
                System.arraycopy(bArr3, 0, bArr2, 0, bArr3.length - i);
                byte[] bArr4 = dirCacheEntry.path;
                IO.readFully(inputStream, bArr2, bArr4.length - i, iDecodeUInt16 - (bArr4.length - i));
                byte[] bArr5 = dirCacheEntry.path;
                messageDigest.update(bArr2, bArr5.length - i, iDecodeUInt16 - (bArr5.length - i));
                iDecodeUInt16 -= dirCacheEntry.path.length - i;
            } else {
                IO.readFully(inputStream, bArr2, 0, iDecodeUInt16);
                messageDigest.update(bArr2, 0, iDecodeUInt16);
            }
            i2 = 0;
        } else {
            i2 = 1;
            if (dirCacheVersion != DirCache.DirCacheVersion.DIRC_VERSION_PATHCOMPRESS || dirCacheEntry == null || i == dirCacheEntry.path.length) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr6 = new byte[NAME_MASK];
                IO.readFully(inputStream, bArr6, 0, NAME_MASK);
                byteArrayOutputStream.write(bArr6);
                readNulTerminatedString(inputStream, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                this.path = byteArray;
                int length = byteArray.length;
                messageDigest.update(byteArray, 0, length);
                messageDigest.update((byte) 0);
                iDecodeUInt16 = length;
            } else {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                byte[] bArr7 = dirCacheEntry.path;
                byteArrayOutputStream2.write(bArr7, 0, bArr7.length - i);
                int nulTerminatedString = readNulTerminatedString(inputStream, byteArrayOutputStream2);
                byte[] byteArray2 = byteArrayOutputStream2.toByteArray();
                this.path = byteArray2;
                messageDigest.update(byteArray2, dirCacheEntry.path.length - i, nulTerminatedString);
                messageDigest.update((byte) 0);
                iDecodeUInt16 = nulTerminatedString;
            }
        }
        try {
            checkPath(this.path);
            if (dirCacheVersion != DirCache.DirCacheVersion.DIRC_VERSION_PATHCOMPRESS) {
                int i6 = i4 + iDecodeUInt16;
                int i7 = (((i6 + 8) & (-8)) - i6) - i2;
                if (i7 > 0) {
                    IO.skipFully(inputStream, i7);
                    messageDigest.update(nullpad, 0, i7);
                }
            } else if (i2 == 0) {
                int i8 = inputStream.read();
                if (i8 < 0) {
                    throw new EOFException(JGitText.get().shortReadOfBlock);
                }
                messageDigest.update((byte) i8);
            }
            if (mightBeRacilyClean(instant)) {
                smudgeRacilyClean();
            }
        } catch (InvalidPathException e) {
            CorruptObjectException corruptObjectException = new CorruptObjectException(e.getMessage());
            if (e.getCause() != null) {
                corruptObjectException.initCause(e.getCause());
                throw corruptObjectException;
            }
            throw corruptObjectException;
        }
    }

    public DirCacheEntry(String str) {
        this(Constants.encode(str), 0);
    }

    public DirCacheEntry(String str, int i) {
        this(Constants.encode(str), i);
    }

    public DirCacheEntry(byte[] bArr) {
        this(bArr, 0);
    }

    public DirCacheEntry(byte[] bArr, int i) {
        checkPath(bArr);
        if (i < 0 || 3 < i) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.get().invalidStageForPath, Integer.valueOf(i), toString(bArr)));
        }
        byte[] bArr2 = new byte[62];
        this.info = bArr2;
        this.infoOffset = 0;
        this.path = bArr;
        int i2 = (i & 3) << 12;
        NB.encodeInt16(bArr2, 60, bArr.length < NAME_MASK ? bArr.length | i2 : i2 | NAME_MASK);
    }

    public DirCacheEntry(DirCacheEntry dirCacheEntry) {
        this.path = dirCacheEntry.path;
        byte[] bArr = new byte[62];
        this.info = bArr;
        this.infoOffset = 0;
        System.arraycopy(dirCacheEntry.info, dirCacheEntry.infoOffset, bArr, 0, 62);
    }

    private int readNulTerminatedString(InputStream inputStream, OutputStream outputStream) throws IOException {
        int i = 0;
        while (true) {
            int i2 = inputStream.read();
            if (i2 < 0) {
                throw new EOFException(JGitText.get().shortReadOfBlock);
            }
            if (i2 == 0) {
                return i;
            }
            outputStream.write(i2);
            i++;
        }
    }

    void write(OutputStream outputStream, DirCache.DirCacheVersion dirCacheVersion, DirCacheEntry dirCacheEntry) throws IOException {
        int length;
        int i;
        int i2 = isExtended() ? 64 : 62;
        if (dirCacheVersion != DirCache.DirCacheVersion.DIRC_VERSION_PATHCOMPRESS) {
            outputStream.write(this.info, this.infoOffset, i2);
            byte[] bArr = this.path;
            outputStream.write(bArr, 0, bArr.length);
            int length2 = i2 + this.path.length;
            int i3 = (length2 + 8) & (-8);
            if (length2 != i3) {
                outputStream.write(nullpad, 0, i3 - length2);
                return;
            }
            return;
        }
        if (dirCacheEntry != null) {
            int iMin = Math.min(this.path.length, dirCacheEntry.path.length);
            i = 0;
            while (i < iMin && this.path[i] == dirCacheEntry.path[i]) {
                i++;
            }
            length = dirCacheEntry.path.length - i;
        } else {
            length = 0;
            i = 0;
        }
        byte[] bArr2 = new byte[16];
        int i4 = 15;
        bArr2[15] = (byte) (length & 127);
        while (true) {
            int i5 = length >>> 7;
            if (i5 != 0) {
                i4--;
                length = i5 - 1;
                bArr2[i4] = (byte) ((length & 127) | 128);
            } else {
                outputStream.write(this.info, this.infoOffset, i2);
                outputStream.write(bArr2, i4, 16 - i4);
                byte[] bArr3 = this.path;
                outputStream.write(bArr3, i, bArr3.length - i);
                outputStream.write(0);
                return;
            }
        }
    }

    public final boolean mightBeRacilyClean(Instant instant) {
        int i = this.infoOffset;
        return ((int) instant.getEpochSecond()) == NB.decodeInt32(this.info, i + 8) && instant.getNano() <= NB.decodeInt32(this.info, i + 12);
    }

    public final void smudgeRacilyClean() {
        int i = this.infoOffset;
        Arrays.fill(this.info, i + 36, i + 40, (byte) 0);
    }

    public final boolean isSmudged() {
        return getLength() == 0 && Constants.EMPTY_BLOB_ID.compareTo(this.info, this.infoOffset + 40) != 0;
    }

    final byte[] idBuffer() {
        return this.info;
    }

    final int idOffset() {
        return this.infoOffset + 40;
    }

    public boolean isAssumeValid() {
        return (this.info[this.infoOffset + 60] & 128) != 0;
    }

    public void setAssumeValid(boolean z) {
        if (z) {
            byte[] bArr = this.info;
            int i = this.infoOffset + 60;
            bArr[i] = (byte) (bArr[i] | (-128));
        } else {
            byte[] bArr2 = this.info;
            int i2 = this.infoOffset + 60;
            bArr2[i2] = (byte) (bArr2[i2] & 127);
        }
    }

    public boolean isUpdateNeeded() {
        return (this.inCoreFlags & 1) != 0;
    }

    public void setUpdateNeeded(boolean z) {
        if (z) {
            this.inCoreFlags = (byte) (this.inCoreFlags | 1);
        } else {
            this.inCoreFlags = (byte) (this.inCoreFlags & (-2));
        }
    }

    public int getStage() {
        return (this.info[this.infoOffset + 60] >>> 4) & 3;
    }

    public void setStage(int i) {
        if ((i & (-4)) != 0) {
            throw new IllegalArgumentException("Invalid stage, must be in range [0..3]");
        }
        byte[] bArr = this.info;
        int i2 = this.infoOffset;
        int i3 = i << 4;
        bArr[i2 + 60] = (byte) (i3 | (bArr[i2 + 60] & 207));
    }

    public boolean isSkipWorkTree() {
        return (getExtendedFlags() & 1073741824) != 0;
    }

    public boolean isIntentToAdd() {
        return (getExtendedFlags() & INTENT_TO_ADD) != 0;
    }

    public boolean isMerged() {
        return getStage() == 0;
    }

    public int getRawMode() {
        return NB.decodeInt32(this.info, this.infoOffset + 24);
    }

    public FileMode getFileMode() {
        return FileMode.fromBits(getRawMode());
    }

    public void setFileMode(FileMode fileMode) {
        int bits = fileMode.getBits() & FileMode.TYPE_MASK;
        if (bits == 0 || bits == 16384) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.get().invalidModeForPath, fileMode, getPathString()));
        }
        NB.encodeInt32(this.info, this.infoOffset + 24, fileMode.getBits());
    }

    void setFileMode(int i) {
        NB.encodeInt32(this.info, this.infoOffset + 24, i);
    }

    public long getCreationTime() {
        return decodeTS(0);
    }

    public void setCreationTime(long j) {
        encodeTS(0, j);
    }

    public Instant getLastModifiedInstant() {
        return decodeTSInstant(8);
    }

    public void setLastModified(Instant instant) {
        encodeTS(8, instant);
    }

    public int getLength() {
        return NB.decodeInt32(this.info, this.infoOffset + 36);
    }

    public void setLength(int i) {
        NB.encodeInt32(this.info, this.infoOffset + 36, i);
    }

    public void setLength(long j) {
        setLength((int) j);
    }

    public ObjectId getObjectId() {
        return ObjectId.fromRaw(idBuffer(), idOffset());
    }

    public void setObjectId(AnyObjectId anyObjectId) {
        anyObjectId.copyRawTo(idBuffer(), idOffset());
    }

    public void setObjectIdFromRaw(byte[] bArr, int i) {
        System.arraycopy(bArr, i, idBuffer(), idOffset(), 20);
    }

    public String getPathString() {
        return toString(this.path);
    }

    public byte[] getRawPath() {
        return (byte[]) this.path.clone();
    }

    public String toString() {
        return String.valueOf(getFileMode()) + " " + getLength() + " " + String.valueOf(getLastModifiedInstant()) + " " + String.valueOf(getObjectId()) + " " + getStage() + " " + getPathString() + "\n";
    }

    public void copyMetaData(DirCacheEntry dirCacheEntry) {
        copyMetaData(dirCacheEntry, false);
    }

    void copyMetaData(DirCacheEntry dirCacheEntry, boolean z) {
        int iDecodeUInt16 = NB.decodeUInt16(this.info, this.infoOffset + 60);
        int iDecodeUInt17 = NB.decodeUInt16(dirCacheEntry.info, dirCacheEntry.infoOffset + 60);
        System.arraycopy(dirCacheEntry.info, dirCacheEntry.infoOffset, this.info, this.infoOffset, 62);
        NB.encodeInt16(this.info, this.infoOffset + 60, (iDecodeUInt16 & NAME_MASK) | (z ? iDecodeUInt16 & 12288 : iDecodeUInt17 & 12288) | (iDecodeUInt17 & (-16384)));
    }

    boolean isExtended() {
        return (this.info[this.infoOffset + 60] & SignedBytes.MAX_POWER_OF_TWO) != 0;
    }

    private long decodeTS(int i) {
        int i2 = this.infoOffset + i;
        return (((long) NB.decodeInt32(this.info, i2)) * 1000) + ((long) (NB.decodeInt32(this.info, i2 + 4) / DurationKt.NANOS_IN_MILLIS));
    }

    private Instant decodeTSInstant(int i) {
        int i2 = this.infoOffset + i;
        return Instant.ofEpochSecond(NB.decodeInt32(this.info, i2), NB.decodeInt32(this.info, i2 + 4));
    }

    private void encodeTS(int i, long j) {
        int i2 = this.infoOffset + i;
        NB.encodeInt32(this.info, i2, (int) (j / 1000));
        NB.encodeInt32(this.info, i2 + 4, ((int) (j % 1000)) * DurationKt.NANOS_IN_MILLIS);
    }

    private void encodeTS(int i, Instant instant) {
        int i2 = this.infoOffset + i;
        NB.encodeInt32(this.info, i2, (int) instant.getEpochSecond());
        NB.encodeInt32(this.info, i2 + 4, instant.getNano());
    }

    private int getExtendedFlags() {
        if (isExtended()) {
            return NB.decodeUInt16(this.info, this.infoOffset + 62) << 16;
        }
        return 0;
    }

    private static void checkPath(byte[] bArr) {
        try {
            SystemReader.getInstance().checkPath(bArr);
        } catch (CorruptObjectException e) {
            InvalidPathException invalidPathException = new InvalidPathException(toString(bArr));
            invalidPathException.initCause(e);
            throw invalidPathException;
        }
    }

    static String toString(byte[] bArr) {
        return StandardCharsets.UTF_8.decode(ByteBuffer.wrap(bArr)).toString();
    }
}
