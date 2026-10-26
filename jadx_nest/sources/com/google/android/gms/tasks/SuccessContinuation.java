package com.google.android.gms.tasks;

/* INFO: compiled from: com.google.android.gms:play-services-tasks@@18.1.0 */
/* INFO: loaded from: classes3.dex */
public interface SuccessContinuation<TResult, TContinuationResult> {
    Task<TContinuationResult> then(TResult tresult) throws Exception;
}
