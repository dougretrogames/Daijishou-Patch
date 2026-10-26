package com.magneticchen.daijishou.dialog_fragments;

import android.content.Context;
import android.view.View;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.textfield.TextInputEditText;
import java.util.List;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class EditPlayableItemDialogFragment$$ExternalSyntheticLambda11 implements View.OnClickListener {
    public final /* synthetic */ TextInputEditText f$0;
    public final /* synthetic */ List f$1;
    public final /* synthetic */ EditPlayableItemDialogFragment f$2;
    public final /* synthetic */ Context f$3;
    public final /* synthetic */ ChipGroup f$4;

    public /* synthetic */ EditPlayableItemDialogFragment$$ExternalSyntheticLambda11(TextInputEditText textInputEditText, List list, EditPlayableItemDialogFragment editPlayableItemDialogFragment, Context context, ChipGroup chipGroup) {
        this.f$0 = textInputEditText;
        this.f$1 = list;
        this.f$2 = editPlayableItemDialogFragment;
        this.f$3 = context;
        this.f$4 = chipGroup;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            EditPlayableItemDialogFragment.onCreateDialog$lambda$25$lambda$24$lambda$23$lambda$10(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
