package com.magneticchen.daijishou.dialog_fragments;

import android.content.Context;
import android.view.View;
import android.widget.AutoCompleteTextView;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.textfield.TextInputEditText;
import java.util.List;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class EditPlayableItemDialogFragment$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ AutoCompleteTextView f$0;
    public final /* synthetic */ List f$1;
    public final /* synthetic */ List f$2;
    public final /* synthetic */ EditPlayableItemDialogFragment f$3;
    public final /* synthetic */ List f$4;
    public final /* synthetic */ TextInputEditText f$5;
    public final /* synthetic */ Context f$6;
    public final /* synthetic */ ChipGroup f$7;

    public /* synthetic */ EditPlayableItemDialogFragment$$ExternalSyntheticLambda0(AutoCompleteTextView autoCompleteTextView, List list, List list2, EditPlayableItemDialogFragment editPlayableItemDialogFragment, List list3, TextInputEditText textInputEditText, Context context, ChipGroup chipGroup) {
        this.f$0 = autoCompleteTextView;
        this.f$1 = list;
        this.f$2 = list2;
        this.f$3 = editPlayableItemDialogFragment;
        this.f$4 = list3;
        this.f$5 = textInputEditText;
        this.f$6 = context;
        this.f$7 = chipGroup;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            EditPlayableItemDialogFragment.onCreateDialog$lambda$25$lambda$24$lambda$23$lambda$7(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
