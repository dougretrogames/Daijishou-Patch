package org.apache.commons.collections4.bloomfilter;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class CountingBloomFilter$$ExternalSyntheticLambda0 implements CellExtractor.CellPredicate {
    public final /* synthetic */ long[] f$0;
    public final /* synthetic */ int[] f$1;

    public /* synthetic */ CountingBloomFilter$$ExternalSyntheticLambda0(long[] jArr, int[] iArr) {
        this.f$0 = jArr;
        this.f$1 = iArr;
    }

    @Override // org.apache.commons.collections4.bloomfilter.CellExtractor.CellPredicate
    public final boolean test(int i, int i2) {
        return CountingBloomFilter.lambda$getMaxInsert$0(this.f$0, this.f$1, i, i2);
    }
}
