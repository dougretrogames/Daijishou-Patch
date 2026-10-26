package org.apache.commons.io.input;

import java.io.IOException;
import java.util.function.Supplier;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class BrokenReader$$ExternalSyntheticLambda0 implements Supplier {
    public final /* synthetic */ IOException f$0;

    public /* synthetic */ BrokenReader$$ExternalSyntheticLambda0(IOException iOException) {
        this.f$0 = iOException;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return BrokenReader.lambda$new$1(this.f$0);
    }
}
