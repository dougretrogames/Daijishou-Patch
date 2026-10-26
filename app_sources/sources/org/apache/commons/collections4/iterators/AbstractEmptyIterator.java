package org.apache.commons.collections4.iterators;

import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableIterator;

/* INFO: loaded from: classes5.dex */
abstract class AbstractEmptyIterator<E> implements ResettableIterator<E> {
    @Override // java.util.Iterator
    public boolean hasNext() {
        return false;
    }

    public boolean hasPrevious() {
        return false;
    }

    public int nextIndex() {
        return 0;
    }

    public int previousIndex() {
        return -1;
    }

    @Override // org.apache.commons.collections4.ResettableIterator
    public void reset() {
    }

    protected AbstractEmptyIterator() {
    }

    @Deprecated
    public void add(E e) {
        throw new UnsupportedOperationException("add() not supported for empty Iterator");
    }

    @Override // java.util.Iterator
    public E next() {
        throw new NoSuchElementException("Iterator contains no elements");
    }

    public E previous() {
        throw new NoSuchElementException("Iterator contains no elements");
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new IllegalStateException("Iterator contains no elements");
    }

    public void set(E e) {
        throw new IllegalStateException("Iterator contains no elements");
    }
}
