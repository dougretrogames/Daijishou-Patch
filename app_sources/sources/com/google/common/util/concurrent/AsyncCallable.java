package com.google.common.util.concurrent;

/* INFO: loaded from: classes4.dex */
@ElementTypesAreNonnullByDefault
public interface AsyncCallable<V> {
    ListenableFuture<V> call() throws Exception;
}
