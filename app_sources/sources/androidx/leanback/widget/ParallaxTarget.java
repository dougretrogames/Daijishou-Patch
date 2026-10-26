package androidx.leanback.widget;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.util.Property;
import android.view.animation.LinearInterpolator;

/* INFO: loaded from: classes.dex */
public abstract class ParallaxTarget {
    public void directUpdate(Number number) {
    }

    public boolean isDirectMapping() {
        return false;
    }

    public void update(float f) {
    }

    public static final class PropertyValuesHolderTarget extends ParallaxTarget {
        private static final long PSEUDO_DURATION = 1000000;
        private final ObjectAnimator mAnimator;

        public PropertyValuesHolderTarget(Object obj, PropertyValuesHolder propertyValuesHolder) {
            ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(obj, propertyValuesHolder);
            this.mAnimator = objectAnimatorOfPropertyValuesHolder;
            objectAnimatorOfPropertyValuesHolder.setInterpolator(new LinearInterpolator());
            objectAnimatorOfPropertyValuesHolder.setDuration(PSEUDO_DURATION);
        }

        @Override // androidx.leanback.widget.ParallaxTarget
        public void update(float f) {
            this.mAnimator.setCurrentPlayTime((long) (f * 1000000.0f));
        }
    }

    public static final class DirectPropertyTarget<T, V extends Number> extends ParallaxTarget {
        Object mObject;
        Property<T, V> mProperty;

        @Override // androidx.leanback.widget.ParallaxTarget
        public boolean isDirectMapping() {
            return true;
        }

        public DirectPropertyTarget(Object obj, Property<T, V> property) {
            this.mObject = obj;
            this.mProperty = property;
        }

        @Override // androidx.leanback.widget.ParallaxTarget
        public void directUpdate(Number number) {
            this.mProperty.set((T) this.mObject, (V) number);
        }
    }
}
