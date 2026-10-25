package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
public final class SlideDistanceProvider implements VisibilityAnimatorProvider {
    private static final int DEFAULT_DISTANCE = -1;
    private int slideDistance = -1;
    private int slideEdge;

    @Retention(RetentionPolicy.SOURCE)
    public @interface GravityFlag {
    }

    public SlideDistanceProvider(int i) {
        this.slideEdge = i;
    }

    public int getSlideEdge() {
        return this.slideEdge;
    }

    public void setSlideEdge(int i) {
        this.slideEdge = i;
    }

    public int getSlideDistance() {
        return this.slideDistance;
    }

    public void setSlideDistance(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Slide distance must be positive. If attempting to reverse the direction of the slide, use setSlideEdge(int) instead.");
        }
        this.slideDistance = i;
    }

    @Override // com.google.android.material.transition.platform.VisibilityAnimatorProvider
    public Animator createAppear(ViewGroup viewGroup, View view) {
        return createTranslationAppearAnimator(viewGroup, view, this.slideEdge, getSlideDistanceOrDefault(view.getContext()));
    }

    @Override // com.google.android.material.transition.platform.VisibilityAnimatorProvider
    public Animator createDisappear(ViewGroup viewGroup, View view) {
        return createTranslationDisappearAnimator(viewGroup, view, this.slideEdge, getSlideDistanceOrDefault(view.getContext()));
    }

    private int getSlideDistanceOrDefault(Context context) {
        int i = this.slideDistance;
        return i != -1 ? i : context.getResources().getDimensionPixelSize(R.dimen.mtrl_transition_shared_axis_slide_distance);
    }

    private static Animator createTranslationAppearAnimator(View view, View view2, int i, int i2) {
        float translationX = view2.getTranslationX();
        float translationY = view2.getTranslationY();
        if (i == 3) {
            return createTranslationXAnimator(view2, i2 + translationX, translationX, translationX);
        }
        if (i == 5) {
            return createTranslationXAnimator(view2, translationX - i2, translationX, translationX);
        }
        if (i == 48) {
            return createTranslationYAnimator(view2, translationY - i2, translationY, translationY);
        }
        if (i == 80) {
            return createTranslationYAnimator(view2, i2 + translationY, translationY, translationY);
        }
        if (i == 8388611) {
            return createTranslationXAnimator(view2, isRtl(view) ? i2 + translationX : translationX - i2, translationX, translationX);
        }
        if (i == 8388613) {
            return createTranslationXAnimator(view2, isRtl(view) ? translationX - i2 : i2 + translationX, translationX, translationX);
        }
        throw new IllegalArgumentException("Invalid slide direction: " + i);
    }

    private static Animator createTranslationDisappearAnimator(View view, View view2, int i, int i2) {
        float translationX = view2.getTranslationX();
        float translationY = view2.getTranslationY();
        if (i == 3) {
            return createTranslationXAnimator(view2, translationX, translationX - i2, translationX);
        }
        if (i == 5) {
            return createTranslationXAnimator(view2, translationX, i2 + translationX, translationX);
        }
        if (i == 48) {
            return createTranslationYAnimator(view2, translationY, i2 + translationY, translationY);
        }
        if (i == 80) {
            return createTranslationYAnimator(view2, translationY, translationY - i2, translationY);
        }
        if (i == 8388611) {
            return createTranslationXAnimator(view2, translationX, isRtl(view) ? translationX - i2 : i2 + translationX, translationX);
        }
        if (i == 8388613) {
            return createTranslationXAnimator(view2, translationX, isRtl(view) ? i2 + translationX : translationX - i2, translationX);
        }
        throw new IllegalArgumentException("Invalid slide direction: " + i);
    }

    private static Animator createTranslationXAnimator(View view, float f, float f2, float f3) {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_X, f, f2));
        objectAnimatorOfPropertyValuesHolder.addListener(new AnonymousClass1(view, f3));
        return objectAnimatorOfPropertyValuesHolder;
    }

    /* JADX INFO: renamed from: com.google.android.material.transition.platform.SlideDistanceProvider$1, reason: invalid class name */
    class AnonymousClass1 extends AnimatorListenerAdapter {
        final /* synthetic */ float val$originalTranslation;
        final /* synthetic */ View val$view;

        AnonymousClass1(View view, float f) {
            this.val$view = view;
            this.val$originalTranslation = f;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.val$view.setTranslationX(this.val$originalTranslation);
        }
    }

    private static Animator createTranslationYAnimator(View view, float f, float f2, float f3) {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_Y, f, f2));
        objectAnimatorOfPropertyValuesHolder.addListener(new AnonymousClass2(view, f3));
        return objectAnimatorOfPropertyValuesHolder;
    }

    /* JADX INFO: renamed from: com.google.android.material.transition.platform.SlideDistanceProvider$2, reason: invalid class name */
    class AnonymousClass2 extends AnimatorListenerAdapter {
        final /* synthetic */ float val$originalTranslation;
        final /* synthetic */ View val$view;

        AnonymousClass2(View view, float f) {
            this.val$view = view;
            this.val$originalTranslation = f;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.val$view.setTranslationY(this.val$originalTranslation);
        }
    }

    private static boolean isRtl(View view) {
        return ViewCompat.getLayoutDirection(view) == 1;
    }
}
