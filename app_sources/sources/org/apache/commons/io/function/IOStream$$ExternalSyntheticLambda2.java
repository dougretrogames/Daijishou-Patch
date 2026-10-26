package org.apache.commons.io.function;

import java.util.function.Function;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class IOStream$$ExternalSyntheticLambda2 implements Function {
    public final /* synthetic */ IOFunction f$0;

    public /* synthetic */ IOStream$$ExternalSyntheticLambda2(IOFunction iOFunction) {
        this.f$0 = iOFunction;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return Erase.apply(this.f$0, obj);
    }
}
