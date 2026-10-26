package org.eclipse.jgit.revwalk;

import java.util.function.Predicate;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class DateRevPriorityQueue$$ExternalSyntheticLambda1 implements Predicate {
    public final /* synthetic */ int f$0;

    public /* synthetic */ DateRevPriorityQueue$$ExternalSyntheticLambda1(int i) {
        this.f$0 = i;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return DateRevPriorityQueue.lambda$3(this.f$0, (RevCommit) obj);
    }
}
