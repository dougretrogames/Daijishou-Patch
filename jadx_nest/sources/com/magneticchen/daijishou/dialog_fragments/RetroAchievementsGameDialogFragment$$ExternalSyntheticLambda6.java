package com.magneticchen.daijishou.dialog_fragments;

import android.view.MenuItem;
import androidx.appcompat.widget.PopupMenu;
import com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsGameRecordEntity;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class RetroAchievementsGameDialogFragment$$ExternalSyntheticLambda6 implements PopupMenu.OnMenuItemClickListener {
    public final /* synthetic */ RetroAchievementsGameRecordEntity f$0;
    public final /* synthetic */ RetroAchievementsGameDialogFragment f$1;

    public /* synthetic */ RetroAchievementsGameDialogFragment$$ExternalSyntheticLambda6(RetroAchievementsGameRecordEntity retroAchievementsGameRecordEntity, RetroAchievementsGameDialogFragment retroAchievementsGameDialogFragment) {
        this.f$0 = retroAchievementsGameRecordEntity;
        this.f$1 = retroAchievementsGameDialogFragment;
    }

    @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        return RetroAchievementsGameDialogFragment.onCreateView$lambda$16(this.f$0, this.f$1, menuItem);
    }
}
