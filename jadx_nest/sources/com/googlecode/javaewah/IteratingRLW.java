package com.googlecode.javaewah;

/* INFO: loaded from: classes4.dex */
public interface IteratingRLW {
    IteratingRLW clone() throws CloneNotSupportedException;

    void discardFirstWords(long j);

    void discardLiteralWords(long j);

    void discardRunningWords();

    long getLiteralWordAt(int i);

    int getNumberOfLiteralWords();

    boolean getRunningBit();

    long getRunningLength();

    boolean next();

    long size();
}
