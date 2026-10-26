package com.google.common.collect;

import java.util.function.Function;
import java.util.stream.Stream;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class CollectCollectors$$ExternalSyntheticLambda34 implements Function {
    public final /* synthetic */ Function f$0;

    public /* synthetic */ CollectCollectors$$ExternalSyntheticLambda34(Function function) {
        this.f$0 = function;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return ((Stream) this.f$0.apply(obj)).peek(new CollectCollectors$$ExternalSyntheticLambda39());
    }
}
