package org.apache.commons.io;

import java.io.File;
import org.apache.commons.io.file.PathUtils;
import org.apache.commons.io.function.IOLongSupplier;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class FileUtils$$ExternalSyntheticLambda2 implements IOLongSupplier {
    public final /* synthetic */ File f$0;

    public /* synthetic */ FileUtils$$ExternalSyntheticLambda2(File file) {
        this.f$0 = file;
    }

    @Override // org.apache.commons.io.function.IOLongSupplier
    public final long getAsLong() {
        return PathUtils.sizeOfDirectory(this.f$0.toPath());
    }
}
