package net.jodah.expiringmap.internal;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* INFO: loaded from: classes5.dex */
public class NamedThreadFactory implements ThreadFactory {
    private final String nameFormat;
    private final AtomicInteger threadNumber = new AtomicInteger(1);

    public NamedThreadFactory(String str) {
        this.nameFormat = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, String.format(this.nameFormat, Integer.valueOf(this.threadNumber.getAndIncrement())));
        thread.setDaemon(true);
        return thread;
    }
}
