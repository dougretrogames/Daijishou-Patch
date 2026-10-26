package com.magneticchen.daijishou.nav_fragments;

import android.content.Context;
import android.widget.Toast;
import com.magneticchen.daijishou.application_data.IntPreference;
import com.magneticchen.daijishou.daijishou_widget.widget_recycler_view.WidgetFaceRecyclerViewAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;

/* INFO: compiled from: WidgetGridNavFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "removed", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class WidgetGridNavFragment$showOptionsForViewHolder$2$2 extends Lambda<Unit> implements Function1<Boolean, Unit> {
    final /* synthetic */ WidgetGridNavFragment this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    WidgetGridNavFragment$showOptionsForViewHolder$2$2(WidgetGridNavFragment widgetGridNavFragment) {
        super(1);
        this.this$0 = widgetGridNavFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        WidgetFaceRecyclerViewAdapter widgetFaceRecyclerViewAdapter = null;
        if (z) {
            Context context = this.this$0.getContext();
            String str = this.this$0.widgetRemovedSuccessfullyString;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("widgetRemovedSuccessfullyString");
                str = null;
            }
            Toast.makeText(context, str, 0).show();
        } else {
            Context context2 = this.this$0.getContext();
            String str2 = this.this$0.widgetRemoveCanceledString;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("widgetRemoveCanceledString");
                str2 = null;
            }
            Toast.makeText(context2, str2, 0).show();
        }
        WidgetFaceRecyclerViewAdapter widgetFaceRecyclerViewAdapter2 = this.this$0.widgetFaceRecyclerViewAdapter;
        if (widgetFaceRecyclerViewAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("widgetFaceRecyclerViewAdapter");
        } else {
            widgetFaceRecyclerViewAdapter = widgetFaceRecyclerViewAdapter2;
        }
        widgetFaceRecyclerViewAdapter.selectPosition(RangesKt.coerceAtMost(this.this$0.widgetInstances.size() - 1, this.this$0.getDefaultSharedPreferences().getInt(IntPreference.WIDGET_GRID_LAST_FOCUSED_POSITION.getKey(), IntPreference.WIDGET_GRID_LAST_FOCUSED_POSITION.getDefaultValue())));
    }
}
