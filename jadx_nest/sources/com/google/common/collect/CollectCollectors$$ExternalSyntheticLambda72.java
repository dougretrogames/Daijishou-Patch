package com.google.common.collect;

import java.util.function.BinaryOperator;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class CollectCollectors$$ExternalSyntheticLambda72 implements BinaryOperator {
    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        return ((ImmutableSortedMap.Builder) obj).combine((ImmutableSortedMap.Builder) obj2);
    }
}
