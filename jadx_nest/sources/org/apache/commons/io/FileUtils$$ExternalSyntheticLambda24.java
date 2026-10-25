package org.apache.commons.io;

import java.io.File;
import org.apache.commons.io.file.PathUtils;
import org.apache.commons.io.function.IOSupplier;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class FileUtils$$ExternalSyntheticLambda24 implements IOSupplier {
    public final /* synthetic */ File f$0;

    public /* synthetic */ FileUtils$$ExternalSyntheticLambda24(File file) {
        this.f$0 = file;
    }

    @Override // org.apache.commons.io.function.IOSupplier
    public final Object get() {
        return PathUtils.sizeOfDirectoryAsBigInteger(this.f$0.toPath());
    }
}
