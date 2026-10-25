package com.magneticchen.daijishou.daijishou_widget.widgets.category;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: CategoryWidgetNavFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Ljava/lang/Exception;", "Lkotlin/Exception;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class CategoryWidgetNavFragment$CategoryWidgetRecyclerViewAdapter$ViewHolder$onBind$1 extends Lambda<Unit> implements Function1<Exception, Unit> {
    final /* synthetic */ CategoryWidgetNavFragment.CategoryWidgetRecyclerViewAdapter.ViewHolder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CategoryWidgetNavFragment$CategoryWidgetRecyclerViewAdapter$ViewHolder$onBind$1(CategoryWidgetNavFragment.CategoryWidgetRecyclerViewAdapter.ViewHolder viewHolder) {
        super(1);
        this.this$0 = viewHolder;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
        invoke2(exc);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Exception it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this.this$0.placeholder.setVisibility(0);
        this.this$0.platformTextView.setVisibility(0);
    }
}
