package org.apache.commons.io.function;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class IOFunction$$ExternalSyntheticLambda1 implements IOFunction {
    public final /* synthetic */ IOFunction f$0;
    public final /* synthetic */ IOFunction f$1;

    public /* synthetic */ IOFunction$$ExternalSyntheticLambda1(IOFunction iOFunction, IOFunction iOFunction2) {
        this.f$0 = iOFunction;
        this.f$1 = iOFunction2;
    }

    @Override // org.apache.commons.io.function.IOFunction
    public final Object apply(Object obj) {
        return this.f$1.apply(this.f$0.apply(obj));
    }
}
