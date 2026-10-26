package org.apache.commons.io.function;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class UncheckedIOIterator$$ExternalSyntheticLambda0 implements IOSupplier {
    public final /* synthetic */ IOIterator f$0;

    public /* synthetic */ UncheckedIOIterator$$ExternalSyntheticLambda0(IOIterator iOIterator) {
        this.f$0 = iOIterator;
    }

    @Override // org.apache.commons.io.function.IOSupplier
    public final Object get() {
        return this.f$0.next();
    }
}
