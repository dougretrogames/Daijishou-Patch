package org.apache.commons.collections4.bloomfilter;

import java.util.function.Predicate;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class LayeredBloomFilter$$ExternalSyntheticLambda4 implements Predicate {
    public final /* synthetic */ BloomFilter f$0;

    public /* synthetic */ LayeredBloomFilter$$ExternalSyntheticLambda4(BloomFilter bloomFilter) {
        this.f$0 = bloomFilter;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return LayeredBloomFilter.lambda$contains$0(this.f$0, (BloomFilter) obj);
    }
}
