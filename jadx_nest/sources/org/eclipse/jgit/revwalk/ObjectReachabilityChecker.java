package org.eclipse.jgit.revwalk;

import java.io.IOException;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

/* INFO: loaded from: classes5.dex */
public interface ObjectReachabilityChecker {
    Optional<RevObject> areAllReachable(Collection<RevObject> collection, Stream<RevObject> stream) throws IOException;
}
