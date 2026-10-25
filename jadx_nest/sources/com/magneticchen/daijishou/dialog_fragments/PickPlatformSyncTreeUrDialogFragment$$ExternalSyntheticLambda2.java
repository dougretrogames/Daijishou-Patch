package com.magneticchen.daijishou.dialog_fragments;

import android.app.AlertDialog;
import android.view.View;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class PickPlatformSyncTreeUrDialogFragment$$ExternalSyntheticLambda2 implements View.OnClickListener {
    public final /* synthetic */ PickPlatformSyncTreeUrDialogFragment f$0;
    public final /* synthetic */ AlertDialog f$1;

    public /* synthetic */ PickPlatformSyncTreeUrDialogFragment$$ExternalSyntheticLambda2(PickPlatformSyncTreeUrDialogFragment pickPlatformSyncTreeUrDialogFragment, AlertDialog alertDialog) {
        this.f$0 = pickPlatformSyncTreeUrDialogFragment;
        this.f$1 = alertDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            PickPlatformSyncTreeUrDialogFragment.onCreateDialog$lambda$11$lambda$10$lambda$9$lambda$8(this.f$0, this.f$1, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
