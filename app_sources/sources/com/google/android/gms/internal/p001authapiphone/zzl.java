package com.google.android.gms.internal.p001authapiphone;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* INFO: compiled from: com.google.android.gms:play-services-auth-api-phone@@18.0.2 */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class zzl implements RemoteCall {
    public final /* synthetic */ zzr zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzl(zzr zzrVar, String str) {
        this.zza = zzrVar;
        this.zzb = str;
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) throws RemoteException {
        ((zzh) ((zzw) obj).getService()).zzd(this.zzb, new zzq(this.zza, (TaskCompletionSource) obj2));
    }
}
