package com.google.common.collect;

import java.util.Comparator;
import java.util.function.Supplier;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class CollectCollectors$$ExternalSyntheticLambda49 implements Supplier {
    public final /* synthetic */ Comparator f$0;

    public /* synthetic */ CollectCollectors$$ExternalSyntheticLambda49(Comparator comparator) {
        this.f$0 = comparator;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return CollectCollectors.lambda$toImmutableSortedSet$0(this.f$0);
    }
}
