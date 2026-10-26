package com.googlecode.javaewah32;

import com.googlecode.javaewah.ChunkIterator;

/* INFO: loaded from: classes4.dex */
final class ChunkIteratorImpl32 implements ChunkIterator {
    private final Buffer32 buffer;
    private final EWAHIterator32 ewahIter;
    private boolean hasNext = moveToNextRLW();
    private Boolean nextBit;
    private int nextLength;
    private int position;
    private boolean runningBit;
    private int runningLength;
    private final int sizeInBits;
    private int word;
    private int wordLength;
    private int wordMask;
    private int wordPosition;

    ChunkIteratorImpl32(EWAHIterator32 eWAHIterator32, int i) {
        this.ewahIter = eWAHIterator32;
        this.sizeInBits = i;
        this.buffer = eWAHIterator32.buffer();
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

    private void setRLW(RunningLengthWord32 runningLengthWord32) {
        this.runningLength = Math.min(this.sizeInBits, this.position + (runningLengthWord32.getRunningLength() * 32));
        this.runningBit = runningLengthWord32.getRunningBit();
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
            if (i != 0 || this.wordMask != 0 || (i2 = this.wordPosition) >= this.wordLength) {
                break;
            }
            Buffer32 buffer32 = this.buffer;
            this.wordPosition = i2 + 1;
            this.word = buffer32.getWord(i2);
            this.wordMask = 1;
        }
        return !(i == 0 && this.wordMask == 0 && hasNextRLW()) && this.position < this.sizeInBits;
    }

    private boolean hasNextRLW() {
        return this.ewahIter.hasNext();
    }

    private RunningLengthWord32 nextRLW() {
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
        int i = this.word;
        int i2 = this.wordMask;
        this.word = i & (~i2);
        this.wordMask = i2 << 1;
    }
}
