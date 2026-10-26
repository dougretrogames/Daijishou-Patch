package com.google.android.gms.internal.auth;

import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* INFO: compiled from: com.google.android.gms:play-services-auth-base@@18.0.10 */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class zzbl implements RemoteCall {
    public final /* synthetic */ zzbo zza;
    public final /* synthetic */ ProxyRequest zzb;

    public /* synthetic */ zzbl(zzbo zzboVar, ProxyRequest proxyRequest) {
        this.zza = zzboVar;
        this.zzb = proxyRequest;
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) throws RemoteException {
        zzbo zzboVar = this.zza;
        ProxyRequest proxyRequest = this.zzb;
        ((zzbh) ((zzbe) obj).getService()).zze(new zzbm(zzboVar, (TaskCompletionSource) obj2), proxyRequest);
    }
}
