package com.google.android.gms.common.moduleinstall.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class zak implements SuccessContinuation {
    public final /* synthetic */ AtomicReference zaa;

    public /* synthetic */ zak(AtomicReference atomicReference) {
        this.zaa = atomicReference;
    }

    @Override // com.google.android.gms.tasks.SuccessContinuation
    public final Task then(Object obj) {
        int i = zay.zab;
        AtomicReference atomicReference = this.zaa;
        return atomicReference.get() != null ? Tasks.forResult((ModuleInstallResponse) atomicReference.get()) : Tasks.forException(new ApiException(Status.RESULT_INTERNAL_ERROR));
    }
}
