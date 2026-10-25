package org.apache.commons.io.function;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class IOFunction$$ExternalSyntheticLambda6 implements IOSupplier {
    public final /* synthetic */ IOFunction f$0;
    public final /* synthetic */ IOSupplier f$1;

    public /* synthetic */ IOFunction$$ExternalSyntheticLambda6(IOFunction iOFunction, IOSupplier iOSupplier) {
        this.f$0 = iOFunction;
        this.f$1 = iOSupplier;
    }

    @Override // org.apache.commons.io.function.IOSupplier
    public final Object get() {
        return this.f$0.apply(this.f$1.get());
    }
}
