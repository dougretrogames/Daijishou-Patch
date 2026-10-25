package com.magneticchen.daijishou.dialog_fragments;

import android.app.AlertDialog;
import android.view.View;
import android.widget.EditText;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class EditIndexUriDialogFragment$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ EditText f$0;
    public final /* synthetic */ EditIndexUriDialogFragment f$1;
    public final /* synthetic */ AlertDialog f$2;

    public /* synthetic */ EditIndexUriDialogFragment$$ExternalSyntheticLambda0(EditText editText, EditIndexUriDialogFragment editIndexUriDialogFragment, AlertDialog alertDialog) {
        this.f$0 = editText;
        this.f$1 = editIndexUriDialogFragment;
        this.f$2 = alertDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            EditIndexUriDialogFragment.onCreateDialog$lambda$6$lambda$5$lambda$3(this.f$0, this.f$1, this.f$2, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
