package androidx.core.view.insets;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* INFO: loaded from: classes.dex */
class SystemBarStateMonitor {
    private int mColorHint;
    private final View mDetector;
    private final ArrayList<Callback> mCallbacks = new ArrayList<>();
    private Insets mInsets = Insets.NONE;
    private Insets mInsetsIgnoringVisibility = Insets.NONE;

    interface Callback {
        void onAnimationEnd();

        void onAnimationProgress(int i, Insets insets, RectF rectF);

        void onAnimationStart();

        void onColorHintChanged(int i);

        void onInsetsChanged(Insets insets, Insets insets2);
    }

    SystemBarStateMonitor(ViewGroup viewGroup) {
        Drawable background = viewGroup.getBackground();
        this.mColorHint = background instanceof ColorDrawable ? ((ColorDrawable) background).getColor() : 0;
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(viewGroup.getContext(), viewGroup);
        this.mDetector = anonymousClass1;
        anonymousClass1.setWillNotDraw(true);
        ViewCompat.setOnApplyWindowInsetsListener(anonymousClass1, new SystemBarStateMonitor$$ExternalSyntheticLambda0(this));
        ViewCompat.setWindowInsetsAnimationCallback(anonymousClass1, new AnonymousClass2(0));
        viewGroup.addView(anonymousClass1, 0);
    }

    /* INFO: renamed from: androidx.core.view.insets.SystemBarStateMonitor$1, reason: invalid class name */
    class AnonymousClass1 extends View {
        final /* synthetic */ ViewGroup val$rootView;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Context context, ViewGroup viewGroup) {
            super(context);
            this.val$rootView = viewGroup;
        }

