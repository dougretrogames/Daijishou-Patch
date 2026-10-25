package org.apache.commons.io.function;

import java.util.Comparator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes5.dex */
final class UncheckedIOSpliterator<T> implements Spliterator<T> {
    private final IOSpliterator<T> delegate;

    UncheckedIOSpliterator(IOSpliterator<T> iOSpliterator) {
        this.delegate = (IOSpliterator) Objects.requireNonNull(iOSpliterator, "delegate");
    }

    @Override // java.util.Spliterator
    public int characteristics() {
        return this.delegate.characteristics();
    }

    @Override // java.util.Spliterator
    public long estimateSize() {
        return this.delegate.estimateSize();
    }

    @Override // java.util.Spliterator
    public void forEachRemaining(Consumer<? super T> consumer) {
        IOSpliterator<T> iOSpliterator = this.delegate;
        Objects.requireNonNull(iOSpliterator);
        UncheckedIOSpliterator$$ExternalSyntheticLambda3 uncheckedIOSpliterator$$ExternalSyntheticLambda3 = new UncheckedIOSpliterator$$ExternalSyntheticLambda3(iOSpliterator);
        Objects.requireNonNull(consumer);
        Uncheck.accept(uncheckedIOSpliterator$$ExternalSyntheticLambda3, new UncheckedIOSpliterator$$ExternalSyntheticLambda1(consumer));
    }

    @Override // java.util.Spliterator
    public Comparator<? super T> getComparator() {
        return this.delegate.getComparator().asComparator();
    }

    @Override // java.util.Spliterator
    public long getExactSizeIfKnown() {
        return this.delegate.getExactSizeIfKnown();
    }

    @Override // java.util.Spliterator
    public boolean hasCharacteristics(int i) {
        return this.delegate.hasCharacteristics(i);
    }

    @Override // java.util.Spliterator
    public boolean tryAdvance(Consumer<? super T> consumer) {
        IOSpliterator<T> iOSpliterator = this.delegate;
        Objects.requireNonNull(iOSpliterator);
        UncheckedIOSpliterator$$ExternalSyntheticLambda0 uncheckedIOSpliterator$$ExternalSyntheticLambda0 = new UncheckedIOSpliterator$$ExternalSyntheticLambda0(iOSpliterator);
        Objects.requireNonNull(consumer);
        return ((Boolean) Uncheck.apply(uncheckedIOSpliterator$$ExternalSyntheticLambda0, new UncheckedIOSpliterator$$ExternalSyntheticLambda1(consumer))).booleanValue();
    }

    @Override // java.util.Spliterator
    public Spliterator<T> trySplit() {
        IOSpliterator<T> iOSpliterator = this.delegate;
        Objects.requireNonNull(iOSpliterator);
        return ((IOSpliterator) Uncheck.get(new UncheckedIOSpliterator$$ExternalSyntheticLambda2(iOSpliterator))).unwrap();
    }
}
