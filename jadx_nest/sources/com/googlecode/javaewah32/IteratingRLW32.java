package com.googlecode.javaewah32;

/* JADX INFO: loaded from: classes4.dex */
public interface IteratingRLW32 {
    IteratingRLW32 clone() throws CloneNotSupportedException;

    void discardFirstWords(int i);

    void discardLiteralWords(int i);

    void discardRunningWords();

    int getLiteralWordAt(int i);

    int getNumberOfLiteralWords();

    boolean getRunningBit();

    int getRunningLength();

    boolean next();

    int size();
}
