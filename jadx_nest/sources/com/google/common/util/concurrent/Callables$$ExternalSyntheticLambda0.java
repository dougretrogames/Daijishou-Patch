package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class Callables$$ExternalSyntheticLambda0 implements Callable {
    public final /* synthetic */ Supplier f$0;
    public final /* synthetic */ Callable f$1;

    public /* synthetic */ Callables$$ExternalSyntheticLambda0(Supplier supplier, Callable callable) {
        this.f$0 = supplier;
        this.f$1 = callable;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return Callables.lambda$threadRenaming$2(this.f$0, this.f$1);
    }
}
