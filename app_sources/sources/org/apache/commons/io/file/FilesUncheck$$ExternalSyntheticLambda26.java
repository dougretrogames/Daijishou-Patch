package org.apache.commons.io.file;

import java.nio.file.Files;
import java.nio.file.Path;
import org.apache.commons.io.function.IOFunction;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class FilesUncheck$$ExternalSyntheticLambda26 implements IOFunction {
    @Override // org.apache.commons.io.function.IOFunction
    public final Object apply(Object obj) {
        return Files.readSymbolicLink((Path) obj);
    }
}
