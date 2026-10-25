package org.apache.commons.io.function;

import java.util.function.IntConsumer;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class IOIntConsumer$$ExternalSyntheticLambda3 implements IntConsumer {
    public final /* synthetic */ IOIntConsumer f$0;

    public /* synthetic */ IOIntConsumer$$ExternalSyntheticLambda3(IOIntConsumer iOIntConsumer) {
        this.f$0 = iOIntConsumer;
    }

    @Override // java.util.function.IntConsumer
    public final void accept(int i) {
        Uncheck.accept(this.f$0, i);
    }
}
