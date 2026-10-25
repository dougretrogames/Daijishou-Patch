package androidx.leanback.app;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import androidx.leanback.media.PlaybackGlue;
import androidx.leanback.widget.DetailsParallax;
import androidx.leanback.widget.Parallax;
import androidx.leanback.widget.ParallaxEffect;
import androidx.leanback.widget.ParallaxTarget;

/* JADX INFO: loaded from: classes.dex */
final class DetailsBackgroundVideoHelper {
    private static final long BACKGROUND_CROSS_FADE_DURATION = 500;
    private static final long CROSSFADE_DELAY = 1000;
    static final int INITIAL = 0;
    static final int NO_VIDEO = 2;
    static final int PLAY_VIDEO = 1;
    ValueAnimator mBackgroundAnimator;
    Drawable mBackgroundDrawable;
    private final DetailsParallax mDetailsParallax;
    private ParallaxEffect mParallaxEffect;
    private PlaybackGlue mPlaybackGlue;
    private int mCurrentState = 0;
    PlaybackControlStateCallback mControlStateCallback = new PlaybackControlStateCallback();
    private boolean mBackgroundDrawableVisible = true;

    DetailsBackgroundVideoHelper(PlaybackGlue playbackGlue, DetailsParallax detailsParallax, Drawable drawable) {
        this.mPlaybackGlue = playbackGlue;
        this.mDetailsParallax = detailsParallax;
        this.mBackgroundDrawable = drawable;
        drawable.setAlpha(255);
        startParallax();
    }

    void startParallax() {
        if (this.mParallaxEffect != null) {
            return;
        }
        Parallax.IntProperty overviewRowTop = this.mDetailsParallax.getOverviewRowTop();
        this.mParallaxEffect = this.mDetailsParallax.addEffect(overviewRowTop.atFraction(1.0f), overviewRowTop.atFraction(0.0f)).target(new AnonymousClass1());
        this.mDetailsParallax.updateValues();
    }

    /* JADX INFO: renamed from: androidx.leanback.app.DetailsBackgroundVideoHelper$1, reason: invalid class name */
    class AnonymousClass1 extends ParallaxTarget {
        AnonymousClass1() {
        }

        @Override // androidx.leanback.widget.ParallaxTarget
        public void update(float f) {
            if (f == 1.0f) {
                DetailsBackgroundVideoHelper.this.updateState(2);
            } else {
                DetailsBackgroundVideoHelper.this.updateState(1);
            }
        }
    }

    void stopParallax() {
        this.mDetailsParallax.removeEffect(this.mParallaxEffect);
    }

    boolean isVideoVisible() {
        return this.mCurrentState == 1;
    }

    void updateState(int i) {
        if (i == this.mCurrentState) {
            return;
        }
        this.mCurrentState = i;
        applyState();
    }

    private void applyState() {
        int i = this.mCurrentState;
        if (i != 1) {
            if (i != 2) {
                return;
            }
            crossFadeBackgroundToVideo(false);
            PlaybackGlue playbackGlue = this.mPlaybackGlue;
            if (playbackGlue != null) {
                playbackGlue.removePlayerCallback(this.mControlStateCallback);
                this.mPlaybackGlue.pause();
                return;
            }
            return;
        }
        PlaybackGlue playbackGlue2 = this.mPlaybackGlue;
        if (playbackGlue2 != null) {
            if (playbackGlue2.isPrepared()) {
                internalStartPlayback();
                return;
            } else {
                this.mPlaybackGlue.addPlayerCallback(this.mControlStateCallback);
                return;
            }
        }
        crossFadeBackgroundToVideo(false);
    }

    void setPlaybackGlue(PlaybackGlue playbackGlue) {
        PlaybackGlue playbackGlue2 = this.mPlaybackGlue;
        if (playbackGlue2 != null) {
            playbackGlue2.removePlayerCallback(this.mControlStateCallback);
        }
        this.mPlaybackGlue = playbackGlue;
        applyState();
    }

    void internalStartPlayback() {
        PlaybackGlue playbackGlue = this.mPlaybackGlue;
        if (playbackGlue != null) {
            playbackGlue.play();
        }
        this.mDetailsParallax.getRecyclerView().postDelayed(new AnonymousClass2(), 1000L);
    }

    /* JADX INFO: renamed from: androidx.leanback.app.DetailsBackgroundVideoHelper$2, reason: invalid class name */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DetailsBackgroundVideoHelper.this.crossFadeBackgroundToVideo(true);
        }
    }

    void crossFadeBackgroundToVideo(boolean z) {
        crossFadeBackgroundToVideo(z, false);
    }

    void crossFadeBackgroundToVideo(boolean z, boolean z2) {
        boolean z3 = !z;
        if (this.mBackgroundDrawableVisible == z3) {
            if (z2) {
                ValueAnimator valueAnimator = this.mBackgroundAnimator;
                if (valueAnimator != null) {
                    valueAnimator.cancel();
                    this.mBackgroundAnimator = null;
                }
                Drawable drawable = this.mBackgroundDrawable;
                if (drawable != null) {
                    drawable.setAlpha(z ? 0 : 255);
                    return;
                }
                return;
            }
            return;
        }
        this.mBackgroundDrawableVisible = z3;
        ValueAnimator valueAnimator2 = this.mBackgroundAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
            this.mBackgroundAnimator = null;
        }
        float f = z ? 1.0f : 0.0f;
        float f2 = z ? 0.0f : 1.0f;
        Drawable drawable2 = this.mBackgroundDrawable;
        if (drawable2 == null) {
            return;
        }
        if (z2) {
            drawable2.setAlpha(z ? 0 : 255);
            return;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, f2);
        this.mBackgroundAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(BACKGROUND_CROSS_FADE_DURATION);
        this.mBackgroundAnimator.addUpdateListener(new AnonymousClass3());
        this.mBackgroundAnimator.addListener(new AnonymousClass4());
        this.mBackgroundAnimator.start();
    }

    /* JADX INFO: renamed from: androidx.leanback.app.DetailsBackgroundVideoHelper$3, reason: invalid class name */
    class AnonymousClass3 implements ValueAnimator.AnimatorUpdateListener {
        AnonymousClass3() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            DetailsBackgroundVideoHelper.this.mBackgroundDrawable.setAlpha((int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f));
        }
    }

    /* JADX INFO: renamed from: androidx.leanback.app.DetailsBackgroundVideoHelper$4, reason: invalid class name */
    class AnonymousClass4 implements Animator.AnimatorListener {
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        AnonymousClass4() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            DetailsBackgroundVideoHelper.this.mBackgroundAnimator = null;
        }
    }

    private class PlaybackControlStateCallback extends PlaybackGlue.PlayerCallback {
        PlaybackControlStateCallback() {
        }

        @Override // androidx.leanback.media.PlaybackGlue.PlayerCallback
        public void onPreparedStateChanged(PlaybackGlue playbackGlue) {
            if (playbackGlue.isPrepared()) {
                DetailsBackgroundVideoHelper.this.internalStartPlayback();
            }
        }
    }
}
