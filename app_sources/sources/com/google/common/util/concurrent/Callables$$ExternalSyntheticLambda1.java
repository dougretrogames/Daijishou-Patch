package com.google.common.util.concurrent;

import java.util.concurrent.Callable;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class Callables$$ExternalSyntheticLambda1 implements AsyncCallable {
    public final /* synthetic */ ListeningExecutorService f$0;
    public final /* synthetic */ Callable f$1;

    public /* synthetic */ Callables$$ExternalSyntheticLambda1(ListeningExecutorService listeningExecutorService, Callable callable) {
        this.f$0 = listeningExecutorService;
        this.f$1 = callable;
    }

    @Override // com.google.common.util.concurrent.AsyncCallable
    public final ListenableFuture call() {
        return this.f$0.submit(this.f$1);
    }
}
