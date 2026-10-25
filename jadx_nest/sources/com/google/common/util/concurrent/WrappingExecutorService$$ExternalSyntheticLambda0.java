package com.google.common.util.concurrent;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class WrappingExecutorService$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ Callable f$0;

    public /* synthetic */ WrappingExecutorService$$ExternalSyntheticLambda0(Callable callable) {
        this.f$0 = callable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WrappingExecutorService.lambda$wrapTask$0(this.f$0);
    }
}
