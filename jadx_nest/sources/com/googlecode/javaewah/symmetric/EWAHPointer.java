package com.googlecode.javaewah.symmetric;

import com.googlecode.javaewah.IteratingBufferedRunningLengthWord;

/* INFO: loaded from: classes4.dex */
public final class EWAHPointer implements Comparable<EWAHPointer> {
    private boolean dead;
    private int endrun;
    private boolean isLiteral;
    public final IteratingBufferedRunningLengthWord iterator;
    private final int pos;
    private boolean value;

    public EWAHPointer(int i, IteratingBufferedRunningLengthWord iteratingBufferedRunningLengthWord, int i2) {
        this.dead = false;
        this.pos = i2;
        this.iterator = iteratingBufferedRunningLengthWord;
        if (iteratingBufferedRunningLengthWord.getRunningLength() > 0) {
            this.endrun = i + ((int) iteratingBufferedRunningLengthWord.getRunningLength());
            this.isLiteral = false;
            this.value = iteratingBufferedRunningLengthWord.getRunningBit();
        } else if (iteratingBufferedRunningLengthWord.getNumberOfLiteralWords() > 0) {
            this.isLiteral = true;
            this.endrun = i + iteratingBufferedRunningLengthWord.getNumberOfLiteralWords();
        } else {
            this.endrun = i;
            this.dead = true;
        }
    }

    public int endOfRun() {
        return this.endrun;
    }

    public int beginOfRun() {
        if (this.isLiteral) {
            return this.endrun - this.iterator.getNumberOfLiteralWords();
        }
        return (int) (((long) this.endrun) - this.iterator.getRunningLength());
    }

    public void parseNextRun() {
        if (this.isLiteral || this.iterator.getNumberOfLiteralWords() == 0) {
            IteratingBufferedRunningLengthWord iteratingBufferedRunningLengthWord = this.iterator;
            iteratingBufferedRunningLengthWord.discardFirstWords(iteratingBufferedRunningLengthWord.size());
            if (this.iterator.getRunningLength() > 0) {
                this.endrun += (int) this.iterator.getRunningLength();
                this.isLiteral = false;
                this.value = this.iterator.getRunningBit();
                return;
            } else if (this.iterator.getNumberOfLiteralWords() > 0) {
                this.isLiteral = true;
                this.endrun += this.iterator.getNumberOfLiteralWords();
                return;
            } else {
                this.dead = true;
                return;
            }
        }
        this.isLiteral = true;
        this.endrun += this.iterator.getNumberOfLiteralWords();
    }

    public boolean hasNoData() {
        return this.dead;
    }

    public void callbackUpdate(UpdateableBitmapFunction updateableBitmapFunction) {
        if (this.dead) {
            updateableBitmapFunction.setZero(this.pos);
            return;
        }
        if (this.isLiteral) {
            updateableBitmapFunction.setLiteral(this.pos);
        } else if (this.value) {
            updateableBitmapFunction.setOne(this.pos);
        } else {
            updateableBitmapFunction.setZero(this.pos);
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(EWAHPointer eWAHPointer) {
        return this.endrun - eWAHPointer.endrun;
    }
}
