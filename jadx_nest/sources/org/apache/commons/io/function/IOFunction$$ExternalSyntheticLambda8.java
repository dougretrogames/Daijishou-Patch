package org.apache.commons.io.function;

import java.util.function.Supplier;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class IOFunction$$ExternalSyntheticLambda8 implements IOSupplier {
    public final /* synthetic */ IOFunction f$0;
    public final /* synthetic */ Supplier f$1;

    public /* synthetic */ IOFunction$$ExternalSyntheticLambda8(IOFunction iOFunction, Supplier supplier) {
        this.f$0 = iOFunction;
        this.f$1 = supplier;
    }

    @Override // org.apache.commons.io.function.IOSupplier
    public final Object get() {
        return this.f$0.apply(this.f$1.get());
    }
}
