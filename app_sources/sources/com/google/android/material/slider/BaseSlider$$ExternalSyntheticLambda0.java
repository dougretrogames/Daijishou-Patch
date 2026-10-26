package com.google.android.material.slider;

import android.view.ViewTreeObserver;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class BaseSlider$$ExternalSyntheticLambda0 implements ViewTreeObserver.OnScrollChangedListener {
    public final /* synthetic */ BaseSlider f$0;

    public /* synthetic */ BaseSlider$$ExternalSyntheticLambda0(BaseSlider baseSlider) {
        this.f$0 = baseSlider;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        this.f$0.updateLabels();
    }
}
