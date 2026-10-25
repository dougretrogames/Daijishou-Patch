package com.google.android.gms.internal.auth;

import android.accounts.Account;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth-base@@18.0.10 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class zzr implements RemoteCall {
    public final /* synthetic */ zzab zza;
    public final /* synthetic */ Account zzb;

    public /* synthetic */ zzr(zzab zzabVar, Account account) {
        this.zza = zzabVar;
        this.zzb = account;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) throws RemoteException {
        zzab zzabVar = this.zza;
        ((zzp) ((zzi) obj).getService()).zzg(new zzaa(zzabVar, (TaskCompletionSource) obj2), this.zzb);
    }
}
