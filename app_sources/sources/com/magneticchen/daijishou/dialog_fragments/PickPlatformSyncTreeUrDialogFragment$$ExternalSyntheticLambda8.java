package com.magneticchen.daijishou.dialog_fragments;

import android.net.Uri;
import androidx.activity.result.ActivityResultCallback;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class PickPlatformSyncTreeUrDialogFragment$$ExternalSyntheticLambda8 implements ActivityResultCallback {
    public final /* synthetic */ PickPlatformSyncTreeUrDialogFragment f$0;

    public /* synthetic */ PickPlatformSyncTreeUrDialogFragment$$ExternalSyntheticLambda8(PickPlatformSyncTreeUrDialogFragment pickPlatformSyncTreeUrDialogFragment) {
        this.f$0 = pickPlatformSyncTreeUrDialogFragment;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public final void onActivityResult(Object obj) {
        try {
            PickPlatformSyncTreeUrDialogFragment.selectSyncTreeUriActivity$lambda$0(this.f$0, (Uri) obj);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
