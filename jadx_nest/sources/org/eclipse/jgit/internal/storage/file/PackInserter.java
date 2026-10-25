package org.eclipse.jgit.internal.storage.file;

import com.google.common.base.Ascii;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.Channels;
import java.nio.file.StandardCopyOption;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import org.eclipse.jgit.errors.CorruptObjectException;
import org.eclipse.jgit.errors.IncorrectObjectTypeException;
import org.eclipse.jgit.errors.LargeObjectException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.storage.pack.PackExt;
import org.eclipse.jgit.lib.AbbreviatedObjectId;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.InflaterCache;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectIdOwnerMap;
import org.eclipse.jgit.lib.ObjectInserter;
import org.eclipse.jgit.lib.ObjectLoader;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.ObjectStream;
import org.eclipse.jgit.storage.pack.PackConfig;
import org.eclipse.jgit.transport.PackParser;
import org.eclipse.jgit.transport.PackedObjectInfo;
import org.eclipse.jgit.util.BlockList;
import org.eclipse.jgit.util.FileUtils;
import org.eclipse.jgit.util.IO;
import org.eclipse.jgit.util.NB;
import org.eclipse.jgit.util.io.CountingOutputStream;
import org.eclipse.jgit.util.sha1.SHA1;

/* JADX INFO: loaded from: classes5.dex */
public class PackInserter extends ObjectInserter {
    private static final int INDEX_VERSION = 2;
    private Inflater cachedInflater;
    private boolean checkExisting = true;
    private int compression = 9;
    private final ObjectDirectory db;
    private List<PackedObjectInfo> objectList;
    private ObjectIdOwnerMap<PackedObjectInfo> objectMap;
    private PackStream packOut;
    private PackConfig pconfig;
    private boolean rollback;
    private File tmpPack;

    PackInserter(ObjectDirectory objectDirectory) {
        this.db = objectDirectory;
        this.pconfig = new PackConfig(objectDirectory.getConfig());
    }

    public void checkExisting(boolean z) {
        this.checkExisting = z;
    }

    public void setCompressionLevel(int i) {
        this.compression = i;
    }

    int getBufferSize() {
        return buffer().length;
    }

    @Override // org.eclipse.jgit.lib.ObjectInserter
    public ObjectId insert(int i, byte[] bArr, int i2, int i3) throws IOException {
        ObjectId objectIdIdFor = idFor(i, bArr, i2, i3);
        ObjectIdOwnerMap<PackedObjectInfo> objectIdOwnerMap = this.objectMap;
        if ((objectIdOwnerMap != null && objectIdOwnerMap.contains(objectIdIdFor)) || (this.checkExisting && this.db.hasPackedObject(objectIdIdFor))) {
            return objectIdIdFor;
        }
        long jBeginObject = beginObject(i, i3);
        this.packOut.compress.write(bArr, i2, i3);
        this.packOut.compress.finish();
        return endObject(objectIdIdFor, jBeginObject);
    }

    @Override // org.eclipse.jgit.lib.ObjectInserter
    public ObjectId insert(int i, long j, InputStream inputStream) throws IOException {
        byte[] bArrBuffer = buffer();
        if (j <= bArrBuffer.length) {
            int i2 = (int) j;
            IO.readFully(inputStream, bArrBuffer, 0, i2);
            return insert(i, bArrBuffer, 0, i2);
        }
        long jBeginObject = beginObject(i, j);
        SHA1 sha1Digest = digest();
        sha1Digest.update(Constants.encodedTypeString(i));
        sha1Digest.update((byte) 32);
        sha1Digest.update(Constants.encodeASCII(j));
        sha1Digest.update((byte) 0);
        while (0 < j) {
            int i3 = inputStream.read(bArrBuffer, 0, (int) Math.min(bArrBuffer.length, j));
            if (i3 <= 0) {
                throw new EOFException();
            }
            sha1Digest.update(bArrBuffer, 0, i3);
            this.packOut.compress.write(bArrBuffer, 0, i3);
            j -= (long) i3;
        }
        this.packOut.compress.finish();
        return endObject(sha1Digest.toObjectId(), jBeginObject);
    }

    private long beginObject(int i, long j) throws IOException {
        if (this.packOut == null) {
            beginPack();
        }
        long offset = this.packOut.getOffset();
        this.packOut.beginObject(i, j);
        return offset;
    }

    private ObjectId endObject(ObjectId objectId, long j) {
        PackedObjectInfo packedObjectInfo = new PackedObjectInfo(objectId);
        packedObjectInfo.setOffset(j);
        packedObjectInfo.setCRC((int) this.packOut.crc32.getValue());
        this.objectList.add(packedObjectInfo);
        this.objectMap.addIfAbsent(packedObjectInfo);
        return objectId;
    }

