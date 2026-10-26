package org.apache.commons.io.filefilter;

import java.nio.file.Path;
import org.apache.commons.io.function.IOSupplier;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class AgeFileFilter$$ExternalSyntheticLambda0 implements IOSupplier {
    public final /* synthetic */ AgeFileFilter f$0;
    public final /* synthetic */ Path f$1;

    public /* synthetic */ AgeFileFilter$$ExternalSyntheticLambda0(AgeFileFilter ageFileFilter, Path path) {
        this.f$0 = ageFileFilter;
        this.f$1 = path;
    }

    @Override // org.apache.commons.io.function.IOSupplier
    public final Object get() {
        return this.f$0.m5574lambda$accept$0$orgapachecommonsiofilefilterAgeFileFilter(this.f$1);
    }
}
