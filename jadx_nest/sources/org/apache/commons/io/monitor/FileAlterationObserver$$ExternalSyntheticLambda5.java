package org.apache.commons.io.monitor;

import java.util.function.Consumer;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class FileAlterationObserver$$ExternalSyntheticLambda5 implements Consumer {
    public final /* synthetic */ FileAlterationObserver f$0;

    public /* synthetic */ FileAlterationObserver$$ExternalSyntheticLambda5(FileAlterationObserver fileAlterationObserver) {
        this.f$0 = fileAlterationObserver;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        this.f$0.fireOnCreate((FileEntry) obj);
    }
}
