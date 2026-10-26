package org.eclipse.jgit.internal.storage.file;

import java.util.concurrent.Callable;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class PackBitmapIndexV1$$ExternalSyntheticLambda0 implements Callable {
    public final /* synthetic */ PackBitmapIndex.SupplierWithIOException f$0;

    public /* synthetic */ PackBitmapIndexV1$$ExternalSyntheticLambda0(PackBitmapIndex.SupplierWithIOException supplierWithIOException) {
        this.f$0 = supplierWithIOException;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return (PackReverseIndex) this.f$0.get();
    }
}
