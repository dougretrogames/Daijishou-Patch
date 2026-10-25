package co.infinum.retromock;

import java.util.concurrent.ThreadLocalRandom;

/* JADX INFO: loaded from: classes3.dex */
class ThreadLocalRandomProvider implements RandomProvider {
    ThreadLocalRandomProvider() {
    }

    @Override // co.infinum.retromock.RandomProvider
    public long nextLong(long j) {
        return ThreadLocalRandom.current().nextLong(j);
    }

    @Override // co.infinum.retromock.RandomProvider
    public int nextInt(int i) {
        return ThreadLocalRandom.current().nextInt(i);
    }
}
