package org.eclipse.jgit.internal.storage.file;

import com.google.common.base.Ascii;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.AccessDeniedException;
import java.nio.file.NoSuchFileException;
import java.text.MessageFormat;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.errors.CorruptObjectException;
import org.eclipse.jgit.errors.LargeObjectException;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.errors.NoPackSignatureException;
import org.eclipse.jgit.errors.PackInvalidException;
import org.eclipse.jgit.errors.PackMismatchException;
import org.eclipse.jgit.errors.StoredObjectRepresentationNotAvailableException;
import org.eclipse.jgit.errors.UnpackException;
import org.eclipse.jgit.errors.UnsupportedPackIndexVersionException;
import org.eclipse.jgit.errors.UnsupportedPackVersionException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.storage.pack.BinaryDelta;
import org.eclipse.jgit.internal.storage.pack.PackExt;
import org.eclipse.jgit.internal.storage.pack.PackOutputStream;
import org.eclipse.jgit.internal.util.Optionally;
import org.eclipse.jgit.lib.AbbreviatedObjectId;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectLoader;
import org.eclipse.jgit.util.FileUtils;
import org.eclipse.jgit.util.Hex;
import org.eclipse.jgit.util.LongList;
import org.eclipse.jgit.util.NB;
import org.eclipse.jgit.util.RawParseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public class Pack implements Iterable<PackIndex.MutableEntry> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Logger LOG = LoggerFactory.getLogger((Class<?>) Pack.class);
    public static final Comparator<Pack> SORT = new Pack$$ExternalSyntheticLambda1();
    private int activeCopyRawData;
    private int activeWindows;

    @Nullable
    private PackFile bitmapIdxFile;
    private volatile LongList corruptObjects;
    private RandomAccessFile fd;
    private PackFileSnapshot fileSnapshot;
    final int hash;
    private volatile boolean invalid;
    private volatile Exception invalidatingCause;
    private PackFile keepFile;
    long length;
    private byte[] packChecksum;
    private final PackFile packFile;
    Instant packLastModified;
    private boolean useStrongRefs;
    private final Object readLock = new Object();
    private AtomicInteger transientErrorCount = new AtomicInteger();
    private volatile Optionally<PackIndex> loadedIdx = Optionally.empty();
    private Optionally<PackReverseIndex> reverseIdx = Optionally.empty();
    private Optionally<PackBitmapIndex> bitmapIdx = Optionally.empty();

    public Pack(Config config, File file, @Nullable PackFile packFile) {
        this.useStrongRefs = config.getBoolean(ConfigConstants.CONFIG_CORE_SECTION, ConfigConstants.CONFIG_KEY_PACKED_INDEX_GIT_USE_STRONGREFS, WindowCache.getInstance().isPackedIndexGitUseStrongRefs());
        this.packFile = new PackFile(file);
        PackFileSnapshot packFileSnapshotSave = PackFileSnapshot.save(file);
        this.fileSnapshot = packFileSnapshotSave;
        this.packLastModified = packFileSnapshotSave.lastModifiedInstant();
        this.bitmapIdxFile = packFile;
        this.hash = System.identityHashCode(this) * 31;
        this.length = Long.MAX_VALUE;
    }

    private PackIndex idx() throws IOException {
        Optional<PackIndex> optional = this.loadedIdx.getOptional();
        if (optional.isPresent()) {
            return optional.get();
        }
        synchronized (this) {
            Optional<PackIndex> optional2 = this.loadedIdx.getOptional();
            if (optional2.isPresent()) {
                return optional2.get();
            }
            if (this.invalid) {
                throw new PackInvalidException(this.packFile, this.invalidatingCause);
            }
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                PackFile packFileCreate = this.packFile.create(PackExt.INDEX);
                PackIndex packIndexOpen = PackIndex.open(packFileCreate);
                Logger logger = LOG;
                if (logger.isDebugEnabled()) {
                    logger.debug(String.format("Opening pack index %s, size %.3f MB took %d ms", packFileCreate.getAbsolutePath(), Float.valueOf(packFileCreate.length() / 1048576.0f), Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis)));
                }
                byte[] bArr = this.packChecksum;
                if (bArr == null) {
                    byte[] checksum = packIndexOpen.getChecksum();
                    this.packChecksum = checksum;
                    this.fileSnapshot.setChecksum(ObjectId.fromRaw(checksum));
                } else if (!Arrays.equals(bArr, packIndexOpen.getChecksum())) {
                    throw new PackMismatchException(MessageFormat.format(JGitText.get().packChecksumMismatch, this.packFile.getPath(), PackExt.PACK.getExtension(), Hex.toHexString(this.packChecksum), PackExt.INDEX.getExtension(), Hex.toHexString(packIndexOpen.getChecksum())));
                }
                this.loadedIdx = optionally(packIndexOpen);
                return packIndexOpen;
            } catch (InterruptedIOException e) {
                throw e;
            } catch (IOException e2) {
                this.invalid = true;
                this.invalidatingCause = e2;
                throw e2;
            }
        }
    }

    public PackFile getPackFile() {
        return this.packFile;
    }

    /* JADX INFO: renamed from: getIndex, reason: merged with bridge method [inline-methods] */
    public PackIndex m5707lambda$1$orgeclipsejgitinternalstoragefilePack() throws IOException {
        return idx();
    }

    public String getPackName() {
        return this.packFile.getId();
    }

    public boolean hasObject(AnyObjectId anyObjectId) throws IOException {
        long jFindOffset = idx().findOffset(anyObjectId);
        return 0 < jFindOffset && !isCorrupt(jFindOffset);
    }

    public boolean shouldBeKept() {
        if (this.keepFile == null) {
            this.keepFile = this.packFile.create(PackExt.KEEP);
        }
        return this.keepFile.exists();
    }

    ObjectLoader get(WindowCursor windowCursor, AnyObjectId anyObjectId) throws IOException {
        long jFindOffset = idx().findOffset(anyObjectId);
        if (0 >= jFindOffset || isCorrupt(jFindOffset)) {
            return null;
        }
        return load(windowCursor, jFindOffset);
    }

    void resolve(Set<ObjectId> set, AbbreviatedObjectId abbreviatedObjectId, int i) throws IOException {
        idx().resolve(set, abbreviatedObjectId, i);
    }

    public void close() {
        WindowCache.purge(this);
        synchronized (this) {
            this.loadedIdx.clear();
            this.reverseIdx.clear();
            this.bitmapIdx.clear();
        }
    }

    @Override // java.lang.Iterable
    public Iterator<PackIndex.MutableEntry> iterator() {
        try {
            return idx().iterator();
        } catch (IOException unused) {
            return Collections.emptyList().iterator();
        }
    }

    long getObjectCount() throws IOException {
        return idx().getObjectCount();
    }

    ObjectId findObjectForOffset(long j) throws IOException {
        return getReverseIdx().findObject(j);
    }

    PackFileSnapshot getFileSnapshot() {
        return this.fileSnapshot;
    }

    AnyObjectId getPackChecksum() {
        return ObjectId.fromRaw(this.packChecksum);
    }

    private final byte[] decompress(long j, int i, WindowCursor windowCursor) throws DataFormatException, IOException {
        try {
            byte[] bArr = new byte[i];
            if (windowCursor.inflate(this, j, bArr, false) == i) {
                return bArr;
            }
            throw new EOFException(MessageFormat.format(JGitText.get().shortCompressedStreamAt, Long.valueOf(j)));
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    void copyPackAsIs(PackOutputStream packOutputStream, WindowCursor windowCursor) throws IOException {
        windowCursor.pin(this, 0L);
        windowCursor.copyPackAsIs(this, this.length, packOutputStream);
    }

    final void copyAsIs(PackOutputStream packOutputStream, LocalObjectToPack localObjectToPack, boolean z, WindowCursor windowCursor) throws StoredObjectRepresentationNotAvailableException, IOException {
        beginCopyAsIs();
        try {
            copyAsIs2(packOutputStream, localObjectToPack, z, windowCursor);
        } finally {
            endCopyAsIs();
        }
    }

    /* JADX WARN: Code duplicated, block: B:151:0x02e7  */
    /* JADX WARN: Code duplicated, block: B:153:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:169:0x013b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:0x012f  */
    /* JADX WARN: Code duplicated, block: B:68:0x0145  */
    /* JADX WARN: Code duplicated, block: B:72:0x0155  */
    /* JADX WARN: Code duplicated, block: B:82:0x0197 A[Catch: IOException -> 0x0052, DataFormatException -> 0x01d1, TRY_ENTER, TryCatch #2 {IOException -> 0x0052, blocks: (B:19:0x003f, B:22:0x0047, B:91:0x01e2, B:66:0x013b, B:82:0x0197, B:83:0x01bc, B:29:0x005b, B:30:0x0061, B:32:0x0073, B:33:0x007b, B:36:0x0082), top: B:155:0x003b }] */
    /* JADX WARN: Code duplicated, block: B:88:0x01d6  */
    private void copyAsIs2(PackOutputStream packOutputStream, LocalObjectToPack localObjectToPack, boolean z, WindowCursor windowCursor) throws StoredObjectRepresentationNotAvailableException, IOException {
        byte[] bArr;
        int i;
        int i2;
        long jFindCRC32;
        long j;
        long j2;
        byte[] bArr2;
        ByteArrayWindow byteArrayWindow;
        long j3;
        long j4;
        Pack pack;
        Inflater inflater;
        byte[] bArr3;
        byte[] bArr4;
        long j5;
        long j6;
        byte[] bArr5;
        Inflater inflater2;
        int i3;
        CRC32 crc32 = z ? new CRC32() : null;
        CRC32 crc33 = z ? new CRC32() : null;
        byte[] copyBuffer = packOutputStream.getCopyBuffer();
        int i4 = 0;
        try {
            try {
                readFully(localObjectToPack.offset, copyBuffer, 0, 20, windowCursor);
                byte b = copyBuffer[0];
                int i5 = b & 255;
                int i6 = 7;
                int i7 = (i5 >> 4) & 7;
                long j7 = b & Ascii.SI;
                int i8 = 4;
                long j8 = j7;
                int i9 = 1;
                while ((i5 & 128) != 0) {
                    try {
                        long j9 = j8;
                        i2 = i4;
                        int i10 = i9 + 1;
                        byte b2 = copyBuffer[i9];
                        int i11 = b2 & 255;
                        int i12 = i6;
                        long j10 = (((long) (b2 & 127)) << i8) + j9;
                        i8 += i12;
                        i9 = i10;
                        i5 = i11;
                        i4 = i2;
                        i6 = i12;
                        j8 = j10;
                        copyBuffer = copyBuffer;
                    } catch (IOException e) {
                        e = e;
                        i4 = i2;
                    }
                }
                try {
                    if (i7 == 6) {
                        while (true) {
                            i3 = i9 + 1;
                            if ((copyBuffer[i9] & 128) == 0) {
                                break;
                            } else {
                                i9 = i3;
                            }
                        }
                        if (z) {
                            crc32.update(copyBuffer, i4, i3);
                            crc33.update(copyBuffer, i4, i3);
                        }
                        i = i3;
                        bArr = copyBuffer;
                    } else if (i7 == i6) {
                        if (z) {
                            crc32.update(copyBuffer, i4, i9);
                            crc33.update(copyBuffer, i4, i9);
                        }
                        int i13 = i9;
                        readFully(((long) i9) + localObjectToPack.offset, copyBuffer, 0, 20, windowCursor);
                        bArr = copyBuffer;
                        if (z) {
                            crc32.update(bArr, i4, 20);
                            crc33.update(bArr, i4, 20);
                        }
                        i = i13 + 20;
                    } else {
                        bArr = copyBuffer;
                        int i14 = i9;
                        if (z) {
                            crc32.update(bArr, i4, i14);
                            crc33.update(bArr, i4, i14);
                        }
                        i = i14;
                    }
                    long j11 = ((long) i) + localObjectToPack.offset;
                    long j12 = localObjectToPack.length;
                    Pack pack2 = this;
                    try {
                        ByteArrayWindow byteArrayWindowQuickCopy = windowCursor.quickCopy(pack2, j11, j12);
                        Pack pack3 = pack2;
                        long j13 = j11;
                        try {
                            if (z) {
                                try {
                                    if (pack3.idx().hasCRC32Support()) {
                                        jFindCRC32 = pack3.idx().findCRC32(localObjectToPack);
                                        if (byteArrayWindowQuickCopy != null) {
                                            byteArrayWindowQuickCopy.crc32(crc32, j13, (int) j12);
                                            j = j12;
                                        } else {
                                            j = j12;
                                            long j14 = j13;
                                            long j15 = j;
                                            while (j15 > 0) {
                                                long j16 = j13;
                                                int iMin = (int) Math.min(j15, bArr.length);
                                                Pack pack4 = pack3;
                                                byte[] bArr6 = bArr;
                                                long j17 = j;
                                                long j18 = jFindCRC32;
                                                ByteArrayWindow byteArrayWindow2 = byteArrayWindowQuickCopy;
                                                pack4.readFully(j14, bArr6, 0, iMin, windowCursor);
                                                crc32.update(bArr6, i4, iMin);
                                                long j19 = iMin;
                                                j14 += j19;
                                                j15 -= j19;
                                                bArr = bArr6;
                                                byteArrayWindowQuickCopy = byteArrayWindow2;
                                                jFindCRC32 = j18;
                                                pack3 = pack4;
                                                j13 = j16;
                                                j = j17;
                                            }
                                        }
                                        if (crc32.getValue() != jFindCRC32) {
                                            pack3.setCorrupt(localObjectToPack.offset);
                                            throw new CorruptObjectException(MessageFormat.format(JGitText.get().objectAtHasBadZlibStream, Long.valueOf(localObjectToPack.offset), pack3.getPackFile()));
                                        }
                                        j2 = j13;
                                        bArr2 = bArr;
                                        byteArrayWindow = byteArrayWindowQuickCopy;
                                        j3 = j;
                                        if (i4 == 0) {
                                            throw new StoredObjectRepresentationNotAvailableException(e);
                                        }
                                        throw e;
                                    }
                                    j4 = j13;
                                    pack = pack3;
                                    bArr2 = bArr;
                                    byteArrayWindow = byteArrayWindowQuickCopy;
                                    j8 = j8;
                                    if (z) {
                                        try {
                                            inflater = windowCursor.inflater();
                                            bArr3 = new byte[1024];
                                            if (byteArrayWindow != null) {
                                                j3 = j12;
                                                byteArrayWindow.check(inflater, bArr3, j4, (int) j3);
                                            } else {
                                                bArr4 = bArr3;
                                                j3 = j12;
                                                j5 = j3;
                                                j6 = j4;
                                                while (j5 > 0) {
                                                    int iMin2 = (int) Math.min(j5, bArr2.length);
                                                    long j20 = j5;
                                                    bArr5 = bArr4;
                                                    long j21 = j4;
                                                    inflater2 = inflater;
                                                    readFully(j6, bArr2, 0, iMin2, windowCursor);
                                                    crc32.update(bArr2, i4, iMin2);
                                                    inflater2.setInput(bArr2, i4, iMin2);
                                                    do {
                                                    } while (inflater2.inflate(bArr5, i4, 1024) > 0);
                                                    long j22 = iMin2;
                                                    j6 += j22;
                                                    inflater = inflater2;
                                                    bArr4 = bArr5;
                                                    j5 = j20 - j22;
                                                    j4 = j21;
                                                    pack = this;
                                                }
                                            }
                                            if (inflater.finished() || inflater.getBytesRead() != j3) {
                                                pack.setCorrupt(localObjectToPack.offset);
                                                throw new EOFException(MessageFormat.format(JGitText.get().shortCompressedStreamAt, Long.valueOf(localObjectToPack.offset)));
                                            }
                                            jFindCRC32 = crc32.getValue();
                                            j2 = j4;
                                        } catch (DataFormatException e2) {
                                            e = e2;
                                            pack2 = this;
                                            i2 = i4;
                                            pack2.setCorrupt(localObjectToPack.offset);
                                            throw new StoredObjectRepresentationNotAvailableException(new CorruptObjectException(MessageFormat.format(JGitText.get().objectAtHasBadZlibStream, Long.valueOf(localObjectToPack.offset), pack2.getPackFile()), e));
                                        }
                                    } else {
                                        byteArrayWindow = byteArrayWindow;
                                        j2 = j4;
                                        j3 = j12;
                                        jFindCRC32 = -1;
                                    }
                                } catch (IOException e3) {
                                    e = e3;
                                } catch (DataFormatException e4) {
                                    e = e4;
                                    pack2 = pack3;
                                    i2 = i4;
                                    pack2.setCorrupt(localObjectToPack.offset);
                                    throw new StoredObjectRepresentationNotAvailableException(new CorruptObjectException(MessageFormat.format(JGitText.get().objectAtHasBadZlibStream, Long.valueOf(localObjectToPack.offset), pack2.getPackFile()), e));
                                }
                            } else {
                                j4 = j13;
                                pack = pack3;
                                bArr2 = bArr;
                                byteArrayWindow = byteArrayWindowQuickCopy;
                                j8 = j8;
                                if (z) {
                                    inflater = windowCursor.inflater();
                                    bArr3 = new byte[1024];
                                    if (byteArrayWindow != null) {
                                        j3 = j12;
                                        byteArrayWindow.check(inflater, bArr3, j4, (int) j3);
                                    } else {
                                        bArr4 = bArr3;
                                        j3 = j12;
                                        j5 = j3;
                                        j6 = j4;
                                        while (j5 > 0) {
                                            int iMin3 = (int) Math.min(j5, bArr2.length);
                                            long j23 = j5;
                                            bArr5 = bArr4;
                                            long j24 = j4;
                                            inflater2 = inflater;
                                            readFully(j6, bArr2, 0, iMin3, windowCursor);
                                            crc32.update(bArr2, i4, iMin3);
                                            inflater2.setInput(bArr2, i4, iMin3);
                                            do {
                                            } while (inflater2.inflate(bArr5, i4, 1024) > 0);
                                            long j25 = iMin3;
                                            j6 += j25;
                                            inflater = inflater2;
                                            bArr4 = bArr5;
                                            j5 = j23 - j25;
                                            j4 = j24;
                                            pack = this;
                                        }
                                    }
                                    if (inflater.finished()) {
                                    }
                                    pack.setCorrupt(localObjectToPack.offset);
                                    throw new EOFException(MessageFormat.format(JGitText.get().shortCompressedStreamAt, Long.valueOf(localObjectToPack.offset)));
                                }
                                byteArrayWindow = byteArrayWindow;
                                j2 = j4;
                                j3 = j12;
                                jFindCRC32 = -1;
                            }
                            try {
                                if (byteArrayWindow != null) {
                                    packOutputStream.writeHeader(localObjectToPack, j8);
                                    byteArrayWindow.write(packOutputStream, j2, (int) j3);
                                    return;
                                }
                                long j26 = j8;
                                long j27 = j2;
                                if (j3 <= bArr2.length) {
                                    if (!z) {
                                        long j28 = j3;
                                        while (j28 > 0) {
                                            try {
                                                int iMin4 = (int) Math.min(j28, bArr2.length);
                                                long j29 = j26;
                                                readFully(j27, bArr2, 0, iMin4, windowCursor);
                                                long j30 = iMin4;
                                                j27 += j30;
                                                j28 -= j30;
                                                j26 = j29;
                                                j3 = j3;
                                            } catch (IOException e5) {
                                                e = e5;
                                                i4 = 0;
                                                if (i4 == 0) {
                                                    throw new StoredObjectRepresentationNotAvailableException(e);
                                                }
                                                throw e;
                                            }
                                        }
                                    }
                                    long j31 = j3;
                                    packOutputStream.writeHeader(localObjectToPack, j26);
                                    packOutputStream.write(bArr2, 0, (int) j31);
                                    return;
                                }
                                long j32 = j3;
                                int i15 = 0;
                                while (j32 > 0) {
                                    try {
                                        int iMin5 = (int) Math.min(j32, bArr2.length);
                                        long j33 = j32;
                                        try {
                                            readFully(j27, bArr2, 0, iMin5, windowCursor);
                                            if (z) {
                                                crc33.update(bArr2, 0, iMin5);
                                            }
                                            if (i15 == 0) {
                                                packOutputStream.writeHeader(localObjectToPack, j26);
                                                i15 = 1;
                                            }
                                            packOutputStream.write(bArr2, 0, iMin5);
                                            long j34 = iMin5;
                                            j27 += j34;
                                            j32 = j33 - j34;
                                        } catch (IOException e6) {
                                            e = e6;
                                            i4 = i15;
                                            if (i4 == 0) {
                                                throw new StoredObjectRepresentationNotAvailableException(e);
                                            }
                                            throw e;
                                        }
                                    } catch (IOException e7) {
                                        e = e7;
                                    }
                                }
                                if (z && crc33.getValue() != jFindCRC32) {
                                    throw new CorruptObjectException(MessageFormat.format(JGitText.get().objectAtHasBadZlibStream, Long.valueOf(localObjectToPack.offset), getPackFile()));
                                }
                            } catch (IOException e8) {
                                e = e8;
                                i4 = 1;
                            }
                        } catch (IOException e9) {
                            e = e9;
                        }
                    } catch (DataFormatException e10) {
                        e = e10;
                    }
                } catch (IOException e11) {
                    e = e11;
                }
            } catch (IOException e12) {
                e = e12;
            }
        } catch (IOException e13) {
            e = e13;
        }
    }

    boolean invalid() {
        return this.invalid;
    }

    void setInvalid() {
        this.invalid = true;
    }

    int incrementTransientErrorCount() {
        return this.transientErrorCount.incrementAndGet();
    }

    void resetTransientErrorCount() {
        this.transientErrorCount.set(0);
    }

    private void readFully(long j, byte[] bArr, int i, int i2, WindowCursor windowCursor) throws IOException {
        if (windowCursor.copy(this, j, bArr, i, i2) != i2) {
            throw new EOFException();
        }
    }

    private synchronized void beginCopyAsIs() throws StoredObjectRepresentationNotAvailableException {
        int i = this.activeCopyRawData + 1;
        this.activeCopyRawData = i;
        if (i == 1 && this.activeWindows == 0) {
            try {
                doOpen();
            } catch (IOException e) {
                throw new StoredObjectRepresentationNotAvailableException(e);
            }
        }
    }

    private synchronized void endCopyAsIs() {
        int i = this.activeCopyRawData - 1;
        this.activeCopyRawData = i;
        if (i == 0 && this.activeWindows == 0) {
            doClose();
        }
    }

    synchronized boolean beginWindowCache() throws IOException {
        int i = this.activeWindows + 1;
        this.activeWindows = i;
        if (i != 1) {
            return false;
        }
        if (this.activeCopyRawData == 0) {
            doOpen();
        }
        return true;
    }

    synchronized boolean endWindowCache() {
        boolean z;
        z = true;
        int i = this.activeWindows - 1;
        this.activeWindows = i;
        if (i != 0) {
            z = false;
        }
        if (z && this.activeCopyRawData == 0) {
            doClose();
        }
        return z;
    }

    private void doOpen() throws Exception {
        if (this.invalid) {
            openFail(true, this.invalidatingCause);
            throw new PackInvalidException(this.packFile, this.invalidatingCause);
        }
        try {
            synchronized (this.readLock) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(this.packFile, "r");
                this.fd = randomAccessFile;
                this.length = randomAccessFile.length();
                onOpenPack();
            }
        } catch (EOFException e) {
            e = e;
            openFail(true, e);
            throw e;
        } catch (FileNotFoundException e2) {
            openFail(true ^ this.packFile.exists(), e2);
            throw e2;
        } catch (InterruptedIOException e3) {
            openFail(false, e3);
            throw e3;
        } catch (RuntimeException e4) {
            openFail(false, e4);
            throw e4;
        } catch (AccessDeniedException e5) {
            e = e5;
            openFail(true, e);
            throw e;
        } catch (NoSuchFileException e6) {
            e = e6;
            openFail(true, e);
            throw e;
        } catch (CorruptObjectException e7) {
            e = e7;
            openFail(true, e);
            throw e;
        } catch (NoPackSignatureException e8) {
            e = e8;
            openFail(true, e);
            throw e;
        } catch (PackMismatchException e9) {
            e = e9;
            openFail(true, e);
            throw e;
        } catch (UnpackException e10) {
            e = e10;
            openFail(true, e);
            throw e;
        } catch (UnsupportedPackIndexVersionException e11) {
            e = e11;
            openFail(true, e);
            throw e;
        } catch (UnsupportedPackVersionException e12) {
            e = e12;
            openFail(true, e);
            throw e;
        } catch (IOException e13) {
            openFail(FileUtils.isStaleFileHandleInCausalChain(e13), e13);
            throw e13;
        }
    }

    private void openFail(boolean z, Exception exc) {
        this.activeWindows = 0;
        this.activeCopyRawData = 0;
        this.invalid = z;
        this.invalidatingCause = exc;
        doClose();
    }

    private void doClose() {
        synchronized (this.readLock) {
            RandomAccessFile randomAccessFile = this.fd;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException unused) {
                }
                this.fd = null;
            }
        }
    }

    ByteArrayWindow read(long j, int i) throws IOException {
        RandomAccessFile randomAccessFile;
        ByteArrayWindow byteArrayWindow;
        synchronized (this.readLock) {
            if (this.invalid || (randomAccessFile = this.fd) == null) {
                throw new PackInvalidException(this.packFile, this.invalidatingCause);
            }
            long j2 = this.length;
            if (j2 < ((long) i) + j) {
                i = (int) (j2 - j);
            }
            byte[] bArr = new byte[i];
            randomAccessFile.seek(j);
            this.fd.readFully(bArr, 0, i);
            byteArrayWindow = new ByteArrayWindow(this, j, bArr);
        }
        return byteArrayWindow;
    }

    ByteWindow mmap(long j, int i) throws IOException {
        long j2;
        MappedByteBuffer map;
        synchronized (this.readLock) {
            long j3 = this.length;
            if (j3 < ((long) i) + j) {
                i = (int) (j3 - j);
            }
            try {
                j2 = j;
                try {
                    map = this.fd.getChannel().map(FileChannel.MapMode.READ_ONLY, j2, i);
                } catch (IOException unused) {
                    System.gc();
                    System.runFinalization();
                    map = this.fd.getChannel().map(FileChannel.MapMode.READ_ONLY, j2, i);
                }
            } catch (IOException unused2) {
                j2 = j;
            }
            if (map.hasArray()) {
                return new ByteArrayWindow(this, j2, map.array());
            }
            return new ByteBufferWindow(this, j2, map);
        }
    }

    private void onOpenPack() throws IOException {
        PackIndex packIndexIdx = idx();
        byte[] bArr = new byte[20];
        this.fd.seek(0L);
        this.fd.readFully(bArr, 0, 12);
        if (RawParseUtils.match(bArr, 0, Constants.PACK_SIGNATURE) != 4) {
            throw new NoPackSignatureException(JGitText.get().notAPACKFile);
        }
        long jDecodeUInt32 = NB.decodeUInt32(bArr, 4);
        long jDecodeUInt33 = NB.decodeUInt32(bArr, 8);
        if (jDecodeUInt32 != 2 && jDecodeUInt32 != 3) {
            throw new UnsupportedPackVersionException(jDecodeUInt32);
        }
        if (jDecodeUInt33 != packIndexIdx.getObjectCount()) {
            throw new PackMismatchException(MessageFormat.format(JGitText.get().packObjectCountMismatch, Long.valueOf(jDecodeUInt33), Long.valueOf(packIndexIdx.getObjectCount()), getPackFile()));
        }
        this.fd.seek(this.length - 20);
        this.fd.readFully(bArr, 0, 20);
        if (!Arrays.equals(bArr, this.packChecksum)) {
            throw new PackMismatchException(MessageFormat.format(JGitText.get().packChecksumMismatch, getPackFile(), PackExt.PACK.getExtension(), Hex.toHexString(bArr), PackExt.INDEX.getExtension(), Hex.toHexString(packIndexIdx.getChecksum())));
        }
    }

    ObjectLoader load(WindowCursor windowCursor, long j) throws LargeObjectException, IOException {
        long j2;
        Delta delta;
        Pack pack;
        WindowCursor windowCursor2;
        int i;
        boolean z;
        WindowCursor windowCursor3;
        int i2;
        byte[] bArr;
        WindowCursor windowCursor4 = windowCursor;
        try {
            byte[] bArr2 = windowCursor4.tempId;
            byte[] bArrDecompress = null;
            long j3 = j;
            Delta delta2 = null;
            while (true) {
                try {
                    readFully(j3, bArr2, 0, 20, windowCursor4);
                    long j4 = j3;
                    try {
                        byte b = bArr2[0];
                        int i3 = b & 255;
                        int i4 = 7;
                        int i5 = (i3 >> 4) & 7;
                        int i6 = 1;
                        long j5 = b & Ascii.SI;
                        int i7 = 1;
                        int i8 = 4;
                        while ((i3 & 128) != 0) {
                            long j6 = j4;
                            Delta delta3 = delta2;
                            int i9 = i5;
                            int i10 = i4;
                            int i11 = i7;
                            i7 = i11 + 1;
                            byte b2 = bArr2[i11];
                            int i12 = b2 & 255;
                            j5 += ((long) (b2 & 127)) << i8;
                            i8 += 7;
                            delta2 = delta3;
                            j4 = j6;
                            i5 = i9;
                            i3 = i12;
                            i4 = i10;
                            i6 = 1;
                        }
                        if (i5 == i6 || i5 == 2 || i5 == 3 || i5 == 4) {
                            long j7 = j4;
                            delta = delta2;
                            pack = this;
                            windowCursor2 = windowCursor;
                            long j8 = j5;
                            bArrDecompress = (delta != null || j8 < ((long) windowCursor2.getStreamFileThreshold())) ? pack.decompress(((long) i7) + j7, (int) j8, windowCursor2) : null;
                            if (delta != null) {
                                i = i5;
                                z = false;
                                break;
                            }
                            if (bArrDecompress != null) {
                                return new ObjectLoader.SmallObject(i5, bArrDecompress);
                            }
                            try {
                                return new LargePackedWholeObject(i5, j8, j7, i7, pack, windowCursor2.db);
                            } catch (DataFormatException e) {
                                e = e;
                                j2 = j7;
                                throw new CorruptObjectException(MessageFormat.format(JGitText.get().objectAtHasBadZlibStream, Long.valueOf(j2), getPackFile()), e);
                            }
                        }
                        if (i5 == 6) {
                            pack = this;
                            windowCursor2 = windowCursor;
                            Delta delta4 = delta2;
                            long j9 = j5;
                            int i13 = i7 + 1;
                            byte b3 = bArr2[i7];
                            int i14 = b3 & 255;
                            long j10 = b3 & 127;
                            while ((i14 & 128) != 0) {
                                long j11 = j4;
                                int i15 = i13;
                                Delta delta5 = delta4;
                                i13 = i15 + 1;
                                byte b4 = bArr2[i15];
                                int i16 = b4 & 255;
                                j10 = ((j10 + 1) << i4) + ((long) (b4 & 127));
                                delta4 = delta5;
                                i4 = i4;
                                i14 = i16;
                                j4 = j11;
                            }
                            long j12 = j4 - j10;
                            j2 = j4;
                            try {
                                Delta delta6 = new Delta(delta4, j2, (int) j9, i13, j12);
                                if (j9 != delta6.deltaSize) {
                                    delta = delta6;
                                    i = -1;
                                    z = false;
                                    break;
                                }
                                DeltaBaseCache.Entry entry = windowCursor2.getDeltaBaseCache().get(pack, j12);
                                if (entry != null) {
                                    i2 = entry.type;
                                    bArr = entry.data;
                                    delta = delta6;
                                    z = true;
                                    i = i2;
                                    bArrDecompress = bArr;
                                    break;
                                }
                                windowCursor4 = windowCursor2;
                                delta2 = delta6;
                                j3 = j12;
                            } catch (DataFormatException e2) {
                                e = e2;
                                throw new CorruptObjectException(MessageFormat.format(JGitText.get().objectAtHasBadZlibStream, Long.valueOf(j2), getPackFile()), e);
                            }
                        } else if (i5 == i4) {
                            pack = this;
                            pack.readFully(j4 + ((long) i7), bArr2, 0, 20, windowCursor);
                            windowCursor2 = windowCursor;
                            long jFindDeltaBase = pack.findDeltaBase(ObjectId.fromRaw(bArr2));
                            j2 = j4;
                            long j13 = j5;
                            try {
                                Delta delta7 = new Delta(delta2, j2, (int) j5, i7 + 20, jFindDeltaBase);
                                if (j13 != delta7.deltaSize) {
                                    z = false;
                                    delta = delta7;
                                    i = -1;
                                    break;
                                }
                                DeltaBaseCache.Entry entry2 = windowCursor2.getDeltaBaseCache().get(pack, jFindDeltaBase);
                                if (entry2 != null) {
                                    i2 = entry2.type;
                                    bArr = entry2.data;
                                    z = true;
                                    delta = delta7;
                                    i = i2;
                                    bArrDecompress = bArr;
                                    break;
                                }
                                windowCursor4 = windowCursor2;
                                j3 = jFindDeltaBase;
                                delta2 = delta7;
                            } catch (DataFormatException e3) {
                                e = e3;
                                throw new CorruptObjectException(MessageFormat.format(JGitText.get().objectAtHasBadZlibStream, Long.valueOf(j2), getPackFile()), e);
                            }
                        } else {
                            throw new IOException(MessageFormat.format(JGitText.get().unknownObjectType, Integer.valueOf(i5)));
                        }
                    } catch (DataFormatException e4) {
                        e = e4;
                        j2 = j4;
                    }
                } catch (DataFormatException e5) {
                    e = e5;
                    j2 = j3;
                }
            }
            if (bArrDecompress == null) {
                throw new IOException(JGitText.get().inMemoryBufferLimitExceeded);
            }
            byte[] bArr3 = bArrDecompress;
            while (true) {
                if (z) {
                    windowCursor3 = windowCursor2;
                    z = false;
                } else if (delta.next == null) {
                    windowCursor3 = windowCursor;
                    windowCursor2.getDeltaBaseCache().store(pack, delta.basePos, bArr3, i);
                } else {
                    windowCursor3 = windowCursor2;
                }
                j2 = delta.deltaPos;
                byte[] bArrDecompress2 = pack.decompress(((long) delta.hdrLen) + j2, delta.deltaSize, windowCursor3);
                if (bArrDecompress2 == null) {
                    throw new LargeObjectException.OutOfMemory(new OutOfMemoryError());
                }
                long resultSize = BinaryDelta.getResultSize(bArrDecompress2);
                if (2147483647L <= resultSize) {
                    throw new LargeObjectException.ExceedsByteArrayLimit();
                }
                try {
                    byte[] bArr4 = new byte[(int) resultSize];
                    BinaryDelta.apply(bArr3, bArrDecompress2, bArr4);
                    delta = delta.next;
                    if (delta == null) {
                        return new ObjectLoader.SmallObject(i, bArr4);
                    }
                    bArr3 = bArr4;
                    windowCursor2 = windowCursor3;
                } catch (OutOfMemoryError e6) {
                    throw new LargeObjectException.OutOfMemory(e6);
                }
            }
        } catch (DataFormatException e7) {
            e = e7;
            j2 = j;
        }
    }

    private long findDeltaBase(ObjectId objectId) throws IOException {
        long jFindOffset = idx().findOffset(objectId);
        if (jFindOffset >= 0) {
            return jFindOffset;
        }
        throw new MissingObjectException(objectId, JGitText.get().missingDeltaBase);
    }

    private static class Delta {
        final long basePos;
        final long deltaPos;
        final int deltaSize;
        final int hdrLen;
        final Delta next;

        Delta(Delta delta, long j, int i, int i2, long j2) {
            this.next = delta;
            this.deltaPos = j;
            this.deltaSize = i;
            this.hdrLen = i2;
            this.basePos = j2;
        }
    }

    byte[] getDeltaHeader(WindowCursor windowCursor, long j) throws DataFormatException, IOException {
        byte[] bArr = new byte[18];
        windowCursor.inflate(this, j, bArr, true);
        return bArr;
    }

    int getObjectType(WindowCursor windowCursor, long j) throws IOException {
        int i;
        byte[] bArr;
        byte[] bArr2 = windowCursor.tempId;
        long jFindDeltaBase = j;
        while (true) {
            WindowCursor windowCursor2 = windowCursor;
            readFully(jFindDeltaBase, bArr2, 0, 20, windowCursor2);
            int i2 = bArr2[0] & 255;
            i = (i2 >> 4) & 7;
            int i3 = 1;
            if (i == 1 || i == 2 || i == 3 || i == 4) {
                break;
            }
            if (i == 6) {
                bArr = bArr2;
                while ((i2 & 128) != 0) {
                    int i4 = bArr[i3] & 255;
                    i3++;
                    i2 = i4;
                }
                int i5 = i3 + 1;
                byte b = bArr[i3];
                int i6 = b & 255;
                long j2 = b & 127;
                while ((i6 & 128) != 0) {
                    int i7 = i5 + 1;
                    byte b2 = bArr[i5];
                    i6 = b2 & 255;
                    j2 = ((j2 + 1) << 7) + ((long) (b2 & 127));
                    i5 = i7;
                }
                jFindDeltaBase -= j2;
            } else if (i == 7) {
                while ((i2 & 128) != 0) {
                    byte[] bArr3 = bArr2;
                    int i8 = bArr3[i3] & 255;
                    i3++;
                    i2 = i8;
                    bArr2 = bArr3;
                }
                readFully(jFindDeltaBase + ((long) i3), bArr2, 0, 20, windowCursor2);
                bArr = bArr2;
                jFindDeltaBase = findDeltaBase(ObjectId.fromRaw(bArr));
            } else {
                throw new IOException(MessageFormat.format(JGitText.get().unknownObjectType, Integer.valueOf(i)));
            }
            bArr2 = bArr;
            windowCursor = windowCursor2;
        }
        return i;
    }

    long getObjectSize(WindowCursor windowCursor, AnyObjectId anyObjectId) throws IOException {
        long jFindOffset = idx().findOffset(anyObjectId);
        if (0 < jFindOffset) {
            return getObjectSize(windowCursor, jFindOffset);
        }
        return -1L;
    }

    long getObjectSize(WindowCursor windowCursor, long j) throws IOException {
        long j2;
        byte[] bArr = windowCursor.tempId;
        readFully(j, bArr, 0, 20, windowCursor);
        byte b = bArr[0];
        int i = b & 255;
        int i2 = (i >> 4) & 7;
        long j3 = b & Ascii.SI;
        int i3 = 4;
        int i4 = 1;
        while ((i & 128) != 0) {
            int i5 = i4 + 1;
            byte b2 = bArr[i4];
            int i6 = b2 & 255;
            j3 += ((long) (b2 & 127)) << i3;
            i3 += 7;
            i4 = i5;
            i = i6;
        }
        if (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4) {
            return j3;
        }
        if (i2 == 6) {
            int i7 = i4 + 1;
            int i8 = bArr[i4] & 255;
            while ((i8 & 128) != 0) {
                i8 = bArr[i7] & 255;
                i7++;
            }
            j2 = j + ((long) i7);
        } else {
            if (i2 != 7) {
                throw new IOException(MessageFormat.format(JGitText.get().unknownObjectType, Integer.valueOf(i2)));
            }
            j2 = j + ((long) i4) + 20;
        }
        try {
            return BinaryDelta.getResultSize(getDeltaHeader(windowCursor, j2));
        } catch (DataFormatException e) {
            throw new CorruptObjectException(MessageFormat.format(JGitText.get().objectAtHasBadZlibStream, Long.valueOf(j), getPackFile()), e);
        }
    }

    LocalObjectRepresentation representation(WindowCursor windowCursor, AnyObjectId anyObjectId) throws IOException {
        long jFindOffset = idx().findOffset(anyObjectId);
        if (jFindOffset < 0) {
            return null;
        }
        byte[] bArr = windowCursor.tempId;
        readFully(jFindOffset, bArr, 0, 20, windowCursor);
        int i = bArr[0] & 255;
        int i2 = (i >> 4) & 7;
        int i3 = 1;
        while ((i & 128) != 0) {
            int i4 = i3 + 1;
            int i5 = bArr[i3] & 255;
            i3 = i4;
            i = i5;
        }
        long jFindEndOffset = findEndOffset(jFindOffset) - jFindOffset;
        if (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4) {
            return LocalObjectRepresentation.newWhole(this, jFindOffset, jFindEndOffset - ((long) i3));
        }
        if (i2 != 6) {
            if (i2 == 7) {
                long j = i3;
                long j2 = (jFindEndOffset - j) - 20;
                readFully(j + jFindOffset, bArr, 0, 20, windowCursor);
                return LocalObjectRepresentation.newDelta(this, jFindOffset, j2, ObjectId.fromRaw(bArr));
            }
            throw new IOException(MessageFormat.format(JGitText.get().unknownObjectType, Integer.valueOf(i2)));
        }
        int i6 = i3 + 1;
        byte b = bArr[i3];
        int i7 = b & 255;
        long j3 = b & 127;
        while ((i7 & 128) != 0) {
            int i8 = i6 + 1;
            byte b2 = bArr[i6];
            int i9 = b2 & 255;
            j3 = ((j3 + 1) << 7) + ((long) (b2 & 127));
            i6 = i8;
            i7 = i9;
        }
        return LocalObjectRepresentation.newDelta(this, jFindOffset, jFindEndOffset - ((long) i6), jFindOffset - j3);
    }

    private long findEndOffset(long j) throws IOException {
        return getReverseIdx().findNextOffset(j, this.length - 20);
    }

    synchronized PackBitmapIndex getBitmapIndex() throws IOException {
        if (!this.invalid && this.bitmapIdxFile != null) {
            Optional<PackBitmapIndex> optional = this.bitmapIdx.getOptional();
            if (optional.isPresent()) {
                return optional.get();
            }
            try {
                PackBitmapIndex packBitmapIndexOpen = PackBitmapIndex.open(this.bitmapIdxFile, idx(), getReverseIdx());
                if (Arrays.equals(this.packChecksum, packBitmapIndexOpen.getPackChecksum())) {
                    this.bitmapIdx = optionally(packBitmapIndexOpen);
                    return packBitmapIndexOpen;
                }
            } catch (FileNotFoundException unused) {
            } catch (IOException e) {
                if (!FileUtils.isStaleFileHandleInCausalChain(e)) {
                    throw e;
                }
            }
            this.bitmapIdxFile = null;
            return null;
        }
        return null;
    }

    synchronized void refreshBitmapIndex(PackFile packFile) {
        this.bitmapIdx = Optionally.empty();
        this.invalid = false;
        this.bitmapIdxFile = packFile;
        try {
            getBitmapIndex();
        } catch (IOException e) {
            LOG.warn(JGitText.get().bitmapFailedToGet, this.bitmapIdxFile, e);
            this.bitmapIdx = Optionally.empty();
            this.bitmapIdxFile = null;
        }
    }

    private synchronized PackReverseIndex getReverseIdx() throws IOException {
        if (this.invalid) {
            throw new PackInvalidException(this.packFile, this.invalidatingCause);
        }
        Optional<PackReverseIndex> optional = this.reverseIdx.getOptional();
        if (optional.isPresent()) {
            return optional.get();
        }
        PackReverseIndex packReverseIndexOpenOrCompute = PackReverseIndexFactory.openOrCompute(this.packFile.create(PackExt.REVERSE_INDEX), getObjectCount(), new Pack$$ExternalSyntheticLambda0(this));
        packReverseIndexOpenOrCompute.verifyPackChecksum(getPackFile().getPath());
        this.reverseIdx = optionally(packReverseIndexOpenOrCompute);
        return packReverseIndexOpenOrCompute;
    }

    private boolean isCorrupt(long j) {
        boolean zContains;
        LongList longList = this.corruptObjects;
        if (longList == null) {
            return false;
        }
        synchronized (longList) {
            zContains = longList.contains(j);
        }
        return zContains;
    }

    private void setCorrupt(long j) {
        LongList longList = this.corruptObjects;
        if (longList == null) {
            synchronized (this.readLock) {
                longList = this.corruptObjects;
                if (longList == null) {
                    longList = new LongList();
                    this.corruptObjects = longList;
                }
            }
        }
        synchronized (longList) {
            longList.add(j);
        }
    }

    public String toString() {
        return "Pack [packFileName=" + this.packFile.getName() + ", length=" + this.packFile.length() + ", packChecksum=" + ObjectId.fromRaw(this.packChecksum).name() + CollectionUtils.DEFAULT_TOSTRING_SUFFIX;
    }

    private <T> Optionally<T> optionally(T t) {
        return this.useStrongRefs ? new Optionally.Hard(t) : new Optionally.Soft(t);
    }
}
