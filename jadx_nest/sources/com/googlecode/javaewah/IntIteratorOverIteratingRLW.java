package com.googlecode.javaewah;

/* INFO: loaded from: classes4.dex */
public class IntIteratorOverIteratingRLW implements IntIterator {
    private boolean hasNext;
    private int literalPosition;
    final IteratingRLW parent;
    private int position = 0;
    private int runningLength;
    private long word;
    private int wordLength;
    private int wordPosition;

    public IntIteratorOverIteratingRLW(IteratingRLW iteratingRLW) {
        this.parent = iteratingRLW;
        setupForCurrentRunningLengthWord();
        this.hasNext = moveToNext();
    }

    private boolean moveToNext() {
        while (!runningHasNext() && !literalHasNext()) {
            if (!this.parent.next()) {
                return false;
            }
            setupForCurrentRunningLengthWord();
        }
        return true;
    }

    @Override // com.googlecode.javaewah.IntIterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // com.googlecode.javaewah.IntIterator
    public final int next() {
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

    private void setupForCurrentRunningLengthWord() {
        this.runningLength = (((int) this.parent.getRunningLength()) * 64) + this.position;
        if (!this.parent.getRunningBit()) {
            this.position = this.runningLength;
        }
        this.wordPosition = 0;
        this.wordLength = this.parent.getNumberOfLiteralWords();
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
            IteratingRLW iteratingRLW = this.parent;
            this.wordPosition = i + 1;
            this.word = iteratingRLW.getLiteralWordAt(i);
            int i2 = this.position;
            this.literalPosition = i2;
            this.position = i2 + 64;
        }
        return j != 0;
    }
}
