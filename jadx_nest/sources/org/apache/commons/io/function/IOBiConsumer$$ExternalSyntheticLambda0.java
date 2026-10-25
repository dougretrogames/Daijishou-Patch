package org.apache.commons.io.function;

import java.io.IOException;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class IOBiConsumer$$ExternalSyntheticLambda0 implements IOBiConsumer {
    public final /* synthetic */ IOBiConsumer f$0;
    public final /* synthetic */ IOBiConsumer f$1;

    public /* synthetic */ IOBiConsumer$$ExternalSyntheticLambda0(IOBiConsumer iOBiConsumer, IOBiConsumer iOBiConsumer2) {
        this.f$0 = iOBiConsumer;
        this.f$1 = iOBiConsumer2;
    }

    @Override // org.apache.commons.io.function.IOBiConsumer
    public final void accept(Object obj, Object obj2) throws IOException {
        IOBiConsumer.lambda$andThen$0(this.f$0, this.f$1, obj, obj2);
    }
}
