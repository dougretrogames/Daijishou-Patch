package com.google.android.gms.fido.fido2;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialRequestOptions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-fido@@20.0.1 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class zza implements RemoteCall {
    public final /* synthetic */ Fido2ApiClient zza;
    public final /* synthetic */ PublicKeyCredentialRequestOptions zzb;

    public /* synthetic */ zza(Fido2ApiClient fido2ApiClient, PublicKeyCredentialRequestOptions publicKeyCredentialRequestOptions) {
        this.zza = fido2ApiClient;
        this.zzb = publicKeyCredentialRequestOptions;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) throws RemoteException {
        Fido2ApiClient fido2ApiClient = this.zza;
        PublicKeyCredentialRequestOptions publicKeyCredentialRequestOptions = this.zzb;
        ((com.google.android.gms.internal.fido.zzs) ((com.google.android.gms.internal.fido.zzp) obj).getService()).zzd(new zzi(fido2ApiClient, (TaskCompletionSource) obj2), publicKeyCredentialRequestOptions);
    }
}
