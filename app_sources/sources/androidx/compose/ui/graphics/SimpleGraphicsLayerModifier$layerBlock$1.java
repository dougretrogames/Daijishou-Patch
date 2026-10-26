package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: GraphicsLayerModifier.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class SimpleGraphicsLayerModifier$layerBlock$1 extends Lambda implements Function1<GraphicsLayerScope, Unit> {
    final /* synthetic */ SimpleGraphicsLayerModifier this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    SimpleGraphicsLayerModifier$layerBlock$1(SimpleGraphicsLayerModifier simpleGraphicsLayerModifier) {
        super(1);
        this.this$0 = simpleGraphicsLayerModifier;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
        invoke2(graphicsLayerScope);
        return Unit.INSTANCE;
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GraphicsLayerScope graphicsLayerScope) {
        graphicsLayerScope.setScaleX(this.this$0.getScaleX());
        graphicsLayerScope.setScaleY(this.this$0.getScaleY());
        graphicsLayerScope.setAlpha(this.this$0.getAlpha());
        graphicsLayerScope.setTranslationX(this.this$0.getTranslationX());
        graphicsLayerScope.setTranslationY(this.this$0.getTranslationY());
        graphicsLayerScope.setShadowElevation(this.this$0.getShadowElevation());
        graphicsLayerScope.setRotationX(this.this$0.getRotationX());
        graphicsLayerScope.setRotationY(this.this$0.getRotationY());
        graphicsLayerScope.setRotationZ(this.this$0.getRotationZ());
        graphicsLayerScope.setCameraDistance(this.this$0.getCameraDistance());
        graphicsLayerScope.mo724setTransformOrigin__ExYCQ(this.this$0.getTransformOrigin());
        graphicsLayerScope.setShape(this.this$0.getShape());
        graphicsLayerScope.setClip(this.this$0.getClip());
        graphicsLayerScope.setRenderEffect(this.this$0.getRenderEffect());
        graphicsLayerScope.mo721setAmbientShadowColor8_81llA(this.this$0.getAmbientShadowColor());
        graphicsLayerScope.mo723setSpotShadowColor8_81llA(this.this$0.getSpotShadowColor());
        graphicsLayerScope.mo722setCompositingStrategyaDBOjCE(this.this$0.getCompositingStrategy());
    }
}
