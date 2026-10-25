package com.googlecode.javaewah;

import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
final class LongArray implements Buffer, Cloneable {
    private static final int DEFAULT_BUFFER_SIZE = 4;
    private int actualSizeInWords;
    private long[] buffer;

    public LongArray() {
        this(4);
    }

    public LongArray(int i) {
        this.actualSizeInWords = 1;
        this.buffer = null;
        this.buffer = new long[i < 1 ? 1 : i];
    }

    @Override // com.googlecode.javaewah.Buffer
    public int sizeInWords() {
        return this.actualSizeInWords;
    }

    @Override // com.googlecode.javaewah.Buffer
    public void ensureCapacity(int i) {
        resizeBuffer(i - this.actualSizeInWords);
    }

    @Override // com.googlecode.javaewah.Buffer
    public long getWord(int i) {
        return this.buffer[i];
    }

    @Override // com.googlecode.javaewah.Buffer
    public long getLastWord() {
        return getWord(this.actualSizeInWords - 1);
    }

    @Override // com.googlecode.javaewah.Buffer
    public void clear() {
        this.actualSizeInWords = 1;
        this.buffer[0] = 0;
    }

    @Override // com.googlecode.javaewah.Buffer
    public void trim() {
        this.buffer = Arrays.copyOf(this.buffer, this.actualSizeInWords);
    }

    @Override // com.googlecode.javaewah.Buffer
    public void setWord(int i, long j) {
        this.buffer[i] = j;
    }

    @Override // com.googlecode.javaewah.Buffer
    public void setLastWord(long j) {
        setWord(this.actualSizeInWords - 1, j);
    }

    @Override // com.googlecode.javaewah.Buffer
    public void push_back(long j) {
        resizeBuffer(1);
        long[] jArr = this.buffer;
        int i = this.actualSizeInWords;
        this.actualSizeInWords = i + 1;
        jArr[i] = j;
    }

    @Override // com.googlecode.javaewah.Buffer
    public void push_back(Buffer buffer, int i, int i2) {
        resizeBuffer(i2);
        if (buffer instanceof LongArray) {
            System.arraycopy(((LongArray) buffer).buffer, i, this.buffer, this.actualSizeInWords, i2);
        } else {
            for (int i3 = 0; i3 < i2; i3++) {
                this.buffer[this.actualSizeInWords + i3] = buffer.getWord(i + i3);
            }
        }
        this.actualSizeInWords += i2;
    }

    @Override // com.googlecode.javaewah.Buffer
    public void negative_push_back(Buffer buffer, int i, int i2) {
        resizeBuffer(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            this.buffer[this.actualSizeInWords + i3] = ~buffer.getWord(i + i3);
        }
        this.actualSizeInWords += i2;
    }

    @Override // com.googlecode.javaewah.Buffer
    public void removeLastWord() {
        int i = this.actualSizeInWords - 1;
        this.actualSizeInWords = i;
        setWord(i, 0L);
    }

    @Override // com.googlecode.javaewah.Buffer
    public void negateWord(int i) {
        long[] jArr = this.buffer;
        jArr[i] = ~jArr[i];
    }

    @Override // com.googlecode.javaewah.Buffer
    public void andWord(int i, long j) {
        long[] jArr = this.buffer;
        jArr[i] = j & jArr[i];
    }

    @Override // com.googlecode.javaewah.Buffer
    public void orWord(int i, long j) {
        long[] jArr = this.buffer;
        jArr[i] = j | jArr[i];
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
        resizeBuffer(i2);
        long[] jArr = this.buffer;
        System.arraycopy(jArr, i, jArr, i + i2, this.actualSizeInWords - i);
        this.actualSizeInWords += i2;
    }

    @Override // com.googlecode.javaewah.Buffer
    public void collapse(int i, int i2) {
        long[] jArr = this.buffer;
        System.arraycopy(jArr, i + i2, jArr, i, (this.actualSizeInWords - i) - i2);
        for (int i3 = 0; i3 < i2; i3++) {
            removeLastWord();
        }
    }

    @Override // com.googlecode.javaewah.Buffer
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public LongArray m3464clone() {
        LongArray longArray;
        CloneNotSupportedException e;
        try {
            longArray = (LongArray) super.clone();
            try {
                longArray.buffer = (long[]) this.buffer.clone();
                longArray.actualSizeInWords = this.actualSizeInWords;
                return longArray;
            } catch (CloneNotSupportedException e2) {
                e = e2;
                e.printStackTrace();
                return longArray;
            }
        } catch (CloneNotSupportedException e3) {
            longArray = null;
            e = e3;
        }
    }

    @Override // com.googlecode.javaewah.Buffer
    public void swap(Buffer buffer) {
        if (buffer instanceof LongArray) {
            long[] jArr = this.buffer;
            LongArray longArray = (LongArray) buffer;
            this.buffer = longArray.buffer;
            longArray.buffer = jArr;
            int i = this.actualSizeInWords;
            this.actualSizeInWords = longArray.actualSizeInWords;
            longArray.actualSizeInWords = i;
            return;
        }
        long[] jArr2 = new long[buffer.sizeInWords()];
        for (int i2 = 0; i2 < buffer.sizeInWords(); i2++) {
            jArr2[i2] = buffer.getWord(i2);
        }
        int iSizeInWords = buffer.sizeInWords();
        buffer.clear();
        buffer.removeLastWord();
        buffer.push_back(this, 0, sizeInWords());
        this.buffer = jArr2;
        this.actualSizeInWords = iSizeInWords;
    }

    private void resizeBuffer(int i) {
        int iNewSizeInWords = newSizeInWords(i);
        long[] jArr = this.buffer;
        if (iNewSizeInWords >= jArr.length) {
            long[] jArr2 = new long[iNewSizeInWords];
            this.buffer = jArr2;
            System.arraycopy(jArr, 0, jArr2, 0, jArr.length);
        }
    }

    private int newSizeInWords(int i) {
        int i2 = this.actualSizeInWords + i;
        if (i2 < this.buffer.length) {
            return i2;
        }
        if (i2 < 32768) {
            return i2 * 2;
        }
        int i3 = (i2 * 3) / 2;
        if (i3 < i2) {
            return Integer.MAX_VALUE;
        }
        return i3;
    }
}
