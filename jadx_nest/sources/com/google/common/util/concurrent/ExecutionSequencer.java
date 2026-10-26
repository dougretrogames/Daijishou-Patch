package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.CheckForNull;

/* INFO: loaded from: classes4.dex */
@ElementTypesAreNonnullByDefault
public final class ExecutionSequencer {
    private final AtomicReference<ListenableFuture<Void>> ref = new AtomicReference<>(Futures.immediateVoidFuture());

    @LazyInit
    private ThreadConfinedTaskQueue latestTaskQueue = new ThreadConfinedTaskQueue(null);

    enum RunningState {
        NOT_RUN,
        CANCELLED,
        STARTED
    }

    private ExecutionSequencer() {
    }

    public static ExecutionSequencer create() {
        return new ExecutionSequencer();
    }

    private static final class ThreadConfinedTaskQueue {

        @CheckForNull
        Executor nextExecutor;

        @CheckForNull
        Runnable nextTask;

        @CheckForNull
        @LazyInit
        Thread thread;

        private ThreadConfinedTaskQueue() {
        }

        /* synthetic */ ThreadConfinedTaskQueue(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public <T> ListenableFuture<T> submit(Callable<T> callable, Executor executor) {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull(executor);
        return submitAsync(new AnonymousClass1(this, callable), executor);
    }

    /* INFO: Add missing generic type declarations: [T] */
    /* INFO: renamed from: com.google.common.util.concurrent.ExecutionSequencer$1, reason: invalid class name */
    class AnonymousClass1<T> implements AsyncCallable<T> {
        final /* synthetic */ Callable val$callable;

        AnonymousClass1(final ExecutionSequencer this$0, final Callable val$callable) {
            this.val$callable = val$callable;
        }

        @Override // com.google.common.util.concurrent.AsyncCallable
        public ListenableFuture<T> call() throws Exception {
            return Futures.immediateFuture(this.val$callable.call());
        }

        public String toString() {
            return this.val$callable.toString();
        }
    }

    public <T> ListenableFuture<T> submitAsync(AsyncCallable<T> callable, Executor executor) {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull(executor);
        TaskNonReentrantExecutor taskNonReentrantExecutor = new TaskNonReentrantExecutor(executor, this, null);
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(this, taskNonReentrantExecutor, callable);
        SettableFuture settableFutureCreate = SettableFuture.create();
        ListenableFuture<Void> andSet = this.ref.getAndSet(settableFutureCreate);
        TrustedListenableFutureTask trustedListenableFutureTaskCreate = TrustedListenableFutureTask.create(anonymousClass2);
        andSet.addListener(trustedListenableFutureTaskCreate, taskNonReentrantExecutor);
        ListenableFuture<T> listenableFutureNonCancellationPropagating = Futures.nonCancellationPropagating(trustedListenableFutureTaskCreate);
        ExecutionSequencer$$ExternalSyntheticLambda0 executionSequencer$$ExternalSyntheticLambda0 = new ExecutionSequencer$$ExternalSyntheticLambda0(trustedListenableFutureTaskCreate, settableFutureCreate, andSet, listenableFutureNonCancellationPropagating, taskNonReentrantExecutor);
        listenableFutureNonCancellationPropagating.addListener(executionSequencer$$ExternalSyntheticLambda0, MoreExecutors.directExecutor());
        trustedListenableFutureTaskCreate.addListener(executionSequencer$$ExternalSyntheticLambda0, MoreExecutors.directExecutor());
        return listenableFutureNonCancellationPropagating;
    }

    /* INFO: Add missing generic type declarations: [T] */
    /* INFO: renamed from: com.google.common.util.concurrent.ExecutionSequencer$2, reason: invalid class name */
    class AnonymousClass2<T> implements AsyncCallable<T> {
        final /* synthetic */ AsyncCallable val$callable;
        final /* synthetic */ TaskNonReentrantExecutor val$taskExecutor;

        AnonymousClass2(final ExecutionSequencer this$0, final TaskNonReentrantExecutor val$taskExecutor, final AsyncCallable val$callable) {
            this.val$taskExecutor = val$taskExecutor;
            this.val$callable = val$callable;
        }

        @Override // com.google.common.util.concurrent.AsyncCallable
        public ListenableFuture<T> call() throws Exception {
            if (!this.val$taskExecutor.trySetStarted()) {
                return Futures.immediateCancelledFuture();
            }
            return this.val$callable.call();
        }

        public String toString() {
            return this.val$callable.toString();
        }
    }

    static /* synthetic */ void lambda$submitAsync$0(TrustedListenableFutureTask trustedListenableFutureTask, SettableFuture settableFuture, ListenableFuture listenableFuture, ListenableFuture listenableFuture2, TaskNonReentrantExecutor taskNonReentrantExecutor) {
        if (trustedListenableFutureTask.isDone()) {
            settableFuture.setFuture(listenableFuture);
        } else if (listenableFuture2.isCancelled() && taskNonReentrantExecutor.trySetCancelled()) {
            trustedListenableFutureTask.cancel(false);
        }
    }

    /* INFO: Access modifiers changed from: private */
    static final class TaskNonReentrantExecutor extends AtomicReference<RunningState> implements Executor, Runnable {

        @CheckForNull
        Executor delegate;

        @CheckForNull
        ExecutionSequencer sequencer;

        @CheckForNull
        @LazyInit
        Thread submitting;

        @CheckForNull
        Runnable task;

        /* synthetic */ TaskNonReentrantExecutor(Executor executor, ExecutionSequencer executionSequencer, AnonymousClass1 anonymousClass1) {
            this(executor, executionSequencer);
        }

        private TaskNonReentrantExecutor(Executor delegate, ExecutionSequencer sequencer) {
            super(RunningState.NOT_RUN);
            this.delegate = delegate;
            this.sequencer = sequencer;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable task) {
            if (get() == RunningState.CANCELLED) {
                this.delegate = null;
                this.sequencer = null;
                return;
            }
            this.submitting = Thread.currentThread();
            try {
                ThreadConfinedTaskQueue threadConfinedTaskQueue = ((ExecutionSequencer) Objects.requireNonNull(this.sequencer)).latestTaskQueue;
                if (threadConfinedTaskQueue.thread == this.submitting) {
                    this.sequencer = null;
                    Preconditions.checkState(threadConfinedTaskQueue.nextTask == null);
                    threadConfinedTaskQueue.nextTask = task;
                    threadConfinedTaskQueue.nextExecutor = (Executor) Objects.requireNonNull(this.delegate);
                    this.delegate = null;
                } else {
                    Executor executor = (Executor) Objects.requireNonNull(this.delegate);
                    this.delegate = null;
                    this.task = task;
                    executor.execute(this);
                }
            } finally {
                this.submitting = null;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Executor executor;
            Thread threadCurrentThread = Thread.currentThread();
            if (threadCurrentThread != this.submitting) {
                Runnable runnable = (Runnable) Objects.requireNonNull(this.task);
                this.task = null;
                runnable.run();
                return;
            }
            ThreadConfinedTaskQueue threadConfinedTaskQueue = new ThreadConfinedTaskQueue(null);
            threadConfinedTaskQueue.thread = threadCurrentThread;
            ((ExecutionSequencer) Objects.requireNonNull(this.sequencer)).latestTaskQueue = threadConfinedTaskQueue;
            this.sequencer = null;
            try {
                Runnable runnable2 = (Runnable) Objects.requireNonNull(this.task);
                this.task = null;
                runnable2.run();
                while (true) {
                    Runnable runnable3 = threadConfinedTaskQueue.nextTask;
                    if (runnable3 == null || (executor = threadConfinedTaskQueue.nextExecutor) == null) {
                        break;
                    }
                    threadConfinedTaskQueue.nextTask = null;
                    threadConfinedTaskQueue.nextExecutor = null;
                    executor.execute(runnable3);
                }
                threadConfinedTaskQueue.thread = null;
            } catch (Throwable th) {
                threadConfinedTaskQueue.thread = null;
                throw th;
            }
        }

        /* INFO: Access modifiers changed from: private */
        public boolean trySetStarted() {
            return compareAndSet(RunningState.NOT_RUN, RunningState.STARTED);
        }

        /* INFO: Access modifiers changed from: private */
        public boolean trySetCancelled() {
            return compareAndSet(RunningState.NOT_RUN, RunningState.CANCELLED);
        }
    }
}
