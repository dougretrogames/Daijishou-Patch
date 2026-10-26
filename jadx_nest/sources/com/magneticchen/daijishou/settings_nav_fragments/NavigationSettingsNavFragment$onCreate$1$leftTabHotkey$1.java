package com.magneticchen.daijishou.settings_nav_fragments;

import android.view.KeyEvent;
import com.magneticchen.daijishou.application_data.IntPreference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: NavigationSettingsNavFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/KeyEvent;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class NavigationSettingsNavFragment$onCreate$1$leftTabHotkey$1 extends Lambda<Unit> implements Function1<KeyEvent, Unit> {
    final /* synthetic */ Function0<Unit> $function;
    final /* synthetic */ NavigationSettingsNavFragment this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    NavigationSettingsNavFragment$onCreate$1$leftTabHotkey$1(NavigationSettingsNavFragment navigationSettingsNavFragment, Function0<Unit> function0) {
        super(1);
        this.this$0 = navigationSettingsNavFragment;
        this.$function = function0;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(KeyEvent keyEvent) {
        invoke2(keyEvent);
        return Unit.INSTANCE;
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(KeyEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        this.this$0.getDefaultSharedPreferences().edit().putInt(IntPreference.LEFT_TAB_HOTKEY.getKey(), it.getKeyCode()).apply();
        this.$function.invoke();
    }
}
