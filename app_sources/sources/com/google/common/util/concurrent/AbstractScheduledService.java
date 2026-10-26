package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import javax.annotation.CheckForNull;
import org.apache.commons.collections4.CollectionUtils;

/* INFO: loaded from: classes4.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractScheduledService implements Service {
    private static final LazyLogger logger = new LazyLogger(AbstractScheduledService.class);
    private final AbstractService delegate = new ServiceDelegate(this, null);

    interface Cancellable {
        void cancel(boolean mayInterruptIfRunning);

        boolean isCancelled();
    }

    protected abstract void runOneIteration() throws Exception;

    protected abstract Scheduler scheduler();

    protected void shutDown() throws Exception {
    }

    protected void startUp() throws Exception {
    }

    public static abstract class Scheduler {
        abstract Cancellable schedule(AbstractService service, ScheduledExecutorService executor, Runnable runnable);

        /* synthetic */ Scheduler(AnonymousClass1 anonymousClass1) {
            this();
        }

        public static Scheduler newFixedDelaySchedule(final long initialDelay, final long delay, final TimeUnit unit) {
            Preconditions.checkNotNull(unit);
            Preconditions.checkArgument(delay > 0, "delay must be > 0, found %s", delay);
            return new AnonymousClass1(initialDelay, delay, unit);
        }

        /* INFO: renamed from: com.google.common.util.concurrent.AbstractScheduledService$Scheduler$1, reason: invalid class name */
        class AnonymousClass1 extends Scheduler {
            final /* synthetic */ long val$delay;
            final /* synthetic */ long val$initialDelay;
            final /* synthetic */ TimeUnit val$unit;

            /* WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(final long val$initialDelay, final long val$delay, final TimeUnit val$unit) {
                super(null);
                this.val$initialDelay = val$initialDelay;
                this.val$delay = val$delay;
                this.val$unit = val$unit;
            }

            @Override // com.google.common.util.concurrent.AbstractScheduledService.Scheduler
            public Cancellable schedule(AbstractService service, ScheduledExecutorService executor, Runnable task) {
                return new FutureAsCancellable(executor.scheduleWithFixedDelay(task, this.val$initialDelay, this.val$delay, this.val$unit));
            }
        }

        public static Scheduler newFixedRateSchedule(final long initialDelay, final long period, final TimeUnit unit) {
            Preconditions.checkNotNull(unit);
            Preconditions.checkArgument(period > 0, "period must be > 0, found %s", period);
            return new AnonymousClass2(initialDelay, period, unit);
        }

        /* INFO: renamed from: com.google.common.util.concurrent.AbstractScheduledService$Scheduler$2, reason: invalid class name */
        class AnonymousClass2 extends Scheduler {
            final /* synthetic */ long val$initialDelay;
            final /* synthetic */ long val$period;
            final /* synthetic */ TimeUnit val$unit;

            /* WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(final long val$initialDelay, final long val$period, final TimeUnit val$unit) {
                super(null);
                this.val$initialDelay = val$initialDelay;
                this.val$period = val$period;
                this.val$unit = val$unit;
            }

            @Override // com.google.common.util.concurrent.AbstractScheduledService.Scheduler
            public Cancellable schedule(AbstractService service, ScheduledExecutorService executor, Runnable task) {
                return new FutureAsCancellable(executor.scheduleAtFixedRate(task, this.val$initialDelay, this.val$period, this.val$unit));
            }
        }

        private Scheduler() {
        }
    }

    /* INFO: Access modifiers changed from: private */
    final class ServiceDelegate extends AbstractService {

        @CheckForNull
        private volatile ScheduledExecutorService executorService;
        private final ReentrantLock lock;

        @CheckForNull
        private volatile Cancellable runningTask;
        private final Runnable task;

        private ServiceDelegate() {
            this.lock = new ReentrantLock();
            this.task = new Task();
        }

        /* synthetic */ ServiceDelegate(AbstractScheduledService abstractScheduledService, AnonymousClass1 anonymousClass1) {
            this();
        }

        class Task implements Runnable {
            Task() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ServiceDelegate.this.lock.lock();
                try {
                    if (!((Cancellable) Objects.requireNonNull(ServiceDelegate.this.runningTask)).isCancelled()) {
                        AbstractScheduledService.this.runOneIteration();
                    }
                } catch (Throwable th) {
                    try {
                        Platform.restoreInterruptIfIsInterruptedException(th);
                        try {
                            AbstractScheduledService.this.shutDown();
                        } catch (Exception e) {
                            Platform.restoreInterruptIfIsInterruptedException(e);
                            AbstractScheduledService.logger.get().log(Level.WARNING, "Error while attempting to shut down the service after failure.", (Throwable) e);
                        }
                        ServiceDelegate.this.notifyFailed(th);
                        ((Cancellable) Objects.requireNonNull(ServiceDelegate.this.runningTask)).cancel(false);
                    } catch (Throwable th2) {
                        ServiceDelegate.this.lock.unlock();
                        throw th2;
                    }
                }
                ServiceDelegate.this.lock.unlock();
            }
        }

        @Override // com.google.common.util.concurrent.AbstractService
        protected final void doStart() {
            this.executorService = MoreExecutors.renamingDecorator(AbstractScheduledService.this.executor(), (Supplier<String>) new AbstractScheduledService$ServiceDelegate$$ExternalSyntheticLambda0(this));
            this.executorService.execute(new AbstractScheduledService$ServiceDelegate$$ExternalSyntheticLambda1(this));
        }

        /* INFO: renamed from: lambda$doStart$0$com-google-common-util-concurrent-AbstractScheduledService$ServiceDelegate, reason: not valid java name */
        /* synthetic */ String m3370xcd8af3c3() {
            return AbstractScheduledService.this.serviceName() + " " + state();
        }

        /* INFO: renamed from: lambda$doStart$1$com-google-common-util-concurrent-AbstractScheduledService$ServiceDelegate, reason: not valid java name */
        /* synthetic */ void m3371xfa22122() {
            this.lock.lock();
            try {
                AbstractScheduledService.this.startUp();
                Objects.requireNonNull(this.executorService);
                this.runningTask = AbstractScheduledService.this.scheduler().schedule(AbstractScheduledService.this.delegate, this.executorService, this.task);
                notifyStarted();
            } catch (Throwable th) {
                try {
                    Platform.restoreInterruptIfIsInterruptedException(th);
                    notifyFailed(th);
                    if (this.runningTask != null) {
                        this.runningTask.cancel(false);
                    }
                } finally {
                    this.lock.unlock();
                }
            }
        }

        @Override // com.google.common.util.concurrent.AbstractService
        protected final void doStop() {
            Objects.requireNonNull(this.runningTask);
            Objects.requireNonNull(this.executorService);
            this.runningTask.cancel(false);
            this.executorService.execute(new AbstractScheduledService$ServiceDelegate$$ExternalSyntheticLambda2(this));
        }

        /* INFO: renamed from: lambda$doStop$2$com-google-common-util-concurrent-AbstractScheduledService$ServiceDelegate, reason: not valid java name */
        /* synthetic */ void m3372x2d03b891() {
            try {
                this.lock.lock();
                try {
                    if (state() == Service.State.STOPPING) {
                        AbstractScheduledService.this.shutDown();
                        this.lock.unlock();
                        notifyStopped();
                        return;
                    }
                    this.lock.unlock();
                } catch (Throwable th) {
                    this.lock.unlock();
                    throw th;
                }
            } catch (Throwable th2) {
                Platform.restoreInterruptIfIsInterruptedException(th2);
                notifyFailed(th2);
            }
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public String toString() {
            return AbstractScheduledService.this.toString();
        }
    }

    protected AbstractScheduledService() {
    }

    /* INFO: renamed from: com.google.common.util.concurrent.AbstractScheduledService$1ThreadFactoryImpl, reason: invalid class name */
    class C1ThreadFactoryImpl implements ThreadFactory {
        C1ThreadFactoryImpl() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return MoreExecutors.newThread(AbstractScheduledService.this.serviceName(), runnable);
        }
    }

    protected ScheduledExecutorService executor() {
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new C1ThreadFactoryImpl());
        addListener(new AnonymousClass1(this, scheduledExecutorServiceNewSingleThreadScheduledExecutor), MoreExecutors.directExecutor());
        return scheduledExecutorServiceNewSingleThreadScheduledExecutor;
    }

    /* INFO: renamed from: com.google.common.util.concurrent.AbstractScheduledService$1, reason: invalid class name */
    class AnonymousClass1 extends Service.Listener {
        final /* synthetic */ ScheduledExecutorService val$executor;

        AnonymousClass1(final AbstractScheduledService this$0, final ScheduledExecutorService val$executor) {
            this.val$executor = val$executor;
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void terminated(Service.State from) {
            this.val$executor.shutdown();
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void failed(Service.State from, Throwable failure) {
            this.val$executor.shutdown();
        }
    }

    protected String serviceName() {
        return getClass().getSimpleName();
    }

    public String toString() {
        return serviceName() + " [" + state() + CollectionUtils.DEFAULT_TOSTRING_SUFFIX;
    }

    @Override // com.google.common.util.concurrent.Service
    public final boolean isRunning() {
        return this.delegate.isRunning();
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State state() {
        return this.delegate.state();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void addListener(Service.Listener listener, Executor executor) {
        this.delegate.addListener(listener, executor);
    }

    @Override // com.google.common.util.concurrent.Service
    public final Throwable failureCause() {
        return this.delegate.failureCause();
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service startAsync() {
        this.delegate.startAsync();
        return this;
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service stopAsync() {
        this.delegate.stopAsync();
        return this;
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning() {
        this.delegate.awaitRunning();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitRunning(long timeout, TimeUnit unit) throws TimeoutException {
        this.delegate.awaitRunning(timeout, unit);
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated() {
        this.delegate.awaitTerminated();
    }

    @Override // com.google.common.util.concurrent.Service
    public final void awaitTerminated(long timeout, TimeUnit unit) throws TimeoutException {
        this.delegate.awaitTerminated(timeout, unit);
    }

    private static final class FutureAsCancellable implements Cancellable {
        private final Future<?> delegate;

        FutureAsCancellable(Future<?> delegate) {
            this.delegate = delegate;
        }

        @Override // com.google.common.util.concurrent.AbstractScheduledService.Cancellable
        public void cancel(boolean mayInterruptIfRunning) {
            this.delegate.cancel(mayInterruptIfRunning);
        }

        @Override // com.google.common.util.concurrent.AbstractScheduledService.Cancellable
        public boolean isCancelled() {
            return this.delegate.isCancelled();
        }
    }

    public static abstract class CustomScheduler extends Scheduler {
        protected abstract Schedule getNextSchedule() throws Exception;

        public CustomScheduler() {
            super(null);
        }

        private final class ReschedulableCallable implements Callable<Void> {

            @CheckForNull
            private SupplantableFuture cancellationDelegate;
            private final ScheduledExecutorService executor;
            private final ReentrantLock lock = new ReentrantLock();
            private final AbstractService service;
            private final Runnable wrappedRunnable;

            ReschedulableCallable(AbstractService service, ScheduledExecutorService executor, Runnable runnable) {
                this.wrappedRunnable = runnable;
                this.executor = executor;
                this.service = service;
            }

            @Override // java.util.concurrent.Callable
            @CheckForNull
            public Void call() throws Exception {
                this.wrappedRunnable.run();
                reschedule();
                return null;
            }

            public Cancellable reschedule() {
                Cancellable futureAsCancellable;
                try {
                    Schedule nextSchedule = CustomScheduler.this.getNextSchedule();
                    this.lock.lock();
                    try {
                        futureAsCancellable = initializeOrUpdateCancellationDelegate(nextSchedule);
                        this.lock.unlock();
                        th = null;
                    } catch (Throwable th) {
                        th = th;
                        try {
                            futureAsCancellable = new FutureAsCancellable(Futures.immediateCancelledFuture());
                            this.lock.unlock();
                        } catch (Throwable th2) {
                            this.lock.unlock();
                            throw th2;
                        }
                    }
                    if (th != null) {
                        this.service.notifyFailed(th);
                    }
                    return futureAsCancellable;
                } catch (Throwable th3) {
                    Platform.restoreInterruptIfIsInterruptedException(th3);
                    this.service.notifyFailed(th3);
                    return new FutureAsCancellable(Futures.immediateCancelledFuture());
                }
            }

            private Cancellable initializeOrUpdateCancellationDelegate(Schedule schedule) {
                SupplantableFuture supplantableFuture = this.cancellationDelegate;
                if (supplantableFuture == null) {
                    SupplantableFuture supplantableFuture2 = new SupplantableFuture(this.lock, submitToExecutor(schedule));
                    this.cancellationDelegate = supplantableFuture2;
                    return supplantableFuture2;
                }
                if (!supplantableFuture.currentFuture.isCancelled()) {
                    this.cancellationDelegate.currentFuture = submitToExecutor(schedule);
                }
                return this.cancellationDelegate;
            }

            private ScheduledFuture<Void> submitToExecutor(Schedule schedule) {
                return this.executor.schedule(this, schedule.delay, schedule.unit);
            }
        }

        private static final class SupplantableFuture implements Cancellable {
            private Future<Void> currentFuture;
            private final ReentrantLock lock;

            SupplantableFuture(ReentrantLock lock, Future<Void> currentFuture) {
                this.lock = lock;
                this.currentFuture = currentFuture;
            }

            @Override // com.google.common.util.concurrent.AbstractScheduledService.Cancellable
            public void cancel(boolean mayInterruptIfRunning) {
                this.lock.lock();
                try {
                    this.currentFuture.cancel(mayInterruptIfRunning);
                } finally {
                    this.lock.unlock();
                }
            }

            @Override // com.google.common.util.concurrent.AbstractScheduledService.Cancellable
            public boolean isCancelled() {
                this.lock.lock();
                try {
                    return this.currentFuture.isCancelled();
                } finally {
                    this.lock.unlock();
                }
            }
        }

        @Override // com.google.common.util.concurrent.AbstractScheduledService.Scheduler
        final Cancellable schedule(AbstractService service, ScheduledExecutorService executor, Runnable runnable) {
            return new ReschedulableCallable(service, executor, runnable).reschedule();
        }

        protected static final class Schedule {
            private final long delay;
            private final TimeUnit unit;

            public Schedule(long delay, TimeUnit unit) {
                this.delay = delay;
                this.unit = (TimeUnit) Preconditions.checkNotNull(unit);
            }
        }
    }
}
