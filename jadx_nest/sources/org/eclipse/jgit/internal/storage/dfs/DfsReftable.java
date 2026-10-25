package org.eclipse.jgit.internal.storage.dfs;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.eclipse.jgit.internal.storage.io.BlockSource;
import org.eclipse.jgit.internal.storage.pack.PackExt;
import org.eclipse.jgit.internal.storage.reftable.ReftableReader;

/* JADX INFO: loaded from: classes5.dex */
public class DfsReftable extends BlockBasedFile {
    public DfsReftable(DfsPackDescription dfsPackDescription) {
        this(DfsBlockCache.getInstance(), dfsPackDescription);
    }

    public DfsReftable(DfsBlockCache dfsBlockCache, DfsPackDescription dfsPackDescription) {
        super(dfsBlockCache, dfsPackDescription, PackExt.REFTABLE);
        int blockSize = dfsPackDescription.getBlockSize(PackExt.REFTABLE);
        if (blockSize > 0) {
            setBlockSize(blockSize);
        }
        long fileSize = dfsPackDescription.getFileSize(PackExt.REFTABLE);
        this.length = fileSize <= 0 ? -1L : fileSize;
    }

    public DfsPackDescription getPackDescription() {
        return this.desc;
    }

    public ReftableReader open(DfsReader dfsReader) throws IOException {
        return new ReftableReader(new CacheSource(this, this.cache, dfsReader));
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class CacheSource extends BlockSource {
        private final DfsBlockCache cache;
        private ReadableChannel ch;
        private final DfsReader ctx;
        private final DfsReftable file;
        private int readAhead;

        CacheSource(DfsReftable dfsReftable, DfsBlockCache dfsBlockCache, DfsReader dfsReader) {
            this.file = dfsReftable;
            this.cache = dfsBlockCache;
            this.ctx = dfsReader;
        }

        @Override // org.eclipse.jgit.internal.storage.io.BlockSource
        public ByteBuffer read(long j, int i) throws IOException {
            if (this.ch == null && this.readAhead > 0 && notInCache(j)) {
                m5676xa4b6974c().setReadAheadBytes(this.readAhead);
            }
            DfsBlock orLoad = this.cache.getOrLoad(this.file, j, this.ctx, new DfsReftable$CacheSource$$ExternalSyntheticLambda0(this));
            if (orLoad.start == j && orLoad.size() >= i) {
                return orLoad.zeroCopyByteBuffer(i);
            }
            byte[] bArr = new byte[i];
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            return byteBufferWrap;
        }

        private boolean notInCache(long j) {
            return this.cache.get(this.file.key, this.file.alignToBlock(j)) == null;
        }

        @Override // org.eclipse.jgit.internal.storage.io.BlockSource
        public long size() throws IOException {
            long j = this.file.length;
            if (j >= 0) {
                return j;
            }
            long size = m5676xa4b6974c().size();
            this.file.length = size;
            return size;
        }

        @Override // org.eclipse.jgit.internal.storage.io.BlockSource
        public void adviseSequentialRead(long j, long j2) {
            int streamPackBufferSize = this.ctx.getOptions().getStreamPackBufferSize();
            if (streamPackBufferSize > 0) {
                this.readAhead = (int) Math.min(streamPackBufferSize, j2 - j);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: open, reason: merged with bridge method [inline-methods] */
        public ReadableChannel m5676xa4b6974c() throws IOException {
            if (this.ch == null) {
                this.ch = this.ctx.db.openFile(this.file.desc, this.file.ext);
            }
            return this.ch;
        }

        @Override // org.eclipse.jgit.internal.storage.io.BlockSource, java.lang.AutoCloseable
        public void close() {
            ReadableChannel readableChannel = this.ch;
            if (readableChannel != null) {
                try {
                    readableChannel.close();
                } catch (IOException unused) {
                } finally {
                    this.ch = null;
                }
            }
        }
    }
}
