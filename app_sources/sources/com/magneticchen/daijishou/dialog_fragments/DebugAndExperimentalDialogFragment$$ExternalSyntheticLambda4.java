package com.magneticchen.daijishou.dialog_fragments;

import android.view.View;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class DebugAndExperimentalDialogFragment$$ExternalSyntheticLambda4 implements View.OnClickListener {
    public final /* synthetic */ DebugAndExperimentalDialogFragment f$0;

    public /* synthetic */ DebugAndExperimentalDialogFragment$$ExternalSyntheticLambda4(DebugAndExperimentalDialogFragment debugAndExperimentalDialogFragment) {
        this.f$0 = debugAndExperimentalDialogFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            DebugAndExperimentalDialogFragment.onCreateDialog$lambda$4(this.f$0, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
