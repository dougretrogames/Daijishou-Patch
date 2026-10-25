package androidx.compose.ui.draw;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.RenderEffectKt;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: Blur.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class BlurKt$blur$1 extends Lambda implements Function1<GraphicsLayerScope, Unit> {
    final /* synthetic */ boolean $clip;
    final /* synthetic */ Shape $edgeTreatment;
    final /* synthetic */ float $radiusX;
    final /* synthetic */ float $radiusY;
    final /* synthetic */ int $tileMode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BlurKt$blur$1(float f, float f2, int i, Shape shape, boolean z) {
        super(1);
        this.$radiusX = f;
        this.$radiusY = f2;
        this.$tileMode = i;
        this.$edgeTreatment = shape;
        this.$clip = z;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
        invoke2(graphicsLayerScope);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GraphicsLayerScope graphicsLayerScope) {
        float f = graphicsLayerScope.mo1785toPx0680j_4(this.$radiusX);
        float f2 = graphicsLayerScope.mo1785toPx0680j_4(this.$radiusY);
        graphicsLayerScope.setRenderEffect((f <= 0.0f || f2 <= 0.0f) ? null : RenderEffectKt.m839BlurEffect3YTHUZs(f, f2, this.$tileMode));
        Shape rectangleShape = this.$edgeTreatment;
        if (rectangleShape == null) {
            rectangleShape = RectangleShapeKt.getRectangleShape();
        }
        graphicsLayerScope.setShape(rectangleShape);
        graphicsLayerScope.setClip(this.$clip);
    }
}
