package io.grpc;

import androidx.compose.runtime.CompositionImpl$$ExternalSyntheticBackportWithForwarding0;
import com.google.common.base.Preconditions;
import java.time.Duration;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* INFO: loaded from: classes4.dex */
public final class SynchronizationContext implements Executor {
    private final Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
    private final Queue<Runnable> queue = new ConcurrentLinkedQueue();
    private final AtomicReference<Thread> drainingThread = new AtomicReference<>();

    public SynchronizationContext(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.uncaughtExceptionHandler = (Thread.UncaughtExceptionHandler) Preconditions.checkNotNull(uncaughtExceptionHandler, "uncaughtExceptionHandler");
    }

    public final void drain() {
        while (CompositionImpl$$ExternalSyntheticBackportWithForwarding0.m(this.drainingThread, null, Thread.currentThread())) {
            while (true) {
                try {
                    Runnable runnablePoll = this.queue.poll();
                    if (runnablePoll == null) {
                        break;
                    }
                    try {
                        runnablePoll.run();
                    } catch (Throwable th) {
                        this.uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
                    }
                } catch (Throwable th2) {
                    this.drainingThread.set(null);
                    throw th2;
                }
            }
            this.drainingThread.set(null);
            if (this.queue.isEmpty()) {
                return;
            }
        }
    }

    public final void executeLater(Runnable runnable) {
        this.queue.add((Runnable) Preconditions.checkNotNull(runnable, "runnable is null"));
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        executeLater(runnable);
        drain();
    }

    public void throwIfNotInThisSynchronizationContext() {
        Preconditions.checkState(Thread.currentThread() == this.drainingThread.get(), "Not called from the SynchronizationContext");
    }

    /* INFO: renamed from: io.grpc.SynchronizationContext$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ ManagedRunnable val$runnable;
        final /* synthetic */ Runnable val$task;

        AnonymousClass1(ManagedRunnable managedRunnable, Runnable runnable) {
            this.val$runnable = managedRunnable;
            this.val$task = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            SynchronizationContext.this.execute(this.val$runnable);
        }

        public String toString() {
            return this.val$task.toString() + "(scheduled in SynchronizationContext)";
        }
    }

    public final ScheduledHandle schedule(Runnable runnable, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        ManagedRunnable managedRunnable = new ManagedRunnable(runnable);
        return new ScheduledHandle(managedRunnable, scheduledExecutorService.schedule(new AnonymousClass1(managedRunnable, runnable), j, timeUnit), null);
    }

    public final ScheduledHandle schedule(Runnable runnable, Duration duration, ScheduledExecutorService scheduledExecutorService) {
        return schedule(runnable, TimeUtils.convertToNanos(duration), TimeUnit.NANOSECONDS, scheduledExecutorService);
    }

    /* INFO: renamed from: io.grpc.SynchronizationContext$2, reason: invalid class name */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ long val$delay;
        final /* synthetic */ ManagedRunnable val$runnable;
        final /* synthetic */ Runnable val$task;

        AnonymousClass2(ManagedRunnable managedRunnable, Runnable runnable, long j) {
            this.val$runnable = managedRunnable;
            this.val$task = runnable;
            this.val$delay = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            SynchronizationContext.this.execute(this.val$runnable);
        }

        public String toString() {
            return this.val$task.toString() + "(scheduled in SynchronizationContext with delay of " + this.val$delay + ")";
        }
    }

    public final ScheduledHandle scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        ManagedRunnable managedRunnable = new ManagedRunnable(runnable);
        return new ScheduledHandle(managedRunnable, scheduledExecutorService.scheduleWithFixedDelay(new AnonymousClass2(managedRunnable, runnable, j2), j, j2, timeUnit), null);
    }

    public final ScheduledHandle scheduleWithFixedDelay(Runnable runnable, Duration duration, Duration duration2, ScheduledExecutorService scheduledExecutorService) {
        return scheduleWithFixedDelay(runnable, TimeUtils.convertToNanos(duration), TimeUtils.convertToNanos(duration2), TimeUnit.NANOSECONDS, scheduledExecutorService);
    }

    private static class ManagedRunnable implements Runnable {
        boolean hasStarted;
        boolean isCancelled;
        final Runnable task;

        ManagedRunnable(Runnable runnable) {
            this.task = (Runnable) Preconditions.checkNotNull(runnable, "task");
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.isCancelled) {
                return;
            }
            this.hasStarted = true;
            this.task.run();
        }
    }

    public static final class ScheduledHandle {
        private final ScheduledFuture<?> future;
        private final ManagedRunnable runnable;

        /* synthetic */ ScheduledHandle(ManagedRunnable managedRunnable, ScheduledFuture scheduledFuture, AnonymousClass1 anonymousClass1) {
            this(managedRunnable, scheduledFuture);
        }

        private ScheduledHandle(ManagedRunnable managedRunnable, ScheduledFuture<?> scheduledFuture) {
            this.runnable = (ManagedRunnable) Preconditions.checkNotNull(managedRunnable, "runnable");
            this.future = (ScheduledFuture) Preconditions.checkNotNull(scheduledFuture, "future");
        }

        public void cancel() {
            this.runnable.isCancelled = true;
            this.future.cancel(false);
        }

        public boolean isPending() {
            return (this.runnable.hasStarted || this.runnable.isCancelled) ? false : true;
        }
    }
}
