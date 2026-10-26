package com.google.common.collect;

import java.util.function.Function;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class CollectCollectors$$ExternalSyntheticLambda31 implements Function {
    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return ImmutableMultiset.copyFromEntries(((Multiset) obj).entrySet());
    }
}
