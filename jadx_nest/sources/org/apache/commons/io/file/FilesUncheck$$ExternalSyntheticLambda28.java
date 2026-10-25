package org.apache.commons.io.file;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import org.apache.commons.io.function.IOQuadFunction;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class FilesUncheck$$ExternalSyntheticLambda28 implements IOQuadFunction {
    @Override // org.apache.commons.io.function.IOQuadFunction
    public final Object apply(Object obj, Object obj2, Object obj3, Object obj4) {
        return Files.write((Path) obj, (Iterable) obj2, (Charset) obj3, (OpenOption[]) obj4);
    }
}
