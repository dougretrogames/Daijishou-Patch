package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
class ViewUtils {
    static final Property<View, Rect> CLIP_BOUNDS;
    private static final ViewUtilsApi19 IMPL;
    private static final String TAG = "ViewUtils";
    static final Property<View, Float> TRANSITION_ALPHA;

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            IMPL = new ViewUtilsApi29();
        } else {
            IMPL = new ViewUtilsApi23();
        }
        TRANSITION_ALPHA = new AnonymousClass1(Float.class, "translationAlpha");
        CLIP_BOUNDS = new AnonymousClass2(Rect.class, "clipBounds");
    }

    /* JADX INFO: renamed from: androidx.transition.ViewUtils$1, reason: invalid class name */
    class AnonymousClass1 extends Property<View, Float> {
        AnonymousClass1(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public Float get(View view) {
            return Float.valueOf(ViewUtils.getTransitionAlpha(view));
        }

        @Override // android.util.Property
        public void set(View view, Float f) {
            ViewUtils.setTransitionAlpha(view, f.floatValue());
        }
    }

    /* JADX INFO: renamed from: androidx.transition.ViewUtils$2, reason: invalid class name */
    class AnonymousClass2 extends Property<View, Rect> {
        AnonymousClass2(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public Rect get(View view) {
            return view.getClipBounds();
        }

        @Override // android.util.Property
        public void set(View view, Rect rect) {
            view.setClipBounds(rect);
        }
    }

    static void setTransitionAlpha(View view, float f) {
        IMPL.setTransitionAlpha(view, f);
    }

    static float getTransitionAlpha(View view) {
        return IMPL.getTransitionAlpha(view);
    }

    static void saveNonTransitionAlpha(View view) {
        IMPL.saveNonTransitionAlpha(view);
    }

    static void clearNonTransitionAlpha(View view) {
        IMPL.clearNonTransitionAlpha(view);
    }

    static void setTransitionVisibility(View view, int i) {
        IMPL.setTransitionVisibility(view, i);
    }

    static void transformMatrixToGlobal(View view, Matrix matrix) {
        IMPL.transformMatrixToGlobal(view, matrix);
    }

    static void transformMatrixToLocal(View view, Matrix matrix) {
        IMPL.transformMatrixToLocal(view, matrix);
    }

    static void setAnimationMatrix(View view, Matrix matrix) {
        IMPL.setAnimationMatrix(view, matrix);
    }

    static void setLeftTopRightBottom(View view, int i, int i2, int i3, int i4) {
        IMPL.setLeftTopRightBottom(view, i, i2, i3, i4);
    }

    private ViewUtils() {
    }
}
