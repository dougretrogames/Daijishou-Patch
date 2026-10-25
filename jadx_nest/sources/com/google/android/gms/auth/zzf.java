package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth-base@@18.0.10 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class zzf implements zzk {
    public final /* synthetic */ Account zza;

    public /* synthetic */ zzf(Account account) {
        this.zza = account;
    }

    @Override // com.google.android.gms.auth.zzk
    public final Object zza(IBinder iBinder) throws RemoteException, IOException {
        Bundle bundleZzf = com.google.android.gms.internal.auth.zze.zzb(iBinder).zzf(this.zza);
        if (bundleZzf != null) {
            return bundleZzf;
        }
        throw new IOException("Service call returned null.");
    }
}
