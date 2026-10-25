package com.googlecode.javaewah;

/* JADX INFO: loaded from: classes4.dex */
final class ClearIntIterator implements IntIterator {
    private final Buffer buffer;
    private final EWAHIterator ewahIter;
    private boolean hasNext = moveToNext();
    private int literalPosition;
    private int position;
    private int runningLength;
    private final int sizeInBits;
    private long word;
    private int wordLength;
    private int wordPosition;

    ClearIntIterator(EWAHIterator eWAHIterator, int i) {
        this.ewahIter = eWAHIterator;
        this.sizeInBits = i;
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
        this.runningLength = Math.min(this.sizeInBits, (((int) runningLengthWord.getRunningLength()) * 64) + this.position);
        if (runningLengthWord.getRunningBit()) {
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
        int i2;
        while (true) {
            j = this.word;
            if (j != 0 || (i = this.wordPosition) >= this.wordLength) {
                break;
            }
            Buffer buffer = this.buffer;
            this.wordPosition = i + 1;
            this.word = ~buffer.getWord(i);
            if (this.wordPosition == this.wordLength && !this.ewahIter.hasNext() && (i2 = this.sizeInBits % 64) > 0) {
                this.word &= (-1) >>> (64 - i2);
            }
            int i3 = this.position;
            this.literalPosition = i3;
            this.position = i3 + 64;
        }
        return j != 0;
    }
}
