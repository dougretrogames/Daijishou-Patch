package org.apache.commons.io.file;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import org.apache.commons.io.function.IOTriFunction;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class FilesUncheck$$ExternalSyntheticLambda39 implements IOTriFunction {
    @Override // org.apache.commons.io.function.IOTriFunction
    public final Object apply(Object obj, Object obj2, Object obj3) {
        return Files.createSymbolicLink((Path) obj, (Path) obj2, (FileAttribute[]) obj3);
    }
}
