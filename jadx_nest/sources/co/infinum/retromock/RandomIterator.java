package co.infinum.retromock;

/* JADX INFO: loaded from: classes3.dex */
final class RandomIterator<T> implements ResponseIterator<T> {
    private final RandomProvider randomProvider;
    private final T[] responses;

    RandomIterator(T[] tArr) {
        this(tArr, new ThreadLocalRandomProvider());
    }

    RandomIterator(T[] tArr, RandomProvider randomProvider) {
        Preconditions.checkNotNullOrEmpty(tArr, "");
        this.responses = tArr;
        this.randomProvider = randomProvider;
    }

    @Override // co.infinum.retromock.ResponseIterator
    public T next() {
        T[] tArr = this.responses;
        return tArr[this.randomProvider.nextInt(tArr.length)];
    }
}
