package com.google.common.collect;

import java.util.function.BinaryOperator;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class CollectCollectors$$ExternalSyntheticLambda60 implements BinaryOperator {
    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        return ((ImmutableSetMultimap.Builder) obj).combine((ImmutableMultimap.Builder) obj2);
    }
}
