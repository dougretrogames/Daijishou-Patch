package com.skydoves.balloon;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewAnimationUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: ViewExtension.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public final class Balloon$dismiss$$inlined$circularUnRevealed$1 implements Runnable {
    final /* synthetic */ long $circularDuration;
    final /* synthetic */ Function0 $dismissWindow$inlined;
    final /* synthetic */ View $this_circularUnRevealed;

    public Balloon$dismiss$$inlined$circularUnRevealed$1(View view, long j, Function0 function0) {
        this.$this_circularUnRevealed = view;
        this.$circularDuration = j;
        this.$dismissWindow$inlined = function0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.$this_circularUnRevealed.isAttachedToWindow()) {
            View view = this.$this_circularUnRevealed;
            Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view, (view.getLeft() + this.$this_circularUnRevealed.getRight()) / 2, (this.$this_circularUnRevealed.getTop() + this.$this_circularUnRevealed.getBottom()) / 2, Math.max(this.$this_circularUnRevealed.getWidth(), this.$this_circularUnRevealed.getHeight()), 0.0f);
            animatorCreateCircularReveal.setDuration(this.$circularDuration);
            animatorCreateCircularReveal.start();
            animatorCreateCircularReveal.addListener(new AnonymousClass1(this.$dismissWindow$inlined));
        }
    }

    /* INFO: renamed from: com.skydoves.balloon.Balloon$dismiss$$inlined$circularUnRevealed$1$1, reason: invalid class name */
    /* INFO: compiled from: ViewExtension.kt */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, d2 = {"com/skydoves/balloon/extensions/ViewExtensionKt$circularUnRevealed$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "balloon_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass1 extends AnimatorListenerAdapter {
        final /* synthetic */ Function0 $dismissWindow$inlined;

        public AnonymousClass1(Function0 function0) {
            this.$dismissWindow$inlined = function0;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            super.onAnimationEnd(animation);
            this.$dismissWindow$inlined.invoke();
        }
    }
}
