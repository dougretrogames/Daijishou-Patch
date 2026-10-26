package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.util.concurrent.Callable;

/* INFO: loaded from: classes4.dex */
@ElementTypesAreNonnullByDefault
public final class Callables {
    static /* synthetic */ Object lambda$returning$0(Object obj) throws Exception {
        return obj;
    }

    private Callables() {
    }

    public static <T> Callable<T> returning(@ParametricNullness T value) {
        return new Callables$$ExternalSyntheticLambda2(value);
    }

    public static <T> AsyncCallable<T> asAsyncCallable(Callable<T> callable, ListeningExecutorService listeningExecutorService) {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull(listeningExecutorService);
        return new Callables$$ExternalSyntheticLambda1(listeningExecutorService, callable);
    }

    static <T> Callable<T> threadRenaming(Callable<T> callable, Supplier<String> nameSupplier) {
        Preconditions.checkNotNull(nameSupplier);
        Preconditions.checkNotNull(callable);
        return new Callables$$ExternalSyntheticLambda0(nameSupplier, callable);
    }

    static /* synthetic */ Object lambda$threadRenaming$2(Supplier supplier, Callable callable) throws Exception {
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        boolean zTrySetName = trySetName((String) supplier.get(), threadCurrentThread);
        try {
            return callable.call();
        } finally {
            if (zTrySetName) {
                trySetName(name, threadCurrentThread);
            }
        }
    }

    static Runnable threadRenaming(Runnable task, Supplier<String> nameSupplier) {
        Preconditions.checkNotNull(nameSupplier);
        Preconditions.checkNotNull(task);
        return new Callables$$ExternalSyntheticLambda3(nameSupplier, task);
    }

    static /* synthetic */ void lambda$threadRenaming$3(Supplier supplier, Runnable runnable) {
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        boolean zTrySetName = trySetName((String) supplier.get(), threadCurrentThread);
        try {
            runnable.run();
        } finally {
            if (zTrySetName) {
                trySetName(name, threadCurrentThread);
            }
        }
    }

    private static boolean trySetName(String threadName, Thread currentThread) {
        try {
            currentThread.setName(threadName);
            return true;
        } catch (SecurityException unused) {
            return false;
        }
    }
}
