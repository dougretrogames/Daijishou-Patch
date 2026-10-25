package com.google.android.gms.fido.fido2;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.fido.fido2.api.common.BrowserPublicKeyCredentialCreationOptions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-fido@@20.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class zzo implements RemoteCall {
    public final /* synthetic */ Fido2PrivilegedApiClient zza;
    public final /* synthetic */ BrowserPublicKeyCredentialCreationOptions zzb;

    public /* synthetic */ zzo(Fido2PrivilegedApiClient fido2PrivilegedApiClient, BrowserPublicKeyCredentialCreationOptions browserPublicKeyCredentialCreationOptions) {
        this.zza = fido2PrivilegedApiClient;
        this.zzb = browserPublicKeyCredentialCreationOptions;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) throws RemoteException {
        Fido2PrivilegedApiClient fido2PrivilegedApiClient = this.zza;
        BrowserPublicKeyCredentialCreationOptions browserPublicKeyCredentialCreationOptions = this.zzb;
        ((com.google.android.gms.internal.fido.zzn) ((com.google.android.gms.internal.fido.zzk) obj).getService()).zzd(new zzs(fido2PrivilegedApiClient, (TaskCompletionSource) obj2), browserPublicKeyCredentialCreationOptions);
    }
}
