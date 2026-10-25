package androidx.compose.ui.focus;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: FocusRestorer.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class FocusRestorerKt$saveFocusedChild$1$1 extends Lambda implements Function0<Object> {
    final /* synthetic */ FocusTargetNode $this_saveFocusedChild;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FocusRestorerKt$saveFocusedChild$1$1(FocusTargetNode focusTargetNode) {
        super(0);
        this.$this_saveFocusedChild = focusTargetNode;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return Integer.valueOf(this.$this_saveFocusedChild.getPreviouslyFocusedChildHash());
    }
}
