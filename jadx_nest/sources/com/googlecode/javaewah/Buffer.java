package com.googlecode.javaewah;

/* INFO: loaded from: classes4.dex */
interface Buffer {
    void andLastWord(long j);

    void andWord(int i, long j);

    void clear();

    Buffer clone() throws CloneNotSupportedException;

    void collapse(int i, int i2);

    void ensureCapacity(int i);

    void expand(int i, int i2);

    long getLastWord();

    long getWord(int i);

    void negateWord(int i);

    void negative_push_back(Buffer buffer, int i, int i2);

    void orLastWord(long j);

    void orWord(int i, long j);

    void push_back(long j);

    void push_back(Buffer buffer, int i, int i2);

    void removeLastWord();

    void setLastWord(long j);

    void setWord(int i, long j);

    int sizeInWords();

    void swap(Buffer buffer);

    void trim();
}
