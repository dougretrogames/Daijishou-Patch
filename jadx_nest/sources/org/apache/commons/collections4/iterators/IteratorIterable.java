package org.apache.commons.collections4.iterators;

import java.util.Iterator;
import org.apache.commons.collections4.ResettableIterator;

/* JADX INFO: loaded from: classes5.dex */
public class IteratorIterable<E> implements Iterable<E> {
    private final Iterator<? extends E> iterator;
    private final Iterator<E> typeSafeIterator;

    /* JADX INFO: renamed from: org.apache.commons.collections4.iterators.IteratorIterable$1, reason: invalid class name */
    class AnonymousClass1 implements Iterator<E> {
        final /* synthetic */ Iterator val$iterator;

        AnonymousClass1(Iterator it) {
            this.val$iterator = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.val$iterator.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            return (E) this.val$iterator.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.val$iterator.remove();
        }
    }

    private static <E> Iterator<E> createTypesafeIterator(Iterator<? extends E> it) {
        return new AnonymousClass1(it);
    }

    public IteratorIterable(Iterator<? extends E> it) {
        this(it, false);
    }

    public IteratorIterable(Iterator<? extends E> it, boolean z) {
        if (z && !(it instanceof ResettableIterator)) {
            this.iterator = new ListIteratorWrapper(it);
        } else {
            this.iterator = it;
        }
        this.typeSafeIterator = createTypesafeIterator(this.iterator);
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        Iterator<? extends E> it = this.iterator;
        if (it instanceof ResettableIterator) {
            ((ResettableIterator) it).reset();
        }
        return this.typeSafeIterator;
    }
}
