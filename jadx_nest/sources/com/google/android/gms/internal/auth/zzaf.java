package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Status;

/* INFO: compiled from: com.google.android.gms:play-services-auth-base@@18.0.10 */
/* INFO: loaded from: classes3.dex */
final class zzaf extends zzah {
    final /* synthetic */ zzag zza;

    zzaf(zzag zzagVar) {
        this.zza = zzagVar;
    }

    @Override // com.google.android.gms.internal.auth.zzah, com.google.android.gms.auth.account.zzb
    public final void zzc(boolean z) {
        this.zza.setResult(new zzak(z ? Status.RESULT_SUCCESS : zzal.zza));
    }
}
