package org.eclipse.jgit.merge;

import org.eclipse.jgit.lib.Repository;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ThreeWayMergeStrategy extends MergeStrategy {
    @Override // org.eclipse.jgit.merge.MergeStrategy
    public abstract ThreeWayMerger newMerger(Repository repository);

    @Override // org.eclipse.jgit.merge.MergeStrategy
    public abstract ThreeWayMerger newMerger(Repository repository, boolean z);
}
