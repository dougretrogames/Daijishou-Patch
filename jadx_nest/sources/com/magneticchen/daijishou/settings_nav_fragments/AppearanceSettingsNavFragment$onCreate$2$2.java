package com.magneticchen.daijishou.settings_nav_fragments;

import android.widget.Toast;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.application_data.IntPreference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: AppearanceSettingsNavFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class AppearanceSettingsNavFragment$onCreate$2$2 extends Lambda<Unit> implements Function0<Unit> {
    final /* synthetic */ AppearanceSettingsNavFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppearanceSettingsNavFragment$onCreate$2$2(AppearanceSettingsNavFragment appearanceSettingsNavFragment) {
        super(0);
        this.this$0 = appearanceSettingsNavFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.getDefaultSharedPreferences().edit().putInt(IntPreference.WALLPAPER_HASH_CODE.getKey(), IntPreference.WALLPAPER_HASH_CODE.getDefaultValue()).apply();
        this.this$0.getDefaultSharedPreferences().edit().putInt(IntPreference.WALLPAPER_COLOR_THEME.getKey(), IntPreference.WALLPAPER_COLOR_THEME.getDefaultValue()).apply();
        this.this$0.getDefaultSharedPreferences().edit().putInt(IntPreference.WALLPAPER_COLOR_ICON_THEME.getKey(), IntPreference.WALLPAPER_COLOR_ICON_THEME.getDefaultValue()).apply();
        this.this$0.getDefaultSharedPreferences().edit().putInt(IntPreference.WALLPAPER_COLOR_ON_THEME.getKey(), IntPreference.WALLPAPER_COLOR_ON_THEME.getDefaultValue()).apply();
        Toast.makeText(this.this$0.requireContext(), this.this$0.getString(R.string.wallpaper_set), 0).show();
    }
}
