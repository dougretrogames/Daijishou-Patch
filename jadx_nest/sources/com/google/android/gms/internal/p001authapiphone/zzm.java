package com.google.android.gms.internal.p001authapiphone;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth-api-phone@@18.0.2 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class zzm implements RemoteCall {
    public final /* synthetic */ zzr zza;

    public /* synthetic */ zzm(zzr zzrVar) {
        this.zza = zzrVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) throws RemoteException {
        ((zzh) ((zzw) obj).getService()).zze(new zzo(this.zza, (TaskCompletionSource) obj2));
    }
}
