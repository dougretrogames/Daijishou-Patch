package com.google.common.collect;

import java.util.function.BinaryOperator;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class TableCollectors$$ExternalSyntheticLambda6 implements BinaryOperator {
    public final /* synthetic */ BinaryOperator f$0;

    public /* synthetic */ TableCollectors$$ExternalSyntheticLambda6(BinaryOperator binaryOperator) {
        this.f$0 = binaryOperator;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        return ((TableCollectors.ImmutableTableCollectorState) obj).combine((TableCollectors.ImmutableTableCollectorState) obj2, this.f$0);
    }
}
