package com.google.common.collect;

import java.util.function.BinaryOperator;
import java.util.function.Supplier;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class CollectCollectors$$ExternalSyntheticLambda68 implements Supplier {
    public final /* synthetic */ BinaryOperator f$0;

    public /* synthetic */ CollectCollectors$$ExternalSyntheticLambda68(BinaryOperator binaryOperator) {
        this.f$0 = binaryOperator;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return CollectCollectors.lambda$toImmutableEnumMap$15(this.f$0);
    }
}
