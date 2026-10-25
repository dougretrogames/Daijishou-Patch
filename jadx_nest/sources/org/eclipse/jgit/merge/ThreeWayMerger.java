package org.eclipse.jgit.merge;

import java.io.IOException;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectInserter;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevTree;
import org.eclipse.jgit.treewalk.AbstractTreeIterator;
import org.eclipse.jgit.treewalk.EmptyTreeIterator;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ThreeWayMerger extends Merger {
    private ObjectId baseCommitId;
    private RevTree baseTree;

    protected ThreeWayMerger(Repository repository) {
        super(repository);
    }

    protected ThreeWayMerger(Repository repository, boolean z) {
        this(repository);
    }

    protected ThreeWayMerger(ObjectInserter objectInserter) {
        super(objectInserter);
    }

    public void setBase(AnyObjectId anyObjectId) throws IOException {
        if (anyObjectId != null) {
            this.baseTree = this.walk.parseTree(anyObjectId);
        } else {
            this.baseTree = null;
        }
    }

    @Override // org.eclipse.jgit.merge.Merger
    public boolean merge(AnyObjectId... anyObjectIdArr) throws IOException {
        if (anyObjectIdArr.length != 2) {
            return false;
        }
        return super.merge(anyObjectIdArr);
    }

    @Override // org.eclipse.jgit.merge.Merger
    public ObjectId getBaseCommitId() {
        return this.baseCommitId;
    }

    protected AbstractTreeIterator mergeBase() throws IOException {
        RevTree revTree = this.baseTree;
        if (revTree != null) {
            return openTree(revTree);
        }
        RevCommit commit = this.baseCommitId != null ? this.walk.parseCommit(this.baseCommitId) : getBaseCommit(this.sourceCommits[0], this.sourceCommits[1]);
        if (commit == null) {
            this.baseCommitId = null;
            return new EmptyTreeIterator();
        }
        this.baseCommitId = commit.toObjectId();
        return openTree(commit.getTree());
    }
}
