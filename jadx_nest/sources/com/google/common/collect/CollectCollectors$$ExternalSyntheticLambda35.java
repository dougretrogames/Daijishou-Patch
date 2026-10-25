package com.google.common.collect;

import java.util.function.Supplier;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class CollectCollectors$$ExternalSyntheticLambda35 implements Supplier {
    public final /* synthetic */ MultimapBuilder.SetMultimapBuilder f$0;

    public /* synthetic */ CollectCollectors$$ExternalSyntheticLambda35(MultimapBuilder.SetMultimapBuilder setMultimapBuilder) {
        this.f$0 = setMultimapBuilder;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return this.f$0.build();
    }
}
