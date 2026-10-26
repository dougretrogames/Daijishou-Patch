package com.google.common.collect;

import java.util.Comparator;
import java.util.function.Function;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class ImmutableSortedMultiset$$ExternalSyntheticLambda3 implements Function {
    public final /* synthetic */ Comparator f$0;

    public /* synthetic */ ImmutableSortedMultiset$$ExternalSyntheticLambda3(Comparator comparator) {
        this.f$0 = comparator;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return ImmutableSortedMultiset.copyOfSortedEntries(this.f$0, ((Multiset) obj).entrySet());
    }
}
