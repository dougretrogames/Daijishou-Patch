package com.googlecode.javaewah32;

/* JADX INFO: loaded from: classes4.dex */
public final class BufferedRunningLengthWord32 implements Cloneable {
    protected int NumberOfLiteralWords;
    public boolean RunningBit;
    public int RunningLength;
    public int literalWordOffset;

    public BufferedRunningLengthWord32(int i) {
        this.literalWordOffset = 0;
        this.NumberOfLiteralWords = i >>> 17;
        this.RunningBit = (i & 1) != 0;
        this.RunningLength = (i >>> 1) & 65535;
    }

    public BufferedRunningLengthWord32(RunningLengthWord32 runningLengthWord32) {
        this(runningLengthWord32.buffer.getWord(runningLengthWord32.position));
    }

    public void discardFirstWords(int i) {
        int i2 = this.RunningLength;
        if (i2 >= i) {
            this.RunningLength = i2 - i;
            return;
        }
        int i3 = i - i2;
        this.RunningLength = 0;
        this.literalWordOffset += i3;
        this.NumberOfLiteralWords -= i3;
    }

    public int getNumberOfLiteralWords() {
        return this.NumberOfLiteralWords;
    }

    public boolean getRunningBit() {
        return this.RunningBit;
    }

    public int getRunningLength() {
        return this.RunningLength;
    }

    public void reset(int i) {
        this.NumberOfLiteralWords = i >>> 17;
        this.RunningBit = (i & 1) != 0;
        this.RunningLength = (i >>> 1) & 65535;
        this.literalWordOffset = 0;
    }

    public void reset(RunningLengthWord32 runningLengthWord32) {
        reset(runningLengthWord32.buffer.getWord(runningLengthWord32.position));
    }

    public void setNumberOfLiteralWords(int i) {
        this.NumberOfLiteralWords = i;
    }

    public void setRunningBit(boolean z) {
        this.RunningBit = z;
    }

    public void setRunningLength(int i) {
        this.RunningLength = i;
    }

    public int size() {
        return this.RunningLength + this.NumberOfLiteralWords;
    }

    public String toString() {
        return "running bit = " + getRunningBit() + " running length = " + getRunningLength() + " number of lit. words " + getNumberOfLiteralWords();
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public BufferedRunningLengthWord32 m3471clone() throws CloneNotSupportedException {
        BufferedRunningLengthWord32 bufferedRunningLengthWord32 = (BufferedRunningLengthWord32) super.clone();
        bufferedRunningLengthWord32.literalWordOffset = this.literalWordOffset;
        bufferedRunningLengthWord32.NumberOfLiteralWords = this.NumberOfLiteralWords;
        bufferedRunningLengthWord32.RunningBit = this.RunningBit;
        bufferedRunningLengthWord32.RunningLength = this.RunningLength;
        return bufferedRunningLengthWord32;
    }
}
