package org.apache.commons.collections4.bloomfilter;

import java.util.BitSet;
import java.util.function.IntPredicate;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class IndexExtractor$$ExternalSyntheticLambda1 implements IntPredicate {
    public final /* synthetic */ BitSet f$0;

    public /* synthetic */ IndexExtractor$$ExternalSyntheticLambda1(BitSet bitSet) {
        this.f$0 = bitSet;
    }

    @Override // java.util.function.IntPredicate
    public final boolean test(int i) {
        return IndexExtractor.lambda$uniqueIndices$1(this.f$0, i);
    }
}
