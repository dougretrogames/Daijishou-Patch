package com.magneticchen.daijishou.daijishou_widget.widgets.app_shortcut;

import android.net.Uri;
import androidx.activity.result.ActivityResultCallback;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class AppShortcutWidgetFaceFragment$$ExternalSyntheticLambda0 implements ActivityResultCallback {
    public final /* synthetic */ AppShortcutWidgetFaceFragment f$0;

    public /* synthetic */ AppShortcutWidgetFaceFragment$$ExternalSyntheticLambda0(AppShortcutWidgetFaceFragment appShortcutWidgetFaceFragment) {
        this.f$0 = appShortcutWidgetFaceFragment;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public final void onActivityResult(Object obj) {
        try {
            AppShortcutWidgetFaceFragment.selectImageActivity$lambda$1(this.f$0, (Uri) obj);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
