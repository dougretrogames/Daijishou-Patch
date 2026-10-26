package org.eclipse.jgit.util.io;

import java.io.IOException;
import java.io.OutputStream;

/* INFO: loaded from: classes5.dex */
public class TeeOutputStream extends OutputStream {
    private final OutputStream stream1;
    private final OutputStream stream2;

    public TeeOutputStream(OutputStream outputStream, OutputStream outputStream2) {
        this.stream1 = outputStream;
        this.stream2 = outputStream2;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.stream1.write(bArr);
        this.stream2.write(bArr);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.stream1.write(bArr, i, i2);
        this.stream2.write(bArr, i, i2);
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.stream1.write(i);
        this.stream2.write(i);
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.stream1.flush();
        this.stream2.flush();
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            this.stream1.close();
        } finally {
            this.stream2.close();
        }
    }
}
