package com.google.common.util.concurrent;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class AggregateFuture$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ AggregateFuture f$0;
    public final /* synthetic */ ListenableFuture f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ AggregateFuture$$ExternalSyntheticLambda0(AggregateFuture aggregateFuture, ListenableFuture listenableFuture, int i) {
        this.f$0 = aggregateFuture;
        this.f$1 = listenableFuture;
        this.f$2 = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.m3373lambda$init$0$comgooglecommonutilconcurrentAggregateFuture(this.f$1, this.f$2);
    }
}
