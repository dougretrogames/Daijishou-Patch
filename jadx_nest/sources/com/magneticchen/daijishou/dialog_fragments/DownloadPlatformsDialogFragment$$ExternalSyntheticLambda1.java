package com.magneticchen.daijishou.dialog_fragments;

import android.content.DialogInterface;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class DownloadPlatformsDialogFragment$$ExternalSyntheticLambda1 implements DialogInterface.OnClickListener {
    public final /* synthetic */ DownloadPlatformsDialogFragment f$0;

    public /* synthetic */ DownloadPlatformsDialogFragment$$ExternalSyntheticLambda1(DownloadPlatformsDialogFragment downloadPlatformsDialogFragment) {
        this.f$0 = downloadPlatformsDialogFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        try {
            DownloadPlatformsDialogFragment.onCreateDialog$lambda$10$lambda$1(this.f$0, dialogInterface, i);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
