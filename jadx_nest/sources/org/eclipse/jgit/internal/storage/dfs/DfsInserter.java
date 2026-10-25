package org.eclipse.jgit.internal.storage.dfs;

import com.google.common.base.Ascii;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.errors.CorruptObjectException;
import org.eclipse.jgit.errors.IncorrectObjectTypeException;
import org.eclipse.jgit.errors.LargeObjectException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.storage.file.BasePackIndexWriter;
import org.eclipse.jgit.internal.storage.file.PackIndex;
import org.eclipse.jgit.internal.storage.file.PackObjectSizeIndexWriter;
import org.eclipse.jgit.internal.storage.pack.PackExt;
import org.eclipse.jgit.lib.AbbreviatedObjectId;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectIdOwnerMap;
import org.eclipse.jgit.lib.ObjectInserter;
import org.eclipse.jgit.lib.ObjectLoader;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.ObjectStream;
import org.eclipse.jgit.transport.PackedObjectInfo;
import org.eclipse.jgit.util.BlockList;
import org.eclipse.jgit.util.IO;
import org.eclipse.jgit.util.NB;
import org.eclipse.jgit.util.TemporaryBuffer;
import org.eclipse.jgit.util.io.CountingOutputStream;
import org.eclipse.jgit.util.sha1.SHA1;

/* JADX INFO: loaded from: classes5.dex */
public class DfsInserter extends ObjectInserter {
    private static final int INDEX_VERSION = 2;
    DfsBlockCache cache;
    final DfsObjDatabase db;
    private final int minBytesForObjectSizeIndex;
    List<PackedObjectInfo> objectList;
    ObjectIdOwnerMap<PackedObjectInfo> objectMap;
    DfsPackDescription packDsc;
    DfsStreamKey packKey;
    PackStream packOut;
    private boolean rollback;
    int compression = 9;
    private boolean checkExisting = true;

    protected DfsInserter(DfsObjDatabase dfsObjDatabase) {
        this.db = dfsObjDatabase;
        this.minBytesForObjectSizeIndex = dfsObjDatabase.getRepository().getConfig().getInt(ConfigConstants.CONFIG_PACK_SECTION, ConfigConstants.CONFIG_KEY_MIN_BYTES_OBJ_SIZE_INDEX, -1);
    }

    public void checkExisting(boolean z) {
        this.checkExisting = z;
    }

    void setCompressionLevel(int i) {
        this.compression = i;
    }

    @Override // org.eclipse.jgit.lib.ObjectInserter
    public DfsPackParser newPackParser(InputStream inputStream) throws IOException {
        return new DfsPackParser(this.db, this, inputStream);
    }

    @Override // org.eclipse.jgit.lib.ObjectInserter
    public ObjectReader newReader() {
        return new Reader(this, null);
    }

    @Override // org.eclipse.jgit.lib.ObjectInserter
    public ObjectId insert(int i, byte[] bArr, int i2, int i3) throws IOException {
        ObjectId objectIdIdFor = idFor(i, bArr, i2, i3);
        ObjectIdOwnerMap<PackedObjectInfo> objectIdOwnerMap = this.objectMap;
        if ((objectIdOwnerMap != null && objectIdOwnerMap.contains(objectIdIdFor)) || (this.checkExisting && this.db.has(objectIdIdFor, true))) {
            return objectIdIdFor;
        }
        long j = i3;
        long jBeginObject = beginObject(i, j);
        this.packOut.compress.write(bArr, i2, i3);
        this.packOut.compress.finish();
        return endObject(objectIdIdFor, jBeginObject, j, i);
    }

