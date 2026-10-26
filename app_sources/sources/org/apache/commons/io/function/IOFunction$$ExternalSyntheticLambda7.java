package org.apache.commons.io.function;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class IOFunction$$ExternalSyntheticLambda7 implements IOFunction {
    public final /* synthetic */ IOFunction f$0;
    public final /* synthetic */ IOFunction f$1;

    public /* synthetic */ IOFunction$$ExternalSyntheticLambda7(IOFunction iOFunction, IOFunction iOFunction2) {
        this.f$0 = iOFunction;
        this.f$1 = iOFunction2;
    }

    @Override // org.apache.commons.io.function.IOFunction
    public final Object apply(Object obj) {
        return this.f$0.apply(this.f$1.apply(obj));
    }
}
