package org.eclipse.jgit.util;

/* JADX INFO: loaded from: classes5.dex */
public final class RawCharSequence implements CharSequence {
    public static final RawCharSequence EMPTY = new RawCharSequence(null, 0, 0);
    final byte[] buffer;
    final int endPtr;
    final int startPtr;

    public RawCharSequence(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.startPtr = i;
        this.endPtr = i2;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return (char) (this.buffer[this.startPtr + i] & 255);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.endPtr - this.startPtr;
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        byte[] bArr = this.buffer;
        int i3 = this.startPtr;
        return new RawCharSequence(bArr, i + i3, i3 + i2);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        int length = length();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(charAt(i));
        }
        return sb.toString();
    }
}
