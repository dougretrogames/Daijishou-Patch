package com.magneticchen.daijishou.nav_fragments;

import com.magneticchen.daijishou.daijishou_widget.WidgetsManager;
import com.magneticchen.daijishou.daijishou_widget.widget_recycler_view.WidgetFaceRecyclerViewAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: WidgetGridNavFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "fromPosition", "", "toPosition", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class WidgetGridNavFragment$showOptionsForViewHolder$2$1 extends Lambda<Unit> implements Function2<Integer, Integer, Unit> {
    final /* synthetic */ WidgetsManager $widgetsManager;
    final /* synthetic */ WidgetGridNavFragment this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    WidgetGridNavFragment$showOptionsForViewHolder$2$1(WidgetGridNavFragment widgetGridNavFragment, WidgetsManager widgetsManager) {
        super(2);
        this.this$0 = widgetGridNavFragment;
        this.$widgetsManager = widgetsManager;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
        invoke(num.intValue(), num2.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i, int i2) {
        WidgetFaceRecyclerViewAdapter widgetFaceRecyclerViewAdapter = this.this$0.widgetFaceRecyclerViewAdapter;
        if (widgetFaceRecyclerViewAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("widgetFaceRecyclerViewAdapter");
            widgetFaceRecyclerViewAdapter = null;
        }
        widgetFaceRecyclerViewAdapter.selectPosition(i2);
        this.$widgetsManager.moveWidgetInstancePosition(i, i2);
    }
}
