package com.magneticchen.daijishou.dialog_fragments;

import android.view.View;
import com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsGameRecordEntity;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class RetroAchievementsGameDialogFragment$$ExternalSyntheticLambda1 implements View.OnClickListener {
    public final /* synthetic */ RetroAchievementsGameDialogFragment f$0;
    public final /* synthetic */ RetroAchievementsGameRecordEntity f$1;

    public /* synthetic */ RetroAchievementsGameDialogFragment$$ExternalSyntheticLambda1(RetroAchievementsGameDialogFragment retroAchievementsGameDialogFragment, RetroAchievementsGameRecordEntity retroAchievementsGameRecordEntity) {
        this.f$0 = retroAchievementsGameDialogFragment;
        this.f$1 = retroAchievementsGameRecordEntity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            RetroAchievementsGameDialogFragment.onCreateView$updateRetroAchievementsGameRecord$lambda$27(this.f$0, this.f$1, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
