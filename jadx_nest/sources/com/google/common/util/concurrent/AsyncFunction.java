package com.google.common.util.concurrent;

/* INFO: loaded from: classes4.dex */
@ElementTypesAreNonnullByDefault
public interface AsyncFunction<I, O> {
    ListenableFuture<O> apply(@ParametricNullness I input) throws Exception;
}
