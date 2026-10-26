package org.eclipse.jgit.internal.transport.connectivity;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectIdSubclassMap;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.revwalk.ObjectWalk;
import org.eclipse.jgit.revwalk.RevBlob;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevFlag;
import org.eclipse.jgit.revwalk.RevObject;
import org.eclipse.jgit.revwalk.RevSort;
import org.eclipse.jgit.revwalk.RevTree;
import org.eclipse.jgit.transport.ConnectivityChecker;
import org.eclipse.jgit.transport.ReceiveCommand;

/* INFO: loaded from: classes5.dex */
public final class FullConnectivityChecker implements ConnectivityChecker {
    @Override // org.eclipse.jgit.transport.ConnectivityChecker
    public void checkConnectivity(ConnectivityChecker.ConnectivityCheckInfo connectivityCheckInfo, Set<ObjectId> set, ProgressMonitor progressMonitor) throws IOException {
        progressMonitor.beginTask(JGitText.get().countingObjects, 0);
        Throwable th = null;
        try {
            ObjectWalk objectWalk = new ObjectWalk(connectivityCheckInfo.getRepository());
            try {
                if (markStartAndKnownNodes(connectivityCheckInfo, objectWalk, set, progressMonitor)) {
                    checkCommitTree(connectivityCheckInfo, objectWalk, progressMonitor);
                    checkObjects(connectivityCheckInfo, objectWalk, progressMonitor);
                    objectWalk.close();
                    progressMonitor.endTask();
                    return;
                }
                objectWalk.close();
                progressMonitor.endTask();
            } catch (Throwable th2) {
                objectWalk.close();
                throw th2;
            }
        } catch (Throwable th3) {
            if (0 == 0) {
                throw th3;
            }
            if (null != th3) {
                try {
                    th.addSuppressed(th3);
                } catch (Throwable th4) {
                    progressMonitor.endTask();
                    throw th4;
                }
            }
            throw null;
        }
    }

    private boolean markStartAndKnownNodes(ConnectivityChecker.ConnectivityCheckInfo connectivityCheckInfo, ObjectWalk objectWalk, Set<ObjectId> set, ProgressMonitor progressMonitor) throws IOException {
        boolean z = connectivityCheckInfo.isCheckObjects() && !connectivityCheckInfo.getParser().getBaseObjectIds().isEmpty();
        if (connectivityCheckInfo.isCheckObjects()) {
            objectWalk.sort(RevSort.TOPO);
            if (!connectivityCheckInfo.getParser().getBaseObjectIds().isEmpty()) {
                objectWalk.sort(RevSort.BOUNDARY, true);
            }
        }
        boolean z2 = false;
        for (ReceiveCommand receiveCommand : connectivityCheckInfo.getCommands()) {
            if (receiveCommand.getResult() == ReceiveCommand.Result.NOT_ATTEMPTED && receiveCommand.getType() != ReceiveCommand.Type.DELETE && !set.contains(receiveCommand.getNewId())) {
                objectWalk.markStart(objectWalk.parseAny(receiveCommand.getNewId()));
                progressMonitor.update(1);
                z2 = true;
            }
        }
        if (!z2) {
            return false;
        }
        Iterator<ObjectId> it = set.iterator();
        while (it.hasNext()) {
            RevObject any = objectWalk.parseAny(it.next());
            objectWalk.markUninteresting(any);
            progressMonitor.update(1);
            if (z) {
                RevObject revObjectPeel = objectWalk.peel(any);
                if (revObjectPeel instanceof RevCommit) {
                    revObjectPeel = ((RevCommit) revObjectPeel).getTree();
                }
                if (revObjectPeel instanceof RevTree) {
                    objectWalk.markUninteresting(revObjectPeel);
                }
            }
        }
        return true;
    }

    private void checkCommitTree(ConnectivityChecker.ConnectivityCheckInfo connectivityCheckInfo, ObjectWalk objectWalk, ProgressMonitor progressMonitor) throws IOException {
        ObjectIdSubclassMap<ObjectId> newObjectIds = connectivityCheckInfo.getParser().getNewObjectIds();
        while (true) {
            RevCommit next = objectWalk.next();
            if (next == null) {
                return;
            }
            progressMonitor.update(1);
            if (connectivityCheckInfo.isCheckObjects() && !next.has(RevFlag.UNINTERESTING) && !newObjectIds.contains(next)) {
                throw new MissingObjectException(next, "commit");
            }
        }
    }

    private void checkObjects(ConnectivityChecker.ConnectivityCheckInfo connectivityCheckInfo, ObjectWalk objectWalk, ProgressMonitor progressMonitor) throws IOException {
        ObjectIdSubclassMap<ObjectId> newObjectIds = connectivityCheckInfo.getParser().getNewObjectIds();
        while (true) {
            RevObject revObjectNextObject = objectWalk.nextObject();
            if (revObjectNextObject != null) {
                progressMonitor.update(1);
                if (!revObjectNextObject.has(RevFlag.UNINTERESTING)) {
                    if (connectivityCheckInfo.isCheckObjects()) {
                        if (!newObjectIds.contains(revObjectNextObject)) {
                            throw new MissingObjectException(revObjectNextObject, revObjectNextObject.getType());
                        }
                    } else if ((revObjectNextObject instanceof RevBlob) && !connectivityCheckInfo.getRepository().getObjectDatabase().has(revObjectNextObject)) {
                        throw new MissingObjectException(revObjectNextObject, Constants.TYPE_BLOB);
                    }
                }
            } else {
                if (connectivityCheckInfo.isCheckObjects()) {
                    Iterator<V> it = connectivityCheckInfo.getParser().getBaseObjectIds().iterator();
                    while (it.hasNext()) {
                        RevObject any = objectWalk.parseAny((ObjectId) it.next());
                        if (!any.has(RevFlag.UNINTERESTING)) {
                            throw new MissingObjectException(any, any.getType());
                        }
                    }
                    return;
                }
                return;
            }
        }
    }
}
