package com.googlecode.javaewah32;

import com.googlecode.javaewah.IntIterator;

/* INFO: loaded from: classes4.dex */
final class ReverseIntIterator32 implements IntIterator {
    private final Buffer32 buffer;
    private final ReverseEWAHIterator32 ewahIter;
    private boolean hasNext = moveToPreviousRLW();
    private int literalPosition;
    private int position;
    private boolean runningBit;
    private int runningLength;
    private final int sizeInBits;
    private int word;
    private int wordLength;
    private int wordPosition;

    ReverseIntIterator32(ReverseEWAHIterator32 reverseEWAHIterator32, int i) {
        this.ewahIter = reverseEWAHIterator32;
        this.sizeInBits = i;
        this.buffer = reverseEWAHIterator32.buffer();
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
            int i = this.word;
            int i2 = i & (-i);
            iBitCount = this.literalPosition - Integer.bitCount(i2 - 1);
            this.word = i2 ^ this.word;
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

    private void setRLW(RunningLengthWord32 runningLengthWord32) {
        int i;
        this.wordLength = runningLengthWord32.getNumberOfLiteralWords();
        this.wordPosition = this.ewahIter.position();
        int i2 = this.runningLength;
        this.position = i2;
        int runningLength = runningLengthWord32.getRunningLength();
        int i3 = this.wordLength;
        int i4 = i2 - ((runningLength + i3) * 32);
        this.runningLength = i4;
        int i5 = this.position;
        int i6 = this.sizeInBits;
        if (i5 == i6 - 1 && (i = i6 % 32) > 0) {
            int i7 = 32 - i;
            this.runningLength = i4 + i7;
            if (i3 > 0) {
                Buffer32 buffer32 = this.buffer;
                int i8 = this.wordPosition;
                this.wordLength = i3 - 1;
                this.word = Integer.reverse(buffer32.getWord(i8 + i3)) >>> i7;
                int i9 = this.position;
                this.literalPosition = i9;
                this.position = i9 - i;
            }
        }
        this.runningBit = runningLengthWord32.getRunningBit();
    }

    private boolean runningHasNext() {
        return this.runningBit && this.runningLength < this.position;
    }

    private boolean literalHasNext() {
        int i;
        int i2;
        while (true) {
            i = this.word;
            if (i != 0 || (i2 = this.wordLength) <= 0) {
                break;
            }
            Buffer32 buffer32 = this.buffer;
            int i3 = this.wordPosition;
            this.wordLength = i2 - 1;
            this.word = Integer.reverse(buffer32.getWord(i3 + i2));
            int i4 = this.position;
            this.literalPosition = i4;
            this.position = i4 - 32;
        }
        return i != 0;
    }
}
