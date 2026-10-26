package com.googlecode.javaewah32;

/* INFO: loaded from: classes4.dex */
public final class EWAHIterator32 implements Cloneable {
    private int pointer;
    final RunningLengthWord32 rlw;
    private final int size;

    public EWAHIterator32(Buffer32 buffer32) {
        this.rlw = new RunningLengthWord32(buffer32, 0);
        this.size = buffer32.sizeInWords();
        this.pointer = 0;
    }

    private EWAHIterator32(int i, RunningLengthWord32 runningLengthWord32, int i2) {
        this.pointer = i;
        this.rlw = runningLengthWord32;
        this.size = i2;
    }

    public static EWAHIterator32 getEWAHIterator(EWAHCompressedBitmap32 eWAHCompressedBitmap32) {
        return eWAHCompressedBitmap32.getEWAHIterator();
    }

    public Buffer32 buffer() {
        return this.rlw.buffer;
    }

    public int literalWords() {
        return this.pointer - this.rlw.getNumberOfLiteralWords();
    }

    public boolean hasNext() {
        return this.pointer < this.size;
    }

    public RunningLengthWord32 next() {
        this.rlw.position = this.pointer;
        this.pointer += this.rlw.getNumberOfLiteralWords() + 1;
        return this.rlw;
    }

    /* INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public EWAHIterator32 m3473clone() throws CloneNotSupportedException {
        return new EWAHIterator32(this.pointer, this.rlw.m3479clone(), this.size);
    }
}
