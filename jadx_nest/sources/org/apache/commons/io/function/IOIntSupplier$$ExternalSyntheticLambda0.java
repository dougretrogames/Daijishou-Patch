package org.apache.commons.io.function;

import java.util.function.IntSupplier;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class IOIntSupplier$$ExternalSyntheticLambda0 implements IntSupplier {
    public final /* synthetic */ IOIntSupplier f$0;

    public /* synthetic */ IOIntSupplier$$ExternalSyntheticLambda0(IOIntSupplier iOIntSupplier) {
        this.f$0 = iOIntSupplier;
    }

    @Override // java.util.function.IntSupplier
    public final int getAsInt() {
        return Uncheck.getAsInt(this.f$0);
    }
}
