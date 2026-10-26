package com.magneticchen.daijishou.dialog_fragments;

import android.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class DownloadPlatformsDialogFragment$$ExternalSyntheticLambda4 implements AdapterView.OnItemClickListener {
    public final /* synthetic */ AlertDialog f$0;
    public final /* synthetic */ DownloadPlatformsDialogFragment f$1;
    public final /* synthetic */ ListView f$2;

    public /* synthetic */ DownloadPlatformsDialogFragment$$ExternalSyntheticLambda4(AlertDialog alertDialog, DownloadPlatformsDialogFragment downloadPlatformsDialogFragment, ListView listView) {
        this.f$0 = alertDialog;
        this.f$1 = downloadPlatformsDialogFragment;
        this.f$2 = listView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        try {
            DownloadPlatformsDialogFragment.onCreateDialog$lambda$10$lambda$4(this.f$0, this.f$1, this.f$2, adapterView, view, i, j);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
