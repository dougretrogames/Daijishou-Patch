package org.eclipse.jgit.internal.storage.file;

import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import org.eclipse.jgit.internal.storage.pack.PackOutputStream;

/* JADX INFO: loaded from: classes5.dex */
abstract class ByteWindow {
    protected final long end;
    protected final Pack pack;
    protected final long start;

    protected abstract int copy(int i, byte[] bArr, int i2, int i3);

    protected abstract int setInput(int i, Inflater inflater) throws DataFormatException;

    abstract void write(PackOutputStream packOutputStream, long j, int i) throws IOException;

    protected ByteWindow(Pack pack, long j, int i) {
        this.pack = pack;
        this.start = j;
        this.end = j + ((long) i);
    }

    final int size() {
        return (int) (this.end - this.start);
    }

    final boolean contains(Pack pack, long j) {
        return this.pack == pack && this.start <= j && j < this.end;
    }

    final int copy(long j, byte[] bArr, int i, int i2) {
        return copy((int) (j - this.start), bArr, i, i2);
    }

    final int setInput(long j, Inflater inflater) throws DataFormatException {
        return setInput((int) (j - this.start), inflater);
    }
}
