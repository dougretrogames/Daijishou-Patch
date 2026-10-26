package com.google.android.gms.internal.auth;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* INFO: compiled from: com.google.android.gms:play-services-auth-base@@18.0.10 */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class zzt implements RemoteCall {
    public final /* synthetic */ zzab zza;
    public final /* synthetic */ zzbw zzb;

    public /* synthetic */ zzt(zzab zzabVar, zzbw zzbwVar) {
        this.zza = zzabVar;
        this.zzb = zzbwVar;
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) throws RemoteException {
        zzab zzabVar = this.zza;
        ((zzp) ((zzi) obj).getService()).zzd(new zzx(zzabVar, (TaskCompletionSource) obj2), this.zzb);
    }
}
