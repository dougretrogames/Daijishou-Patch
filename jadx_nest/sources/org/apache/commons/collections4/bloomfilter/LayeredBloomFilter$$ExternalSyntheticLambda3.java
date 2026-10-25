package org.apache.commons.collections4.bloomfilter;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class LayeredBloomFilter$$ExternalSyntheticLambda3 implements Predicate {
    public final /* synthetic */ IntPredicate f$0;

    public /* synthetic */ LayeredBloomFilter$$ExternalSyntheticLambda3(IntPredicate intPredicate) {
        this.f$0 = intPredicate;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return ((BloomFilter) obj).processIndices(this.f$0);
    }
}
