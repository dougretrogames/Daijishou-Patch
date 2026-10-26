package org.apache.commons.io;

import java.io.File;
import java.nio.file.FileVisitOption;
import org.apache.commons.io.filefilter.FileFileFilter;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.function.IOFunction;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class FileUtils$$ExternalSyntheticLambda18 implements IOFunction {
    public final /* synthetic */ IOFileFilter f$0;
    public final /* synthetic */ IOFileFilter f$1;

    public /* synthetic */ FileUtils$$ExternalSyntheticLambda18(IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2) {
        this.f$0 = iOFileFilter;
        this.f$1 = iOFileFilter2;
    }

    @Override // org.apache.commons.io.function.IOFunction
    public final Object apply(Object obj) {
        return FileUtils.listAccumulate((File) obj, FileFileFilter.INSTANCE.and(this.f$0), this.f$1, FileVisitOption.FOLLOW_LINKS);
    }
}
