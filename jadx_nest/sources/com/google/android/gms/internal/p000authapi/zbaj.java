package com.google.android.gms.internal.p000authapi;

import android.os.RemoteException;
import com.google.android.gms.auth.api.identity.GetSignInIntentRequest;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* INFO: compiled from: com.google.android.gms:play-services-auth@@21.3.0 */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class zbaj implements RemoteCall {
    public final /* synthetic */ zbap zba;
    public final /* synthetic */ GetSignInIntentRequest zbb;

    public /* synthetic */ zbaj(zbap zbapVar, GetSignInIntentRequest getSignInIntentRequest) {
        this.zba = zbapVar;
        this.zbb = getSignInIntentRequest;
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) throws RemoteException {
        ((zbv) ((zbaq) obj).getService()).zbe(new zban(this.zba, (TaskCompletionSource) obj2), (GetSignInIntentRequest) Preconditions.checkNotNull(this.zbb));
    }
}
