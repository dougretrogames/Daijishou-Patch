package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.Brush;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: VectorCompose.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/graphics/vector/PathComponent;", "it", "Landroidx/compose/ui/graphics/Brush;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class VectorComposeKt$Path$2$6 extends Lambda implements Function2<PathComponent, Brush, Unit> {
    public static final VectorComposeKt$Path$2$6 INSTANCE = new VectorComposeKt$Path$2$6();

    VectorComposeKt$Path$2$6() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Brush brush) {
        invoke2(pathComponent, brush);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(PathComponent pathComponent, Brush brush) {
        pathComponent.setStroke(brush);
    }
}
