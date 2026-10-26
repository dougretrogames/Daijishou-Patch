package org.eclipse.jgit.util;

import java.nio.file.FileStore;
import java.nio.file.Path;
import java.util.function.Supplier;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class FS$FileStoreAttributes$$ExternalSyntheticLambda2 implements Supplier {
    public final /* synthetic */ FileStore f$0;
    public final /* synthetic */ Path f$1;

    public /* synthetic */ FS$FileStoreAttributes$$ExternalSyntheticLambda2(FileStore fileStore, Path path) {
        this.f$0 = fileStore;
        this.f$1 = path;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return FS.FileStoreAttributes.lambda$2(this.f$0, this.f$1);
    }
}
