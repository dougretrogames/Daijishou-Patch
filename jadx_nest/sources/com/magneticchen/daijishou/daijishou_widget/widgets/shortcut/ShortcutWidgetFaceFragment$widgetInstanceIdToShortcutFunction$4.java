package com.magneticchen.daijishou.daijishou_widget.widgets.shortcut;

import androidx.fragment.app.FragmentActivity;
import com.magneticchen.daijishou.activities.MainActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: ShortcutWidgetFaceFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class ShortcutWidgetFaceFragment$widgetInstanceIdToShortcutFunction$4 extends Lambda<Unit> implements Function0<Unit> {
    final /* synthetic */ ShortcutWidgetFaceFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ShortcutWidgetFaceFragment$widgetInstanceIdToShortcutFunction$4(ShortcutWidgetFaceFragment shortcutWidgetFaceFragment) {
        super(0);
        this.this$0 = shortcutWidgetFaceFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        FragmentActivity fragmentActivityRequireActivity = this.this$0.requireActivity();
        Intrinsics.checkNotNull(fragmentActivityRequireActivity, "null cannot be cast to non-null type com.magneticchen.daijishou.activities.MainActivity");
        ((MainActivity) fragmentActivityRequireActivity).navigatePage("apps", null);
    }
}
