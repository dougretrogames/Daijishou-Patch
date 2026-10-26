package org.eclipse.jgit.revwalk;

import java.io.IOException;
import org.eclipse.jgit.internal.storage.commitgraph.ChangedPathFilter;
import org.eclipse.jgit.internal.storage.commitgraph.CommitGraph;
import org.eclipse.jgit.lib.AnyObjectId;

/* INFO: loaded from: classes5.dex */
class RevCommitCG extends RevCommit {
    private int generation;
    private final int graphPosition;

    protected RevCommitCG(AnyObjectId anyObjectId, int i) {
        super(anyObjectId);
        this.generation = Integer.MAX_VALUE;
        this.graphPosition = i;
    }

    @Override // org.eclipse.jgit.revwalk.RevCommit
    void parseCanonical(RevWalk revWalk, byte[] bArr) throws IOException {
        if (revWalk.isRetainBody()) {
            this.buffer = bArr;
        }
        parseInGraph(revWalk);
    }

    @Override // org.eclipse.jgit.revwalk.RevCommit, org.eclipse.jgit.revwalk.RevObject
    void parseHeaders(RevWalk revWalk) throws IOException {
        if (revWalk.isRetainBody()) {
            super.parseBody(revWalk);
        } else {
            parseInGraph(revWalk);
        }
    }

    private void parseInGraph(RevWalk revWalk) throws IOException {
        CommitGraph commitGraph = revWalk.commitGraph();
        CommitGraph.CommitData commitData = commitGraph.getCommitData(this.graphPosition);
        if (commitData == null) {
            throw new IllegalStateException();
        }
        if (!revWalk.shallowCommitsInitialized) {
            revWalk.initializeShallowCommits(this);
        }
        this.tree = revWalk.lookupTree(commitData.getTree());
        this.commitTime = (int) commitData.getCommitTime();
        this.generation = commitData.getGeneration();
        if (getParents() == null) {
            int[] parents = commitData.getParents();
            if (parents.length == 0) {
                this.parents = RevCommit.NO_PARENTS;
            } else {
                int length = parents.length;
                RevCommit[] revCommitArr = new RevCommit[length];
                for (int i = 0; i < length; i++) {
                    int i2 = parents[i];
                    revCommitArr[i] = revWalk.lookupCommit(commitGraph.getObjectId(i2), i2);
                }
                this.parents = revCommitArr;
            }
        }
        this.flags |= 1;
    }

    @Override // org.eclipse.jgit.revwalk.RevCommit
    int getGeneration() {
        return this.generation;
    }

    @Override // org.eclipse.jgit.revwalk.RevCommit
    public ChangedPathFilter getChangedPathFilter(RevWalk revWalk) {
        return revWalk.commitGraph().getChangedPathFilter(this.graphPosition);
    }
}