        @Override // android.view.View
        protected void onConfigurationChanged(Configuration configuration) {
            Drawable background = this.val$rootView.getBackground();
            int color = background instanceof ColorDrawable ? ((ColorDrawable) background).getColor() : 0;
            if (SystemBarStateMonitor.this.mColorHint != color) {
                SystemBarStateMonitor.this.mColorHint = color;
                for (int size = SystemBarStateMonitor.this.mCallbacks.size() - 1; size >= 0; size--) {
                    ((Callback) SystemBarStateMonitor.this.mCallbacks.get(size)).onColorHintChanged(color);
                }
            }
        }
    }

    /* INFO: renamed from: lambda$new$0$androidx-core-view-insets-SystemBarStateMonitor, reason: not valid java name */
    /* synthetic */ WindowInsetsCompat m3176lambda$new$0$androidxcoreviewinsetsSystemBarStateMonitor(View view, WindowInsetsCompat windowInsetsCompat) {
        Insets insets = getInsets(windowInsetsCompat);
        Insets insetsIgnoringVisibility = getInsetsIgnoringVisibility(windowInsetsCompat);
        if (!insets.equals(this.mInsets) || !insetsIgnoringVisibility.equals(this.mInsetsIgnoringVisibility)) {
            this.mInsets = insets;
            this.mInsetsIgnoringVisibility = insetsIgnoringVisibility;
            for (int size = this.mCallbacks.size() - 1; size >= 0; size--) {
                this.mCallbacks.get(size).onInsetsChanged(insets, insetsIgnoringVisibility);
            }
        }
        return windowInsetsCompat;
    }

    /* INFO: renamed from: androidx.core.view.insets.SystemBarStateMonitor$2, reason: invalid class name */
    class AnonymousClass2 extends WindowInsetsAnimationCompat.Callback {
        private final HashMap<WindowInsetsAnimationCompat, Integer> mAnimationSidesMap;

        AnonymousClass2(int i) {
            super(i);
            this.mAnimationSidesMap = new HashMap<>();
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
        public void onPrepare(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
            if (animatesSystemBars(windowInsetsAnimationCompat)) {
                for (int size = SystemBarStateMonitor.this.mCallbacks.size() - 1; size >= 0; size--) {
                    ((Callback) SystemBarStateMonitor.this.mCallbacks.get(size)).onAnimationStart();
                }
            }
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
        public WindowInsetsAnimationCompat.BoundsCompat onStart(WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsetsAnimationCompat.BoundsCompat boundsCompat) {
            if (!animatesSystemBars(windowInsetsAnimationCompat)) {
                return boundsCompat;
            }
            Insets upperBound = boundsCompat.getUpperBound();
            Insets lowerBound = boundsCompat.getLowerBound();
            int i = upperBound.left != lowerBound.left ? 1 : 0;
            if (upperBound.top != lowerBound.top) {
                i |= 2;
            }
            if (upperBound.right != lowerBound.right) {
                i |= 4;
            }
            if (upperBound.bottom != lowerBound.bottom) {
                i |= 8;
            }
            this.mAnimationSidesMap.put(windowInsetsAnimationCompat, Integer.valueOf(i));
            return boundsCompat;
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
        public WindowInsetsCompat onProgress(WindowInsetsCompat windowInsetsCompat, List<WindowInsetsAnimationCompat> list) {
            RectF rectF = new RectF(1.0f, 1.0f, 1.0f, 1.0f);
            int i = 0;
            for (int size = list.size() - 1; size >= 0; size--) {
                WindowInsetsAnimationCompat windowInsetsAnimationCompat = list.get(size);
                Integer num = this.mAnimationSidesMap.get(windowInsetsAnimationCompat);
                if (num != null) {
                    int iIntValue = num.intValue();
                    float alpha = windowInsetsAnimationCompat.getAlpha();
                    if ((iIntValue & 1) != 0) {
                        rectF.left = alpha;
                    }
                    if ((iIntValue & 2) != 0) {
                        rectF.top = alpha;
                    }
                    if ((iIntValue & 4) != 0) {
                        rectF.right = alpha;
                    }
                    if ((iIntValue & 8) != 0) {
                        rectF.bottom = alpha;
                    }
                    i |= iIntValue;
                }
            }
            Insets insets = SystemBarStateMonitor.this.getInsets(windowInsetsCompat);
            for (int size2 = SystemBarStateMonitor.this.mCallbacks.size() - 1; size2 >= 0; size2--) {
                ((Callback) SystemBarStateMonitor.this.mCallbacks.get(size2)).onAnimationProgress(i, insets, rectF);
            }
            return windowInsetsCompat;
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
        public void onEnd(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
            if (animatesSystemBars(windowInsetsAnimationCompat)) {
                this.mAnimationSidesMap.remove(windowInsetsAnimationCompat);
                for (int size = SystemBarStateMonitor.this.mCallbacks.size() - 1; size >= 0; size--) {
                    ((Callback) SystemBarStateMonitor.this.mCallbacks.get(size)).onAnimationEnd();
                }
            }
        }

        private boolean animatesSystemBars(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
            return (windowInsetsAnimationCompat.getTypeMask() & WindowInsetsCompat.Type.systemBars()) != 0;
        }
    }

    /* INFO: Access modifiers changed from: private */
    public Insets getInsets(WindowInsetsCompat windowInsetsCompat) {
        return Insets.min(windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars()), windowInsetsCompat.getInsets(WindowInsetsCompat.Type.tappableElement()));
    }

    private Insets getInsetsIgnoringVisibility(WindowInsetsCompat windowInsetsCompat) {
        return Insets.min(windowInsetsCompat.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.systemBars()), windowInsetsCompat.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.tappableElement()));
    }

    void addCallback(Callback callback) {
        if (this.mCallbacks.contains(callback)) {
            return;
        }
        this.mCallbacks.add(callback);
        callback.onInsetsChanged(this.mInsets, this.mInsetsIgnoringVisibility);
        callback.onColorHintChanged(this.mColorHint);
    }

    void removeCallback(Callback callback) {
        this.mCallbacks.remove(callback);
    }

    boolean hasCallback() {
        return !this.mCallbacks.isEmpty();
    }

    void detachFromWindow() {
        this.mDetector.post(new SystemBarStateMonitor$$ExternalSyntheticLambda1(this));
    }

    /* INFO: renamed from: lambda$detachFromWindow$1$androidx-core-view-insets-SystemBarStateMonitor, reason: not valid java name */
    /* synthetic */ void m3175xf3edbe07() {
        ViewParent parent = this.mDetector.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.mDetector);
        }
    }
}
