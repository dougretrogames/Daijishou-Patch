package org.eclipse.jgit.util.io;

import java.io.IOException;
import java.io.OutputStream;

/* INFO: loaded from: classes5.dex */
public class CountingOutputStream extends OutputStream {
    private long cnt;
    private final OutputStream out;

    public CountingOutputStream(OutputStream outputStream) {
        this.out = outputStream;
    }

    public long getCount() {
        return this.cnt;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.out.write(i);
        this.cnt++;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.out.write(bArr, i, i2);
        this.cnt += (long) i2;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.out.flush();
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.out.close();
    }
}
