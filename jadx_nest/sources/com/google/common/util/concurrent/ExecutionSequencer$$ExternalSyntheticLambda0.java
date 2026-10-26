package com.google.common.util.concurrent;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class ExecutionSequencer$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ TrustedListenableFutureTask f$0;
    public final /* synthetic */ SettableFuture f$1;
    public final /* synthetic */ ListenableFuture f$2;
    public final /* synthetic */ ListenableFuture f$3;
    public final /* synthetic */ ExecutionSequencer.TaskNonReentrantExecutor f$4;

    public /* synthetic */ ExecutionSequencer$$ExternalSyntheticLambda0(TrustedListenableFutureTask trustedListenableFutureTask, SettableFuture settableFuture, ListenableFuture listenableFuture, ListenableFuture listenableFuture2, ExecutionSequencer.TaskNonReentrantExecutor taskNonReentrantExecutor) {
        this.f$0 = trustedListenableFutureTask;
        this.f$1 = settableFuture;
        this.f$2 = listenableFuture;
        this.f$3 = listenableFuture2;
        this.f$4 = taskNonReentrantExecutor;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ExecutionSequencer.lambda$submitAsync$0(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
    }
}
