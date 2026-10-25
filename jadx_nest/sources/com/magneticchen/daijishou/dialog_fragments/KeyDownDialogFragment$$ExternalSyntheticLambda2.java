package com.magneticchen.daijishou.dialog_fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class KeyDownDialogFragment$$ExternalSyntheticLambda2 implements DialogInterface.OnKeyListener {
    public final /* synthetic */ Ref.ObjectRef f$0;
    public final /* synthetic */ KeyDownDialogFragment f$1;
    public final /* synthetic */ AlertDialog f$2;

    public /* synthetic */ KeyDownDialogFragment$$ExternalSyntheticLambda2(Ref.ObjectRef objectRef, KeyDownDialogFragment keyDownDialogFragment, AlertDialog alertDialog) {
        this.f$0 = objectRef;
        this.f$1 = keyDownDialogFragment;
        this.f$2 = alertDialog;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        return KeyDownDialogFragment.onCreateDialog$lambda$6$lambda$5(this.f$0, this.f$1, this.f$2, dialogInterface, i, keyEvent);
    }
}
