package androidx.leanback.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes.dex */
class NonOverlappingLinearLayoutWithForeground extends LinearLayout {
    private static final int VERSION_M = 23;
    private Drawable mForeground;
    private boolean mForegroundBoundsChanged;
    private final Rect mSelfBounds;

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    public NonOverlappingLinearLayoutWithForeground(Context context) {
        this(context, null);
    }

    public NonOverlappingLinearLayoutWithForeground(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NonOverlappingLinearLayoutWithForeground(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSelfBounds = new Rect();
        if (context.getApplicationInfo().targetSdkVersion >= 23) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{android.R.attr.foreground});
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
        if (drawable != null) {
            setForegroundCompat(drawable);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public void setForegroundCompat(Drawable drawable) {
        ForegroundHelper.setForeground(this, drawable);
    }

    public Drawable getForegroundCompat() {
        return ForegroundHelper.getForeground(this);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.mForeground;
        if (drawable != null) {
            if (this.mForegroundBoundsChanged) {
                this.mForegroundBoundsChanged = false;
                Rect rect = this.mSelfBounds;
                rect.set(0, 0, getRight() - getLeft(), getBottom() - getTop());
                drawable.setBounds(rect);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mForegroundBoundsChanged = z | this.mForegroundBoundsChanged;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.mForeground;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.mForeground;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mForeground;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.mForeground.setState(getDrawableState());
    }
}
