package org.apache.commons.io.file;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import org.apache.commons.io.function.IOBiFunction;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class FilesUncheck$$ExternalSyntheticLambda27 implements IOBiFunction {
    @Override // org.apache.commons.io.function.IOBiFunction
    public final Object apply(Object obj, Object obj2) {
        return Files.readAllLines((Path) obj, (Charset) obj2);
    }
}
