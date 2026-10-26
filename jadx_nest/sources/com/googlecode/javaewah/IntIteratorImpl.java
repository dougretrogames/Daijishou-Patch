package com.googlecode.javaewah;

/* INFO: loaded from: classes4.dex */
final class IntIteratorImpl implements IntIterator {
    private final Buffer buffer;
    private final EWAHIterator ewahIter;
    private boolean hasNext = moveToNext();
    private int literalPosition;
    private int position;
    private int runningLength;
    private long word;
    private int wordLength;
    private int wordPosition;

    IntIteratorImpl(EWAHIterator eWAHIterator) {
        this.ewahIter = eWAHIterator;
        this.buffer = eWAHIterator.buffer();
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
        return this.hasNext;
    }

    @Override // com.googlecode.javaewah.IntIterator
    public int next() {
        int i;
        if (runningHasNext()) {
            i = this.position;
            this.position = i + 1;
        } else {
            long j = this.word;
            long j2 = j & (-j);
            int iBitCount = this.literalPosition + Long.bitCount(j2 - 1);
            this.word = j2 ^ this.word;
            i = iBitCount;
        }
        this.hasNext = moveToNext();
        return i;
    }

    private void setRunningLengthWord(RunningLengthWord runningLengthWord) {
        this.runningLength = (((int) runningLengthWord.getRunningLength()) * 64) + this.position;
        if (!runningLengthWord.getRunningBit()) {
            this.position = this.runningLength;
        }
        int iLiteralWords = this.ewahIter.literalWords();
        this.wordPosition = iLiteralWords;
        this.wordLength = iLiteralWords + runningLengthWord.getNumberOfLiteralWords();
    }

    private boolean runningHasNext() {
        return this.position < this.runningLength;
    }

    private boolean literalHasNext() {
        long j;
        int i;
        while (true) {
            j = this.word;
            if (j != 0 || (i = this.wordPosition) >= this.wordLength) {
                break;
            }
            Buffer buffer = this.buffer;
            this.wordPosition = i + 1;
            this.word = buffer.getWord(i);
            int i2 = this.position;
            this.literalPosition = i2;
            this.position = i2 + 64;
        }
        return j != 0;
    }
}
