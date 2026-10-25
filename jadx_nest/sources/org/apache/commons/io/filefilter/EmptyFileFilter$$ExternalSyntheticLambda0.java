package org.apache.commons.io.filefilter;

import java.nio.file.Path;
import org.apache.commons.io.function.IOSupplier;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class EmptyFileFilter$$ExternalSyntheticLambda0 implements IOSupplier {
    public final /* synthetic */ EmptyFileFilter f$0;
    public final /* synthetic */ Path f$1;

    public /* synthetic */ EmptyFileFilter$$ExternalSyntheticLambda0(EmptyFileFilter emptyFileFilter, Path path) {
        this.f$0 = emptyFileFilter;
        this.f$1 = path;
    }

    @Override // org.apache.commons.io.function.IOSupplier
    public final Object get() {
        return this.f$0.m5575lambda$accept$0$orgapachecommonsiofilefilterEmptyFileFilter(this.f$1);
    }
}
