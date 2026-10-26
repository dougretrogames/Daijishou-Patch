package org.apache.commons.io.file;

import java.nio.file.Path;
import java.util.function.UnaryOperator;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class PathUtils$$ExternalSyntheticLambda4 implements UnaryOperator {
    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return PathUtils.stripTrailingSeparator((Path) obj);
    }
}
