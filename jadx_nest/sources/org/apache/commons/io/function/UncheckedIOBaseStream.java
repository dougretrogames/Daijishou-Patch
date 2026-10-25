package org.apache.commons.io.function;

import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.stream.BaseStream;
import org.apache.commons.io.function.IOBaseStream;

/* JADX INFO: loaded from: classes5.dex */
final class UncheckedIOBaseStream<T, S extends IOBaseStream<T, S, B>, B extends BaseStream<T, B>> implements BaseStream<T, B> {
    private final S delegate;

    UncheckedIOBaseStream(S s) {
        this.delegate = s;
    }

    @Override // java.util.stream.BaseStream, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    @Override // java.util.stream.BaseStream
    public boolean isParallel() {
        return this.delegate.isParallel();
    }

    @Override // java.util.stream.BaseStream
    public Iterator<T> iterator() {
        return this.delegate.iterator().asIterator();
    }

    @Override // java.util.stream.BaseStream
    public B onClose(Runnable runnable) {
        S s = this.delegate;
        Objects.requireNonNull(s);
        return (B) ((IOBaseStream) Uncheck.apply(new UncheckedIOBaseStream$$ExternalSyntheticLambda0(s), new UncheckedIOBaseStream$$ExternalSyntheticLambda1(runnable))).unwrap();
    }

    @Override // java.util.stream.BaseStream
    public B parallel() {
        return (B) this.delegate.parallel().unwrap();
    }

    @Override // java.util.stream.BaseStream
    public B sequential() {
        return (B) this.delegate.sequential().unwrap();
    }

    @Override // java.util.stream.BaseStream
    public Spliterator<T> spliterator() {
        return this.delegate.spliterator().unwrap();
    }

    @Override // java.util.stream.BaseStream
    public B unordered() {
        return (B) this.delegate.unordered().unwrap();
    }
}
