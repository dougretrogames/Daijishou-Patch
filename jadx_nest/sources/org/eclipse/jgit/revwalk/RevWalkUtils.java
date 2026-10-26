package org.eclipse.jgit.revwalk;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.NullProgressMonitor;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.lib.Ref;

/* INFO: loaded from: classes5.dex */
public final class RevWalkUtils {
    private RevWalkUtils() {
    }

    public static int count(RevWalk revWalk, RevCommit revCommit, RevCommit revCommit2) throws IOException {
        return find(revWalk, revCommit, revCommit2).size();
    }

    public static List<RevCommit> find(RevWalk revWalk, RevCommit revCommit, RevCommit revCommit2) throws IOException {
        revWalk.reset();
        revWalk.markStart(revCommit);
        if (revCommit2 != null) {
            revWalk.markUninteresting(revCommit2);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<RevCommit> it = revWalk.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public static List<Ref> findBranchesReachableFrom(RevCommit revCommit, RevWalk revWalk, Collection<Ref> collection) throws IOException {
        return findBranchesReachableFrom(revCommit, revWalk, collection, NullProgressMonitor.INSTANCE);
    }

    public static List<Ref> findBranchesReachableFrom(RevCommit revCommit, RevWalk revWalk, Collection<Ref> collection, ProgressMonitor progressMonitor) throws IOException {
        RevCommit commit = revWalk.parseCommit(revCommit.getId());
        revWalk.reset();
        ArrayList arrayList = new ArrayList();
        progressMonitor.beginTask(JGitText.get().searchForReachableBranches, collection.size());
        for (Ref ref : collection) {
            RevObject any = revWalk.parseAny(ref.getObjectId());
            if ((any instanceof RevCommit) && ((RevCommit) any).getCommitTime() + 86400 >= commit.getCommitTime()) {
                arrayList.add(ref);
            }
        }
        List<Ref> mergedInto = revWalk.getMergedInto(commit, arrayList, progressMonitor);
        progressMonitor.endTask();
        return mergedInto;
    }
}
