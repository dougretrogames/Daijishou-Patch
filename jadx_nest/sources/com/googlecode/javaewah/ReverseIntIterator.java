package com.googlecode.javaewah;

/* JADX INFO: loaded from: classes4.dex */
final class ReverseIntIterator implements IntIterator {
    private final Buffer buffer;
    private final ReverseEWAHIterator ewahIter;
    private boolean hasNext = moveToPreviousRLW();
    private int literalPosition;
    private int position;
    private boolean runningBit;
    private int runningLength;
    private final int sizeInBits;
    private long word;
    private int wordLength;
    private int wordPosition;

    ReverseIntIterator(ReverseEWAHIterator reverseEWAHIterator, int i) {
        this.ewahIter = reverseEWAHIterator;
        this.sizeInBits = i;
        this.buffer = reverseEWAHIterator.buffer();
        this.runningLength = i - 1;
    }

    @Override // com.googlecode.javaewah.IntIterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // com.googlecode.javaewah.IntIterator
    public int next() {
        int iBitCount;
        if (literalHasNext()) {
            long j = this.word;
            long j2 = j & (-j);
            iBitCount = this.literalPosition - Long.bitCount(j2 - 1);
            this.word = j2 ^ this.word;
        } else {
            iBitCount = this.position;
            this.position = iBitCount - 1;
        }
        this.hasNext = moveToPreviousRLW();
        return iBitCount;
    }

    private boolean moveToPreviousRLW() {
        while (!literalHasNext() && !runningHasNext()) {
            if (!this.ewahIter.hasPrevious()) {
                return false;
            }
            setRLW(this.ewahIter.previous());
        }
        return true;
    }

    private void setRLW(RunningLengthWord runningLengthWord) {
        int i;
        this.wordLength = runningLengthWord.getNumberOfLiteralWords();
        this.wordPosition = this.ewahIter.position();
        int i2 = this.runningLength;
        this.position = i2;
        long runningLength = runningLengthWord.getRunningLength();
        int i3 = this.wordLength;
        int i4 = (int) (((long) i2) - ((runningLength + ((long) i3)) * 64));
        this.runningLength = i4;
        int i5 = this.position;
        int i6 = this.sizeInBits;
        if (i5 == i6 - 1 && (i = i6 % 64) > 0) {
            int i7 = 64 - i;
            this.runningLength = i4 + i7;
            if (i3 > 0) {
                Buffer buffer = this.buffer;
                int i8 = this.wordPosition;
                this.wordLength = i3 - 1;
                this.word = Long.reverse(buffer.getWord(i8 + i3)) >>> i7;
                int i9 = this.position;
                this.literalPosition = i9;
                this.position = i9 - i;
            }
        }
        this.runningBit = runningLengthWord.getRunningBit();
    }

    private boolean runningHasNext() {
        return this.runningBit && this.runningLength < this.position;
    }

    private boolean literalHasNext() {
        long j;
        int i;
        while (true) {
            j = this.word;
            if (j != 0 || (i = this.wordLength) <= 0) {
                break;
            }
            Buffer buffer = this.buffer;
            int i2 = this.wordPosition;
            this.wordLength = i - 1;
            this.word = Long.reverse(buffer.getWord(i2 + i));
            int i3 = this.position;
            this.literalPosition = i3;
            this.position = i3 - 64;
        }
        return j != 0;
    }
}
