package com.googlecode.javaewah32;

/* INFO: loaded from: classes4.dex */
public interface BitmapStorage32 {
    void addLiteralWord(int i);

    void addStreamOfEmptyWords(boolean z, int i);

    void addStreamOfLiteralWords(Buffer32 buffer32, int i, int i2);

    void addStreamOfNegatedLiteralWords(Buffer32 buffer32, int i, int i2);

    void addWord(int i);

    void clear();

    void setSizeInBitsWithinLastWord(int i);
}