    @Override // org.eclipse.jgit.lib.ObjectInserter
    public ObjectId insert(int i, long j, InputStream inputStream) throws IOException {
        byte[] bArrInsertBuffer = insertBuffer(j);
        if (j <= bArrInsertBuffer.length) {
            int i2 = (int) j;
            IO.readFully(inputStream, bArrInsertBuffer, 0, i2);
            return insert(i, bArrInsertBuffer, 0, i2);
        }
        long jBeginObject = beginObject(i, j);
        SHA1 sha1Digest = digest();
        sha1Digest.update(Constants.encodedTypeString(i));
        sha1Digest.update((byte) 32);
        sha1Digest.update(Constants.encodeASCII(j));
        sha1Digest.update((byte) 0);
        long j2 = j;
        while (0 < j2) {
            long j3 = jBeginObject;
            long j4 = j;
            int i3 = inputStream.read(bArrInsertBuffer, 0, (int) Math.min(bArrInsertBuffer.length, j2));
            if (i3 <= 0) {
                throw new EOFException();
            }
            sha1Digest.update(bArrInsertBuffer, 0, i3);
            this.packOut.compress.write(bArrInsertBuffer, 0, i3);
            j2 -= (long) i3;
            j = j4;
            jBeginObject = j3;
        }
        this.packOut.compress.finish();
        return endObject(sha1Digest.toObjectId(), jBeginObject, j, i);
    }

    private byte[] insertBuffer(long j) {
        byte[] bArrBuffer = buffer();
        if (j > bArrBuffer.length && j < this.db.getReaderOptions().getStreamFileThreshold()) {
            try {
                return new byte[(int) j];
            } catch (OutOfMemoryError unused) {
            }
        }
        return bArrBuffer;
    }

    @Override // org.eclipse.jgit.lib.ObjectInserter
    public void flush() throws IOException {
        if (this.packDsc == null) {
            return;
        }
        PackStream packStream = this.packOut;
        if (packStream == null) {
            throw new IOException();
        }
        byte[] bArrWritePackFooter = packStream.writePackFooter();
        this.packDsc.addFileExt(PackExt.PACK);
        this.packDsc.setFileSize(PackExt.PACK, this.packOut.getCount());
        this.packOut.close();
        this.packOut = null;
        sortObjectsById();
        PackIndex packIndexWritePackIndex = writePackIndex(this.packDsc, bArrWritePackFooter, this.objectList);
        writeObjectSizeIndex(this.packDsc, this.objectList);
        this.db.commitPack(Collections.singletonList(this.packDsc), null);
        this.rollback = false;
        DfsPackFile dfsPackFileCreateDfsPackFile = this.db.createDfsPackFile(this.cache, this.packDsc);
        if (packIndexWritePackIndex != null) {
            dfsPackFileCreateDfsPackFile.setPackIndex(packIndexWritePackIndex);
        }
        this.db.addPack(dfsPackFileCreateDfsPackFile);
        clear();
    }

    @Override // org.eclipse.jgit.lib.ObjectInserter, java.lang.AutoCloseable
    public void close() {
        DfsPackDescription dfsPackDescription;
        PackStream packStream = this.packOut;
        if (packStream != null) {
            try {
                packStream.close();
            } catch (IOException unused) {
            } finally {
                this.packOut = null;
            }
        }
        if (this.rollback && (dfsPackDescription = this.packDsc) != null) {
            try {
                this.db.rollbackPack(Collections.singletonList(dfsPackDescription));
                this.packDsc = null;
                this.rollback = false;
            } catch (Throwable th) {
                this.packDsc = null;
                this.rollback = false;
                throw th;
            }
        }
        clear();
    }

    private void clear() {
        this.objectList = null;
        this.objectMap = null;
        this.packKey = null;
        this.packDsc = null;
    }

    private long beginObject(int i, long j) throws IOException {
        if (this.packOut == null) {
            beginPack();
        }
        long count = this.packOut.getCount();
        this.packOut.beginObject(i, j);
        return count;
    }

    private ObjectId endObject(ObjectId objectId, long j, long j2, int i) {
        PackedObjectInfo packedObjectInfo = new PackedObjectInfo(objectId);
        packedObjectInfo.setType(i);
        packedObjectInfo.setOffset(j);
        packedObjectInfo.setCRC((int) this.packOut.crc32.getValue());
        packedObjectInfo.setFullSize(j2);
        this.objectList.add(packedObjectInfo);
        this.objectMap.addIfAbsent(packedObjectInfo);
        return objectId;
    }

