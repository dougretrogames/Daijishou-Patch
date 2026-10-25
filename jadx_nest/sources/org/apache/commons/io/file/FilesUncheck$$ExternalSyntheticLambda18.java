package org.apache.commons.io.file;

import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.BiPredicate;
import org.apache.commons.io.function.IOQuadFunction;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class FilesUncheck$$ExternalSyntheticLambda18 implements IOQuadFunction {
    @Override // org.apache.commons.io.function.IOQuadFunction
    public final Object apply(Object obj, Object obj2, Object obj3, Object obj4) {
        return Files.find((Path) obj, ((Integer) obj2).intValue(), (BiPredicate) obj3, (FileVisitOption[]) obj4);
    }
}
