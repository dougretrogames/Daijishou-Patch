package androidx.compose.ui.node;

import androidx.compose.ui.graphics.Canvas;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: NodeCoordinator.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class NodeCoordinator$drawBlock$1 extends Lambda implements Function1<Canvas, Unit> {
    final /* synthetic */ NodeCoordinator this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    NodeCoordinator$drawBlock$1(NodeCoordinator nodeCoordinator) {
        super(1);
        this.this$0 = nodeCoordinator;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Canvas canvas) {
        invoke2(canvas);
        return Unit.INSTANCE;
    }

    /* INFO: renamed from: androidx.compose.ui.node.NodeCoordinator$drawBlock$1$1, reason: invalid class name */
    /* INFO: compiled from: NodeCoordinator.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        final /* synthetic */ Canvas $canvas;
        final /* synthetic */ NodeCoordinator this$0;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(NodeCoordinator nodeCoordinator, Canvas canvas) {
            super(0);
            this.this$0 = nodeCoordinator;
            this.$canvas = canvas;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.this$0.drawContainedDrawModifiers(this.$canvas);
        }
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Canvas canvas) {
        if (this.this$0.getLayoutNode().isPlaced()) {
            this.this$0.getSnapshotObserver().observeReads$ui_release(this.this$0, NodeCoordinator.onCommitAffectingLayer, new AnonymousClass1(this.this$0, canvas));
            this.this$0.lastLayerDrawingWasSkipped = false;
        } else {
            this.this$0.lastLayerDrawingWasSkipped = true;
        }
    }
}
