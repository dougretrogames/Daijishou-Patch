package com.google.android.gms.internal.p000authapi;

import android.os.RemoteException;
import com.google.android.gms.auth.api.identity.GetPhoneNumberHintIntentRequest;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@21.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class zbag implements RemoteCall {
    public final /* synthetic */ zbap zba;
    public final /* synthetic */ GetPhoneNumberHintIntentRequest zbb;

    public /* synthetic */ zbag(zbap zbapVar, GetPhoneNumberHintIntentRequest getPhoneNumberHintIntentRequest) {
        this.zba = zbapVar;
        this.zbb = getPhoneNumberHintIntentRequest;
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) throws RemoteException {
        this.zba.zba(this.zbb, (zbaq) obj, (TaskCompletionSource) obj2);
    }
}
