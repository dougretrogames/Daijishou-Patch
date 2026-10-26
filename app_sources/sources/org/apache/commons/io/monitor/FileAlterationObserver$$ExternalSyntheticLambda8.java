package org.apache.commons.io.monitor;

import java.util.function.Consumer;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class FileAlterationObserver$$ExternalSyntheticLambda8 implements Consumer {
    public final /* synthetic */ FileEntry f$0;

    public /* synthetic */ FileAlterationObserver$$ExternalSyntheticLambda8(FileEntry fileEntry) {
        this.f$0 = fileEntry;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        FileAlterationObserver.lambda$fireOnDelete$4(this.f$0, (FileAlterationListener) obj);
    }
}
