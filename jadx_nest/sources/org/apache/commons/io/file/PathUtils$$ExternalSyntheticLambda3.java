package org.apache.commons.io.file;

import java.nio.file.Path;
import java.util.function.Function;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class PathUtils$$ExternalSyntheticLambda3 implements Function {
    public final /* synthetic */ Path f$0;

    public /* synthetic */ PathUtils$$ExternalSyntheticLambda3(Path path) {
        this.f$0 = path;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return this.f$0.relativize((Path) obj);
    }
}
