package org.apache.commons.io.function;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class IOTriFunction$$ExternalSyntheticLambda0 implements IOTriFunction {
    public final /* synthetic */ IOTriFunction f$0;
    public final /* synthetic */ IOFunction f$1;

    public /* synthetic */ IOTriFunction$$ExternalSyntheticLambda0(IOTriFunction iOTriFunction, IOFunction iOFunction) {
        this.f$0 = iOTriFunction;
        this.f$1 = iOFunction;
    }

    @Override // org.apache.commons.io.function.IOTriFunction
    public final Object apply(Object obj, Object obj2, Object obj3) {
        return this.f$1.apply(this.f$0.apply(obj, obj2, obj3));
    }
}
