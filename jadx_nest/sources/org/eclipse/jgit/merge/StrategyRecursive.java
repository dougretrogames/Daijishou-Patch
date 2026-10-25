package org.eclipse.jgit.merge;

import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.lib.ObjectInserter;
import org.eclipse.jgit.lib.Repository;

/* JADX INFO: loaded from: classes5.dex */
public class StrategyRecursive extends StrategyResolve {
    @Override // org.eclipse.jgit.merge.StrategyResolve, org.eclipse.jgit.merge.ThreeWayMergeStrategy, org.eclipse.jgit.merge.MergeStrategy
    public ThreeWayMerger newMerger(Repository repository) {
        return new RecursiveMerger(repository, false);
    }

    @Override // org.eclipse.jgit.merge.StrategyResolve, org.eclipse.jgit.merge.ThreeWayMergeStrategy, org.eclipse.jgit.merge.MergeStrategy
    public ThreeWayMerger newMerger(Repository repository, boolean z) {
        return new RecursiveMerger(repository, z);
    }

    @Override // org.eclipse.jgit.merge.StrategyResolve, org.eclipse.jgit.merge.MergeStrategy
    public ThreeWayMerger newMerger(ObjectInserter objectInserter, Config config) {
        return new RecursiveMerger(objectInserter, config);
    }

    @Override // org.eclipse.jgit.merge.StrategyResolve, org.eclipse.jgit.merge.MergeStrategy
    public String getName() {
        return "recursive";
    }
}
