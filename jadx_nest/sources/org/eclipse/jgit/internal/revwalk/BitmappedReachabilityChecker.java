package org.eclipse.jgit.internal.revwalk;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;
import java.util.stream.Stream;
import org.eclipse.jgit.lib.BitmapIndex;
import org.eclipse.jgit.revwalk.ReachabilityChecker;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevFlag;
import org.eclipse.jgit.revwalk.RevSort;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.revwalk.filter.RevFilter;

/* INFO: loaded from: classes5.dex */
public class BitmappedReachabilityChecker implements ReachabilityChecker {
    private final RevWalk walk;

    public BitmappedReachabilityChecker(RevWalk revWalk) throws IOException {
        this.walk = revWalk;
        if (revWalk.getObjectReader().getBitmapIndex() == null) {
            throw new AssertionError("Trying to use bitmapped reachability check on a repository without bitmaps");
        }
    }

    @Override // org.eclipse.jgit.revwalk.ReachabilityChecker
    public Optional<RevCommit> areAllReachable(Collection<RevCommit> collection, Stream<RevCommit> stream) throws IOException {
        ArrayList arrayList = new ArrayList(collection);
        this.walk.reset();
        this.walk.sort(RevSort.TOPO);
        ReachedFilter reachedFilter = new ReachedFilter(this.walk.getObjectReader().getBitmapIndex());
        this.walk.setRevFilter(reachedFilter);
        Iterator<RevCommit> it = stream.iterator();
        while (it.hasNext()) {
            this.walk.markStart(it.next());
            while (this.walk.next() != null) {
                arrayList.removeIf(new BitmappedReachabilityChecker$$ExternalSyntheticLambda0(reachedFilter));
                if (arrayList.isEmpty()) {
                    return Optional.empty();
                }
            }
            this.walk.reset();
        }
        return Optional.of((RevCommit) arrayList.get(0));
    }

    /* INFO: Access modifiers changed from: private */
    static class ReachedFilter extends RevFilter {
        private final BitmapIndex.BitmapBuilder reached;
        private final BitmapIndex repoBitmaps;

        @Override // org.eclipse.jgit.revwalk.filter.RevFilter
        public final boolean requiresCommitBody() {
            return false;
        }

        public ReachedFilter(BitmapIndex bitmapIndex) {
            this.repoBitmaps = bitmapIndex;
            this.reached = bitmapIndex.newBitmapBuilder();
        }

        @Override // org.eclipse.jgit.revwalk.filter.RevFilter
        public final boolean include(RevWalk revWalk, RevCommit revCommit) {
            if (this.reached.contains(revCommit)) {
                dontFollow(revCommit);
                return false;
            }
            BitmapIndex.Bitmap bitmap = this.repoBitmaps.getBitmap(revCommit);
            if (bitmap != null) {
                this.reached.or(bitmap);
                dontFollow(revCommit);
                return true;
            }
            this.reached.addObject(revCommit, 1);
            return true;
        }

        private static final void dontFollow(RevCommit revCommit) {
            for (RevCommit revCommit2 : revCommit.getParents()) {
                revCommit2.add(RevFlag.SEEN);
            }
        }

        @Override // org.eclipse.jgit.revwalk.filter.RevFilter
        public final RevFilter clone() {
            throw new UnsupportedOperationException();
        }

        boolean isReachable(RevCommit revCommit) {
            return this.reached.contains(revCommit);
        }
    }
}
