package com.googlecode.javaewah32;

/* INFO: loaded from: classes4.dex */
public final class RunningLengthWord32 implements Cloneable {
    public static final int LARGEST_LITERAL_COUNT = 32767;
    public static final int LARGEST_RUNNING_LENGTH_COUNT = 65535;
    private static final int LITERAL_BITS = 15;
    private static final int NOT_RUNNING_LENGTH_PLUS_RUNNING_BIT = -131072;
    private static final int NOT_SHIFTED_LARGEST_RUNNING_LENGTH_COUNT = -131071;
    public static final int RUNNING_LENGTH_BITS = 16;
    private static final int RUNNING_LENGTH_PLUS_RUNNING_BIT = 131071;
    private static final int SHIFTED_LARGEST_RUNNING_LENGTH_COUNT = 131070;
    final Buffer32 buffer;
    int position;

    RunningLengthWord32(Buffer32 buffer32, int i) {
        this.buffer = buffer32;
        this.position = i;
    }

    public int getNumberOfLiteralWords() {
        return getNumberOfLiteralWords(this.buffer, this.position);
    }

    static int getNumberOfLiteralWords(Buffer32 buffer32, int i) {
        return buffer32.getWord(i) >>> 17;
    }

    public boolean getRunningBit() {
        return getRunningBit(this.buffer, this.position);
    }

    static boolean getRunningBit(Buffer32 buffer32, int i) {
        return (buffer32.getWord(i) & 1) != 0;
    }

    public int getRunningLength() {
        return getRunningLength(this.buffer, this.position);
    }

    static int getRunningLength(Buffer32 buffer32, int i) {
        return (buffer32.getWord(i) >>> 1) & 65535;
    }

    public void setNumberOfLiteralWords(int i) {
        setNumberOfLiteralWords(this.buffer, this.position, i);
    }

    static void setNumberOfLiteralWords(Buffer32 buffer32, int i, int i2) {
        buffer32.orWord(i, NOT_RUNNING_LENGTH_PLUS_RUNNING_BIT);
        buffer32.andWord(i, (i2 << 17) | RUNNING_LENGTH_PLUS_RUNNING_BIT);
    }

    public void setRunningBit(boolean z) {
        setRunningBit(this.buffer, this.position, z);
    }

    static void setRunningBit(Buffer32 buffer32, int i, boolean z) {
        if (z) {
            buffer32.orWord(i, 1);
        } else {
            buffer32.andWord(i, -2);
        }
    }

    public void setRunningLength(int i) {
        setRunningLength(this.buffer, this.position, i);
    }

    static void setRunningLength(Buffer32 buffer32, int i, int i2) {
        buffer32.orWord(i, SHIFTED_LARGEST_RUNNING_LENGTH_COUNT);
        buffer32.andWord(i, (i2 << 1) | NOT_SHIFTED_LARGEST_RUNNING_LENGTH_COUNT);
    }

    public int size() {
        return getRunningLength() + getNumberOfLiteralWords();
    }

    public String toString() {
        return "running bit = " + getRunningBit() + " running length = " + getRunningLength() + " number of lit. words " + getNumberOfLiteralWords();
    }

    /* INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public RunningLengthWord32 m3479clone() throws CloneNotSupportedException {
        return (RunningLengthWord32) super.clone();
    }
}
