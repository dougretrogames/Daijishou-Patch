package com.magneticchen.daijishou.dialog_fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class AcknowledgementDialogFragment$$ExternalSyntheticLambda6 implements DialogInterface.OnShowListener {
    public final /* synthetic */ String f$0;
    public final /* synthetic */ AcknowledgementDialogFragment f$1;
    public final /* synthetic */ AlertDialog f$2;

    public /* synthetic */ AcknowledgementDialogFragment$$ExternalSyntheticLambda6(String str, AcknowledgementDialogFragment acknowledgementDialogFragment, AlertDialog alertDialog) {
        this.f$0 = str;
        this.f$1 = acknowledgementDialogFragment;
        this.f$2 = alertDialog;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        try {
            AcknowledgementDialogFragment.onCreateDialog$lambda$14$lambda$13(this.f$0, this.f$1, this.f$2, dialogInterface);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
