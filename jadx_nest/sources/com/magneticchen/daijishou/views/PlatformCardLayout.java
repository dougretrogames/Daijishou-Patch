package com.magneticchen.daijishou.views;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.preference.PreferenceManager;
import com.magneticchen.daijishou.application_data.BooleanPreference;
import com.magneticchen.daijishou.application_data.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlatformCardLayout.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0001\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH\u0014R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/magneticchen/daijishou/views/PlatformCardLayout;", "Lcom/magneticchen/daijishou/views/SwipeableConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defaultSharedPreferences", "Landroid/content/SharedPreferences;", "getDefaultSharedPreferences", "()Landroid/content/SharedPreferences;", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PlatformCardLayout extends SwipeableConstraintLayout {
    private final SharedPreferences defaultSharedPreferences;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlatformCardLayout(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(...)");
        this.defaultSharedPreferences = defaultSharedPreferences;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlatformCardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(...)");
        this.defaultSharedPreferences = defaultSharedPreferences;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlatformCardLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(...)");
        this.defaultSharedPreferences = defaultSharedPreferences;
    }

    public final SharedPreferences getDefaultSharedPreferences() {
        return this.defaultSharedPreferences;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (this.defaultSharedPreferences.getBoolean(BooleanPreference.ENFORCE_PLATFORM_CARD_ASPECT_RATIO.getKey(), BooleanPreference.ENFORCE_PLATFORM_CARD_ASPECT_RATIO.getDefaultValue())) {
            float measuredWidth = getMeasuredWidth() / getMeasuredHeight();
            if (measuredWidth < 1.0f) {
                measuredWidth = 1.0f / measuredWidth;
            }
            if (measuredWidth > 2.1111112f) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ((ConstraintLayout.LayoutParams) layoutParams).dimensionRatio = Constants.layoutDimensionRatio;
            }
        }
    }
}
