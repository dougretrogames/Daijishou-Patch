package com.google.android.material.motion;

import android.window.OnBackInvokedCallback;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class MaterialBackOrchestrator$Api33BackCallbackDelegate$$ExternalSyntheticLambda0 implements OnBackInvokedCallback {
    public final /* synthetic */ MaterialBackHandler f$0;

    public /* synthetic */ MaterialBackOrchestrator$Api33BackCallbackDelegate$$ExternalSyntheticLambda0(MaterialBackHandler materialBackHandler) {
        this.f$0 = materialBackHandler;
    }

    @Override // android.window.OnBackInvokedCallback
    public final void onBackInvoked() {
        this.f$0.handleBackInvoked();
    }
}
