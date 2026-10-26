package org.apache.commons.collections4.bloomfilter;

import java.util.function.Predicate;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class LayeredBloomFilter$$ExternalSyntheticLambda1 implements Predicate {
    public final /* synthetic */ SimpleBloomFilter f$0;

    public /* synthetic */ LayeredBloomFilter$$ExternalSyntheticLambda1(SimpleBloomFilter simpleBloomFilter) {
        this.f$0 = simpleBloomFilter;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return this.f$0.merge((BloomFilter<?>) obj);
    }
}
