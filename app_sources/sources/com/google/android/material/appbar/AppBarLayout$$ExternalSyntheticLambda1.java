package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import com.google.android.material.shape.MaterialShapeDrawable;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class AppBarLayout$$ExternalSyntheticLambda1 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ AppBarLayout f$0;
    public final /* synthetic */ MaterialShapeDrawable f$1;

    public /* synthetic */ AppBarLayout$$ExternalSyntheticLambda1(AppBarLayout appBarLayout, MaterialShapeDrawable materialShapeDrawable) {
        this.f$0 = appBarLayout;
        this.f$1 = materialShapeDrawable;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f$0.m3256x84b6053(this.f$1, valueAnimator);
    }
}
