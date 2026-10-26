package com.google.android.gms.fido.fido2;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* INFO: compiled from: com.google.android.gms:play-services-fido@@20.0.1 */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class zzk implements RemoteCall {
    public final /* synthetic */ Fido2PrivilegedApiClient zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzk(Fido2PrivilegedApiClient fido2PrivilegedApiClient, String str) {
        this.zza = fido2PrivilegedApiClient;
        this.zzb = str;
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) throws RemoteException {
        Fido2PrivilegedApiClient fido2PrivilegedApiClient = this.zza;
        String str = this.zzb;
        ((com.google.android.gms.internal.fido.zzn) ((com.google.android.gms.internal.fido.zzk) obj).getService()).zzc(new zzv(fido2PrivilegedApiClient, (TaskCompletionSource) obj2), str);
    }
}
