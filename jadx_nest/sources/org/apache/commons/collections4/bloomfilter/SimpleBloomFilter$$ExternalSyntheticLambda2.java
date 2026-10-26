package org.apache.commons.collections4.bloomfilter;

import java.util.function.LongPredicate;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class SimpleBloomFilter$$ExternalSyntheticLambda2 implements LongPredicate {
    public final /* synthetic */ SimpleBloomFilter f$0;
    public final /* synthetic */ int[] f$1;

    public /* synthetic */ SimpleBloomFilter$$ExternalSyntheticLambda2(SimpleBloomFilter simpleBloomFilter, int[] iArr) {
        this.f$0 = simpleBloomFilter;
        this.f$1 = iArr;
    }

    @Override // java.util.function.LongPredicate
    public final boolean test(long j) {
        return this.f$0.m5536x2a80fc9(this.f$1, j);
    }
}
