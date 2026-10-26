package com.google.android.gms.internal.p000authapi;

import android.os.RemoteException;
import com.google.android.gms.auth.api.identity.SavePasswordRequest;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* INFO: compiled from: com.google.android.gms:play-services-auth@@21.3.0 */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class zbab implements RemoteCall {
    public final /* synthetic */ zbaf zba;
    public final /* synthetic */ SavePasswordRequest zbb;

    public /* synthetic */ zbab(zbaf zbafVar, SavePasswordRequest savePasswordRequest) {
        this.zba = zbafVar;
        this.zbb = savePasswordRequest;
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) throws RemoteException {
        ((zbm) ((zbg) obj).getService()).zbd(new zbae(this.zba, (TaskCompletionSource) obj2), (SavePasswordRequest) Preconditions.checkNotNull(this.zbb));
    }
}
