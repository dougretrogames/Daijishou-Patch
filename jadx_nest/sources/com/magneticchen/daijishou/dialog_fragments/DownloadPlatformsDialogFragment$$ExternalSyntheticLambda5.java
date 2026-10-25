package com.magneticchen.daijishou.dialog_fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.ListView;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class DownloadPlatformsDialogFragment$$ExternalSyntheticLambda5 implements DialogInterface.OnShowListener {
    public final /* synthetic */ AlertDialog f$0;
    public final /* synthetic */ DownloadPlatformsDialogFragment f$1;
    public final /* synthetic */ ListView f$2;
    public final /* synthetic */ FragmentActivity f$3;

    public /* synthetic */ DownloadPlatformsDialogFragment$$ExternalSyntheticLambda5(AlertDialog alertDialog, DownloadPlatformsDialogFragment downloadPlatformsDialogFragment, ListView listView, FragmentActivity fragmentActivity) {
        this.f$0 = alertDialog;
        this.f$1 = downloadPlatformsDialogFragment;
        this.f$2 = listView;
        this.f$3 = fragmentActivity;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        try {
            DownloadPlatformsDialogFragment.onCreateDialog$lambda$10$lambda$9(this.f$0, this.f$1, this.f$2, this.f$3, dialogInterface);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
