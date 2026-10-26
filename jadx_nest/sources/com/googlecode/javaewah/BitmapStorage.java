package com.googlecode.javaewah;

/* INFO: loaded from: classes4.dex */
public interface BitmapStorage {
    void addLiteralWord(long j);

    void addStreamOfEmptyWords(boolean z, long j);

    void addStreamOfLiteralWords(Buffer buffer, int i, int i2);

    void addStreamOfNegatedLiteralWords(Buffer buffer, int i, int i2);

    void addWord(long j);

    void clear();

    void setSizeInBitsWithinLastWord(int i);
}
