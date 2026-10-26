package org.apache.commons.collections4.bloomfilter;

import java.util.function.IntPredicate;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class BitMapExtractor$$ExternalSyntheticLambda1 implements IntPredicate {
    public final /* synthetic */ long[] f$0;

    public /* synthetic */ BitMapExtractor$$ExternalSyntheticLambda1(long[] jArr) {
        this.f$0 = jArr;
    }

    @Override // java.util.function.IntPredicate
    public final boolean test(int i) {
        return BitMapExtractor.lambda$fromIndexExtractor$0(this.f$0, i);
    }
}
