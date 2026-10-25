package org.apache.commons.io;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import org.apache.commons.io.function.IOSupplier;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class FileUtils$$ExternalSyntheticLambda0 implements IOSupplier {
    public final /* synthetic */ File f$0;

    public /* synthetic */ FileUtils$$ExternalSyntheticLambda0(File file) {
        this.f$0 = file;
    }

    @Override // org.apache.commons.io.function.IOSupplier
    public final Object get() {
        return Files.newInputStream(this.f$0.toPath(), new OpenOption[0]);
    }
}
