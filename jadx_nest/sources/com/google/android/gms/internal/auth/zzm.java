package com.google.android.gms.internal.auth;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.AccountChangeEventsResponse;
import com.google.android.gms.common.api.Status;

/* INFO: compiled from: com.google.android.gms:play-services-auth-base@@18.0.10 */
/* INFO: loaded from: classes3.dex */
public interface zzm extends IInterface {
    void zzb(Status status, AccountChangeEventsResponse accountChangeEventsResponse) throws RemoteException;
}
