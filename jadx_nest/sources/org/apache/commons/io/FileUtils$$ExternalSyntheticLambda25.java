package org.apache.commons.io;

import java.io.File;
import java.nio.file.FileVisitOption;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.function.IOFunction;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class FileUtils$$ExternalSyntheticLambda25 implements IOFunction {
    public final /* synthetic */ IOFileFilter f$0;
    public final /* synthetic */ IOFileFilter f$1;

    public /* synthetic */ FileUtils$$ExternalSyntheticLambda25(IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2) {
        this.f$0 = iOFileFilter;
        this.f$1 = iOFileFilter2;
    }

    @Override // org.apache.commons.io.function.IOFunction
    public final Object apply(Object obj) {
        return FileUtils.listAccumulate((File) obj, this.f$0, this.f$1, FileVisitOption.FOLLOW_LINKS);
    }
}
