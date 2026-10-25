package com.googlecode.javaewah;

/* JADX INFO: loaded from: classes4.dex */
public interface LogicalElement<T> {
    T and(T t);

    T andNot(T t);

    T compose(T t);

    void not();

    T or(T t);

    int sizeInBits();

    int sizeInBytes();

    T xor(T t);
}
