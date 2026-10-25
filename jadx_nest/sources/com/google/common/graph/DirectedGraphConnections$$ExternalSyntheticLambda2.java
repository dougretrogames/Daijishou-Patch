package com.google.common.graph;

import com.google.common.base.Function;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class DirectedGraphConnections$$ExternalSyntheticLambda2 implements Function {
    public final /* synthetic */ Object f$0;

    public /* synthetic */ DirectedGraphConnections$$ExternalSyntheticLambda2(Object obj) {
        this.f$0 = obj;
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        return DirectedGraphConnections.lambda$incidentEdgeIterator$2(this.f$0, (DirectedGraphConnections.NodeConnection) obj);
    }
}
