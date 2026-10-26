package com.googlecode.javaewah;

import java.nio.LongBuffer;

/* INFO: loaded from: classes4.dex */
final class LongBufferWrapper implements Buffer, Cloneable {
    private int actualSizeInWords;
    private LongBuffer buffer;

    @Override // com.googlecode.javaewah.Buffer
    public void trim() {
    }

    public LongBufferWrapper(LongBuffer longBuffer) {
        this.actualSizeInWords = 1;
        this.buffer = longBuffer;
    }

    public LongBufferWrapper(LongBuffer longBuffer, int i) {
        this.buffer = longBuffer;
        this.actualSizeInWords = i;
    }

    @Override // com.googlecode.javaewah.Buffer
    public int sizeInWords() {
        return this.actualSizeInWords;
    }

    @Override // com.googlecode.javaewah.Buffer
    public void ensureCapacity(int i) {
        if (i > this.buffer.capacity()) {
            throw new RuntimeException("Cannot increase buffer capacity. Current capacity: " + this.buffer.capacity() + ". New capacity: " + i);
        }
    }

    @Override // com.googlecode.javaewah.Buffer
    public long getWord(int i) {
        return this.buffer.get(i);
    }

    @Override // com.googlecode.javaewah.Buffer
    public long getLastWord() {
        return getWord(this.actualSizeInWords - 1);
    }

    @Override // com.googlecode.javaewah.Buffer
    public void clear() {
        this.actualSizeInWords = 1;
        setWord(0, 0L);
    }

    @Override // com.googlecode.javaewah.Buffer
    public void setWord(int i, long j) {
        this.buffer.put(i, j);
    }

    @Override // com.googlecode.javaewah.Buffer
    public void setLastWord(long j) {
        setWord(this.actualSizeInWords - 1, j);
    }

    @Override // com.googlecode.javaewah.Buffer
    public void push_back(long j) {
        int i = this.actualSizeInWords;
        this.actualSizeInWords = i + 1;
        setWord(i, j);
    }

    @Override // com.googlecode.javaewah.Buffer
    public void push_back(Buffer buffer, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            push_back(buffer.getWord(i + i3));
        }
    }

    @Override // com.googlecode.javaewah.Buffer
    public void negative_push_back(Buffer buffer, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            push_back(~buffer.getWord(i + i3));
        }
    }

    @Override // com.googlecode.javaewah.Buffer
    public void removeLastWord() {
        int i = this.actualSizeInWords - 1;
        this.actualSizeInWords = i;
        setWord(i, 0L);
    }

    @Override // com.googlecode.javaewah.Buffer
    public void negateWord(int i) {
        setWord(i, ~getWord(i));
    }

    @Override // com.googlecode.javaewah.Buffer
    public void andWord(int i, long j) {
        setWord(i, j & getWord(i));
    }

    @Override // com.googlecode.javaewah.Buffer
    public void orWord(int i, long j) {
        setWord(i, j | getWord(i));
    }

    @Override // com.googlecode.javaewah.Buffer
    public void andLastWord(long j) {
        andWord(this.actualSizeInWords - 1, j);
    }

    @Override // com.googlecode.javaewah.Buffer
    public void orLastWord(long j) {
        orWord(this.actualSizeInWords - 1, j);
    }

    @Override // com.googlecode.javaewah.Buffer
    public void expand(int i, int i2) {
        for (int i3 = (this.actualSizeInWords - i) - 1; i3 >= 0; i3--) {
            setWord(i + i2 + i3, getWord(i + i3));
        }
        this.actualSizeInWords += i2;
    }

    @Override // com.googlecode.javaewah.Buffer
    public void collapse(int i, int i2) {
        for (int i3 = 0; i3 < (this.actualSizeInWords - i) - i2; i3++) {
            setWord(i + i3, getWord(i + i2 + i3));
        }
        for (int i4 = 0; i4 < i2; i4++) {
            removeLastWord();
        }
    }

    @Override // com.googlecode.javaewah.Buffer
    /* INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public LongBufferWrapper m3465clone() throws CloneNotSupportedException {
        return new LongBufferWrapper(this.buffer, this.actualSizeInWords);
    }

    @Override // com.googlecode.javaewah.Buffer
    public void swap(Buffer buffer) {
        if (buffer instanceof LongBufferWrapper) {
            LongBufferWrapper longBufferWrapper = (LongBufferWrapper) buffer;
            LongBuffer longBuffer = this.buffer;
            int i = this.actualSizeInWords;
            this.actualSizeInWords = longBufferWrapper.actualSizeInWords;
            this.buffer = longBufferWrapper.buffer;
            longBufferWrapper.actualSizeInWords = i;
            longBufferWrapper.buffer = longBuffer;
            return;
        }
        buffer.swap(this);
    }
}
