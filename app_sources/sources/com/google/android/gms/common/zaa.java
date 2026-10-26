package com.google.android.gms.common;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

/* INFO: compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class zaa implements SuccessContinuation {
    public static final /* synthetic */ zaa zaa = new zaa();

    private /* synthetic */ zaa() {
    }

    @Override // com.google.android.gms.tasks.SuccessContinuation
    public final Task then(Object obj) {
        int i = GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        return Tasks.forResult(null);
    }
}
