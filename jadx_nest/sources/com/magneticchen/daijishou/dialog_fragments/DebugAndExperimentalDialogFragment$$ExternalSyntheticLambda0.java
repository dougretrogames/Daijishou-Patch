package com.magneticchen.daijishou.dialog_fragments;

import androidx.activity.result.ActivityResultCallback;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class DebugAndExperimentalDialogFragment$$ExternalSyntheticLambda0 implements ActivityResultCallback {
    public final /* synthetic */ DebugAndExperimentalDialogFragment f$0;

    public /* synthetic */ DebugAndExperimentalDialogFragment$$ExternalSyntheticLambda0(DebugAndExperimentalDialogFragment debugAndExperimentalDialogFragment) {
        this.f$0 = debugAndExperimentalDialogFragment;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public final void onActivityResult(Object obj) {
        try {
            DebugAndExperimentalDialogFragment.requestPermissionAndStartDebugService$lambda$0(this.f$0, ((Boolean) obj).booleanValue());
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
