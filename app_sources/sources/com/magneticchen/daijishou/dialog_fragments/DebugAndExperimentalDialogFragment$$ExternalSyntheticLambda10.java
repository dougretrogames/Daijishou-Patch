package com.magneticchen.daijishou.dialog_fragments;

import android.view.View;
import com.google.android.material.switchmaterial.SwitchMaterial;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class DebugAndExperimentalDialogFragment$$ExternalSyntheticLambda10 implements View.OnClickListener {
    public final /* synthetic */ DebugAndExperimentalDialogFragment f$0;
    public final /* synthetic */ SwitchMaterial f$1;

    public /* synthetic */ DebugAndExperimentalDialogFragment$$ExternalSyntheticLambda10(DebugAndExperimentalDialogFragment debugAndExperimentalDialogFragment, SwitchMaterial switchMaterial) {
        this.f$0 = debugAndExperimentalDialogFragment;
        this.f$1 = switchMaterial;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            DebugAndExperimentalDialogFragment.onCreateDialog$lambda$10(this.f$0, this.f$1, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
