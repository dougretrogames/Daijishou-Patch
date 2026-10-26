package org.eclipse.jgit.internal.revwalk;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;
import java.util.stream.Stream;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.revwalk.ObjectReachabilityChecker;
import org.eclipse.jgit.revwalk.ObjectWalk;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevObject;
import org.eclipse.jgit.revwalk.RevSort;

/* INFO: loaded from: classes5.dex */
public class PedestrianObjectReachabilityChecker implements ObjectReachabilityChecker {
    private final ObjectWalk walk;

    public PedestrianObjectReachabilityChecker(ObjectWalk objectWalk) {
        this.walk = objectWalk;
    }

    @Override // org.eclipse.jgit.revwalk.ObjectReachabilityChecker
    public Optional<RevObject> areAllReachable(Collection<RevObject> collection, Stream<RevObject> stream) throws IOException {
        try {
            this.walk.reset();
            this.walk.sort(RevSort.TOPO);
            Iterator<RevObject> it = collection.iterator();
            while (it.hasNext()) {
                this.walk.markStart(it.next());
            }
            for (RevObject revObject : stream) {
                this.walk.markUninteresting(revObject);
                RevObject revObjectPeel = this.walk.peel(revObject);
                if (revObjectPeel instanceof RevCommit) {
                    this.walk.markUninteresting(((RevCommit) revObjectPeel).getTree());
                }
            }
            RevCommit next = this.walk.next();
            if (next != null) {
                return Optional.of(next);
            }
            RevObject revObjectNextObject = this.walk.nextObject();
            if (revObjectNextObject != null) {
                return Optional.of(revObjectNextObject);
            }
            return Optional.empty();
        } catch (InvalidObjectException | MissingObjectException e) {
            throw new IllegalStateException(e);
        }
    }
}
