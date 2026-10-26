package com.magneticchen.daijishou.dialog_fragments;

import android.view.View;
import android.widget.EditText;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class EditIndexUriDialogFragment$$ExternalSyntheticLambda1 implements View.OnClickListener {
    public final /* synthetic */ EditText f$0;

    public /* synthetic */ EditIndexUriDialogFragment$$ExternalSyntheticLambda1(EditText editText) {
        this.f$0 = editText;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            EditIndexUriDialogFragment.onCreateDialog$lambda$6$lambda$5$lambda$4(this.f$0, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
