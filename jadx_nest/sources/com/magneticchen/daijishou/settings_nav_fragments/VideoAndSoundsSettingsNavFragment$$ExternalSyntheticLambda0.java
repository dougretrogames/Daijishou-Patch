package com.magneticchen.daijishou.settings_nav_fragments;

import android.net.Uri;
import androidx.activity.result.ActivityResultCallback;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class VideoAndSoundsSettingsNavFragment$$ExternalSyntheticLambda0 implements ActivityResultCallback {
    public final /* synthetic */ VideoAndSoundsSettingsNavFragment f$0;

    public /* synthetic */ VideoAndSoundsSettingsNavFragment$$ExternalSyntheticLambda0(VideoAndSoundsSettingsNavFragment videoAndSoundsSettingsNavFragment) {
        this.f$0 = videoAndSoundsSettingsNavFragment;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public final void onActivityResult(Object obj) {
        try {
            VideoAndSoundsSettingsNavFragment.setBackgroundMusicActivity$lambda$0(this.f$0, (Uri) obj);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
