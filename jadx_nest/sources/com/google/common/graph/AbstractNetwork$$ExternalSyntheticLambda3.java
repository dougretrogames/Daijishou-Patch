package com.google.common.graph;

import com.google.common.base.Supplier;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class AbstractNetwork$$ExternalSyntheticLambda3 implements Supplier {
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ AbstractNetwork$$ExternalSyntheticLambda3(Object obj, Object obj2) {
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    @Override // com.google.common.base.Supplier
    public final Object get() {
        return String.format("Node %s or node %s that were used to generate this set are no longer in the graph.", this.f$0, this.f$1);
    }
}
