package org.eclipse.jgit.util;

import java.nio.file.FileStore;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class FS$FileStoreAttributes$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ FileStore f$0;
    public final /* synthetic */ FS.FileStoreAttributes f$1;

    public /* synthetic */ FS$FileStoreAttributes$$ExternalSyntheticLambda1(FileStore fileStore, FS.FileStoreAttributes fileStoreAttributes) {
        this.f$0 = fileStore;
        this.f$1 = fileStoreAttributes;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FS.FileStoreAttributes.saveToConfig(this.f$0, this.f$1);
    }
}
