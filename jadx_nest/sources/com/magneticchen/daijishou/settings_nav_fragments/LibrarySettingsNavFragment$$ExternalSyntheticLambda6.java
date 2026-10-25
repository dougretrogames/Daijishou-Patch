package com.magneticchen.daijishou.settings_nav_fragments;

import android.net.Uri;
import androidx.activity.result.ActivityResultCallback;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class LibrarySettingsNavFragment$$ExternalSyntheticLambda6 implements ActivityResultCallback {
    public final /* synthetic */ LibrarySettingsNavFragment f$0;

    public /* synthetic */ LibrarySettingsNavFragment$$ExternalSyntheticLambda6(LibrarySettingsNavFragment librarySettingsNavFragment) {
        this.f$0 = librarySettingsNavFragment;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public final void onActivityResult(Object obj) {
        try {
            LibrarySettingsNavFragment.importPlatformActivity$lambda$1(this.f$0, (Uri) obj);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
