package com.magneticchen.daijishou.dialog_fragments;

import android.content.Context;
import android.view.View;
import android.widget.AutoCompleteTextView;
import com.google.android.material.chip.ChipGroup;
import java.util.List;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class EditPlatformDialogFragment$$ExternalSyntheticLambda6 implements View.OnClickListener {
    public final /* synthetic */ AutoCompleteTextView f$0;
    public final /* synthetic */ List f$1;
    public final /* synthetic */ EditPlatformDialogFragment f$2;
    public final /* synthetic */ List f$3;
    public final /* synthetic */ List f$4;
    public final /* synthetic */ Context f$5;
    public final /* synthetic */ ChipGroup f$6;

    public /* synthetic */ EditPlatformDialogFragment$$ExternalSyntheticLambda6(AutoCompleteTextView autoCompleteTextView, List list, EditPlatformDialogFragment editPlatformDialogFragment, List list2, List list3, Context context, ChipGroup chipGroup) {
        this.f$0 = autoCompleteTextView;
        this.f$1 = list;
        this.f$2 = editPlatformDialogFragment;
        this.f$3 = list2;
        this.f$4 = list3;
        this.f$5 = context;
        this.f$6 = chipGroup;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            EditPlatformDialogFragment.onCreateDialog$lambda$48$lambda$47$lambda$26(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
