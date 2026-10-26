package com.google.common.graph;

import com.google.common.base.Function;
import java.util.Objects;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class ImmutableValueGraph$$ExternalSyntheticLambda0 implements Function {
    public final /* synthetic */ ValueGraph f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ ImmutableValueGraph$$ExternalSyntheticLambda0(ValueGraph valueGraph, Object obj) {
        this.f$0 = valueGraph;
        this.f$1 = obj;
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        return Objects.requireNonNull(this.f$0.edgeValueOrDefault(this.f$1, obj, null));
    }
}
