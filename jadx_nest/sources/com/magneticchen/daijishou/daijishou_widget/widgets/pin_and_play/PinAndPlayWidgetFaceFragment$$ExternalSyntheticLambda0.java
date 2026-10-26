package com.magneticchen.daijishou.daijishou_widget.widgets.pin_and_play;

import android.net.Uri;
import androidx.activity.result.ActivityResultCallback;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class PinAndPlayWidgetFaceFragment$$ExternalSyntheticLambda0 implements ActivityResultCallback {
    public final /* synthetic */ PinAndPlayWidgetFaceFragment f$0;

    public /* synthetic */ PinAndPlayWidgetFaceFragment$$ExternalSyntheticLambda0(PinAndPlayWidgetFaceFragment pinAndPlayWidgetFaceFragment) {
        this.f$0 = pinAndPlayWidgetFaceFragment;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public final void onActivityResult(Object obj) {
        try {
            PinAndPlayWidgetFaceFragment.selectImageActivity$lambda$1(this.f$0, (Uri) obj);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
