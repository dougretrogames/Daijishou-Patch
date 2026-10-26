package androidx.compose.ui.node;

import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: LayoutNodeLayoutDelegate.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class LayoutNodeLayoutDelegate$LookaheadPassDelegate$placeAt$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Owner $owner;
    final /* synthetic */ long $position;
    final /* synthetic */ LayoutNodeLayoutDelegate this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    LayoutNodeLayoutDelegate$LookaheadPassDelegate$placeAt$2(LayoutNodeLayoutDelegate layoutNodeLayoutDelegate, Owner owner, long j) {
        super(0);
        this.this$0 = layoutNodeLayoutDelegate;
        this.$owner = owner;
        this.$position = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        LookaheadDelegate lookaheadDelegate;
        Placeable.PlacementScope placementScope = null;
        if (LayoutNodeLayoutDelegateKt.isOutMostLookaheadRoot(this.this$0.layoutNode)) {
            NodeCoordinator wrappedBy = this.this$0.getOuterCoordinator().getWrappedBy();
            if (wrappedBy != null) {
                placementScope = wrappedBy.getPlacementScope();
            }
        } else {
            NodeCoordinator wrappedBy2 = this.this$0.getOuterCoordinator().getWrappedBy();
            if (wrappedBy2 != null && (lookaheadDelegate = wrappedBy2.getLookaheadDelegate()) != null) {
                placementScope = lookaheadDelegate.getPlacementScope();
            }
        }
        if (placementScope == null) {
            placementScope = this.$owner.getPlacementScope();
        }
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.this$0;
        long j = this.$position;
        LookaheadDelegate lookaheadDelegate2 = layoutNodeLayoutDelegate.getOuterCoordinator().getLookaheadDelegate();
        Intrinsics.checkNotNull(lookaheadDelegate2);
        Placeable.PlacementScope.m1878place70tqf50$default(placementScope, lookaheadDelegate2, j, 0.0f, 2, null);
    }
}
