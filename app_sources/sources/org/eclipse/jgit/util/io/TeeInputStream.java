package org.eclipse.jgit.util.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* INFO: loaded from: classes5.dex */
public class TeeInputStream extends InputStream {
    private OutputStream dst;
    private byte[] skipBuffer;
    private InputStream src;

    public TeeInputStream(InputStream inputStream, OutputStream outputStream) {
        this.src = inputStream;
        this.dst = outputStream;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        byte[] bArrSkipBuffer = skipBuffer();
        if (read(bArrSkipBuffer, 0, 1) == 1) {
            return bArrSkipBuffer[0] & 255;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        int i;
        byte[] bArrSkipBuffer = skipBuffer();
        long j2 = 0;
        while (0 < j && (i = this.src.read(bArrSkipBuffer, 0, (int) Math.min(bArrSkipBuffer.length, j))) > 0) {
            this.dst.write(bArrSkipBuffer, 0, i);
            long j3 = i;
            j2 += j3;
            j -= j3;
        }
        return j2;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.src.read(bArr, i, i2);
        if (i3 > 0) {
            this.dst.write(bArr, i, i3);
        }
        return i3;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        byte[] bArrSkipBuffer = skipBuffer();
        while (true) {
            int i = this.src.read(bArrSkipBuffer);
            if (i > 0) {
                this.dst.write(bArrSkipBuffer, 0, i);
            } else {
                this.dst.close();
                this.src.close();
                return;
            }
        }
    }

    private byte[] skipBuffer() {
        if (this.skipBuffer == null) {
            this.skipBuffer = new byte[2048];
        }
        return this.skipBuffer;
    }
}
