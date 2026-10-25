package org.eclipse.jgit.merge;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
class EolAwareOutputStream extends OutputStream {
    private boolean bol = true;
    private final OutputStream out;

    EolAwareOutputStream(OutputStream outputStream) {
        this.out = outputStream;
    }

    void beginln() throws IOException {
        if (this.bol) {
            return;
        }
        write(10);
    }

    boolean isBeginln() {
        return this.bol;
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        this.out.write(i);
        this.bol = i == 10;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (i2 > 0) {
            this.out.write(bArr, i, i2);
            this.bol = bArr[i + (i2 - 1)] == 10;
        }
    }
}
