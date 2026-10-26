package com.googlecode.javaewah32.symmetric;

import com.googlecode.javaewah32.IteratingBufferedRunningLengthWord32;

/* INFO: loaded from: classes4.dex */
public final class EWAHPointer32 implements Comparable<EWAHPointer32> {
    private boolean dead;
    private int endrun;
    private boolean isLiteral;
    public final IteratingBufferedRunningLengthWord32 iterator;
    private final int pos;
    private boolean value;

    public EWAHPointer32(int i, IteratingBufferedRunningLengthWord32 iteratingBufferedRunningLengthWord32, int i2) {
        this.dead = false;
        this.pos = i2;
        this.iterator = iteratingBufferedRunningLengthWord32;
        if (iteratingBufferedRunningLengthWord32.getRunningLength() > 0) {
            this.endrun = i + iteratingBufferedRunningLengthWord32.getRunningLength();
            this.isLiteral = false;
            this.value = iteratingBufferedRunningLengthWord32.getRunningBit();
        } else if (iteratingBufferedRunningLengthWord32.getNumberOfLiteralWords() > 0) {
            this.isLiteral = true;
            this.endrun = i + iteratingBufferedRunningLengthWord32.getNumberOfLiteralWords();
        } else {
            this.endrun = i;
            this.dead = true;
        }
    }

    public int endOfRun() {
        return this.endrun;
    }

    public int beginOfRun() {
        int i;
        int runningLength;
        if (this.isLiteral) {
            i = this.endrun;
            runningLength = this.iterator.getNumberOfLiteralWords();
        } else {
            i = this.endrun;
            runningLength = this.iterator.getRunningLength();
        }
        return i - runningLength;
    }

    public void parseNextRun() {
        if (this.isLiteral || this.iterator.getNumberOfLiteralWords() == 0) {
            IteratingBufferedRunningLengthWord32 iteratingBufferedRunningLengthWord32 = this.iterator;
            iteratingBufferedRunningLengthWord32.discardFirstWords(iteratingBufferedRunningLengthWord32.size());
            if (this.iterator.getRunningLength() > 0) {
                this.endrun += this.iterator.getRunningLength();
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

    public void callbackUpdate(UpdateableBitmapFunction32 updateableBitmapFunction32) {
        if (this.dead) {
            updateableBitmapFunction32.setZero(this.pos);
            return;
        }
        if (this.isLiteral) {
            updateableBitmapFunction32.setLiteral(this.pos);
        } else if (this.value) {
            updateableBitmapFunction32.setOne(this.pos);
        } else {
            updateableBitmapFunction32.setZero(this.pos);
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(EWAHPointer32 eWAHPointer32) {
        return this.endrun - eWAHPointer32.endrun;
    }
}
