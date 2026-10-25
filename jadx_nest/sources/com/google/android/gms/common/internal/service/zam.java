package com.google.android.gms.common.internal.service;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class zam implements RemoteCall {
    public final /* synthetic */ TelemetryData zaa;

    public /* synthetic */ zam(TelemetryData telemetryData) {
        this.zaa = telemetryData;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) throws RemoteException {
        int i = zao.zab;
        ((zai) ((zap) obj).getService()).zae(this.zaa);
        ((TaskCompletionSource) obj2).setResult(null);
    }
}
