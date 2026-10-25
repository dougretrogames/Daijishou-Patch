package org.eclipse.jgit.internal.storage.pack;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.io.OutputStream;
import org.eclipse.jgit.lib.Constants;

/* JADX INFO: loaded from: classes5.dex */
public class DeltaEncoder {
    private static final int MAX_COPY_CMD_SIZE = 8;
    private static final int MAX_INSERT_DATA_SIZE = 127;
    private static final int MAX_V2_COPY = 65536;
    private final byte[] buf;
    private final int limit;
    private final OutputStream out;
    private int size;

    public DeltaEncoder(OutputStream outputStream, long j, long j2) throws IOException {
        this(outputStream, j, j2, 0);
    }

    public DeltaEncoder(OutputStream outputStream, long j, long j2, int i) throws IOException {
        this.buf = new byte[32];
        this.out = outputStream;
        this.limit = i;
        writeVarint(j);
        writeVarint(j2);
    }

    private void writeVarint(long j) throws IOException {
        int i = 0;
        while (j >= 128) {
            this.buf[i] = (byte) ((((int) j) & 127) | 128);
            j >>>= 7;
            i++;
        }
        byte[] bArr = this.buf;
        int i2 = i + 1;
        bArr[i] = (byte) (((int) j) & 127);
        int i3 = this.size + i2;
        this.size = i3;
        int i4 = this.limit;
        if (i4 == 0 || i3 < i4) {
            this.out.write(bArr, 0, i2);
        }
    }

    public int getSize() {
        return this.size;
    }

    public boolean insert(String str) throws IOException {
        return insert(Constants.encode(str));
    }

    public boolean insert(byte[] bArr) throws IOException {
        return insert(bArr, 0, bArr.length);
    }

    public boolean insert(byte[] bArr, int i, int i2) throws IOException {
        if (i2 <= 0) {
            return true;
        }
        int i3 = this.limit;
        if (i3 != 0) {
            int i4 = i2 / 127;
            if (i2 % 127 != 0) {
                i4++;
            }
            if (i3 < this.size + i4 + i2) {
                return false;
            }
        }
        do {
            int iMin = Math.min(127, i2);
            this.out.write((byte) iMin);
            this.out.write(bArr, i, iMin);
            i += iMin;
            i2 -= iMin;
            this.size += iMin + 1;
        } while (i2 > 0);
        return true;
    }

    public boolean copy(long j, int i) throws IOException {
        byte[] bArr;
        if (i == 0) {
            return true;
        }
        while (true) {
            int iEncodeCopy = 0;
            do {
                if (65536 < i) {
                    iEncodeCopy = encodeCopy(iEncodeCopy, j, 65536);
                    j += PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                    i -= 65536;
                    bArr = this.buf;
                } else {
                    int iEncodeCopy2 = encodeCopy(iEncodeCopy, j, i);
                    int i2 = this.limit;
                    if (i2 != 0 && i2 < this.size + iEncodeCopy2) {
                        return false;
                    }
                    this.out.write(this.buf, 0, iEncodeCopy2);
                    this.size += iEncodeCopy2;
                    return true;
                }
            } while (bArr.length >= iEncodeCopy + 8);
            int i3 = this.limit;
            if (i3 != 0 && i3 < this.size + iEncodeCopy) {
                return false;
            }
            this.out.write(bArr, 0, iEncodeCopy);
            this.size += iEncodeCopy;
        }
    }

    private int encodeCopy(int i, long j, int i2) {
        int i3;
        int i4;
        int i5 = i + 1;
        byte b = (byte) (j & 255);
        if (b != 0) {
            i3 = i + 2;
            this.buf[i5] = b;
            i4 = 129;
        } else {
            i3 = i5;
            i4 = 128;
        }
        byte b2 = (byte) ((j >>> 8) & 255);
        if (b2 != 0) {
            i4 |= 2;
            this.buf[i3] = b2;
            i3++;
        }
        byte b3 = (byte) ((j >>> 16) & 255);
        if (b3 != 0) {
            i4 |= 4;
            this.buf[i3] = b3;
            i3++;
        }
        byte b4 = (byte) ((j >>> 24) & 255);
        if (b4 != 0) {
            i4 |= 8;
            this.buf[i3] = b4;
            i3++;
        }
        if (i2 != 65536) {
            byte b5 = (byte) (i2 & 255);
            if (b5 != 0) {
                i4 |= 16;
                this.buf[i3] = b5;
                i3++;
            }
            byte b6 = (byte) ((i2 >>> 8) & 255);
            if (b6 != 0) {
                this.buf[i3] = b6;
                i4 |= 32;
                i3++;
            }
            byte b7 = (byte) ((i2 >>> 16) & 255);
            if (b7 != 0) {
                i4 |= 64;
                this.buf[i3] = b7;
                i3++;
            }
        }
        this.buf[i] = (byte) i4;
        return i3;
    }
}
