package org.apache.commons.collections4.bloomfilter;

import java.util.function.Predicate;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class LayeredBloomFilter$$ExternalSyntheticLambda2 implements Predicate {
    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return ((BloomFilter) obj).isEmpty();
    }
}
