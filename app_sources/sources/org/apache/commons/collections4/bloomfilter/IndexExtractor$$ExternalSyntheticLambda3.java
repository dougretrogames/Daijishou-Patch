package org.apache.commons.collections4.bloomfilter;

import java.util.function.IntPredicate;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class IndexExtractor$$ExternalSyntheticLambda3 implements IndexExtractor {
    public final /* synthetic */ BitMapExtractor f$0;

    public /* synthetic */ IndexExtractor$$ExternalSyntheticLambda3(BitMapExtractor bitMapExtractor) {
        this.f$0 = bitMapExtractor;
    }

    @Override // org.apache.commons.collections4.bloomfilter.IndexExtractor, org.apache.commons.collections4.bloomfilter.CellExtractor
    public final boolean processIndices(IntPredicate intPredicate) {
        return IndexExtractor.lambda$fromBitMapExtractor$0(this.f$0, intPredicate);
    }
}
