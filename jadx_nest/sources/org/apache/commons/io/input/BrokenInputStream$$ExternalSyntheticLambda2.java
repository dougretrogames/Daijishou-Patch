package org.apache.commons.io.input;

import java.io.IOException;
import java.util.function.Supplier;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class BrokenInputStream$$ExternalSyntheticLambda2 implements Supplier {
    public final /* synthetic */ IOException f$0;

    public /* synthetic */ BrokenInputStream$$ExternalSyntheticLambda2(IOException iOException) {
        this.f$0 = iOException;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return BrokenInputStream.lambda$new$1(this.f$0);
    }
}
