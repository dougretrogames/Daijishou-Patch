package com.magneticchen.daijishou.settings_nav_fragments;

import com.magneticchen.daijishou.application_data.IntPreference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: NavigationSettingsNavFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class NavigationSettingsNavFragment$onCreate$2$nextHotkey$2 extends Lambda<Unit> implements Function0<Unit> {
    final /* synthetic */ Function0<Unit> $function;
    final /* synthetic */ NavigationSettingsNavFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NavigationSettingsNavFragment$onCreate$2$nextHotkey$2(NavigationSettingsNavFragment navigationSettingsNavFragment, Function0<Unit> function0) {
        super(0);
        this.this$0 = navigationSettingsNavFragment;
        this.$function = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.getDefaultSharedPreferences().edit().putInt(IntPreference.SWITCHING_NEXT_HOTKEY.getKey(), -1).apply();
        this.$function.invoke();
    }
}
