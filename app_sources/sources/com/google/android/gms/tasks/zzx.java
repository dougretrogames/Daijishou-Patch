package com.google.android.gms.tasks;

import java.util.concurrent.TimeoutException;

/* INFO: compiled from: com.google.android.gms:play-services-tasks@@18.1.0 */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class zzx implements Runnable {
    public final /* synthetic */ TaskCompletionSource zza;

    public /* synthetic */ zzx(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.trySetException(new TimeoutException());
    }
}
