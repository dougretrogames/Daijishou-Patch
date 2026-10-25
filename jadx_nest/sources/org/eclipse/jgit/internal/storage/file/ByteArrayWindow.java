package org.eclipse.jgit.internal.storage.file;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import org.eclipse.jgit.internal.storage.pack.PackOutputStream;

/* JADX INFO: loaded from: classes5.dex */
final class ByteArrayWindow extends ByteWindow {
    private final byte[] array;

    ByteArrayWindow(Pack pack, long j, byte[] bArr) {
        super(pack, j, bArr.length);
        this.array = bArr;
    }

    @Override // org.eclipse.jgit.internal.storage.file.ByteWindow
    protected int copy(int i, byte[] bArr, int i2, int i3) {
        int iMin = Math.min(this.array.length - i, i3);
        System.arraycopy(this.array, i, bArr, i2, iMin);
        return iMin;
    }

    @Override // org.eclipse.jgit.internal.storage.file.ByteWindow
    protected int setInput(int i, Inflater inflater) throws DataFormatException {
        byte[] bArr = this.array;
        int length = bArr.length - i;
        inflater.setInput(bArr, i, length);
        return length;
    }

    void crc32(CRC32 crc32, long j, int i) {
        crc32.update(this.array, (int) (j - this.start), i);
    }

    @Override // org.eclipse.jgit.internal.storage.file.ByteWindow
    void write(PackOutputStream packOutputStream, long j, int i) throws IOException {
        packOutputStream.write(this.array, (int) (j - this.start), i);
    }

    void check(Inflater inflater, byte[] bArr, long j, int i) throws DataFormatException {
        inflater.setInput(this.array, (int) (j - this.start), i);
        while (inflater.inflate(bArr, 0, bArr.length) > 0) {
        }
    }
}
