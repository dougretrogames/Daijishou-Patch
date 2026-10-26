package org.apache.commons.io.file;

import java.nio.file.Path;
import java.util.function.Function;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class PathUtils$$ExternalSyntheticLambda7 implements Function {
    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        Path path = (Path) obj;
        return PathUtils.RelativeSortedPaths.extractKey(path.getFileSystem().getSeparator(), path.toString());
    }
}
