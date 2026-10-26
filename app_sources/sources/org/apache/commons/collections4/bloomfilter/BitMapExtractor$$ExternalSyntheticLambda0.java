package org.apache.commons.collections4.bloomfilter;

import java.util.function.LongPredicate;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class BitMapExtractor$$ExternalSyntheticLambda0 implements LongPredicate {
    public final /* synthetic */ BitMapExtractor.C1Bits f$0;

    public /* synthetic */ BitMapExtractor$$ExternalSyntheticLambda0(BitMapExtractor.C1Bits c1Bits) {
        this.f$0 = c1Bits;
    }

    @Override // java.util.function.LongPredicate
    public final boolean test(long j) {
        return this.f$0.add(j);
    }
}
