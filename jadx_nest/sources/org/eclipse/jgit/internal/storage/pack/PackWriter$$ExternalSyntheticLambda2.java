package org.eclipse.jgit.internal.storage.pack;

import java.util.List;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class PackWriter$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ DeltaTask f$0;
    public final /* synthetic */ List f$1;

    public /* synthetic */ PackWriter$$ExternalSyntheticLambda2(DeltaTask deltaTask, List list) {
        this.f$0 = deltaTask;
        this.f$1 = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PackWriter.lambda$2(this.f$0, this.f$1);
    }
}
