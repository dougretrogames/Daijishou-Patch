package org.eclipse.jgit.internal.storage.dfs;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.text.MessageFormat;
import org.eclipse.jgit.errors.PackInvalidException;
import org.eclipse.jgit.internal.storage.pack.PackExt;

/* INFO: loaded from: classes5.dex */
abstract class BlockBasedFile {
    volatile int blockSize;
    final DfsBlockCache cache;
    final DfsPackDescription desc;
    final PackExt ext;
    volatile boolean invalid;
    protected volatile Exception invalidatingCause;
    final DfsStreamKey key;
    volatile long length;

    BlockBasedFile(DfsBlockCache dfsBlockCache, DfsPackDescription dfsPackDescription, PackExt packExt) {
        this.cache = dfsBlockCache;
        this.key = dfsPackDescription.getStreamKey(packExt);
        this.desc = dfsPackDescription;
        this.ext = packExt;
    }

    String getFileName() {
        return this.desc.getFileName(this.ext);
    }

    boolean invalid() {
        return this.invalid;
    }

    void setInvalid() {
        this.invalid = true;
    }

    void setBlockSize(int i) {
        this.blockSize = i;
    }

    long alignToBlock(long j) {
        int blockSize = this.blockSize;
        if (blockSize == 0) {
            blockSize = this.cache.getBlockSize();
        }
        long j2 = blockSize;
        return (j / j2) * j2;
    }

    int blockSize(ReadableChannel readableChannel) {
        int i = this.blockSize;
        if (i != 0) {
            return i;
        }
        int iBlockSize = readableChannel.blockSize();
        if (iBlockSize <= 0) {
            iBlockSize = this.cache.getBlockSize();
        } else if (iBlockSize < this.cache.getBlockSize()) {
            iBlockSize *= this.cache.getBlockSize() / iBlockSize;
        }
        this.blockSize = iBlockSize;
        return iBlockSize;
    }

    /* WARN: Code duplicated, block: B:21:0x002b A[DONT_INVERT] */
    /* WARN: Code duplicated, block: B:22:0x002d  */
    /* WARN: Code duplicated, block: B:31:? A[RETURN, SYNTHETIC] */
    DfsBlock getOrLoadBlock(long j, DfsReader dfsReader) throws Throwable {
        Throwable th;
        Throwable th2 = null;
        try {
            try {
                LazyChannel lazyChannel = new LazyChannel(dfsReader, this.desc, this.ext);
                try {
                    try {
                        DfsBlock orLoad = this.cache.getOrLoad(this, j, dfsReader, lazyChannel);
                        dfsReader.emitBlockLoad(this, j, orLoad);
                        lazyChannel.close();
                        return orLoad;
                    } catch (Throwable th3) {
                        th = th3;
                        Throwable th4 = th;
                        lazyChannel.close();
                        throw th4;
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
            } catch (Throwable th6) {
                th = th6;
                th = th;
                if (0 != 0) {
                    throw th;
                }
                if (null != th) {
                    th2.addSuppressed(th);
                }
                throw null;
            }
        } catch (Throwable th7) {
            th = th7;
            th = th;
            if (0 != 0) {
                throw th;
            }
            if (null != th) {
                th2.addSuppressed(th);
            }
            throw null;
        }
    }

    DfsBlock readOneBlock(long j, DfsReader dfsReader, ReadableChannel readableChannel) throws IOException {
        if (this.invalid) {
            throw new PackInvalidException(getFileName(), this.invalidatingCause);
        }
        dfsReader.stats.readBlock++;
        long jNanoTime = System.nanoTime();
        try {
            int iBlockSize = blockSize(readableChannel);
            long j2 = iBlockSize;
            long j3 = (j / j2) * j2;
            long size = this.length;
            if (size < 0) {
                size = readableChannel.size();
                if (0 <= size) {
                    this.length = size;
                }
            }
            if (0 <= size && size < j2 + j3) {
                iBlockSize = (int) (size - j3);
            }
            if (iBlockSize <= 0) {
                throw new EOFException(MessageFormat.format(DfsText.get().shortReadOfBlock, Long.valueOf(j3), getFileName(), 0L, 0L));
            }
            byte[] bArr = new byte[iBlockSize];
            readableChannel.position(j3);
            int i = read(readableChannel, ByteBuffer.wrap(bArr, 0, iBlockSize));
            long j4 = size;
            dfsReader.stats.readBlockBytes += (long) i;
            if (i != iBlockSize) {
                if (0 <= size) {
                    throw new EOFException(MessageFormat.format(DfsText.get().shortReadOfBlock, Long.valueOf(j3), getFileName(), Integer.valueOf(iBlockSize), Integer.valueOf(i)));
                }
                byte[] bArr2 = new byte[i];
                System.arraycopy(bArr, 0, bArr2, 0, i);
                bArr = bArr2;
            } else if (j4 < 0) {
                this.length = readableChannel.size();
            }
            DfsBlock dfsBlock = new DfsBlock(this.key, j3, bArr);
            dfsReader.stats.readBlockMicros += elapsedMicros(jNanoTime);
            return dfsBlock;
        } catch (Throwable th) {
            dfsReader.stats.readBlockMicros += elapsedMicros(jNanoTime);
            throw th;
        }
    }

    static int read(ReadableChannel readableChannel, ByteBuffer byteBuffer) throws IOException {
        while (readableChannel.read(byteBuffer) > 0 && byteBuffer.hasRemaining()) {
        }
        return byteBuffer.position();
    }

    static long elapsedMicros(long j) {
        return (System.nanoTime() - j) / 1000;
    }

    private static class LazyChannel implements AutoCloseable, DfsBlockCache.ReadableChannelSupplier {
        private final DfsReader ctx;
        private final DfsPackDescription desc;
        private final PackExt ext;
        private ReadableChannel rc;

        LazyChannel(DfsReader dfsReader, DfsPackDescription dfsPackDescription, PackExt packExt) {
            this.ctx = dfsReader;
            this.desc = dfsPackDescription;
            this.ext = packExt;
        }

        @Override // org.eclipse.jgit.internal.storage.dfs.DfsBlockCache.ReadableChannelSupplier
        public ReadableChannel get() throws IOException {
            if (this.rc == null) {
                this.rc = this.ctx.db.openFile(this.desc, this.ext);
            }
            return this.rc;
        }

        @Override // java.lang.AutoCloseable
        public void close() throws IOException {
            ReadableChannel readableChannel = this.rc;
            if (readableChannel != null) {
                readableChannel.close();
            }
        }
    }
}