    private void beginPack() throws IOException {
        this.objectList = new BlockList();
        this.objectMap = new ObjectIdOwnerMap<>();
        this.cache = DfsBlockCache.getInstance();
        this.rollback = true;
        DfsPackDescription dfsPackDescriptionNewPack = this.db.newPack(DfsObjDatabase.PackSource.INSERT);
        this.packDsc = dfsPackDescriptionNewPack;
        DfsOutputStream dfsOutputStreamWriteFile = this.db.writeFile(dfsPackDescriptionNewPack, PackExt.PACK);
        this.packDsc.setBlockSize(PackExt.PACK, dfsOutputStreamWriteFile.blockSize());
        this.packOut = new PackStream(dfsOutputStreamWriteFile);
        this.packKey = this.packDsc.getStreamKey(PackExt.PACK);
        byte[] bArr = this.packOut.hdrBuf;
        System.arraycopy(Constants.PACK_SIGNATURE, 0, bArr, 0, 4);
        NB.encodeInt32(bArr, 4, 2);
        NB.encodeInt32(bArr, 8, 1);
        this.packOut.write(bArr, 0, 12);
    }

    private void sortObjectsById() {
        Collections.sort(this.objectList);
    }

    @Nullable
    private TemporaryBuffer.Heap maybeGetTemporaryBuffer(List<PackedObjectInfo> list) {
        if (list.size() <= 58000) {
            return new TemporaryBuffer.Heap(2097152);
        }
        return null;
    }

    PackIndex writePackIndex(DfsPackDescription dfsPackDescription, byte[] bArr, List<PackedObjectInfo> list) throws IOException {
        PackIndex packIndex;
        dfsPackDescription.setIndexVersion(2);
        dfsPackDescription.setObjectCount(list.size());
        Throwable th = null;
        try {
            TemporaryBuffer.Heap heapMaybeGetTemporaryBuffer = maybeGetTemporaryBuffer(list);
            try {
                DfsOutputStream dfsOutputStreamWriteFile = this.db.writeFile(dfsPackDescription, PackExt.INDEX);
                try {
                    CountingOutputStream countingOutputStream = new CountingOutputStream(dfsOutputStreamWriteFile);
                    try {
                        if (heapMaybeGetTemporaryBuffer != null) {
                            index(heapMaybeGetTemporaryBuffer, bArr, list);
                            packIndex = PackIndex.read(heapMaybeGetTemporaryBuffer.openInputStream());
                            heapMaybeGetTemporaryBuffer.writeTo(countingOutputStream, null);
                        } else {
                            index(countingOutputStream, bArr, list);
                            packIndex = null;
                        }
                        dfsPackDescription.addFileExt(PackExt.INDEX);
                        dfsPackDescription.setBlockSize(PackExt.INDEX, dfsOutputStreamWriteFile.blockSize());
                        dfsPackDescription.setFileSize(PackExt.INDEX, countingOutputStream.getCount());
                        countingOutputStream.close();
                        if (dfsOutputStreamWriteFile != null) {
                            dfsOutputStreamWriteFile.close();
                        }
                        if (heapMaybeGetTemporaryBuffer != null) {
                            heapMaybeGetTemporaryBuffer.close();
                        }
                        return packIndex;
                    } catch (Throwable th2) {
                        countingOutputStream.close();
                        throw th2;
                    }
                } catch (Throwable th3) {
                    if (0 == 0) {
                        th = th3;
                    } else if (null != th3) {
                        th.addSuppressed(th3);
                    }
                    if (dfsOutputStreamWriteFile == null) {
                        throw th;
                    }
                    dfsOutputStreamWriteFile.close();
                    throw th;
                }
            } catch (Throwable th4) {
                if (0 == 0) {
                    th = th4;
                } else if (null != th4) {
                    th.addSuppressed(th4);
                }
                if (heapMaybeGetTemporaryBuffer == null) {
                    throw th;
                }
                heapMaybeGetTemporaryBuffer.close();
                throw th;
            }
        } catch (Throwable th5) {
            if (0 == 0) {
                throw th5;
            }
            if (null != th5) {
                th.addSuppressed(th5);
            }
            throw null;
        }
    }

