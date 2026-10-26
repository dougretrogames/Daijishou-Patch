package com.magneticchen.daijishou.dialog_fragments;

import android.view.View;
import com.google.android.material.chip.ChipGroup;
import java.util.List;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class EditPlayableItemDialogFragment$$ExternalSyntheticLambda7 implements View.OnClickListener {
    public final /* synthetic */ List f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ ChipGroup f$2;

    public /* synthetic */ EditPlayableItemDialogFragment$$ExternalSyntheticLambda7(List list, String str, ChipGroup chipGroup) {
        this.f$0 = list;
        this.f$1 = str;
        this.f$2 = chipGroup;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            EditPlayableItemDialogFragment.onCreateDialog$lambda$25$lambda$24$lambda$23$addGenreId$lambda$5(this.f$0, this.f$1, this.f$2, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
