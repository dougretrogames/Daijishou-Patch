package com.google.common.collect;

import java.util.function.Supplier;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class CollectCollectors$$ExternalSyntheticLambda26 implements Supplier {
    public final /* synthetic */ MultimapBuilder.ListMultimapBuilder f$0;

    public /* synthetic */ CollectCollectors$$ExternalSyntheticLambda26(MultimapBuilder.ListMultimapBuilder listMultimapBuilder) {
        this.f$0 = listMultimapBuilder;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return this.f$0.build();
    }
}
