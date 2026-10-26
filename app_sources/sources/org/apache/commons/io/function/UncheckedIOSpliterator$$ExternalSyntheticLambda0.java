package org.apache.commons.io.function;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class UncheckedIOSpliterator$$ExternalSyntheticLambda0 implements IOFunction {
    public final /* synthetic */ IOSpliterator f$0;

    public /* synthetic */ UncheckedIOSpliterator$$ExternalSyntheticLambda0(IOSpliterator iOSpliterator) {
        this.f$0 = iOSpliterator;
    }

    @Override // org.apache.commons.io.function.IOFunction
    public final Object apply(Object obj) {
        return Boolean.valueOf(this.f$0.tryAdvance((IOConsumer) obj));
    }
}
