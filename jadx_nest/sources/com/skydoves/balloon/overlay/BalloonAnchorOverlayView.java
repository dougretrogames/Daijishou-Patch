package com.skydoves.balloon.overlay;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.skydoves.balloon.extensions.ContextExtensionKt;
import com.skydoves.balloon.internals.ViewPropertyDelegate;
import com.skydoves.balloon.internals.ViewPropertyKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: BalloonAnchorOverlayView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010F\u001a\u00020GJ\u0010\u0010H\u001a\u00020G2\u0006\u0010I\u001a\u00020JH\u0014J\b\u0010K\u001a\u00020GH\u0002J\u001a\u0010L\u001a\u00020G2\b\u0010M\u001a\u0004\u0018\u00010\u00012\u0006\u0010I\u001a\u00020JH\u0002J\b\u0010N\u001a\u00020\u0007H\u0002J0\u0010O\u001a\u00020G2\u0006\u0010P\u001a\u00020E2\u0006\u0010Q\u001a\u00020\u00072\u0006\u0010R\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\u00072\u0006\u0010T\u001a\u00020\u0007H\u0014R/\u0010\u000b\u001a\u0004\u0018\u00010\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u00018F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR;\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00122\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00128F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R+\u0010\u0019\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00078G@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u0011\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR+\u0010\u001f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00078G@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\"\u0010\u0011\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR/\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\n\u001a\u0004\u0018\u00010#8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b)\u0010\u0011\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R+\u0010+\u001a\u00020*2\u0006\u0010\n\u001a\u00020*8G@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b0\u0010\u0011\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R/\u00102\u001a\u0004\u0018\u0001012\b\u0010\n\u001a\u0004\u0018\u0001018F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b7\u0010\u0011\u001a\u0004\b3\u00104\"\u0004\b5\u00106R+\u00109\u001a\u0002082\u0006\u0010\n\u001a\u0002088F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b>\u0010\u0011\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020EX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006U"}, d2 = {"Lcom/skydoves/balloon/overlay/BalloonAnchorOverlayView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "defStyle", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "anchorView", "getAnchorView", "()Landroid/view/View;", "setAnchorView", "(Landroid/view/View;)V", "anchorView$delegate", "Lcom/skydoves/balloon/internals/ViewPropertyDelegate;", "", "anchorViewList", "getAnchorViewList", "()Ljava/util/List;", "setAnchorViewList", "(Ljava/util/List;)V", "anchorViewList$delegate", "overlayColor", "getOverlayColor", "()I", "setOverlayColor", "(I)V", "overlayColor$delegate", "overlayPaddingColor", "getOverlayPaddingColor", "setOverlayPaddingColor", "overlayPaddingColor$delegate", "Landroid/graphics/Shader;", "overlayPaddingShader", "getOverlayPaddingShader", "()Landroid/graphics/Shader;", "setOverlayPaddingShader", "(Landroid/graphics/Shader;)V", "overlayPaddingShader$delegate", "", "overlayPadding", "getOverlayPadding", "()F", "setOverlayPadding", "(F)V", "overlayPadding$delegate", "Landroid/graphics/Point;", "overlayPosition", "getOverlayPosition", "()Landroid/graphics/Point;", "setOverlayPosition", "(Landroid/graphics/Point;)V", "overlayPosition$delegate", "Lcom/skydoves/balloon/overlay/BalloonOverlayShape;", "balloonOverlayShape", "getBalloonOverlayShape", "()Lcom/skydoves/balloon/overlay/BalloonOverlayShape;", "setBalloonOverlayShape", "(Lcom/skydoves/balloon/overlay/BalloonOverlayShape;)V", "balloonOverlayShape$delegate", "bitmap", "Landroid/graphics/Bitmap;", "paint", "Landroid/graphics/Paint;", "paddingColorPaint", "invalidated", "", "forceInvalidate", "", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "prepareBitmap", "addFocusViewInOverlay", "view", "getStatusBarHeight", "onLayout", "changed", "left", "top", "right", "bottom", "balloon_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BalloonAnchorOverlayView extends View {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(BalloonAnchorOverlayView.class, "anchorView", "getAnchorView()Landroid/view/View;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(BalloonAnchorOverlayView.class, "anchorViewList", "getAnchorViewList()Ljava/util/List;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(BalloonAnchorOverlayView.class, "overlayColor", "getOverlayColor()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(BalloonAnchorOverlayView.class, "overlayPaddingColor", "getOverlayPaddingColor()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(BalloonAnchorOverlayView.class, "overlayPaddingShader", "getOverlayPaddingShader()Landroid/graphics/Shader;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(BalloonAnchorOverlayView.class, "overlayPadding", "getOverlayPadding()F", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(BalloonAnchorOverlayView.class, "overlayPosition", "getOverlayPosition()Landroid/graphics/Point;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(BalloonAnchorOverlayView.class, "balloonOverlayShape", "getBalloonOverlayShape()Lcom/skydoves/balloon/overlay/BalloonOverlayShape;", 0))};

    /* JADX INFO: renamed from: anchorView$delegate, reason: from kotlin metadata */
    private final ViewPropertyDelegate anchorView;

    /* JADX INFO: renamed from: anchorViewList$delegate, reason: from kotlin metadata */
    private final ViewPropertyDelegate anchorViewList;

    /* JADX INFO: renamed from: balloonOverlayShape$delegate, reason: from kotlin metadata */
    private final ViewPropertyDelegate balloonOverlayShape;
    private Bitmap bitmap;
    private boolean invalidated;

    /* JADX INFO: renamed from: overlayColor$delegate, reason: from kotlin metadata */
    private final ViewPropertyDelegate overlayColor;

    /* JADX INFO: renamed from: overlayPadding$delegate, reason: from kotlin metadata */
    private final ViewPropertyDelegate overlayPadding;

    /* JADX INFO: renamed from: overlayPaddingColor$delegate, reason: from kotlin metadata */
    private final ViewPropertyDelegate overlayPaddingColor;

    /* JADX INFO: renamed from: overlayPaddingShader$delegate, reason: from kotlin metadata */
    private final ViewPropertyDelegate overlayPaddingShader;

    /* JADX INFO: renamed from: overlayPosition$delegate, reason: from kotlin metadata */
    private final ViewPropertyDelegate overlayPosition;
    private final Paint paddingColorPaint;
    private final Paint paint;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BalloonAnchorOverlayView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BalloonAnchorOverlayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ BalloonAnchorOverlayView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BalloonAnchorOverlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        BalloonAnchorOverlayView balloonAnchorOverlayView = this;
        this.anchorView = ViewPropertyKt.viewProperty(balloonAnchorOverlayView, null);
        this.anchorViewList = ViewPropertyKt.viewProperty(balloonAnchorOverlayView, null);
        this.overlayColor = ViewPropertyKt.viewProperty(balloonAnchorOverlayView, 0);
        this.overlayPaddingColor = ViewPropertyKt.viewProperty(balloonAnchorOverlayView, 0);
        this.overlayPaddingShader = ViewPropertyKt.viewProperty(balloonAnchorOverlayView, null);
        this.overlayPadding = ViewPropertyKt.viewProperty(balloonAnchorOverlayView, Float.valueOf(0.0f));
        this.overlayPosition = ViewPropertyKt.viewProperty(balloonAnchorOverlayView, null);
        this.balloonOverlayShape = ViewPropertyKt.viewProperty(balloonAnchorOverlayView, BalloonOverlayOval.INSTANCE);
        Paint paint = new Paint(1);
        this.paint = paint;
        Paint paint2 = new Paint(1);
        this.paddingColorPaint = paint2;
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        paint2.setAntiAlias(true);
        paint2.setFilterBitmap(true);
        paint2.setDither(true);
    }

    public final View getAnchorView() {
        return (View) this.anchorView.getValue(this, $$delegatedProperties[0]);
    }

    public final void setAnchorView(View view) {
        this.anchorView.setValue(this, $$delegatedProperties[0], view);
    }

    public final List<View> getAnchorViewList() {
        return (List) this.anchorViewList.getValue(this, $$delegatedProperties[1]);
    }

    public final void setAnchorViewList(List<? extends View> list) {
        this.anchorViewList.setValue(this, $$delegatedProperties[1], list);
    }

    public final int getOverlayColor() {
        return ((Number) this.overlayColor.getValue(this, $$delegatedProperties[2])).intValue();
    }

    public final void setOverlayColor(int i) {
        this.overlayColor.setValue(this, $$delegatedProperties[2], Integer.valueOf(i));
    }

    public final int getOverlayPaddingColor() {
        return ((Number) this.overlayPaddingColor.getValue(this, $$delegatedProperties[3])).intValue();
    }

    public final void setOverlayPaddingColor(int i) {
        this.overlayPaddingColor.setValue(this, $$delegatedProperties[3], Integer.valueOf(i));
    }

    public final Shader getOverlayPaddingShader() {
        return (Shader) this.overlayPaddingShader.getValue(this, $$delegatedProperties[4]);
    }

    public final void setOverlayPaddingShader(Shader shader) {
        this.overlayPaddingShader.setValue(this, $$delegatedProperties[4], shader);
    }

    public final float getOverlayPadding() {
        return ((Number) this.overlayPadding.getValue(this, $$delegatedProperties[5])).floatValue();
    }

    public final void setOverlayPadding(float f) {
        this.overlayPadding.setValue(this, $$delegatedProperties[5], Float.valueOf(f));
    }

    public final Point getOverlayPosition() {
        return (Point) this.overlayPosition.getValue(this, $$delegatedProperties[6]);
    }

    public final void setOverlayPosition(Point point) {
        this.overlayPosition.setValue(this, $$delegatedProperties[6], point);
    }

    public final BalloonOverlayShape getBalloonOverlayShape() {
        return (BalloonOverlayShape) this.balloonOverlayShape.getValue(this, $$delegatedProperties[7]);
    }

    public final void setBalloonOverlayShape(BalloonOverlayShape balloonOverlayShape) {
        Intrinsics.checkNotNullParameter(balloonOverlayShape, "<set-?>");
        this.balloonOverlayShape.setValue(this, $$delegatedProperties[7], balloonOverlayShape);
    }

    public final void forceInvalidate() {
        this.invalidated = true;
        invalidate();
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Bitmap bitmap;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.invalidated || (bitmap = this.bitmap) == null || (bitmap != null && bitmap.isRecycled())) {
            prepareBitmap();
        }
        Bitmap bitmap2 = this.bitmap;
        if (bitmap2 == null || bitmap2.isRecycled()) {
            return;
        }
        canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
    }

    private final void prepareBitmap() {
        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }
        View anchorView = getAnchorView();
        if (anchorView == null || anchorView.getWidth() != 0) {
            View anchorView2 = getAnchorView();
            if (anchorView2 == null || anchorView2.getHeight() != 0) {
                Bitmap bitmap = this.bitmap;
                if (bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
                this.bitmap = bitmapCreateBitmap;
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                Paint paint = this.paint;
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
                paint.setColor(getOverlayColor());
                canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.paint);
                Paint paint2 = this.paint;
                paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
                paint2.setColor(0);
                Paint paint3 = this.paddingColorPaint;
                paint3.setColor(getOverlayPaddingColor());
                paint3.setStyle(Paint.Style.STROKE);
                paint3.setStrokeWidth(getOverlayPadding());
                paint3.setShader(getOverlayPaddingShader());
                List<View> anchorViewList = getAnchorViewList();
                if (anchorViewList == null || anchorViewList.isEmpty()) {
                    addFocusViewInOverlay(getAnchorView(), canvas);
                } else {
                    List<View> anchorViewList2 = getAnchorViewList();
                    if (anchorViewList2 != null) {
                        Iterator<T> it = anchorViewList2.iterator();
                        while (it.hasNext()) {
                            addFocusViewInOverlay((View) it.next(), canvas);
                        }
                    }
                }
                this.invalidated = false;
            }
        }
    }

    private final void addFocusViewInOverlay(View view, Canvas canvas) {
        RectF rectF;
        if (view != null) {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            Point overlayPosition = getOverlayPosition();
            if (overlayPosition != null) {
                rectF = new RectF(overlayPosition.x - getOverlayPadding(), (overlayPosition.y - getOverlayPadding()) + getStatusBarHeight(), overlayPosition.x + view.getWidth() + getOverlayPadding(), overlayPosition.y + view.getHeight() + getOverlayPadding() + getStatusBarHeight());
            } else {
                rectF = new RectF(rect.left - getOverlayPadding(), rect.top - getOverlayPadding(), rect.right + getOverlayPadding(), rect.bottom + getOverlayPadding());
            }
            float overlayPadding = getOverlayPadding() / 2;
            RectF rectF2 = new RectF(rectF);
            rectF2.inset(overlayPadding, overlayPadding);
            BalloonOverlayShape balloonOverlayShape = getBalloonOverlayShape();
            if (balloonOverlayShape instanceof BalloonOverlayEmpty) {
                return;
            }
            if (balloonOverlayShape instanceof BalloonOverlayRect) {
                canvas.drawRect(rectF, this.paint);
                canvas.drawRect(rectF2, this.paddingColorPaint);
                return;
            }
            if (balloonOverlayShape instanceof BalloonOverlayOval) {
                canvas.drawOval(rectF, this.paint);
                canvas.drawOval(rectF2, this.paddingColorPaint);
                return;
            }
            if (balloonOverlayShape instanceof BalloonOverlayCircle) {
                BalloonOverlayCircle balloonOverlayCircle = (BalloonOverlayCircle) balloonOverlayShape;
                Float radius = balloonOverlayCircle.getRadius();
                if (radius != null) {
                    float fFloatValue = radius.floatValue();
                    canvas.drawCircle(rectF.centerX(), rectF.centerY(), fFloatValue, this.paint);
                    canvas.drawCircle(rectF2.centerX(), rectF2.centerY(), fFloatValue - overlayPadding, this.paddingColorPaint);
                }
                Integer radiusRes = balloonOverlayCircle.getRadiusRes();
                if (radiusRes != null) {
                    int iIntValue = radiusRes.intValue();
                    float fCenterX = rectF.centerX();
                    float fCenterY = rectF.centerY();
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                    canvas.drawCircle(fCenterX, fCenterY, ContextExtensionKt.dimen(context, iIntValue), this.paint);
                    float fCenterX2 = rectF2.centerX();
                    float fCenterY2 = rectF2.centerY();
                    Context context2 = getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                    canvas.drawCircle(fCenterX2, fCenterY2, ContextExtensionKt.dimen(context2, iIntValue) - overlayPadding, this.paddingColorPaint);
                    return;
                }
                return;
            }
            if (!(balloonOverlayShape instanceof BalloonOverlayRoundRect)) {
                throw new NoWhenBranchMatchedException();
            }
            BalloonOverlayRoundRect balloonOverlayRoundRect = (BalloonOverlayRoundRect) balloonOverlayShape;
            Pair<Float, Float> radiusPair = balloonOverlayRoundRect.getRadiusPair();
            if (radiusPair != null) {
                canvas.drawRoundRect(rectF, radiusPair.getFirst().floatValue(), radiusPair.getSecond().floatValue(), this.paint);
                canvas.drawRoundRect(rectF2, radiusPair.getFirst().floatValue() - overlayPadding, radiusPair.getSecond().floatValue() - overlayPadding, this.paddingColorPaint);
            }
            Pair<Integer, Integer> radiusResPair = balloonOverlayRoundRect.getRadiusResPair();
            if (radiusResPair != null) {
                Context context3 = getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
                float fDimen = ContextExtensionKt.dimen(context3, radiusResPair.getFirst().intValue());
                Context context4 = getContext();
                Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
                canvas.drawRoundRect(rectF, fDimen, ContextExtensionKt.dimen(context4, radiusResPair.getSecond().intValue()), this.paint);
                Context context5 = getContext();
                Intrinsics.checkNotNullExpressionValue(context5, "getContext(...)");
                float fDimen2 = ContextExtensionKt.dimen(context5, radiusResPair.getFirst().intValue()) - overlayPadding;
                Context context6 = getContext();
                Intrinsics.checkNotNullExpressionValue(context6, "getContext(...)");
                canvas.drawRoundRect(rectF2, fDimen2, ContextExtensionKt.dimen(context6, radiusResPair.getSecond().intValue()) - overlayPadding, this.paddingColorPaint);
            }
        }
    }

    private final int getStatusBarHeight() {
        Rect rect = new Rect();
        Context context = getContext();
        if (!(context instanceof Activity)) {
            return 0;
        }
        ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect.top;
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        this.invalidated = true;
    }
}
