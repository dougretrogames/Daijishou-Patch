package com.magneticchen.daijishou.dialog_fragments;

import android.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import androidx.fragment.app.FragmentActivity;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class DownloadPlatformsDialogFragment$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ AlertDialog f$0;
    public final /* synthetic */ DownloadPlatformsDialogFragment f$1;
    public final /* synthetic */ Button f$2;
    public final /* synthetic */ Button f$3;
    public final /* synthetic */ Button f$4;
    public final /* synthetic */ ListView f$5;
    public final /* synthetic */ FragmentActivity f$6;

    public /* synthetic */ DownloadPlatformsDialogFragment$$ExternalSyntheticLambda0(AlertDialog alertDialog, DownloadPlatformsDialogFragment downloadPlatformsDialogFragment, Button button, Button button2, Button button3, ListView listView, FragmentActivity fragmentActivity) {
        this.f$0 = alertDialog;
        this.f$1 = downloadPlatformsDialogFragment;
        this.f$2 = button;
        this.f$3 = button2;
        this.f$4 = button3;
        this.f$5 = listView;
        this.f$6 = fragmentActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            DownloadPlatformsDialogFragment.onCreateDialog$lambda$10$lambda$9$lambda$8(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
