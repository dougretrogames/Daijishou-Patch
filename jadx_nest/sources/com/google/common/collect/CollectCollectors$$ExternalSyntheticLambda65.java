package com.google.common.collect;

import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.ToIntFunction;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class CollectCollectors$$ExternalSyntheticLambda65 implements BiConsumer {
    public final /* synthetic */ Function f$0;
    public final /* synthetic */ ToIntFunction f$1;

    public /* synthetic */ CollectCollectors$$ExternalSyntheticLambda65(Function function, ToIntFunction toIntFunction) {
        this.f$0 = function;
        this.f$1 = toIntFunction;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        ((Multiset) obj).add(this.f$0.apply(obj2), this.f$1.applyAsInt(obj2));
    }
}
