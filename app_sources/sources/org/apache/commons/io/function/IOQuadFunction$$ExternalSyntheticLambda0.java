package org.apache.commons.io.function;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class IOQuadFunction$$ExternalSyntheticLambda0 implements IOQuadFunction {
    public final /* synthetic */ IOQuadFunction f$0;
    public final /* synthetic */ IOFunction f$1;

    public /* synthetic */ IOQuadFunction$$ExternalSyntheticLambda0(IOQuadFunction iOQuadFunction, IOFunction iOFunction) {
        this.f$0 = iOQuadFunction;
        this.f$1 = iOFunction;
    }

    @Override // org.apache.commons.io.function.IOQuadFunction
    public final Object apply(Object obj, Object obj2, Object obj3, Object obj4) {
        return this.f$1.apply(this.f$0.apply(obj, obj2, obj3, obj4));
    }
}
