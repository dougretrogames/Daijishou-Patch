package org.apache.commons.io.function;

import java.util.function.BiFunction;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class IOStream$$ExternalSyntheticLambda7 implements BiFunction {
    public final /* synthetic */ IOBiFunction f$0;

    public /* synthetic */ IOStream$$ExternalSyntheticLambda7(IOBiFunction iOBiFunction) {
        this.f$0 = iOBiFunction;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        return Erase.apply(this.f$0, obj, obj2);
    }
}
