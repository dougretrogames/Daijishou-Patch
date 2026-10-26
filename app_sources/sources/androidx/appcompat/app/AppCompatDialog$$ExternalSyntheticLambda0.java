package androidx.appcompat.app;

import android.view.KeyEvent;
import androidx.core.view.KeyEventDispatcher;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes.dex */
public final /* synthetic */ class AppCompatDialog$$ExternalSyntheticLambda0 implements KeyEventDispatcher.Component {
    public final /* synthetic */ AppCompatDialog f$0;

    public /* synthetic */ AppCompatDialog$$ExternalSyntheticLambda0(AppCompatDialog appCompatDialog) {
        this.f$0 = appCompatDialog;
    }

    @Override // androidx.core.view.KeyEventDispatcher.Component
    public final boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return this.f$0.superDispatchKeyEvent(keyEvent);
    }
}
