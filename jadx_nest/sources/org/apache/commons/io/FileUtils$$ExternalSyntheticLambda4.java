package org.apache.commons.io;

import java.io.File;
import org.apache.commons.io.function.IOFunction;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class FileUtils$$ExternalSyntheticLambda4 implements IOFunction {
    @Override // org.apache.commons.io.function.IOFunction
    public final Object apply(Object obj) {
        return Long.valueOf(FileUtils.lastModified((File) obj));
    }
}
