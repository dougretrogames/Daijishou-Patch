package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.PathFillType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: VectorCompose.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/vector/PathComponent;", "it", "Landroidx/compose/ui/graphics/PathFillType;", "invoke-pweu1eQ", "(Landroidx/compose/ui/graphics/vector/PathComponent;I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class VectorComposeKt$Path$2$3 extends Lambda implements Function2<PathComponent, PathFillType, Unit> {
    public static final VectorComposeKt$Path$2$3 INSTANCE = new VectorComposeKt$Path$2$3();

    VectorComposeKt$Path$2$3() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, PathFillType pathFillType) {
        m1180invokepweu1eQ(pathComponent, pathFillType.getValue());
        return Unit.INSTANCE;
    }

    /* INFO: renamed from: invoke-pweu1eQ, reason: not valid java name */
    public final void m1180invokepweu1eQ(PathComponent pathComponent, int i) {
        pathComponent.m1172setPathFillTypeoQ8Xj4U(i);
    }
}
