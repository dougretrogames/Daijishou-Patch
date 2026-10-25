package org.apache.commons.io.file;

import java.nio.file.Files;
import java.nio.file.Path;
import org.apache.commons.io.function.IOFunction;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class FilesUncheck$$ExternalSyntheticLambda11 implements IOFunction {
    @Override // org.apache.commons.io.function.IOFunction
    public final Object apply(Object obj) {
        return Files.readAllLines((Path) obj);
    }
}
