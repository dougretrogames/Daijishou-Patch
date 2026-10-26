package androidx.compose.ui.graphics.vector;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: Vector.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "node", "Landroidx/compose/ui/graphics/vector/VNode;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class GroupComponent$wrappedListener$1 extends Lambda implements Function1<VNode, Unit> {
    final /* synthetic */ GroupComponent this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    GroupComponent$wrappedListener$1(GroupComponent groupComponent) {
        super(1);
        this.this$0 = groupComponent;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(VNode vNode) {
        invoke2(vNode);
        return Unit.INSTANCE;
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(VNode vNode) {
        this.this$0.markTintForVNode(vNode);
        Function1<VNode, Unit> invalidateListener$ui_release = this.this$0.getInvalidateListener$ui_release();
        if (invalidateListener$ui_release != null) {
            invalidateListener$ui_release.invoke(vNode);
        }
    }
}
