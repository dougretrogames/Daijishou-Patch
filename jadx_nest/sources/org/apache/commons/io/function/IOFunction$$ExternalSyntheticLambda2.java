package org.apache.commons.io.function;

import java.util.function.Function;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class IOFunction$$ExternalSyntheticLambda2 implements IOFunction {
    public final /* synthetic */ IOFunction f$0;
    public final /* synthetic */ Function f$1;

    public /* synthetic */ IOFunction$$ExternalSyntheticLambda2(IOFunction iOFunction, Function function) {
        this.f$0 = iOFunction;
        this.f$1 = function;
    }

    @Override // org.apache.commons.io.function.IOFunction
    public final Object apply(Object obj) {
        return this.f$0.apply(this.f$1.apply(obj));
    }
}
