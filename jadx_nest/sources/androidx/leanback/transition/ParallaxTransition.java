package androidx.leanback.transition;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.leanback.R;
import androidx.leanback.widget.Parallax;

/* JADX INFO: loaded from: classes.dex */
public class ParallaxTransition extends Visibility {
    static Interpolator sInterpolator = new LinearInterpolator();

    public ParallaxTransition() {
    }

    public ParallaxTransition(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    Animator createAnimator(View view) {
        Parallax parallax = (Parallax) view.getTag(R.id.lb_parallax_source);
        if (parallax == null) {
            return null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(sInterpolator);
        valueAnimatorOfFloat.addUpdateListener(new AnonymousClass1(parallax));
        return valueAnimatorOfFloat;
    }

    /* JADX INFO: renamed from: androidx.leanback.transition.ParallaxTransition$1, reason: invalid class name */
    class AnonymousClass1 implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ Parallax val$source;

        AnonymousClass1(Parallax parallax) {
            this.val$source = parallax;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.val$source.updateValues();
        }
    }

    @Override // android.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues2 == null) {
            return null;
        }
        return createAnimator(view);
    }

    @Override // android.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null) {
            return null;
        }
        return createAnimator(view);
    }
}
