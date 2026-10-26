package com.google.android.gms.common.moduleinstall.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* INFO: compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class zaj implements RemoteCall {
    public final /* synthetic */ zay zaa;
    public final /* synthetic */ zaab zab;

    public /* synthetic */ zaj(zay zayVar, zaab zaabVar) {
        this.zaa = zayVar;
        this.zab = zaabVar;
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) throws RemoteException {
        ((zaf) ((zaz) obj).getService()).zai(new zav(this.zaa, (TaskCompletionSource) obj2), this.zab);
    }
}
