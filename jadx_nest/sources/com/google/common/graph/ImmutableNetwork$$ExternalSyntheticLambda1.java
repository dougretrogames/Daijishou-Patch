package com.google.common.graph;

import com.google.common.base.Function;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class ImmutableNetwork$$ExternalSyntheticLambda1 implements Function {
    public final /* synthetic */ Network f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ ImmutableNetwork$$ExternalSyntheticLambda1(Network network, Object obj) {
        this.f$0 = network;
        this.f$1 = obj;
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        return this.f$0.incidentNodes(obj).adjacentNode(this.f$1);
    }
}
