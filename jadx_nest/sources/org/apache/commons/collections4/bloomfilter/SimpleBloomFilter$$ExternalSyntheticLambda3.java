package org.apache.commons.collections4.bloomfilter;

import java.util.function.IntPredicate;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class SimpleBloomFilter$$ExternalSyntheticLambda3 implements IntPredicate {
    public final /* synthetic */ SimpleBloomFilter f$0;

    public /* synthetic */ SimpleBloomFilter$$ExternalSyntheticLambda3(SimpleBloomFilter simpleBloomFilter) {
        this.f$0 = simpleBloomFilter;
    }

    @Override // java.util.function.IntPredicate
    public final boolean test(int i) {
        return this.f$0.m5537xf637940a(i);
    }
}
