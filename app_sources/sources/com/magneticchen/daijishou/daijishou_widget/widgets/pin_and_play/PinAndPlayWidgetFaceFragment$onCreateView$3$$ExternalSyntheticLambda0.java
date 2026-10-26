package com.magneticchen.daijishou.daijishou_widget.widgets.pin_and_play;

import androidx.lifecycle.Observer;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class PinAndPlayWidgetFaceFragment$onCreateView$3$$ExternalSyntheticLambda0 implements Observer {
    public final /* synthetic */ PinAndPlayWidgetFaceFragment f$0;

    public /* synthetic */ PinAndPlayWidgetFaceFragment$onCreateView$3$$ExternalSyntheticLambda0(PinAndPlayWidgetFaceFragment pinAndPlayWidgetFaceFragment) {
        this.f$0 = pinAndPlayWidgetFaceFragment;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        try {
            PinAndPlayWidgetFaceFragment.invoke$lambda$2$lambda$1(this.f$0, (PlayableItemEntity) obj);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }
}
