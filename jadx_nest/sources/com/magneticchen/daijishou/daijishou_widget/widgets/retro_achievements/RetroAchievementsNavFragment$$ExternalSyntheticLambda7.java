package com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements;

import android.view.View;
import com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsUserProfileEntity;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class RetroAchievementsNavFragment$$ExternalSyntheticLambda7 implements View.OnClickListener {
    public final /* synthetic */ RetroAchievementsUserProfileEntity f$0;
    public final /* synthetic */ RetroAchievementsNavFragment f$1;

    public /* synthetic */ RetroAchievementsNavFragment$$ExternalSyntheticLambda7(RetroAchievementsUserProfileEntity retroAchievementsUserProfileEntity, RetroAchievementsNavFragment retroAchievementsNavFragment) {
        this.f$0 = retroAchievementsUserProfileEntity;
        this.f$1 = retroAchievementsNavFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            RetroAchievementsNavFragment.renderUserProfile$lambda$1(this.f$0, this.f$1, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
