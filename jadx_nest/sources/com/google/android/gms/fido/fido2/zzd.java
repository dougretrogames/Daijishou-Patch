package com.google.android.gms.fido.fido2;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialCreationOptions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* INFO: compiled from: com.google.android.gms:play-services-fido@@20.0.1 */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class zzd implements RemoteCall {
    public final /* synthetic */ Fido2ApiClient zza;
    public final /* synthetic */ PublicKeyCredentialCreationOptions zzb;

    public /* synthetic */ zzd(Fido2ApiClient fido2ApiClient, PublicKeyCredentialCreationOptions publicKeyCredentialCreationOptions) {
        this.zza = fido2ApiClient;
        this.zzb = publicKeyCredentialCreationOptions;
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) throws RemoteException {
        Fido2ApiClient fido2ApiClient = this.zza;
        PublicKeyCredentialCreationOptions publicKeyCredentialCreationOptions = this.zzb;
        ((com.google.android.gms.internal.fido.zzs) ((com.google.android.gms.internal.fido.zzp) obj).getService()).zzc(new zzh(fido2ApiClient, (TaskCompletionSource) obj2), publicKeyCredentialCreationOptions);
    }
}
