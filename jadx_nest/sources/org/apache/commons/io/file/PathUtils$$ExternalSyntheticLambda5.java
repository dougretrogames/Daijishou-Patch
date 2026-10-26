package org.apache.commons.io.file;

import java.nio.file.Path;
import java.util.function.Predicate;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class PathUtils$$ExternalSyntheticLambda5 implements Predicate {
    public final /* synthetic */ PathFilter f$0;

    public /* synthetic */ PathUtils$$ExternalSyntheticLambda5(PathFilter pathFilter) {
        this.f$0 = pathFilter;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return PathUtils.lambda$filterPaths$2(this.f$0, (Path) obj);
    }
}
