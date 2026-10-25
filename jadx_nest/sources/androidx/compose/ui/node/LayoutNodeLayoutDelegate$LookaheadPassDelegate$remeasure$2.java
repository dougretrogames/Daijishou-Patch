package androidx.compose.ui.node;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: LayoutNodeLayoutDelegate.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class LayoutNodeLayoutDelegate$LookaheadPassDelegate$remeasure$2 extends Lambda implements Function1<AlignmentLinesOwner, Unit> {
    public static final LayoutNodeLayoutDelegate$LookaheadPassDelegate$remeasure$2 INSTANCE = new LayoutNodeLayoutDelegate$LookaheadPassDelegate$remeasure$2();

    LayoutNodeLayoutDelegate$LookaheadPassDelegate$remeasure$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AlignmentLinesOwner alignmentLinesOwner) {
        invoke2(alignmentLinesOwner);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(AlignmentLinesOwner alignmentLinesOwner) {
        alignmentLinesOwner.getAlignmentLines().setUsedDuringParentMeasurement$ui_release(false);
    }
}
