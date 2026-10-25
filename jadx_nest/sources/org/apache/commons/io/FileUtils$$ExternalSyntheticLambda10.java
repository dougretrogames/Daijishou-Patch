package org.apache.commons.io;

import java.io.File;
import org.apache.commons.io.file.PathUtils;
import org.apache.commons.io.function.IOBooleanSupplier;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class FileUtils$$ExternalSyntheticLambda10 implements IOBooleanSupplier {
    public final /* synthetic */ File f$0;
    public final /* synthetic */ File f$1;

    public /* synthetic */ FileUtils$$ExternalSyntheticLambda10(File file, File file2) {
        this.f$0 = file;
        this.f$1 = file2;
    }

    @Override // org.apache.commons.io.function.IOBooleanSupplier
    public final boolean getAsBoolean() {
        return PathUtils.isOlder(this.f$0.toPath(), this.f$1.toPath());
    }
}
