package androidx.leanback.widget;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;

/* INFO: loaded from: classes.dex */
public class SearchOrbView extends FrameLayout implements View.OnClickListener {
    private boolean mAttachedToWindow;
    private boolean mColorAnimationEnabled;
    private ValueAnimator mColorAnimator;
    private final ArgbEvaluator mColorEvaluator;
    private Colors mColors;
    private final ValueAnimator.AnimatorUpdateListener mFocusUpdateListener;
    private final float mFocusedZ;
    private final float mFocusedZoom;
    private final ImageView mIcon;
    private Drawable mIconDrawable;
    private View.OnClickListener mListener;
    private final int mPulseDurationMs;
    private final View mRootView;
    private final int mScaleDurationMs;
    private final View mSearchOrbView;
    private ValueAnimator mShadowFocusAnimator;
    private final float mUnfocusedZ;
    private final ValueAnimator.AnimatorUpdateListener mUpdateListener;

    public static class Colors {
        private static final float BRIGHTNESS_ALPHA = 0.15f;
        public int brightColor;
        public int color;
        public int iconColor;

        public Colors(int i) {
            this(i, i);
        }

        public Colors(int i, int i2) {
            this(i, i2, 0);
        }

        public Colors(int i, int i2, int i3) {
            this.color = i;
            this.brightColor = i2 == i ? getBrightColor(i) : i2;
            this.iconColor = i3;
        }

        public static int getBrightColor(int i) {
            return Color.argb((int) ((Color.alpha(i) * 0.85f) + 38.25f), (int) ((Color.red(i) * 0.85f) + 38.25f), (int) ((Color.green(i) * 0.85f) + 38.25f), (int) ((Color.blue(i) * 0.85f) + 38.25f));
        }
    }

    /* INFO: renamed from: lambda$new$0$androidx-leanback-widget-SearchOrbView, reason: not valid java name */
    /* synthetic */ void m3202lambda$new$0$androidxleanbackwidgetSearchOrbView(ValueAnimator valueAnimator) {
        setOrbViewColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }

    /* INFO: renamed from: lambda$new$1$androidx-leanback-widget-SearchOrbView, reason: not valid java name */
    /* synthetic */ void m3203lambda$new$1$androidxleanbackwidgetSearchOrbView(ValueAnimator valueAnimator) {
        setSearchOrbZ(valueAnimator.getAnimatedFraction());
    }

    void setSearchOrbZ(float f) {
        View view = this.mSearchOrbView;
        float f2 = this.mUnfocusedZ;
        ViewCompat.setZ(view, f2 + (f * (this.mFocusedZ - f2)));
    }

    public SearchOrbView(Context context) {
        this(context, null);
    }

