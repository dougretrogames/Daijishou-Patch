package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Result;

/* INFO: compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* INFO: loaded from: classes3.dex */
public abstract class OptionalPendingResult<R extends Result> extends PendingResult<R> {
    public abstract R get();

    public abstract boolean isDone();
}
