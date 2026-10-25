package org.apache.commons.collections4.iterators;

import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractUntypedIteratorDecorator<I, O> implements Iterator<O> {
    private final Iterator<I> iterator;

    protected AbstractUntypedIteratorDecorator(Iterator<I> it) {
        this.iterator = (Iterator) Objects.requireNonNull(it, "iterator");
    }

    protected Iterator<I> getIterator() {
        return this.iterator;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.iterator.remove();
    }
}
