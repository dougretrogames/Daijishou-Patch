package com.google.android.gms.internal.p000authapi;

import android.os.RemoteException;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@21.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class zbai implements RemoteCall {
    public final /* synthetic */ zbap zba;
    public final /* synthetic */ BeginSignInRequest zbb;

    public /* synthetic */ zbai(zbap zbapVar, BeginSignInRequest beginSignInRequest) {
        this.zba = zbapVar;
        this.zbb = beginSignInRequest;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) throws RemoteException {
        ((zbv) ((zbaq) obj).getService()).zbc(new zbal(this.zba, (TaskCompletionSource) obj2), (BeginSignInRequest) Preconditions.checkNotNull(this.zbb));
    }
}
