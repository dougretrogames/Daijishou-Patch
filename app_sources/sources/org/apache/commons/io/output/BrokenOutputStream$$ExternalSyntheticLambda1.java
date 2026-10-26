package org.apache.commons.io.output;

import java.io.IOException;
import java.util.function.Function;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class BrokenOutputStream$$ExternalSyntheticLambda1 implements Function {
    public final /* synthetic */ IOException f$0;

    public /* synthetic */ BrokenOutputStream$$ExternalSyntheticLambda1(IOException iOException) {
        this.f$0 = iOException;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return BrokenOutputStream.lambda$new$1(this.f$0, (String) obj);
    }
}
