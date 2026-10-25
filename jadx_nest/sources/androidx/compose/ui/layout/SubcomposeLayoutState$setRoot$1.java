package androidx.compose.ui.layout;

import androidx.compose.ui.node.LayoutNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: SubcomposeLayout.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/node/LayoutNode;", "it", "Landroidx/compose/ui/layout/SubcomposeLayoutState;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class SubcomposeLayoutState$setRoot$1 extends Lambda implements Function2<LayoutNode, SubcomposeLayoutState, Unit> {
    final /* synthetic */ SubcomposeLayoutState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SubcomposeLayoutState$setRoot$1(SubcomposeLayoutState subcomposeLayoutState) {
        super(2);
        this.this$0 = subcomposeLayoutState;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode, SubcomposeLayoutState subcomposeLayoutState) {
        invoke2(layoutNode, subcomposeLayoutState);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(LayoutNode layoutNode, SubcomposeLayoutState subcomposeLayoutState) {
        SubcomposeLayoutState subcomposeLayoutState2 = this.this$0;
        LayoutNodeSubcompositionsState subcompositionsState = layoutNode.getSubcompositionsState();
        if (subcompositionsState == null) {
            subcompositionsState = new LayoutNodeSubcompositionsState(layoutNode, this.this$0.slotReusePolicy);
            layoutNode.setSubcompositionsState$ui_release(subcompositionsState);
        }
        subcomposeLayoutState2._state = subcompositionsState;
        this.this$0.getState().makeSureStateIsConsistent();
        this.this$0.getState().setSlotReusePolicy(this.this$0.slotReusePolicy);
    }
}
