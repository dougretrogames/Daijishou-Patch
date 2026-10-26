package org.eclipse.jgit.transport;

import java.io.IOException;
import java.io.OutputStream;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.api.errors.AbortedByHookException;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.errors.NotSupportedException;
import org.eclipse.jgit.errors.TransportException;
import org.eclipse.jgit.hooks.PrePushHook;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevObject;
import org.eclipse.jgit.revwalk.RevWalk;

/* INFO: loaded from: classes5.dex */
class PushProcess {
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$transport$RemoteRefUpdate$Status;
    static final String PROGRESS_OPENING_CONNECTION = JGitText.get().openingConnection;
    private PushConnection connection;
    private final OutputStream out;
    private final PrePushHook prePush;
    private List<String> pushOptions;
    private final Map<String, RemoteRefUpdate> toPush;
    private final Transport transport;
    private final RevWalk walker;

    static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$transport$RemoteRefUpdate$Status() {
        int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$transport$RemoteRefUpdate$Status;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[RemoteRefUpdate.Status.valuesCustom().length];
        try {
            iArr2[RemoteRefUpdate.Status.AWAITING_REPORT.ordinal()] = 8;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[RemoteRefUpdate.Status.NON_EXISTING.ordinal()] = 7;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[RemoteRefUpdate.Status.NOT_ATTEMPTED.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[RemoteRefUpdate.Status.OK.ordinal()] = 9;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[RemoteRefUpdate.Status.REJECTED_NODELETE.ordinal()] = 4;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[RemoteRefUpdate.Status.REJECTED_NONFASTFORWARD.ordinal()] = 3;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            iArr2[RemoteRefUpdate.Status.REJECTED_OTHER_REASON.ordinal()] = 6;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            iArr2[RemoteRefUpdate.Status.REJECTED_REMOTE_CHANGED.ordinal()] = 5;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            iArr2[RemoteRefUpdate.Status.UP_TO_DATE.ordinal()] = 2;
        } catch (NoSuchFieldError unused9) {
        }
        $SWITCH_TABLE$org$eclipse$jgit$transport$RemoteRefUpdate$Status = iArr2;
        return iArr2;
    }

    PushProcess(Transport transport, Collection<RemoteRefUpdate> collection, PrePushHook prePushHook) throws TransportException {
        this(transport, collection, prePushHook, null);
    }

    PushProcess(Transport transport, Collection<RemoteRefUpdate> collection, PrePushHook prePushHook, OutputStream outputStream) throws TransportException {
        this.walker = new RevWalk(transport.local);
        this.transport = transport;
        this.toPush = new LinkedHashMap();
        this.prePush = prePushHook;
        this.out = outputStream;
        this.pushOptions = transport.getPushOptions();
        for (RemoteRefUpdate remoteRefUpdate : collection) {
            if (this.toPush.put(remoteRefUpdate.getRemoteName(), remoteRefUpdate) != null) {
                throw new TransportException(MessageFormat.format(JGitText.get().duplicateRemoteRefUpdateIsIllegal, remoteRefUpdate.getRemoteName()));
            }
        }
    }

    PushResult execute(ProgressMonitor progressMonitor) throws NotSupportedException, TransportException {
        PrePushHook prePushHook;
        try {
            progressMonitor.beginTask(PROGRESS_OPENING_CONNECTION, 0);
            PushResult pushResult = new PushResult();
            this.connection = this.transport.openPush();
            try {
                pushResult.setAdvertisedRefs(this.transport.getURI(), this.connection.getRefsMap());
                pushResult.peerUserAgent = this.connection.getPeerUserAgent();
                progressMonitor.endTask();
                Map<String, RemoteRefUpdate> mapExpandMatching = expandMatching();
                this.toPush.clear();
                this.toPush.putAll(mapExpandMatching);
                pushResult.setRemoteUpdates(this.toPush);
                Map<String, RemoteRefUpdate> mapPrepareRemoteUpdates = prepareRemoteUpdates();
                List list = (List) mapPrepareRemoteUpdates.values().stream().filter(new PushProcess$$ExternalSyntheticLambda0()).collect(Collectors.toList());
                if (!list.isEmpty() && (prePushHook = this.prePush) != null) {
                    try {
                        prePushHook.setRefs(list);
                        this.prePush.setDryRun(this.transport.isDryRun());
                        this.prePush.call();
                    } catch (IOException | AbortedByHookException e) {
                        throw new TransportException(e.getMessage(), e);
                    }
                }
                if (this.transport.isDryRun()) {
                    modifyUpdatesForDryRun();
                } else if (!mapPrepareRemoteUpdates.isEmpty()) {
                    this.connection.push(progressMonitor, mapPrepareRemoteUpdates, this.out);
                }
                this.connection.close();
                pushResult.addMessages(this.connection.getMessages());
                if (!this.transport.isDryRun()) {
                    updateTrackingRefs();
                }
                Iterator<RemoteRefUpdate> it = this.toPush.values().iterator();
                while (it.hasNext()) {
                    TrackingRefUpdate trackingRefUpdate = it.next().getTrackingRefUpdate();
                    if (trackingRefUpdate != null) {
                        pushResult.add(trackingRefUpdate);
                    }
                }
                this.walker.close();
                return pushResult;
            } catch (Throwable th) {
                this.connection.close();
                pushResult.addMessages(this.connection.getMessages());
                throw th;
            }
        } catch (Throwable th2) {
            this.walker.close();
            throw th2;
        }
    }

    static /* synthetic */ boolean lambda$0(RemoteRefUpdate remoteRefUpdate) {
        switch ($SWITCH_TABLE$org$eclipse$jgit$transport$RemoteRefUpdate$Status()[remoteRefUpdate.getStatus().ordinal()]) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return false;
            default:
                return true;
        }
    }

