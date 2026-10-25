package com.magneticchen.daijishou.dialog_fragments;

import android.view.View;
import com.google.android.material.textfield.TextInputEditText;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class LoggerDialogFragment$$ExternalSyntheticLambda5 implements View.OnClickListener {
    public final /* synthetic */ TextInputEditText f$0;

    public /* synthetic */ LoggerDialogFragment$$ExternalSyntheticLambda5(TextInputEditText textInputEditText) {
        this.f$0 = textInputEditText;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            LoggerDialogFragment.onCreateView$lambda$12(this.f$0, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
