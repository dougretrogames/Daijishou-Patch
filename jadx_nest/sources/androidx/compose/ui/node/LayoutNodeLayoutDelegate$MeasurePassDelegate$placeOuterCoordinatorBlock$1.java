package androidx.compose.ui.node;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: LayoutNodeLayoutDelegate.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class LayoutNodeLayoutDelegate$MeasurePassDelegate$placeOuterCoordinatorBlock$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ LayoutNodeLayoutDelegate this$0;
    final /* synthetic */ LayoutNodeLayoutDelegate.MeasurePassDelegate this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LayoutNodeLayoutDelegate$MeasurePassDelegate$placeOuterCoordinatorBlock$1(LayoutNodeLayoutDelegate layoutNodeLayoutDelegate, LayoutNodeLayoutDelegate.MeasurePassDelegate measurePassDelegate) {
        super(0);
        this.this$0 = layoutNodeLayoutDelegate;
        this.this$1 = measurePassDelegate;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Placeable.PlacementScope placementScope;
        NodeCoordinator wrappedBy = this.this$0.getOuterCoordinator().getWrappedBy();
        if (wrappedBy == null || (placementScope = wrappedBy.getPlacementScope()) == null) {
            placementScope = LayoutNodeKt.requireOwner(this.this$0.layoutNode).getPlacementScope();
        }
        Placeable.PlacementScope placementScope2 = placementScope;
        LayoutNodeLayoutDelegate.MeasurePassDelegate measurePassDelegate = this.this$1;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.this$0;
        Function1<? super GraphicsLayerScope, Unit> function1 = measurePassDelegate.placeOuterCoordinatorLayerBlock;
        if (function1 == null) {
            placementScope2.m1882place70tqf50(layoutNodeLayoutDelegate.getOuterCoordinator(), measurePassDelegate.placeOuterCoordinatorPosition, measurePassDelegate.placeOuterCoordinatorZIndex);
        } else {
            placementScope2.m1887placeWithLayeraW9wM(layoutNodeLayoutDelegate.getOuterCoordinator(), measurePassDelegate.placeOuterCoordinatorPosition, measurePassDelegate.placeOuterCoordinatorZIndex, function1);
        }
    }
}
