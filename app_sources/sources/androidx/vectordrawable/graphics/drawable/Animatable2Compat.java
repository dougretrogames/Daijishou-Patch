package androidx.vectordrawable.graphics.drawable;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.Drawable;

/* INFO: loaded from: classes3.dex */
public interface Animatable2Compat extends Animatable {
    void clearAnimationCallbacks();

    void registerAnimationCallback(AnimationCallback animationCallback);

    boolean unregisterAnimationCallback(AnimationCallback animationCallback);

    public static abstract class AnimationCallback {
        Animatable2.AnimationCallback mPlatformCallback;

        public void onAnimationEnd(Drawable drawable) {
        }

        public void onAnimationStart(Drawable drawable) {
        }

        /* INFO: renamed from: androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback$1, reason: invalid class name */
        class AnonymousClass1 extends Animatable2.AnimationCallback {
            AnonymousClass1() {
            }

            @Override // android.graphics.drawable.Animatable2.AnimationCallback
            public void onAnimationStart(Drawable drawable) {
                AnimationCallback.this.onAnimationStart(drawable);
            }

            @Override // android.graphics.drawable.Animatable2.AnimationCallback
            public void onAnimationEnd(Drawable drawable) {
                AnimationCallback.this.onAnimationEnd(drawable);
            }
        }

        Animatable2.AnimationCallback getPlatformCallback() {
            if (this.mPlatformCallback == null) {
                this.mPlatformCallback = new AnonymousClass1();
            }
            return this.mPlatformCallback;
        }
    }
}
