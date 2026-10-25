package org.apache.commons.collections4.iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public class CartesianProductIterator<E> implements Iterator<List<E>> {
    private final List<Iterable<? extends E>> iterables;
    private final List<Iterator<? extends E>> iterators;
    private List<E> previousTuple;

    @SafeVarargs
    public CartesianProductIterator(Iterable<? extends E>... iterableArr) {
        Objects.requireNonNull(iterableArr, "iterables");
        this.iterables = new ArrayList(iterableArr.length);
        this.iterators = new ArrayList(iterableArr.length);
        for (Iterable<? extends E> iterable : iterableArr) {
            Objects.requireNonNull(iterable, "iterable");
            this.iterables.add(iterable);
            Iterator<? extends E> it = iterable.iterator();
            if (!it.hasNext()) {
                this.iterators.clear();
                return;
            }
            this.iterators.add(it);
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.iterators.stream().anyMatch(new CartesianProductIterator$$ExternalSyntheticLambda0());
    }

    @Override // java.util.Iterator
    public List<E> next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (this.previousTuple == null) {
            this.previousTuple = new ArrayList(this.iterables.size());
            Iterator<Iterator<? extends E>> it = this.iterators.iterator();
            while (it.hasNext()) {
                this.previousTuple.add(it.next().next());
            }
            return new ArrayList(this.previousTuple);
        }
        for (int size = this.iterators.size() - 1; size >= 0; size--) {
            Iterator<? extends E> it2 = this.iterators.get(size);
            if (it2.hasNext()) {
                this.previousTuple.set(size, it2.next());
                return new ArrayList(this.previousTuple);
            }
            Iterator<? extends E> it3 = this.iterables.get(size).iterator();
            this.iterators.set(size, it3);
            this.previousTuple.set(size, it3.next());
        }
        throw new IllegalStateException("reached unreachable code");
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove");
    }
}
