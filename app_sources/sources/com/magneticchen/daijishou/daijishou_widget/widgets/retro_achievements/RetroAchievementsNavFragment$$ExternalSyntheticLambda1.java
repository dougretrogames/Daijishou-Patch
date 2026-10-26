package com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements;

import android.view.View;
import kotlin.jvm.internal.Ref;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class RetroAchievementsNavFragment$$ExternalSyntheticLambda1 implements View.OnClickListener {
    public final /* synthetic */ Ref.BooleanRef f$0;
    public final /* synthetic */ RetroAchievementsNavFragment f$1;

    public /* synthetic */ RetroAchievementsNavFragment$$ExternalSyntheticLambda1(Ref.BooleanRef booleanRef, RetroAchievementsNavFragment retroAchievementsNavFragment) {
        this.f$0 = booleanRef;
        this.f$1 = retroAchievementsNavFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            RetroAchievementsNavFragment.onCreateView$lambda$3(this.f$0, this.f$1, view);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
