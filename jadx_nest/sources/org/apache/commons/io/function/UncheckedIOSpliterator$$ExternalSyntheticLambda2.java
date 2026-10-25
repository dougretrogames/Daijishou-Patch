package org.apache.commons.io.function;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class UncheckedIOSpliterator$$ExternalSyntheticLambda2 implements IOSupplier {
    public final /* synthetic */ IOSpliterator f$0;

    public /* synthetic */ UncheckedIOSpliterator$$ExternalSyntheticLambda2(IOSpliterator iOSpliterator) {
        this.f$0 = iOSpliterator;
    }

    @Override // org.apache.commons.io.function.IOSupplier
    public final Object get() {
        return this.f$0.trySplit();
    }
}
