package com.skydoves.balloon.extensions;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewAnimationUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewExtension.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0000\u001a\u0014\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0001\u001a(\u0010\r\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u000e\b\u0004\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0081\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0010"}, d2 = {"visible", "", "Landroid/view/View;", "shouldVisible", "", "getViewPointOnScreen", "Landroid/graphics/Point;", "getStatusBarHeight", "", "isStatusBarVisible", "circularRevealed", "circularDuration", "", "circularUnRevealed", "doAfterFinish", "Lkotlin/Function0;", "balloon_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ViewExtensionKt {
    public static final /* synthetic */ void visible(View view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setVisibility(z ? 0 : 8);
    }

    public static final /* synthetic */ Point getViewPointOnScreen(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        int[] iArr = {0, 0};
        view.getLocationOnScreen(iArr);
        return new Point(iArr[0], iArr[1]);
    }

    public static final /* synthetic */ int getStatusBarHeight(View view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Rect rect = new Rect();
        Context context = view.getContext();
        if (!(context instanceof Activity) || !z) {
            return 0;
        }
        ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect.top;
    }

    public static final /* synthetic */ void circularRevealed(View view, long j) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setVisibility(4);
        view.post(new ViewExtensionKt$$ExternalSyntheticLambda0(view, j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void circularRevealed$lambda$1(View view, long j) {
        if (view.isAttachedToWindow()) {
            view.setVisibility(0);
            Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view, (view.getLeft() + view.getRight()) / 2, (view.getTop() + view.getBottom()) / 2, 0.0f, Math.max(view.getWidth(), view.getHeight()));
            animatorCreateCircularReveal.setDuration(j);
            animatorCreateCircularReveal.start();
        }
    }

    /* JADX INFO: renamed from: com.skydoves.balloon.extensions.ViewExtensionKt$circularUnRevealed$1, reason: invalid class name */
    /* JADX INFO: compiled from: ViewExtension.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class AnonymousClass1 implements Runnable {
        final /* synthetic */ long $circularDuration;
        final /* synthetic */ Function0<Unit> $doAfterFinish;
        final /* synthetic */ View $this_circularUnRevealed;

        public AnonymousClass1(View view, long j, Function0<Unit> function0) {
            this.$this_circularUnRevealed = view;
            this.$circularDuration = j;
            this.$doAfterFinish = function0;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.$this_circularUnRevealed.isAttachedToWindow()) {
                View view = this.$this_circularUnRevealed;
                Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view, (view.getLeft() + this.$this_circularUnRevealed.getRight()) / 2, (this.$this_circularUnRevealed.getTop() + this.$this_circularUnRevealed.getBottom()) / 2, Math.max(this.$this_circularUnRevealed.getWidth(), this.$this_circularUnRevealed.getHeight()), 0.0f);
                animatorCreateCircularReveal.setDuration(this.$circularDuration);
                animatorCreateCircularReveal.start();
                animatorCreateCircularReveal.addListener(new AnonymousClass2(this.$doAfterFinish));
            }
        }

        /* JADX INFO: renamed from: com.skydoves.balloon.extensions.ViewExtensionKt$circularUnRevealed$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: ViewExtension.kt */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/skydoves/balloon/extensions/ViewExtensionKt$circularUnRevealed$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "balloon_release"}, k = 1, mv = {2, 0, 0}, xi = 176)
        public static final class AnonymousClass2 extends AnimatorListenerAdapter {
            final /* synthetic */ Function0<Unit> $doAfterFinish;

            public AnonymousClass2(Function0<Unit> function0) {
                this.$doAfterFinish = function0;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                super.onAnimationEnd(animation);
                this.$doAfterFinish.invoke();
            }
        }
    }

    public static final /* synthetic */ void circularUnRevealed(View view, long j, Function0<Unit> doAfterFinish) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(doAfterFinish, "doAfterFinish");
        view.post(new AnonymousClass1(view, j, doAfterFinish));
    }
}
