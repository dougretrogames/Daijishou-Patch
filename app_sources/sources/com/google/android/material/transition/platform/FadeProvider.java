package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;

/* INFO: loaded from: classes3.dex */
public final class FadeProvider implements VisibilityAnimatorProvider {
    private float incomingEndThreshold = 1.0f;

    public float getIncomingEndThreshold() {
        return this.incomingEndThreshold;
    }

    public void setIncomingEndThreshold(float f) {
        this.incomingEndThreshold = f;
    }

    @Override // com.google.android.material.transition.platform.VisibilityAnimatorProvider
    public Animator createAppear(ViewGroup viewGroup, View view) {
        float alpha = view.getAlpha() == 0.0f ? 1.0f : view.getAlpha();
        return createFadeAnimator(view, 0.0f, alpha, 0.0f, this.incomingEndThreshold, alpha);
    }

    @Override // com.google.android.material.transition.platform.VisibilityAnimatorProvider
    public Animator createDisappear(ViewGroup viewGroup, View view) {
        float alpha = view.getAlpha() == 0.0f ? 1.0f : view.getAlpha();
        return createFadeAnimator(view, alpha, 0.0f, 0.0f, 1.0f, alpha);
    }

    private static Animator createFadeAnimator(View view, float f, float f2, float f3, float f4, float f5) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new AnonymousClass1(view, f, f2, f3, f4));
        valueAnimatorOfFloat.addListener(new AnonymousClass2(view, f5));
        return valueAnimatorOfFloat;
    }

    /* INFO: renamed from: com.google.android.material.transition.platform.FadeProvider$1, reason: invalid class name */
    class AnonymousClass1 implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ float val$endFraction;
        final /* synthetic */ float val$endValue;
        final /* synthetic */ float val$startFraction;
        final /* synthetic */ float val$startValue;
        final /* synthetic */ View val$view;

        AnonymousClass1(View view, float f, float f2, float f3, float f4) {
            this.val$view = view;
            this.val$startValue = f;
            this.val$endValue = f2;
            this.val$startFraction = f3;
            this.val$endFraction = f4;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.val$view.setAlpha(TransitionUtils.lerp(this.val$startValue, this.val$endValue, this.val$startFraction, this.val$endFraction, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
        }
    }

    /* INFO: renamed from: com.google.android.material.transition.platform.FadeProvider$2, reason: invalid class name */
    class AnonymousClass2 extends AnimatorListenerAdapter {
        final /* synthetic */ float val$originalAlpha;
        final /* synthetic */ View val$view;

        AnonymousClass2(View view, float f) {
            this.val$view = view;
            this.val$originalAlpha = f;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.val$view.setAlpha(this.val$originalAlpha);
        }
    }
}
