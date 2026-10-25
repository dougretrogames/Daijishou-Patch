package com.magneticchen.daijishou.daijishou_widget.widgets.random;

import com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity;
import com.magneticchen.daijishou.view_models.DaijishouLibraryModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: RandomWidgetFaceFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<no name provided>", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class RandomWidgetFaceFragment$widgetInstanceIdToRandomFunction$4 extends Lambda<PlayableItemEntity> implements Function0<PlayableItemEntity> {
    final /* synthetic */ RandomWidgetFaceFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RandomWidgetFaceFragment$widgetInstanceIdToRandomFunction$4(RandomWidgetFaceFragment randomWidgetFaceFragment) {
        super(0);
        this.this$0 = randomWidgetFaceFragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final PlayableItemEntity invoke() {
        return DaijishouLibraryModel.getNewlyPlayableItemRandomlyByVisibility$default(this.this$0.getDaijishouLibrary(), false, 1, null);
    }
}
