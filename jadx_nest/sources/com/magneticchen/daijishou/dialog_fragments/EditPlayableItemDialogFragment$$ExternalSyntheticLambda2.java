package com.magneticchen.daijishou.dialog_fragments;

import android.net.Uri;
import androidx.activity.result.ActivityResultCallback;
import java.io.IOException;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class EditPlayableItemDialogFragment$$ExternalSyntheticLambda2 implements ActivityResultCallback {
    public final /* synthetic */ EditPlayableItemDialogFragment f$0;

    public /* synthetic */ EditPlayableItemDialogFragment$$ExternalSyntheticLambda2(EditPlayableItemDialogFragment editPlayableItemDialogFragment) {
        this.f$0 = editPlayableItemDialogFragment;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public final void onActivityResult(Object obj) {
        try {
            EditPlayableItemDialogFragment.setBoxArtActivity$lambda$0(this.f$0, (Uri) obj);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
