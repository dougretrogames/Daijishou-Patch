package com.googlecode.javaewah32;

import java.nio.IntBuffer;

/* JADX INFO: loaded from: classes4.dex */
final class IntBufferWrapper implements Buffer32, Cloneable {
    private int actualSizeInWords;
    private IntBuffer buffer;

    @Override // com.googlecode.javaewah32.Buffer32
    public void trim() {
    }

    public IntBufferWrapper(IntBuffer intBuffer) {
        this.actualSizeInWords = 1;
        this.buffer = intBuffer;
    }

    public IntBufferWrapper(IntBuffer intBuffer, int i) {
        this.buffer = intBuffer;
        this.actualSizeInWords = i;
    }

    @Override // com.googlecode.javaewah32.Buffer32
    public int sizeInWords() {
        return this.actualSizeInWords;
    }

    @Override // com.googlecode.javaewah32.Buffer32
    public void ensureCapacity(int i) {
        if (i > this.buffer.capacity()) {
            throw new RuntimeException("Cannot increase buffer capacity. Current capacity: " + this.buffer.capacity() + ". New capacity: " + i);
        }
    }

    @Override // com.googlecode.javaewah32.Buffer32
    public int getWord(int i) {
        return this.buffer.get(i);
    }

    @Override // com.googlecode.javaewah32.Buffer32
    public int getLastWord() {
        return getWord(this.actualSizeInWords - 1);
    }

    @Override // com.googlecode.javaewah32.Buffer32
    public void clear() {
        this.actualSizeInWords = 1;
        setWord(0, 0);
    }

    @Override // com.googlecode.javaewah32.Buffer32
    public void setWord(int i, int i2) {
        this.buffer.put(i, i2);
    }

    @Override // com.googlecode.javaewah32.Buffer32
    public void setLastWord(int i) {
        setWord(this.actualSizeInWords - 1, i);
    }

    @Override // com.googlecode.javaewah32.Buffer32
    public void push_back(int i) {
        int i2 = this.actualSizeInWords;
        this.actualSizeInWords = i2 + 1;
        setWord(i2, i);
    }

    @Override // com.googlecode.javaewah32.Buffer32
    public void push_back(Buffer32 buffer32, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            push_back(buffer32.getWord(i + i3));
        }
    }

    @Override // com.googlecode.javaewah32.Buffer32
    public void negative_push_back(Buffer32 buffer32, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            push_back(~buffer32.getWord(i + i3));
        }
    }

    @Override // com.googlecode.javaewah32.Buffer32
    public void removeLastWord() {
        int i = this.actualSizeInWords - 1;
        this.actualSizeInWords = i;
        setWord(i, 0);
    }

    @Override // com.googlecode.javaewah32.Buffer32
    public void negateWord(int i) {
        setWord(i, ~getWord(i));
    }

    @Override // com.googlecode.javaewah32.Buffer32
    public void andWord(int i, int i2) {
        setWord(i, i2 & getWord(i));
    }

    @Override // com.googlecode.javaewah32.Buffer32
    public void orWord(int i, int i2) {
        setWord(i, i2 | getWord(i));
    }

    @Override // com.googlecode.javaewah32.Buffer32
    public void andLastWord(int i) {
        andWord(this.actualSizeInWords - 1, i);
    }

    @Override // com.googlecode.javaewah32.Buffer32
    public void orLastWord(int i) {
        orWord(this.actualSizeInWords - 1, i);
    }

    @Override // com.googlecode.javaewah32.Buffer32
    public void expand(int i, int i2) {
        for (int i3 = (this.actualSizeInWords - i) - 1; i3 >= 0; i3--) {
            setWord(i + i2 + i3, getWord(i + i3));
        }
        this.actualSizeInWords += i2;
    }

    @Override // com.googlecode.javaewah32.Buffer32
    public void collapse(int i, int i2) {
        for (int i3 = 0; i3 < (this.actualSizeInWords - i) - i2; i3++) {
            setWord(i + i3, getWord(i + i2 + i3));
        }
        for (int i4 = 0; i4 < i2; i4++) {
            removeLastWord();
        }
    }

    @Override // com.googlecode.javaewah32.Buffer32
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public IntBufferWrapper m3475clone() throws CloneNotSupportedException {
        return new IntBufferWrapper(this.buffer, this.actualSizeInWords);
    }

    @Override // com.googlecode.javaewah32.Buffer32
    public void swap(Buffer32 buffer32) {
        if (buffer32 instanceof IntBufferWrapper) {
            IntBufferWrapper intBufferWrapper = (IntBufferWrapper) buffer32;
            IntBuffer intBuffer = this.buffer;
            int i = this.actualSizeInWords;
            this.actualSizeInWords = intBufferWrapper.actualSizeInWords;
            this.buffer = intBufferWrapper.buffer;
            intBufferWrapper.actualSizeInWords = i;
            intBufferWrapper.buffer = intBuffer;
            return;
        }
        buffer32.swap(this);
    }
}
