package org.eclipse.jgit.internal.storage.commitgraph;

import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.ObjectId;

/* INFO: loaded from: classes5.dex */
public interface CommitGraph {
    public static final CommitGraph EMPTY = new AnonymousClass1();

    public interface CommitData {
        long getCommitTime();

        int getGeneration();

        int[] getParents();

        ObjectId getTree();
    }

    int findGraphPosition(AnyObjectId anyObjectId);

    ChangedPathFilter getChangedPathFilter(int i);

    long getCommitCnt();

    CommitData getCommitData(int i);

    ObjectId getObjectId(int i);

    /* INFO: renamed from: org.eclipse.jgit.internal.storage.commitgraph.CommitGraph$1, reason: invalid class name */
    class AnonymousClass1 implements CommitGraph {
        @Override // org.eclipse.jgit.internal.storage.commitgraph.CommitGraph
        public int findGraphPosition(AnyObjectId anyObjectId) {
            return -1;
        }

        @Override // org.eclipse.jgit.internal.storage.commitgraph.CommitGraph
        public ChangedPathFilter getChangedPathFilter(int i) {
            return null;
        }

        @Override // org.eclipse.jgit.internal.storage.commitgraph.CommitGraph
        public long getCommitCnt() {
            return 0L;
        }

        @Override // org.eclipse.jgit.internal.storage.commitgraph.CommitGraph
        public CommitData getCommitData(int i) {
            return null;
        }

        @Override // org.eclipse.jgit.internal.storage.commitgraph.CommitGraph
        public ObjectId getObjectId(int i) {
            return null;
        }

        AnonymousClass1() {
        }
    }
}
