package org.apache.commons.io.function;

import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
final class UncheckedIOIterable<E> implements Iterable<E> {
    private final IOIterable<E> delegate;

    UncheckedIOIterable(IOIterable<E> iOIterable) {
        this.delegate = (IOIterable) Objects.requireNonNull(iOIterable, "delegate");
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        return new UncheckedIOIterator(this.delegate.iterator());
    }
}
