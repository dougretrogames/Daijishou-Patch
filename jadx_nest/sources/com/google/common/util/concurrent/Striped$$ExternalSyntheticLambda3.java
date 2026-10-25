package com.google.common.util.concurrent;

import com.google.common.base.Supplier;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class Striped$$ExternalSyntheticLambda3 implements Supplier {
    public final /* synthetic */ int f$0;

    public /* synthetic */ Striped$$ExternalSyntheticLambda3(int i) {
        this.f$0 = i;
    }

    @Override // com.google.common.base.Supplier
    public final Object get() {
        return Striped.lambda$lazyWeakSemaphore$2(this.f$0);
    }
}
