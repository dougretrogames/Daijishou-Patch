package com.google.android.gms.internal.auth;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth-base@@18.0.10 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class zzbk implements RemoteCall {
    public final /* synthetic */ zzbo zza;

    public /* synthetic */ zzbk(zzbo zzboVar) {
        this.zza = zzboVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) throws RemoteException {
        ((zzbh) ((zzbe) obj).getService()).zzd(new zzbn(this.zza, (TaskCompletionSource) obj2));
    }
}
