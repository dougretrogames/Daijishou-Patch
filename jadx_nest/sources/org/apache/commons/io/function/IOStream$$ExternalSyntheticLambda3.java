package org.apache.commons.io.function;

import java.util.function.Function;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class IOStream$$ExternalSyntheticLambda3 implements Function {
    public final /* synthetic */ IOFunction f$0;

    public /* synthetic */ IOStream$$ExternalSyntheticLambda3(IOFunction iOFunction) {
        this.f$0 = iOFunction;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return ((IOStream) Erase.apply(this.f$0, obj)).unwrap();
    }
}
