package com.google.common.util.concurrent;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class Callables$$ExternalSyntheticLambda2 implements Callable {
    public final /* synthetic */ Object f$0;

    public /* synthetic */ Callables$$ExternalSyntheticLambda2(Object obj) {
        this.f$0 = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return Callables.lambda$returning$0(this.f$0);
    }
}
