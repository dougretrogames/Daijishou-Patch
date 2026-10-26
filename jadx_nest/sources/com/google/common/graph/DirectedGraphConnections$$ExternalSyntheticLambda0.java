package com.google.common.graph;

import com.google.common.base.Function;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class DirectedGraphConnections$$ExternalSyntheticLambda0 implements Function {
    public final /* synthetic */ Object f$0;

    public /* synthetic */ DirectedGraphConnections$$ExternalSyntheticLambda0(Object obj) {
        this.f$0 = obj;
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        return EndpointPair.ordered(obj, this.f$0);
    }
}
