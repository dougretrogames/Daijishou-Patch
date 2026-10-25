package org.eclipse.jgit.util.io;

import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
public class NullOutputStream extends OutputStream {
    public static final NullOutputStream INSTANCE = new NullOutputStream();

    @Override // java.io.OutputStream
    public void write(int i) {
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
    }

    private NullOutputStream() {
    }
}
