package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.CheckForNull;

/* INFO: loaded from: classes4.dex */
@ElementTypesAreNonnullByDefault
public final class ThreadFactoryBuilder {

    @CheckForNull
    private String nameFormat = null;

    @CheckForNull
    private Boolean daemon = null;

    @CheckForNull
    private Integer priority = null;

    @CheckForNull
    private Thread.UncaughtExceptionHandler uncaughtExceptionHandler = null;

    @CheckForNull
    private ThreadFactory backingThreadFactory = null;

    public ThreadFactoryBuilder setNameFormat(String nameFormat) {
        format(nameFormat, 0);
        this.nameFormat = nameFormat;
        return this;
    }

    public ThreadFactoryBuilder setDaemon(boolean daemon) {
        this.daemon = Boolean.valueOf(daemon);
        return this;
    }

    public ThreadFactoryBuilder setPriority(int priority) {
        Preconditions.checkArgument(priority >= 1, "Thread priority (%s) must be >= %s", priority, 1);
        Preconditions.checkArgument(priority <= 10, "Thread priority (%s) must be <= %s", priority, 10);
        this.priority = Integer.valueOf(priority);
        return this;
    }

    public ThreadFactoryBuilder setUncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.uncaughtExceptionHandler = (Thread.UncaughtExceptionHandler) Preconditions.checkNotNull(uncaughtExceptionHandler);
        return this;
    }

    public ThreadFactoryBuilder setThreadFactory(ThreadFactory backingThreadFactory) {
        this.backingThreadFactory = (ThreadFactory) Preconditions.checkNotNull(backingThreadFactory);
        return this;
    }

    public ThreadFactory build() {
        return doBuild(this);
    }

    private static ThreadFactory doBuild(ThreadFactoryBuilder builder) {
        String str = builder.nameFormat;
        Boolean bool = builder.daemon;
        Integer num = builder.priority;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = builder.uncaughtExceptionHandler;
        ThreadFactory threadFactoryDefaultThreadFactory = builder.backingThreadFactory;
        if (threadFactoryDefaultThreadFactory == null) {
            threadFactoryDefaultThreadFactory = Executors.defaultThreadFactory();
        }
        return new AnonymousClass1(threadFactoryDefaultThreadFactory, str, str != null ? new AtomicLong(0L) : null, bool, num, uncaughtExceptionHandler);
    }

    /* INFO: renamed from: com.google.common.util.concurrent.ThreadFactoryBuilder$1, reason: invalid class name */
    class AnonymousClass1 implements ThreadFactory {
        final /* synthetic */ ThreadFactory val$backingThreadFactory;
        final /* synthetic */ AtomicLong val$count;
        final /* synthetic */ Boolean val$daemon;
        final /* synthetic */ String val$nameFormat;
        final /* synthetic */ Integer val$priority;
        final /* synthetic */ Thread.UncaughtExceptionHandler val$uncaughtExceptionHandler;

        AnonymousClass1(final ThreadFactory val$backingThreadFactory, final String val$nameFormat, final AtomicLong val$count, final Boolean val$daemon, final Integer val$priority, final Thread.UncaughtExceptionHandler val$uncaughtExceptionHandler) {
            this.val$backingThreadFactory = val$backingThreadFactory;
            this.val$nameFormat = val$nameFormat;
            this.val$count = val$count;
            this.val$daemon = val$daemon;
            this.val$priority = val$priority;
            this.val$uncaughtExceptionHandler = val$uncaughtExceptionHandler;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread threadNewThread = this.val$backingThreadFactory.newThread(runnable);
            Objects.requireNonNull(threadNewThread);
            String str = this.val$nameFormat;
            if (str != null) {
                threadNewThread.setName(ThreadFactoryBuilder.format(str, Long.valueOf(((AtomicLong) Objects.requireNonNull(this.val$count)).getAndIncrement())));
            }
            Boolean bool = this.val$daemon;
            if (bool != null) {
                threadNewThread.setDaemon(bool.booleanValue());
            }
            Integer num = this.val$priority;
            if (num != null) {
                threadNewThread.setPriority(num.intValue());
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.val$uncaughtExceptionHandler;
            if (uncaughtExceptionHandler != null) {
                threadNewThread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
            }
            return threadNewThread;
        }
    }

    /* INFO: Access modifiers changed from: private */
    public static String format(String format, Object... args) {
        return String.format(Locale.ROOT, format, args);
    }
}
