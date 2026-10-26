package org.apache.commons.collections4.iterators;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Objects;

/* INFO: loaded from: classes5.dex */
public class PushbackIterator<E> implements Iterator<E> {
    private final Deque<E> items = new ArrayDeque();
    private final Iterator<? extends E> iterator;

    public static <E> PushbackIterator<E> pushbackIterator(Iterator<? extends E> it) {
        Objects.requireNonNull(it, "iterator");
        if (it instanceof PushbackIterator) {
            return (PushbackIterator) it;
        }
        return new PushbackIterator<>(it);
    }

    public PushbackIterator(Iterator<? extends E> it) {
        this.iterator = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return !this.items.isEmpty() || this.iterator.hasNext();
    }

    @Override // java.util.Iterator
    public E next() {
        return !this.items.isEmpty() ? this.items.pop() : this.iterator.next();
    }

    public void pushback(E e) {
        this.items.push(e);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
