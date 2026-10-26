package com.google.android.gms.fido.fido2;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* INFO: compiled from: com.google.android.gms:play-services-fido@@20.0.1 */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class zzp implements RemoteCall {
    public final /* synthetic */ Fido2PrivilegedApiClient zza;

    public /* synthetic */ zzp(Fido2PrivilegedApiClient fido2PrivilegedApiClient) {
        this.zza = fido2PrivilegedApiClient;
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) throws RemoteException {
        ((com.google.android.gms.internal.fido.zzn) ((com.google.android.gms.internal.fido.zzk) obj).getService()).zzf(new zzu(this.zza, (TaskCompletionSource) obj2));
    }
}
