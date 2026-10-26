package co.infinum.retromock;

import java.util.concurrent.atomic.AtomicInteger;

/* INFO: loaded from: classes3.dex */
final class CircularIterator<T> implements ResponseIterator<T> {
    private AtomicInteger index = new AtomicInteger();
    private final T[] responses;

    CircularIterator(T[] tArr) {
        Preconditions.checkNotEmpty(tArr, "Responses should contain at least one response.");
        this.responses = tArr;
    }

    @Override // co.infinum.retromock.ResponseIterator
    public T next() {
        return this.responses[this.index.getAndIncrement() % this.responses.length];
    }
}