    private static void index(OutputStream outputStream, byte[] bArr, List<PackedObjectInfo> list) throws IOException {
        BasePackIndexWriter.createVersion(outputStream, 2).write(list, bArr);
    }

    void writeObjectSizeIndex(DfsPackDescription dfsPackDescription, List<PackedObjectInfo> list) throws IOException {
        if (this.minBytesForObjectSizeIndex < 0) {
            return;
        }
        Throwable th = null;
        try {
            DfsOutputStream dfsOutputStreamWriteFile = this.db.writeFile(dfsPackDescription, PackExt.OBJECT_SIZE_INDEX);
            try {
                CountingOutputStream countingOutputStream = new CountingOutputStream(dfsOutputStreamWriteFile);
                try {
                    PackObjectSizeIndexWriter.createWriter(dfsOutputStreamWriteFile, this.minBytesForObjectSizeIndex).write(list);
                    dfsPackDescription.addFileExt(PackExt.OBJECT_SIZE_INDEX);
                    dfsPackDescription.setBlockSize(PackExt.OBJECT_SIZE_INDEX, dfsOutputStreamWriteFile.blockSize());
                    dfsPackDescription.setFileSize(PackExt.OBJECT_SIZE_INDEX, countingOutputStream.getCount());
                    countingOutputStream.close();
                    if (dfsOutputStreamWriteFile != null) {
                        dfsOutputStreamWriteFile.close();
                    }
                } catch (Throwable th2) {
                    countingOutputStream.close();
                    throw th2;
                }
            } catch (Throwable th3) {
                if (0 == 0) {
                    th = th3;
                } else if (null != th3) {
                    th.addSuppressed(th3);
                }
                if (dfsOutputStreamWriteFile == null) {
                    throw th;
                }
                dfsOutputStreamWriteFile.close();
                throw th;
            }
        } catch (Throwable th4) {
            if (0 == 0) {
                throw th4;
            }
            if (null != th4) {
                th.addSuppressed(th4);
            }
            throw null;
        }
    }

    private class PackStream extends OutputStream {
        private final int blockSize;
        final DeflaterOutputStream compress;
        private byte[] currBuf;
        private long currPos;
        private int currPtr;
        private final Deflater deflater;
        private final DfsOutputStream out;
        final byte[] hdrBuf = new byte[32];
        private final MessageDigest md = Constants.newMessageDigest();
        final CRC32 crc32 = new CRC32();

        PackStream(DfsOutputStream dfsOutputStream) {
            this.out = dfsOutputStream;
            Deflater deflater = new Deflater(DfsInserter.this.compression);
            this.deflater = deflater;
            this.compress = new DeflaterOutputStream(this, deflater, 8192);
            int iBlockSize = dfsOutputStream.blockSize();
            if (iBlockSize <= 0) {
                iBlockSize = DfsInserter.this.cache.getBlockSize();
            } else if (iBlockSize < DfsInserter.this.cache.getBlockSize()) {
                iBlockSize *= DfsInserter.this.cache.getBlockSize() / iBlockSize;
            }
            this.blockSize = iBlockSize;
            this.currBuf = new byte[iBlockSize];
        }

        long getCount() {
            return this.currPos + ((long) this.currPtr);
        }

        void beginObject(int i, long j) throws IOException {
            this.crc32.reset();
            this.deflater.reset();
            write(this.hdrBuf, 0, encodeTypeSize(i, j));
        }

        private int encodeTypeSize(int i, long j) {
            long j2 = j >>> 4;
            this.hdrBuf[0] = (byte) (((long) ((i << 4) | (j2 > 0 ? 128 : 0))) | (j & 15));
            int i2 = 1;
            while (j2 > 0) {
                long j3 = j2 >>> 7;
                int i3 = i2 + 1;
                this.hdrBuf[i2] = (byte) ((j2 & 127) | ((long) (j3 > 0 ? 128 : 0)));
                i2 = i3;
                j2 = j3;
            }
            return i2;
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            byte[] bArr = this.hdrBuf;
            bArr[0] = (byte) i;
            write(bArr, 0, 1);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.crc32.update(bArr, i, i2);
            this.md.update(bArr, i, i2);
            writeNoHash(bArr, i, i2);
        }

