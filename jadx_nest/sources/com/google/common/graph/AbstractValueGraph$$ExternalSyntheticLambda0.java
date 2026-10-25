package com.google.common.graph;

import com.google.common.base.Function;
import java.util.Objects;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class AbstractValueGraph$$ExternalSyntheticLambda0 implements Function {
    public final /* synthetic */ ValueGraph f$0;

    public /* synthetic */ AbstractValueGraph$$ExternalSyntheticLambda0(ValueGraph valueGraph) {
        this.f$0 = valueGraph;
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        EndpointPair endpointPair = (EndpointPair) obj;
        return Objects.requireNonNull(this.f$0.edgeValueOrDefault(endpointPair.nodeU(), endpointPair.nodeV(), null));
    }
}
