package com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsUserProfileEntity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: RetroAchievementsNavFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001¢\u0006\u0002\b\u00032\r\u0010\u0004\u001a\t\u0018\u00010\u0005¢\u0006\u0002\b\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Landroidx/lifecycle/LiveData;", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsUserProfileEntity;", "Lkotlin/jvm/JvmSuppressWildcards;", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class RetroAchievementsNavFragment$onCreateView$userProfileLiveData$1 extends Lambda<LiveData<RetroAchievementsUserProfileEntity>> implements Function1<String, LiveData<RetroAchievementsUserProfileEntity>> {
    final /* synthetic */ RetroAchievementsNavFragment this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    RetroAchievementsNavFragment$onCreateView$userProfileLiveData$1(RetroAchievementsNavFragment retroAchievementsNavFragment) {
        super(1);
        this.this$0 = retroAchievementsNavFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public final LiveData<RetroAchievementsUserProfileEntity> invoke(String str) {
        if (str != null) {
            return this.this$0.getRetroAchievementsManager().getRetroAchievementsRepository().getRetroAchievementsUserProfileById(str);
        }
        return new MutableLiveData(null);
    }
}
