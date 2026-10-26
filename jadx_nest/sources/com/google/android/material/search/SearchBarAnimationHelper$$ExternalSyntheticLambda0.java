package com.google.android.material.search;

import android.animation.ValueAnimator;
import android.view.View;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class SearchBarAnimationHelper$$ExternalSyntheticLambda0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ View f$0;

    public /* synthetic */ SearchBarAnimationHelper$$ExternalSyntheticLambda0(View view) {
        this.f$0 = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f$0.setAlpha(0.0f);
    }
}
