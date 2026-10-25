package com.googlecode.javaewah;

/* JADX INFO: loaded from: classes4.dex */
public final class RunningLengthWord implements Cloneable {
    public static final int LARGEST_LITERAL_COUNT = Integer.MAX_VALUE;
    public static final long LARGEST_RUNNING_LENGTH_COUNT = 4294967295L;
    private static final int LITERAL_BITS = 31;
    private static final long NOT_RUNNING_LENGTH_PLUS_RUNNING_BIT = -8589934592L;
    private static final long NOT_SHIFTED_LARGEST_RUNNING_LENGTH_COUNT = -8589934591L;
    public static final int RUNNING_LENGTH_BITS = 32;
    private static final long RUNNING_LENGTH_PLUS_RUNNING_BIT = 8589934591L;
    private static final long SHIFTED_LARGEST_RUNNING_LENGTH_COUNT = 8589934590L;
    final Buffer buffer;
    int position;

    RunningLengthWord(Buffer buffer, int i) {
        this.buffer = buffer;
        this.position = i;
    }

    public int getNumberOfLiteralWords() {
        return getNumberOfLiteralWords(this.buffer, this.position);
    }

    static int getNumberOfLiteralWords(Buffer buffer, int i) {
        return (int) (buffer.getWord(i) >>> 33);
    }

    public boolean getRunningBit() {
        return getRunningBit(this.buffer, this.position);
    }

    static boolean getRunningBit(Buffer buffer, int i) {
        return (buffer.getWord(i) & 1) != 0;
    }

    public long getRunningLength() {
        return getRunningLength(this.buffer, this.position);
    }

    static long getRunningLength(Buffer buffer, int i) {
        return (buffer.getWord(i) >>> 1) & 4294967295L;
    }

    public void setNumberOfLiteralWords(long j) {
        setNumberOfLiteralWords(this.buffer, this.position, j);
    }

    static void setNumberOfLiteralWords(Buffer buffer, int i, long j) {
        buffer.orWord(i, NOT_RUNNING_LENGTH_PLUS_RUNNING_BIT);
        buffer.andWord(i, (j << 33) | RUNNING_LENGTH_PLUS_RUNNING_BIT);
    }

    public void setRunningBit(boolean z) {
        setRunningBit(this.buffer, this.position, z);
    }

    static void setRunningBit(Buffer buffer, int i, boolean z) {
        if (z) {
            buffer.orWord(i, 1L);
        } else {
            buffer.andWord(i, -2L);
        }
    }

    public void setRunningLength(long j) {
        setRunningLength(this.buffer, this.position, j);
    }

    static void setRunningLength(Buffer buffer, int i, long j) {
        buffer.orWord(i, SHIFTED_LARGEST_RUNNING_LENGTH_COUNT);
        buffer.andWord(i, (j << 1) | NOT_SHIFTED_LARGEST_RUNNING_LENGTH_COUNT);
    }

    public long size() {
        return getRunningLength() + ((long) getNumberOfLiteralWords());
    }

    public String toString() {
        return "running bit = " + getRunningBit() + " running length = " + getRunningLength() + " number of lit. words " + getNumberOfLiteralWords();
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public RunningLengthWord m3466clone() throws CloneNotSupportedException {
        return (RunningLengthWord) super.clone();
    }
}
