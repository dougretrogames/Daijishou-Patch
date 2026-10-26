package org.apache.commons.collections4.iterators;

import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;
import org.apache.commons.collections4.IteratorUtils;

/* INFO: loaded from: classes5.dex */
public final class ExtendedIterator<T> implements IteratorOperations<T> {
    private final Iterator<? extends T> base;
    private final boolean throwOnRemove;

    public static <T> ExtendedIterator<T> create(Iterator<T> it) {
        return it instanceof ExtendedIterator ? (ExtendedIterator) it : new ExtendedIterator<>(it, false);
    }

    public static <T> ExtendedIterator<T> create(Stream<T> stream) {
        return new ExtendedIterator<>(stream.iterator(), true);
    }

    public static <T> ExtendedIterator<T> createNoRemove(Iterator<T> it) {
        return new ExtendedIterator<>(it, true);
    }

    public static ExtendedIterator<?> emptyIterator() {
        return new ExtendedIterator<>(Collections.emptyIterator(), false);
    }

    public static <T> ExtendedIterator<T> flatten(Iterator<Iterator<T>> it) {
        return create(IteratorUtils.chainedIterator(it));
    }

    private ExtendedIterator(Iterator<? extends T> it, boolean z) {
        this.base = it;
        this.throwOnRemove = z;
    }

    public <X extends T> ExtendedIterator<T> andThen(Iterator<X> it) {
        Iterator<? extends T> it2 = this.base;
        if (it2 instanceof IteratorChain) {
            ((IteratorChain) it2).addIterator(it);
            return this;
        }
        return new ExtendedIterator<>(new IteratorChain(this.base, it), this.throwOnRemove);
    }

    public ExtendedIterator<T> filter(Predicate<T> predicate) {
        Objects.requireNonNull(predicate);
        return new ExtendedIterator<>(new FilterIterator(this, new ExtendedIterator$$ExternalSyntheticLambda1(predicate)), this.throwOnRemove);
    }

    @Override // java.util.Iterator
    public void forEachRemaining(Consumer<? super T> consumer) {
        this.base.forEachRemaining(consumer);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.base.hasNext();
    }

    public <U> ExtendedIterator<U> map(Function<T, U> function) {
        Objects.requireNonNull(function);
        return new ExtendedIterator<>(new TransformIterator(this, new ExtendedIterator$$ExternalSyntheticLambda0(function)), false);
    }

    @Override // java.util.Iterator
    public T next() {
        return this.base.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        if (this.throwOnRemove) {
            throw new UnsupportedOperationException();
        }
        this.base.remove();
    }
}
