package androidx.leanback.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import androidx.core.view.GravityCompat;
import androidx.leanback.R;

/* JADX INFO: loaded from: classes.dex */
public class FadeAndShortSlide extends Visibility {
    private static final String PROPNAME_SCREEN_POSITION = "android:fadeAndShortSlideTransition:screenPosition";
    private float mDistance;
    private Visibility mFade;
    private CalculateSlide mSlideCalculator;
    final CalculateSlide sCalculateTopBottom;
    private static final TimeInterpolator sDecelerate = new DecelerateInterpolator();
    static final CalculateSlide sCalculateStart = new AnonymousClass1();
    static final CalculateSlide sCalculateEnd = new AnonymousClass2();
    static final CalculateSlide sCalculateStartEnd = new AnonymousClass3();
    static final CalculateSlide sCalculateBottom = new AnonymousClass4();
    static final CalculateSlide sCalculateTop = new AnonymousClass5();

    private static abstract class CalculateSlide {
        CalculateSlide() {
        }

        float getGoneX(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
            return view.getTranslationX();
        }

        float getGoneY(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
            return view.getTranslationY();
        }
    }

    float getHorizontalDistance(ViewGroup viewGroup) {
        float f = this.mDistance;
        return f >= 0.0f ? f : viewGroup.getWidth() / 4;
    }

    float getVerticalDistance(ViewGroup viewGroup) {
        float f = this.mDistance;
        return f >= 0.0f ? f : viewGroup.getHeight() / 4;
    }

    /* JADX INFO: renamed from: androidx.leanback.transition.FadeAndShortSlide$1, reason: invalid class name */
    class AnonymousClass1 extends CalculateSlide {
        AnonymousClass1() {
        }

        @Override // androidx.leanback.transition.FadeAndShortSlide.CalculateSlide
        public float getGoneX(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
            if (viewGroup.getLayoutDirection() == 1) {
                return view.getTranslationX() + fadeAndShortSlide.getHorizontalDistance(viewGroup);
            }
            return view.getTranslationX() - fadeAndShortSlide.getHorizontalDistance(viewGroup);
        }
    }

    /* JADX INFO: renamed from: androidx.leanback.transition.FadeAndShortSlide$2, reason: invalid class name */
    class AnonymousClass2 extends CalculateSlide {
        AnonymousClass2() {
        }

        @Override // androidx.leanback.transition.FadeAndShortSlide.CalculateSlide
        public float getGoneX(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
            if (viewGroup.getLayoutDirection() == 1) {
                return view.getTranslationX() - fadeAndShortSlide.getHorizontalDistance(viewGroup);
            }
            return view.getTranslationX() + fadeAndShortSlide.getHorizontalDistance(viewGroup);
        }
    }

    /* JADX INFO: renamed from: androidx.leanback.transition.FadeAndShortSlide$3, reason: invalid class name */
    class AnonymousClass3 extends CalculateSlide {
        AnonymousClass3() {
        }

        @Override // androidx.leanback.transition.FadeAndShortSlide.CalculateSlide
        public float getGoneX(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
            int iCenterX;
            int width = iArr[0] + (view.getWidth() / 2);
            viewGroup.getLocationOnScreen(iArr);
            Rect epicenter = fadeAndShortSlide.getEpicenter();
            if (epicenter == null) {
                iCenterX = iArr[0] + (viewGroup.getWidth() / 2);
            } else {
                iCenterX = epicenter.centerX();
            }
            if (width < iCenterX) {
                return view.getTranslationX() - fadeAndShortSlide.getHorizontalDistance(viewGroup);
            }
            return view.getTranslationX() + fadeAndShortSlide.getHorizontalDistance(viewGroup);
        }
    }

    /* JADX INFO: renamed from: androidx.leanback.transition.FadeAndShortSlide$4, reason: invalid class name */
    class AnonymousClass4 extends CalculateSlide {
        AnonymousClass4() {
        }

        @Override // androidx.leanback.transition.FadeAndShortSlide.CalculateSlide
        public float getGoneY(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
            return view.getTranslationY() + fadeAndShortSlide.getVerticalDistance(viewGroup);
        }
    }

    /* JADX INFO: renamed from: androidx.leanback.transition.FadeAndShortSlide$5, reason: invalid class name */
    class AnonymousClass5 extends CalculateSlide {
        AnonymousClass5() {
        }

        @Override // androidx.leanback.transition.FadeAndShortSlide.CalculateSlide
        public float getGoneY(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
            return view.getTranslationY() - fadeAndShortSlide.getVerticalDistance(viewGroup);
        }
    }

    /* JADX INFO: renamed from: androidx.leanback.transition.FadeAndShortSlide$6, reason: invalid class name */
    class AnonymousClass6 extends CalculateSlide {
        AnonymousClass6() {
        }

        @Override // androidx.leanback.transition.FadeAndShortSlide.CalculateSlide
        public float getGoneY(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
            int iCenterY;
            int height = iArr[1] + (view.getHeight() / 2);
            viewGroup.getLocationOnScreen(iArr);
            Rect epicenter = FadeAndShortSlide.this.getEpicenter();
            if (epicenter == null) {
                iCenterY = iArr[1] + (viewGroup.getHeight() / 2);
            } else {
                iCenterY = epicenter.centerY();
            }
            if (height < iCenterY) {
                return view.getTranslationY() - fadeAndShortSlide.getVerticalDistance(viewGroup);
            }
            return view.getTranslationY() + fadeAndShortSlide.getVerticalDistance(viewGroup);
        }
    }

