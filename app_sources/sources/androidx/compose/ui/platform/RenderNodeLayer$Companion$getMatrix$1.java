package androidx.compose.ui.platform;

import android.graphics.Matrix;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: RenderNodeLayer.android.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "rn", "Landroidx/compose/ui/platform/DeviceRenderNode;", "matrix", "Landroid/graphics/Matrix;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class RenderNodeLayer$Companion$getMatrix$1 extends Lambda implements Function2<DeviceRenderNode, Matrix, Unit> {
    public static final RenderNodeLayer$Companion$getMatrix$1 INSTANCE = new RenderNodeLayer$Companion$getMatrix$1();

    RenderNodeLayer$Companion$getMatrix$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(DeviceRenderNode deviceRenderNode, Matrix matrix) {
        invoke2(deviceRenderNode, matrix);
        return Unit.INSTANCE;
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(DeviceRenderNode deviceRenderNode, Matrix matrix) {
        deviceRenderNode.getMatrix(matrix);
    }
}
