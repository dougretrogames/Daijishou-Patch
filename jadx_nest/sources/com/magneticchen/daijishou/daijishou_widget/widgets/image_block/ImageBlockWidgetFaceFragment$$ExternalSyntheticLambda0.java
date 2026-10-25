package com.magneticchen.daijishou.daijishou_widget.widgets.image_block;

import android.net.Uri;
import androidx.activity.result.ActivityResultCallback;
import java.io.FileNotFoundException;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class ImageBlockWidgetFaceFragment$$ExternalSyntheticLambda0 implements ActivityResultCallback {
    public final /* synthetic */ ImageBlockWidgetFaceFragment f$0;

    public /* synthetic */ ImageBlockWidgetFaceFragment$$ExternalSyntheticLambda0(ImageBlockWidgetFaceFragment imageBlockWidgetFaceFragment) {
        this.f$0 = imageBlockWidgetFaceFragment;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public final void onActivityResult(Object obj) {
        try {
            ImageBlockWidgetFaceFragment.selectImageActivity$lambda$2(this.f$0, (Uri) obj);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
