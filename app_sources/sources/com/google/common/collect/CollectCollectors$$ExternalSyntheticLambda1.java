package com.google.common.collect;

import java.util.function.BiConsumer;
import java.util.function.Function;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class CollectCollectors$$ExternalSyntheticLambda1 implements BiConsumer {
    public final /* synthetic */ Function f$0;
    public final /* synthetic */ Function f$1;

    public /* synthetic */ CollectCollectors$$ExternalSyntheticLambda1(Function function, Function function2) {
        this.f$0 = function;
        this.f$1 = function2;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        ((ImmutableBiMap.Builder) obj).put(this.f$0.apply(obj2), this.f$1.apply(obj2));
    }
}