        private void writeNoHash(byte[] bArr, int i, int i2) throws IOException {
            while (i2 > 0) {
                int iMin = Math.min(i2, this.currBuf.length - this.currPtr);
                if (iMin == 0) {
                    flushBlock();
                    this.currBuf = new byte[this.blockSize];
                } else {
                    System.arraycopy(bArr, i, this.currBuf, this.currPtr, iMin);
                    i += iMin;
                    i2 -= iMin;
                    this.currPtr += iMin;
                }
            }
        }

        private void flushBlock() throws IOException {
            this.out.write(this.currBuf, 0, this.currPtr);
            int i = this.currPtr;
            byte[] bArrCopyOf = this.currBuf;
            if (i != bArrCopyOf.length) {
                bArrCopyOf = copyOf(bArrCopyOf, 0, i);
            }
            DfsInserter.this.cache.put(new DfsBlock(DfsInserter.this.packKey, this.currPos, bArrCopyOf));
            this.currPos += (long) this.currPtr;
            this.currPtr = 0;
            this.currBuf = null;
        }

        private byte[] copyOf(byte[] bArr, int i, int i2) {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            return bArr2;
        }

        byte[] writePackFooter() throws IOException {
            byte[] bArrDigest = this.md.digest();
            writeNoHash(bArrDigest, 0, bArrDigest.length);
            if (this.currPtr != 0) {
                flushBlock();
            }
            return bArrDigest;
        }

        int read(long j, byte[] bArr, int i, int i2) throws IOException {
            long j2;
            int i3 = 0;
            long j3 = j;
            while (true) {
                j2 = this.currPos;
                if (j3 >= j2 || i3 >= i2) {
                    break;
                }
                byte[] bArr2 = bArr;
                int iCopy = getOrLoadBlock(j3).copy(j3, bArr2, i + i3, i2 - i3);
                j3 += (long) iCopy;
                i3 += iCopy;
                bArr = bArr2;
            }
            byte[] bArr3 = bArr;
            if (j2 > j3 || i3 >= i2) {
                return i3;
            }
            int i4 = (int) (j3 - j2);
            int iMin = Math.min(this.currPtr - i4, i2 - i3);
            System.arraycopy(this.currBuf, i4, bArr3, i + i3, iMin);
            return i3 + iMin;
        }

        byte[] inflate(DfsReader dfsReader, long j, int i) throws DataFormatException, IOException {
            try {
                byte[] bArr = new byte[i];
                Inflater inflater = dfsReader.inflater();
                long input = j + ((long) setInput(j, inflater));
                int i2 = 0;
                while (true) {
                    int iInflate = inflater.inflate(bArr, i2, i - i2);
                    i2 += iInflate;
                    if (inflater.finished()) {
                        return bArr;
                    }
                    if (inflater.needsInput()) {
                        input += (long) setInput(input, inflater);
                    } else if (iInflate == 0) {
                        throw new DataFormatException();
                    }
                }
            } catch (OutOfMemoryError unused) {
                return null;
            }
        }

        private int setInput(long j, Inflater inflater) throws DataFormatException, IOException {
            long j2 = this.currPos;
            if (j < j2) {
                return getOrLoadBlock(j).setInput(j, inflater);
            }
            int i = this.currPtr;
            if (j < ((long) i) + j2) {
                int i2 = (int) (j - j2);
                int i3 = i - i2;
                inflater.setInput(this.currBuf, i2, i3);
                return i3;
            }
            throw new EOFException(JGitText.get().unexpectedEofInPack);
        }

