package org.apache.commons.collections4.bloomfilter;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class ArrayCountingBloomFilter$$ExternalSyntheticLambda0 implements CellExtractor.CellPredicate {
    public final /* synthetic */ ArrayCountingBloomFilter f$0;
    public final /* synthetic */ int[] f$1;

    public /* synthetic */ ArrayCountingBloomFilter$$ExternalSyntheticLambda0(ArrayCountingBloomFilter arrayCountingBloomFilter, int[] iArr) {
        this.f$0 = arrayCountingBloomFilter;
        this.f$1 = iArr;
    }

    @Override // org.apache.commons.collections4.bloomfilter.CellExtractor.CellPredicate
    public final boolean test(int i, int i2) {
        return this.f$0.m5532x8ea261a5(this.f$1, i, i2);
    }
}
