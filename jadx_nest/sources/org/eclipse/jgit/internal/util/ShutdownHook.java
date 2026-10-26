package org.eclipse.jgit.internal.util;

import java.text.MessageFormat;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.eclipse.jgit.internal.JGitText;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* INFO: loaded from: classes5.dex */
public enum ShutdownHook {
    INSTANCE;

    private static final Logger LOG = LoggerFactory.getLogger((Class<?>) ShutdownHook.class);
    private final Set<Listener> listeners = ConcurrentHashMap.newKeySet();
    private final AtomicBoolean shutdownInProgress = new AtomicBoolean();

    public interface Listener {
        void onShutdown();
    }

    /* INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static ShutdownHook[] valuesCustom() {
        ShutdownHook[] shutdownHookArrValuesCustom = values();
        int length = shutdownHookArrValuesCustom.length;
        ShutdownHook[] shutdownHookArr = new ShutdownHook[length];
        System.arraycopy(shutdownHookArrValuesCustom, 0, shutdownHookArr, 0, length);
        return shutdownHookArr;
    }

    ShutdownHook() {
        CleanupService.getInstance().register(new ShutdownHook$$ExternalSyntheticLambda1(this));
    }

    /* INFO: Access modifiers changed from: private */
    public void cleanup() {
        if (this.shutdownInProgress.getAndSet(true)) {
            return;
        }
        ExecutorService executorServiceNewWorkStealingPool = Executors.newWorkStealingPool();
        try {
            try {
                executorServiceNewWorkStealingPool.submit(new ShutdownHook$$ExternalSyntheticLambda2(this)).get(30L, TimeUnit.SECONDS);
                executorServiceNewWorkStealingPool.shutdownNow();
            } catch (Throwable th) {
                executorServiceNewWorkStealingPool.shutdownNow();
                throw th;
            }
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /* INFO: renamed from: lambda$1$org-eclipse-jgit-internal-util-ShutdownHook, reason: not valid java name */
    /* synthetic */ Object m5769lambda$1$orgeclipsejgitinternalutilShutdownHook() throws Exception {
        doCleanup();
        return null;
    }

    private void doCleanup() {
        this.listeners.parallelStream().forEach(new ShutdownHook$$ExternalSyntheticLambda0(this));
    }

    /* INFO: Access modifiers changed from: private */
    public void notify(Listener listener) {
        LOG.debug(JGitText.get().shutdownCleanup, listener);
        try {
            listener.onShutdown();
        } catch (RuntimeException e) {
            LOG.error(MessageFormat.format(JGitText.get().shutdownCleanupListenerFailed, listener), (Throwable) e);
        }
    }

    public boolean register(Listener listener) {
        if (this.shutdownInProgress.get()) {
            return this.listeners.contains(listener);
        }
        LOG.debug("register {} with shutdown hook", listener);
        this.listeners.add(listener);
        return true;
    }

    public boolean unregister(Listener listener) {
        if (this.shutdownInProgress.get()) {
            return !this.listeners.contains(listener);
        }
        LOG.debug("unregister {} from shutdown hook", listener);
        this.listeners.remove(listener);
        return true;
    }

    public boolean isShutdownInProgress() {
        return this.shutdownInProgress.get();
    }
}
