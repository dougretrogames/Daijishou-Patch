package org.eclipse.jgit.dircache;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.security.DigestOutputStream;
import java.security.MessageDigest;
import java.text.MessageFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import net.lingala.zip4j.util.InternalZipConstants;
import org.eclipse.jgit.errors.CorruptObjectException;
import org.eclipse.jgit.errors.IndexReadException;
import org.eclipse.jgit.errors.LockFailedException;
import org.eclipse.jgit.events.IndexChangedEvent;
import org.eclipse.jgit.events.IndexChangedListener;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.storage.file.FileSnapshot;
import org.eclipse.jgit.internal.storage.file.LockFile;
import org.eclipse.jgit.internal.storage.io.NullMessageDigest;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectInserter;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.treewalk.FileTreeIterator;
import org.eclipse.jgit.treewalk.TreeWalk;
import org.eclipse.jgit.treewalk.filter.PathFilterGroup;
import org.eclipse.jgit.util.FS;
import org.eclipse.jgit.util.IO;
import org.eclipse.jgit.util.MutableInteger;
import org.eclipse.jgit.util.NB;
import org.eclipse.jgit.util.TemporaryBuffer;
import org.eclipse.jgit.util.io.SilentFileInputStream;

/* JADX INFO: loaded from: classes5.dex */
public class DirCache {
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$dircache$DirCache$DirCacheVersion = null;
    private static final int EXT_TREE = 1414677829;
    private int entryCnt;
    private IndexChangedListener indexChangedListener;
    private final File liveFile;
    private LockFile myLock;
    private byte[] readIndexChecksum;
    private Repository repository;
    private boolean skipHash;
    private FileSnapshot snapshot;
    private DirCacheEntry[] sortedEntries;
    private DirCacheTree tree;
    private DirCacheVersion version;
    private byte[] writeIndexChecksum;
    private static final byte[] SIG_DIRC = {68, 73, 82, 67};
    private static final DirCacheEntry[] NO_ENTRIES = new DirCacheEntry[0];
    private static final byte[] NO_CHECKSUM = new byte[0];
    static final Comparator<DirCacheEntry> ENT_CMP = new DirCache$$ExternalSyntheticLambda1();

