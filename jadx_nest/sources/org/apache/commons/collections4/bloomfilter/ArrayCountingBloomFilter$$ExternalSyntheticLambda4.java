package org.apache.commons.collections4.bloomfilter;

import java.util.function.IntPredicate;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class ArrayCountingBloomFilter$$ExternalSyntheticLambda4 implements IntPredicate {
    public final /* synthetic */ ArrayCountingBloomFilter f$0;

    public /* synthetic */ ArrayCountingBloomFilter$$ExternalSyntheticLambda4(ArrayCountingBloomFilter arrayCountingBloomFilter) {
        this.f$0 = arrayCountingBloomFilter;
    }

    @Override // java.util.function.IntPredicate
    public final boolean test(int i) {
        return this.f$0.m5530x217effda(i);
    }
}
