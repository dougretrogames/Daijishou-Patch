package androidx.appcompat.app;

import android.window.OnBackInvokedCallback;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes.dex */
public final /* synthetic */ class AppCompatDelegateImpl$Api33Impl$$ExternalSyntheticLambda0 implements OnBackInvokedCallback {
    public final /* synthetic */ AppCompatDelegateImpl f$0;

    public /* synthetic */ AppCompatDelegateImpl$Api33Impl$$ExternalSyntheticLambda0(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.f$0 = appCompatDelegateImpl;
    }

    @Override // android.window.OnBackInvokedCallback
    public final void onBackInvoked() {
        this.f$0.onBackPressed();
    }
}
