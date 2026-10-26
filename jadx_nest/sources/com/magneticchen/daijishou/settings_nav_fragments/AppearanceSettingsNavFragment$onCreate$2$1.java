package com.magneticchen.daijishou.settings_nav_fragments;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: AppearanceSettingsNavFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class AppearanceSettingsNavFragment$onCreate$2$1 extends Lambda<Unit> implements Function0<Unit> {
    final /* synthetic */ AppearanceSettingsNavFragment this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppearanceSettingsNavFragment$onCreate$2$1(AppearanceSettingsNavFragment appearanceSettingsNavFragment) {
        super(0);
        this.this$0 = appearanceSettingsNavFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.setWallpaperActivity.launch("image/*");
    }
}
