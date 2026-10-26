package com.magneticchen.daijishou.activities;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class BootstrapActivity$$ExternalSyntheticLambda0 implements ActivityResultCallback {
    public final /* synthetic */ BootstrapActivity f$0;

    public /* synthetic */ BootstrapActivity$$ExternalSyntheticLambda0(BootstrapActivity bootstrapActivity) {
        this.f$0 = bootstrapActivity;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public final void onActivityResult(Object obj) {
        try {
            BootstrapActivity.startForResult$lambda$0(this.f$0, (ActivityResult) obj);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
