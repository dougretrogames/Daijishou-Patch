package com.google.common.collect;

import java.util.function.BinaryOperator;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class Comparators$$ExternalSyntheticLambda2 implements BinaryOperator {
    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        return ((TopKSelector) obj).combine((TopKSelector) obj2);
    }
}
