package org.eclipse.jgit.revwalk;

import java.util.function.Predicate;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class DateRevPriorityQueue$$ExternalSyntheticLambda4 implements Predicate {
    public final /* synthetic */ int f$0;

    public /* synthetic */ DateRevPriorityQueue$$ExternalSyntheticLambda4(int i) {
        this.f$0 = i;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return DateRevPriorityQueue.lambda$5(this.f$0, (RevCommit) obj);
    }
}
