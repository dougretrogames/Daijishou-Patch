package org.apache.commons.io.file;

import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import org.apache.commons.io.function.IOTriFunction;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class FilesUncheck$$ExternalSyntheticLambda9 implements IOTriFunction {
    @Override // org.apache.commons.io.function.IOTriFunction
    public final Object apply(Object obj, Object obj2, Object obj3) {
        return Files.move((Path) obj, (Path) obj2, (CopyOption[]) obj3);
    }
}
