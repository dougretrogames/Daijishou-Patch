package com.google.android.gms.internal.auth;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* INFO: compiled from: com.google.android.gms:play-services-auth-base@@18.0.10 */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class zzq implements RemoteCall {
    public final /* synthetic */ zzab zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzq(zzab zzabVar, String str) {
        this.zza = zzabVar;
        this.zzb = str;
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) throws RemoteException {
        zzab zzabVar = this.zza;
        ((zzp) ((zzi) obj).getService()).zzh(new zzy(zzabVar, (TaskCompletionSource) obj2), this.zzb);
    }
}
