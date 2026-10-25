package com.magneticchen.daijishou.daijishou_widget.widgets.category;

import com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: CategoryWidgetViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayableItemEntity;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class CategoryWidgetViewModel$refreshHighlightPlayableItemsLiveDataSource$2$1 extends Lambda<Unit> implements Function1<List<? extends PlayableItemEntity>, Unit> {
    final /* synthetic */ CategoryWidgetViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CategoryWidgetViewModel$refreshHighlightPlayableItemsLiveDataSource$2$1(CategoryWidgetViewModel categoryWidgetViewModel) {
        super(1);
        this.this$0 = categoryWidgetViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends PlayableItemEntity> list) {
        invoke2((List<PlayableItemEntity>) list);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<PlayableItemEntity> list) {
        this.this$0.getGenresWidgetPlayableItemsLiveData().postValue(list);
    }
}
