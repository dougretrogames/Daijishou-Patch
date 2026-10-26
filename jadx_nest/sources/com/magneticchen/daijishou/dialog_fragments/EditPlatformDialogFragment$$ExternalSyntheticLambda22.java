package com.magneticchen.daijishou.dialog_fragments;

import android.net.Uri;
import androidx.activity.result.ActivityResultCallback;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class EditPlatformDialogFragment$$ExternalSyntheticLambda22 implements ActivityResultCallback {
    public final /* synthetic */ EditPlatformDialogFragment f$0;

    public /* synthetic */ EditPlatformDialogFragment$$ExternalSyntheticLambda22(EditPlatformDialogFragment editPlatformDialogFragment) {
        this.f$0 = editPlatformDialogFragment;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public final void onActivityResult(Object obj) {
        try {
            EditPlatformDialogFragment.importXMLFileFromUriActivity$lambda$9(this.f$0, (Uri) obj);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
