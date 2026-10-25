package com.googlecode.javaewah32;

import com.googlecode.javaewah.IntIterator;

/* JADX INFO: loaded from: classes4.dex */
final class IntIteratorImpl32 implements IntIterator {
    private final Buffer32 buffer;
    private final EWAHIterator32 ewahIter;
    private boolean hasnext = moveToNext();
    private int literalPosition;
    private int position;
    private int runningLength;
    private int word;
    private int wordLength;
    private int wordPosition;

    IntIteratorImpl32(EWAHIterator32 eWAHIterator32) {
        this.ewahIter = eWAHIterator32;
        this.buffer = eWAHIterator32.buffer();
    }

    public boolean moveToNext() {
        while (!runningHasNext() && !literalHasNext()) {
            if (!this.ewahIter.hasNext()) {
                return false;
            }
            setRunningLengthWord(this.ewahIter.next());
        }
        return true;
    }

    @Override // com.googlecode.javaewah.IntIterator
    public boolean hasNext() {
        return this.hasnext;
    }

    @Override // com.googlecode.javaewah.IntIterator
    public int next() {
        int i;
        if (runningHasNext()) {
            i = this.position;
            this.position = i + 1;
        } else {
            int i2 = this.word;
            int i3 = i2 & (-i2);
            int iBitCount = this.literalPosition + Integer.bitCount(i3 - 1);
            this.word = i3 ^ this.word;
            i = iBitCount;
        }
        this.hasnext = moveToNext();
        return i;
    }

    private void setRunningLengthWord(RunningLengthWord32 runningLengthWord32) {
        this.runningLength = (runningLengthWord32.getRunningLength() * 32) + this.position;
        if (!runningLengthWord32.getRunningBit()) {
            this.position = this.runningLength;
        }
        int iLiteralWords = this.ewahIter.literalWords();
        this.wordPosition = iLiteralWords;
        this.wordLength = iLiteralWords + runningLengthWord32.getNumberOfLiteralWords();
    }

    private boolean runningHasNext() {
        return this.position < this.runningLength;
    }

    private boolean literalHasNext() {
        int i;
        int i2;
        while (true) {
            i = this.word;
            if (i != 0 || (i2 = this.wordPosition) >= this.wordLength) {
                break;
            }
            Buffer32 buffer32 = this.buffer;
            this.wordPosition = i2 + 1;
            this.word = buffer32.getWord(i2);
            int i3 = this.position;
            this.literalPosition = i3;
            this.position = i3 + 32;
        }
        return i != 0;
    }
}
