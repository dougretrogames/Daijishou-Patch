package org.eclipse.jgit.merge;

import java.io.IOException;
import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectInserter;
import org.eclipse.jgit.lib.Repository;

/* INFO: loaded from: classes5.dex */
public class StrategyOneSided extends MergeStrategy {
    private final String strategyName;
    private final int treeIndex;

    protected StrategyOneSided(String str, int i) {
        this.strategyName = str;
        this.treeIndex = i;
    }

    @Override // org.eclipse.jgit.merge.MergeStrategy
    public String getName() {
        return this.strategyName;
    }

    @Override // org.eclipse.jgit.merge.MergeStrategy
    public Merger newMerger(Repository repository) {
        return new OneSide(repository, this.treeIndex);
    }

    @Override // org.eclipse.jgit.merge.MergeStrategy
    public Merger newMerger(Repository repository, boolean z) {
        return new OneSide(repository, this.treeIndex);
    }

    @Override // org.eclipse.jgit.merge.MergeStrategy
    public Merger newMerger(ObjectInserter objectInserter, Config config) {
        return new OneSide(objectInserter, this.treeIndex);
    }

    static class OneSide extends Merger {
        private final int treeIndex;

        @Override // org.eclipse.jgit.merge.Merger
        public ObjectId getBaseCommitId() {
            return null;
        }

        protected OneSide(Repository repository, int i) {
            super(repository);
            this.treeIndex = i;
        }

        protected OneSide(ObjectInserter objectInserter, int i) {
            super(objectInserter);
            this.treeIndex = i;
        }

        @Override // org.eclipse.jgit.merge.Merger
        protected boolean mergeImpl() throws IOException {
            return this.treeIndex < this.sourceTrees.length;
        }

        @Override // org.eclipse.jgit.merge.Merger
        public ObjectId getResultTreeId() {
            return this.sourceTrees[this.treeIndex];
        }
    }
}
