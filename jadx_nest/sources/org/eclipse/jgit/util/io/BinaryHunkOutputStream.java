package org.eclipse.jgit.util.io;

import java.io.IOException;
import java.io.OutputStream;
import org.eclipse.jgit.util.Base85;

/* JADX INFO: loaded from: classes5.dex */
public class BinaryHunkOutputStream extends OutputStream {
    private static final int MAX_BYTES = 52;
    private final byte[] buffer = new byte[52];
    private final OutputStream out;
    private int pos;

    public BinaryHunkOutputStream(OutputStream outputStream) {
        this.out = outputStream;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        flush();
        this.out.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        int i = this.pos;
        if (i > 0) {
            encode(this.buffer, 0, i);
            this.pos = 0;
        }
        this.out.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        byte[] bArr = this.buffer;
        int i2 = this.pos;
        int i3 = i2 + 1;
        this.pos = i3;
        bArr[i2] = (byte) i;
        if (i3 == bArr.length) {
            encode(bArr, 0, i3);
            this.pos = 0;
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return;
        }
        int i3 = this.pos;
        if (i3 > 0) {
            int iMin = Math.min(i2, this.buffer.length - i3);
            System.arraycopy(bArr, i, this.buffer, this.pos, iMin);
            i += iMin;
            int i4 = this.pos + iMin;
            this.pos = i4;
            i2 -= iMin;
            byte[] bArr2 = this.buffer;
            if (i4 == bArr2.length) {
                encode(bArr2, 0, i4);
                this.pos = 0;
            }
            if (i2 == 0) {
                return;
            }
        }
        while (i2 >= 52) {
            encode(bArr, i, 52);
            i2 -= 52;
            i += 52;
        }
        if (i2 > 0) {
            System.arraycopy(bArr, i, this.buffer, 0, i2);
            this.pos = i2;
        }
    }

    private void encode(byte[] bArr, int i, int i2) throws IOException {
        if (i2 <= 26) {
            this.out.write(i2 + 64);
        } else {
            this.out.write(i2 + 70);
        }
        this.out.write(Base85.encode(bArr, i, i2));
        this.out.write(10);
    }
}
