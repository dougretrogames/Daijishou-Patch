package com.magneticchen.daijishou.abstract_fragment_classes;

import android.content.DialogInterface;
import android.view.KeyEvent;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class DaijishouDialogFragment$$ExternalSyntheticLambda0 implements DialogInterface.OnKeyListener {
    public final /* synthetic */ DaijishouDialogFragment f$0;

    public /* synthetic */ DaijishouDialogFragment$$ExternalSyntheticLambda0(DaijishouDialogFragment daijishouDialogFragment) {
        this.f$0 = daijishouDialogFragment;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        return DaijishouDialogFragment.setupDaijishouDialog$lambda$4(this.f$0, dialogInterface, i, keyEvent);
    }
}
