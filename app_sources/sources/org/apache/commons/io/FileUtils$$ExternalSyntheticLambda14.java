package org.apache.commons.io;

import java.io.File;
import java.nio.file.LinkOption;
import java.time.Instant;
import org.apache.commons.io.file.PathUtils;
import org.apache.commons.io.function.IOBooleanSupplier;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class FileUtils$$ExternalSyntheticLambda14 implements IOBooleanSupplier {
    public final /* synthetic */ File f$0;
    public final /* synthetic */ Instant f$1;

    public /* synthetic */ FileUtils$$ExternalSyntheticLambda14(File file, Instant instant) {
        this.f$0 = file;
        this.f$1 = instant;
    }

    @Override // org.apache.commons.io.function.IOBooleanSupplier
    public final boolean getAsBoolean() {
        return PathUtils.isNewer(this.f$0.toPath(), this.f$1, new LinkOption[0]);
    }
}
