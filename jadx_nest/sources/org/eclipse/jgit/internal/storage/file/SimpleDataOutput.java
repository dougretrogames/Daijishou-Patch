package org.eclipse.jgit.internal.storage.file;

import java.io.DataOutput;
import java.io.IOException;
import java.io.OutputStream;
import org.eclipse.jgit.util.NB;

/* JADX INFO: loaded from: classes5.dex */
class SimpleDataOutput implements DataOutput {
    private final byte[] buf = new byte[8];
    private final OutputStream fd;

    SimpleDataOutput(OutputStream outputStream) {
        this.fd = outputStream;
    }

    @Override // java.io.DataOutput
    public void writeShort(int i) throws IOException {
        NB.encodeInt16(this.buf, 0, i);
        this.fd.write(this.buf, 0, 2);
    }

    @Override // java.io.DataOutput
    public void writeInt(int i) throws IOException {
        NB.encodeInt32(this.buf, 0, i);
        this.fd.write(this.buf, 0, 4);
    }

    @Override // java.io.DataOutput
    public void writeLong(long j) throws IOException {
        NB.encodeInt64(this.buf, 0, j);
        this.fd.write(this.buf, 0, 8);
    }

    @Override // java.io.DataOutput
    public void write(int i) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.DataOutput
    public void write(byte[] bArr) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.DataOutput
    public void write(byte[] bArr, int i, int i2) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.DataOutput
    public void writeBoolean(boolean z) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.DataOutput
    public void writeByte(int i) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.DataOutput
    public void writeChar(int i) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.DataOutput
    public void writeFloat(float f) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.DataOutput
    public void writeDouble(double d) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.DataOutput
    public void writeBytes(String str) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.DataOutput
    public void writeChars(String str) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.DataOutput
    public void writeUTF(String str) throws IOException {
        throw new UnsupportedOperationException();
    }
}