    private Map<String, RemoteRefUpdate> prepareRemoteUpdates() throws TransportException {
        boolean zIsPushAtomic = this.transport.isPushAtomic();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (RemoteRefUpdate remoteRefUpdate : this.toPush.values()) {
            Ref ref = this.connection.getRef(remoteRefUpdate.getRemoteName());
            ObjectId objectId = ref != null ? ref.getObjectId() : null;
            if (objectId == null) {
                objectId = ObjectId.zeroId();
            }
            if (remoteRefUpdate.getNewObjectId().equals((AnyObjectId) objectId)) {
                if (remoteRefUpdate.isDelete()) {
                    remoteRefUpdate.setStatus(RemoteRefUpdate.Status.NON_EXISTING);
                } else {
                    remoteRefUpdate.setStatus(RemoteRefUpdate.Status.UP_TO_DATE);
                }
            } else if (remoteRefUpdate.isExpectingOldObjectId() && !remoteRefUpdate.getExpectedOldObjectId().equals((AnyObjectId) objectId)) {
                remoteRefUpdate.setStatus(RemoteRefUpdate.Status.REJECTED_REMOTE_CHANGED);
                if (zIsPushAtomic) {
                    return rejectAll();
                }
            } else {
                if (!remoteRefUpdate.isExpectingOldObjectId()) {
                    remoteRefUpdate.setExpectedOldObjectId(objectId);
                }
                if (objectId.equals((AnyObjectId) ObjectId.zeroId()) || remoteRefUpdate.isDelete()) {
                    remoteRefUpdate.setFastForward(true);
                    linkedHashMap.put(remoteRefUpdate.getRemoteName(), remoteRefUpdate);
                } else {
                    boolean zIsFastForward = isFastForward(objectId, remoteRefUpdate.getNewObjectId());
                    remoteRefUpdate.setFastForward(zIsFastForward);
                    if (!zIsFastForward && !remoteRefUpdate.isForceUpdate()) {
                        remoteRefUpdate.setStatus(RemoteRefUpdate.Status.REJECTED_NONFASTFORWARD);
                        if (zIsPushAtomic) {
                            return rejectAll();
                        }
                    } else {
                        linkedHashMap.put(remoteRefUpdate.getRemoteName(), remoteRefUpdate);
                    }
                }
            }
        }
        return linkedHashMap;
    }

    private boolean isFastForward(ObjectId objectId, ObjectId objectId2) throws TransportException {
        try {
            RevObject any = this.walker.parseAny(objectId);
            RevObject any2 = this.walker.parseAny(objectId2);
            return (any instanceof RevCommit) && (any2 instanceof RevCommit) && this.walker.isMergedInto((RevCommit) any, (RevCommit) any2);
        } catch (MissingObjectException unused) {
            return false;
        } catch (Exception e) {
            throw new TransportException(this.transport.getURI(), MessageFormat.format(JGitText.get().readingObjectsFromLocalRepositoryFailed, e.getMessage()), e);
        }
    }

