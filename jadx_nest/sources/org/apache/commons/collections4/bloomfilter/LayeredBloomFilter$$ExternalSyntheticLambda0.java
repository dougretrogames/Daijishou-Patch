package org.apache.commons.collections4.bloomfilter;

import java.util.function.Predicate;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class LayeredBloomFilter$$ExternalSyntheticLambda0 implements Predicate {
    public final /* synthetic */ LayeredBloomFilter f$0;
    public final /* synthetic */ boolean[] f$1;

    public /* synthetic */ LayeredBloomFilter$$ExternalSyntheticLambda0(LayeredBloomFilter layeredBloomFilter, boolean[] zArr) {
        this.f$0 = layeredBloomFilter;
        this.f$1 = zArr;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return this.f$0.m5534x5565950b(this.f$1, (BloomFilter) obj);
    }
}
