package org.eclipse.jgit.internal.storage.commitgraph;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectIdOwnerMap;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevObject;
import org.eclipse.jgit.revwalk.RevSort;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.util.BlockList;

/* JADX INFO: loaded from: classes5.dex */
public class GraphCommits implements Iterable<RevCommit> {
    private final ObjectIdOwnerMap<CommitWithPosition> commitPosMap;
    private final int extraEdgeCnt;
    private final ObjectReader objectReader;
    private final List<RevCommit> sortedCommits;

    public static GraphCommits fromWalk(ProgressMonitor progressMonitor, Set<? extends ObjectId> set, RevWalk revWalk) throws IOException {
        revWalk.reset();
        revWalk.sort(RevSort.NONE);
        revWalk.setRetainBody(false);
        Iterator<? extends ObjectId> it = set.iterator();
        while (it.hasNext()) {
            RevObject any = revWalk.parseAny(it.next());
            if (any instanceof RevCommit) {
                revWalk.markStart((RevCommit) any);
            }
        }
        BlockList blockList = new BlockList();
        progressMonitor.beginTask(JGitText.get().findingCommitsForCommitGraph, 0);
        while (true) {
            RevCommit next = revWalk.next();
            if (next != null) {
                progressMonitor.update(1);
                blockList.add(next);
            } else {
                progressMonitor.endTask();
                return new GraphCommits(blockList, revWalk.getObjectReader());
            }
        }
    }

    private GraphCommits(List<RevCommit> list, ObjectReader objectReader) {
        Collections.sort(list);
        this.sortedCommits = list;
        this.commitPosMap = new ObjectIdOwnerMap<>();
        int parentCount = 0;
        for (int i = 0; i < list.size(); i++) {
            RevCommit revCommit = this.sortedCommits.get(i);
            if (revCommit.getParentCount() > 2) {
                parentCount += revCommit.getParentCount() - 1;
            }
            this.commitPosMap.add(new CommitWithPosition(revCommit, i));
        }
        this.extraEdgeCnt = parentCount;
        this.objectReader = objectReader;
    }

    int getOidPosition(RevCommit revCommit) throws MissingObjectException {
        CommitWithPosition commitWithPosition = (CommitWithPosition) this.commitPosMap.get(revCommit);
        if (commitWithPosition == null) {
            throw new MissingObjectException(revCommit, 1);
        }
        return commitWithPosition.position;
    }

    int getExtraEdgeCnt() {
        return this.extraEdgeCnt;
    }

    int size() {
        return this.sortedCommits.size();
    }

    ObjectReader getObjectReader() {
        return this.objectReader;
    }

    @Override // java.lang.Iterable
    public Iterator<RevCommit> iterator() {
        return this.sortedCommits.iterator();
    }

    private static class CommitWithPosition extends ObjectIdOwnerMap.Entry {
        final int position;

        CommitWithPosition(AnyObjectId anyObjectId, int i) {
            super(anyObjectId);
            this.position = i;
        }
    }
}
