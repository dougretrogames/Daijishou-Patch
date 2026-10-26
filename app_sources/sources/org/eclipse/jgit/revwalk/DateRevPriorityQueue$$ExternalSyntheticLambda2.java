package org.eclipse.jgit.revwalk;

import java.util.function.ToIntFunction;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes5.dex */
public final /* synthetic */ class DateRevPriorityQueue$$ExternalSyntheticLambda2 implements ToIntFunction {
    @Override // java.util.function.ToIntFunction
    public final int applyAsInt(Object obj) {
        return ((DateRevPriorityQueue.RevCommitEntry) obj).getEntry().getCommitTime();
    }
}
