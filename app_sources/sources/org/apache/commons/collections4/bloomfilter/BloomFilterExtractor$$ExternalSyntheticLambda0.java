package org.apache.commons.collections4.bloomfilter;

import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Predicate;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class BloomFilterExtractor$$ExternalSyntheticLambda0 implements Predicate {
    public final /* synthetic */ AtomicReference f$0;

    public /* synthetic */ BloomFilterExtractor$$ExternalSyntheticLambda0(AtomicReference atomicReference) {
        this.f$0 = atomicReference;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return BloomFilterExtractor.lambda$flatten$1(this.f$0, (BloomFilter) obj);
    }
}
