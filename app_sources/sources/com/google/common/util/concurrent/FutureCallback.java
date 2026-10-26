package com.google.common.util.concurrent;

/* INFO: loaded from: classes4.dex */
@ElementTypesAreNonnullByDefault
public interface FutureCallback<V> {
    void onFailure(Throwable t);

    void onSuccess(@ParametricNullness V result);
}
