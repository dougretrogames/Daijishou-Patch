package androidx.compose.ui.text.input;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: InputMethodManager.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/view/inputmethod/InputMethodManager;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class InputMethodManagerImpl$imm$2 extends Lambda implements Function0<android.view.inputmethod.InputMethodManager> {
    final /* synthetic */ InputMethodManagerImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InputMethodManagerImpl$imm$2(InputMethodManagerImpl inputMethodManagerImpl) {
        super(0);
        this.this$0 = inputMethodManagerImpl;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final android.view.inputmethod.InputMethodManager invoke() {
        Object systemService = this.this$0.view.getContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        return (android.view.inputmethod.InputMethodManager) systemService;
    }
}
