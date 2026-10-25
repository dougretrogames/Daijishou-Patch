package org.eclipse.jgit.internal.transport.connectivity;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevObject;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.transport.ConnectivityChecker;
import org.eclipse.jgit.transport.ReceiveCommand;

/* JADX INFO: loaded from: classes5.dex */
public class IterativeConnectivityChecker implements ConnectivityChecker {
    private static final int MAXIMUM_PARENTS_TO_CHECK = 128;
    private final ConnectivityChecker delegate;
    private Set<ObjectId> forcedHaves = Collections.emptySet();

    public IterativeConnectivityChecker(ConnectivityChecker connectivityChecker) {
        this.delegate = connectivityChecker;
    }

    @Override // org.eclipse.jgit.transport.ConnectivityChecker
    public void checkConnectivity(ConnectivityChecker.ConnectivityCheckInfo connectivityCheckInfo, Set<ObjectId> set, ProgressMonitor progressMonitor) throws IOException {
        try {
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            getAllObjectIds(connectivityCheckInfo.getCommands()).forEach(new IterativeConnectivityChecker$$ExternalSyntheticLambda0(set, hashSet2, hashSet));
            if (!hashSet.isEmpty()) {
                hashSet2.addAll(extractAdvertisedParentCommits(hashSet, set, connectivityCheckInfo.getWalk()));
            }
            hashSet2.addAll(this.forcedHaves);
            if (!hashSet2.isEmpty()) {
                this.delegate.checkConnectivity(connectivityCheckInfo, hashSet2, progressMonitor);
                return;
            }
        } catch (MissingObjectException unused) {
        }
        this.delegate.checkConnectivity(connectivityCheckInfo, set, progressMonitor);
    }

    static /* synthetic */ void lambda$0(Set set, Set set2, Set set3, ObjectId objectId) {
        if (set.contains(objectId)) {
            set2.add(objectId);
        } else {
            set3.add(objectId);
        }
    }

    private static Stream<ObjectId> getAllObjectIds(List<ReceiveCommand> list) {
        return list.stream().flatMap(new IterativeConnectivityChecker$$ExternalSyntheticLambda1());
    }

    static /* synthetic */ Stream lambda$1(ReceiveCommand receiveCommand) {
        if (receiveCommand.getType() == ReceiveCommand.Type.UPDATE || receiveCommand.getType() == ReceiveCommand.Type.UPDATE_NONFASTFORWARD) {
            return Stream.of((Object[]) new ObjectId[]{receiveCommand.getOldId(), receiveCommand.getNewId()});
        }
        if (receiveCommand.getType() == ReceiveCommand.Type.CREATE) {
            return Stream.of(receiveCommand.getNewId());
        }
        return Stream.of((Object[]) new ObjectId[0]);
    }

    public void setForcedHaves(Set<ObjectId> set) {
        this.forcedHaves = Collections.unmodifiableSet(set);
    }

    private static Set<ObjectId> extractAdvertisedParentCommits(Set<ObjectId> set, Set<ObjectId> set2, RevWalk revWalk) throws IOException {
        HashSet hashSet = new HashSet();
        Iterator<ObjectId> it = set.iterator();
        while (it.hasNext()) {
            RevObject any = revWalk.parseAny(it.next());
            if (any instanceof RevCommit) {
                ArrayDeque arrayDeque = new ArrayDeque(128);
                arrayDeque.addAll(parseParents(((RevCommit) any).getParents(), revWalk));
                int length = 0;
                while (!arrayDeque.isEmpty()) {
                    RevCommit revCommit = (RevCommit) arrayDeque.poll();
                    if (set2.contains(revCommit.getId())) {
                        hashSet.add(revCommit.getId());
                    } else if (length < 128) {
                        RevCommit[] parents = revCommit.getParents();
                        length += parents.length;
                        arrayDeque.addAll(parseParents(parents, revWalk));
                    }
                }
            }
        }
        return hashSet;
    }

    private static List<RevCommit> parseParents(RevCommit[] revCommitArr, RevWalk revWalk) {
        return (List) Arrays.stream(revCommitArr).map(new IterativeConnectivityChecker$$ExternalSyntheticLambda2(revWalk)).collect(Collectors.toList());
    }

    static /* synthetic */ RevCommit lambda$2(RevWalk revWalk, RevCommit revCommit) {
        try {
            return revWalk.parseCommit(revCommit);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
