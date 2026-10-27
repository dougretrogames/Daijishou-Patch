package com.magneticchen.daijishou.ui.fragments.dialog;

import androidx.recyclerview.widget.DiffUtil;
import com.magneticchen.daijishou.data.db.entity.PlayableItemEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchPlayableItemDialogFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/dialog/PlayableItemEntityDiffUtilCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldList", "", "Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;", "newList", "(Ljava/util/List;Ljava/util/List;)V", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PlayableItemEntityDiffUtilCallback extends DiffUtil.Callback {
    private final List<PlayableItemEntity> newList;
    private final List<PlayableItemEntity> oldList;

    public PlayableItemEntityDiffUtilCallback(List<PlayableItemEntity> oldList, List<PlayableItemEntity> newList) {
        Intrinsics.checkNotNullParameter(oldList, "oldList");
        Intrinsics.checkNotNullParameter(newList, "newList");
        this.oldList = oldList;
        this.newList = newList;
    }

    public int getOldListSize() {
        return this.oldList.size();
    }

    public int getNewListSize() {
        return this.newList.size();
    }

    public boolean areItemsTheSame(int i, int i2) {
        return this.newList.get(i2).getId() == this.oldList.get(i).getId();
    }

    public boolean areContentsTheSame(int i, int i2) {
        return Intrinsics.areEqual(this.newList.get(i2).getName(), this.oldList.get(i).getName()) && Intrinsics.areEqual(this.newList.get(i2).getAttachedPlatformId(), this.oldList.get(i).getAttachedPlatformId()) && this.newList.get(i2).isFavorite() == this.oldList.get(i).isFavorite() && Intrinsics.areEqual(this.newList.get(i2).getLastPlayedTimestamp(), this.oldList.get(i).getLastPlayedTimestamp());
    }
}
