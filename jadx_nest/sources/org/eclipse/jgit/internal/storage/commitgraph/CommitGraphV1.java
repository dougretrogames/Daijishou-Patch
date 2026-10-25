package org.eclipse.jgit.internal.storage.commitgraph;

import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.ObjectId;

/* JADX INFO: loaded from: classes5.dex */
class CommitGraphV1 implements CommitGraph {
    private final GraphCommitData commitData;
    private final GraphChangedPathFilterData cpfData;
    private final GraphObjectIndex idx;

    CommitGraphV1(GraphObjectIndex graphObjectIndex, GraphCommitData graphCommitData, GraphChangedPathFilterData graphChangedPathFilterData) {
        this.idx = graphObjectIndex;
        this.commitData = graphCommitData;
        this.cpfData = graphChangedPathFilterData;
    }

    @Override // org.eclipse.jgit.internal.storage.commitgraph.CommitGraph
    public int findGraphPosition(AnyObjectId anyObjectId) {
        return this.idx.findGraphPosition(anyObjectId);
    }

    @Override // org.eclipse.jgit.internal.storage.commitgraph.CommitGraph
    public CommitGraph.CommitData getCommitData(int i) {
        if (i < 0 || i >= getCommitCnt()) {
            return null;
        }
        return this.commitData.getCommitData(i);
    }

    @Override // org.eclipse.jgit.internal.storage.commitgraph.CommitGraph
    public ObjectId getObjectId(int i) {
        return this.idx.getObjectId(i);
    }

    @Override // org.eclipse.jgit.internal.storage.commitgraph.CommitGraph
    public ChangedPathFilter getChangedPathFilter(int i) {
        return this.cpfData.getChangedPathFilter(i);
    }

    @Override // org.eclipse.jgit.internal.storage.commitgraph.CommitGraph
    public long getCommitCnt() {
        return this.idx.getCommitCnt();
    }
}
