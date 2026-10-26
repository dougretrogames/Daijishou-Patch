package com.magneticchen.daijishou.view_models;

import android.app.Application;
import com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager;
import com.magneticchen.daijishou.view_models.abstract_view_models.DaijishouAndroidViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: RetroAchievementsModel.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/magneticchen/daijishou/view_models/RetroAchievementsModel;", "Lcom/magneticchen/daijishou/view_models/abstract_view_models/DaijishouAndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "retroAchievementsManager", "Lcom/magneticchen/daijishou/retro_achievements/RetroAchievementsManager;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RetroAchievementsModel extends DaijishouAndroidViewModel {
    private final RetroAchievementsManager retroAchievementsManager;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RetroAchievementsModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.retroAchievementsManager = getApplication().getRetroAchievementsManager();
    }
}
