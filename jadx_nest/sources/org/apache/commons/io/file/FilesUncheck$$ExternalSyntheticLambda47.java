package org.apache.commons.io.file;

import java.nio.file.Files;
import java.nio.file.Path;
import org.apache.commons.io.function.IOBiFunction;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class FilesUncheck$$ExternalSyntheticLambda47 implements IOBiFunction {
    @Override // org.apache.commons.io.function.IOBiFunction
    public final Object apply(Object obj, Object obj2) {
        return Boolean.valueOf(Files.isSameFile((Path) obj, (Path) obj2));
    }
}
