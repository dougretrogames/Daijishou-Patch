package com.magneticchen.daijishou.dialog_fragments;

import android.content.DialogInterface;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class AcknowledgementDialogFragment$$ExternalSyntheticLambda0 implements DialogInterface.OnCancelListener {
    public final /* synthetic */ AcknowledgementDialogFragment f$0;

    public /* synthetic */ AcknowledgementDialogFragment$$ExternalSyntheticLambda0(AcknowledgementDialogFragment acknowledgementDialogFragment) {
        this.f$0 = acknowledgementDialogFragment;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        try {
            AcknowledgementDialogFragment.onCreateDialog$lambda$14$lambda$2(this.f$0, dialogInterface);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
