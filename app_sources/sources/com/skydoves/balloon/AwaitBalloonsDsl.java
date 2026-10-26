package com.skydoves.balloon;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: AwaitBalloons.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J2\u0010\b\u001a\u00020\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H&J(\u0010\u0012\u001a\u00020\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH&J(\u0010\u0013\u001a\u00020\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH&J(\u0010\u0014\u001a\u00020\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH&J(\u0010\u0015\u001a\u00020\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH&J(\u0010\u0016\u001a\u00020\t*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH&J2\u0010\b\u001a\u00020\t*\u00020\f2\u0006\u0010\u0017\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0016J(\u0010\u0012\u001a\u00020\t*\u00020\f2\u0006\u0010\u0017\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0016J(\u0010\u0013\u001a\u00020\t*\u00020\f2\u0006\u0010\u0017\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0016J(\u0010\u0014\u001a\u00020\t*\u00020\f2\u0006\u0010\u0017\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0016J(\u0010\u0015\u001a\u00020\t*\u00020\f2\u0006\u0010\u0017\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0016J(\u0010\u0016\u001a\u00020\t*\u00020\f2\u0006\u0010\u0017\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0016R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/skydoves/balloon/AwaitBalloonsDsl;", "", "dismissSequentially", "", "getDismissSequentially", "()Z", "setDismissSequentially", "(Z)V", "atCenter", "", "Lcom/skydoves/balloon/Balloon;", "anchor", "Landroid/view/View;", "xOff", "", "yOff", "centerAlign", "Lcom/skydoves/balloon/BalloonCenterAlign;", "asDropDown", "alignTop", "alignStart", "alignEnd", "alignBottom", "balloon", "balloon_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface AwaitBalloonsDsl {
    void alignBottom(View view, Balloon balloon, int i, int i2);

    void alignBottom(Balloon balloon, View view, int i, int i2);

    void alignEnd(View view, Balloon balloon, int i, int i2);

    void alignEnd(Balloon balloon, View view, int i, int i2);

    void alignStart(View view, Balloon balloon, int i, int i2);

    void alignStart(Balloon balloon, View view, int i, int i2);

    void alignTop(View view, Balloon balloon, int i, int i2);

    void alignTop(Balloon balloon, View view, int i, int i2);

    void asDropDown(View view, Balloon balloon, int i, int i2);

    void asDropDown(Balloon balloon, View view, int i, int i2);

    void atCenter(View view, Balloon balloon, int i, int i2, BalloonCenterAlign balloonCenterAlign);

    void atCenter(Balloon balloon, View view, int i, int i2, BalloonCenterAlign balloonCenterAlign);

    boolean getDismissSequentially();

    void setDismissSequentially(boolean z);

    /* INFO: compiled from: AwaitBalloons.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void atCenter$default(AwaitBalloonsDsl awaitBalloonsDsl, Balloon balloon, View view, int i, int i2, BalloonCenterAlign balloonCenterAlign, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: atCenter");
            }
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = 0;
            }
            if ((i3 & 8) != 0) {
                balloonCenterAlign = BalloonCenterAlign.TOP;
            }
            awaitBalloonsDsl.atCenter(balloon, view, i, i2, balloonCenterAlign);
        }

        public static /* synthetic */ void asDropDown$default(AwaitBalloonsDsl awaitBalloonsDsl, Balloon balloon, View view, int i, int i2, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: asDropDown");
            }
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = 0;
            }
            awaitBalloonsDsl.asDropDown(balloon, view, i, i2);
        }

        public static /* synthetic */ void alignTop$default(AwaitBalloonsDsl awaitBalloonsDsl, Balloon balloon, View view, int i, int i2, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: alignTop");
            }
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = 0;
            }
            awaitBalloonsDsl.alignTop(balloon, view, i, i2);
        }

        public static /* synthetic */ void alignStart$default(AwaitBalloonsDsl awaitBalloonsDsl, Balloon balloon, View view, int i, int i2, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: alignStart");
            }
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = 0;
            }
            awaitBalloonsDsl.alignStart(balloon, view, i, i2);
        }

        public static /* synthetic */ void alignEnd$default(AwaitBalloonsDsl awaitBalloonsDsl, Balloon balloon, View view, int i, int i2, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: alignEnd");
            }
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = 0;
            }
            awaitBalloonsDsl.alignEnd(balloon, view, i, i2);
        }

        public static /* synthetic */ void alignBottom$default(AwaitBalloonsDsl awaitBalloonsDsl, Balloon balloon, View view, int i, int i2, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: alignBottom");
            }
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = 0;
            }
            awaitBalloonsDsl.alignBottom(balloon, view, i, i2);
        }

        public static /* synthetic */ void atCenter$default(AwaitBalloonsDsl awaitBalloonsDsl, View view, Balloon balloon, int i, int i2, BalloonCenterAlign balloonCenterAlign, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: atCenter");
            }
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = 0;
            }
            if ((i3 & 8) != 0) {
                balloonCenterAlign = BalloonCenterAlign.TOP;
            }
            awaitBalloonsDsl.atCenter(view, balloon, i, i2, balloonCenterAlign);
        }

        public static void atCenter(AwaitBalloonsDsl awaitBalloonsDsl, View receiver, Balloon balloon, int i, int i2, BalloonCenterAlign centerAlign) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            Intrinsics.checkNotNullParameter(balloon, "balloon");
            Intrinsics.checkNotNullParameter(centerAlign, "centerAlign");
            awaitBalloonsDsl.atCenter(balloon, receiver, i, i2, centerAlign);
        }

        public static /* synthetic */ void asDropDown$default(AwaitBalloonsDsl awaitBalloonsDsl, View view, Balloon balloon, int i, int i2, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: asDropDown");
            }
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = 0;
            }
            awaitBalloonsDsl.asDropDown(view, balloon, i, i2);
        }

        public static void asDropDown(AwaitBalloonsDsl awaitBalloonsDsl, View receiver, Balloon balloon, int i, int i2) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            Intrinsics.checkNotNullParameter(balloon, "balloon");
            awaitBalloonsDsl.asDropDown(balloon, receiver, i, i2);
        }

        public static /* synthetic */ void alignTop$default(AwaitBalloonsDsl awaitBalloonsDsl, View view, Balloon balloon, int i, int i2, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: alignTop");
            }
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = 0;
            }
            awaitBalloonsDsl.alignTop(view, balloon, i, i2);
        }

        public static void alignTop(AwaitBalloonsDsl awaitBalloonsDsl, View receiver, Balloon balloon, int i, int i2) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            Intrinsics.checkNotNullParameter(balloon, "balloon");
            awaitBalloonsDsl.alignTop(balloon, receiver, i, i2);
        }

        public static /* synthetic */ void alignStart$default(AwaitBalloonsDsl awaitBalloonsDsl, View view, Balloon balloon, int i, int i2, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: alignStart");
            }
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = 0;
            }
            awaitBalloonsDsl.alignStart(view, balloon, i, i2);
        }

        public static void alignStart(AwaitBalloonsDsl awaitBalloonsDsl, View receiver, Balloon balloon, int i, int i2) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            Intrinsics.checkNotNullParameter(balloon, "balloon");
            awaitBalloonsDsl.alignStart(balloon, receiver, i, i2);
        }

        public static /* synthetic */ void alignEnd$default(AwaitBalloonsDsl awaitBalloonsDsl, View view, Balloon balloon, int i, int i2, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: alignEnd");
            }
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = 0;
            }
            awaitBalloonsDsl.alignEnd(view, balloon, i, i2);
        }

        public static void alignEnd(AwaitBalloonsDsl awaitBalloonsDsl, View receiver, Balloon balloon, int i, int i2) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            Intrinsics.checkNotNullParameter(balloon, "balloon");
            awaitBalloonsDsl.alignEnd(balloon, receiver, i, i2);
        }

        public static /* synthetic */ void alignBottom$default(AwaitBalloonsDsl awaitBalloonsDsl, View view, Balloon balloon, int i, int i2, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: alignBottom");
            }
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = 0;
            }
            awaitBalloonsDsl.alignBottom(view, balloon, i, i2);
        }

        public static void alignBottom(AwaitBalloonsDsl awaitBalloonsDsl, View receiver, Balloon balloon, int i, int i2) {
            Intrinsics.checkNotNullParameter(receiver, "$receiver");
            Intrinsics.checkNotNullParameter(balloon, "balloon");
            awaitBalloonsDsl.alignBottom(balloon, receiver, i, i2);
        }
    }
}
