package com.google.android.gms.common.moduleinstall.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class zal implements RemoteCall {
    public final /* synthetic */ zay zaa;
    public final /* synthetic */ ApiFeatureRequest zab;

    public /* synthetic */ zal(zay zayVar, ApiFeatureRequest apiFeatureRequest) {
        this.zaa = zayVar;
        this.zab = apiFeatureRequest;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) throws RemoteException {
        ((zaf) ((zaz) obj).getService()).zae(new zar(this.zaa, (TaskCompletionSource) obj2), this.zab);
    }
}
