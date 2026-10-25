package com.magneticchen.daijishou.dialog_fragments;

import android.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class ListSelectDialogFragment$$ExternalSyntheticLambda1 implements AdapterView.OnItemClickListener {
    public final /* synthetic */ ListSelectDialogFragment f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ AlertDialog f$2;

    public /* synthetic */ ListSelectDialogFragment$$ExternalSyntheticLambda1(ListSelectDialogFragment listSelectDialogFragment, boolean z, AlertDialog alertDialog) {
        this.f$0 = listSelectDialogFragment;
        this.f$1 = z;
        this.f$2 = alertDialog;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        try {
            ListSelectDialogFragment.onCreateDialog$lambda$6$lambda$2(this.f$0, this.f$1, this.f$2, adapterView, view, i, j);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
