package org.apache.commons.io.monitor;

import java.util.function.Consumer;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class FileAlterationObserver$$ExternalSyntheticLambda4 implements Consumer {
    public final /* synthetic */ FileEntry f$0;

    public /* synthetic */ FileAlterationObserver$$ExternalSyntheticLambda4(FileEntry fileEntry) {
        this.f$0 = fileEntry;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        FileAlterationObserver.lambda$fireOnCreate$3(this.f$0, (FileAlterationListener) obj);
    }
}
