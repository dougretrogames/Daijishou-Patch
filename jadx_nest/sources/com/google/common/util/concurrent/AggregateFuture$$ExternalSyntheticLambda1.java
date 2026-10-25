package com.google.common.util.concurrent;

import com.google.common.collect.ImmutableCollection;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class AggregateFuture$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ AggregateFuture f$0;
    public final /* synthetic */ ImmutableCollection f$1;

    public /* synthetic */ AggregateFuture$$ExternalSyntheticLambda1(AggregateFuture aggregateFuture, ImmutableCollection immutableCollection) {
        this.f$0 = aggregateFuture;
        this.f$1 = immutableCollection;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.m3374lambda$init$1$comgooglecommonutilconcurrentAggregateFuture(this.f$1);
    }
}
