package com.magneticchen.daijishou.dialog_fragments;

import android.view.View;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class LoggerDialogFragment$$ExternalSyntheticLambda2 implements View.OnClickListener {
    public final /* synthetic */ LoggerDialogFragment f$0;

    public /* synthetic */ LoggerDialogFragment$$ExternalSyntheticLambda2(LoggerDialogFragment loggerDialogFragment) {
        this.f$0 = loggerDialogFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            LoggerDialogFragment.onCreateView$lambda$9(this.f$0, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
