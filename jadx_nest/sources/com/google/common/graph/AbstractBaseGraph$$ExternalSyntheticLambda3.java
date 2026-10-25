package com.google.common.graph;

import com.google.common.base.Supplier;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class AbstractBaseGraph$$ExternalSyntheticLambda3 implements Supplier {
    public final /* synthetic */ Object f$0;

    public /* synthetic */ AbstractBaseGraph$$ExternalSyntheticLambda3(Object obj) {
        this.f$0 = obj;
    }

    @Override // com.google.common.base.Supplier
    public final Object get() {
        return String.format("Node %s that was used to generate this set is no longer in the graph.", this.f$0);
    }
}
