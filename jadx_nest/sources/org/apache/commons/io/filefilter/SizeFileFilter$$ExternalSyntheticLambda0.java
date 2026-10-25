package org.apache.commons.io.filefilter;

import java.nio.file.Path;
import org.apache.commons.io.function.IOSupplier;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class SizeFileFilter$$ExternalSyntheticLambda0 implements IOSupplier {
    public final /* synthetic */ SizeFileFilter f$0;
    public final /* synthetic */ Path f$1;

    public /* synthetic */ SizeFileFilter$$ExternalSyntheticLambda0(SizeFileFilter sizeFileFilter, Path path) {
        this.f$0 = sizeFileFilter;
        this.f$1 = path;
    }

    @Override // org.apache.commons.io.function.IOSupplier
    public final Object get() {
        return this.f$0.m5581lambda$accept$0$orgapachecommonsiofilefilterSizeFileFilter(this.f$1);
    }
}
