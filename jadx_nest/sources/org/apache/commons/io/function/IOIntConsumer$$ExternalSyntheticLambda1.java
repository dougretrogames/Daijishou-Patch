package org.apache.commons.io.function;

import java.io.IOException;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class IOIntConsumer$$ExternalSyntheticLambda1 implements IOIntConsumer {
    public final /* synthetic */ IOIntConsumer f$0;
    public final /* synthetic */ IOIntConsumer f$1;

    public /* synthetic */ IOIntConsumer$$ExternalSyntheticLambda1(IOIntConsumer iOIntConsumer, IOIntConsumer iOIntConsumer2) {
        this.f$0 = iOIntConsumer;
        this.f$1 = iOIntConsumer2;
    }

    @Override // org.apache.commons.io.function.IOIntConsumer
    public final void accept(int i) throws IOException {
        IOIntConsumer.lambda$andThen$1(this.f$0, this.f$1, i);
    }
}
