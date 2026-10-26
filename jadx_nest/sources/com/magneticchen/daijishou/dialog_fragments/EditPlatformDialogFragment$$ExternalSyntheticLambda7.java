package com.magneticchen.daijishou.dialog_fragments;

import android.content.Context;
import android.view.View;
import android.widget.AutoCompleteTextView;
import com.google.android.material.chip.ChipGroup;
import java.util.List;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class EditPlatformDialogFragment$$ExternalSyntheticLambda7 implements View.OnClickListener {
    public final /* synthetic */ AutoCompleteTextView f$0;
    public final /* synthetic */ List f$1;
    public final /* synthetic */ EditPlatformDialogFragment f$2;
    public final /* synthetic */ List f$3;
    public final /* synthetic */ Context f$4;
    public final /* synthetic */ ChipGroup f$5;

    public /* synthetic */ EditPlatformDialogFragment$$ExternalSyntheticLambda7(AutoCompleteTextView autoCompleteTextView, List list, EditPlatformDialogFragment editPlatformDialogFragment, List list2, Context context, ChipGroup chipGroup) {
        this.f$0 = autoCompleteTextView;
        this.f$1 = list;
        this.f$2 = editPlatformDialogFragment;
        this.f$3 = list2;
        this.f$4 = context;
        this.f$5 = chipGroup;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            EditPlatformDialogFragment.onCreateDialog$lambda$48$lambda$47$lambda$27(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
