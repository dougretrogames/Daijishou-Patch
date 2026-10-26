package org.eclipse.jgit.internal.storage.dfs;

import com.google.common.base.Ascii;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.text.MessageFormat;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import org.eclipse.jgit.errors.CorruptObjectException;
import org.eclipse.jgit.errors.LargeObjectException;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.errors.PackInvalidException;
import org.eclipse.jgit.errors.StoredObjectRepresentationNotAvailableException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.storage.commitgraph.CommitGraph;
import org.eclipse.jgit.internal.storage.commitgraph.CommitGraphLoader;
import org.eclipse.jgit.internal.storage.file.PackBitmapIndex;
import org.eclipse.jgit.internal.storage.file.PackIndex;
import org.eclipse.jgit.internal.storage.file.PackObjectSizeIndex;
import org.eclipse.jgit.internal.storage.file.PackObjectSizeIndexLoader;
import org.eclipse.jgit.internal.storage.file.PackReverseIndex;
import org.eclipse.jgit.internal.storage.file.PackReverseIndexFactory;
import org.eclipse.jgit.internal.storage.pack.BinaryDelta;
import org.eclipse.jgit.internal.storage.pack.PackExt;
import org.eclipse.jgit.internal.storage.pack.PackOutputStream;
import org.eclipse.jgit.lib.AbbreviatedObjectId;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectLoader;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.util.LongList;

/* INFO: loaded from: classes5.dex */
public final class DfsPackFile extends BlockBasedFile {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final PackBitmapIndexLoader DEFAULT_BITMAP_LOADER = new StreamPackBitmapIndexLoader(null);
    private static final int REC_SIZE = 28;
    private static final long REF_POSITION = 0;
    private volatile PackBitmapIndex bitmapIndex;
    private final PackBitmapIndexLoader bitmapLoader;
    private volatile CommitGraph commitGraph;
    private volatile LongList corruptObjects;
    private final Object corruptObjectsLock;
    private volatile PackIndex index;
    private final IndexFactory indexFactory;
    private volatile PackObjectSizeIndex objectSizeIndex;
    private boolean objectSizeIndexLoadAttempted;
    private volatile PackReverseIndex reverseIndex;

    public interface IndexFactory {

        public interface PackIndexes {
            PackIndex index(DfsReader dfsReader) throws IOException;

            PackReverseIndex reverseIndex(DfsReader dfsReader) throws IOException;
        }

        PackIndexes getPackIndexes();
    }

    static /* synthetic */ ReadableChannel lambda$3(ReadableChannel readableChannel) throws IOException {
        return readableChannel;
    }

    DfsPackFile(DfsBlockCache dfsBlockCache, DfsPackDescription dfsPackDescription) {
        this(dfsBlockCache, dfsPackDescription, DEFAULT_BITMAP_LOADER, new CachedStreamIndexFactory(dfsBlockCache, dfsPackDescription));
    }

    public DfsPackFile(DfsBlockCache dfsBlockCache, DfsPackDescription dfsPackDescription, PackBitmapIndexLoader packBitmapIndexLoader, IndexFactory indexFactory) {
        super(dfsBlockCache, dfsPackDescription, PackExt.PACK);
        this.corruptObjectsLock = new Object();
        int blockSize = dfsPackDescription.getBlockSize(PackExt.PACK);
        if (blockSize > 0) {
            setBlockSize(blockSize);
        }
        long fileSize = dfsPackDescription.getFileSize(PackExt.PACK);
        this.length = fileSize <= 0 ? -1L : fileSize;
        this.bitmapLoader = packBitmapIndexLoader;
        this.indexFactory = indexFactory;
    }

    public DfsPackDescription getPackDescription() {
        return this.desc;
    }

    public boolean isIndexLoaded() {
        return this.index != null;
    }

    void setPackIndex(PackIndex packIndex) {
        this.cache.putRef(this.desc.getStreamKey(PackExt.INDEX), packIndex.getObjectCount() * ((long) 28), packIndex);
        this.index = packIndex;
    }

    public PackIndex getPackIndex(DfsReader dfsReader) throws IOException {
        return idx(dfsReader);
    }

    /* INFO: Access modifiers changed from: private */
    public PackIndex idx(DfsReader dfsReader) throws IOException {
        if (this.index != null) {
            return this.index;
        }
        if (this.invalid) {
            throw new PackInvalidException(getFileName(), this.invalidatingCause);
        }
        Repository.getGlobalListenerList().dispatch(new BeforeDfsPackIndexLoadedEvent(this));
        try {
            this.index = this.indexFactory.getPackIndexes().index(dfsReader);
            if (this.index == null) {
                throw new IOException("Couldn't get a reference to the primary index");
            }
            dfsReader.emitIndexLoad(this.desc, PackExt.INDEX, this.index);
            return this.index;
        } catch (IOException e) {
            this.invalid = true;
            this.invalidatingCause = e;
            throw e;
        }
    }

    final boolean isGarbage() {
        return this.desc.getPackSource() == DfsObjDatabase.PackSource.UNREACHABLE_GARBAGE;
    }

    public PackBitmapIndex getBitmapIndex(DfsReader dfsReader) throws IOException {
        if (this.invalid || isGarbage() || !this.bitmapLoader.hasBitmaps(this.desc)) {
            return null;
        }
        if (this.bitmapIndex != null) {
            return this.bitmapIndex;
        }
        if (!this.bitmapLoader.keepInDfs(this.desc)) {
            PackBitmapIndexLoader.LoadResult loadResultLoadPackBitmapIndex = this.bitmapLoader.loadPackBitmapIndex(dfsReader, this);
            if (this.bitmapIndex == null && loadResultLoadPackBitmapIndex.bitmapIndex != null) {
                this.bitmapIndex = loadResultLoadPackBitmapIndex.bitmapIndex;
            }
            return this.bitmapIndex;
        }
        DfsStreamKey streamKey = this.desc.getStreamKey(PackExt.BITMAP_INDEX);
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        DfsBlockCache.Ref orLoadRef = this.cache.getOrLoadRef(streamKey, 0L, new DfsPackFile$$ExternalSyntheticLambda1(this, atomicBoolean, dfsReader, streamKey));
        if (atomicBoolean.get()) {
            dfsReader.stats.bitmapCacheHit++;
        }
        PackBitmapIndex packBitmapIndex = (PackBitmapIndex) orLoadRef.get();
        if (this.bitmapIndex == null && packBitmapIndex != null) {
            this.bitmapIndex = packBitmapIndex;
        }
        dfsReader.emitIndexLoad(this.desc, PackExt.BITMAP_INDEX, this.bitmapIndex);
        return this.bitmapIndex;
    }

    /* INFO: renamed from: lambda$0$org-eclipse-jgit-internal-storage-dfs-DfsPackFile, reason: not valid java name */
    /* synthetic */ DfsBlockCache.Ref m5672lambda$0$orgeclipsejgitinternalstoragedfsDfsPackFile(AtomicBoolean atomicBoolean, DfsReader dfsReader, DfsStreamKey dfsStreamKey) throws IOException {
        atomicBoolean.set(false);
        return loadBitmapIndex(dfsReader, dfsStreamKey);
    }

    public CommitGraph getCommitGraph(DfsReader dfsReader) throws IOException {
        if (this.invalid || isGarbage() || !this.desc.hasFileExt(PackExt.COMMIT_GRAPH)) {
            return null;
        }
        if (this.commitGraph != null) {
            return this.commitGraph;
        }
        DfsStreamKey streamKey = this.desc.getStreamKey(PackExt.COMMIT_GRAPH);
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        DfsBlockCache.Ref orLoadRef = this.cache.getOrLoadRef(streamKey, 0L, new DfsPackFile$$ExternalSyntheticLambda2(this, atomicBoolean, dfsReader, streamKey));
        if (atomicBoolean.get()) {
            dfsReader.stats.commitGraphCacheHit++;
        }
        CommitGraph commitGraph = (CommitGraph) orLoadRef.get();
        if (this.commitGraph == null && commitGraph != null) {
            this.commitGraph = commitGraph;
        }
        dfsReader.emitIndexLoad(this.desc, PackExt.COMMIT_GRAPH, this.commitGraph);
        return this.commitGraph;
    }

