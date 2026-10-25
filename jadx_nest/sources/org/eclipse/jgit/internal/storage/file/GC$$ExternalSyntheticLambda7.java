package org.eclipse.jgit.internal.storage.file;

import java.util.Set;
import java.util.function.Predicate;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class GC$$ExternalSyntheticLambda7 implements Predicate {
    public final /* synthetic */ Set f$0;

    public /* synthetic */ GC$$ExternalSyntheticLambda7(Set set) {
        this.f$0 = set;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return GC.lambda$12(this.f$0, (PackFile) obj);
    }
}
