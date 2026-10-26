package org.apache.commons.io.function;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class IOBiFunction$$ExternalSyntheticLambda0 implements IOBiFunction {
    public final /* synthetic */ IOBiFunction f$0;
    public final /* synthetic */ IOFunction f$1;

    public /* synthetic */ IOBiFunction$$ExternalSyntheticLambda0(IOBiFunction iOBiFunction, IOFunction iOFunction) {
        this.f$0 = iOBiFunction;
        this.f$1 = iOFunction;
    }

    @Override // org.apache.commons.io.function.IOBiFunction
    public final Object apply(Object obj, Object obj2) {
        return this.f$1.apply(this.f$0.apply(obj, obj2));
    }
}
