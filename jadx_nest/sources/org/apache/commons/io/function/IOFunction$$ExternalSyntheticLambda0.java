package org.apache.commons.io.function;

import java.util.function.Function;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class IOFunction$$ExternalSyntheticLambda0 implements Function {
    public final /* synthetic */ IOFunction f$0;

    public /* synthetic */ IOFunction$$ExternalSyntheticLambda0(IOFunction iOFunction) {
        this.f$0 = iOFunction;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return Uncheck.apply(this.f$0, obj);
    }
}
