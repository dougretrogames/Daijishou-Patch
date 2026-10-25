package com.magneticchen.daijishou.dialog_fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.EditText;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class EditIndexUriDialogFragment$$ExternalSyntheticLambda5 implements DialogInterface.OnShowListener {
    public final /* synthetic */ AlertDialog f$0;
    public final /* synthetic */ EditText f$1;
    public final /* synthetic */ EditIndexUriDialogFragment f$2;

    public /* synthetic */ EditIndexUriDialogFragment$$ExternalSyntheticLambda5(AlertDialog alertDialog, EditText editText, EditIndexUriDialogFragment editIndexUriDialogFragment) {
        this.f$0 = alertDialog;
        this.f$1 = editText;
        this.f$2 = editIndexUriDialogFragment;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        try {
            EditIndexUriDialogFragment.onCreateDialog$lambda$6$lambda$5(this.f$0, this.f$1, this.f$2, dialogInterface);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
