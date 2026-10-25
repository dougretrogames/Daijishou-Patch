package com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements;

import android.view.View;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class RetroAchievementsNavFragment$$ExternalSyntheticLambda0 implements View.OnScrollChangeListener {
    public final /* synthetic */ RetroAchievementsNavFragment f$0;

    public /* synthetic */ RetroAchievementsNavFragment$$ExternalSyntheticLambda0(RetroAchievementsNavFragment retroAchievementsNavFragment) {
        this.f$0 = retroAchievementsNavFragment;
    }

    @Override // android.view.View.OnScrollChangeListener
    public final void onScrollChange(View view, int i, int i2, int i3, int i4) {
        try {
            RetroAchievementsNavFragment.onCreateView$lambda$2(this.f$0, view, i, i2, i3, i4);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