    public SearchOrbView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.leanback.R.attr.searchOrbViewStyle);
    }

    public SearchOrbView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mColorEvaluator = new ArgbEvaluator();
        this.mUpdateListener = new SearchOrbView$$ExternalSyntheticLambda0(this);
        this.mFocusUpdateListener = new SearchOrbView$$ExternalSyntheticLambda1(this);
        Resources resources = context.getResources();
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(getLayoutResourceId(), (ViewGroup) this, true);
        this.mRootView = viewInflate;
        this.mSearchOrbView = viewInflate.findViewById(androidx.leanback.R.id.search_orb);
        ImageView imageView = (ImageView) viewInflate.findViewById(androidx.leanback.R.id.icon);
        this.mIcon = imageView;
        this.mFocusedZoom = context.getResources().getFraction(androidx.leanback.R.fraction.lb_search_orb_focused_zoom, 1, 1);
        this.mPulseDurationMs = context.getResources().getInteger(androidx.leanback.R.integer.lb_search_orb_pulse_duration_ms);
        this.mScaleDurationMs = context.getResources().getInteger(androidx.leanback.R.integer.lb_search_orb_scale_duration_ms);
        float dimensionPixelSize = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_search_orb_focused_z);
        this.mFocusedZ = dimensionPixelSize;
        this.mUnfocusedZ = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_search_orb_unfocused_z);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.leanback.R.styleable.lbSearchOrbView, i, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, androidx.leanback.R.styleable.lbSearchOrbView, attributeSet, typedArrayObtainStyledAttributes, i, 0);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(androidx.leanback.R.styleable.lbSearchOrbView_searchOrbIcon);
        setOrbIcon(drawable == null ? resources.getDrawable(androidx.leanback.R.drawable.lb_ic_in_app_search) : drawable);
        int color = typedArrayObtainStyledAttributes.getColor(androidx.leanback.R.styleable.lbSearchOrbView_searchOrbColor, resources.getColor(androidx.leanback.R.color.lb_default_search_color));
        setOrbColors(new Colors(color, typedArrayObtainStyledAttributes.getColor(androidx.leanback.R.styleable.lbSearchOrbView_searchOrbBrightColor, color), typedArrayObtainStyledAttributes.getColor(androidx.leanback.R.styleable.lbSearchOrbView_searchOrbIconColor, 0)));
        typedArrayObtainStyledAttributes.recycle();
        setFocusable(true);
        setClipChildren(false);
        setOnClickListener(this);
        setSoundEffectsEnabled(false);
        setSearchOrbZ(0.0f);
        ViewCompat.setZ(imageView, dimensionPixelSize);
    }

    int getLayoutResourceId() {
        return androidx.leanback.R.layout.lb_search_orb;
    }

    void scaleOrbViewOnly(float f) {
        this.mSearchOrbView.setScaleX(f);
        this.mSearchOrbView.setScaleY(f);
    }

    float getFocusedZoom() {
        return this.mFocusedZoom;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener = this.mListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    private void startShadowFocusAnimation(boolean z, int i) {
        if (this.mShadowFocusAnimator == null) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mShadowFocusAnimator = valueAnimatorOfFloat;
            valueAnimatorOfFloat.addUpdateListener(this.mFocusUpdateListener);
        }
        if (z) {
            this.mShadowFocusAnimator.start();
        } else {
            this.mShadowFocusAnimator.reverse();
        }
        this.mShadowFocusAnimator.setDuration(i);
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        animateOnFocus(z);
    }

    void animateOnFocus(boolean z) {
        float f = z ? this.mFocusedZoom : 1.0f;
        this.mRootView.animate().scaleX(f).scaleY(f).setDuration(this.mScaleDurationMs).start();
        startShadowFocusAnimation(z, this.mScaleDurationMs);
        enableOrbColorAnimation(z);
    }

    public void setOrbIcon(Drawable drawable) {
        this.mIconDrawable = drawable;
        this.mIcon.setImageDrawable(drawable);
    }

    public Drawable getOrbIcon() {
        return this.mIconDrawable;
    }

    public void setOnOrbClickedListener(View.OnClickListener onClickListener) {
        this.mListener = onClickListener;
    }

    public void setOrbColor(int i) {
        setOrbColors(new Colors(i, i, 0));
    }

    @Deprecated
    public void setOrbColor(int i, int i2) {
        setOrbColors(new Colors(i, i2, 0));
    }

    public int getOrbColor() {
        return this.mColors.color;
    }

    public void setOrbColors(Colors colors) {
        this.mColors = colors;
        this.mIcon.setColorFilter(colors.iconColor);
        if (this.mColorAnimator == null) {
            setOrbViewColor(this.mColors.color);
        } else {
            enableOrbColorAnimation(true);
        }
    }

    public Colors getOrbColors() {
        return this.mColors;
    }

    public void enableOrbColorAnimation(boolean z) {
        this.mColorAnimationEnabled = z;
        updateColorAnimator();
    }

    private void updateColorAnimator() {
        ValueAnimator valueAnimator = this.mColorAnimator;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.mColorAnimator = null;
        }
        if (this.mColorAnimationEnabled && this.mAttachedToWindow) {
            ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(this.mColorEvaluator, Integer.valueOf(this.mColors.color), Integer.valueOf(this.mColors.brightColor), Integer.valueOf(this.mColors.color));
            this.mColorAnimator = valueAnimatorOfObject;
            valueAnimatorOfObject.setRepeatCount(-1);
            this.mColorAnimator.setDuration(this.mPulseDurationMs * 2);
            this.mColorAnimator.addUpdateListener(this.mUpdateListener);
            this.mColorAnimator.start();
        }
    }

    void setOrbViewColor(int i) {
        if (this.mSearchOrbView.getBackground() instanceof GradientDrawable) {
            ((GradientDrawable) this.mSearchOrbView.getBackground()).setColor(i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mAttachedToWindow = true;
        updateColorAnimator();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.mAttachedToWindow = false;
        updateColorAnimator();
        super.onDetachedFromWindow();
    }
}
