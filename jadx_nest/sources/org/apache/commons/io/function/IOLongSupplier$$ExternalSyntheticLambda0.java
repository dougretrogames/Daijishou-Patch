package org.apache.commons.io.function;

import java.util.function.LongSupplier;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class IOLongSupplier$$ExternalSyntheticLambda0 implements LongSupplier {
    public final /* synthetic */ IOLongSupplier f$0;

    public /* synthetic */ IOLongSupplier$$ExternalSyntheticLambda0(IOLongSupplier iOLongSupplier) {
        this.f$0 = iOLongSupplier;
    }

    @Override // java.util.function.LongSupplier
    public final long getAsLong() {
        return Uncheck.getAsLong(this.f$0);
    }
}
