package com.google.common.util.concurrent;

import com.google.common.base.Supplier;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class Callables$$ExternalSyntheticLambda3 implements Runnable {
    public final /* synthetic */ Supplier f$0;
    public final /* synthetic */ Runnable f$1;

    public /* synthetic */ Callables$$ExternalSyntheticLambda3(Supplier supplier, Runnable runnable) {
        this.f$0 = supplier;
        this.f$1 = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Callables.lambda$threadRenaming$3(this.f$0, this.f$1);
    }
}
