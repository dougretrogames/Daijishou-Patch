package com.magneticchen.daijishou.nav_fragments;

import androidx.fragment.app.FragmentActivity;
import com.magneticchen.daijishou.activities.MainActivity;
import com.magneticchen.daijishou.daijishou_widget.WidgetsManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: WidgetGridNavFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/magneticchen/daijishou/daijishou_widget/WidgetsManager;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class WidgetGridNavFragment$widgetsManager$2 extends Lambda<WidgetsManager> implements Function0<WidgetsManager> {
    final /* synthetic */ WidgetGridNavFragment this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    WidgetGridNavFragment$widgetsManager$2(WidgetGridNavFragment widgetGridNavFragment) {
        super(0);
        this.this$0 = widgetGridNavFragment;
    }

    /* WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetsManager invoke() {
        FragmentActivity fragmentActivityRequireActivity = this.this$0.requireActivity();
        Intrinsics.checkNotNull(fragmentActivityRequireActivity, "null cannot be cast to non-null type com.magneticchen.daijishou.activities.MainActivity");
        return ((MainActivity) fragmentActivityRequireActivity).getWidgetsManager();
    }
}
