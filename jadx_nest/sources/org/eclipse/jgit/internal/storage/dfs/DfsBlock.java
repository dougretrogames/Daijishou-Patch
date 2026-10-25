package org.eclipse.jgit.internal.storage.dfs;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import org.eclipse.jgit.internal.storage.pack.PackOutputStream;

/* JADX INFO: loaded from: classes5.dex */
final class DfsBlock {
    private final byte[] block;
    final long end;
    final long start;
    final DfsStreamKey stream;

    DfsBlock(DfsStreamKey dfsStreamKey, long j, byte[] bArr) {
        this.stream = dfsStreamKey;
        this.start = j;
        this.end = j + ((long) bArr.length);
        this.block = bArr;
    }

    int size() {
        return this.block.length;
    }

    ByteBuffer zeroCopyByteBuffer(int i) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(this.block);
        return byteBufferWrap;
    }

    boolean contains(DfsStreamKey dfsStreamKey, long j) {
        return this.stream.equals(dfsStreamKey) && this.start <= j && j < this.end;
    }

    int copy(long j, byte[] bArr, int i, int i2) {
        return copy((int) (j - this.start), bArr, i, i2);
    }

    int copy(int i, byte[] bArr, int i2, int i3) {
        int iMin = Math.min(this.block.length - i, i3);
        System.arraycopy(this.block, i, bArr, i2, iMin);
        return iMin;
    }

    int setInput(long j, Inflater inflater) throws DataFormatException {
        int i = (int) (j - this.start);
        byte[] bArr = this.block;
        int length = bArr.length - i;
        if (length <= 0) {
            throw new DataFormatException(length + " bytes to inflate: at pos=" + j + "; block.start=" + this.start + "; ptr=" + i + "; block.length=" + this.block.length);
        }
        inflater.setInput(bArr, i, length);
        return length;
    }

    void crc32(CRC32 crc32, long j, int i) {
        crc32.update(this.block, (int) (j - this.start), i);
    }

    void write(PackOutputStream packOutputStream, long j, int i) throws IOException {
        packOutputStream.write(this.block, (int) (j - this.start), i);
    }

    void check(Inflater inflater, byte[] bArr, long j, int i) throws DataFormatException {
        inflater.setInput(this.block, (int) (j - this.start), i);
        while (inflater.inflate(bArr, 0, bArr.length) > 0) {
        }
    }
}
