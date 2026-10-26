package org.apache.commons.io.monitor;

import java.util.function.Predicate;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class FileAlterationObserver$$ExternalSyntheticLambda0 implements Predicate {
    public final /* synthetic */ FileAlterationListener f$0;

    public /* synthetic */ FileAlterationObserver$$ExternalSyntheticLambda0(FileAlterationListener fileAlterationListener) {
        this.f$0 = fileAlterationListener;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return this.f$0.equals((FileAlterationListener) obj);
    }
}
