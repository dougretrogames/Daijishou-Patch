package com.googlecode.javaewah32;

/* JADX INFO: loaded from: classes4.dex */
public final class BitCounter32 implements BitmapStorage32 {
    private int oneBits;

    @Override // com.googlecode.javaewah32.BitmapStorage32
    public void setSizeInBitsWithinLastWord(int i) {
    }

    @Override // com.googlecode.javaewah32.BitmapStorage32
    public void addWord(int i) {
        this.oneBits += Integer.bitCount(i);
    }

    @Override // com.googlecode.javaewah32.BitmapStorage32
    public void addLiteralWord(int i) {
        this.oneBits += Integer.bitCount(i);
    }

    @Override // com.googlecode.javaewah32.BitmapStorage32
    public void addStreamOfLiteralWords(Buffer32 buffer32, int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            addLiteralWord(buffer32.getWord(i3));
        }
    }

    @Override // com.googlecode.javaewah32.BitmapStorage32
    public void addStreamOfEmptyWords(boolean z, int i) {
        if (z) {
            this.oneBits += i * 32;
        }
    }

    @Override // com.googlecode.javaewah32.BitmapStorage32
    public void addStreamOfNegatedLiteralWords(Buffer32 buffer32, int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            addLiteralWord(~buffer32.getWord(i3));
        }
    }

    @Override // com.googlecode.javaewah32.BitmapStorage32
    public void clear() {
        this.oneBits = 0;
    }

    public int getCount() {
        return this.oneBits;
    }
}
