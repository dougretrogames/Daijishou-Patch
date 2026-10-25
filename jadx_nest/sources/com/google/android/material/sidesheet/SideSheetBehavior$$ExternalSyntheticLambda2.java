package com.google.android.material.sidesheet;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class SideSheetBehavior$$ExternalSyntheticLambda2 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ SideSheetBehavior f$0;
    public final /* synthetic */ ViewGroup.MarginLayoutParams f$1;
    public final /* synthetic */ int f$2;
    public final /* synthetic */ View f$3;

    public /* synthetic */ SideSheetBehavior$$ExternalSyntheticLambda2(SideSheetBehavior sideSheetBehavior, ViewGroup.MarginLayoutParams marginLayoutParams, int i, View view) {
        this.f$0 = sideSheetBehavior;
        this.f$1 = marginLayoutParams;
        this.f$2 = i;
        this.f$3 = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f$0.m3326xc3af8fb4(this.f$1, this.f$2, this.f$3, valueAnimator);
    }
}
