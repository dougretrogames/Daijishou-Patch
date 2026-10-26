package org.apache.commons.io.function;

import java.util.function.Supplier;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class IOSupplier$$ExternalSyntheticLambda0 implements Supplier {
    public final /* synthetic */ IOSupplier f$0;

    public /* synthetic */ IOSupplier$$ExternalSyntheticLambda0(IOSupplier iOSupplier) {
        this.f$0 = iOSupplier;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return this.f$0.getUnchecked();
    }
}
