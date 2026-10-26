package org.apache.commons.io.output;

import java.util.function.Supplier;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class BrokenWriter$$ExternalSyntheticLambda1 implements Supplier {
    public final /* synthetic */ Throwable f$0;

    public /* synthetic */ BrokenWriter$$ExternalSyntheticLambda1(Throwable th) {
        this.f$0 = th;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return BrokenWriter.lambda$new$2(this.f$0);
    }
}
