package com.googlecode.javaewah32;

import com.googlecode.javaewah.IntIterator;

/* JADX INFO: loaded from: classes4.dex */
public class IntIteratorOverIteratingRLW32 implements IntIterator {
    private boolean hasNext;
    private int literalPosition;
    final IteratingRLW32 parent;
    private int position = 0;
    private int runningLength;
    private int word;
    private int wordLength;
    private int wordPosition;

    public IntIteratorOverIteratingRLW32(IteratingRLW32 iteratingRLW32) {
        this.parent = iteratingRLW32;
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
            int i2 = this.word;
            int i3 = i2 & (-i2);
            int iBitCount = this.literalPosition + Integer.bitCount(i3 - 1);
            this.word = i3 ^ this.word;
            i = iBitCount;
        }
        this.hasNext = moveToNext();
        return i;
    }

    private void setupForCurrentRunningLengthWord() {
        this.runningLength = (this.parent.getRunningLength() * 32) + this.position;
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
        int i;
        int i2;
        while (true) {
            i = this.word;
            if (i != 0 || (i2 = this.wordPosition) >= this.wordLength) {
                break;
            }
            IteratingRLW32 iteratingRLW32 = this.parent;
            this.wordPosition = i2 + 1;
            this.word = iteratingRLW32.getLiteralWordAt(i2);
            int i3 = this.position;
            this.literalPosition = i3;
            this.position = i3 + 32;
        }
        return i != 0;
    }
}
