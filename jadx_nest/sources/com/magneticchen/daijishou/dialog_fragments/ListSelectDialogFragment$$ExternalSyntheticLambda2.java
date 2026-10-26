package com.magneticchen.daijishou.dialog_fragments;

import android.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class ListSelectDialogFragment$$ExternalSyntheticLambda2 implements AdapterView.OnItemLongClickListener {
    public final /* synthetic */ ListSelectDialogFragment f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ AlertDialog f$2;

    public /* synthetic */ ListSelectDialogFragment$$ExternalSyntheticLambda2(ListSelectDialogFragment listSelectDialogFragment, boolean z, AlertDialog alertDialog) {
        this.f$0 = listSelectDialogFragment;
        this.f$1 = z;
        this.f$2 = alertDialog;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public final boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        return ListSelectDialogFragment.onCreateDialog$lambda$6$lambda$4(this.f$0, this.f$1, this.f$2, adapterView, view, i, j);
    }
}
