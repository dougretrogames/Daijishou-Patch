package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapConfig;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: Vector.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u00106\u001a\u00020\u000eH\u0002J\b\u00107\u001a\u00020\"H\u0016J\f\u00108\u001a\u00020\u000e*\u00020\rH\u0016J\u001c\u00108\u001a\u00020\u000e*\u00020\r2\u0006\u00109\u001a\u00020-2\b\u0010:\u001a\u0004\u0018\u00010\u0011R\u001a\u0010\u0005\u001a\u00020\u00068@X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u00118@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001aX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020(X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010)R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R1\u00100\u001a\u00020(2\u0006\u0010\u0010\u001a\u00020(8@@@X\u0080\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b5\u0010\u0018\u001a\u0004\b1\u00102\"\u0004\b3\u00104\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006;"}, d2 = {"Landroidx/compose/ui/graphics/vector/VectorComponent;", "Landroidx/compose/ui/graphics/vector/VNode;", "root", "Landroidx/compose/ui/graphics/vector/GroupComponent;", "(Landroidx/compose/ui/graphics/vector/GroupComponent;)V", "cacheBitmapConfig", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "getCacheBitmapConfig-_sVssgQ$ui_release", "()I", "cacheDrawScope", "Landroidx/compose/ui/graphics/vector/DrawCache;", "drawVectorBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "<set-?>", "Landroidx/compose/ui/graphics/ColorFilter;", "intrinsicColorFilter", "getIntrinsicColorFilter$ui_release", "()Landroidx/compose/ui/graphics/ColorFilter;", "setIntrinsicColorFilter$ui_release", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "intrinsicColorFilter$delegate", "Landroidx/compose/runtime/MutableState;", "invalidateCallback", "Lkotlin/Function0;", "getInvalidateCallback$ui_release", "()Lkotlin/jvm/functions/Function0;", "setInvalidateCallback$ui_release", "(Lkotlin/jvm/functions/Function0;)V", "isDirty", "", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "previousDrawSize", "Landroidx/compose/ui/geometry/Size;", "J", "getRoot", "()Landroidx/compose/ui/graphics/vector/GroupComponent;", "rootScaleX", "", "rootScaleY", "tintFilter", "viewportSize", "getViewportSize-NH-jbRc$ui_release", "()J", "setViewportSize-uvyYCjk$ui_release", "(J)V", "viewportSize$delegate", "doInvalidate", "toString", "draw", "alpha", "colorFilter", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VectorComponent extends VNode {
    public static final int $stable = 8;
    private final DrawCache cacheDrawScope;
    private final Function1<DrawScope, Unit> drawVectorBlock;

    /* JADX INFO: renamed from: intrinsicColorFilter$delegate, reason: from kotlin metadata */
    private final MutableState intrinsicColorFilter;
    private Function0<Unit> invalidateCallback;
    private boolean isDirty;
    private String name;
    private long previousDrawSize;
    private final GroupComponent root;
    private float rootScaleX;
    private float rootScaleY;
    private ColorFilter tintFilter;

    /* JADX INFO: renamed from: viewportSize$delegate, reason: from kotlin metadata */
    private final MutableState viewportSize;

    public VectorComponent(GroupComponent groupComponent) {
        super(null);
        this.root = groupComponent;
        groupComponent.setInvalidateListener$ui_release(new AnonymousClass1());
        this.name = "";
        this.isDirty = true;
        this.cacheDrawScope = new DrawCache();
        this.invalidateCallback = VectorComponent$invalidateCallback$1.INSTANCE;
        this.intrinsicColorFilter = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.viewportSize = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Size.m346boximpl(Size.INSTANCE.m367getZeroNHjbRc()), null, 2, null);
        this.previousDrawSize = Size.INSTANCE.m366getUnspecifiedNHjbRc();
        this.rootScaleX = 1.0f;
        this.rootScaleY = 1.0f;
        this.drawVectorBlock = new VectorComponent$drawVectorBlock$1(this);
    }

    public final GroupComponent getRoot() {
        return this.root;
    }

    /* JADX INFO: renamed from: androidx.compose.ui.graphics.vector.VectorComponent$1, reason: invalid class name */
    /* JADX INFO: compiled from: Vector.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/graphics/vector/VNode;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass1 extends Lambda implements Function1<VNode, Unit> {
        AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(VNode vNode) {
            invoke2(vNode);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(VNode vNode) {
            VectorComponent.this.doInvalidate();
        }
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doInvalidate() {
        this.isDirty = true;
        this.invalidateCallback.invoke();
    }

    /* JADX INFO: renamed from: getCacheBitmapConfig-_sVssgQ$ui_release, reason: not valid java name */
    public final int m1175getCacheBitmapConfig_sVssgQ$ui_release() {
        ImageBitmap mCachedImage = this.cacheDrawScope.getMCachedImage();
        return mCachedImage != null ? mCachedImage.mo397getConfig_sVssgQ() : ImageBitmapConfig.INSTANCE.m752getArgb8888_sVssgQ();
    }

    public final Function0<Unit> getInvalidateCallback$ui_release() {
        return this.invalidateCallback;
    }

    public final void setInvalidateCallback$ui_release(Function0<Unit> function0) {
        this.invalidateCallback = function0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ColorFilter getIntrinsicColorFilter$ui_release() {
        return (ColorFilter) this.intrinsicColorFilter.getValue();
    }

    public final void setIntrinsicColorFilter$ui_release(ColorFilter colorFilter) {
        this.intrinsicColorFilter.setValue(colorFilter);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getViewportSize-NH-jbRc$ui_release, reason: not valid java name */
    public final long m1176getViewportSizeNHjbRc$ui_release() {
        return ((Size) this.viewportSize.getValue()).getPackedValue();
    }

    /* JADX INFO: renamed from: setViewportSize-uvyYCjk$ui_release, reason: not valid java name */
    public final void m1177setViewportSizeuvyYCjk$ui_release(long j) {
        this.viewportSize.setValue(Size.m346boximpl(j));
    }

    public final void draw(DrawScope drawScope, float f, ColorFilter colorFilter) {
        int iM752getArgb8888_sVssgQ;
        if (this.root.getIsTintable() && this.root.getTintColor() != Color.INSTANCE.m566getUnspecified0d7_KjU() && VectorKt.tintableWithAlphaMask(getIntrinsicColorFilter$ui_release()) && VectorKt.tintableWithAlphaMask(colorFilter)) {
            iM752getArgb8888_sVssgQ = ImageBitmapConfig.INSTANCE.m751getAlpha8_sVssgQ();
        } else {
            iM752getArgb8888_sVssgQ = ImageBitmapConfig.INSTANCE.m752getArgb8888_sVssgQ();
        }
        int i = iM752getArgb8888_sVssgQ;
        if (this.isDirty || !Size.m354equalsimpl0(this.previousDrawSize, drawScope.mo1081getSizeNHjbRc()) || !ImageBitmapConfig.m747equalsimpl0(i, m1175getCacheBitmapConfig_sVssgQ$ui_release())) {
            this.tintFilter = ImageBitmapConfig.m747equalsimpl0(i, ImageBitmapConfig.INSTANCE.m751getAlpha8_sVssgQ()) ? ColorFilter.Companion.m571tintxETnrds$default(ColorFilter.INSTANCE, this.root.getTintColor(), 0, 2, null) : null;
            this.rootScaleX = Size.m358getWidthimpl(drawScope.mo1081getSizeNHjbRc()) / Size.m358getWidthimpl(m1176getViewportSizeNHjbRc$ui_release());
            this.rootScaleY = Size.m355getHeightimpl(drawScope.mo1081getSizeNHjbRc()) / Size.m355getHeightimpl(m1176getViewportSizeNHjbRc$ui_release());
            this.cacheDrawScope.m1158drawCachedImageFqjB98A(i, IntSizeKt.IntSize((int) Math.ceil(Size.m358getWidthimpl(drawScope.mo1081getSizeNHjbRc())), (int) Math.ceil(Size.m355getHeightimpl(drawScope.mo1081getSizeNHjbRc()))), drawScope, drawScope.getLayoutDirection(), this.drawVectorBlock);
            this.isDirty = false;
            this.previousDrawSize = drawScope.mo1081getSizeNHjbRc();
        }
        if (colorFilter == null) {
            if (getIntrinsicColorFilter$ui_release() != null) {
                colorFilter = getIntrinsicColorFilter$ui_release();
            } else {
                colorFilter = this.tintFilter;
            }
        }
        this.cacheDrawScope.drawInto(drawScope, f, colorFilter);
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public void draw(DrawScope drawScope) {
        draw(drawScope, 1.0f, null);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Params: \tname: ");
        sb.append(this.name).append("\n\tviewportWidth: ");
        sb.append(Size.m358getWidthimpl(m1176getViewportSizeNHjbRc$ui_release())).append("\n\tviewportHeight: ");
        sb.append(Size.m355getHeightimpl(m1176getViewportSizeNHjbRc$ui_release())).append("\n");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
