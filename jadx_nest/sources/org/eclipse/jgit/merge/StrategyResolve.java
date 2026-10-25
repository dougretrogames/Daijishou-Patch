package org.eclipse.jgit.merge;

import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.lib.ObjectInserter;
import org.eclipse.jgit.lib.Repository;

/* JADX INFO: loaded from: classes5.dex */
public class StrategyResolve extends ThreeWayMergeStrategy {
    @Override // org.eclipse.jgit.merge.ThreeWayMergeStrategy, org.eclipse.jgit.merge.MergeStrategy
    public ThreeWayMerger newMerger(Repository repository) {
        return new ResolveMerger(repository, false);
    }

    @Override // org.eclipse.jgit.merge.ThreeWayMergeStrategy, org.eclipse.jgit.merge.MergeStrategy
    public ThreeWayMerger newMerger(Repository repository, boolean z) {
        return new ResolveMerger(repository, z);
    }

    @Override // org.eclipse.jgit.merge.MergeStrategy
    public ThreeWayMerger newMerger(ObjectInserter objectInserter, Config config) {
        return new ResolveMerger(objectInserter, config);
    }

    @Override // org.eclipse.jgit.merge.MergeStrategy
    public String getName() {
        return "resolve";
    }
}
