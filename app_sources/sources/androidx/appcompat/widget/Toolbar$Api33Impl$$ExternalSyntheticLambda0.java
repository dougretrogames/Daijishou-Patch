package androidx.appcompat.widget;

import android.window.OnBackInvokedCallback;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes.dex */
public final /* synthetic */ class Toolbar$Api33Impl$$ExternalSyntheticLambda0 implements OnBackInvokedCallback {
    public final /* synthetic */ Runnable f$0;

    public /* synthetic */ Toolbar$Api33Impl$$ExternalSyntheticLambda0(Runnable runnable) {
        this.f$0 = runnable;
    }

    @Override // android.window.OnBackInvokedCallback
    public final void onBackInvoked() {
        this.f$0.run();
    }
}
