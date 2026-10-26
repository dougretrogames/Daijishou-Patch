package com.magneticchen.daijishou.settings_nav_fragments;

import android.net.Uri;
import androidx.activity.result.ActivityResultCallback;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class LibrarySettingsNavFragment$$ExternalSyntheticLambda5 implements ActivityResultCallback {
    public final /* synthetic */ LibrarySettingsNavFragment f$0;

    public /* synthetic */ LibrarySettingsNavFragment$$ExternalSyntheticLambda5(LibrarySettingsNavFragment librarySettingsNavFragment) {
        this.f$0 = librarySettingsNavFragment;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public final void onActivityResult(Object obj) {
        try {
            LibrarySettingsNavFragment.selectPegasusConfigActivity$lambda$0(this.f$0, (Uri) obj);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
