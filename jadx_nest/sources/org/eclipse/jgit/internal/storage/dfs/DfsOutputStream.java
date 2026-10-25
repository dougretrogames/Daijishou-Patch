package org.eclipse.jgit.internal.storage.dfs;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public abstract class DfsOutputStream extends OutputStream {
    public int blockSize() {
        return 0;
    }

    public abstract int read(long j, ByteBuffer byteBuffer) throws IOException;

    @Override // java.io.OutputStream
    public abstract void write(byte[] bArr, int i, int i2) throws IOException;

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        write(new byte[]{(byte) i});
    }
}
