package co.infinum.retromock;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
final class DefaultThreadFactory implements ThreadFactory {
    static final AtomicInteger POOL_INDEX = new AtomicInteger();

    DefaultThreadFactory() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "Retromock-" + POOL_INDEX.getAndIncrement() + "-thread");
        thread.setDaemon(true);
        return thread;
    }
}
