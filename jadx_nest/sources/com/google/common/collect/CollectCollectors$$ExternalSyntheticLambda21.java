package com.google.common.collect;

import java.util.function.BiConsumer;
import java.util.function.Function;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class CollectCollectors$$ExternalSyntheticLambda21 implements BiConsumer {
    public final /* synthetic */ Function f$0;
    public final /* synthetic */ Function f$1;

    public /* synthetic */ CollectCollectors$$ExternalSyntheticLambda21(Function function, Function function2) {
        this.f$0 = function;
        this.f$1 = function2;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        CollectCollectors.lambda$flatteningToMultimap$26(this.f$0, this.f$1, (Multimap) obj, obj2);
    }
}
