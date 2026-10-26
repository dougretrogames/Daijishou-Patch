package com.magneticchen.daijishou.dialog_fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class PickPlatformSyncTreeUrDialogFragment$$ExternalSyntheticLambda7 implements DialogInterface.OnShowListener {
    public final /* synthetic */ AlertDialog f$0;
    public final /* synthetic */ PickPlatformSyncTreeUrDialogFragment f$1;

    public /* synthetic */ PickPlatformSyncTreeUrDialogFragment$$ExternalSyntheticLambda7(AlertDialog alertDialog, PickPlatformSyncTreeUrDialogFragment pickPlatformSyncTreeUrDialogFragment) {
        this.f$0 = alertDialog;
        this.f$1 = pickPlatformSyncTreeUrDialogFragment;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        try {
            PickPlatformSyncTreeUrDialogFragment.onCreateDialog$lambda$11$lambda$10$lambda$9(this.f$0, this.f$1, dialogInterface);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
