package androidx.compose.ui.text.input;

import android.view.inputmethod.BaseInputConnection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* INFO: compiled from: TextInputServiceAndroid.android.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/view/inputmethod/BaseInputConnection;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class TextInputServiceAndroid$baseInputConnection$2 extends Lambda implements Function0<BaseInputConnection> {
    final /* synthetic */ TextInputServiceAndroid this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextInputServiceAndroid$baseInputConnection$2(TextInputServiceAndroid textInputServiceAndroid) {
        super(0);
        this.this$0 = textInputServiceAndroid;
    }

    /* WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final BaseInputConnection invoke() {
        return new BaseInputConnection(this.this$0.getView(), false);
    }
}
