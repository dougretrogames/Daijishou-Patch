package co.infinum.retromock;

import java.util.concurrent.atomic.AtomicInteger;

/* INFO: loaded from: classes3.dex */
final class SequentialIterator<T> implements ResponseIterator<T> {
    private AtomicInteger index = new AtomicInteger();
    private final T[] responses;

    SequentialIterator(T[] tArr) {
        Preconditions.checkNotEmpty(tArr, "Responses should contain at least one response.");
        this.responses = tArr;
    }

    @Override // co.infinum.retromock.ResponseIterator
    public T next() {
        int andIncrement = this.index.getAndIncrement();
        T[] tArr = this.responses;
        if (andIncrement >= tArr.length) {
            return tArr[tArr.length - 1];
        }
        return tArr[andIncrement];
    }
}
