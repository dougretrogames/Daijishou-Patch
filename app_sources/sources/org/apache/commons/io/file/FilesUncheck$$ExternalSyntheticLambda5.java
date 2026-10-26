package org.apache.commons.io.file;

import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import org.apache.commons.io.function.IOTriFunction;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class FilesUncheck$$ExternalSyntheticLambda5 implements IOTriFunction {
    @Override // org.apache.commons.io.function.IOTriFunction
    public final Object apply(Object obj, Object obj2, Object obj3) {
        return Files.walk((Path) obj, ((Integer) obj2).intValue(), (FileVisitOption[]) obj3);
    }
}
