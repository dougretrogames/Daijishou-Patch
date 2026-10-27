package com.magneticchen.daijishou.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.magneticchen.daijishou.utils.DpToPxConverter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SwipeableConstraintLayout.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0001\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0014\u0010\u001f\u001a\u00020\u00142\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\u0014\u0010 \u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\u0014\u0010!\u001a\u00020\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/magneticchen/daijishou/ui/views/SwipeableConstraintLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dpToPxConverter", "Lcom/magneticchen/daijishou/utils/DpToPxConverter;", "maxDistanceDp", "", "maxDistancePx", "minDistanceDp", "minDistancePx", "onNextSwiped", "Lkotlin/Function0;", "", "onPreviousSwiped", "onTaped", "x1", "x2", "y1", "y2", "onTouchEvent", "", "motionEvent", "Landroid/view/MotionEvent;", "setOnNextSwiped", "setOnPreviousSwiped", "setOnTaped", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class SwipeableConstraintLayout extends ConstraintLayout {
    private final DpToPxConverter dpToPxConverter;
    private final float maxDistanceDp;
    private final int maxDistancePx;
    private final float minDistanceDp;
    private final int minDistancePx;
    private Function0<Unit> onNextSwiped;
    private Function0<Unit> onPreviousSwiped;
    private Function0<Unit> onTaped;
    private float x1;
    private float x2;
    private float y1;
    private float y2;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeableConstraintLayout(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        DpToPxConverter dpToPxConverter = new DpToPxConverter(context2);
        this.dpToPxConverter = dpToPxConverter;
        this.minDistanceDp = 72.0f;
        this.maxDistanceDp = 32.0f;
        this.minDistancePx = dpToPxConverter.convert(72.0f);
        this.maxDistancePx = dpToPxConverter.convert(32.0f);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeableConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        DpToPxConverter dpToPxConverter = new DpToPxConverter(context2);
        this.dpToPxConverter = dpToPxConverter;
        this.minDistanceDp = 72.0f;
        this.maxDistanceDp = 32.0f;
        this.minDistancePx = dpToPxConverter.convert(72.0f);
        this.maxDistancePx = dpToPxConverter.convert(32.0f);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeableConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        DpToPxConverter dpToPxConverter = new DpToPxConverter(context2);
        this.dpToPxConverter = dpToPxConverter;
        this.minDistanceDp = 72.0f;
        this.maxDistanceDp = 32.0f;
        this.minDistancePx = dpToPxConverter.convert(72.0f);
        this.maxDistancePx = dpToPxConverter.convert(32.0f);
    }

    public final void setOnTaped(Function0<Unit> onTaped) {
        Intrinsics.checkNotNullParameter(onTaped, "onTaped");
        this.onTaped = onTaped;
    }

    public final void setOnPreviousSwiped(Function0<Unit> onPreviousSwiped) {
        Intrinsics.checkNotNullParameter(onPreviousSwiped, "onPreviousSwiped");
        this.onPreviousSwiped = onPreviousSwiped;
    }

    public final void setOnNextSwiped(Function0<Unit> onNextSwiped) {
        Intrinsics.checkNotNullParameter(onNextSwiped, "onNextSwiped");
        this.onNextSwiped = onNextSwiped;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Function0<Unit> function0;
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        int action = motionEvent.getAction();
        if (action == 0) {
            this.x1 = motionEvent.getX();
            this.y1 = motionEvent.getY();
        } else if (action == 1) {
            this.x2 = motionEvent.getX();
            float y = motionEvent.getY();
            this.y2 = y;
            float f = this.x2 - this.x1;
            float f2 = y - this.y1;
            if (Math.abs(f) > this.minDistancePx) {
                if (this.x2 < this.x1) {
                    Function0<Unit> function1 = this.onNextSwiped;
                    if (function1 != null) {
                        function1.invoke();
                    }
                } else {
                    Function0<Unit> function2 = this.onPreviousSwiped;
                    if (function2 != null) {
                        function2.invoke();
                    }
                }
            } else if (Math.abs(f) < this.maxDistancePx && Math.abs(f2) < this.maxDistancePx && (function0 = this.onTaped) != null) {
                function0.invoke();
            }
        }
        return true;
    }
}
