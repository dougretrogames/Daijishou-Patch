package org.eclipse.jgit.internal.revwalk;

import java.util.function.Predicate;
import org.eclipse.jgit.revwalk.RevCommit;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class BitmappedReachabilityChecker$$ExternalSyntheticLambda0 implements Predicate {
    public final /* synthetic */ BitmappedReachabilityChecker.ReachedFilter f$0;

    public /* synthetic */ BitmappedReachabilityChecker$$ExternalSyntheticLambda0(BitmappedReachabilityChecker.ReachedFilter reachedFilter) {
        this.f$0 = reachedFilter;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return this.f$0.isReachable((RevCommit) obj);
    }
}
