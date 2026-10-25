package com.googlecode.javaewah32;

/* JADX INFO: loaded from: classes4.dex */
interface Buffer32 {
    void andLastWord(int i);

    void andWord(int i, int i2);

    void clear();

    Buffer32 clone() throws CloneNotSupportedException;

    void collapse(int i, int i2);

    void ensureCapacity(int i);

    void expand(int i, int i2);

    int getLastWord();

    int getWord(int i);

    void negateWord(int i);

    void negative_push_back(Buffer32 buffer32, int i, int i2);

    void orLastWord(int i);

    void orWord(int i, int i2);

    void push_back(int i);

    void push_back(Buffer32 buffer32, int i, int i2);

    void removeLastWord();

    void setLastWord(int i);

    void setWord(int i, int i2);

    int sizeInWords();

    void swap(Buffer32 buffer32);

    void trim();
}