    /* INFO: renamed from: lambda$1$org-eclipse-jgit-internal-storage-dfs-DfsPackFile, reason: not valid java name */
    /* synthetic */ DfsBlockCache.Ref m5673lambda$1$orgeclipsejgitinternalstoragedfsDfsPackFile(AtomicBoolean atomicBoolean, DfsReader dfsReader, DfsStreamKey dfsStreamKey) throws IOException {
        atomicBoolean.set(false);
        return loadCommitGraph(dfsReader, dfsStreamKey);
    }

    public PackReverseIndex getReverseIdx(DfsReader dfsReader) throws IOException {
        if (this.reverseIndex != null) {
            return this.reverseIndex;
        }
        this.reverseIndex = this.indexFactory.getPackIndexes().reverseIndex(dfsReader);
        if (this.reverseIndex == null) {
            throw new IOException("Couldn't get a reference to the reverse index");
        }
        dfsReader.emitIndexLoad(this.desc, PackExt.REVERSE_INDEX, this.reverseIndex);
        return this.reverseIndex;
    }

    private PackObjectSizeIndex getObjectSizeIndex(DfsReader dfsReader) throws IOException {
        if (this.objectSizeIndex != null) {
            return this.objectSizeIndex;
        }
        if (this.objectSizeIndexLoadAttempted || !dfsReader.getOptions().shouldUseObjectSizeIndex() || !this.desc.hasFileExt(PackExt.OBJECT_SIZE_INDEX)) {
            return null;
        }
        DfsStreamKey streamKey = this.desc.getStreamKey(PackExt.OBJECT_SIZE_INDEX);
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        try {
            DfsBlockCache.Ref orLoadRef = this.cache.getOrLoadRef(streamKey, 0L, new DfsPackFile$$ExternalSyntheticLambda3(this, atomicBoolean, dfsReader, streamKey));
            if (atomicBoolean.get()) {
                dfsReader.stats.objectSizeIndexCacheHit++;
            }
            PackObjectSizeIndex packObjectSizeIndex = (PackObjectSizeIndex) orLoadRef.get();
            if (this.objectSizeIndex == null && packObjectSizeIndex != null) {
                this.objectSizeIndex = packObjectSizeIndex;
            }
            this.objectSizeIndexLoadAttempted = true;
            if (this.objectSizeIndex != null) {
                dfsReader.emitIndexLoad(this.desc, PackExt.OBJECT_SIZE_INDEX, this.objectSizeIndex);
            }
            return this.objectSizeIndex;
        } catch (Throwable th) {
            this.objectSizeIndexLoadAttempted = true;
            throw th;
        }
    }

    /* INFO: renamed from: lambda$2$org-eclipse-jgit-internal-storage-dfs-DfsPackFile, reason: not valid java name */
    /* synthetic */ DfsBlockCache.Ref m5674lambda$2$orgeclipsejgitinternalstoragedfsDfsPackFile(AtomicBoolean atomicBoolean, DfsReader dfsReader, DfsStreamKey dfsStreamKey) throws IOException {
        atomicBoolean.set(false);
        return loadObjectSizeIndex(dfsReader, dfsStreamKey);
    }

    public boolean hasObject(DfsReader dfsReader, AnyObjectId anyObjectId) throws IOException {
        long jFindOffset = idx(dfsReader).findOffset(anyObjectId);
        return 0 < jFindOffset && !isCorrupt(jFindOffset);
    }

    ObjectLoader get(DfsReader dfsReader, AnyObjectId anyObjectId) throws IOException {
        long jFindOffset = idx(dfsReader).findOffset(anyObjectId);
        if (0 >= jFindOffset || isCorrupt(jFindOffset)) {
            return null;
        }
        return load(dfsReader, jFindOffset);
    }

    long findOffset(DfsReader dfsReader, AnyObjectId anyObjectId) throws IOException {
        return idx(dfsReader).findOffset(anyObjectId);
    }

    void resolve(DfsReader dfsReader, Set<ObjectId> set, AbbreviatedObjectId abbreviatedObjectId, int i) throws IOException {
        idx(dfsReader).resolve(set, abbreviatedObjectId, i);
    }

    long getObjectCount(DfsReader dfsReader) throws IOException {
        return idx(dfsReader).getObjectCount();
    }

