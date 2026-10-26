package org.apache.commons.io.function;

import java.util.function.BiFunction;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class IOBiFunction$$ExternalSyntheticLambda1 implements BiFunction {
    public final /* synthetic */ IOBiFunction f$0;

    public /* synthetic */ IOBiFunction$$ExternalSyntheticLambda1(IOBiFunction iOBiFunction) {
        this.f$0 = iOBiFunction;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        return Uncheck.apply(this.f$0, obj, obj2);
    }
}
