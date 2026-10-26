package com.skydoves.balloon.radius;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.skydoves.balloon.internals.ViewPropertyDelegate;
import com.skydoves.balloon.internals.ViewPropertyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* INFO: compiled from: RadiusLayout.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ(\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007H\u0014J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001dH\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8G@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/skydoves/balloon/radius/RadiusLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "defStyle", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "path", "Landroid/graphics/Path;", "<set-?>", "", "radius", "getRadius", "()F", "setRadius", "(F)V", "radius$delegate", "Lcom/skydoves/balloon/internals/ViewPropertyDelegate;", "onSizeChanged", "", "w", "h", "oldw", "oldh", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "balloon_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RadiusLayout extends FrameLayout {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(RadiusLayout.class, "radius", "getRadius()F", 0))};
    private final Path path;

    /* INFO: renamed from: radius$delegate, reason: from kotlin metadata */
    private final ViewPropertyDelegate radius;

    /* WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RadiusLayout(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RadiusLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ RadiusLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RadiusLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.path = new Path();
        this.radius = ViewPropertyKt.viewProperty(this, Float.valueOf(0.0f));
    }

    public final float getRadius() {
        return ((Number) this.radius.getValue(this, $$delegatedProperties[0])).floatValue();
    }

    public final void setRadius(float f) {
        this.radius.setValue(this, $$delegatedProperties[0], Float.valueOf(f));
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.path.addRoundRect(new RectF(0.0f, 0.0f, w, h), getRadius(), getRadius(), Path.Direction.CW);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        canvas.clipPath(this.path);
        super.dispatchDraw(canvas);
    }
}
