package com.googlecode.javaewah;

/* INFO: loaded from: classes4.dex */
public final class BitCounter implements BitmapStorage {
    private int oneBits;

    @Override // com.googlecode.javaewah.BitmapStorage
    public void setSizeInBitsWithinLastWord(int i) {
    }

    @Override // com.googlecode.javaewah.BitmapStorage
    public void addWord(long j) {
        this.oneBits += Long.bitCount(j);
    }

    @Override // com.googlecode.javaewah.BitmapStorage
    public void addLiteralWord(long j) {
        this.oneBits += Long.bitCount(j);
    }

    @Override // com.googlecode.javaewah.BitmapStorage
    public void addStreamOfLiteralWords(Buffer buffer, int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            addLiteralWord(buffer.getWord(i3));
        }
    }

    @Override // com.googlecode.javaewah.BitmapStorage
    public void addStreamOfEmptyWords(boolean z, long j) {
        if (z) {
            this.oneBits += (int) (j * 64);
        }
    }

    @Override // com.googlecode.javaewah.BitmapStorage
    public void addStreamOfNegatedLiteralWords(Buffer buffer, int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            addLiteralWord(~buffer.getWord(i3));
        }
    }

    @Override // com.googlecode.javaewah.BitmapStorage
    public void clear() {
        this.oneBits = 0;
    }

    public int getCount() {
        return this.oneBits;
    }
}
