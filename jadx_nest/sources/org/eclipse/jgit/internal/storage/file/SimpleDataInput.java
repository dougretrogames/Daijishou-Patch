package org.eclipse.jgit.internal.storage.file;

import java.io.DataInput;
import java.io.IOException;
import java.io.InputStream;
import org.eclipse.jgit.util.IO;
import org.eclipse.jgit.util.NB;

/* JADX INFO: loaded from: classes5.dex */
class SimpleDataInput implements DataInput {
    private final byte[] buf = new byte[8];
    private final InputStream fd;

    SimpleDataInput(InputStream inputStream) {
        this.fd = inputStream;
    }

    @Override // java.io.DataInput
    public int readInt() throws IOException {
        readFully(this.buf, 0, 4);
        return NB.decodeInt32(this.buf, 0);
    }

    @Override // java.io.DataInput
    public long readLong() throws IOException {
        readFully(this.buf, 0, 8);
        return NB.decodeInt64(this.buf, 0);
    }

    public long readUnsignedInt() throws IOException {
        readFully(this.buf, 0, 4);
        return NB.decodeUInt32(this.buf, 0);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr) throws IOException {
        readFully(bArr, 0, bArr.length);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr, int i, int i2) throws IOException {
        IO.readFully(this.fd, bArr, i, i2);
    }

    @Override // java.io.DataInput
    public int skipBytes(int i) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.DataInput
    public boolean readBoolean() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.DataInput
    public byte readByte() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.DataInput
    public short readShort() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.DataInput
    public char readChar() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.DataInput
    public float readFloat() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.DataInput
    public double readDouble() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.DataInput
    public String readLine() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.DataInput
    public String readUTF() throws IOException {
        throw new UnsupportedOperationException();
    }
}
