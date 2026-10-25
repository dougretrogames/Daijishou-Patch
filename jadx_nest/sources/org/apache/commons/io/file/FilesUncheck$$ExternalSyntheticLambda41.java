package org.apache.commons.io.file;

import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;
import org.apache.commons.io.function.IOQuadFunction;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class FilesUncheck$$ExternalSyntheticLambda41 implements IOQuadFunction {
    @Override // org.apache.commons.io.function.IOQuadFunction
    public final Object apply(Object obj, Object obj2, Object obj3, Object obj4) {
        return Files.walkFileTree((Path) obj, (Set) obj2, ((Integer) obj3).intValue(), (FileVisitor) obj4);
    }
}
