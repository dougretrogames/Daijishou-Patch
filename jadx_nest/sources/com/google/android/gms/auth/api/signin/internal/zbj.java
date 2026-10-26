package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* INFO: compiled from: com.google.android.gms:play-services-auth@@21.3.0 */
/* INFO: loaded from: classes3.dex */
final class zbj extends zba {
    final /* synthetic */ zbk zba;

    zbj(zbk zbkVar) {
        this.zba = zbkVar;
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zba, com.google.android.gms.auth.api.signin.internal.zbr
    public final void zbb(Status status) throws RemoteException {
        this.zba.setResult(status);
    }
}
