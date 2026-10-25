package androidx.compose.ui.focus;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: FocusRestorer.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "Landroidx/compose/ui/focus/FocusRequester;", "it", "Landroidx/compose/ui/focus/FocusDirection;", "invoke-3ESFkO8", "(I)Landroidx/compose/ui/focus/FocusRequester;"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class FocusRestorerNode$onEnter$1 extends Lambda implements Function1<FocusDirection, FocusRequester> {
    final /* synthetic */ FocusRestorerNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FocusRestorerNode$onEnter$1(FocusRestorerNode focusRestorerNode) {
        super(1);
        this.this$0 = focusRestorerNode;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ FocusRequester invoke(FocusDirection focusDirection) {
        return m233invoke3ESFkO8(focusDirection.getValue());
    }

    /* JADX INFO: renamed from: invoke-3ESFkO8, reason: not valid java name */
    public final FocusRequester m233invoke3ESFkO8(int i) {
        FocusRequester focusRequesterInvoke;
        if (FocusRequesterModifierNodeKt.restoreFocusedChild(this.this$0)) {
            return FocusRequester.INSTANCE.getCancel();
        }
        Function0<FocusRequester> onRestoreFailed = this.this$0.getOnRestoreFailed();
        return (onRestoreFailed == null || (focusRequesterInvoke = onRestoreFailed.invoke()) == null) ? FocusRequester.INSTANCE.getDefault() : focusRequesterInvoke;
    }
}
