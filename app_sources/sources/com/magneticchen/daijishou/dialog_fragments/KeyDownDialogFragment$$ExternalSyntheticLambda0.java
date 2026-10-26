package com.magneticchen.daijishou.dialog_fragments;

import android.content.DialogInterface;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class KeyDownDialogFragment$$ExternalSyntheticLambda0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ KeyDownDialogFragment f$0;

    public /* synthetic */ KeyDownDialogFragment$$ExternalSyntheticLambda0(KeyDownDialogFragment keyDownDialogFragment) {
        this.f$0 = keyDownDialogFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        try {
            KeyDownDialogFragment.onCreateDialog$lambda$6$lambda$1(this.f$0, dialogInterface, i);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
