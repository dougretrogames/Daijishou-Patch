package org.eclipse.jgit.revwalk;

import java.util.function.Predicate;
import org.eclipse.jgit.internal.storage.commitgraph.ChangedPathFilter;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class TreeRevFilter$$ExternalSyntheticLambda0 implements Predicate {
    public final /* synthetic */ ChangedPathFilter f$0;

    public /* synthetic */ TreeRevFilter$$ExternalSyntheticLambda0(ChangedPathFilter changedPathFilter) {
        this.f$0 = changedPathFilter;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return this.f$0.maybeContains((byte[]) obj);
    }
}
