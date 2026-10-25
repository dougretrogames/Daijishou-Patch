package com.google.common.collect;

import java.util.function.BinaryOperator;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class CollectCollectors$$ExternalSyntheticLambda51 implements BinaryOperator {
    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        return ((ImmutableSortedSet.Builder) obj).combine((ImmutableSet.Builder) obj2);
    }
}
