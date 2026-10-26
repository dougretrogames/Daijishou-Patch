package org.apache.commons.io.function;

import java.io.IOException;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class IOConsumer$$ExternalSyntheticLambda2 implements IOConsumer {
    public final /* synthetic */ IOConsumer f$0;
    public final /* synthetic */ IOConsumer f$1;

    public /* synthetic */ IOConsumer$$ExternalSyntheticLambda2(IOConsumer iOConsumer, IOConsumer iOConsumer2) {
        this.f$0 = iOConsumer;
        this.f$1 = iOConsumer2;
    }

    @Override // org.apache.commons.io.function.IOConsumer
    public final void accept(Object obj) throws IOException {
        IOConsumer.lambda$andThen$1(this.f$0, this.f$1, obj);
    }
}
