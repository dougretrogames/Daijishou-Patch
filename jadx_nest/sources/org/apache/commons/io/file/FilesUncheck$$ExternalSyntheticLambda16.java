package org.apache.commons.io.file;

import java.nio.file.Files;
import java.nio.file.attribute.FileAttribute;
import org.apache.commons.io.function.IOTriFunction;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class FilesUncheck$$ExternalSyntheticLambda16 implements IOTriFunction {
    @Override // org.apache.commons.io.function.IOTriFunction
    public final Object apply(Object obj, Object obj2, Object obj3) {
        return Files.createTempFile((String) obj, (String) obj2, (FileAttribute[]) obj3);
    }
}
