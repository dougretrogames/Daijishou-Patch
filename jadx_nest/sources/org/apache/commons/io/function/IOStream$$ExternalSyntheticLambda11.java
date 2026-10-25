package org.apache.commons.io.function;

import java.util.function.Function;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class IOStream$$ExternalSyntheticLambda11 implements Function {
    public final /* synthetic */ IOFunction f$0;

    public /* synthetic */ IOStream$$ExternalSyntheticLambda11(IOFunction iOFunction) {
        this.f$0 = iOFunction;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return IOStream.lambda$flatMapToInt$8(this.f$0, obj);
    }
}
