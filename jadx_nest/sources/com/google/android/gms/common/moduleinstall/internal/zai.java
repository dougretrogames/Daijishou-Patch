package com.google.android.gms.common.moduleinstall.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.moduleinstall.InstallStatusListener;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class zai implements RemoteCall {
    public final /* synthetic */ zay zaa;
    public final /* synthetic */ AtomicReference zab;
    public final /* synthetic */ InstallStatusListener zac;
    public final /* synthetic */ ApiFeatureRequest zad;
    public final /* synthetic */ zaab zae;

    public /* synthetic */ zai(zay zayVar, AtomicReference atomicReference, InstallStatusListener installStatusListener, ApiFeatureRequest apiFeatureRequest, zaab zaabVar) {
        this.zaa = zayVar;
        this.zab = atomicReference;
        this.zac = installStatusListener;
        this.zad = apiFeatureRequest;
        this.zae = zaabVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) throws RemoteException {
        ((zaf) ((zaz) obj).getService()).zag(new zau(this.zaa, this.zab, (TaskCompletionSource) obj2, this.zac), this.zad, this.zae);
    }
}
