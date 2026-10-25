package org.apache.commons.io.monitor;

import java.util.function.Predicate;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class FileAlterationMonitor$$ExternalSyntheticLambda0 implements Predicate {
    public final /* synthetic */ FileAlterationObserver f$0;

    public /* synthetic */ FileAlterationMonitor$$ExternalSyntheticLambda0(FileAlterationObserver fileAlterationObserver) {
        this.f$0 = fileAlterationObserver;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return this.f$0.equals((FileAlterationObserver) obj);
    }
}
