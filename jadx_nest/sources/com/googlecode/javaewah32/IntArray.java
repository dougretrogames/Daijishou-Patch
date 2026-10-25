package com.googlecode.javaewah32;

import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
class IntArray implements Buffer32, Cloneable {
    private static final int DEFAULT_BUFFER_SIZE = 4;
    private int actualSizeInWords;
    private int[] buffer;

    public IntArray() {
        this(4);
    }

    public IntArray(int i) {
        this.actualSizeInWords = 1;
        this.buffer = null;
        this.buffer = new int[i < 1 ? 1 : i];
    }

    @Override // com.googlecode.javaewah32.Buffer32
    public int sizeInWords() {
        return this.actualSizeInWords;
    }

    @Override // com.googlecode.javaewah32.Buffer32
    public void ensureCapacity(int i) {
        resizeBuffer(i - this.actualSizeInWords);
    }

    @Override // com.googlecode.javaewah32.Buffer32
    public int getWord(int i) {
        return this.buffer[i];
    }

    @Override // com.googlecode.javaewah32.Buffer32
    public int getLastWord() {
        return getWord(this.actualSizeInWords - 1);
    }

    @Override // com.googlecode.javaewah32.Buffer32
    public void clear() {
        this.actualSizeInWords = 1;
        this.buffer[0] = 0;
    }

    @Override // com.googlecode.javaewah32.Buffer32
    public void trim() {
        this.buffer = Arrays.copyOf(this.buffer, this.actualSizeInWords);
    }

    @Override // com.googlecode.javaewah32.Buffer32
    public void setWord(int i, int i2) {
        this.buffer[i] = i2;
    }

    @Override // com.googlecode.javaewah32.Buffer32
    public void setLastWord(int i) {
        setWord(this.actualSizeInWords - 1, i);
    }

    @Override // com.googlecode.javaewah32.Buffer32
    public void push_back(int i) {
        resizeBuffer(1);
        int[] iArr = this.buffer;
        int i2 = this.actualSizeInWords;
        this.actualSizeInWords = i2 + 1;
        iArr[i2] = i;
    }

    @Override // com.googlecode.javaewah32.Buffer32
    public void push_back(Buffer32 buffer32, int i, int i2) {
        resizeBuffer(i2);
        if (buffer32 instanceof IntArray) {
            System.arraycopy(((IntArray) buffer32).buffer, i, this.buffer, this.actualSizeInWords, i2);
        } else {
            for (int i3 = 0; i3 < i2; i3++) {
                this.buffer[this.actualSizeInWords + i3] = buffer32.getWord(i + i3);
            }
        }
        this.actualSizeInWords += i2;
    }

    @Override // com.googlecode.javaewah32.Buffer32
    public void negative_push_back(Buffer32 buffer32, int i, int i2) {
        resizeBuffer(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            this.buffer[this.actualSizeInWords + i3] = ~buffer32.getWord(i + i3);
        }
        this.actualSizeInWords += i2;
    }

    @Override // com.googlecode.javaewah32.Buffer32
    public void removeLastWord() {
        int i = this.actualSizeInWords - 1;
        this.actualSizeInWords = i;
        setWord(i, 0);
    }

    @Override // com.googlecode.javaewah32.Buffer32
    public void negateWord(int i) {
        int[] iArr = this.buffer;
        iArr[i] = ~iArr[i];
    }

    @Override // com.googlecode.javaewah32.Buffer32
    public void andWord(int i, int i2) {
        int[] iArr = this.buffer;
        iArr[i] = i2 & iArr[i];
    }

    @Override // com.googlecode.javaewah32.Buffer32
    public void orWord(int i, int i2) {
        int[] iArr = this.buffer;
        iArr[i] = i2 | iArr[i];
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
        resizeBuffer(i2);
        int[] iArr = this.buffer;
        System.arraycopy(iArr, i, iArr, i + i2, this.actualSizeInWords - i);
        this.actualSizeInWords += i2;
    }

    @Override // com.googlecode.javaewah32.Buffer32
    public void collapse(int i, int i2) {
        int[] iArr = this.buffer;
        System.arraycopy(iArr, i + i2, iArr, i, (this.actualSizeInWords - i) - i2);
        for (int i3 = 0; i3 < i2; i3++) {
            removeLastWord();
        }
    }

    @Override // com.googlecode.javaewah32.Buffer32
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public IntArray m3474clone() {
        IntArray intArray;
        CloneNotSupportedException e;
        try {
            intArray = (IntArray) super.clone();
            try {
                intArray.buffer = (int[]) this.buffer.clone();
                intArray.actualSizeInWords = this.actualSizeInWords;
                return intArray;
            } catch (CloneNotSupportedException e2) {
                e = e2;
                e.printStackTrace();
                return intArray;
            }
        } catch (CloneNotSupportedException e3) {
            intArray = null;
            e = e3;
        }
    }

    @Override // com.googlecode.javaewah32.Buffer32
    public void swap(Buffer32 buffer32) {
        if (buffer32 instanceof IntArray) {
            int[] iArr = this.buffer;
            IntArray intArray = (IntArray) buffer32;
            this.buffer = intArray.buffer;
            intArray.buffer = iArr;
            int i = this.actualSizeInWords;
            this.actualSizeInWords = intArray.actualSizeInWords;
            intArray.actualSizeInWords = i;
            return;
        }
        int[] iArr2 = new int[buffer32.sizeInWords()];
        for (int i2 = 0; i2 < buffer32.sizeInWords(); i2++) {
            iArr2[i2] = buffer32.getWord(i2);
        }
        int iSizeInWords = buffer32.sizeInWords();
        buffer32.clear();
        buffer32.removeLastWord();
        buffer32.push_back(this, 0, sizeInWords());
        this.buffer = iArr2;
        this.actualSizeInWords = iSizeInWords;
    }

    private void resizeBuffer(int i) {
        int iNewSizeInWords = newSizeInWords(i);
        int[] iArr = this.buffer;
        if (iNewSizeInWords >= iArr.length) {
            int[] iArr2 = new int[iNewSizeInWords];
            this.buffer = iArr2;
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
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
