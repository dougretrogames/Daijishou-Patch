package androidx.compose.ui.node;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: LayoutNodeLayoutDelegate.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class LayoutNodeLayoutDelegate$performLookaheadMeasure$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ long $constraints;
    final /* synthetic */ LayoutNodeLayoutDelegate this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    LayoutNodeLayoutDelegate$performLookaheadMeasure$1(LayoutNodeLayoutDelegate layoutNodeLayoutDelegate, long j) {
        super(0);
        this.this$0 = layoutNodeLayoutDelegate;
        this.$constraints = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        LookaheadDelegate lookaheadDelegate = this.this$0.getOuterCoordinator().getLookaheadDelegate();
        Intrinsics.checkNotNull(lookaheadDelegate);
        lookaheadDelegate.mo1824measureBRTryo0(this.$constraints);
    }
}
