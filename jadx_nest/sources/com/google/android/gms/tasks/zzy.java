package com.google.android.gms.tasks;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@18.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class zzy implements OnCompleteListener {
    public final /* synthetic */ com.google.android.gms.internal.tasks.zza zza;
    public final /* synthetic */ TaskCompletionSource zzb;
    public final /* synthetic */ zzb zzc;

    public /* synthetic */ zzy(com.google.android.gms.internal.tasks.zza zzaVar, TaskCompletionSource taskCompletionSource, zzb zzbVar) {
        this.zza = zzaVar;
        this.zzb = taskCompletionSource;
        this.zzc = zzbVar;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        this.zza.removeCallbacksAndMessages(null);
        TaskCompletionSource taskCompletionSource = this.zzb;
        if (task.isSuccessful()) {
            taskCompletionSource.trySetResult(task.getResult());
        } else {
            if (task.isCanceled()) {
                this.zzc.zza();
                return;
            }
            Exception exception = task.getException();
            exception.getClass();
            taskCompletionSource.trySetException(exception);
        }
    }
}
