package com.google.android.material.search;

import android.animation.ValueAnimator;
import com.google.android.material.internal.FadeThroughDrawable;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class SearchViewAnimationHelper$$ExternalSyntheticLambda3 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ FadeThroughDrawable f$0;

    public /* synthetic */ SearchViewAnimationHelper$$ExternalSyntheticLambda3(FadeThroughDrawable fadeThroughDrawable) {
        this.f$0 = fadeThroughDrawable;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f$0.setProgress(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
