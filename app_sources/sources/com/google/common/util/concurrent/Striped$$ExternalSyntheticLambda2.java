package com.google.common.util.concurrent;

import com.google.common.base.Supplier;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes4.dex */
public final /* synthetic */ class Striped$$ExternalSyntheticLambda2 implements Supplier {
    public final /* synthetic */ int f$0;

    public /* synthetic */ Striped$$ExternalSyntheticLambda2(int i) {
        this.f$0 = i;
    }

    @Override // com.google.common.base.Supplier
    public final Object get() {
        return Striped.lambda$semaphore$1(this.f$0);
    }
}
