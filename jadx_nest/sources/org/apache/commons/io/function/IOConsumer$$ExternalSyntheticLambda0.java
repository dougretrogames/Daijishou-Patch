package org.apache.commons.io.function;

import java.util.function.Consumer;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class IOConsumer$$ExternalSyntheticLambda0 implements Consumer {
    public final /* synthetic */ IOConsumer f$0;

    public /* synthetic */ IOConsumer$$ExternalSyntheticLambda0(IOConsumer iOConsumer) {
        this.f$0 = iOConsumer;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        Uncheck.accept((IOConsumer<Object>) this.f$0, obj);
    }
}
