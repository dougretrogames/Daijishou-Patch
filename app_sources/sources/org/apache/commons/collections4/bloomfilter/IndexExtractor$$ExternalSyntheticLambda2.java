package org.apache.commons.collections4.bloomfilter;

import java.util.function.IntPredicate;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class IndexExtractor$$ExternalSyntheticLambda2 implements IntPredicate {
    public final /* synthetic */ IndexExtractor.C1Indices f$0;

    public /* synthetic */ IndexExtractor$$ExternalSyntheticLambda2(IndexExtractor.C1Indices c1Indices) {
        this.f$0 = c1Indices;
    }

    @Override // java.util.function.IntPredicate
    public final boolean test(int i) {
        return this.f$0.add(i);
    }
}
