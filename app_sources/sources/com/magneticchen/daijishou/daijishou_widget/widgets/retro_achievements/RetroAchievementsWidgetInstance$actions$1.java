package com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements;

import androidx.appcompat.app.AppCompatActivity;
import com.magneticchen.daijishou.dialog_fragments.EditRetroAchievementsAccountDialogFragment;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: RetroAchievementsWidgetInstance.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class RetroAchievementsWidgetInstance$actions$1 extends Lambda<Unit> implements Function1<AppCompatActivity, Unit> {
    public static final RetroAchievementsWidgetInstance$actions$1 INSTANCE = new RetroAchievementsWidgetInstance$actions$1();

    RetroAchievementsWidgetInstance$actions$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AppCompatActivity appCompatActivity) {
        invoke2(appCompatActivity);
        return Unit.INSTANCE;
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(AppCompatActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        EditRetroAchievementsAccountDialogFragment.INSTANCE.newInstance().show(activity.getSupportFragmentManager(), EditRetroAchievementsAccountDialogFragment.class.getName());
    }
}
