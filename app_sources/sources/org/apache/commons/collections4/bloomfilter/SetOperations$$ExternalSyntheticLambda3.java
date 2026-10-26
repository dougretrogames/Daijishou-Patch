package org.apache.commons.collections4.bloomfilter;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class SetOperations$$ExternalSyntheticLambda3 implements LongBiPredicate {
    public final /* synthetic */ int[] f$0;

    public /* synthetic */ SetOperations$$ExternalSyntheticLambda3(int[] iArr) {
        this.f$0 = iArr;
    }

    @Override // org.apache.commons.collections4.bloomfilter.LongBiPredicate
    public final boolean test(long j, long j2) {
        return SetOperations.lambda$jaccardSimilarity$3(this.f$0, j, j2);
    }
}
