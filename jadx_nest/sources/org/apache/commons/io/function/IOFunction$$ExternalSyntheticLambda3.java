package org.apache.commons.io.function;

import java.io.IOException;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class IOFunction$$ExternalSyntheticLambda3 implements IOConsumer {
    public final /* synthetic */ IOFunction f$0;
    public final /* synthetic */ IOConsumer f$1;

    public /* synthetic */ IOFunction$$ExternalSyntheticLambda3(IOFunction iOFunction, IOConsumer iOConsumer) {
        this.f$0 = iOFunction;
        this.f$1 = iOConsumer;
    }

    @Override // org.apache.commons.io.function.IOConsumer
    public final void accept(Object obj) throws IOException {
        this.f$1.accept(this.f$0.apply(obj));
    }
}