    private byte[] decompress(long j, int i, DfsReader dfsReader) throws DataFormatException, IOException {
        try {
            byte[] bArr = new byte[i];
            if (dfsReader.inflate(this, j, bArr, false) == i) {
                return bArr;
            }
            throw new EOFException(MessageFormat.format(JGitText.get().shortCompressedStreamAt, Long.valueOf(j)));
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    void copyPackAsIs(PackOutputStream packOutputStream, DfsReader dfsReader) throws IOException {
        if (this.length == -1) {
            dfsReader.pin(this, 0L);
            dfsReader.unpin();
        }
        Throwable th = null;
        try {
            ReadableChannel readableChannelOpenFile = dfsReader.db.openFile(this.desc, PackExt.PACK);
            try {
                int streamPackBufferSize = dfsReader.getOptions().getStreamPackBufferSize();
                if (streamPackBufferSize > 0) {
                    readableChannelOpenFile.setReadAheadBytes(streamPackBufferSize);
                }
                if (this.cache.shouldCopyThroughCache(this.length)) {
                    copyPackThroughCache(packOutputStream, dfsReader, readableChannelOpenFile);
                } else {
                    copyPackBypassCache(packOutputStream, readableChannelOpenFile);
                }
            } finally {
                if (readableChannelOpenFile != null) {
                    readableChannelOpenFile.close();
                }
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

    private void copyPackThroughCache(PackOutputStream packOutputStream, DfsReader dfsReader, ReadableChannel readableChannel) throws IOException {
        long j = this.length - 32;
        long j2 = 12;
        while (0 < j) {
            DfsReader dfsReader2 = dfsReader;
            DfsBlock orLoad = this.cache.getOrLoad(this, j2, dfsReader2, new DfsPackFile$$ExternalSyntheticLambda0(readableChannel));
            int i = (int) (j2 - orLoad.start);
            if (orLoad.size() <= i) {
                throw packfileIsTruncated();
            }
            int iMin = (int) Math.min(orLoad.size() - i, j);
            orLoad.write(packOutputStream, j2, iMin);
            long j3 = iMin;
            j2 += j3;
            j -= j3;
            dfsReader = dfsReader2;
        }
    }

    private long copyPackBypassCache(PackOutputStream packOutputStream, ReadableChannel readableChannel) throws IOException {
        ByteBuffer byteBufferNewCopyBuffer = newCopyBuffer(packOutputStream, readableChannel);
        long j = this.length - 32;
        long j2 = 12;
        boolean z = false;
        while (0 < j) {
            DfsBlock dfsBlock = (DfsBlock) this.cache.get(this.key, alignToBlock(j2));
            if (dfsBlock != null) {
                int i = (int) (j2 - dfsBlock.start);
                if (dfsBlock.size() <= i) {
                    throw packfileIsTruncated();
                }
                int iMin = (int) Math.min(dfsBlock.size() - i, j);
                dfsBlock.write(packOutputStream, j2, iMin);
                long j3 = iMin;
                j2 += j3;
                j -= j3;
                readableChannel.position(j2);
            } else {
                int i2 = z ? 0 : 12;
                int i3 = read(readableChannel, byteBufferNewCopyBuffer);
                if (i3 <= i2) {
                    throw packfileIsTruncated();
                }
                int iMin2 = (int) Math.min(i3 - i2, j);
                packOutputStream.write(byteBufferNewCopyBuffer.array(), i2, iMin2);
                long j4 = iMin2;
                j2 += j4;
                j -= j4;
            }
            z = true;
        }
        return j2;
    }

    private ByteBuffer newCopyBuffer(PackOutputStream packOutputStream, ReadableChannel readableChannel) {
        int iBlockSize = blockSize(readableChannel);
        byte[] copyBuffer = packOutputStream.getCopyBuffer();
        if (iBlockSize > copyBuffer.length) {
            copyBuffer = new byte[iBlockSize];
        }
        return ByteBuffer.wrap(copyBuffer, 0, iBlockSize);
    }

    /* WARN: Code duplicated, block: B:131:0x0137 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* WARN: Code duplicated, block: B:58:0x012e  */
    /* WARN: Code duplicated, block: B:62:0x0141  */
    /* WARN: Code duplicated, block: B:64:0x014e  */
    /* WARN: Code duplicated, block: B:74:0x0195 A[Catch: IOException -> 0x01d4, DataFormatException -> 0x01d9, TRY_ENTER, TryCatch #6 {IOException -> 0x01d4, DataFormatException -> 0x01d9, blocks: (B:60:0x0137, B:74:0x0195, B:75:0x01b9), top: B:131:0x0137 }] */
    /* WARN: Code duplicated, block: B:78:0x01d2 A[LOOP:5: B:75:0x01b9->B:78:0x01d2, LOOP_END] */
    /* WARN: Code duplicated, block: B:83:0x01de  */
    void copyAsIs(PackOutputStream packOutputStream, DfsObjectToPack dfsObjectToPack, boolean z, DfsReader dfsReader) throws StoredObjectRepresentationNotAvailableException, IOException {
        byte[] bArr;
        long j;
        CRC32 crc32;
        long value;
        byte[] bArr2;
        DfsBlock dfsBlock;
        long j2;
        long j3;
        DfsPackFile dfsPackFile;
        Inflater inflater;
        byte[] bArr3;
        byte[] bArr4;
        DfsBlock dfsBlock2;
        long j4;
        long j5;
        Inflater inflater2;
        byte[] bArr5;
        int i;
        int i2;
        CRC32 crc33 = z ? new CRC32() : null;
        CRC32 crc34 = z ? new CRC32() : null;
        byte[] copyBuffer = packOutputStream.getCopyBuffer();
        try {
            try {
                readFully(dfsObjectToPack.offset, copyBuffer, 0, 20, dfsReader);
                int i3 = 0;
                byte b = copyBuffer[0];
                int i4 = b & 255;
                int i5 = 7;
                int i6 = (i4 >> 4) & 7;
                long j6 = b & Ascii.SI;
                int i7 = 4;
                long j7 = j6;
                int i8 = 1;
                while ((i4 & 128) != 0) {
                    CRC32 crc35 = crc34;
                    int i9 = i3;
                    int i10 = i8 + 1;
                    byte b2 = copyBuffer[i8];
                    int i11 = i5;
                    long j8 = (((long) (b2 & 127)) << i7) + j7;
                    i7 += i11;
                    i4 = b2 & 255;
                    i3 = i9;
                    j7 = j8;
                    i5 = i11;
                    copyBuffer = copyBuffer;
                    i8 = i10;
                    crc34 = crc35;
                }
                if (i6 == 6) {
                    while (true) {
                        i2 = i8 + 1;
                        if ((copyBuffer[i8] & 128) == 0) {
                            break;
                        } else {
                            i8 = i2;
                        }
                    }
                    if (z) {
                        crc33.update(copyBuffer, i3, i2);
                        crc34.update(copyBuffer, i3, i2);
                    }
                    i8 = i2;
                    bArr = copyBuffer;
                } else if (i6 == i5) {
                    if (z) {
                        crc33.update(copyBuffer, i3, i8);
                        crc34.update(copyBuffer, i3, i8);
                    }
                    readFully(((long) i8) + dfsObjectToPack.offset, copyBuffer, 0, 20, dfsReader);
                    bArr = copyBuffer;
                    if (z) {
                        crc33.update(bArr, i3, 20);
                        crc34.update(bArr, i3, 20);
                    }
                    i8 += 20;
                } else {
                    bArr = copyBuffer;
                    if (z) {
                        crc33.update(bArr, i3, i8);
                        crc34.update(bArr, i3, i8);
                    }
                }
                long j9 = ((long) i8) + dfsObjectToPack.offset;
                long j10 = dfsObjectToPack.length;
                DfsPackFile dfsPackFile2 = this;
                try {
                    DfsBlock dfsBlockQuickCopy = dfsReader.quickCopy(dfsPackFile2, j9, j10);
                    DfsReader dfsReader2 = dfsReader;
                    DfsPackFile dfsPackFile3 = dfsPackFile2;
                    long j11 = j9;
                    if (z) {
                        try {
                            if (dfsPackFile3.idx(dfsReader2).hasCRC32Support()) {
                                long jFindCRC32 = dfsPackFile3.idx(dfsReader2).findCRC32(dfsObjectToPack);
                                if (dfsBlockQuickCopy != null) {
                                    dfsBlockQuickCopy.crc32(crc33, j11, (int) j10);
                                    j = j10;
                                } else {
                                    j = j10;
                                    long j12 = j11;
                                    long j13 = j;
                                    while (j13 > 0) {
                                        long j14 = j11;
                                        int iMin = (int) Math.min(j13, bArr.length);
                                        long j15 = j13;
                                        long j16 = j;
                                        DfsPackFile dfsPackFile4 = dfsPackFile3;
                                        byte[] bArr6 = bArr;
                                        dfsPackFile4.readFully(j12, bArr6, 0, iMin, dfsReader2);
                                        crc33.update(bArr6, 0, iMin);
                                        long j17 = iMin;
                                        j12 += j17;
                                        dfsPackFile3 = dfsPackFile4;
                                        j11 = j14;
                                        j = j16;
                                        j13 = j15 - j17;
                                        bArr = bArr6;
                                        dfsReader2 = dfsReader;
                                    }
                                }
                                if (crc33.getValue() != jFindCRC32) {
                                    dfsPackFile3.setCorrupt(dfsObjectToPack.offset);
                                    throw new CorruptObjectException(MessageFormat.format(JGitText.get().objectAtHasBadZlibStream, Long.valueOf(dfsObjectToPack.offset), dfsPackFile3.getFileName()));
                                }
                                crc32 = crc34;
                                value = jFindCRC32;
                                bArr2 = bArr;
                                dfsBlock = dfsBlockQuickCopy;
                                j2 = j;
                                j3 = j11;
                                throw new StoredObjectRepresentationNotAvailableException(e);
                            }
                            dfsPackFile = dfsPackFile3;
                            bArr2 = bArr;
                            j7 = j7;
                            j2 = j10;
                            if (z) {
                                try {
                                    inflater = dfsReader.inflater();
                                    bArr3 = new byte[1024];
                                    if (dfsBlockQuickCopy != null) {
                                        dfsBlockQuickCopy.check(inflater, bArr3, j11, (int) j2);
                                        j3 = j11;
                                        dfsBlock2 = dfsBlockQuickCopy;
                                    } else {
                                        bArr4 = bArr3;
                                        j3 = j11;
                                        dfsBlock2 = dfsBlockQuickCopy;
                                        j4 = j2;
                                        j5 = j3;
                                        while (j4 > 0) {
                                            int iMin2 = (int) Math.min(j4, bArr2.length);
                                            long j18 = j4;
                                            inflater2 = inflater;
                                            CRC32 crc36 = crc34;
                                            bArr5 = bArr4;
                                            DfsBlock dfsBlock3 = dfsBlock2;
                                            readFully(j5, bArr2, 0, iMin2, dfsReader);
                                            crc33.update(bArr2, 0, iMin2);
                                            inflater2.setInput(bArr2, 0, iMin2);
                                            for (i = 0; inflater2.inflate(bArr5, i, 1024) > 0; i = 0) {
                                            }
                                            long j19 = iMin2;
                                            j5 += j19;
                                            bArr4 = bArr5;
                                            j4 = j18 - j19;
                                            dfsBlock2 = dfsBlock3;
                                            inflater = inflater2;
                                            crc34 = crc36;
                                            dfsPackFile = this;
                                        }
                                    }
                                    if (inflater.finished() || inflater.getBytesRead() != j2) {
                                        dfsPackFile.setCorrupt(dfsObjectToPack.offset);
                                        throw new EOFException(MessageFormat.format(JGitText.get().shortCompressedStreamAt, Long.valueOf(dfsObjectToPack.offset)));
                                    }
                                    crc32 = crc34;
                                    value = crc33.getValue();
                                    dfsBlock = dfsBlock2;
                                } catch (IOException e) {
                                    e = e;
                                } catch (DataFormatException e2) {
                                    e = e2;
                                    dfsPackFile2 = this;
                                    dfsPackFile2.setCorrupt(dfsObjectToPack.offset);
                                    throw new StoredObjectRepresentationNotAvailableException(new CorruptObjectException(MessageFormat.format(JGitText.get().objectAtHasBadZlibStream, Long.valueOf(dfsObjectToPack.offset), dfsPackFile2.getFileName()), e));
                                }
                            } else {
                                crc32 = crc34;
                                dfsBlock = dfsBlockQuickCopy;
                                j3 = j11;
                                value = -1;
                            }
                        } catch (IOException e3) {
                            e = e3;
                        } catch (DataFormatException e4) {
                            e = e4;
                            dfsPackFile2 = dfsPackFile3;
                            dfsPackFile2.setCorrupt(dfsObjectToPack.offset);
                            throw new StoredObjectRepresentationNotAvailableException(new CorruptObjectException(MessageFormat.format(JGitText.get().objectAtHasBadZlibStream, Long.valueOf(dfsObjectToPack.offset), dfsPackFile2.getFileName()), e));
                        }
                    } else {
                        dfsPackFile = dfsPackFile3;
                        bArr2 = bArr;
                        j7 = j7;
                        j2 = j10;
                        if (z) {
                            inflater = dfsReader.inflater();
                            bArr3 = new byte[1024];
                            if (dfsBlockQuickCopy != null) {
                                dfsBlockQuickCopy.check(inflater, bArr3, j11, (int) j2);
                                j3 = j11;
                                dfsBlock2 = dfsBlockQuickCopy;
                            } else {
                                bArr4 = bArr3;
                                j3 = j11;
                                dfsBlock2 = dfsBlockQuickCopy;
                                j4 = j2;
                                j5 = j3;
                                while (j4 > 0) {
                                    int iMin3 = (int) Math.min(j4, bArr2.length);
                                    long j110 = j4;
                                    inflater2 = inflater;
                                    CRC32 crc37 = crc34;
                                    bArr5 = bArr4;
                                    DfsBlock dfsBlock4 = dfsBlock2;
                                    readFully(j5, bArr2, 0, iMin3, dfsReader);
                                    crc33.update(bArr2, 0, iMin3);
                                    inflater2.setInput(bArr2, 0, iMin3);
                                    while (inflater2.inflate(bArr5, i, 1024) > 0) {
                                    }
                                    long j111 = iMin3;
                                    j5 += j111;
                                    bArr4 = bArr5;
                                    j4 = j110 - j111;
                                    dfsBlock2 = dfsBlock4;
                                    inflater = inflater2;
                                    crc34 = crc37;
                                    dfsPackFile = this;
                                }
                            }
                            if (inflater.finished()) {
                            }
                            dfsPackFile.setCorrupt(dfsObjectToPack.offset);
                            throw new EOFException(MessageFormat.format(JGitText.get().shortCompressedStreamAt, Long.valueOf(dfsObjectToPack.offset)));
                        }
                        crc32 = crc34;
                        dfsBlock = dfsBlockQuickCopy;
                        j3 = j11;
                        value = -1;
                    }
                    if (dfsBlock != null) {
                        packOutputStream.writeHeader(dfsObjectToPack, j7);
                        dfsBlock.write(packOutputStream, j3, (int) j2);
                        return;
                    }
                    long j20 = j7;
                    if (j2 <= bArr2.length) {
                        if (!z) {
                            long j21 = j2;
                            long j22 = j3;
                            while (j21 > 0) {
                                int iMin4 = (int) Math.min(j21, bArr2.length);
                                long j23 = j20;
                                readFully(j22, bArr2, 0, iMin4, dfsReader);
                                long j24 = iMin4;
                                j22 += j24;
                                j21 -= j24;
                                j20 = j23;
                            }
                        }
                        packOutputStream.writeHeader(dfsObjectToPack, j20);
                        packOutputStream.write(bArr2, 0, (int) j2);
                        return;
                    }
                    packOutputStream.writeHeader(dfsObjectToPack, j20);
                    long j25 = j3;
                    while (j2 > 0) {
                        int iMin5 = (int) Math.min(j2, bArr2.length);
                        readFully(j25, bArr2, 0, iMin5, dfsReader);
                        CRC32 crc38 = crc32;
                        if (z) {
                            crc38.update(bArr2, 0, iMin5);
                        }
                        packOutputStream.write(bArr2, 0, iMin5);
                        long j26 = iMin5;
                        j25 += j26;
                        j2 -= j26;
                        crc32 = crc38;
                    }
                    if (z && crc32.getValue() != value) {
                        throw new CorruptObjectException(MessageFormat.format(JGitText.get().objectAtHasBadZlibStream, Long.valueOf(dfsObjectToPack.offset), getFileName()));
                    }
                } catch (IOException e5) {
                    e = e5;
                } catch (DataFormatException e6) {
                    e = e6;
                }
            } catch (IOException e7) {
                e = e7;
                throw new StoredObjectRepresentationNotAvailableException(e);
            }
        } catch (IOException e8) {
            e = e8;
        }
    }

    private IOException packfileIsTruncated() {
        this.invalid = true;
        IOException iOException = new IOException(MessageFormat.format(JGitText.get().packfileIsTruncated, getFileName()));
        this.invalidatingCause = iOException;
        return iOException;
    }

    private void readFully(long j, byte[] bArr, int i, int i2, DfsReader dfsReader) throws IOException {
        long j2 = j;
        int i3 = i;
        int i4 = i2;
        while (i4 > 0) {
            byte[] bArr2 = bArr;
            DfsReader dfsReader2 = dfsReader;
            int iCopy = dfsReader2.copy(this, j2, bArr2, i3, i4);
            if (iCopy == 0) {
                throw new EOFException();
            }
            j2 += (long) iCopy;
            i3 += iCopy;
            i4 -= iCopy;
            dfsReader = dfsReader2;
            bArr = bArr2;
        }
    }

    /* WARN: Code duplicated, block: B:136:0x0160 A[SYNTHETIC] */
    /* WARN: Code duplicated, block: B:137:0x0151 A[SYNTHETIC] */
    /* WARN: Code duplicated, block: B:138:0x0166 A[SYNTHETIC] */
    /* WARN: Code duplicated, block: B:54:0x0116  */
    /* WARN: Code duplicated, block: B:56:0x011d  */
    /* WARN: Code duplicated, block: B:57:0x011f A[Catch: DataFormatException -> 0x01c0, TryCatch #5 {DataFormatException -> 0x01c0, blocks: (B:60:0x012e, B:62:0x013c, B:66:0x0148, B:67:0x014a, B:69:0x0151, B:73:0x015a, B:74:0x015f, B:75:0x0160, B:76:0x0165, B:77:0x0166, B:78:0x016b, B:57:0x011f, B:59:0x0123, B:79:0x016c, B:80:0x0171, B:40:0x00bd, B:43:0x00ca, B:45:0x00d6, B:48:0x00e3, B:51:0x010a, B:81:0x0172, B:83:0x017b, B:85:0x0184, B:87:0x018a, B:96:0x01a8), top: B:118:0x00bd, inners: #1 }] */
    /* WARN: Code duplicated, block: B:59:0x0123 A[Catch: DataFormatException -> 0x01c0, TryCatch #5 {DataFormatException -> 0x01c0, blocks: (B:60:0x012e, B:62:0x013c, B:66:0x0148, B:67:0x014a, B:69:0x0151, B:73:0x015a, B:74:0x015f, B:75:0x0160, B:76:0x0165, B:77:0x0166, B:78:0x016b, B:57:0x011f, B:59:0x0123, B:79:0x016c, B:80:0x0171, B:40:0x00bd, B:43:0x00ca, B:45:0x00d6, B:48:0x00e3, B:51:0x010a, B:81:0x0172, B:83:0x017b, B:85:0x0184, B:87:0x018a, B:96:0x01a8), top: B:118:0x00bd, inners: #1 }] */
    /* WARN: Code duplicated, block: B:62:0x013c A[Catch: DataFormatException -> 0x01c0, TRY_LEAVE, TryCatch #5 {DataFormatException -> 0x01c0, blocks: (B:60:0x012e, B:62:0x013c, B:66:0x0148, B:67:0x014a, B:69:0x0151, B:73:0x015a, B:74:0x015f, B:75:0x0160, B:76:0x0165, B:77:0x0166, B:78:0x016b, B:57:0x011f, B:59:0x0123, B:79:0x016c, B:80:0x0171, B:40:0x00bd, B:43:0x00ca, B:45:0x00d6, B:48:0x00e3, B:51:0x010a, B:81:0x0172, B:83:0x017b, B:85:0x0184, B:87:0x018a, B:96:0x01a8), top: B:118:0x00bd, inners: #1 }] */
    /* WARN: Code duplicated, block: B:65:0x0147  */
    /* WARN: Code duplicated, block: B:71:0x0157 A[LOOP:3: B:55:0x011b->B:71:0x0157, LOOP_END] */
    /* WARN: Code duplicated, block: B:79:0x016c A[Catch: DataFormatException -> 0x01c0, TryCatch #5 {DataFormatException -> 0x01c0, blocks: (B:60:0x012e, B:62:0x013c, B:66:0x0148, B:67:0x014a, B:69:0x0151, B:73:0x015a, B:74:0x015f, B:75:0x0160, B:76:0x0165, B:77:0x0166, B:78:0x016b, B:57:0x011f, B:59:0x0123, B:79:0x016c, B:80:0x0171, B:40:0x00bd, B:43:0x00ca, B:45:0x00d6, B:48:0x00e3, B:51:0x010a, B:81:0x0172, B:83:0x017b, B:85:0x0184, B:87:0x018a, B:96:0x01a8), top: B:118:0x00bd, inners: #1 }] */
    ObjectLoader load(DfsReader dfsReader, long j) throws IOException {
        long j2;
        DfsPackFile dfsPackFile;
        DfsReader dfsReader2;
        byte[] bArrDecompress;
        int i;
        Delta delta;
        boolean z;
        byte[] bArr;
        boolean z2;
        byte[] bArrDecompress2;
        long resultSize;
        byte[] bArr2;
        DfsReader dfsReader3 = dfsReader;
        try {
            byte[] bArr3 = dfsReader3.tempId;
            byte[] bArrDecompress3 = null;
            long j3 = j;
            Delta delta2 = null;
            while (true) {
                try {
                    readFully(j3, bArr3, 0, 20, dfsReader3);
                    long j4 = j3;
                    try {
                        byte b = bArr3[0];
                        int i2 = b & 255;
                        int i3 = 7;
                        int i4 = (i2 >> 4) & 7;
                        int i5 = 1;
                        long j5 = b & Ascii.SI;
                        int i6 = 1;
                        int i7 = 4;
                        while ((i2 & 128) != 0) {
                            long j6 = j4;
                            Delta delta3 = delta2;
                            int i8 = i3;
                            long j7 = j5;
                            int i9 = i6;
                            i6 = i9 + 1;
                            byte b2 = bArr3[i9];
                            long j8 = j7 + (((long) (b2 & 127)) << i7);
                            i7 += 7;
                            i2 = b2 & 255;
                            i3 = i8;
                            i5 = 1;
                            j5 = j8;
                            delta2 = delta3;
                            j4 = j6;
                        }
                        if (i4 == i5 || i4 == 2 || i4 == 3 || i4 == 4) {
                            long j9 = j4;
                            Delta delta4 = delta2;
                            dfsPackFile = this;
                            dfsReader2 = dfsReader;
                            long j10 = j5;
                            if (delta4 == null) {
                                if (j10 < dfsReader2.getStreamFileThreshold() && (bArrDecompress = dfsPackFile.decompress(((long) i6) + j9, (int) j10, dfsReader2)) != null) {
                                    return new ObjectLoader.SmallObject(i4, bArrDecompress);
                                }
                                try {
                                    return new LargePackedWholeObject(i4, j10, j9, i6, dfsPackFile, dfsReader2.db);
                                } catch (DataFormatException e) {
                                    e = e;
                                    j2 = j9;
                                    throw new CorruptObjectException(MessageFormat.format(JGitText.get().objectAtHasBadZlibStream, Long.valueOf(j2), getFileName()), e);
                                }
                            }
                            bArrDecompress3 = dfsPackFile.decompress(((long) i6) + j9, (int) j10, dfsReader2);
                            i = i4;
                            delta = delta4;
                            z = false;
                            if (bArrDecompress3 != null) {
                                throw new LargeObjectException();
                            }
                            boolean z3 = z;
                            bArr = bArrDecompress3;
                            z2 = z3;
                            while (true) {
                                if (z2) {
                                    z2 = false;
                                } else if (delta.next == null) {
                                    dfsReader2.getDeltaBaseCache().put(dfsPackFile.key, delta.basePos, i, bArr);
                                }
                                j2 = delta.deltaPos;
                                bArrDecompress2 = dfsPackFile.decompress(((long) delta.hdrLen) + j2, delta.deltaSize, dfsReader2);
                                if (bArrDecompress2 != null) {
                                    throw new LargeObjectException();
                                }
                                resultSize = BinaryDelta.getResultSize(bArrDecompress2);
                                if (2147483647L > resultSize) {
                                    throw new LargeObjectException.ExceedsByteArrayLimit();
                                }
                                try {
                                    bArr2 = new byte[(int) resultSize];
                                    BinaryDelta.apply(bArr, bArrDecompress2, bArr2);
                                    delta = delta.next;
                                    if (delta == null) {
                                        return new ObjectLoader.SmallObject(i, bArr2);
                                    }
                                    bArr = bArr2;
                                } catch (OutOfMemoryError e2) {
                                    throw new LargeObjectException.OutOfMemory(e2);
                                }
                            }
                        } else {
                            if (i4 == 6) {
                                dfsPackFile = this;
                                dfsReader2 = dfsReader;
                                Delta delta5 = delta2;
                                long j11 = j5;
                                int i10 = i6 + 1;
                                byte b3 = bArr3[i6];
                                int i11 = b3 & 255;
                                long j12 = b3 & 127;
                                while ((i11 & 128) != 0) {
                                    long j13 = j4;
                                    int i12 = i10;
                                    Delta delta6 = delta5;
                                    i10 = i12 + 1;
                                    byte b4 = bArr3[i12];
                                    int i13 = b4 & 255;
                                    j12 = ((j12 + 1) << i3) + ((long) (b4 & 127));
                                    delta5 = delta6;
                                    i3 = i3;
                                    i11 = i13;
                                    j4 = j13;
                                }
                                long j14 = j4 - j12;
                                j2 = j4;
                                try {
                                    delta = new Delta(delta5, j2, (int) j11, i10, j14);
                                    if (j11 != delta.deltaSize) {
                                        i = -1;
                                        z = false;
                                    } else {
                                        DeltaBaseCache.Entry entry = dfsReader2.getDeltaBaseCache().get(dfsPackFile.key, j14);
                                        if (entry != null) {
                                            i = entry.type;
                                            bArrDecompress3 = entry.data;
                                            z = true;
                                        } else {
                                            dfsReader3 = dfsReader2;
                                            delta2 = delta;
                                            j3 = j14;
                                        }
                                    }
                                } catch (DataFormatException e3) {
                                    e = e3;
                                    throw new CorruptObjectException(MessageFormat.format(JGitText.get().objectAtHasBadZlibStream, Long.valueOf(j2), getFileName()), e);
                                }
                            } else if (i4 == i3) {
                                dfsPackFile = this;
                                dfsPackFile.readFully(j4 + ((long) i6), bArr3, 0, 20, dfsReader);
                                dfsReader2 = dfsReader;
                                long jFindDeltaBase = dfsPackFile.findDeltaBase(dfsReader2, ObjectId.fromRaw(bArr3));
                                j2 = j4;
                                long j15 = j5;
                                try {
                                    delta = new Delta(delta2, j2, (int) j5, i6 + 20, jFindDeltaBase);
                                    if (j15 != delta.deltaSize) {
                                        i = -1;
                                        z = false;
                                    } else {
                                        DeltaBaseCache.Entry entry2 = dfsReader2.getDeltaBaseCache().get(dfsPackFile.key, jFindDeltaBase);
                                        if (entry2 != null) {
                                            i = entry2.type;
                                            bArrDecompress3 = entry2.data;
                                            z = true;
                                        } else {
                                            dfsReader3 = dfsReader2;
                                            j3 = jFindDeltaBase;
                                            delta2 = delta;
                                        }
                                    }
                                } catch (DataFormatException e4) {
                                    e = e4;
                                    throw new CorruptObjectException(MessageFormat.format(JGitText.get().objectAtHasBadZlibStream, Long.valueOf(j2), getFileName()), e);
                                }
                            } else {
                                throw new IOException(MessageFormat.format(JGitText.get().unknownObjectType, Integer.valueOf(i4)));
                            }
                            if (bArrDecompress3 != null) {
                                throw new LargeObjectException();
                            }
                            boolean z4 = z;
                            bArr = bArrDecompress3;
                            z2 = z4;
                            while (true) {
                                if (z2) {
                                    z2 = false;
                                } else if (delta.next == null) {
                                    dfsReader2.getDeltaBaseCache().put(dfsPackFile.key, delta.basePos, i, bArr);
                                }
                                j2 = delta.deltaPos;
                                bArrDecompress2 = dfsPackFile.decompress(((long) delta.hdrLen) + j2, delta.deltaSize, dfsReader2);
                                if (bArrDecompress2 != null) {
                                    throw new LargeObjectException();
                                }
                                resultSize = BinaryDelta.getResultSize(bArrDecompress2);
                                if (2147483647L > resultSize) {
                                    throw new LargeObjectException.ExceedsByteArrayLimit();
                                }
                                bArr2 = new byte[(int) resultSize];
                                BinaryDelta.apply(bArr, bArrDecompress2, bArr2);
                                delta = delta.next;
                                if (delta == null) {
                                    return new ObjectLoader.SmallObject(i, bArr2);
                                }
                                bArr = bArr2;
                            }
                        }
                    } catch (DataFormatException e5) {
                        e = e5;
                        j2 = j4;
                    }
                } catch (DataFormatException e6) {
                    e = e6;
                    j2 = j3;
                }
            }
        } catch (DataFormatException e7) {
            e = e7;
            j2 = j;
        }
    }

    private long findDeltaBase(DfsReader dfsReader, ObjectId objectId) throws IOException {
        long jFindOffset = idx(dfsReader).findOffset(objectId);
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

    byte[] getDeltaHeader(DfsReader dfsReader, long j) throws DataFormatException, IOException {
        byte[] bArr = new byte[32];
        dfsReader.inflate(this, j, bArr, true);
        return bArr;
    }

    int getObjectType(DfsReader dfsReader, long j) throws IOException {
        int i;
        byte[] bArr;
        byte[] bArr2 = dfsReader.tempId;
        long jFindDeltaBase = j;
        while (true) {
            DfsReader dfsReader2 = dfsReader;
            readFully(jFindDeltaBase, bArr2, 0, 20, dfsReader2);
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
                readFully(jFindDeltaBase + ((long) i3), bArr2, 0, 20, dfsReader2);
                bArr = bArr2;
                jFindDeltaBase = findDeltaBase(dfsReader2, ObjectId.fromRaw(bArr));
            } else {
                throw new IOException(MessageFormat.format(JGitText.get().unknownObjectType, Integer.valueOf(i)));
            }
            bArr2 = bArr;
            dfsReader = dfsReader2;
        }
        return i;
    }

    long getObjectSize(DfsReader dfsReader, AnyObjectId anyObjectId) throws IOException {
        long jFindOffset = idx(dfsReader).findOffset(anyObjectId);
        if (0 < jFindOffset) {
            return getObjectSize(dfsReader, jFindOffset);
        }
        return -1L;
    }

    long getObjectSize(DfsReader dfsReader, long j) throws IOException {
        long j2;
        byte[] bArr = dfsReader.tempId;
        readFully(j, bArr, 0, 20, dfsReader);
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
            return BinaryDelta.getResultSize(getDeltaHeader(dfsReader, j2));
        } catch (DataFormatException e) {
            throw new CorruptObjectException(MessageFormat.format(JGitText.get().objectAtHasBadZlibStream, Long.valueOf(j), getFileName()), e);
        }
    }

    boolean hasObjectSizeIndex(DfsReader dfsReader) throws IOException {
        return getObjectSizeIndex(dfsReader) != null;
    }

    int getObjectSizeIndexThreshold(DfsReader dfsReader) throws IOException {
        PackObjectSizeIndex objectSizeIndex = getObjectSizeIndex(dfsReader);
        if (objectSizeIndex == null) {
            throw new IOException("Asking threshold of non-existing obj-size");
        }
        return objectSizeIndex.getThreshold();
    }

    long getIndexedObjectSize(DfsReader dfsReader, AnyObjectId anyObjectId) throws IOException {
        int iFindPosition = idx(dfsReader).findPosition(anyObjectId);
        if (iFindPosition < 0) {
            throw new IllegalArgumentException("Cannot get size from index since object is not in pack");
        }
        PackObjectSizeIndex objectSizeIndex = getObjectSizeIndex(dfsReader);
        if (objectSizeIndex == null) {
            throw new IllegalStateException("Asking indexed size from a pack without object size index");
        }
        return objectSizeIndex.getSize(iFindPosition);
    }

    void representation(DfsObjectRepresentation dfsObjectRepresentation, long j, DfsReader dfsReader, PackReverseIndex packReverseIndex) throws IOException {
        dfsObjectRepresentation.offset = j;
        byte[] bArr = dfsReader.tempId;
        readFully(j, bArr, 0, 20, dfsReader);
        int i = bArr[0] & 255;
        int i2 = 7;
        int i3 = (i >> 4) & 7;
        int i4 = 1;
        while ((i & 128) != 0) {
            int i5 = bArr[i4] & 255;
            i4++;
            i = i5;
            i2 = 7;
        }
        long jFindNextOffset = packReverseIndex.findNextOffset(j, this.length - 20) - j;
        if (i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4) {
            dfsObjectRepresentation.format = 1;
            dfsObjectRepresentation.baseId = null;
            dfsObjectRepresentation.length = jFindNextOffset - ((long) i4);
            return;
        }
        if (i3 != 6) {
            if (i3 == i2) {
                long j2 = i4;
                readFully(j + j2, bArr, 0, 20, dfsReader);
                dfsObjectRepresentation.format = 0;
                dfsObjectRepresentation.baseId = ObjectId.fromRaw(bArr);
                dfsObjectRepresentation.length = (jFindNextOffset - j2) - 20;
                return;
            }
            throw new IOException(MessageFormat.format(JGitText.get().unknownObjectType, Integer.valueOf(i3)));
        }
        int i6 = i4 + 1;
        byte b = bArr[i4];
        int i7 = b & 255;
        long j3 = b & 127;
        while ((i7 & 128) != 0) {
            int i8 = i6 + 1;
            byte b2 = bArr[i6];
            int i9 = b2 & 255;
            j3 = ((j3 + 1) << i2) + ((long) (b2 & 127));
            i6 = i8;
            i7 = i9;
            i2 = 7;
        }
        dfsObjectRepresentation.format = 0;
        dfsObjectRepresentation.baseId = packReverseIndex.findObject(j - j3);
        dfsObjectRepresentation.length = jFindNextOffset - ((long) i6);
    }

    boolean isCorrupt(long j) {
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
            synchronized (this.corruptObjectsLock) {
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

    private DfsBlockCache.Ref<PackObjectSizeIndex> loadObjectSizeIndex(DfsReader dfsReader, DfsStreamKey dfsStreamKey) throws Throwable {
        Throwable th;
        long jPosition;
        dfsReader.stats.readObjectSizeIndex++;
        long jNanoTime = System.nanoTime();
        Throwable th2 = null;
        try {
            ReadableChannel readableChannelOpenFile = dfsReader.db.openFile(this.desc, PackExt.OBJECT_SIZE_INDEX);
            try {
                try {
                    this.objectSizeIndex = PackObjectSizeIndexLoader.load(Channels.newInputStream(readableChannelOpenFile));
                    jPosition = readableChannelOpenFile.position();
                    e = null;
                } catch (Throwable th3) {
                    th = th3;
                    if (0 == 0) {
                        throw th;
                    }
                    if (null != th) {
                        try {
                            th2.addSuppressed(th);
                        } catch (IOException unused) {
                            return new DfsBlockCache.Ref<>(dfsStreamKey, 0L, 0L, null);
                        }
                    }
                    throw null;
                }
            } catch (IOException e) {
                e = e;
                jPosition = 0;
            } catch (Throwable th4) {
                if (readableChannelOpenFile == null) {
                    throw th4;
                }
                readableChannelOpenFile.close();
                throw th4;
            }
            long j = jPosition;
            if (readableChannelOpenFile != null) {
                readableChannelOpenFile.close();
            }
            if (e != null) {
                throw new IOException(MessageFormat.format(DfsText.get().shortReadOfIndex, this.desc.getFileName(PackExt.OBJECT_SIZE_INDEX)), e);
            }
            dfsReader.stats.readObjectSizeIndexBytes += j;
            dfsReader.stats.readObjectSizeIndexMicros += elapsedMicros(jNanoTime);
            return new DfsBlockCache.Ref<>(dfsStreamKey, 0L, j, this.objectSizeIndex);
        } catch (Throwable th5) {
            th = th5;
        }
    }

    private DfsBlockCache.Ref<PackBitmapIndex> loadBitmapIndex(DfsReader dfsReader, DfsStreamKey dfsStreamKey) throws IOException {
        dfsReader.stats.readBitmap++;
        long jNanoTime = System.nanoTime();
        PackBitmapIndexLoader.LoadResult loadResultLoadPackBitmapIndex = this.bitmapLoader.loadPackBitmapIndex(dfsReader, this);
        this.bitmapIndex = loadResultLoadPackBitmapIndex.bitmapIndex;
        dfsReader.stats.readBitmapIdxBytes += loadResultLoadPackBitmapIndex.bytesRead;
        dfsReader.stats.readBitmapIdxMicros += elapsedMicros(jNanoTime);
        return new DfsBlockCache.Ref<>(dfsStreamKey, 0L, loadResultLoadPackBitmapIndex.bytesRead, loadResultLoadPackBitmapIndex.bitmapIndex);
    }

    private DfsBlockCache.Ref<CommitGraph> loadCommitGraph(DfsReader dfsReader, DfsStreamKey dfsStreamKey) throws IOException {
        dfsReader.stats.readCommitGraph++;
        long jNanoTime = System.nanoTime();
        boolean z = dfsReader.db.getRepository().getConfig().getBoolean("commitGraph", ConfigConstants.CONFIG_KEY_READ_CHANGED_PATHS, false);
        Throwable th = null;
        try {
            ReadableChannel readableChannelOpenFile = dfsReader.db.openFile(this.desc, PackExt.COMMIT_GRAPH);
            try {
                try {
                    CommitGraph commitGraph = CommitGraphLoader.read(alignTo8kBlocks(readableChannelOpenFile), z);
                    long jPosition = readableChannelOpenFile.position();
                    dfsReader.stats.readCommitGraphBytes += jPosition;
                    dfsReader.stats.readCommitGraphMicros += elapsedMicros(jNanoTime);
                    this.commitGraph = commitGraph;
                    DfsBlockCache.Ref<CommitGraph> ref = new DfsBlockCache.Ref<>(dfsStreamKey, 0L, jPosition, commitGraph);
                    if (readableChannelOpenFile != null) {
                        readableChannelOpenFile.close();
                    }
                    return ref;
                } catch (Throwable th2) {
                    if (readableChannelOpenFile == null) {
                        throw th2;
                    }
                    readableChannelOpenFile.close();
                    throw th2;
                }
            } catch (Throwable th3) {
                dfsReader.stats.readCommitGraphBytes += readableChannelOpenFile.position();
                dfsReader.stats.readCommitGraphMicros += elapsedMicros(jNanoTime);
                throw th3;
            }
        } catch (Throwable th4) {
            if (0 == 0) {
                throw th4;
            }
            if (null != th4) {
                try {
                    th.addSuppressed(th4);
                } catch (IOException e) {
                    throw new IOException(MessageFormat.format(DfsText.get().cannotReadCommitGraph, this.desc.getFileName(PackExt.COMMIT_GRAPH)), e);
                }
            }
            throw null;
        }
    }

    /* INFO: Access modifiers changed from: private */
    public static InputStream alignTo8kBlocks(ReadableChannel readableChannel) {
        InputStream inputStreamNewInputStream = Channels.newInputStream(readableChannel);
        int iBlockSize = readableChannel.blockSize();
        if (iBlockSize > 0 && iBlockSize < 8192) {
            iBlockSize *= 8192 / iBlockSize;
        } else if (iBlockSize <= 0) {
            iBlockSize = 8192;
        }
        return new BufferedInputStream(inputStreamNewInputStream, iBlockSize);
    }

    public interface PackBitmapIndexLoader {
        boolean hasBitmaps(DfsPackDescription dfsPackDescription);

        boolean keepInDfs(DfsPackDescription dfsPackDescription);

        LoadResult loadPackBitmapIndex(DfsReader dfsReader, DfsPackFile dfsPackFile) throws IOException;

        public static class LoadResult {
            public final PackBitmapIndex bitmapIndex;
            public final long bytesRead;

            public LoadResult(PackBitmapIndex packBitmapIndex, long j) {
                this.bitmapIndex = packBitmapIndex;
                this.bytesRead = j;
            }
        }
    }

    /* INFO: Access modifiers changed from: private */
    static final class StreamPackBitmapIndexLoader implements PackBitmapIndexLoader {
        /* synthetic */ StreamPackBitmapIndexLoader(DfsPackFileIA dfsPackFileIA) {
            this();
        }

        @Override // org.eclipse.jgit.internal.storage.dfs.DfsPackFile.PackBitmapIndexLoader
        public boolean keepInDfs(DfsPackDescription dfsPackDescription) {
            return true;
        }

        private StreamPackBitmapIndexLoader() {
        }

        @Override // org.eclipse.jgit.internal.storage.dfs.DfsPackFile.PackBitmapIndexLoader
        public boolean hasBitmaps(DfsPackDescription dfsPackDescription) {
            return dfsPackDescription.hasFileExt(PackExt.BITMAP_INDEX);
        }

        @Override // org.eclipse.jgit.internal.storage.dfs.DfsPackFile.PackBitmapIndexLoader
        public PackBitmapIndexLoader.LoadResult loadPackBitmapIndex(DfsReader dfsReader, DfsPackFile dfsPackFile) throws IOException {
            DfsPackDescription packDescription = dfsPackFile.getPackDescription();
            Throwable th = null;
            try {
                ReadableChannel readableChannelOpenFile = dfsReader.db.openFile(packDescription, PackExt.BITMAP_INDEX);
                try {
                    try {
                        PackBitmapIndexLoader.LoadResult loadResult = new PackBitmapIndexLoader.LoadResult(PackBitmapIndex.read(DfsPackFile.alignTo8kBlocks(readableChannelOpenFile), new DfsPackFile$StreamPackBitmapIndexLoader$$ExternalSyntheticLambda0(dfsPackFile, dfsReader), new DfsPackFile$StreamPackBitmapIndexLoader$$ExternalSyntheticLambda1(dfsPackFile, dfsReader), dfsReader.getOptions().shouldLoadRevIndexInParallel()), readableChannelOpenFile.position());
                        if (readableChannelOpenFile != null) {
                            readableChannelOpenFile.close();
                        }
                        return loadResult;
                    } catch (Throwable th2) {
                        readableChannelOpenFile.position();
                        throw th2;
                    }
                } catch (Throwable th3) {
                    if (readableChannelOpenFile == null) {
                        throw th3;
                    }
                    readableChannelOpenFile.close();
                    throw th3;
                }
            } catch (Throwable th4) {
                if (0 == 0) {
                    throw th4;
                }
                if (null != th4) {
                    try {
                        th.addSuppressed(th4);
                    } catch (EOFException e) {
                        throw new IOException(MessageFormat.format(DfsText.get().shortReadOfIndex, packDescription.getFileName(PackExt.BITMAP_INDEX)), e);
                    } catch (IOException e2) {
                        throw new IOException(MessageFormat.format(DfsText.get().cannotReadIndex, packDescription.getFileName(PackExt.BITMAP_INDEX)), e2);
                    }
                }
                throw null;
            }
        }
    }

    public static final class CachedStreamIndexFactory implements IndexFactory {
        private final CachedStreamPackIndexes indexes;

        public CachedStreamIndexFactory(DfsBlockCache dfsBlockCache, DfsPackDescription dfsPackDescription) {
            this.indexes = new CachedStreamPackIndexes(dfsBlockCache, dfsPackDescription);
        }

        @Override // org.eclipse.jgit.internal.storage.dfs.DfsPackFile.IndexFactory
        public IndexFactory.PackIndexes getPackIndexes() {
            return this.indexes;
        }
    }

    public static final class CachedStreamPackIndexes implements IndexFactory.PackIndexes {
        private final DfsBlockCache cache;
        private final DfsPackDescription desc;

        public CachedStreamPackIndexes(DfsBlockCache dfsBlockCache, DfsPackDescription dfsPackDescription) {
            this.cache = dfsBlockCache;
            this.desc = dfsPackDescription;
        }

        @Override // org.eclipse.jgit.internal.storage.dfs.DfsPackFile.IndexFactory.PackIndexes
        public PackIndex index(DfsReader dfsReader) throws IOException {
            DfsStreamKey streamKey = this.desc.getStreamKey(PackExt.INDEX);
            AtomicReference atomicReference = new AtomicReference(null);
            DfsBlockCache.Ref orLoadRef = this.cache.getOrLoadRef(streamKey, 0L, new DfsPackFile$CachedStreamPackIndexes$$ExternalSyntheticLambda0(this, dfsReader, atomicReference, streamKey));
            if (atomicReference.get() == null) {
                dfsReader.stats.idxCacheHit++;
            }
            return (PackIndex) (orLoadRef.get() != null ? orLoadRef.get() : atomicReference.get());
        }

        /* INFO: renamed from: lambda$0$org-eclipse-jgit-internal-storage-dfs-DfsPackFile$CachedStreamPackIndexes, reason: not valid java name */
        /* synthetic */ DfsBlockCache.Ref m5675x68f10ae(DfsReader dfsReader, AtomicReference atomicReference, DfsStreamKey dfsStreamKey) throws IOException {
            RefWithSize<PackIndex> refWithSizeLoadPackIndex = loadPackIndex(dfsReader, this.desc);
            atomicReference.set(refWithSizeLoadPackIndex.ref);
            return new DfsBlockCache.Ref(dfsStreamKey, 0L, refWithSizeLoadPackIndex.size, refWithSizeLoadPackIndex.ref);
        }

        private static RefWithSize<PackIndex> loadPackIndex(DfsReader dfsReader, DfsPackDescription dfsPackDescription) throws IOException {
            try {
                dfsReader.stats.readIdx++;
                long jNanoTime = System.nanoTime();
                Throwable th = null;
                try {
                    ReadableChannel readableChannelOpenFile = dfsReader.db.openFile(dfsPackDescription, PackExt.INDEX);
                    try {
                        PackIndex packIndex = PackIndex.read(DfsPackFile.alignTo8kBlocks(readableChannelOpenFile));
                        dfsReader.stats.readIdxBytes += readableChannelOpenFile.position();
                        RefWithSize<PackIndex> refWithSize = new RefWithSize<>(packIndex, packIndex.getObjectCount() * 28);
                        if (readableChannelOpenFile != null) {
                            readableChannelOpenFile.close();
                        }
                        dfsReader.stats.readIdxMicros += DfsPackFile.elapsedMicros(jNanoTime);
                        return refWithSize;
                    } catch (Throwable th2) {
                        if (readableChannelOpenFile != null) {
                            readableChannelOpenFile.close();
                        }
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
                    } catch (Throwable th4) {
                        dfsReader.stats.readIdxMicros += DfsPackFile.elapsedMicros(jNanoTime);
                        throw th4;
                    }
                }
            } catch (EOFException e) {
                throw new IOException(MessageFormat.format(DfsText.get().shortReadOfIndex, dfsPackDescription.getFileName(PackExt.INDEX)), e);
            } catch (IOException e2) {
                throw new IOException(MessageFormat.format(DfsText.get().cannotReadIndex, dfsPackDescription.getFileName(PackExt.INDEX)), e2);
            }
        }

        @Override // org.eclipse.jgit.internal.storage.dfs.DfsPackFile.IndexFactory.PackIndexes
        public PackReverseIndex reverseIndex(DfsReader dfsReader) throws IOException {
            PackIndex packIndexIndex = index(dfsReader);
            DfsStreamKey streamKey = this.desc.getStreamKey(PackExt.REVERSE_INDEX);
            AtomicReference atomicReference = new AtomicReference(null);
            DfsBlockCache.Ref orLoadRef = this.cache.getOrLoadRef(streamKey, 0L, new DfsPackFile$CachedStreamPackIndexes$$ExternalSyntheticLambda1(dfsReader, packIndexIndex, atomicReference, streamKey));
            if (atomicReference.get() == null) {
                dfsReader.stats.ridxCacheHit++;
            }
            return (PackReverseIndex) (orLoadRef.get() != null ? orLoadRef.get() : atomicReference.get());
        }

        static /* synthetic */ DfsBlockCache.Ref lambda$1(DfsReader dfsReader, PackIndex packIndex, AtomicReference atomicReference, DfsStreamKey dfsStreamKey) throws IOException {
            RefWithSize<PackReverseIndex> refWithSizeLoadReverseIdx = loadReverseIdx(dfsReader, packIndex);
            atomicReference.set(refWithSizeLoadReverseIdx.ref);
            return new DfsBlockCache.Ref(dfsStreamKey, 0L, refWithSizeLoadReverseIdx.size, refWithSizeLoadReverseIdx.ref);
        }

        private static RefWithSize<PackReverseIndex> loadReverseIdx(DfsReader dfsReader, PackIndex packIndex) {
            dfsReader.stats.readReverseIdx++;
            long jNanoTime = System.nanoTime();
            PackReverseIndex packReverseIndexComputeFromIndex = PackReverseIndexFactory.computeFromIndex(packIndex);
            dfsReader.stats.readReverseIdxMicros += DfsPackFile.elapsedMicros(jNanoTime);
            return new RefWithSize<>(packReverseIndexComputeFromIndex, packIndex.getObjectCount() * 8);
        }
    }

    /* INFO: Access modifiers changed from: private */
    static final class RefWithSize<V> {
        final V ref;
        final long size;

        RefWithSize(V v, long j) {
            this.ref = v;
            this.size = j;
        }
    }
}
