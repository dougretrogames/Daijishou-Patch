package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: Vector.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class VectorComponent$drawVectorBlock$1 extends Lambda implements Function1<DrawScope, Unit> {
    final /* synthetic */ VectorComponent this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    VectorComponent$drawVectorBlock$1(VectorComponent vectorComponent) {
        super(1);
        this.this$0 = vectorComponent;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
        invoke2(drawScope);
        return Unit.INSTANCE;
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(DrawScope drawScope) {
        GroupComponent root = this.this$0.getRoot();
        VectorComponent vectorComponent = this.this$0;
        float f = vectorComponent.rootScaleX;
        float f2 = vectorComponent.rootScaleY;
        long jM305getZeroF1C5BW0 = Offset.INSTANCE.m305getZeroF1C5BW0();
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo1006getSizeNHjbRc = drawContext.mo1006getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo1013scale0AR0LA0(f, f2, jM305getZeroF1C5BW0);
        root.draw(drawScope);
        drawContext.getCanvas().restore();
        drawContext.mo1007setSizeuvyYCjk(jMo1006getSizeNHjbRc);
    }
}
