package org.eclipse.jgit.util.io;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.CommitConfig$$ExternalSyntheticBackport0;

/* INFO: loaded from: classes5.dex */
public class ByteBufferInputStream extends InputStream {
    private ByteBuffer buf;

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    public ByteBufferInputStream(ByteBuffer byteBuffer) {
        this.buf = byteBuffer;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        nullCheck();
        if (this.buf.hasRemaining()) {
            return this.buf.get() & 255;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        nullCheck();
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        nullCheck();
        CommitConfig$$ExternalSyntheticBackport0.m(i, i2, bArr.length);
        if (i2 == 0) {
            return 0;
        }
        int iMin = Math.min(this.buf.remaining(), i2);
        if (iMin == 0) {
            return -1;
        }
        this.buf.get(bArr, i, iMin);
        return iMin;
    }

    @Override // java.io.InputStream
    public byte[] readAllBytes() throws IOException {
        return readNBytes(this.buf.remaining());
    }

    @Override // java.io.InputStream
    public byte[] readNBytes(int i) throws IOException {
        byte[] bArr = new byte[Math.min(i, this.buf.remaining())];
        read(bArr);
        return bArr;
    }

    @Override // java.io.InputStream
    public int readNBytes(byte[] bArr, int i, int i2) throws IOException {
        return read(bArr, i, i2);
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        int iMin;
        nullCheck();
        if (j <= 0) {
            return 0L;
        }
        if (j > 2147483647L) {
            iMin = this.buf.remaining();
        } else {
            iMin = Math.min((int) j, this.buf.remaining());
        }
        ByteBuffer byteBuffer = this.buf;
        return iMin;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        nullCheck();
        return this.buf.remaining();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.buf = null;
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i) {
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        try {
        } catch (InvalidMarkException e) {
            throw new IOException(e);
        }
    }

    private void nullCheck() throws IOException {
        if (this.buf == null) {
            throw new IOException(JGitText.get().inputStreamClosed);
        }
    }
}
