package com.google.android.gms.fido.fido2;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.fido.fido2.api.common.BrowserPublicKeyCredentialRequestOptions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-fido@@20.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class zzn implements RemoteCall {
    public final /* synthetic */ Fido2PrivilegedApiClient zza;
    public final /* synthetic */ BrowserPublicKeyCredentialRequestOptions zzb;

    public /* synthetic */ zzn(Fido2PrivilegedApiClient fido2PrivilegedApiClient, BrowserPublicKeyCredentialRequestOptions browserPublicKeyCredentialRequestOptions) {
        this.zza = fido2PrivilegedApiClient;
        this.zzb = browserPublicKeyCredentialRequestOptions;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) throws RemoteException {
        Fido2PrivilegedApiClient fido2PrivilegedApiClient = this.zza;
        BrowserPublicKeyCredentialRequestOptions browserPublicKeyCredentialRequestOptions = this.zzb;
        ((com.google.android.gms.internal.fido.zzn) ((com.google.android.gms.internal.fido.zzk) obj).getService()).zze(new zzt(fido2PrivilegedApiClient, (TaskCompletionSource) obj2), browserPublicKeyCredentialRequestOptions);
    }
}
