package com.google.common.collect;

import java.util.Comparator;
import java.util.function.Supplier;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class Comparators$$ExternalSyntheticLambda0 implements Supplier {
    public final /* synthetic */ int f$0;
    public final /* synthetic */ Comparator f$1;

    public /* synthetic */ Comparators$$ExternalSyntheticLambda0(int i, Comparator comparator) {
        this.f$0 = i;
        this.f$1 = comparator;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return TopKSelector.least(this.f$0, this.f$1);
    }
}
