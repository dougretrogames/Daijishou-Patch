package org.apache.commons.io.function;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class UncheckedIOSpliterator$$ExternalSyntheticLambda3 implements IOConsumer {
    public final /* synthetic */ IOSpliterator f$0;

    public /* synthetic */ UncheckedIOSpliterator$$ExternalSyntheticLambda3(IOSpliterator iOSpliterator) {
        this.f$0 = iOSpliterator;
    }

    @Override // org.apache.commons.io.function.IOConsumer
    public final void accept(Object obj) {
        this.f$0.forEachRemaining((IOConsumer) obj);
    }
}
