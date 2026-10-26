package com.magneticchen.daijishou.daijishou_widget.widgets.category;

import android.view.View;
import com.google.android.material.chip.Chip;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class CategoryWidgetNavFragment$$ExternalSyntheticLambda3 implements View.OnClickListener {
    public final /* synthetic */ CategoryWidgetNavFragment f$0;
    public final /* synthetic */ Chip f$1;

    public /* synthetic */ CategoryWidgetNavFragment$$ExternalSyntheticLambda3(CategoryWidgetNavFragment categoryWidgetNavFragment, Chip chip) {
        this.f$0 = categoryWidgetNavFragment;
        this.f$1 = chip;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            CategoryWidgetNavFragment.updateGenres$lambda$6$lambda$4(this.f$0, this.f$1, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
