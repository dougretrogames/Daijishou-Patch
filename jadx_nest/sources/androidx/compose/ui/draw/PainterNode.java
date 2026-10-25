package androidx.compose.ui.draw;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.ScaleFactorKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: PainterModifier.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B?\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\u001a\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.H\u0002ø\u0001\u0000¢\u0006\u0004\b0\u00101J\u001a\u00102\u001a\u0002032\u0006\u00104\u001a\u000203H\u0002ø\u0001\u0000¢\u0006\u0004\b5\u00101J\b\u00106\u001a\u000207H\u0016J\f\u00108\u001a\u000209*\u00020:H\u0016J\u0016\u0010;\u001a\u00020\u0007*\u00020.H\u0002ø\u0001\u0000¢\u0006\u0004\b<\u0010=J\u0016\u0010>\u001a\u00020\u0007*\u00020.H\u0002ø\u0001\u0000¢\u0006\u0004\b?\u0010=J\u001c\u0010@\u001a\u00020A*\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020AH\u0016J\u001c\u0010F\u001a\u00020A*\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010G\u001a\u00020AH\u0016J&\u0010H\u001a\u00020I*\u00020J2\u0006\u0010C\u001a\u00020K2\u0006\u00104\u001a\u000203H\u0016ø\u0001\u0000¢\u0006\u0004\bL\u0010MJ\u001c\u0010N\u001a\u00020A*\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020AH\u0016J\u001c\u0010O\u001a\u00020A*\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010G\u001a\u00020AH\u0016R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010'\"\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b,\u0010'\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006P"}, d2 = {"Landroidx/compose/ui/draw/PainterNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/DrawModifierNode;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "sizeToIntrinsics", "", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "(Landroidx/compose/ui/graphics/painter/Painter;ZLandroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "setAlignment", "(Landroidx/compose/ui/Alignment;)V", "getAlpha", "()F", "setAlpha", "(F)V", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "setContentScale", "(Landroidx/compose/ui/layout/ContentScale;)V", "getPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "setPainter", "(Landroidx/compose/ui/graphics/painter/Painter;)V", "shouldAutoInvalidate", "getShouldAutoInvalidate", "()Z", "getSizeToIntrinsics", "setSizeToIntrinsics", "(Z)V", "useIntrinsicSize", "getUseIntrinsicSize", "calculateScaledSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "calculateScaledSize-E7KxVPU", "(J)J", "modifyConstraints", "Landroidx/compose/ui/unit/Constraints;", "constraints", "modifyConstraints-ZezNO4M", "toString", "", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "hasSpecifiedAndFiniteHeight", "hasSpecifiedAndFiniteHeight-uvyYCjk", "(J)Z", "hasSpecifiedAndFiniteWidth", "hasSpecifiedAndFiniteWidth-uvyYCjk", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class PainterNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode {
    private Alignment alignment;
    private float alpha;
    private ColorFilter colorFilter;
    private ContentScale contentScale;
    private Painter painter;
    private boolean sizeToIntrinsics;

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
    }

    public final Painter getPainter() {
        return this.painter;
    }

    public final void setPainter(Painter painter) {
        this.painter = painter;
    }

    public final boolean getSizeToIntrinsics() {
        return this.sizeToIntrinsics;
    }

    public final void setSizeToIntrinsics(boolean z) {
        this.sizeToIntrinsics = z;
    }

    public /* synthetic */ PainterNode(Painter painter, boolean z, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(painter, z, (i & 4) != 0 ? Alignment.INSTANCE.getCenter() : alignment, (i & 8) != 0 ? ContentScale.INSTANCE.getInside() : contentScale, (i & 16) != 0 ? 1.0f : f, (i & 32) != 0 ? null : colorFilter);
    }

    public final Alignment getAlignment() {
        return this.alignment;
    }

    public final void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }

    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    public final void setContentScale(ContentScale contentScale) {
        this.contentScale = contentScale;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final void setAlpha(float f) {
        this.alpha = f;
    }

    public final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.colorFilter = colorFilter;
    }

    public PainterNode(Painter painter, boolean z, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter) {
        this.painter = painter;
        this.sizeToIntrinsics = z;
        this.alignment = alignment;
        this.contentScale = contentScale;
        this.alpha = f;
        this.colorFilter = colorFilter;
    }

    private final boolean getUseIntrinsicSize() {
        return this.sizeToIntrinsics && this.painter.getIntrinsicSize() != Size.INSTANCE.m366getUnspecifiedNHjbRc();
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo177measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        Placeable placeableMo1824measureBRTryo0 = measurable.mo1824measureBRTryo0(m200modifyConstraintsZezNO4M(j));
        return MeasureScope.layout$default(measureScope, placeableMo1824measureBRTryo0.getWidth(), placeableMo1824measureBRTryo0.getHeight(), null, new PainterNode$measure$1(placeableMo1824measureBRTryo0), 4, null);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (getUseIntrinsicSize()) {
            long jM200modifyConstraintsZezNO4M = m200modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null));
            return Math.max(Constraints.m2842getMinWidthimpl(jM200modifyConstraintsZezNO4M), intrinsicMeasurable.minIntrinsicWidth(i));
        }
        return intrinsicMeasurable.minIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (getUseIntrinsicSize()) {
            long jM200modifyConstraintsZezNO4M = m200modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null));
            return Math.max(Constraints.m2842getMinWidthimpl(jM200modifyConstraintsZezNO4M), intrinsicMeasurable.maxIntrinsicWidth(i));
        }
        return intrinsicMeasurable.maxIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (getUseIntrinsicSize()) {
            long jM200modifyConstraintsZezNO4M = m200modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null));
            return Math.max(Constraints.m2841getMinHeightimpl(jM200modifyConstraintsZezNO4M), intrinsicMeasurable.minIntrinsicHeight(i));
        }
        return intrinsicMeasurable.minIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (getUseIntrinsicSize()) {
            long jM200modifyConstraintsZezNO4M = m200modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null));
            return Math.max(Constraints.m2841getMinHeightimpl(jM200modifyConstraintsZezNO4M), intrinsicMeasurable.maxIntrinsicHeight(i));
        }
        return intrinsicMeasurable.maxIntrinsicHeight(i);
    }

    /* JADX INFO: renamed from: calculateScaledSize-E7KxVPU, reason: not valid java name */
    private final long m197calculateScaledSizeE7KxVPU(long dstSize) {
        float fM358getWidthimpl;
        float fM355getHeightimpl;
        if (!getUseIntrinsicSize()) {
            return dstSize;
        }
        if (!m199hasSpecifiedAndFiniteWidthuvyYCjk(this.painter.getIntrinsicSize())) {
            fM358getWidthimpl = Size.m358getWidthimpl(dstSize);
        } else {
            fM358getWidthimpl = Size.m358getWidthimpl(this.painter.getIntrinsicSize());
        }
        if (!m198hasSpecifiedAndFiniteHeightuvyYCjk(this.painter.getIntrinsicSize())) {
            fM355getHeightimpl = Size.m355getHeightimpl(dstSize);
        } else {
            fM355getHeightimpl = Size.m355getHeightimpl(this.painter.getIntrinsicSize());
        }
        long jSize = SizeKt.Size(fM358getWidthimpl, fM355getHeightimpl);
        if (Size.m358getWidthimpl(dstSize) != 0.0f && Size.m355getHeightimpl(dstSize) != 0.0f) {
            return ScaleFactorKt.m1912timesUQTWf7w(jSize, this.contentScale.mo1815computeScaleFactorH7hwNQA(jSize, dstSize));
        }
        return Size.INSTANCE.m367getZeroNHjbRc();
    }

    /* JADX INFO: renamed from: modifyConstraints-ZezNO4M, reason: not valid java name */
    private final long m200modifyConstraintsZezNO4M(long constraints) {
        int iM2842getMinWidthimpl;
        int iM2841getMinHeightimpl;
        boolean z = Constraints.m2836getHasBoundedWidthimpl(constraints) && Constraints.m2835getHasBoundedHeightimpl(constraints);
        boolean z2 = Constraints.m2838getHasFixedWidthimpl(constraints) && Constraints.m2837getHasFixedHeightimpl(constraints);
        if ((!getUseIntrinsicSize() && z) || z2) {
            return Constraints.m2831copyZbe2FdA$default(constraints, Constraints.m2840getMaxWidthimpl(constraints), 0, Constraints.m2839getMaxHeightimpl(constraints), 0, 10, null);
        }
        long jMo1151getIntrinsicSizeNHjbRc = this.painter.getIntrinsicSize();
        if (m199hasSpecifiedAndFiniteWidthuvyYCjk(jMo1151getIntrinsicSizeNHjbRc)) {
            iM2842getMinWidthimpl = MathKt.roundToInt(Size.m358getWidthimpl(jMo1151getIntrinsicSizeNHjbRc));
        } else {
            iM2842getMinWidthimpl = Constraints.m2842getMinWidthimpl(constraints);
        }
        if (m198hasSpecifiedAndFiniteHeightuvyYCjk(jMo1151getIntrinsicSizeNHjbRc)) {
            iM2841getMinHeightimpl = MathKt.roundToInt(Size.m355getHeightimpl(jMo1151getIntrinsicSizeNHjbRc));
        } else {
            iM2841getMinHeightimpl = Constraints.m2841getMinHeightimpl(constraints);
        }
        long jM197calculateScaledSizeE7KxVPU = m197calculateScaledSizeE7KxVPU(SizeKt.Size(ConstraintsKt.m2854constrainWidthK40F9xA(constraints, iM2842getMinWidthimpl), ConstraintsKt.m2853constrainHeightK40F9xA(constraints, iM2841getMinHeightimpl)));
        return Constraints.m2831copyZbe2FdA$default(constraints, ConstraintsKt.m2854constrainWidthK40F9xA(constraints, MathKt.roundToInt(Size.m358getWidthimpl(jM197calculateScaledSizeE7KxVPU))), 0, ConstraintsKt.m2853constrainHeightK40F9xA(constraints, MathKt.roundToInt(Size.m355getHeightimpl(jM197calculateScaledSizeE7KxVPU))), 0, 10, null);
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        float fM358getWidthimpl;
        float fM355getHeightimpl;
        long jM367getZeroNHjbRc;
        long jMo1151getIntrinsicSizeNHjbRc = this.painter.getIntrinsicSize();
        if (m199hasSpecifiedAndFiniteWidthuvyYCjk(jMo1151getIntrinsicSizeNHjbRc)) {
            fM358getWidthimpl = Size.m358getWidthimpl(jMo1151getIntrinsicSizeNHjbRc);
        } else {
            fM358getWidthimpl = Size.m358getWidthimpl(contentDrawScope.mo1081getSizeNHjbRc());
        }
        if (m198hasSpecifiedAndFiniteHeightuvyYCjk(jMo1151getIntrinsicSizeNHjbRc)) {
            fM355getHeightimpl = Size.m355getHeightimpl(jMo1151getIntrinsicSizeNHjbRc);
        } else {
            fM355getHeightimpl = Size.m355getHeightimpl(contentDrawScope.mo1081getSizeNHjbRc());
        }
        long jSize = SizeKt.Size(fM358getWidthimpl, fM355getHeightimpl);
        if (Size.m358getWidthimpl(contentDrawScope.mo1081getSizeNHjbRc()) != 0.0f && Size.m355getHeightimpl(contentDrawScope.mo1081getSizeNHjbRc()) != 0.0f) {
            jM367getZeroNHjbRc = ScaleFactorKt.m1912timesUQTWf7w(jSize, this.contentScale.mo1815computeScaleFactorH7hwNQA(jSize, contentDrawScope.mo1081getSizeNHjbRc()));
        } else {
            jM367getZeroNHjbRc = Size.INSTANCE.m367getZeroNHjbRc();
        }
        long j = jM367getZeroNHjbRc;
        long jMo165alignKFBX0sM = this.alignment.mo165alignKFBX0sM(IntSizeKt.IntSize(MathKt.roundToInt(Size.m358getWidthimpl(j)), MathKt.roundToInt(Size.m355getHeightimpl(j))), IntSizeKt.IntSize(MathKt.roundToInt(Size.m358getWidthimpl(contentDrawScope.mo1081getSizeNHjbRc())), MathKt.roundToInt(Size.m355getHeightimpl(contentDrawScope.mo1081getSizeNHjbRc()))), contentDrawScope.getLayoutDirection());
        float fM3012getXimpl = IntOffset.m3012getXimpl(jMo165alignKFBX0sM);
        float fM3013getYimpl = IntOffset.m3013getYimpl(jMo165alignKFBX0sM);
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        contentDrawScope2.getDrawContext().getTransform().translate(fM3012getXimpl, fM3013getYimpl);
        this.painter.m1157drawx_KDEd0(contentDrawScope2, j, this.alpha, this.colorFilter);
        contentDrawScope2.getDrawContext().getTransform().translate(-fM3012getXimpl, -fM3013getYimpl);
        contentDrawScope.drawContent();
    }

    /* JADX INFO: renamed from: hasSpecifiedAndFiniteWidth-uvyYCjk, reason: not valid java name */
    private final boolean m199hasSpecifiedAndFiniteWidthuvyYCjk(long j) {
        if (Size.m354equalsimpl0(j, Size.INSTANCE.m366getUnspecifiedNHjbRc())) {
            return false;
        }
        float fM358getWidthimpl = Size.m358getWidthimpl(j);
        return (Float.isInfinite(fM358getWidthimpl) || Float.isNaN(fM358getWidthimpl)) ? false : true;
    }

    /* JADX INFO: renamed from: hasSpecifiedAndFiniteHeight-uvyYCjk, reason: not valid java name */
    private final boolean m198hasSpecifiedAndFiniteHeightuvyYCjk(long j) {
        if (Size.m354equalsimpl0(j, Size.INSTANCE.m366getUnspecifiedNHjbRc())) {
            return false;
        }
        float fM355getHeightimpl = Size.m355getHeightimpl(j);
        return (Float.isInfinite(fM355getHeightimpl) || Float.isNaN(fM355getHeightimpl)) ? false : true;
    }

    public String toString() {
        return "PainterModifier(painter=" + this.painter + ", sizeToIntrinsics=" + this.sizeToIntrinsics + ", alignment=" + this.alignment + ", alpha=" + this.alpha + ", colorFilter=" + this.colorFilter + ')';
    }
}
