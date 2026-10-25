package com.googlecode.javaewah;

/* JADX INFO: loaded from: classes4.dex */
public interface ChunkIterator {
    boolean hasNext();

    void move();

    void move(int i);

    boolean nextBit();

    int nextLength();
}
