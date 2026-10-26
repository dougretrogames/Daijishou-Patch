package androidx.core.view;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes.dex */
public final /* synthetic */ class SoftwareKeyboardControllerCompat$Impl20$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ View f$0;

    public /* synthetic */ SoftwareKeyboardControllerCompat$Impl20$$ExternalSyntheticLambda0(View view) {
        this.f$0 = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View view = this.f$0;
        ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
    }
}
