package androidx.compose.ui.text.input;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: TextInputServiceAndroid.android.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/text/input/ImeAction;", "invoke-KlQnJC8", "(I)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class TextInputServiceAndroid$onImeActionPerformed$1 extends Lambda implements Function1<ImeAction, Unit> {
    public static final TextInputServiceAndroid$onImeActionPerformed$1 INSTANCE = new TextInputServiceAndroid$onImeActionPerformed$1();

    TextInputServiceAndroid$onImeActionPerformed$1() {
        super(1);
    }

    /* INFO: renamed from: invoke-KlQnJC8, reason: not valid java name */
    public final void m2623invokeKlQnJC8(int i) {
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ImeAction imeAction) {
        m2623invokeKlQnJC8(imeAction.getValue());
        return Unit.INSTANCE;
    }
}
