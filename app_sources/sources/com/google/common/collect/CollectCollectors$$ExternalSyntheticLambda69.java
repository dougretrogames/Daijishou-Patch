package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.function.BiConsumer;
import java.util.function.Function;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class CollectCollectors$$ExternalSyntheticLambda69 implements BiConsumer {
    public final /* synthetic */ Function f$0;
    public final /* synthetic */ Function f$1;

    public /* synthetic */ CollectCollectors$$ExternalSyntheticLambda69(Function function, Function function2) {
        this.f$0 = function;
        this.f$1 = function2;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        ((CollectCollectors.EnumMapAccumulator) obj).put((Enum) Preconditions.checkNotNull((Enum) this.f$0.apply(obj2), "Null key for input %s", obj2), Preconditions.checkNotNull(this.f$1.apply(obj2), "Null value for input %s", obj2));
    }
}
