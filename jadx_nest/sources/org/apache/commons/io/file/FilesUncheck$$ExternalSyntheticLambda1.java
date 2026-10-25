package org.apache.commons.io.file;

import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import org.apache.commons.io.function.IOTriFunction;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class FilesUncheck$$ExternalSyntheticLambda1 implements IOTriFunction {
    @Override // org.apache.commons.io.function.IOTriFunction
    public final Object apply(Object obj, Object obj2, Object obj3) {
        return Files.write((Path) obj, (byte[]) obj2, (OpenOption[]) obj3);
    }
}
