package com.googlecode.javaewah32;

import com.googlecode.javaewah.CloneableIterator;

/* INFO: loaded from: classes4.dex */
public class BufferedIterator32 implements IteratingRLW32, Cloneable {
    private IteratingBufferedRunningLengthWord32 iteratingBrlw;
    private CloneableIterator<EWAHIterator32> masterIterator;

    public BufferedIterator32(CloneableIterator<EWAHIterator32> cloneableIterator) {
        this.masterIterator = cloneableIterator;
        if (cloneableIterator.hasNext()) {
            this.iteratingBrlw = new IteratingBufferedRunningLengthWord32(this.masterIterator.next());
        }
    }

    @Override // com.googlecode.javaewah32.IteratingRLW32
    public void discardFirstWords(int i) {
        while (i > 0) {
            if (this.iteratingBrlw.getRunningLength() > i) {
                this.iteratingBrlw.discardFirstWords(i);
                return;
            }
            IteratingBufferedRunningLengthWord32 iteratingBufferedRunningLengthWord32 = this.iteratingBrlw;
            iteratingBufferedRunningLengthWord32.discardFirstWords(iteratingBufferedRunningLengthWord32.getRunningLength());
            int runningLength = i - this.iteratingBrlw.getRunningLength();
            int numberOfLiteralWords = runningLength > this.iteratingBrlw.getNumberOfLiteralWords() ? this.iteratingBrlw.getNumberOfLiteralWords() : runningLength;
            this.iteratingBrlw.discardFirstWords(numberOfLiteralWords);
            i = runningLength - numberOfLiteralWords;
            if (i > 0 || this.iteratingBrlw.size() == 0) {
                if (!next()) {
                    return;
                }
            }
        }
    }

    @Override // com.googlecode.javaewah32.IteratingRLW32
    public void discardLiteralWords(int i) {
        this.iteratingBrlw.discardLiteralWords(i);
        if (this.iteratingBrlw.getNumberOfLiteralWords() == 0) {
            next();
        }
    }

    @Override // com.googlecode.javaewah32.IteratingRLW32
    public void discardRunningWords() {
        this.iteratingBrlw.discardRunningWords();
        if (this.iteratingBrlw.getNumberOfLiteralWords() == 0) {
            next();
        }
    }

    @Override // com.googlecode.javaewah32.IteratingRLW32
    public boolean next() {
        if (this.iteratingBrlw.next()) {
            return true;
        }
        if (!this.masterIterator.hasNext()) {
            return false;
        }
        this.iteratingBrlw = new IteratingBufferedRunningLengthWord32(this.masterIterator.next());
        return true;
    }

    @Override // com.googlecode.javaewah32.IteratingRLW32
    public int getLiteralWordAt(int i) {
        return this.iteratingBrlw.getLiteralWordAt(i);
    }

    @Override // com.googlecode.javaewah32.IteratingRLW32
    public int getNumberOfLiteralWords() {
        return this.iteratingBrlw.getNumberOfLiteralWords();
    }

    @Override // com.googlecode.javaewah32.IteratingRLW32
    public boolean getRunningBit() {
        return this.iteratingBrlw.getRunningBit();
    }

    @Override // com.googlecode.javaewah32.IteratingRLW32
    public int getRunningLength() {
        return this.iteratingBrlw.getRunningLength();
    }

    @Override // com.googlecode.javaewah32.IteratingRLW32
    public int size() {
        return this.iteratingBrlw.size();
    }

    @Override // com.googlecode.javaewah32.IteratingRLW32
    /* INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public BufferedIterator32 m3470clone() throws CloneNotSupportedException {
        BufferedIterator32 bufferedIterator32 = (BufferedIterator32) super.clone();
        bufferedIterator32.iteratingBrlw = this.iteratingBrlw.m3470clone();
        bufferedIterator32.masterIterator = this.masterIterator.clone();
        return bufferedIterator32;
    }
}
