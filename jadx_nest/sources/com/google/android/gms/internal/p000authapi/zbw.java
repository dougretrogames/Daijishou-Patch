package com.google.android.gms.internal.p000authapi;

import android.os.RemoteException;
import com.google.android.gms.auth.api.identity.AuthorizationRequest;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* INFO: compiled from: com.google.android.gms:play-services-auth@@21.3.0 */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class zbw implements RemoteCall {
    public final /* synthetic */ zbz zba;
    public final /* synthetic */ AuthorizationRequest zbb;

    public /* synthetic */ zbw(zbz zbzVar, AuthorizationRequest authorizationRequest) {
        this.zba = zbzVar;
        this.zbb = authorizationRequest;
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) throws RemoteException {
        ((zbj) ((zbf) obj).getService()).zbc(new zby(this.zba, (TaskCompletionSource) obj2), (AuthorizationRequest) Preconditions.checkNotNull(this.zbb));
    }
}