        private DfsBlock getOrLoadBlock(long j) throws IOException {
            long blockStart = toBlockStart(j);
            DfsBlock dfsBlock = (DfsBlock) DfsInserter.this.cache.get(DfsInserter.this.packKey, blockStart);
            if (dfsBlock != null) {
                return dfsBlock;
            }
            byte[] bArr = new byte[this.blockSize];
            int i = 0;
            while (true) {
                int i2 = this.blockSize;
                if (i < i2) {
                    int i3 = this.out.read(((long) i) + blockStart, ByteBuffer.wrap(bArr, i, i2 - i));
                    if (i3 <= 0) {
                        throw new EOFException(JGitText.get().unexpectedEofInPack);
                    }
                    i += i3;
                } else {
                    DfsBlock dfsBlock2 = new DfsBlock(DfsInserter.this.packKey, blockStart, bArr);
                    DfsInserter.this.cache.put(dfsBlock2);
                    return dfsBlock2;
                }
            }
        }

        private long toBlockStart(long j) {
            int i = this.blockSize;
            return (j / ((long) i)) * ((long) i);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.deflater.end();
            this.out.close();
        }
    }

    private class Reader extends ObjectReader {
        private final DfsReader ctx;

        /* synthetic */ Reader(DfsInserter dfsInserter, DfsInserterIA dfsInserterIA) {
            this();
        }

        private Reader() {
            this.ctx = DfsInserter.this.db.newReader();
        }

        @Override // org.eclipse.jgit.lib.ObjectReader
        public ObjectReader newReader() {
            return DfsInserter.this.db.newReader();
        }

        @Override // org.eclipse.jgit.lib.ObjectReader
        public Collection<ObjectId> resolve(AbbreviatedObjectId abbreviatedObjectId) throws IOException {
            Collection<ObjectId> collectionResolve = this.ctx.resolve(abbreviatedObjectId);
            if (DfsInserter.this.objectList == null) {
                return collectionResolve;
            }
            HashSet hashSet = new HashSet(collectionResolve.size() + 2);
            hashSet.addAll(collectionResolve);
            for (PackedObjectInfo packedObjectInfo : DfsInserter.this.objectList) {
                if (abbreviatedObjectId.prefixCompare(packedObjectInfo) == 0) {
                    hashSet.add(packedObjectInfo.copy());
                }
            }
            return hashSet;
        }

        @Override // org.eclipse.jgit.lib.ObjectReader
        public ObjectLoader open(AnyObjectId anyObjectId, int i) throws IOException {
            byte[] bArrInflate;
            if (DfsInserter.this.objectMap == null) {
                return this.ctx.open(anyObjectId, i);
            }
            PackedObjectInfo packedObjectInfo = (PackedObjectInfo) DfsInserter.this.objectMap.get(anyObjectId);
            if (packedObjectInfo != null) {
                byte[] bArrBuffer = DfsInserter.this.buffer();
                int i2 = DfsInserter.this.packOut.read(packedObjectInfo.getOffset(), bArrBuffer, 0, 20);
                if (i2 <= 0) {
                    throw new EOFException(JGitText.get().unexpectedEofInPack);
                }
                byte b = bArrBuffer[0];
                int i3 = b & 255;
                int i4 = (i3 >> 4) & 7;
                if (i4 == 6 || i4 == 7) {
                    throw new IOException(MessageFormat.format(JGitText.get().cannotReadBackDelta, Integer.toString(i4)));
                }
                if (i != -1 && i4 != i) {
                    throw new IncorrectObjectTypeException(anyObjectId.copy(), i);
                }
                long j = b & Ascii.SI;
                int i5 = 1;
                int i6 = 4;
                long j2 = j;
                while ((i3 & 128) != 0) {
                    if (i5 >= i2) {
                        throw new EOFException(JGitText.get().unexpectedEofInPack);
                    }
                    byte b2 = bArrBuffer[i5];
                    i3 = b2 & 255;
                    j2 += ((long) (b2 & 127)) << i6;
                    i6 += 7;
                    i5++;
                }
                long offset = packedObjectInfo.getOffset() + ((long) i5);
                if (j2 < this.ctx.getStreamFileThreshold() && (bArrInflate = inflate(packedObjectInfo, offset, (int) j2)) != null) {
                    return new ObjectLoader.SmallObject(i4, bArrInflate);
                }
                return DfsInserter.this.new StreamLoader(packedObjectInfo.copy(), i4, j2, DfsInserter.this.packKey, offset);
            }
            return this.ctx.open(anyObjectId, i);
        }

