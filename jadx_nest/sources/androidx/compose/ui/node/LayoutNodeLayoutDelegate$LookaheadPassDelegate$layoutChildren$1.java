package androidx.compose.ui.node;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: LayoutNodeLayoutDelegate.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class LayoutNodeLayoutDelegate$LookaheadPassDelegate$layoutChildren$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ LookaheadDelegate $lookaheadDelegate;
    final /* synthetic */ LayoutNodeLayoutDelegate.LookaheadPassDelegate this$0;
    final /* synthetic */ LayoutNodeLayoutDelegate this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LayoutNodeLayoutDelegate$LookaheadPassDelegate$layoutChildren$1(LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate, LookaheadDelegate lookaheadDelegate, LayoutNodeLayoutDelegate layoutNodeLayoutDelegate) {
        super(0);
        this.this$0 = lookaheadPassDelegate;
        this.$lookaheadDelegate = lookaheadDelegate;
        this.this$1 = layoutNodeLayoutDelegate;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: androidx.compose.ui.node.LayoutNodeLayoutDelegate$LookaheadPassDelegate$layoutChildren$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: LayoutNodeLayoutDelegate.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "child", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass1 extends Lambda implements Function1<AlignmentLinesOwner, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(AlignmentLinesOwner alignmentLinesOwner) {
            invoke2(alignmentLinesOwner);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(AlignmentLinesOwner alignmentLinesOwner) {
            alignmentLinesOwner.getAlignmentLines().setUsedDuringParentLayout$ui_release(false);
        }
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.clearPlaceOrder();
        this.this$0.forEachChildAlignmentLinesOwner(AnonymousClass1.INSTANCE);
        LookaheadDelegate lookaheadDelegate = this.this$0.getInnerCoordinator().getLookaheadDelegate();
        if (lookaheadDelegate != null) {
            boolean zIsPlacingForAlignment$ui_release = lookaheadDelegate.getIsPlacingForAlignment();
            List<LayoutNode> children$ui_release = this.this$1.layoutNode.getChildren$ui_release();
            int size = children$ui_release.size();
            for (int i = 0; i < size; i++) {
                LookaheadDelegate lookaheadDelegate2 = children$ui_release.get(i).getOuterCoordinator$ui_release().getLookaheadDelegate();
                if (lookaheadDelegate2 != null) {
                    lookaheadDelegate2.setPlacingForAlignment$ui_release(zIsPlacingForAlignment$ui_release);
                }
            }
        }
        this.$lookaheadDelegate.getMeasureResult$ui_release().placeChildren();
        LookaheadDelegate lookaheadDelegate3 = this.this$0.getInnerCoordinator().getLookaheadDelegate();
        if (lookaheadDelegate3 != null) {
            lookaheadDelegate3.getIsPlacingForAlignment();
            List<LayoutNode> children$ui_release2 = this.this$1.layoutNode.getChildren$ui_release();
            int size2 = children$ui_release2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                LookaheadDelegate lookaheadDelegate4 = children$ui_release2.get(i2).getOuterCoordinator$ui_release().getLookaheadDelegate();
                if (lookaheadDelegate4 != null) {
                    lookaheadDelegate4.setPlacingForAlignment$ui_release(false);
                }
            }
        }
        this.this$0.checkChildrenPlaceOrderForUpdates();
        this.this$0.forEachChildAlignmentLinesOwner(AnonymousClass4.INSTANCE);
    }

    /* JADX INFO: renamed from: androidx.compose.ui.node.LayoutNodeLayoutDelegate$LookaheadPassDelegate$layoutChildren$1$4, reason: invalid class name */
    /* JADX INFO: compiled from: LayoutNodeLayoutDelegate.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "child", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass4 extends Lambda implements Function1<AlignmentLinesOwner, Unit> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(AlignmentLinesOwner alignmentLinesOwner) {
            invoke2(alignmentLinesOwner);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(AlignmentLinesOwner alignmentLinesOwner) {
            alignmentLinesOwner.getAlignmentLines().setPreviousUsedDuringParentLayout$ui_release(alignmentLinesOwner.getAlignmentLines().getUsedDuringParentLayout());
        }
    }
}
