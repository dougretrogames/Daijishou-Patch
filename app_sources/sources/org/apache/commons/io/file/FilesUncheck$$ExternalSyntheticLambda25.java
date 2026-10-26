package org.apache.commons.io.file;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import org.apache.commons.io.function.IOQuadFunction;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class FilesUncheck$$ExternalSyntheticLambda25 implements IOQuadFunction {
    @Override // org.apache.commons.io.function.IOQuadFunction
    public final Object apply(Object obj, Object obj2, Object obj3, Object obj4) {
        return Files.setAttribute((Path) obj, (String) obj2, obj3, (LinkOption[]) obj4);
    }
}
