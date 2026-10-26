package com.google.android.material.navigation;

import android.animation.ValueAnimator;
import androidx.core.graphics.ColorUtils;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.animation.AnimationUtils;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class DrawerLayoutUtils$$ExternalSyntheticLambda0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ DrawerLayout f$0;

    public /* synthetic */ DrawerLayoutUtils$$ExternalSyntheticLambda0(DrawerLayout drawerLayout) {
        this.f$0 = drawerLayout;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f$0.setScrimColor(ColorUtils.setAlphaComponent(DrawerLayoutUtils.DEFAULT_SCRIM_COLOR, AnimationUtils.lerp(DrawerLayoutUtils.DEFAULT_SCRIM_ALPHA, 0, valueAnimator.getAnimatedFraction())));
    }
}
