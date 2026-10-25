package androidx.core.view.insets;

import android.animation.ValueAnimator;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Protection$$ExternalSyntheticLambda1 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ Protection f$0;

    public /* synthetic */ Protection$$ExternalSyntheticLambda1(Protection protection) {
        this.f$0 = protection;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f$0.m3173lambda$animateAlpha$0$androidxcoreviewinsetsProtection(valueAnimator);
    }
}
