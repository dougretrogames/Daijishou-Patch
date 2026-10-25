package org.eclipse.jgit.util.io;

import java.io.IOException;
import java.io.OutputStream;
import org.eclipse.jgit.diff.RawText;

/* JADX INFO: loaded from: classes5.dex */
public class AutoLFOutputStream extends OutputStream {
    private byte[] binbuf;
    private int binbufcnt;
    private int buf;
    private boolean detectBinary;
    private boolean isBinary;
    private byte[] onebytebuf;
    private final OutputStream out;

    public AutoLFOutputStream(OutputStream outputStream) {
        this(outputStream, true);
    }

    public AutoLFOutputStream(OutputStream outputStream, boolean z) {
        this.buf = -1;
        this.binbuf = new byte[RawText.getBufferSize()];
        this.onebytebuf = new byte[1];
        this.binbufcnt = 0;
        this.out = outputStream;
        this.detectBinary = z;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        byte[] bArr = this.onebytebuf;
        bArr[0] = (byte) i;
        write(bArr, 0, 1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        int iBuffer = buffer(bArr, 0, bArr.length);
        if (iBuffer > 0) {
            write(bArr, bArr.length - iBuffer, iBuffer);
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        int iBuffer = buffer(bArr, i, i2);
        if (iBuffer <= 0) {
            return;
        }
        int i4 = (i + i2) - iBuffer;
        if (this.isBinary) {
            this.out.write(bArr, i4, iBuffer);
            return;
        }
        int i5 = i4;
        int i6 = i5;
        while (true) {
            i3 = i4 + iBuffer;
            if (i5 >= i3) {
                break;
            }
            byte b = bArr[i5];
            if (b != 10) {
                if (b == 13) {
                    if (i6 < i5) {
                        this.out.write(bArr, i6, i5 - i6);
                    }
                    i6 = i5 + 1;
                    this.buf = 13;
                } else {
                    if (this.buf == 13) {
                        this.out.write(13);
                        i6 = i5;
                    }
                    this.buf = -1;
                }
            } else if (this.buf == 13) {
                this.out.write(10);
                i6 = i5 + 1;
                this.buf = -1;
            } else {
                int i7 = i5 + 1;
                if (i6 < i7) {
                    this.out.write(bArr, i6, i7 - i6);
                }
                i6 = i7;
            }
            i5++;
        }
        if (i6 < i3) {
            this.out.write(bArr, i6, i3 - i6);
        }
    }

    private int buffer(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.binbufcnt;
        byte[] bArr2 = this.binbuf;
        if (i3 > bArr2.length) {
            return i2;
        }
        int iMin = Math.min(bArr2.length - i3, i2);
        System.arraycopy(bArr, i, this.binbuf, this.binbufcnt, iMin);
        this.binbufcnt += iMin;
        int i4 = i2 - iMin;
        if (i4 > 0) {
            decideMode(false);
        }
        return i4;
    }

    private void decideMode(boolean z) throws IOException {
        if (this.detectBinary) {
            boolean zIsBinary = RawText.isBinary(this.binbuf, this.binbufcnt, z);
            this.isBinary = zIsBinary;
            if (!zIsBinary) {
                this.isBinary = RawText.isCrLfText(this.binbuf, this.binbufcnt, z);
            }
            this.detectBinary = false;
        }
        int i = this.binbufcnt;
        byte[] bArr = this.binbuf;
        this.binbufcnt = bArr.length + 1;
        write(bArr, 0, i);
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        if (this.binbufcnt <= this.binbuf.length) {
            decideMode(true);
        }
        this.out.flush();
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        flush();
        int i = this.buf;
        if (i == 13) {
            this.out.write(i);
            this.buf = -1;
        }
        this.out.close();
    }
}
