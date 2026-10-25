package com.google.android.gms.internal.auth;

import android.os.RemoteException;
import com.google.android.gms.auth.AccountChangeEventsRequest;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth-base@@18.0.10 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class zzu implements RemoteCall {
    public final /* synthetic */ zzab zza;
    public final /* synthetic */ AccountChangeEventsRequest zzb;

    public /* synthetic */ zzu(zzab zzabVar, AccountChangeEventsRequest accountChangeEventsRequest) {
        this.zza = zzabVar;
        this.zzb = accountChangeEventsRequest;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) throws RemoteException {
        zzab zzabVar = this.zza;
        AccountChangeEventsRequest accountChangeEventsRequest = this.zzb;
        ((zzp) ((zzi) obj).getService()).zze(new zzz(zzabVar, (TaskCompletionSource) obj2), accountChangeEventsRequest);
    }
}
