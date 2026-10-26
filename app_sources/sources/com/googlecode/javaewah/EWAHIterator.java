package com.googlecode.javaewah;

/* INFO: loaded from: classes4.dex */
public final class EWAHIterator implements Cloneable {
    private int pointer;
    final RunningLengthWord rlw;
    private final int size;

    public EWAHIterator(Buffer buffer) {
        this.rlw = new RunningLengthWord(buffer, 0);
        this.size = buffer.sizeInWords();
        this.pointer = 0;
    }

    private EWAHIterator(int i, RunningLengthWord runningLengthWord, int i2) {
        this.pointer = i;
        this.rlw = runningLengthWord;
        this.size = i2;
    }

    public static EWAHIterator getEWAHIterator(EWAHCompressedBitmap eWAHCompressedBitmap) {
        return eWAHCompressedBitmap.getEWAHIterator();
    }

    public Buffer buffer() {
        return this.rlw.buffer;
    }

    public int literalWords() {
        return this.pointer - this.rlw.getNumberOfLiteralWords();
    }

    public boolean hasNext() {
        return this.pointer < this.size;
    }

    public RunningLengthWord next() {
        this.rlw.position = this.pointer;
        this.pointer += this.rlw.getNumberOfLiteralWords() + 1;
        return this.rlw;
    }

    /* INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public EWAHIterator m3461clone() throws CloneNotSupportedException {
        return new EWAHIterator(this.pointer, this.rlw.m3466clone(), this.size);
    }
}
