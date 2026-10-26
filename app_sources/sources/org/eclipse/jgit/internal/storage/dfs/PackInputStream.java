package org.eclipse.jgit.internal.storage.dfs;

import java.io.IOException;
import java.io.InputStream;

/* INFO: loaded from: classes5.dex */
final class PackInputStream extends InputStream {
    final DfsReader ctx;
    private final DfsPackFile pack;
    private long pos;

    PackInputStream(DfsPackFile dfsPackFile, long j, DfsReader dfsReader) throws IOException {
        this.pack = dfsPackFile;
        this.pos = j;
        this.ctx = dfsReader;
        dfsReader.pin(dfsPackFile, j);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int iCopy = this.ctx.copy(this.pack, this.pos, bArr, i, i2);
        this.pos += (long) iCopy;
        return iCopy;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        byte[] bArr = new byte[1];
        if (read(bArr, 0, 1) == 1) {
            return bArr[0] & 255;
        }
        return -1;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.ctx.close();
    }
}
