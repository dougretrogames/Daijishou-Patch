package org.apache.commons.io.filefilter;

import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import org.apache.commons.io.function.IOSupplier;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class PathVisitorFileFilter$$ExternalSyntheticLambda0 implements IOSupplier {
    public final /* synthetic */ PathVisitorFileFilter f$0;
    public final /* synthetic */ Path f$1;
    public final /* synthetic */ BasicFileAttributes f$2;

    public /* synthetic */ PathVisitorFileFilter$$ExternalSyntheticLambda0(PathVisitorFileFilter pathVisitorFileFilter, Path path, BasicFileAttributes basicFileAttributes) {
        this.f$0 = pathVisitorFileFilter;
        this.f$1 = path;
        this.f$2 = basicFileAttributes;
    }

    @Override // org.apache.commons.io.function.IOSupplier
    public final Object get() {
        return this.f$0.m5579xba762e63(this.f$1, this.f$2);
    }
}
