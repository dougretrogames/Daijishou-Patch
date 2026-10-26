package org.eclipse.jgit.internal.storage.file;

import java.io.IOException;
import java.io.InputStream;

/* INFO: loaded from: classes5.dex */
class PackInputStream extends InputStream {
    private final Pack pack;
    private long pos;
    private final WindowCursor wc;

    PackInputStream(Pack pack, long j, WindowCursor windowCursor) throws IOException {
        this.pack = pack;
        this.pos = j;
        this.wc = windowCursor;
        windowCursor.pin(pack, j);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int iCopy = this.wc.copy(this.pack, this.pos, bArr, i, i2);
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
        this.wc.close();
    }
}
