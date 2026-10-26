package org.apache.commons.io.file;

import java.nio.file.Path;
import java.util.function.Predicate;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class PathUtils$$ExternalSyntheticLambda0 implements Predicate {
    public final /* synthetic */ PathFilter f$0;
    public final /* synthetic */ boolean f$1;

    public /* synthetic */ PathUtils$$ExternalSyntheticLambda0(PathFilter pathFilter, boolean z) {
        this.f$0 = pathFilter;
        this.f$1 = z;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return PathUtils.lambda$walk$4(this.f$0, this.f$1, (Path) obj);
    }
}
