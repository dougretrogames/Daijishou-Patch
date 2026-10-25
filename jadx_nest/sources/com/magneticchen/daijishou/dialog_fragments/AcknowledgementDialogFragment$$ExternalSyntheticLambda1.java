package com.magneticchen.daijishou.dialog_fragments;

import android.content.DialogInterface;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class AcknowledgementDialogFragment$$ExternalSyntheticLambda1 implements DialogInterface.OnClickListener {
    public final /* synthetic */ AcknowledgementDialogFragment f$0;

    public /* synthetic */ AcknowledgementDialogFragment$$ExternalSyntheticLambda1(AcknowledgementDialogFragment acknowledgementDialogFragment) {
        this.f$0 = acknowledgementDialogFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        try {
            AcknowledgementDialogFragment.onCreateDialog$lambda$14$lambda$4(this.f$0, dialogInterface, i);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
