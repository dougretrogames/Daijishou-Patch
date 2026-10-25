package com.magneticchen.daijishou.dialog_fragments;

import androidx.recyclerview.widget.DiffUtil;
import com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsAchievementRecordEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RetroAchievementsGameDialogFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/magneticchen/daijishou/dialog_fragments/RetroAchievementsAchievementRecordDiffUtilCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldList", "", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsAchievementRecordEntity;", "newList", "(Ljava/util/List;Ljava/util/List;)V", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RetroAchievementsAchievementRecordDiffUtilCallback extends DiffUtil.Callback {
    private final List<RetroAchievementsAchievementRecordEntity> newList;
    private final List<RetroAchievementsAchievementRecordEntity> oldList;

    public RetroAchievementsAchievementRecordDiffUtilCallback(List<RetroAchievementsAchievementRecordEntity> oldList, List<RetroAchievementsAchievementRecordEntity> newList) {
        Intrinsics.checkNotNullParameter(oldList, "oldList");
        Intrinsics.checkNotNullParameter(newList, "newList");
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getOldListSize() {
        return this.oldList.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getNewListSize() {
        return this.newList.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return this.newList.get(newItemPosition).getAchievementId() == this.oldList.get(oldItemPosition).getAchievementId();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return Intrinsics.areEqual(this.newList.get(newItemPosition).getGameId(), this.oldList.get(oldItemPosition).getGameId()) && Intrinsics.areEqual(this.newList.get(newItemPosition).getName(), this.oldList.get(oldItemPosition).getName()) && Intrinsics.areEqual(this.newList.get(newItemPosition).getImageUrl(), this.oldList.get(oldItemPosition).getImageUrl()) && this.newList.get(newItemPosition).isUnlocked() == this.oldList.get(oldItemPosition).isUnlocked() && this.newList.get(newItemPosition).isHardcoreUnlocked() == this.oldList.get(oldItemPosition).isHardcoreUnlocked();
    }
}
