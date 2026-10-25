package com.magneticchen.daijishou.dialog_fragments;

import android.widget.Toast;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity;
import com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity;
import com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsGameRecordEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: RetroAchievementsGameDialogFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class RetroAchievementsGameDialogFragment$onCreateView$8$1 extends Lambda<Unit> implements Function1<PlayableItemEntity, Unit> {
    final /* synthetic */ ChoosePlayableItemFromLibraryDialogFragment $dialog;
    final /* synthetic */ RetroAchievementsGameRecordEntity $retroAchievementsGameRecord;
    final /* synthetic */ RetroAchievementsGameDialogFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RetroAchievementsGameDialogFragment$onCreateView$8$1(RetroAchievementsGameRecordEntity retroAchievementsGameRecordEntity, RetroAchievementsGameDialogFragment retroAchievementsGameDialogFragment, ChoosePlayableItemFromLibraryDialogFragment choosePlayableItemFromLibraryDialogFragment) {
        super(1);
        this.$retroAchievementsGameRecord = retroAchievementsGameRecordEntity;
        this.this$0 = retroAchievementsGameDialogFragment;
        this.$dialog = choosePlayableItemFromLibraryDialogFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(PlayableItemEntity playableItemEntity) {
        invoke2(playableItemEntity);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(PlayableItemEntity it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this.this$0.getRetroAchievementsRepository().addRetroAchievementsCachedPlayableItemIdToGameIdSurjection(new RetroAchievementsCachedPlayableItemIdToGameIdSurjectionEntity(0L, true, it.getId(), this.$retroAchievementsGameRecord.getGameId(), null, 17, null));
        this.$dialog.dismiss();
        Toast.makeText(this.this$0.requireContext(), this.this$0.getString(R.string.associated), 0).show();
    }
}
