package org.apache.commons.io;

import java.io.File;
import java.nio.file.LinkOption;
import org.apache.commons.io.file.PathUtils;
import org.apache.commons.io.function.IOBooleanSupplier;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class FileUtils$$ExternalSyntheticLambda23 implements IOBooleanSupplier {
    public final /* synthetic */ File f$0;
    public final /* synthetic */ long f$1;

    public /* synthetic */ FileUtils$$ExternalSyntheticLambda23(File file, long j) {
        this.f$0 = file;
        this.f$1 = j;
    }

    @Override // org.apache.commons.io.function.IOBooleanSupplier
    public final boolean getAsBoolean() {
        return PathUtils.isNewer(this.f$0.toPath(), this.f$1, new LinkOption[0]);
    }
}
