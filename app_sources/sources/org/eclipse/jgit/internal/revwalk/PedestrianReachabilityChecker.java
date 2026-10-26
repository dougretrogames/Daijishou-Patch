package org.eclipse.jgit.internal.revwalk;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;
import java.util.stream.Stream;
import org.eclipse.jgit.revwalk.ReachabilityChecker;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevSort;
import org.eclipse.jgit.revwalk.RevWalk;

/* INFO: loaded from: classes5.dex */
public class PedestrianReachabilityChecker implements ReachabilityChecker {
    private final boolean topoSort;
    private final RevWalk walk;

    public PedestrianReachabilityChecker(boolean z, RevWalk revWalk) {
        this.topoSort = z;
        this.walk = revWalk;
    }

    @Override // org.eclipse.jgit.revwalk.ReachabilityChecker
    public Optional<RevCommit> areAllReachable(Collection<RevCommit> collection, Stream<RevCommit> stream) throws IOException {
        this.walk.reset();
        if (this.topoSort) {
            this.walk.sort(RevSort.TOPO);
        }
        Iterator<RevCommit> it = collection.iterator();
        while (it.hasNext()) {
            this.walk.markStart(it.next());
        }
        Iterator<RevCommit> it2 = stream.iterator();
        while (it2.hasNext()) {
            this.walk.markUninteresting(it2.next());
        }
        return Optional.ofNullable(this.walk.next());
    }
}
