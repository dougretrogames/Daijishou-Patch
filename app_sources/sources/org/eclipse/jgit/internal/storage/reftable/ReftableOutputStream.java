package org.eclipse.jgit.internal.storage.reftable;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.util.NB;
import org.eclipse.jgit.util.io.CountingOutputStream;

/* INFO: loaded from: classes5.dex */
class ReftableOutputStream extends OutputStream {
    private final boolean alignBlocks;
    private byte[] blockBuf;
    private int blockSize;
    private int blockStart;
    private int blockType;
    private DeflaterOutputStream compressor;
    private int cur;
    private Deflater deflater;
    private final CountingOutputStream out;
    private long paddingUsed;
    private final byte[] tmp = new byte[10];

    static int computeVarintSize(long j) {
        int i = 1;
        while (true) {
            long j2 = j >>> 7;
            if (j2 == 0) {
                return i;
            }
            j = j2 - 1;
            i++;
        }
    }

    ReftableOutputStream(OutputStream outputStream, int i, boolean z) {
        this.blockSize = i;
        this.blockBuf = new byte[i];
        this.alignBlocks = z;
        this.out = new CountingOutputStream(outputStream);
    }

    void setBlockSize(int i) {
        this.blockSize = i;
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        ensureBytesAvailableInBlockBuf(1);
        byte[] bArr = this.blockBuf;
        int i2 = this.cur;
        this.cur = i2 + 1;
        bArr[i2] = (byte) i;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        ensureBytesAvailableInBlockBuf(i2);
        System.arraycopy(bArr, i, this.blockBuf, this.cur, i2);
        this.cur += i2;
    }

    int bytesWrittenInBlock() {
        return this.cur;
    }

    int bytesAvailableInBlock() {
        return this.blockSize - this.cur;
    }

    long paddingUsed() {
        return this.paddingUsed;
    }

    long size() {
        return this.out.getCount();
    }

    void writeVarint(long j) {
        byte[] bArr = this.tmp;
        int length = bArr.length - 1;
        bArr[length] = (byte) (j & 127);
        while (true) {
            long j2 = j >>> 7;
            if (j2 != 0) {
                length--;
                j = j2 - 1;
                this.tmp[length] = (byte) ((j & 127) | 128);
            } else {
                byte[] bArr2 = this.tmp;
                write(bArr2, length, bArr2.length - length);
                return;
            }
        }
    }

    void writeInt16(int i) {
        ensureBytesAvailableInBlockBuf(2);
        NB.encodeInt16(this.blockBuf, this.cur, i);
        this.cur += 2;
    }

    void writeInt24(int i) {
        ensureBytesAvailableInBlockBuf(3);
        NB.encodeInt24(this.blockBuf, this.cur, i);
        this.cur += 3;
    }

    void writeId(ObjectId objectId) {
        ensureBytesAvailableInBlockBuf(20);
        objectId.copyRawTo(this.blockBuf, this.cur);
        this.cur += 20;
    }

    void writeVarintString(String str) {
        writeVarintString(str.getBytes(StandardCharsets.UTF_8));
    }

    void writeVarintString(byte[] bArr) {
        writeVarint(bArr.length);
        write(bArr, 0, bArr.length);
    }

    private void ensureBytesAvailableInBlockBuf(int i) {
        int i2 = this.cur;
        int i3 = i2 + i;
        byte[] bArr = this.blockBuf;
        if (i3 > bArr.length) {
            this.blockBuf = Arrays.copyOf(this.blockBuf, Math.max(i2 + i, bArr.length * 2));
        }
    }

    void flushFileHeader() throws IOException {
        if (this.cur == 24 && this.out.getCount() == 0) {
            this.out.write(this.blockBuf, 0, this.cur);
            this.cur = 0;
        }
    }

    void beginBlock(byte b) {
        this.blockType = b;
        int i = this.cur;
        this.blockStart = i;
        this.cur = i + 4;
    }

    void flushBlock() throws IOException {
        int i = this.cur;
        if (i > this.blockSize && this.blockType != 105) {
            throw new IOException(JGitText.get().overflowedReftableBlock);
        }
        NB.encodeInt32(this.blockBuf, this.blockStart, i | (this.blockType << 24));
        if (this.blockType == 103) {
            this.out.write(this.blockBuf, 0, 4);
            Deflater deflater = this.deflater;
            if (deflater != null) {
                deflater.reset();
            } else {
                this.deflater = new Deflater(9);
                this.compressor = new DeflaterOutputStream(this.out, this.deflater);
            }
            this.compressor.write(this.blockBuf, 4, this.cur - 4);
            this.compressor.finish();
        } else {
            this.out.write(this.blockBuf, 0, this.cur);
        }
        this.cur = 0;
        this.blockType = 0;
        this.blockStart = 0;
    }

    void padBetweenBlocksToNextBlock() throws IOException {
        if (this.alignBlocks) {
            long size = size();
            int i = this.blockSize;
            long j = size % ((long) i);
            if (j > 0) {
                int i2 = i - ((int) j);
                ensureBytesAvailableInBlockBuf(i2);
                Arrays.fill(this.blockBuf, 0, i2, (byte) 0);
                this.out.write(this.blockBuf, 0, i2);
                this.paddingUsed += (long) i2;
            }
        }
    }

    int estimatePadBetweenBlocks(int i) {
        if (this.alignBlocks) {
            long size = size() + ((long) i);
            int i2 = this.blockSize;
            long j = size % ((long) i2);
            if (j > 0) {
                return i2 - ((int) j);
            }
        }
        return 0;
    }

    void finishFile() throws IOException {
        this.out.write(this.blockBuf, 0, this.cur);
        this.cur = 0;
        Deflater deflater = this.deflater;
        if (deflater != null) {
            deflater.end();
        }
    }
}
