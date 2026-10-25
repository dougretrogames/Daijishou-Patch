package org.apache.commons.collections4.bloomfilter;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class ArrayCountingBloomFilter$$ExternalSyntheticLambda5 implements CellExtractor.CellPredicate {
    public final /* synthetic */ ArrayCountingBloomFilter f$0;

    public /* synthetic */ ArrayCountingBloomFilter$$ExternalSyntheticLambda5(ArrayCountingBloomFilter arrayCountingBloomFilter) {
        this.f$0 = arrayCountingBloomFilter;
    }

    @Override // org.apache.commons.collections4.bloomfilter.CellExtractor.CellPredicate
    public final boolean test(int i, int i2) {
        return this.f$0.subtract(i, i2);
    }
}
