package com.magneticchen.daijishou.settings_nav_fragments;

import android.net.Uri;
import androidx.activity.result.ActivityResultCallback;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class AppearanceSettingsNavFragment$$ExternalSyntheticLambda2 implements ActivityResultCallback {
    public final /* synthetic */ AppearanceSettingsNavFragment f$0;

    public /* synthetic */ AppearanceSettingsNavFragment$$ExternalSyntheticLambda2(AppearanceSettingsNavFragment appearanceSettingsNavFragment) {
        this.f$0 = appearanceSettingsNavFragment;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public final void onActivityResult(Object obj) {
        try {
            AppearanceSettingsNavFragment.setWallpaperActivity$lambda$0(this.f$0, (Uri) obj);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
