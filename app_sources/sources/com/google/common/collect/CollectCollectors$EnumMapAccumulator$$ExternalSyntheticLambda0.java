package com.google.common.collect;

import java.util.function.BiConsumer;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class CollectCollectors$EnumMapAccumulator$$ExternalSyntheticLambda0 implements BiConsumer {
    public final /* synthetic */ CollectCollectors.EnumMapAccumulator f$0;

    public /* synthetic */ CollectCollectors$EnumMapAccumulator$$ExternalSyntheticLambda0(CollectCollectors.EnumMapAccumulator enumMapAccumulator) {
        this.f$0 = enumMapAccumulator;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        this.f$0.put((Enum) obj, obj2);
    }
}
