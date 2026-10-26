package org.apache.commons.collections4.bloomfilter;

import java.util.function.IntPredicate;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class SparseBloomFilter$$ExternalSyntheticLambda1 implements IntPredicate {
    public final /* synthetic */ SparseBloomFilter f$0;

    public /* synthetic */ SparseBloomFilter$$ExternalSyntheticLambda1(SparseBloomFilter sparseBloomFilter) {
        this.f$0 = sparseBloomFilter;
    }

    @Override // java.util.function.IntPredicate
    public final boolean test(int i) {
        return this.f$0.add(i);
    }
}
