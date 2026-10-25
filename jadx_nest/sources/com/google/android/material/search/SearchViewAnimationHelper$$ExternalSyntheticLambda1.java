package com.google.android.material.search;

import android.animation.ValueAnimator;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class SearchViewAnimationHelper$$ExternalSyntheticLambda1 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ DrawerArrowDrawable f$0;

    public /* synthetic */ SearchViewAnimationHelper$$ExternalSyntheticLambda1(DrawerArrowDrawable drawerArrowDrawable) {
        this.f$0 = drawerArrowDrawable;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f$0.setProgress(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
