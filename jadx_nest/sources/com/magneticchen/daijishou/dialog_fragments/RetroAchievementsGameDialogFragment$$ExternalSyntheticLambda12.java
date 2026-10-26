package com.magneticchen.daijishou.dialog_fragments;

import android.view.View;
import com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsGameRecordEntity;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class RetroAchievementsGameDialogFragment$$ExternalSyntheticLambda12 implements View.OnClickListener {
    public final /* synthetic */ RetroAchievementsGameRecordEntity f$0;
    public final /* synthetic */ RetroAchievementsGameDialogFragment f$1;

    public /* synthetic */ RetroAchievementsGameDialogFragment$$ExternalSyntheticLambda12(RetroAchievementsGameRecordEntity retroAchievementsGameRecordEntity, RetroAchievementsGameDialogFragment retroAchievementsGameDialogFragment) {
        this.f$0 = retroAchievementsGameRecordEntity;
        this.f$1 = retroAchievementsGameDialogFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            RetroAchievementsGameDialogFragment.onCreateView$updateRetroAchievementsGameRecord$lambda$26(this.f$0, this.f$1, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
