package org.apache.commons.codec.binary;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/* INFO: loaded from: classes5.dex */
public class BaseNCodecInputStream extends FilterInputStream {
    private final BaseNCodec baseNCodec;
    private final byte[] buf;
    private final BaseNCodec.Context context;
    private final boolean doEncode;
    private final byte[] singleByte;

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    protected BaseNCodecInputStream(InputStream inputStream, BaseNCodec baseNCodec, boolean z) {
        super(inputStream);
        this.singleByte = new byte[1];
        this.context = new BaseNCodec.Context();
        this.doEncode = z;
        this.baseNCodec = baseNCodec;
        this.buf = new byte[z ? 4096 : 8192];
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        return !this.context.eof ? 1 : 0;
    }

    public boolean isStrictDecoding() {
        return this.baseNCodec.isStrictDecoding();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i = read(this.singleByte, 0, 1);
        while (i == 0) {
            i = read(this.singleByte, 0, 1);
        }
        if (i <= 0) {
            return -1;
        }
        byte b = this.singleByte[0];
        return b < 0 ? b + 256 : b;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        Objects.requireNonNull(bArr, "array");
        if (i < 0 || i2 < 0 || i > bArr.length || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 == 0) {
            return 0;
        }
        int i3 = 0;
        while (i3 < i2) {
            if (!this.baseNCodec.hasData(this.context)) {
                int i4 = this.in.read(this.buf);
                if (this.doEncode) {
                    this.baseNCodec.encode(this.buf, 0, i4, this.context);
                } else {
                    this.baseNCodec.decode(this.buf, 0, i4, this.context);
                }
            }
            int results = this.baseNCodec.readResults(bArr, i + i3, i2 - i3, this.context);
            if (results < 0) {
                if (i3 != 0) {
                    break;
                }
                return -1;
            }
            i3 += results;
        }
        return i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        throw new IOException("mark/reset not supported");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        int i;
        if (j < 0) {
            throw new IllegalArgumentException("Negative skip length: " + j);
        }
        byte[] bArr = new byte[512];
        long j2 = j;
        while (j2 > 0 && (i = read(bArr, 0, (int) Math.min(512, j2))) != -1) {
            j2 -= (long) i;
        }
        return j - j2;
    }
}
