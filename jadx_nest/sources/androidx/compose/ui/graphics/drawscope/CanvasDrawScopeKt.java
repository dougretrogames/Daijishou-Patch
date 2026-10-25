package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Path;
import kotlin.Metadata;

/* JADX INFO: compiled from: CanvasDrawScope.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, d2 = {"asDrawTransform", "Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CanvasDrawScopeKt {

    /* JADX INFO: renamed from: androidx.compose.ui.graphics.drawscope.CanvasDrawScopeKt$asDrawTransform$1, reason: invalid class name */
    /* JADX INFO: compiled from: CanvasDrawScope.kt */
    @Metadata(d1 = {"\u0000?\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J:\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000eH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J(\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J\"\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0003H\u0016ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ*\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u0003H\u0016ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u001a\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020&H\u0016ø\u0001\u0000¢\u0006\u0004\b'\u0010(J\u0018\u0010)\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R\u001a\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\b\u0010\u0005\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006*"}, d2 = {"androidx/compose/ui/graphics/drawscope/CanvasDrawScopeKt$asDrawTransform$1", "Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "center", "Landroidx/compose/ui/geometry/Offset;", "getCenter-F1C5BW0", "()J", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "clipPath", "", "path", "Landroidx/compose/ui/graphics/Path;", "clipOp", "Landroidx/compose/ui/graphics/ClipOp;", "clipPath-mtrdD-E", "(Landroidx/compose/ui/graphics/Path;I)V", "clipRect", "left", "", "top", "right", "bottom", "clipRect-N_I0leg", "(FFFFI)V", "inset", "rotate", "degrees", "pivot", "rotate-Uv8p0NA", "(FJ)V", "scale", "scaleX", "scaleY", "scale-0AR0LA0", "(FFJ)V", "transform", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transform-58bKbWc", "([F)V", "translate", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass1 implements DrawTransform {
        final /* synthetic */ DrawContext $this_asDrawTransform;

        AnonymousClass1(DrawContext drawContext) {
            this.$this_asDrawTransform = drawContext;
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
        /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
        public long mo1011getSizeNHjbRc() {
            return this.$this_asDrawTransform.mo1006getSizeNHjbRc();
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
        /* JADX INFO: renamed from: getCenter-F1C5BW0, reason: not valid java name */
        public long mo1010getCenterF1C5BW0() {
            return SizeKt.m368getCenteruvyYCjk(mo1011getSizeNHjbRc());
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
        public void inset(float left, float top, float right, float bottom) {
            Canvas canvas = this.$this_asDrawTransform.getCanvas();
            DrawContext drawContext = this.$this_asDrawTransform;
            long jSize = SizeKt.Size(Size.m358getWidthimpl(mo1011getSizeNHjbRc()) - (right + left), Size.m355getHeightimpl(mo1011getSizeNHjbRc()) - (bottom + top));
            if (Size.m358getWidthimpl(jSize) < 0.0f || Size.m355getHeightimpl(jSize) < 0.0f) {
                throw new IllegalArgumentException("Width and height must be greater than or equal to zero".toString());
            }
            drawContext.mo1007setSizeuvyYCjk(jSize);
            canvas.translate(left, top);
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
        /* JADX INFO: renamed from: clipRect-N_I0leg, reason: not valid java name */
        public void mo1009clipRectN_I0leg(float left, float top, float right, float bottom, int clipOp) {
            this.$this_asDrawTransform.getCanvas().mo384clipRectN_I0leg(left, top, right, bottom, clipOp);
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
        /* JADX INFO: renamed from: clipPath-mtrdD-E, reason: not valid java name */
        public void mo1008clipPathmtrdDE(Path path, int clipOp) {
            this.$this_asDrawTransform.getCanvas().mo383clipPathmtrdDE(path, clipOp);
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
        public void translate(float left, float top) {
            this.$this_asDrawTransform.getCanvas().translate(left, top);
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
        /* JADX INFO: renamed from: rotate-Uv8p0NA, reason: not valid java name */
        public void mo1012rotateUv8p0NA(float degrees, long pivot) {
            Canvas canvas = this.$this_asDrawTransform.getCanvas();
            canvas.translate(Offset.m289getXimpl(pivot), Offset.m290getYimpl(pivot));
            canvas.rotate(degrees);
            canvas.translate(-Offset.m289getXimpl(pivot), -Offset.m290getYimpl(pivot));
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
        /* JADX INFO: renamed from: scale-0AR0LA0, reason: not valid java name */
        public void mo1013scale0AR0LA0(float scaleX, float scaleY, long pivot) {
            Canvas canvas = this.$this_asDrawTransform.getCanvas();
            canvas.translate(Offset.m289getXimpl(pivot), Offset.m290getYimpl(pivot));
            canvas.scale(scaleX, scaleY);
            canvas.translate(-Offset.m289getXimpl(pivot), -Offset.m290getYimpl(pivot));
        }

        @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
        /* JADX INFO: renamed from: transform-58bKbWc, reason: not valid java name */
        public void mo1014transform58bKbWc(float[] matrix) {
            this.$this_asDrawTransform.getCanvas().mo385concat58bKbWc(matrix);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawTransform asDrawTransform(DrawContext drawContext) {
        return new AnonymousClass1(drawContext);
    }
}