    private static File idxFor(File file) {
        String name = file.getName();
        return new File(file.getParentFile(), name.substring(0, name.lastIndexOf(46)) + ".idx");
    }

    private void beginPack() throws IOException {
        this.objectList = new BlockList();
        this.objectMap = new ObjectIdOwnerMap<>();
        this.rollback = true;
        this.tmpPack = File.createTempFile("insert_", ".pack", this.db.getDirectory());
        PackStream packStream = new PackStream(this.tmpPack);
        this.packOut = packStream;
        packStream.write(packStream.hdrBuf, 0, writePackHeader(this.packOut.hdrBuf, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int writePackHeader(byte[] bArr, int i) {
        System.arraycopy(Constants.PACK_SIGNATURE, 0, bArr, 0, 4);
        NB.encodeInt32(bArr, 4, 2);
        NB.encodeInt32(bArr, 8, i);
        return 12;
    }

    @Override // org.eclipse.jgit.lib.ObjectInserter
    public PackParser newPackParser(InputStream inputStream) {
        throw new UnsupportedOperationException();
    }

    @Override // org.eclipse.jgit.lib.ObjectInserter
    public ObjectReader newReader() {
        return new Reader(this, null);
    }

    @Override // org.eclipse.jgit.lib.ObjectInserter
    public void flush() throws IOException {
        if (this.tmpPack == null) {
            return;
        }
        PackStream packStream = this.packOut;
        if (packStream == null) {
            throw new IOException();
        }
        try {
            byte[] bArrFinishPack = packStream.finishPack();
            this.packOut = null;
            Collections.sort(this.objectList);
            File fileIdxFor = idxFor(this.tmpPack);
            writePackIndex(fileIdxFor, bArrFinishPack, this.objectList);
            PackFile packFile = new PackFile(this.db.getPackDirectory(), computeName(this.objectList), PackExt.PACK);
            this.db.closeAllPackHandles(packFile);
            this.tmpPack.setReadOnly();
            boolean z = true;
            FileUtils.rename(this.tmpPack, packFile, StandardCopyOption.ATOMIC_MOVE);
            PackFile packFileCreate = packFile.create(PackExt.INDEX);
            fileIdxFor.setReadOnly();
            try {
                FileUtils.rename(fileIdxFor, packFileCreate, StandardCopyOption.ATOMIC_MOVE);
                try {
                    FileSnapshot fileSnapshotSave = FileSnapshot.save(packFile);
                    if (this.pconfig.doWaitPreventRacyPack(fileSnapshotSave.size())) {
                        fileSnapshotSave.waitUntilNotRacy();
                    }
                    z = false;
                } catch (InterruptedException unused) {
                }
                try {
                    this.db.openPack(packFile);
                    this.rollback = false;
                } finally {
                    clear();
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                }
            } catch (IOException e) {
                e = e;
                File file = new File(packFileCreate.getParentFile(), packFileCreate.getName() + ".new");
                try {
                    FileUtils.rename(fileIdxFor, file, StandardCopyOption.ATOMIC_MOVE);
                    fileIdxFor = file;
                } catch (IOException e2) {
                    e = e2;
                }
                throw new IOException(MessageFormat.format(JGitText.get().panicCantRenameIndexFile, fileIdxFor, packFileCreate), e);
            }
        } catch (Throwable th) {
            this.packOut = null;
            throw th;
        }
    }

    private static void writePackIndex(File file, byte[] bArr, List<PackedObjectInfo> list) throws IOException {
        Throwable th = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                BasePackIndexWriter.createVersion(fileOutputStream, 2).write(list, bArr);
            } finally {
                fileOutputStream.close();
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

    private ObjectId computeName(List<PackedObjectInfo> list) {
        SHA1 sha1Reset = digest().reset();
        byte[] bArrBuffer = buffer();
        Iterator<PackedObjectInfo> it = list.iterator();
        while (it.hasNext()) {
            it.next().copyRawTo(bArrBuffer, 0);
            sha1Reset.update(bArrBuffer, 0, 20);
        }
        return ObjectId.fromRaw(sha1Reset.digest());
    }

    @Override // org.eclipse.jgit.lib.ObjectInserter, java.lang.AutoCloseable
    public void close() {
        File file;
        try {
            PackStream packStream = this.packOut;
            if (packStream != null) {
                try {
                    packStream.close();
                } catch (IOException unused) {
                }
            }
            if (this.rollback && (file = this.tmpPack) != null) {
                try {
                    FileUtils.delete(file);
                } catch (IOException unused2) {
                }
                try {
                    FileUtils.delete(idxFor(this.tmpPack));
                } catch (IOException unused3) {
                }
                this.rollback = false;
            }
            clear();
            try {
                InflaterCache.release(this.cachedInflater);
            } finally {
                this.cachedInflater = null;
            }
        } catch (Throwable th) {
            clear();
            try {
                InflaterCache.release(this.cachedInflater);
                throw th;
            } finally {
                this.cachedInflater = null;
            }
        }
    }

    private void clear() {
        this.objectList = null;
        this.objectMap = null;
        this.tmpPack = null;
        this.packOut = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Inflater inflater() {
        Inflater inflater = this.cachedInflater;
        if (inflater == null) {
            this.cachedInflater = InflaterCache.get();
        } else {
            inflater.reset();
        }
        return this.cachedInflater;
    }

    private class PackStream extends OutputStream {
        private boolean atEnd;
        final DeflaterOutputStream compress;
        final CRC32 crc32;
        private final Deflater deflater;
        private final RandomAccessFile file;
        final byte[] hdrBuf;
        private final CountingOutputStream out;

        PackStream(File file) throws IOException {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            this.file = randomAccessFile;
            this.out = new CountingOutputStream(new FileOutputStream(randomAccessFile.getFD()));
            Deflater deflater = new Deflater(PackInserter.this.compression);
            this.deflater = deflater;
            this.compress = new DeflaterOutputStream(this, deflater, 8192);
            this.hdrBuf = new byte[32];
            this.crc32 = new CRC32();
            this.atEnd = true;
        }

        long getOffset() {
            return this.out.getCount();
        }

        void seek(long j) throws IOException {
            this.file.seek(j);
            this.atEnd = false;
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
            if (!this.atEnd) {
                RandomAccessFile randomAccessFile = this.file;
                randomAccessFile.seek(randomAccessFile.length());
                this.atEnd = true;
            }
            this.out.write(bArr, i, i2);
        }

        byte[] finishPack() throws IOException {
            try {
                this.file.seek(0L);
                CountingOutputStream countingOutputStream = this.out;
                byte[] bArr = this.hdrBuf;
                countingOutputStream.write(bArr, 0, PackInserter.writePackHeader(bArr, PackInserter.this.objectList.size()));
                byte[] bArrBuffer = PackInserter.this.buffer();
                SHA1 sha1Reset = PackInserter.this.digest().reset();
                this.file.seek(0L);
                while (true) {
                    int i = this.file.read(bArrBuffer);
                    if (i >= 0) {
                        sha1Reset.update(bArrBuffer, 0, i);
                    } else {
                        byte[] bArrDigest = sha1Reset.digest();
                        this.out.write(bArrDigest, 0, bArrDigest.length);
                        return bArrDigest;
                    }
                }
            } finally {
                close();
            }
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.deflater.end();
            try {
                this.out.close();
            } finally {
                this.file.close();
            }
        }

        byte[] inflate(long j, int i) throws DataFormatException, IOException {
            try {
                byte[] bArr = new byte[i];
                byte[] bArrBuffer = PackInserter.this.buffer();
                Inflater inflater = PackInserter.this.inflater();
                long input = j + ((long) setInput(j, inflater, bArrBuffer));
                int i2 = 0;
                while (true) {
                    int iInflate = inflater.inflate(bArr, i2, i - i2);
                    i2 += iInflate;
                    if (inflater.finished()) {
                        return bArr;
                    }
                    if (inflater.needsInput()) {
                        input += (long) setInput(input, inflater, bArrBuffer);
                    } else if (iInflate == 0) {
                        throw new DataFormatException();
                    }
                }
            } catch (OutOfMemoryError unused) {
                return null;
            }
        }

        private int setInput(long j, Inflater inflater, byte[] bArr) throws IOException {
            if (this.file.getFilePointer() != j) {
                seek(j);
            }
            int i = this.file.read(bArr);
            if (i < 0) {
                throw new EOFException(JGitText.get().unexpectedEofInPack);
            }
            inflater.setInput(bArr, 0, i);
            return i;
        }
    }

    private class Reader extends ObjectReader {
        private final ObjectReader ctx;

        /* synthetic */ Reader(PackInserter packInserter, PackInserterIA packInserterIA) {
            this();
        }

        private Reader() {
            ObjectReader objectReaderNewReader = PackInserter.this.db.newReader();
            this.ctx = objectReaderNewReader;
            setStreamFileThreshold(objectReaderNewReader.getStreamFileThreshold());
        }

        @Override // org.eclipse.jgit.lib.ObjectReader
        public ObjectReader newReader() {
            return PackInserter.this.db.newReader();
        }

        @Override // org.eclipse.jgit.lib.ObjectReader
        public ObjectInserter getCreatedFromInserter() {
            return PackInserter.this;
        }

        @Override // org.eclipse.jgit.lib.ObjectReader
        public Collection<ObjectId> resolve(AbbreviatedObjectId abbreviatedObjectId) throws IOException {
            Collection<ObjectId> collectionResolve = this.ctx.resolve(abbreviatedObjectId);
            if (PackInserter.this.objectList == null) {
                return collectionResolve;
            }
            HashSet hashSet = new HashSet(collectionResolve.size() + 2);
            hashSet.addAll(collectionResolve);
            for (PackedObjectInfo packedObjectInfo : PackInserter.this.objectList) {
                if (abbreviatedObjectId.prefixCompare(packedObjectInfo) == 0) {
                    hashSet.add(packedObjectInfo.copy());
                }
            }
            return hashSet;
        }

        @Override // org.eclipse.jgit.lib.ObjectReader
        public ObjectLoader open(AnyObjectId anyObjectId, int i) throws IOException {
            byte[] bArrInflate;
            if (PackInserter.this.objectMap == null) {
                return this.ctx.open(anyObjectId, i);
            }
            PackedObjectInfo packedObjectInfo = (PackedObjectInfo) PackInserter.this.objectMap.get(anyObjectId);
            if (packedObjectInfo != null) {
                byte[] bArrBuffer = PackInserter.this.buffer();
                PackInserter.this.packOut.seek(packedObjectInfo.getOffset());
                int i2 = PackInserter.this.packOut.file.read(bArrBuffer, 0, 20);
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
                while ((i3 & 128) != 0) {
                    int i7 = i4;
                    if (i5 >= i2) {
                        throw new EOFException(JGitText.get().unexpectedEofInPack);
                    }
                    int i8 = i5 + 1;
                    byte b2 = bArrBuffer[i5];
                    i3 = b2 & 255;
                    j += ((long) (b2 & 127)) << i6;
                    i6 += 7;
                    i4 = i7;
                    i5 = i8;
                }
                long offset = packedObjectInfo.getOffset() + ((long) i5);
                if (j < getStreamFileThreshold() && (bArrInflate = inflate(packedObjectInfo, offset, (int) j)) != null) {
                    return new ObjectLoader.SmallObject(i4, bArrInflate);
                }
                return new StreamLoader(i4, j, offset);
            }
            return this.ctx.open(anyObjectId, i);
        }

        private byte[] inflate(PackedObjectInfo packedObjectInfo, long j, int i) throws IOException {
            try {
                return PackInserter.this.packOut.inflate(j, i);
            } catch (DataFormatException e) {
                throw new CorruptObjectException(MessageFormat.format(JGitText.get().objectAtHasBadZlibStream, Long.valueOf(packedObjectInfo.getOffset()), PackInserter.this.tmpPack.getAbsolutePath()), e);
            }
        }

        @Override // org.eclipse.jgit.lib.ObjectReader
        public Set<ObjectId> getShallowCommits() throws IOException {
            return this.ctx.getShallowCommits();
        }

        @Override // org.eclipse.jgit.lib.ObjectReader, java.lang.AutoCloseable
        public void close() {
            this.ctx.close();
        }

        private class StreamLoader extends ObjectLoader {
            private final long pos;
            private final long size;
            private final int type;

            StreamLoader(int i, long j, long j2) {
                this.type = i;
                this.size = j;
                this.pos = j2;
            }

            @Override // org.eclipse.jgit.lib.ObjectLoader
            public ObjectStream openStream() throws IOException {
                int length = PackInserter.this.buffer().length;
                PackInserter.this.packOut.seek(this.pos);
                return new ObjectStream.Filter(this.type, this.size, new BufferedInputStream(new InflaterInputStream(new AnonymousClass1(Channels.newInputStream(PackInserter.this.packOut.file.getChannel())), PackInserter.this.inflater(), length), length));
            }

            /* JADX INFO: renamed from: org.eclipse.jgit.internal.storage.file.PackInserter$Reader$StreamLoader$1, reason: invalid class name */
            class AnonymousClass1 extends FilterInputStream {
                @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                }

                AnonymousClass1(InputStream inputStream) {
                    super(inputStream);
                }

                @Override // java.io.FilterInputStream, java.io.InputStream
                public int read() throws IOException {
                    PackInserter.this.packOut.atEnd = false;
                    return super.read();
                }

                @Override // java.io.FilterInputStream, java.io.InputStream
                public int read(byte[] bArr) throws IOException {
                    PackInserter.this.packOut.atEnd = false;
                    return super.read(bArr);
                }

                @Override // java.io.FilterInputStream, java.io.InputStream
                public int read(byte[] bArr, int i, int i2) throws IOException {
                    PackInserter.this.packOut.atEnd = false;
                    return super.read(bArr, i, i2);
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
                throw new LargeObjectException.ExceedsLimit(Reader.this.getStreamFileThreshold(), this.size);
            }
        }
    }
}