    private Map<String, RemoteRefUpdate> expandMatching() throws TransportException {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        boolean z = false;
        for (RemoteRefUpdate remoteRefUpdate : this.toPush.values()) {
            if (remoteRefUpdate.isMatching()) {
                if (z) {
                    throw new TransportException(MessageFormat.format(JGitText.get().duplicateRemoteRefUpdateIsIllegal, CollectionUtils.COLON));
                }
                expandMatching(linkedHashMap, remoteRefUpdate);
                z = true;
            } else if (linkedHashMap.put(remoteRefUpdate.getRemoteName(), remoteRefUpdate) != null) {
                throw new TransportException(MessageFormat.format(JGitText.get().duplicateRemoteRefUpdateIsIllegal, remoteRefUpdate.getRemoteName()));
            }
        }
        return linkedHashMap;
    }

    private void expandMatching(Map<String, RemoteRefUpdate> map, RemoteRefUpdate remoteRefUpdate) throws TransportException {
        String name;
        Ref ref;
        ObjectId objectId;
        ObjectId objectId2;
        try {
            Map<String, Ref> refsMap = this.connection.getRefsMap();
            Collection<RefSpec> fetchSpecs = remoteRefUpdate.getFetchSpecs();
            boolean zIsForceUpdate = remoteRefUpdate.isForceUpdate();
            for (Ref ref2 : this.transport.local.getRefDatabase().getRefsByPrefix(Constants.R_HEADS)) {
                if (!ref2.isSymbolic() && (ref = refsMap.get((name = ref2.getName()))) != null && !ref.isSymbolic() && (objectId = ref.getObjectId()) != null && !ObjectId.zeroId().equals((AnyObjectId) objectId) && (objectId2 = ref2.getObjectId()) != null && !ObjectId.zeroId().equals((AnyObjectId) objectId2)) {
                    RemoteRefUpdate remoteRefUpdate2 = new RemoteRefUpdate(this.transport.local, name, objectId2, name, zIsForceUpdate, Transport.findTrackingRefName(name, fetchSpecs), objectId);
                    if (map.put(remoteRefUpdate2.getRemoteName(), remoteRefUpdate2) != null) {
                        throw new TransportException(MessageFormat.format(JGitText.get().duplicateRemoteRefUpdateIsIllegal, remoteRefUpdate2.getRemoteName()));
                    }
                }
            }
        } catch (IOException e) {
            throw new TransportException(this.transport.getURI(), MessageFormat.format(JGitText.get().readingObjectsFromLocalRepositoryFailed, e.getMessage()), e);
        }
    }

    private Map<String, RemoteRefUpdate> rejectAll() {
        for (RemoteRefUpdate remoteRefUpdate : this.toPush.values()) {
            if (remoteRefUpdate.getStatus() == RemoteRefUpdate.Status.NOT_ATTEMPTED) {
                remoteRefUpdate.setStatus(RemoteRefUpdate.Status.REJECTED_OTHER_REASON);
                remoteRefUpdate.setMessage(JGitText.get().transactionAborted);
            }
        }
        return Collections.emptyMap();
    }

    private void modifyUpdatesForDryRun() {
        for (RemoteRefUpdate remoteRefUpdate : this.toPush.values()) {
            if (remoteRefUpdate.getStatus() == RemoteRefUpdate.Status.NOT_ATTEMPTED) {
                remoteRefUpdate.setStatus(RemoteRefUpdate.Status.OK);
            }
        }
    }

    private void updateTrackingRefs() {
        for (RemoteRefUpdate remoteRefUpdate : this.toPush.values()) {
            RemoteRefUpdate.Status status = remoteRefUpdate.getStatus();
            if (remoteRefUpdate.hasTrackingRefUpdate() && (status == RemoteRefUpdate.Status.UP_TO_DATE || status == RemoteRefUpdate.Status.OK)) {
                try {
                    remoteRefUpdate.updateTrackingRef(this.walker);
                } catch (IOException unused) {
                }
            }
        }
    }

    public List<String> getPushOptions() {
        return this.pushOptions;
    }
}
