package org.apache.commons.io.function;

import java.util.function.Consumer;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class IOFunction$$ExternalSyntheticLambda5 implements IOConsumer {
    public final /* synthetic */ IOFunction f$0;
    public final /* synthetic */ Consumer f$1;

    public /* synthetic */ IOFunction$$ExternalSyntheticLambda5(IOFunction iOFunction, Consumer consumer) {
        this.f$0 = iOFunction;
        this.f$1 = consumer;
    }

    @Override // org.apache.commons.io.function.IOConsumer
    public final void accept(Object obj) {
        this.f$1.accept(this.f$0.apply(obj));
    }
}
