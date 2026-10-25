package org.apache.commons.io.input;

import java.util.function.Supplier;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class BrokenReader$$ExternalSyntheticLambda1 implements Supplier {
    public final /* synthetic */ Throwable f$0;

    public /* synthetic */ BrokenReader$$ExternalSyntheticLambda1(Throwable th) {
        this.f$0 = th;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return BrokenReader.lambda$new$2(this.f$0);
    }
}
