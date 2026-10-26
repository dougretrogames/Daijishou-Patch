package org.apache.commons.collections4.bloomfilter;

import java.util.List;
import java.util.function.Predicate;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class BloomFilterExtractor$$ExternalSyntheticLambda1 implements Predicate {
    public final /* synthetic */ List f$0;

    public /* synthetic */ BloomFilterExtractor$$ExternalSyntheticLambda1(List list) {
        this.f$0 = list;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return this.f$0.add(((BloomFilter) obj).copy());
    }
}
