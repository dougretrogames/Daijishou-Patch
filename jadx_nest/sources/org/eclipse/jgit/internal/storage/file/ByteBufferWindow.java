package org.eclipse.jgit.internal.storage.file;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import org.eclipse.jgit.internal.storage.pack.PackOutputStream;

/* JADX INFO: loaded from: classes5.dex */
final class ByteBufferWindow extends ByteWindow {
    private final ByteBuffer buffer;

    ByteBufferWindow(Pack pack, long j, ByteBuffer byteBuffer) {
        super(pack, j, byteBuffer.capacity());
        this.buffer = byteBuffer;
    }

    @Override // org.eclipse.jgit.internal.storage.file.ByteWindow
    protected int copy(int i, byte[] bArr, int i2, int i3) {
        ByteBuffer byteBufferSlice = this.buffer.slice();
        int iMin = Math.min(byteBufferSlice.remaining(), i3);
        byteBufferSlice.get(bArr, i2, iMin);
        return iMin;
    }

    @Override // org.eclipse.jgit.internal.storage.file.ByteWindow
    void write(PackOutputStream packOutputStream, long j, int i) throws IOException {
        ByteBuffer byteBufferSlice = this.buffer.slice();
        while (i > 0) {
            byte[] copyBuffer = packOutputStream.getCopyBuffer();
            int iMin = Math.min(i, copyBuffer.length);
            byteBufferSlice.get(copyBuffer, 0, iMin);
            packOutputStream.write(copyBuffer, 0, iMin);
            i -= iMin;
        }
    }

    @Override // org.eclipse.jgit.internal.storage.file.ByteWindow
    protected int setInput(int i, Inflater inflater) throws DataFormatException {
        ByteBuffer byteBufferSlice = this.buffer.slice();
        int iMin = Math.min(byteBufferSlice.remaining(), 512);
        byte[] bArr = new byte[iMin];
        byteBufferSlice.get(bArr, 0, iMin);
        inflater.setInput(bArr, 0, iMin);
        return iMin;
    }
}
