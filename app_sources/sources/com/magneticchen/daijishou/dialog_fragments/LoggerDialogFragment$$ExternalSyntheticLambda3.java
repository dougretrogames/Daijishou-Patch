package com.magneticchen.daijishou.dialog_fragments;

import android.view.View;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class LoggerDialogFragment$$ExternalSyntheticLambda3 implements View.OnClickListener {
    public final /* synthetic */ LoggerDialogFragment f$0;

    public /* synthetic */ LoggerDialogFragment$$ExternalSyntheticLambda3(LoggerDialogFragment loggerDialogFragment) {
        this.f$0 = loggerDialogFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            LoggerDialogFragment.onCreateView$lambda$10(this.f$0, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
