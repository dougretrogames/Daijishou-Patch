package org.apache.commons.collections4.bloomfilter;

import java.util.TreeSet;
import java.util.function.IntPredicate;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class SparseBloomFilter$$ExternalSyntheticLambda2 implements IntPredicate {
    public final /* synthetic */ TreeSet f$0;

    public /* synthetic */ SparseBloomFilter$$ExternalSyntheticLambda2(TreeSet treeSet) {
        this.f$0 = treeSet;
    }

    @Override // java.util.function.IntPredicate
    public final boolean test(int i) {
        return this.f$0.contains(Integer.valueOf(i));
    }
}
