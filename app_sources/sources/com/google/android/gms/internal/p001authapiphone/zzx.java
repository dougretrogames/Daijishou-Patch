package com.google.android.gms.internal.p001authapiphone;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* INFO: compiled from: com.google.android.gms:play-services-auth-api-phone@@18.0.2 */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class zzx implements RemoteCall {
    public final /* synthetic */ zzab zza;

    public /* synthetic */ zzx(zzab zzabVar) {
        this.zza = zzabVar;
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) throws RemoteException {
        ((zzh) ((zzw) obj).getService()).zzg(new zzz(this.zza, (TaskCompletionSource) obj2));
    }
}
