package org.apache.commons.collections4.bloomfilter;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class SparseBloomFilter$$ExternalSyntheticLambda0 implements Predicate {
    public final /* synthetic */ IntPredicate f$0;

    public /* synthetic */ SparseBloomFilter$$ExternalSyntheticLambda0(IntPredicate intPredicate) {
        this.f$0 = intPredicate;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return this.f$0.test(((Integer) obj).intValue());
    }
}
