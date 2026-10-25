package androidx.compose.ui.layout;

import androidx.compose.ui.node.NodeCoordinator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: IntermediateLayoutModifierNode.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/LayoutCoordinates;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class IntermediateLayoutModifierNode$localLookaheadScope$1 extends Lambda implements Function0<LayoutCoordinates> {
    final /* synthetic */ IntermediateLayoutModifierNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    IntermediateLayoutModifierNode$localLookaheadScope$1(IntermediateLayoutModifierNode intermediateLayoutModifierNode) {
        super(0);
        this.this$0 = intermediateLayoutModifierNode;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final LayoutCoordinates invoke() {
        NodeCoordinator coordinator$ui_release = this.this$0.getCoordinator();
        Intrinsics.checkNotNull(coordinator$ui_release);
        return coordinator$ui_release;
    }
}
