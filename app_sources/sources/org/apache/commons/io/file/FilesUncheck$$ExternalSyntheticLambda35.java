package org.apache.commons.io.file;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.Set;
import org.apache.commons.io.function.IOTriFunction;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class FilesUncheck$$ExternalSyntheticLambda35 implements IOTriFunction {
    @Override // org.apache.commons.io.function.IOTriFunction
    public final Object apply(Object obj, Object obj2, Object obj3) {
        return Files.newByteChannel((Path) obj, (Set) obj2, (FileAttribute[]) obj3);
    }
}