    static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$dircache$DirCache$DirCacheVersion() {
        int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$dircache$DirCache$DirCacheVersion;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[DirCacheVersion.valuesCustom().length];
        try {
            iArr2[DirCacheVersion.DIRC_VERSION_EXTENDED.ordinal()] = 2;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[DirCacheVersion.DIRC_VERSION_MINIMUM.ordinal()] = 1;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[DirCacheVersion.DIRC_VERSION_PATHCOMPRESS.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        $SWITCH_TABLE$org$eclipse$jgit$dircache$DirCache$DirCacheVersion = iArr2;
        return iArr2;
    }

    static /* synthetic */ int lambda$0(DirCacheEntry dirCacheEntry, DirCacheEntry dirCacheEntry2) {
        int iCmp = cmp(dirCacheEntry, dirCacheEntry2);
        return iCmp != 0 ? iCmp : dirCacheEntry.getStage() - dirCacheEntry2.getStage();
    }

    static int cmp(DirCacheEntry dirCacheEntry, DirCacheEntry dirCacheEntry2) {
        return cmp(dirCacheEntry.path, dirCacheEntry.path.length, dirCacheEntry2);
    }

    static int cmp(byte[] bArr, int i, DirCacheEntry dirCacheEntry) {
        return cmp(bArr, i, dirCacheEntry.path, dirCacheEntry.path.length);
    }

    static int cmp(byte[] bArr, int i, byte[] bArr2, int i2) {
        for (int i3 = 0; i3 < i && i3 < i2; i3++) {
            int i4 = (bArr[i3] & 255) - (bArr2[i3] & 255);
            if (i4 != 0) {
                return i4;
            }
        }
        return i - i2;
    }

    public static DirCache newInCore() {
        return new DirCache(null, null);
    }

    public static DirCache read(ObjectReader objectReader, AnyObjectId anyObjectId) throws IOException {
        DirCache dirCacheNewInCore = newInCore();
        DirCacheBuilder dirCacheBuilderBuilder = dirCacheNewInCore.builder();
        dirCacheBuilderBuilder.addTree(null, 0, objectReader, anyObjectId);
        dirCacheBuilderBuilder.finish();
        return dirCacheNewInCore;
    }

    public static DirCache read(Repository repository) throws IOException {
        DirCache dirCache = read(repository.getIndexFile(), repository.getFS());
        dirCache.repository = repository;
        return dirCache;
    }

    public static DirCache read(File file, FS fs) throws IOException {
        DirCache dirCache = new DirCache(file, fs);
        dirCache.read();
        return dirCache;
    }

    public static DirCache lock(File file, FS fs) throws IOException {
        DirCache dirCache = new DirCache(file, fs);
        if (!dirCache.lock()) {
            throw new LockFailedException(file);
        }
        try {
            dirCache.read();
            return dirCache;
        } catch (IOException | Error | RuntimeException e) {
            dirCache.unlock();
            throw e;
        }
    }

    public static DirCache lock(Repository repository, IndexChangedListener indexChangedListener) throws IOException {
        DirCache dirCacheLock = lock(repository.getIndexFile(), repository.getFS(), indexChangedListener);
        dirCacheLock.repository = repository;
        return dirCacheLock;
    }

    public static DirCache lock(File file, FS fs, IndexChangedListener indexChangedListener) throws IOException {
        DirCache dirCacheLock = lock(file, fs);
        dirCacheLock.registerIndexChangedListener(indexChangedListener);
        return dirCacheLock;
    }

    public DirCache(File file, FS fs) {
        this.liveFile = file;
        clear();
    }

    public DirCacheBuilder builder() {
        return new DirCacheBuilder(this, this.entryCnt + 16);
    }

    public DirCacheEditor editor() {
        return new DirCacheEditor(this, this.entryCnt + 16);
    }

    DirCacheVersion getVersion() {
        return this.version;
    }

    void replace(DirCacheEntry[] dirCacheEntryArr, int i) {
        this.sortedEntries = dirCacheEntryArr;
        this.entryCnt = i;
        this.tree = null;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0047  */
    /* JADX WARN: Code duplicated, block: B:33:0x0053  */
    public void read() throws IOException {
        File file = this.liveFile;
        if (file == null) {
            throw new IOException(JGitText.get().dirCacheDoesNotHaveABackingFile);
        }
        if (!file.exists()) {
            clear();
            return;
        }
        FileSnapshot fileSnapshot = this.snapshot;
        if (fileSnapshot != null && !fileSnapshot.isModified(this.liveFile)) {
            return;
        }
        Throwable th = null;
        try {
            SilentFileInputStream silentFileInputStream = new SilentFileInputStream(this.liveFile);
            try {
                clear();
                readFrom(silentFileInputStream);
                silentFileInputStream.close();
                this.snapshot = FileSnapshot.save(this.liveFile);
            } catch (Throwable th2) {
                silentFileInputStream.close();
                throw th2;
            }
        } catch (Throwable th3) {
            if (0 == 0) {
                throw th3;
            }
            if (null == th3) {
                throw null;
            }
            try {
                th.addSuppressed(th3);
                throw null;
            } catch (FileNotFoundException e) {
                if (!this.liveFile.exists()) {
                    throw new IndexReadException(MessageFormat.format(JGitText.get().cannotReadIndex, this.liveFile.getAbsolutePath(), e));
                }
                clear();
            }
            if (!this.liveFile.exists()) {
                throw new IndexReadException(MessageFormat.format(JGitText.get().cannotReadIndex, this.liveFile.getAbsolutePath(), e));
            }
            clear();
        }
    }

    public boolean isOutdated() throws IOException {
        File file = this.liveFile;
        if (file == null || !file.exists()) {
            return false;
        }
        FileSnapshot fileSnapshot = this.snapshot;
        return fileSnapshot == null || fileSnapshot.isModified(this.liveFile);
    }

    public void clear() {
        this.snapshot = null;
        this.sortedEntries = NO_ENTRIES;
        this.entryCnt = 0;
        this.tree = null;
        this.readIndexChecksum = NO_CHECKSUM;
    }

    private void readFrom(InputStream inputStream) throws IOException {
        DirCache dirCache = this;
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        dirCache.readConfig();
        MessageDigest messageDigestNewMessageDigest = dirCache.newMessageDigest();
        byte[] bArr = new byte[20];
        IO.readFully(bufferedInputStream, bArr, 0, 12);
        messageDigestNewMessageDigest.update(bArr, 0, 12);
        if (!is_DIRC(bArr)) {
            throw new CorruptObjectException(JGitText.get().notADIRCFile);
        }
        int iDecodeInt32 = NB.decodeInt32(bArr, 4);
        DirCacheVersion dirCacheVersionFromInt = DirCacheVersion.fromInt(iDecodeInt32);
        if (dirCacheVersionFromInt == null) {
            throw new CorruptObjectException(MessageFormat.format(JGitText.get().unknownDIRCVersion, Integer.valueOf(iDecodeInt32)));
        }
        int i = $SWITCH_TABLE$org$eclipse$jgit$dircache$DirCache$DirCacheVersion()[dirCacheVersionFromInt.ordinal()];
        boolean z = true;
        if (i == 1) {
            z = false;
        } else if (i != 2 && i != 3) {
            throw new CorruptObjectException(MessageFormat.format(JGitText.get().unknownDIRCVersion, dirCacheVersionFromInt));
        }
        dirCache.version = dirCacheVersionFromInt;
        int iDecodeInt33 = NB.decodeInt32(bArr, 8);
        dirCache.entryCnt = iDecodeInt33;
        if (iDecodeInt33 < 0) {
            throw new CorruptObjectException(JGitText.get().DIRCHasTooManyEntries);
        }
        FileSnapshot fileSnapshotSave = FileSnapshot.save(dirCache.liveFile);
        dirCache.snapshot = fileSnapshotSave;
        Instant instantLastModifiedInstant = fileSnapshotSave.lastModifiedInstant();
        int maximumInfoLength = DirCacheEntry.getMaximumInfoLength(z);
        int i2 = dirCache.entryCnt;
        byte[] bArr2 = new byte[maximumInfoLength * i2];
        dirCache.sortedEntries = new DirCacheEntry[i2];
        MutableInteger mutableInteger = new MutableInteger();
        int i3 = 0;
        while (true) {
            DirCacheEntry dirCacheEntry = null;
            if (i3 >= dirCache.entryCnt) {
                break;
            }
            DirCache dirCache2 = dirCache;
            byte[] bArr3 = bArr;
            DirCacheEntry[] dirCacheEntryArr = dirCache2.sortedEntries;
            BufferedInputStream bufferedInputStream2 = bufferedInputStream;
            byte[] bArr4 = bArr2;
            MessageDigest messageDigest = messageDigestNewMessageDigest;
            MutableInteger mutableInteger2 = mutableInteger;
            DirCacheVersion dirCacheVersion = dirCache2.version;
            if (i3 != 0) {
                dirCacheEntry = dirCache2.sortedEntries[i3 - 1];
            }
            DirCacheEntry dirCacheEntry2 = new DirCacheEntry(bArr4, mutableInteger2, bufferedInputStream2, messageDigest, instantLastModifiedInstant, dirCacheVersion, dirCacheEntry);
            bufferedInputStream = bufferedInputStream2;
            messageDigestNewMessageDigest = messageDigest;
            dirCacheEntryArr[i3] = dirCacheEntry2;
            i3++;
            bArr2 = bArr4;
            mutableInteger = mutableInteger2;
            dirCache = dirCache2;
            bArr = bArr3;
        }
        while (true) {
            bufferedInputStream.mark(21);
            IO.readFully(bufferedInputStream, bArr, 0, 20);
            if (bufferedInputStream.read() >= 0) {
                bufferedInputStream.reset();
                messageDigestNewMessageDigest.update(bArr, 0, 8);
                IO.skipFully(bufferedInputStream, 8L);
                long jDecodeUInt32 = NB.decodeUInt32(bArr, 4);
                if (NB.decodeInt32(bArr, 0) != EXT_TREE) {
                    byte b = bArr[0];
                    if (b < 65 || b > 90) {
                        break;
                    } else {
                        dirCache.skipOptionalExtension(bufferedInputStream, messageDigestNewMessageDigest, bArr, jDecodeUInt32);
                    }
                } else {
                    DirCache dirCache3 = dirCache;
                    byte[] bArr5 = bArr;
                    if (2147483647L < jDecodeUInt32) {
                        throw new CorruptObjectException(MessageFormat.format(JGitText.get().DIRCExtensionIsTooLargeAt, formatExtensionName(bArr5), Long.valueOf(jDecodeUInt32)));
                    }
                    int i4 = (int) jDecodeUInt32;
                    byte[] bArr6 = new byte[i4];
                    IO.readFully(bufferedInputStream, bArr6, 0, i4);
                    messageDigestNewMessageDigest.update(bArr6, 0, i4);
                    dirCache3.tree = new DirCacheTree(bArr6, new MutableInteger(), null);
                    dirCache = dirCache3;
                    bArr = bArr5;
                }
            } else {
                byte[] bArrDigest = messageDigestNewMessageDigest.digest();
                dirCache.readIndexChecksum = bArrDigest;
                if (!dirCache.skipHash && !Arrays.equals(bArrDigest, bArr) && !Arrays.equals(NullMessageDigest.getInstance().digest(), bArr)) {
                    throw new CorruptObjectException(JGitText.get().DIRCChecksumMismatch);
                }
                return;
            }
        }
        throw new CorruptObjectException(MessageFormat.format(JGitText.get().DIRCExtensionNotSupportedByThisVersion, formatExtensionName(bArr)));
    }

    private void skipOptionalExtension(InputStream inputStream, MessageDigest messageDigest, byte[] bArr, long j) throws IOException {
        byte[] bArr2 = new byte[4096];
        while (0 < j) {
            int i = inputStream.read(bArr2, 0, (int) Math.min(4096, j));
            if (i < 0) {
                throw new EOFException(MessageFormat.format(JGitText.get().shortReadOfOptionalDIRCExtensionExpectedAnotherBytes, formatExtensionName(bArr), Long.valueOf(j)));
            }
            messageDigest.update(bArr2, 0, i);
            j -= (long) i;
        }
    }

    private static String formatExtensionName(byte[] bArr) {
        return "'" + new String(bArr, 0, 4, StandardCharsets.ISO_8859_1) + "'";
    }

    private static boolean is_DIRC(byte[] bArr) {
        if (bArr.length < SIG_DIRC.length) {
            return false;
        }
        int i = 0;
        while (true) {
            byte[] bArr2 = SIG_DIRC;
            if (i >= bArr2.length) {
                return true;
            }
            if (bArr[i] != bArr2[i]) {
                return false;
            }
            i++;
        }
    }

    public boolean lock() throws IOException {
        if (this.liveFile == null) {
            throw new IOException(JGitText.get().dirCacheDoesNotHaveABackingFile);
        }
        LockFile lockFile = new LockFile(this.liveFile);
        if (!lockFile.lock()) {
            return false;
        }
        lockFile.setNeedStatInformation(true);
        this.myLock = lockFile;
        return true;
    }

    public void write() throws IOException {
        LockFile lockFile = this.myLock;
        requireLocked(lockFile);
        Throwable th = null;
        try {
            OutputStream outputStream = lockFile.getOutputStream();
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
                try {
                    writeTo(this.liveFile.getParentFile(), bufferedOutputStream);
                    bufferedOutputStream.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                } catch (Throwable th2) {
                    bufferedOutputStream.close();
                    throw th2;
                }
            } catch (Throwable th3) {
                if (0 == 0) {
                    th = th3;
                } else if (null != th3) {
                    th.addSuppressed(th3);
                }
                if (outputStream == null) {
                    throw th;
                }
                outputStream.close();
                throw th;
            }
        } catch (Throwable th4) {
            if (0 == 0) {
                throw th4;
            }
            if (null == th4) {
                throw null;
            }
            try {
                th.addSuppressed(th4);
                throw null;
            } catch (IOException | Error | RuntimeException e) {
                lockFile.unlock();
                throw e;
            }
            lockFile.unlock();
            throw e;
        }
    }

    void writeTo(File file, OutputStream outputStream) throws IOException {
        Instant instantLastModifiedInstant;
        readConfig();
        MessageDigest messageDigestNewMessageDigest = newMessageDigest();
        DigestOutputStream digestOutputStream = new DigestOutputStream(outputStream, messageDigestNewMessageDigest);
        DirCacheVersion dirCacheVersion = this.version;
        if (dirCacheVersion == null || dirCacheVersion == DirCacheVersion.DIRC_VERSION_MINIMUM) {
            this.version = DirCacheVersion.DIRC_VERSION_MINIMUM;
            for (int i = 0; i < this.entryCnt; i++) {
                if (this.sortedEntries[i].isExtended()) {
                    this.version = DirCacheVersion.DIRC_VERSION_EXTENDED;
                    break;
                }
            }
        }
        byte[] bArr = new byte[128];
        byte[] bArr2 = SIG_DIRC;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        NB.encodeInt32(bArr, 4, this.version.getVersionCode());
        NB.encodeInt32(bArr, 8, this.entryCnt);
        digestOutputStream.write(bArr, 0, 12);
        LockFile lockFile = this.myLock;
        if (lockFile != null) {
            lockFile.createCommitSnapshot();
            FileSnapshot commitSnapshot = this.myLock.getCommitSnapshot();
            this.snapshot = commitSnapshot;
            instantLastModifiedInstant = commitSnapshot.lastModifiedInstant();
        } else {
            instantLastModifiedInstant = Instant.EPOCH;
        }
        Instant instant = instantLastModifiedInstant;
        boolean z = this.tree != null;
        if (this.repository != null && this.entryCnt > 0) {
            updateSmudgedEntries();
        }
        int i2 = 0;
        while (true) {
            DirCacheEntry dirCacheEntry = null;
            if (i2 >= this.entryCnt) {
                break;
            }
            DirCacheEntry dirCacheEntry2 = this.sortedEntries[i2];
            if (dirCacheEntry2.mightBeRacilyClean(instant)) {
                dirCacheEntry2.smudgeRacilyClean();
            }
            DirCacheVersion dirCacheVersion2 = this.version;
            if (i2 != 0) {
                dirCacheEntry = this.sortedEntries[i2 - 1];
            }
            dirCacheEntry2.write(digestOutputStream, dirCacheVersion2, dirCacheEntry);
            i2++;
        }
        if (z) {
            TemporaryBuffer.LocalFile localFile = new TemporaryBuffer.LocalFile(file, 5242880);
            try {
                this.tree.write(bArr, localFile);
                localFile.close();
                NB.encodeInt32(bArr, 0, EXT_TREE);
                NB.encodeInt32(bArr, 4, (int) localFile.length());
                digestOutputStream.write(bArr, 0, 8);
                localFile.writeTo(digestOutputStream, null);
                localFile.destroy();
            } catch (Throwable th) {
                localFile.destroy();
                throw th;
            }
        }
        byte[] bArrDigest = messageDigestNewMessageDigest.digest();
        this.writeIndexChecksum = bArrDigest;
        outputStream.write(bArrDigest);
        outputStream.close();
    }

    private void readConfig() {
        Repository repository;
        if (this.version != null || (repository = this.repository) == null) {
            return;
        }
        DirCacheConfig dirCacheConfig = (DirCacheConfig) repository.getConfig().get(new DirCache$$ExternalSyntheticLambda0());
        this.version = dirCacheConfig.getIndexVersion();
        this.skipHash = dirCacheConfig.isSkipHash();
    }

    private MessageDigest newMessageDigest() {
        if (this.skipHash) {
            return NullMessageDigest.getInstance();
        }
        return Constants.newMessageDigest();
    }

    public boolean commit() {
        LockFile lockFile = this.myLock;
        requireLocked(lockFile);
        this.myLock = null;
        if (!lockFile.commit()) {
            return false;
        }
        this.snapshot = lockFile.getCommitSnapshot();
        if (this.indexChangedListener != null && !Arrays.equals(this.readIndexChecksum, this.writeIndexChecksum)) {
            this.indexChangedListener.onIndexChanged(new IndexChangedEvent(true));
        }
        return true;
    }

    private void requireLocked(LockFile lockFile) {
        if (this.liveFile == null) {
            throw new IllegalStateException(JGitText.get().dirCacheIsNotLocked);
        }
        if (lockFile == null) {
            throw new IllegalStateException(MessageFormat.format(JGitText.get().dirCacheFileIsNotLocked, this.liveFile.getAbsolutePath()));
        }
    }

    public void unlock() {
        LockFile lockFile = this.myLock;
        if (lockFile != null) {
            this.myLock = null;
            lockFile.unlock();
        }
    }

    public int findEntry(String str) {
        byte[] bArrEncode = Constants.encode(str);
        return findEntry(bArrEncode, bArrEncode.length);
    }

    public int findEntry(byte[] bArr, int i) {
        return findEntry(0, bArr, i);
    }

    int findEntry(int i, byte[] bArr, int i2) {
        int i3 = this.entryCnt;
        while (i < i3) {
            int i4 = (i + i3) >>> 1;
            int iCmp = cmp(bArr, i2, this.sortedEntries[i4]);
            if (iCmp < 0) {
                i3 = i4;
            } else {
                if (iCmp == 0) {
                    while (i4 > 0 && cmp(bArr, i2, this.sortedEntries[i4 - 1]) == 0) {
                        i4--;
                    }
                    return i4;
                }
                i = i4 + 1;
            }
        }
        return -(i + 1);
    }

    public int nextEntry(int i) {
        DirCacheEntry dirCacheEntry = this.sortedEntries[i];
        int i2 = i + 1;
        while (i2 < this.entryCnt) {
            DirCacheEntry dirCacheEntry2 = this.sortedEntries[i2];
            if (cmp(dirCacheEntry, dirCacheEntry2) != 0) {
                break;
            }
            i2++;
            dirCacheEntry = dirCacheEntry2;
        }
        return i2;
    }

    int nextEntry(byte[] bArr, int i, int i2) {
        while (i2 < this.entryCnt && DirCacheTree.peq(bArr, this.sortedEntries[i2].path, i)) {
            i2++;
        }
        return i2;
    }

    public int getEntryCount() {
        return this.entryCnt;
    }

    public DirCacheEntry getEntry(int i) {
        return this.sortedEntries[i];
    }

    public DirCacheEntry getEntry(String str) {
        int iFindEntry = findEntry(str);
        if (iFindEntry < 0) {
            return null;
        }
        return this.sortedEntries[iFindEntry];
    }

    public DirCacheEntry[] getEntriesWithin(String str) {
        if (str.length() == 0) {
            int i = this.entryCnt;
            DirCacheEntry[] dirCacheEntryArr = new DirCacheEntry[i];
            System.arraycopy(this.sortedEntries, 0, dirCacheEntryArr, 0, i);
            return dirCacheEntryArr;
        }
        if (!str.endsWith(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
            str = str + InternalZipConstants.ZIP_FILE_SEPARATOR;
        }
        byte[] bArrEncode = Constants.encode(str);
        int length = bArrEncode.length;
        int iFindEntry = findEntry(bArrEncode, length);
        if (iFindEntry < 0) {
            iFindEntry = -(iFindEntry + 1);
        }
        int iNextEntry = nextEntry(bArrEncode, length, iFindEntry) - iFindEntry;
        DirCacheEntry[] dirCacheEntryArr2 = new DirCacheEntry[iNextEntry];
        System.arraycopy(this.sortedEntries, iFindEntry, dirCacheEntryArr2, 0, iNextEntry);
        return dirCacheEntryArr2;
    }

    void toArray(int i, DirCacheEntry[] dirCacheEntryArr, int i2, int i3) {
        System.arraycopy(this.sortedEntries, i, dirCacheEntryArr, i2, i3);
    }

    public DirCacheTree getCacheTree(boolean z) {
        if (z) {
            if (this.tree == null) {
                this.tree = new DirCacheTree();
            }
            this.tree.validate(this.sortedEntries, this.entryCnt, 0, 0);
        }
        return this.tree;
    }

    public ObjectId writeTree(ObjectInserter objectInserter) throws IOException {
        return getCacheTree(true).writeTree(this.sortedEntries, 0, 0, objectInserter);
    }

    public boolean hasUnmergedPaths() {
        for (int i = 0; i < this.entryCnt; i++) {
            if (this.sortedEntries[i].getStage() > 0) {
                return true;
            }
        }
        return false;
    }

    private void registerIndexChangedListener(IndexChangedListener indexChangedListener) {
        this.indexChangedListener = indexChangedListener;
    }

    private void updateSmudgedEntries() throws IOException {
        FileTreeIterator fileTreeIterator;
        ArrayList arrayList = new ArrayList(128);
        Throwable th = null;
        try {
            TreeWalk treeWalk = new TreeWalk(this.repository);
            try {
                treeWalk.setOperationType(TreeWalk.OperationType.CHECKIN_OP);
                for (int i = 0; i < this.entryCnt; i++) {
                    if (this.sortedEntries[i].isSmudged()) {
                        arrayList.add(this.sortedEntries[i].getPathString());
                    }
                }
                if (!arrayList.isEmpty()) {
                    treeWalk.setFilter(PathFilterGroup.createFromStrings(arrayList));
                    DirCacheIterator dirCacheIterator = new DirCacheIterator(this);
                    FileTreeIterator fileTreeIterator2 = new FileTreeIterator(this.repository);
                    treeWalk.addTree(dirCacheIterator);
                    treeWalk.addTree(fileTreeIterator2);
                    fileTreeIterator2.setDirCacheIterator(treeWalk, 0);
                    treeWalk.setRecursive(true);
                    while (treeWalk.next()) {
                        DirCacheIterator dirCacheIterator2 = (DirCacheIterator) treeWalk.getTree(0, DirCacheIterator.class);
                        if (dirCacheIterator2 != null && (fileTreeIterator = (FileTreeIterator) treeWalk.getTree(1, FileTreeIterator.class)) != null) {
                            DirCacheEntry dirCacheEntry = dirCacheIterator2.getDirCacheEntry();
                            if (dirCacheEntry.isSmudged() && dirCacheIterator2.idEqual(fileTreeIterator)) {
                                dirCacheEntry.setLength(fileTreeIterator.getEntryLength());
                                dirCacheEntry.setLastModified(fileTreeIterator.getEntryLastModifiedInstant());
                            }
                        }
                    }
                }
            } finally {
                treeWalk.close();
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            if (null != th2) {
                th.addSuppressed(th2);
            }
            throw null;
        }
    }

    enum DirCacheVersion implements Config.ConfigEnum {
        DIRC_VERSION_MINIMUM(2),
        DIRC_VERSION_EXTENDED(3),
        DIRC_VERSION_PATHCOMPRESS(4);

        private final int version;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static DirCacheVersion[] valuesCustom() {
            DirCacheVersion[] dirCacheVersionArrValuesCustom = values();
            int length = dirCacheVersionArrValuesCustom.length;
            DirCacheVersion[] dirCacheVersionArr = new DirCacheVersion[length];
            System.arraycopy(dirCacheVersionArrValuesCustom, 0, dirCacheVersionArr, 0, length);
            return dirCacheVersionArr;
        }

        DirCacheVersion(int i) {
            this.version = i;
        }

        public int getVersionCode() {
            return this.version;
        }

        @Override // org.eclipse.jgit.lib.Config.ConfigEnum
        public String toConfigValue() {
            return Integer.toString(this.version);
        }

        @Override // org.eclipse.jgit.lib.Config.ConfigEnum
        public boolean matchConfigValue(String str) {
            try {
                return this.version == Integer.parseInt(str);
            } catch (NumberFormatException unused) {
            }
        }

        public static DirCacheVersion fromInt(int i) {
            for (DirCacheVersion dirCacheVersion : valuesCustom()) {
                if (i == dirCacheVersion.getVersionCode()) {
                    return dirCacheVersion;
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class DirCacheConfig {
        private final DirCacheVersion indexVersion;
        private final boolean skipHash;

        public DirCacheConfig(Config config) {
            DirCacheVersion dirCacheVersion;
            boolean z = config.getBoolean(ConfigConstants.CONFIG_FEATURE_SECTION, ConfigConstants.CONFIG_KEY_MANYFILES, false);
            DirCacheVersion[] dirCacheVersionArrValuesCustom = DirCacheVersion.valuesCustom();
            if (z) {
                dirCacheVersion = DirCacheVersion.DIRC_VERSION_PATHCOMPRESS;
            } else {
                dirCacheVersion = DirCacheVersion.DIRC_VERSION_EXTENDED;
            }
            this.indexVersion = (DirCacheVersion) config.getEnum(dirCacheVersionArrValuesCustom, ConfigConstants.CONFIG_INDEX_SECTION, null, "version", dirCacheVersion);
            this.skipHash = config.getBoolean(ConfigConstants.CONFIG_INDEX_SECTION, ConfigConstants.CONFIG_KEY_SKIPHASH, false);
        }

        public DirCacheVersion getIndexVersion() {
            return this.indexVersion;
        }

        public boolean isSkipHash() {
            return this.skipHash;
        }
    }
}
