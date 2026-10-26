package org.apache.commons.io.function;

import java.util.function.Consumer;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class IOStream$$ExternalSyntheticLambda17 implements Consumer {
    public final /* synthetic */ IOConsumer f$0;

    public /* synthetic */ IOStream$$ExternalSyntheticLambda17(IOConsumer iOConsumer) {
        this.f$0 = iOConsumer;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) throws Throwable {
        Erase.accept(this.f$0, obj);
    }
}
