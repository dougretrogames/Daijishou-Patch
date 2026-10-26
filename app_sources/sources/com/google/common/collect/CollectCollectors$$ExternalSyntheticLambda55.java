package com.google.common.collect;

import java.util.Comparator;
import java.util.function.Supplier;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class CollectCollectors$$ExternalSyntheticLambda55 implements Supplier {
    public final /* synthetic */ Comparator f$0;

    public /* synthetic */ CollectCollectors$$ExternalSyntheticLambda55(Comparator comparator) {
        this.f$0 = comparator;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return CollectCollectors.lambda$toImmutableSortedMap$8(this.f$0);
    }
}
