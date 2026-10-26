package com.magneticchen.daijishou.dialog_fragments;

import android.net.Uri;
import androidx.activity.result.ActivityResultCallback;
import java.io.IOException;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class EditPlayableItemDialogFragment$$ExternalSyntheticLambda4 implements ActivityResultCallback {
    public final /* synthetic */ EditPlayableItemDialogFragment f$0;

    public /* synthetic */ EditPlayableItemDialogFragment$$ExternalSyntheticLambda4(EditPlayableItemDialogFragment editPlayableItemDialogFragment) {
        this.f$0 = editPlayableItemDialogFragment;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public final void onActivityResult(Object obj) {
        try {
            EditPlayableItemDialogFragment.setTitleActivity$lambda$2(this.f$0, (Uri) obj);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
