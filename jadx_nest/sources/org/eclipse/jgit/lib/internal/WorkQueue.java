package org.eclipse.jgit.lib.internal;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes5.dex */
public class WorkQueue {
    private static final ScheduledThreadPoolExecutor executor;
    static final Object executorKiller;

    /* JADX INFO: renamed from: org.eclipse.jgit.lib.internal.WorkQueue$1, reason: invalid class name */
    class AnonymousClass1 implements ThreadFactory {
        private final ThreadFactory baseFactory = Executors.defaultThreadFactory();

        AnonymousClass1() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread threadNewThread = this.baseFactory.newThread(runnable);
            threadNewThread.setName("JGit-WorkQueue");
            threadNewThread.setContextClassLoader(null);
            threadNewThread.setDaemon(true);
            return threadNewThread;
        }
    }

    static {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new AnonymousClass1());
        executor = scheduledThreadPoolExecutor;
        scheduledThreadPoolExecutor.setRemoveOnCancelPolicy(true);
        scheduledThreadPoolExecutor.setContinueExistingPeriodicTasksAfterShutdownPolicy(false);
        scheduledThreadPoolExecutor.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
        scheduledThreadPoolExecutor.prestartAllCoreThreads();
        scheduledThreadPoolExecutor.setThreadFactory(Executors.defaultThreadFactory());
        executorKiller = new AnonymousClass2();
    }

    /* JADX INFO: renamed from: org.eclipse.jgit.lib.internal.WorkQueue$2, reason: invalid class name */
    class AnonymousClass2 {
        AnonymousClass2() {
        }

        protected void finalize() {
            WorkQueue.executor.shutdownNow();
        }
    }

    public static ScheduledThreadPoolExecutor getExecutor() {
        return executor;
    }
}
