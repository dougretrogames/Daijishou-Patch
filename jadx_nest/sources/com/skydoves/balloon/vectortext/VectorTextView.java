package com.skydoves.balloon.vectortext;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.skydoves.balloon.R;
import com.skydoves.balloon.extensions.TextViewExtensionKt;
import com.skydoves.balloon.internals.DefinitionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VectorTextView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013R(\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/skydoves/balloon/vectortext/VectorTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "value", "Lcom/skydoves/balloon/vectortext/VectorTextViewParams;", "drawableTextViewParams", "getDrawableTextViewParams", "()Lcom/skydoves/balloon/vectortext/VectorTextViewParams;", "setDrawableTextViewParams", "(Lcom/skydoves/balloon/vectortext/VectorTextViewParams;)V", "initAttrs", "", "isRtlSupport", "rtlLayout", "", "balloon_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class VectorTextView extends AppCompatTextView {
    private VectorTextViewParams drawableTextViewParams;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VectorTextView(Context context) {
        this(context, null, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ VectorTextView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VectorTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        initAttrs(context, attributeSet);
    }

    public final VectorTextViewParams getDrawableTextViewParams() {
        return this.drawableTextViewParams;
    }

    public final void setDrawableTextViewParams(VectorTextViewParams vectorTextViewParams) {
        if (vectorTextViewParams != null) {
            TextViewExtensionKt.applyDrawable(this, vectorTextViewParams);
        } else {
            vectorTextViewParams = null;
        }
        this.drawableTextViewParams = vectorTextViewParams;
    }

    private final void initAttrs(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.VectorTextView);
            Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
            setDrawableTextViewParams(new VectorTextViewParams(DefinitionKt.takeIfNotNoIntValue(typedArrayObtainStyledAttributes.getResourceId(R.styleable.VectorTextView_balloon_drawableStart, Integer.MIN_VALUE)), DefinitionKt.takeIfNotNoIntValue(typedArrayObtainStyledAttributes.getResourceId(R.styleable.VectorTextView_balloon_drawableEnd, Integer.MIN_VALUE)), DefinitionKt.takeIfNotNoIntValue(typedArrayObtainStyledAttributes.getResourceId(R.styleable.VectorTextView_balloon_drawableBottom, Integer.MIN_VALUE)), DefinitionKt.takeIfNotNoIntValue(typedArrayObtainStyledAttributes.getResourceId(R.styleable.VectorTextView_balloon_drawableTop, Integer.MIN_VALUE)), null, null, null, null, false, null, null, null, null, DefinitionKt.takeIfNotNoIntValue(typedArrayObtainStyledAttributes.getResourceId(R.styleable.VectorTextView_balloon_drawablePadding, Integer.MIN_VALUE)), DefinitionKt.takeIfNotNoIntValue(typedArrayObtainStyledAttributes.getColor(R.styleable.VectorTextView_balloon_drawableTintColor, Integer.MIN_VALUE)), DefinitionKt.takeIfNotNoIntValue(typedArrayObtainStyledAttributes.getResourceId(R.styleable.VectorTextView_balloon_drawableWidth, Integer.MIN_VALUE)), DefinitionKt.takeIfNotNoIntValue(typedArrayObtainStyledAttributes.getResourceId(R.styleable.VectorTextView_balloon_drawableHeight, Integer.MIN_VALUE)), DefinitionKt.takeIfNotNoIntValue(typedArrayObtainStyledAttributes.getResourceId(R.styleable.VectorTextView_balloon_drawableSquareSize, Integer.MIN_VALUE)), 8176, null));
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public final void isRtlSupport(boolean rtlLayout) {
        VectorTextViewParams vectorTextViewParams = this.drawableTextViewParams;
        if (vectorTextViewParams != null) {
            vectorTextViewParams.setRtlLayout(rtlLayout);
            TextViewExtensionKt.applyDrawable(this, vectorTextViewParams);
        }
    }
}
