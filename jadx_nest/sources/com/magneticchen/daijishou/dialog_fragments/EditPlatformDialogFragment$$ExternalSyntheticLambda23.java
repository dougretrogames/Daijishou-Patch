package com.magneticchen.daijishou.dialog_fragments;

import android.net.Uri;
import androidx.activity.result.ActivityResultCallback;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class EditPlatformDialogFragment$$ExternalSyntheticLambda23 implements ActivityResultCallback {
    public final /* synthetic */ EditPlatformDialogFragment f$0;

    public /* synthetic */ EditPlatformDialogFragment$$ExternalSyntheticLambda23(EditPlatformDialogFragment editPlatformDialogFragment) {
        this.f$0 = editPlatformDialogFragment;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public final void onActivityResult(Object obj) {
        try {
            EditPlatformDialogFragment.selectWallpaperActivity$lambda$10(this.f$0, (Uri) obj);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
