package androidx.transition;

import androidx.dynamicanimation.animation.DynamicAnimation;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class Transition$SeekController$$ExternalSyntheticLambda0 implements DynamicAnimation.OnAnimationEndListener {
    public final /* synthetic */ Transition.SeekController f$0;

    public /* synthetic */ Transition$SeekController$$ExternalSyntheticLambda0(Transition.SeekController seekController) {
        this.f$0 = seekController;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
    public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z, float f, float f2) {
        this.f$0.m3239x76b2d240(dynamicAnimation, z, f, f2);
    }
}
