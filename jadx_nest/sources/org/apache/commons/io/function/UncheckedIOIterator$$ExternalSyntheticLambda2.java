package org.apache.commons.io.function;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class UncheckedIOIterator$$ExternalSyntheticLambda2 implements IOBooleanSupplier {
    public final /* synthetic */ IOIterator f$0;

    public /* synthetic */ UncheckedIOIterator$$ExternalSyntheticLambda2(IOIterator iOIterator) {
        this.f$0 = iOIterator;
    }

    @Override // org.apache.commons.io.function.IOBooleanSupplier
    public final boolean getAsBoolean() {
        return this.f$0.hasNext();
    }
}
