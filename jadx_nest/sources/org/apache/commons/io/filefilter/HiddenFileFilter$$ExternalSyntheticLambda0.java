package org.apache.commons.io.filefilter;

import java.nio.file.Path;
import org.apache.commons.io.function.IOSupplier;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class HiddenFileFilter$$ExternalSyntheticLambda0 implements IOSupplier {
    public final /* synthetic */ HiddenFileFilter f$0;
    public final /* synthetic */ Path f$1;

    public /* synthetic */ HiddenFileFilter$$ExternalSyntheticLambda0(HiddenFileFilter hiddenFileFilter, Path path) {
        this.f$0 = hiddenFileFilter;
        this.f$1 = path;
    }

    @Override // org.apache.commons.io.function.IOSupplier
    public final Object get() {
        return this.f$0.m5576x3301f0b8(this.f$1);
    }
}
