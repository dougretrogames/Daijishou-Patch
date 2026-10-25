package org.eclipse.jgit.transport;

import java.io.IOException;
import java.io.OutputStream;
import java.text.MessageFormat;
import org.eclipse.jgit.internal.JGitText;

/* JADX INFO: loaded from: classes5.dex */
public class SideBandOutputStream extends OutputStream {
    public static final int CH_DATA = 1;
    public static final int CH_ERROR = 3;
    public static final int CH_PROGRESS = 2;
    static final int HDR_SIZE = 5;
    public static final int MAX_BUF = 65520;
    public static final int SMALL_BUF = 1000;
    private final byte[] buffer;
    private int cnt;
    private final OutputStream out;

    public SideBandOutputStream(int i, int i2, OutputStream outputStream) {
        if (i <= 0 || i > 255) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.get().channelMustBeInRange1_255, Integer.valueOf(i)));
        }
        if (i2 <= 5) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.get().packetSizeMustBeAtLeast, Integer.valueOf(i2), 5));
        }
        if (65520 < i2) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.get().packetSizeMustBeAtMost, Integer.valueOf(i2), Integer.valueOf(MAX_BUF)));
        }
        this.out = outputStream;
        byte[] bArr = new byte[i2];
        this.buffer = bArr;
        bArr[4] = (byte) i;
        this.cnt = 5;
    }

    void flushBuffer() throws IOException {
        if (5 < this.cnt) {
            writeBuffer();
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        flushBuffer();
        this.out.flush();
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        while (i2 > 0) {
            byte[] bArr2 = this.buffer;
            int length = bArr2.length;
            int i3 = this.cnt;
            int i4 = length - i3;
            if (i3 == 5 && i4 < i2) {
                PacketLineOut.formatLength(bArr2, bArr2.length);
                this.out.write(this.buffer, 0, 5);
                this.out.write(bArr, i, i4);
                i += i4;
                i2 -= i4;
            } else {
                if (i4 == 0) {
                    writeBuffer();
                }
                int iMin = Math.min(i2, i4);
                System.arraycopy(bArr, i, this.buffer, this.cnt, iMin);
                this.cnt += iMin;
                i += iMin;
                i2 -= iMin;
            }
        }
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        if (this.cnt == this.buffer.length) {
            writeBuffer();
        }
        byte[] bArr = this.buffer;
        int i2 = this.cnt;
        this.cnt = i2 + 1;
        bArr[i2] = (byte) i;
    }

    private void writeBuffer() throws IOException {
        PacketLineOut.formatLength(this.buffer, this.cnt);
        this.out.write(this.buffer, 0, this.cnt);
        this.cnt = 5;
    }
}
