package com.googlecode.javaewah;

/* INFO: loaded from: classes4.dex */
public final class BufferedRunningLengthWord implements Cloneable {
    protected int literalWordOffset;
    protected int numberOfLiteralWords;
    protected boolean runningBit;
    protected long runningLength;

    public BufferedRunningLengthWord(long j) {
        this.literalWordOffset = 0;
        this.numberOfLiteralWords = (int) (j >>> 33);
        this.runningBit = (1 & j) != 0;
        this.runningLength = (int) ((j >>> 1) & 4294967295L);
    }

    public BufferedRunningLengthWord(RunningLengthWord runningLengthWord) {
        this(runningLengthWord.buffer.getWord(runningLengthWord.position));
    }

    public void discardFirstWords(long j) {
        long j2 = this.runningLength;
        if (j2 >= j) {
            this.runningLength = j2 - j;
            return;
        }
        this.runningLength = 0L;
        int i = (int) (j - j2);
        this.literalWordOffset += i;
        this.numberOfLiteralWords -= i;
    }

    public int getNumberOfLiteralWords() {
        return this.numberOfLiteralWords;
    }

    public boolean getRunningBit() {
        return this.runningBit;
    }

    public long getRunningLength() {
        return this.runningLength;
    }

    public void reset(long j) {
        this.numberOfLiteralWords = (int) (j >>> 33);
        this.runningBit = (1 & j) != 0;
        this.runningLength = (int) ((j >>> 1) & 4294967295L);
        this.literalWordOffset = 0;
    }

    public void reset(RunningLengthWord runningLengthWord) {
        reset(runningLengthWord.buffer.getWord(runningLengthWord.position));
    }

    public void setNumberOfLiteralWords(int i) {
        this.numberOfLiteralWords = i;
    }

    public void setRunningBit(boolean z) {
        this.runningBit = z;
    }

    public void setRunningLength(long j) {
        this.runningLength = j;
    }

    public long size() {
        return this.runningLength + ((long) this.numberOfLiteralWords);
    }

    public String toString() {
        return "running bit = " + getRunningBit() + " running length = " + getRunningLength() + " number of lit. words " + getNumberOfLiteralWords();
    }

    /* INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public BufferedRunningLengthWord m3458clone() throws CloneNotSupportedException {
        BufferedRunningLengthWord bufferedRunningLengthWord = (BufferedRunningLengthWord) super.clone();
        bufferedRunningLengthWord.literalWordOffset = this.literalWordOffset;
        bufferedRunningLengthWord.numberOfLiteralWords = this.numberOfLiteralWords;
        bufferedRunningLengthWord.runningBit = this.runningBit;
        bufferedRunningLengthWord.runningLength = this.runningLength;
        return bufferedRunningLengthWord;
    }
}
