package com.googlecode.javaewah;

/* INFO: loaded from: classes4.dex */
final class ChunkIteratorImpl implements ChunkIterator {
    private final Buffer buffer;
    private final EWAHIterator ewahIter;
    private boolean hasNext = moveToNextRLW();
    private Boolean nextBit;
    private int nextLength;
    private int position;
    private boolean runningBit;
    private int runningLength;
    private final int sizeInBits;
    private long word;
    private int wordLength;
    private long wordMask;
    private int wordPosition;

    ChunkIteratorImpl(EWAHIterator eWAHIterator, int i) {
        this.ewahIter = eWAHIterator;
        this.sizeInBits = i;
        this.buffer = eWAHIterator.buffer();
    }

    @Override // com.googlecode.javaewah.ChunkIterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // com.googlecode.javaewah.ChunkIterator
    public boolean nextBit() {
        return this.nextBit.booleanValue();
    }

    @Override // com.googlecode.javaewah.ChunkIterator
    public int nextLength() {
        return this.nextLength;
    }

    @Override // com.googlecode.javaewah.ChunkIterator
    public void move() {
        move(this.nextLength);
    }

    @Override // com.googlecode.javaewah.ChunkIterator
    public void move(int i) {
        boolean zMoveToNextRLW;
        int i2 = this.nextLength - i;
        this.nextLength = i2;
        if (i2 <= 0) {
            do {
                this.nextBit = null;
                updateNext();
                zMoveToNextRLW = moveToNextRLW();
                this.hasNext = zMoveToNextRLW;
                if (this.nextLength > 0) {
                    return;
                }
            } while (zMoveToNextRLW);
        }
    }

    private boolean moveToNextRLW() {
        while (!runningHasNext() && !literalHasNext()) {
            if (!hasNextRLW()) {
                return this.nextBit != null;
            }
            setRLW(nextRLW());
            updateNext();
        }
        return true;
    }

    private void setRLW(RunningLengthWord runningLengthWord) {
        this.runningLength = Math.min(this.sizeInBits, this.position + (((int) runningLengthWord.getRunningLength()) * 64));
        this.runningBit = runningLengthWord.getRunningBit();
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
            if (j != 0 || this.wordMask != 0 || (i = this.wordPosition) >= this.wordLength) {
                break;
            }
            Buffer buffer = this.buffer;
            this.wordPosition = i + 1;
            this.word = buffer.getWord(i);
            this.wordMask = 1L;
        }
        return !(j == 0 && this.wordMask == 0 && hasNextRLW()) && this.position < this.sizeInBits;
    }

    private boolean hasNextRLW() {
        return this.ewahIter.hasNext();
    }

    private RunningLengthWord nextRLW() {
        return this.ewahIter.next();
    }

    private void updateNext() {
        if (runningHasNext()) {
            Boolean bool = this.nextBit;
            if (bool == null || bool.booleanValue() == this.runningBit) {
                this.nextBit = Boolean.valueOf(this.runningBit);
                int iRunningOffset = runningOffset();
                this.nextLength += iRunningOffset;
                movePosition(iRunningOffset);
                updateNext();
                return;
            }
            return;
        }
        if (literalHasNext()) {
            boolean zCurrentWordBit = currentWordBit();
            Boolean bool2 = this.nextBit;
            if (bool2 == null || bool2.booleanValue() == zCurrentWordBit) {
                this.nextBit = Boolean.valueOf(zCurrentWordBit);
                this.nextLength++;
                movePosition(1);
                shiftWordMask();
                updateNext();
                return;
            }
            return;
        }
        moveToNextRLW();
    }

    private int runningOffset() {
        return this.runningLength - this.position;
    }

    private void movePosition(int i) {
        this.position += i;
    }

    private boolean currentWordBit() {
        return (this.word & this.wordMask) != 0;
    }

    private void shiftWordMask() {
        long j = this.word;
        long j2 = this.wordMask;
        this.word = j & (~j2);
        this.wordMask = j2 << 1;
    }
}
