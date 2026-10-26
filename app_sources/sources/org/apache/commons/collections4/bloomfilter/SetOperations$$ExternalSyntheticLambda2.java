package org.apache.commons.collections4.bloomfilter;

import java.util.function.LongPredicate;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class SetOperations$$ExternalSyntheticLambda2 implements LongPredicate {
    public final /* synthetic */ int[] f$0;

    public /* synthetic */ SetOperations$$ExternalSyntheticLambda2(int[] iArr) {
        this.f$0 = iArr;
    }

    @Override // java.util.function.LongPredicate
    public final boolean test(long j) {
        return SetOperations.lambda$cardinality$1(this.f$0, j);
    }
}
