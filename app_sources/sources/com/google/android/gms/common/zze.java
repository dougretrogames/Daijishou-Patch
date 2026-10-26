package com.google.android.gms.common;

import java.util.concurrent.Callable;

/* INFO: compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class zze implements Callable {
    public final /* synthetic */ boolean zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzj zzc;

    public /* synthetic */ zze(boolean z, String str, zzj zzjVar) {
        this.zza = z;
        this.zzb = str;
        this.zzc = zzjVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return zzn.zzd(this.zza, this.zzb, this.zzc);
    }
}
