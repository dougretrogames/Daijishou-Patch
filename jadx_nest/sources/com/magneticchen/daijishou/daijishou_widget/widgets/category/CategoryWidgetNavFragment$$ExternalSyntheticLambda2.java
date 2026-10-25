package com.magneticchen.daijishou.daijishou_widget.widgets.category;

import com.google.android.material.chip.Chip;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class CategoryWidgetNavFragment$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ CategoryWidgetNavFragment f$1;
    public final /* synthetic */ Chip f$2;

    public /* synthetic */ CategoryWidgetNavFragment$$ExternalSyntheticLambda2(boolean z, CategoryWidgetNavFragment categoryWidgetNavFragment, Chip chip) {
        this.f$0 = z;
        this.f$1 = categoryWidgetNavFragment;
        this.f$2 = chip;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            CategoryWidgetNavFragment.selectChip$lambda$3(this.f$0, this.f$1, this.f$2);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
