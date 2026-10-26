package com.google.android.material.navigation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.view.View;
import androidx.drawerlayout.widget.DrawerLayout;

/* INFO: loaded from: classes3.dex */
public class DrawerLayoutUtils {
    private static final int DEFAULT_SCRIM_COLOR = -1728053248;
    private static final int DEFAULT_SCRIM_ALPHA = Color.alpha(DEFAULT_SCRIM_COLOR);

    private DrawerLayoutUtils() {
    }

    public static ValueAnimator.AnimatorUpdateListener getScrimCloseAnimatorUpdateListener(DrawerLayout drawerLayout) {
        return new DrawerLayoutUtils$$ExternalSyntheticLambda0(drawerLayout);
    }

    /* INFO: renamed from: com.google.android.material.navigation.DrawerLayoutUtils$1, reason: invalid class name */
    class AnonymousClass1 extends AnimatorListenerAdapter {
        final /* synthetic */ DrawerLayout val$drawerLayout;
        final /* synthetic */ View val$drawerView;

        AnonymousClass1(DrawerLayout drawerLayout, View view) {
            this.val$drawerLayout = drawerLayout;
            this.val$drawerView = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.val$drawerLayout.closeDrawer(this.val$drawerView, false);
            this.val$drawerLayout.setScrimColor(DrawerLayoutUtils.DEFAULT_SCRIM_COLOR);
        }
    }

    public static Animator.AnimatorListener getScrimCloseAnimatorListener(DrawerLayout drawerLayout, View view) {
        return new AnonymousClass1(drawerLayout, view);
    }
}
