package org.apache.commons.io.function;

import java.util.function.BooleanSupplier;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class IOBooleanSupplier$$ExternalSyntheticLambda0 implements BooleanSupplier {
    public final /* synthetic */ IOBooleanSupplier f$0;

    public /* synthetic */ IOBooleanSupplier$$ExternalSyntheticLambda0(IOBooleanSupplier iOBooleanSupplier) {
        this.f$0 = iOBooleanSupplier;
    }

    @Override // java.util.function.BooleanSupplier
    public final boolean getAsBoolean() {
        return Uncheck.getAsBoolean(this.f$0);
    }
}