        private byte[] inflate(PackedObjectInfo packedObjectInfo, long j, int i) throws IOException {
            try {
                return DfsInserter.this.packOut.inflate(this.ctx, j, i);
            } catch (DataFormatException e) {
                throw new CorruptObjectException(MessageFormat.format(JGitText.get().objectAtHasBadZlibStream, Long.valueOf(packedObjectInfo.getOffset()), DfsInserter.this.packDsc.getFileName(PackExt.PACK)), e);
            }
        }

        @Override // org.eclipse.jgit.lib.ObjectReader
        public boolean has(AnyObjectId anyObjectId) throws IOException {
            return (DfsInserter.this.objectMap != null && DfsInserter.this.objectMap.contains(anyObjectId)) || this.ctx.has(anyObjectId);
        }

        @Override // org.eclipse.jgit.lib.ObjectReader
        public Set<ObjectId> getShallowCommits() throws IOException {
            return this.ctx.getShallowCommits();
        }

        @Override // org.eclipse.jgit.lib.ObjectReader
        public ObjectInserter getCreatedFromInserter() {
            return DfsInserter.this;
        }

        @Override // org.eclipse.jgit.lib.ObjectReader, java.lang.AutoCloseable
        public void close() {
            this.ctx.close();
        }
    }

    private class StreamLoader extends ObjectLoader {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final ObjectId f118id;
        private final long pos;
        private final long size;
        private final DfsStreamKey srcPack;
        private final int type;

        @Override // org.eclipse.jgit.lib.ObjectLoader
        public boolean isLarge() {
            return true;
        }

        StreamLoader(ObjectId objectId, int i, long j, DfsStreamKey dfsStreamKey, long j2) {
            this.f118id = objectId;
            this.type = i;
            this.size = j;
            this.srcPack = dfsStreamKey;
            this.pos = j2;
        }

        @Override // org.eclipse.jgit.lib.ObjectLoader
        public ObjectStream openStream() throws IOException {
            DfsReader dfsReaderNewReader = DfsInserter.this.db.newReader();
            if (this.srcPack != DfsInserter.this.packKey) {
                try {
                    return dfsReaderNewReader.open(this.f118id, this.type).openStream();
                } finally {
                    dfsReaderNewReader.close();
                }
            }
            return new AnonymousClass1(this.type, this.size, new BufferedInputStream(new InflaterInputStream(DfsInserter.this.new ReadBackStream(this.pos), dfsReaderNewReader.inflater(), 8192), 8192), dfsReaderNewReader);
        }

        /* JADX INFO: renamed from: org.eclipse.jgit.internal.storage.dfs.DfsInserter$StreamLoader$1, reason: invalid class name */
        class AnonymousClass1 extends ObjectStream.Filter {
            private final /* synthetic */ DfsReader val$ctx;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(int i, long j, InputStream inputStream, DfsReader dfsReader) {
                super(i, j, inputStream);
                this.val$ctx = dfsReader;
            }

            @Override // org.eclipse.jgit.lib.ObjectStream.Filter, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                this.val$ctx.close();
                super.close();
            }
        }

        @Override // org.eclipse.jgit.lib.ObjectLoader
        public int getType() {
            return this.type;
        }

        @Override // org.eclipse.jgit.lib.ObjectLoader
        public long getSize() {
            return this.size;
        }

        @Override // org.eclipse.jgit.lib.ObjectLoader
        public byte[] getCachedBytes() throws LargeObjectException {
            throw new LargeObjectException.ExceedsLimit(DfsInserter.this.db.getReaderOptions().getStreamFileThreshold(), this.size);
        }
    }

    private final class ReadBackStream extends InputStream {
        private long pos;

        ReadBackStream(long j) {
            this.pos = j;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            byte[] bArr = new byte[1];
            if (read(bArr) == 1) {
                return bArr[0] & 255;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3 = DfsInserter.this.packOut.read(this.pos, bArr, i, i2);
            if (i3 > 0) {
                this.pos += (long) i3;
            }
            return i3;
        }
    }
}
