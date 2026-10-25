package org.apache.commons.io.function;

import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
final class UncheckedIOIterator<E> implements Iterator<E> {
    private final IOIterator<E> delegate;

    UncheckedIOIterator(IOIterator<E> iOIterator) {
        this.delegate = (IOIterator) Objects.requireNonNull(iOIterator, "delegate");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        IOIterator<E> iOIterator = this.delegate;
        Objects.requireNonNull(iOIterator);
        return Uncheck.getAsBoolean(new UncheckedIOIterator$$ExternalSyntheticLambda2(iOIterator));
    }

    @Override // java.util.Iterator
    public E next() {
        IOIterator<E> iOIterator = this.delegate;
        Objects.requireNonNull(iOIterator);
        return (E) Uncheck.get(new UncheckedIOIterator$$ExternalSyntheticLambda0(iOIterator));
    }

    @Override // java.util.Iterator
    public void remove() {
        IOIterator<E> iOIterator = this.delegate;
        Objects.requireNonNull(iOIterator);
        Uncheck.run(new UncheckedIOIterator$$ExternalSyntheticLambda1(iOIterator));
    }
}
