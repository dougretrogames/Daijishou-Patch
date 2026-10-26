package org.apache.commons.io;

import java.io.File;
import java.nio.file.LinkOption;
import java.time.chrono.ChronoZonedDateTime;
import org.apache.commons.io.file.PathUtils;
import org.apache.commons.io.function.IOBooleanSupplier;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class FileUtils$$ExternalSyntheticLambda12 implements IOBooleanSupplier {
    public final /* synthetic */ File f$0;
    public final /* synthetic */ ChronoZonedDateTime f$1;

    public /* synthetic */ FileUtils$$ExternalSyntheticLambda12(File file, ChronoZonedDateTime chronoZonedDateTime) {
        this.f$0 = file;
        this.f$1 = chronoZonedDateTime;
    }

    @Override // org.apache.commons.io.function.IOBooleanSupplier
    public final boolean getAsBoolean() {
        return PathUtils.isNewer(this.f$0.toPath(), (ChronoZonedDateTime<?>) this.f$1, new LinkOption[0]);
    }
}
