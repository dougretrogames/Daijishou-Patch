package com.magneticchen.daijishou.dialog_fragments;

import android.view.View;
import androidx.appcompat.widget.PopupMenu;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class RetroAchievementsGameDialogFragment$$ExternalSyntheticLambda7 implements View.OnClickListener {
    public final /* synthetic */ PopupMenu f$0;

    public /* synthetic */ RetroAchievementsGameDialogFragment$$ExternalSyntheticLambda7(PopupMenu popupMenu) {
        this.f$0 = popupMenu;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            RetroAchievementsGameDialogFragment.onCreateView$lambda$17(this.f$0, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
