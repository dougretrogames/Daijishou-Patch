package org.apache.commons.io.filefilter;

import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.Predicate;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class OrFileFilter$$ExternalSyntheticLambda3 implements Predicate {
    public final /* synthetic */ Path f$0;
    public final /* synthetic */ BasicFileAttributes f$1;

    public /* synthetic */ OrFileFilter$$ExternalSyntheticLambda3(Path path, BasicFileAttributes basicFileAttributes) {
        this.f$0 = path;
        this.f$1 = basicFileAttributes;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return OrFileFilter.lambda$accept$2(this.f$0, this.f$1, (IOFileFilter) obj);
    }
}
