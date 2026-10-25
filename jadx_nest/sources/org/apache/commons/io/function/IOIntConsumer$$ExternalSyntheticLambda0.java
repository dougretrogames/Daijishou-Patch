package org.apache.commons.io.function;

import java.util.function.Consumer;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class IOIntConsumer$$ExternalSyntheticLambda0 implements Consumer {
    public final /* synthetic */ IOIntConsumer f$0;

    public /* synthetic */ IOIntConsumer$$ExternalSyntheticLambda0(IOIntConsumer iOIntConsumer) {
        this.f$0 = iOIntConsumer;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        Uncheck.accept(this.f$0, ((Integer) obj).intValue());
    }
}
