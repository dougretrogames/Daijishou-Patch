package org.apache.commons.io.output;

import java.util.function.Function;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class BrokenOutputStream$$ExternalSyntheticLambda3 implements Function {
    public final /* synthetic */ Throwable f$0;

    public /* synthetic */ BrokenOutputStream$$ExternalSyntheticLambda3(Throwable th) {
        this.f$0 = th;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return BrokenOutputStream.lambda$new$3(this.f$0, (String) obj);
    }
}
