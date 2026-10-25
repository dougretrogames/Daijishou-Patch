package com.google.auth.oauth2;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class PluggableAuthHandler$$ExternalSyntheticLambda0 implements Callable {
    public final /* synthetic */ Process f$0;

    public /* synthetic */ PluggableAuthHandler$$ExternalSyntheticLambda0(Process process) {
        this.f$0 = process;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return PluggableAuthHandler.lambda$getExecutableResponse$0(this.f$0);
    }
}
