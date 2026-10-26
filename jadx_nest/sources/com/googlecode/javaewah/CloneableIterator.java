package com.googlecode.javaewah;

/* INFO: loaded from: classes4.dex */
public interface CloneableIterator<E> extends Cloneable {
    CloneableIterator<E> clone() throws CloneNotSupportedException;

    boolean hasNext();

    E next();
}
