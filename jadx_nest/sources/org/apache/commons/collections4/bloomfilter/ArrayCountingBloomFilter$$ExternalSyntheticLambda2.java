package org.apache.commons.collections4.bloomfilter;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class ArrayCountingBloomFilter$$ExternalSyntheticLambda2 implements CellExtractor.CellPredicate {
    public final /* synthetic */ ArrayCountingBloomFilter f$0;

    public /* synthetic */ ArrayCountingBloomFilter$$ExternalSyntheticLambda2(ArrayCountingBloomFilter arrayCountingBloomFilter) {
        this.f$0 = arrayCountingBloomFilter;
    }

    @Override // org.apache.commons.collections4.bloomfilter.CellExtractor.CellPredicate
    public final boolean test(int i, int i2) {
        return this.f$0.add(i, i2);
    }
}
