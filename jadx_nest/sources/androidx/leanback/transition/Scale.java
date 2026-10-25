package androidx.leanback.transition;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
class Scale extends Transition {
    private static final String PROPNAME_SCALE = "android:leanback:scale";

    private void captureValues(TransitionValues transitionValues) {
        transitionValues.values.put(PROPNAME_SCALE, Float.valueOf(transitionValues.view.getScaleX()));
    }

    @Override // android.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // android.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // android.transition.Transition
    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null || transitionValues2 == null) {
            return null;
        }
        float fFloatValue = ((Float) transitionValues.values.get(PROPNAME_SCALE)).floatValue();
        float fFloatValue2 = ((Float) transitionValues2.values.get(PROPNAME_SCALE)).floatValue();
        View view = transitionValues.view;
        view.setScaleX(fFloatValue);
        view.setScaleY(fFloatValue);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fFloatValue, fFloatValue2);
        valueAnimatorOfFloat.addUpdateListener(new AnonymousClass1(view));
        return valueAnimatorOfFloat;
    }

    /* JADX INFO: renamed from: androidx.leanback.transition.Scale$1, reason: invalid class name */
    class AnonymousClass1 implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ View val$view;

        AnonymousClass1(View view) {
            this.val$view = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.val$view.setScaleX(fFloatValue);
            this.val$view.setScaleY(fFloatValue);
        }
    }
}
