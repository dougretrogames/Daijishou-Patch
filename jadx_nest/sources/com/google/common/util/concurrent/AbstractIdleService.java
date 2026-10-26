package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.commons.collections4.CollectionUtils;

/* INFO: loaded from: classes4.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractIdleService implements Service {
    private final Supplier<String> threadNameSupplier = new ThreadNameSupplier(this, null);
    private final Service delegate = new DelegateService(this, null);

    protected abstract void shutDown() throws Exception;

    protected abstract void startUp() throws Exception;

    private final class ThreadNameSupplier implements Supplier<String> {
        private ThreadNameSupplier() {
        }

        /* synthetic */ ThreadNameSupplier(AbstractIdleService abstractIdleService, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.common.base.Supplier
        public String get() {
            return AbstractIdleService.this.serviceName() + " " + AbstractIdleService.this.state();
        }
    }

    /* INFO: Access modifiers changed from: private */
    final class DelegateService extends AbstractService {
        private DelegateService() {
        }

        /* synthetic */ DelegateService(AbstractIdleService abstractIdleService, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.common.util.concurrent.AbstractService
        protected final void doStart() {
            MoreExecutors.renamingDecorator(AbstractIdleService.this.executor(), (Supplier<String>) AbstractIdleService.this.threadNameSupplier).execute(new AbstractIdleService$DelegateService$$ExternalSyntheticLambda1(this));
        }

        /* INFO: renamed from: lambda$doStart$0$com-google-common-util-concurrent-AbstractIdleService$DelegateService, reason: not valid java name */
        /* synthetic */ void m3368x2ed323e8() {
            try {
                AbstractIdleService.this.startUp();
                notifyStarted();
            } catch (Throwable th) {
                Platform.restoreInterruptIfIsInterruptedException(th);
                notifyFailed(th);
            }
        }

        @Override // com.google.common.util.concurrent.AbstractService
        protected final void doStop() {
            MoreExecutors.renamingDecorator(AbstractIdleService.this.executor(), (Supplier<String>) AbstractIdleService.this.threadNameSupplier).execute(new AbstractIdleService$DelegateService$$ExternalSyntheticLambda0(this));
        }

        /* INFO: renamed from: lambda$doStop$1$com-google-common-util-concurrent-AbstractIdleService$DelegateService, reason: not valid java name */
        /* synthetic */ void m3369xb13e6319() {
            try {
                AbstractIdleService.this.shutDown();
                notifyStopped();
            } catch (Throwable th) {
                Platform.restoreInterruptIfIsInterruptedException(th);
                notifyFailed(th);
            }
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public String toString() {
            return AbstractIdleService.this.toString();
        }
    }

    protected AbstractIdleService() {
    }

    protected Executor executor() {
        return new AbstractIdleService$$ExternalSyntheticLambda0(this);
    }

    /* INFO: renamed from: lambda$executor$0$com-google-common-util-concurrent-AbstractIdleService, reason: not valid java name */
    /* synthetic */ void m3367xc998c392(Runnable runnable) {
        MoreExecutors.newThread(this.threadNameSupplier.get(), runnable).start();
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

    protected String serviceName() {
        return getClass().getSimpleName();
    }
}
