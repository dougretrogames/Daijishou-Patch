package org.apache.commons.collections4.bloomfilter;

import java.util.function.IntPredicate;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class CellExtractor$$ExternalSyntheticLambda0 implements CellExtractor.CellPredicate {
    public final /* synthetic */ IntPredicate f$0;

    public /* synthetic */ CellExtractor$$ExternalSyntheticLambda0(IntPredicate intPredicate) {
        this.f$0 = intPredicate;
    }

    @Override // org.apache.commons.collections4.bloomfilter.CellExtractor.CellPredicate
    public final boolean test(int i, int i2) {
        return this.f$0.test(i);
    }
}
