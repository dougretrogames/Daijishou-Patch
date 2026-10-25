package com.magneticchen.daijishou.dialog_fragments;

import android.content.DialogInterface;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class KeyDownDialogFragment$$ExternalSyntheticLambda1 implements DialogInterface.OnClickListener {
    public final /* synthetic */ KeyDownDialogFragment f$0;

    public /* synthetic */ KeyDownDialogFragment$$ExternalSyntheticLambda1(KeyDownDialogFragment keyDownDialogFragment) {
        this.f$0 = keyDownDialogFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        try {
            KeyDownDialogFragment.onCreateDialog$lambda$6$lambda$3(this.f$0, dialogInterface, i);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
