package org.apache.commons.io.function;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiFunction;
import java.util.function.Consumer;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class IOStream$$ExternalSyntheticLambda18 implements Consumer {
    public final /* synthetic */ IOConsumer f$0;
    public final /* synthetic */ AtomicReference f$1;
    public final /* synthetic */ BiFunction f$2;
    public final /* synthetic */ AtomicInteger f$3;

    public /* synthetic */ IOStream$$ExternalSyntheticLambda18(IOConsumer iOConsumer, AtomicReference atomicReference, BiFunction biFunction, AtomicInteger atomicInteger) {
        this.f$0 = iOConsumer;
        this.f$1 = atomicReference;
        this.f$2 = biFunction;
        this.f$3 = atomicInteger;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        IOStream.lambda$forAll$11(this.f$0, this.f$1, this.f$2, this.f$3, obj);
    }
}
