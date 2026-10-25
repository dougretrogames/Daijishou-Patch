package org.apache.commons.io.output;

import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class BrokenOutputStream$$ExternalSyntheticLambda0 implements Function {
    public final /* synthetic */ Supplier f$0;

    public /* synthetic */ BrokenOutputStream$$ExternalSyntheticLambda0(Supplier supplier) {
        this.f$0 = supplier;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return BrokenOutputStream.lambda$new$2(this.f$0, (String) obj);
    }
}
