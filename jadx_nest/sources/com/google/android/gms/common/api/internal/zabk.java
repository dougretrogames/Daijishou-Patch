package com.google.android.gms.common.api.internal;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class zabk implements Executor {
    public final /* synthetic */ Handler zaa;

    public /* synthetic */ zabk(Handler handler) {
        this.zaa = handler;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.zaa.post(runnable);
    }
}
