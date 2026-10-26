package com.magneticchen.daijishou.dialog_fragments;

import android.view.View;
import kotlin.Lazy;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class DebugAndExperimentalDialogFragment$$ExternalSyntheticLambda8 implements View.OnClickListener {
    public final /* synthetic */ DebugAndExperimentalDialogFragment f$0;
    public final /* synthetic */ Lazy f$1;

    public /* synthetic */ DebugAndExperimentalDialogFragment$$ExternalSyntheticLambda8(DebugAndExperimentalDialogFragment debugAndExperimentalDialogFragment, Lazy lazy) {
        this.f$0 = debugAndExperimentalDialogFragment;
        this.f$1 = lazy;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            DebugAndExperimentalDialogFragment.onCreateDialog$lambda$8(this.f$0, this.f$1, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
