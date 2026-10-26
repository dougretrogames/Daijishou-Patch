package org.apache.commons.io.function;

import java.io.IOException;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class IOTriConsumer$$ExternalSyntheticLambda0 implements IOTriConsumer {
    public final /* synthetic */ IOTriConsumer f$0;
    public final /* synthetic */ IOTriConsumer f$1;

    public /* synthetic */ IOTriConsumer$$ExternalSyntheticLambda0(IOTriConsumer iOTriConsumer, IOTriConsumer iOTriConsumer2) {
        this.f$0 = iOTriConsumer;
        this.f$1 = iOTriConsumer2;
    }

    @Override // org.apache.commons.io.function.IOTriConsumer
    public final void accept(Object obj, Object obj2, Object obj3) throws IOException {
        IOTriConsumer.lambda$andThen$0(this.f$0, this.f$1, obj, obj2, obj3);
    }
}
