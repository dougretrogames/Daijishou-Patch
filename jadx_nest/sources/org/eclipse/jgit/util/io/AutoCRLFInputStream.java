package org.eclipse.jgit.util.io;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.InputStream;
import org.eclipse.jgit.diff.RawText;

/* JADX INFO: loaded from: classes5.dex */
public class AutoCRLFInputStream extends InputStream {
    private int cnt;
    private boolean detectBinary;
    private final InputStream in;
    private boolean isBinary;
    private byte last;
    private int ptr;
    private final byte[] single = new byte[1];
    private final byte[] buf = new byte[RawText.getBufferSize()];

    public AutoCRLFInputStream(InputStream inputStream, boolean z) {
        this.in = inputStream;
        this.detectBinary = z;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.single, 0, 1) == 1) {
            return this.single[0] & 255;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        if (i2 == 0) {
            return 0;
        }
        if (this.cnt == -1) {
            return -1;
        }
        int i4 = i2 + i;
        int i5 = i;
        while (i5 < i4 && (this.ptr != this.cnt || fillBuffer())) {
            byte[] bArr2 = this.buf;
            int i6 = this.ptr;
            this.ptr = i6 + 1;
            byte b = bArr2[i6];
            if (this.isBinary || b != 10) {
                i3 = i5 + 1;
                this.last = b;
                bArr[i5] = b;
                i5 = i3;
            } else {
                if (b == 10) {
                    if (this.last == 13) {
                        i3 = i5 + 1;
                        this.last = b;
                        bArr[i5] = b;
                    } else {
                        this.last = Ascii.CR;
                        bArr[i5] = Ascii.CR;
                        this.ptr = i6;
                        i5++;
                    }
                } else {
                    i3 = i5 + 1;
                    this.last = b;
                    bArr[i5] = b;
                }
                i5 = i3;
            }
        }
        int i7 = i5 != i ? i5 - i : -1;
        if (i7 > 0) {
            this.last = bArr[i5 - 1];
        }
        return i7;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.in.close();
    }

    private boolean fillBuffer() throws IOException {
        int i;
        this.cnt = 0;
        while (true) {
            int i2 = this.cnt;
            byte[] bArr = this.buf;
            if (i2 >= bArr.length || (i = this.in.read(bArr, i2, bArr.length - i2)) < 0) {
                break;
            }
            this.cnt += i;
        }
        int i3 = this.cnt;
        if (i3 < 1) {
            this.cnt = -1;
            return false;
        }
        if (this.detectBinary) {
            byte[] bArr2 = this.buf;
            this.isBinary = RawText.isBinary(bArr2, i3, i3 < bArr2.length);
            this.detectBinary = false;
        }
        this.ptr = 0;
        return true;
    }
}
