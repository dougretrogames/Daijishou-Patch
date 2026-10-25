package org.apache.commons.io;

import java.io.File;
import org.apache.commons.io.function.IOSupplier;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class FileUtils$$ExternalSyntheticLambda20 implements IOSupplier {
    public final /* synthetic */ File f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ String[] f$2;

    public /* synthetic */ FileUtils$$ExternalSyntheticLambda20(File file, boolean z, String[] strArr) {
        this.f$0 = file;
        this.f$1 = z;
        this.f$2 = strArr;
    }

    @Override // org.apache.commons.io.function.IOSupplier
    public final Object get() {
        return FileUtils.streamFiles(this.f$0, this.f$1, this.f$2);
    }
}
