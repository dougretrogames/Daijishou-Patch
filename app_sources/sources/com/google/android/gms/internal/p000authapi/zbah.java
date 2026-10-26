package com.google.android.gms.internal.p000authapi;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* INFO: compiled from: com.google.android.gms:play-services-auth@@21.3.0 */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class zbah implements RemoteCall {
    public final /* synthetic */ zbap zba;

    public /* synthetic */ zbah(zbap zbapVar) {
        this.zba = zbapVar;
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) throws RemoteException {
        this.zba.zbb((zbaq) obj, (TaskCompletionSource) obj2);
    }
}
