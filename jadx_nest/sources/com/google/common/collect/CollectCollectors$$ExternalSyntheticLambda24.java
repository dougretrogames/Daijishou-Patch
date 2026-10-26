package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.function.Function;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class CollectCollectors$$ExternalSyntheticLambda24 implements Function {
    public final /* synthetic */ Function f$0;

    public /* synthetic */ CollectCollectors$$ExternalSyntheticLambda24(Function function) {
        this.f$0 = function;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return Preconditions.checkNotNull(this.f$0.apply(obj));
    }
}
