package org.apache.commons.io.function;

import java.util.function.BiConsumer;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class IOBiConsumer$$ExternalSyntheticLambda1 implements BiConsumer {
    public final /* synthetic */ IOBiConsumer f$0;

    public /* synthetic */ IOBiConsumer$$ExternalSyntheticLambda1(IOBiConsumer iOBiConsumer) {
        this.f$0 = iOBiConsumer;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        Uncheck.accept(this.f$0, obj, obj2);
    }
}
