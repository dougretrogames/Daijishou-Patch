package org.apache.commons.collections4.bloomfilter;

import java.util.function.LongBinaryOperator;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class SetOperations$$ExternalSyntheticLambda1 implements LongBiPredicate {
    public final /* synthetic */ int[] f$0;
    public final /* synthetic */ LongBinaryOperator f$1;

    public /* synthetic */ SetOperations$$ExternalSyntheticLambda1(int[] iArr, LongBinaryOperator longBinaryOperator) {
        this.f$0 = iArr;
        this.f$1 = longBinaryOperator;
    }

    @Override // org.apache.commons.collections4.bloomfilter.LongBiPredicate
    public final boolean test(long j, long j2) {
        return SetOperations.lambda$cardinality$2(this.f$0, this.f$1, j, j2);
    }
}
