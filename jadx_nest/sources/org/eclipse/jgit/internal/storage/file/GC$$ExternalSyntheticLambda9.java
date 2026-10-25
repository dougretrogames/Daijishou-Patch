package org.eclipse.jgit.internal.storage.file;

import java.nio.file.Path;
import java.time.Instant;
import java.util.function.Predicate;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class GC$$ExternalSyntheticLambda9 implements Predicate {
    public final /* synthetic */ GC f$0;
    public final /* synthetic */ Instant f$1;

    public /* synthetic */ GC$$ExternalSyntheticLambda9(GC gc, Instant instant) {
        this.f$0 = gc;
        this.f$1 = instant;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return this.f$0.m5697lambda$5$orgeclipsejgitinternalstoragefileGC(this.f$1, (Path) obj);
    }
}