    public FadeAndShortSlide() {
        this(GravityCompat.START);
    }

    public FadeAndShortSlide(int i) {
        this.mFade = new Fade();
        this.mDistance = -1.0f;
        this.sCalculateTopBottom = new AnonymousClass6();
        setSlideEdge(i);
    }

    public FadeAndShortSlide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFade = new Fade();
        this.mDistance = -1.0f;
        this.sCalculateTopBottom = new AnonymousClass6();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.lbSlide);
        setSlideEdge(typedArrayObtainStyledAttributes.getInt(R.styleable.lbSlide_lb_slideEdge, GravityCompat.START));
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.transition.Transition
    public void setEpicenterCallback(Transition.EpicenterCallback epicenterCallback) {
        this.mFade.setEpicenterCallback(epicenterCallback);
        super.setEpicenterCallback(epicenterCallback);
    }

    private void captureValues(TransitionValues transitionValues) {
        int[] iArr = new int[2];
        transitionValues.view.getLocationOnScreen(iArr);
        transitionValues.values.put(PROPNAME_SCREEN_POSITION, iArr);
    }

    @Override // android.transition.Visibility, android.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        this.mFade.captureStartValues(transitionValues);
        super.captureStartValues(transitionValues);
        captureValues(transitionValues);
    }

    @Override // android.transition.Visibility, android.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        this.mFade.captureEndValues(transitionValues);
        super.captureEndValues(transitionValues);
        captureValues(transitionValues);
    }

    public void setSlideEdge(int i) {
        if (i == 48) {
            this.mSlideCalculator = sCalculateTop;
            return;
        }
        if (i == 80) {
            this.mSlideCalculator = sCalculateBottom;
            return;
        }
        if (i == 112) {
            this.mSlideCalculator = this.sCalculateTopBottom;
            return;
        }
        if (i == 8388611) {
            this.mSlideCalculator = sCalculateStart;
        } else if (i == 8388613) {
            this.mSlideCalculator = sCalculateEnd;
        } else {
            if (i == 8388615) {
                this.mSlideCalculator = sCalculateStartEnd;
                return;
            }
            throw new IllegalArgumentException("Invalid slide direction");
        }
    }

    @Override // android.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues2 == null || viewGroup == view) {
            return null;
        }
        int[] iArr = (int[]) transitionValues2.values.get(PROPNAME_SCREEN_POSITION);
        int i = iArr[0];
        int i2 = iArr[1];
        float translationX = view.getTranslationX();
        Animator animatorCreateAnimation = TranslationAnimationCreator.createAnimation(view, transitionValues2, i, i2, this.mSlideCalculator.getGoneX(this, viewGroup, view, iArr), this.mSlideCalculator.getGoneY(this, viewGroup, view, iArr), translationX, view.getTranslationY(), sDecelerate, this);
        Animator animatorOnAppear = this.mFade.onAppear(viewGroup, view, transitionValues, transitionValues2);
        if (animatorCreateAnimation == null) {
            return animatorOnAppear;
        }
        if (animatorOnAppear == null) {
            return animatorCreateAnimation;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(animatorCreateAnimation).with(animatorOnAppear);
        return animatorSet;
    }

    @Override // android.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null || viewGroup == view) {
            return null;
        }
        int[] iArr = (int[]) transitionValues.values.get(PROPNAME_SCREEN_POSITION);
        Animator animatorCreateAnimation = TranslationAnimationCreator.createAnimation(view, transitionValues, iArr[0], iArr[1], view.getTranslationX(), view.getTranslationY(), this.mSlideCalculator.getGoneX(this, viewGroup, view, iArr), this.mSlideCalculator.getGoneY(this, viewGroup, view, iArr), sDecelerate, this);
        Animator animatorOnDisappear = this.mFade.onDisappear(viewGroup, view, transitionValues, transitionValues2);
        if (animatorCreateAnimation == null) {
            return animatorOnDisappear;
        }
        if (animatorOnDisappear == null) {
            return animatorCreateAnimation;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(animatorCreateAnimation).with(animatorOnDisappear);
        return animatorSet;
    }

    @Override // android.transition.Transition
    public Transition addListener(Transition.TransitionListener transitionListener) {
        this.mFade.addListener(transitionListener);
        return super.addListener(transitionListener);
    }

    @Override // android.transition.Transition
    public Transition removeListener(Transition.TransitionListener transitionListener) {
        this.mFade.removeListener(transitionListener);
        return super.removeListener(transitionListener);
    }

    public float getDistance() {
        return this.mDistance;
    }

    public void setDistance(float f) {
        this.mDistance = f;
    }

    @Override // android.transition.Transition
    public Transition clone() {
        FadeAndShortSlide fadeAndShortSlide = (FadeAndShortSlide) super.clone();
        fadeAndShortSlide.mFade = (Visibility) this.mFade.clone();
        return fadeAndShortSlide;
    }
}
