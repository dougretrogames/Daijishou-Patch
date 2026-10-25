package org.eclipse.jgit.transport;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.errors.NotSupportedException;
import org.eclipse.jgit.errors.TransportException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.storage.file.LockFile;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.BatchRefUpdate;
import org.eclipse.jgit.lib.BatchingProgressMonitor;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectIdRef;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.revwalk.ObjectWalk;
import org.eclipse.jgit.revwalk.RevObject;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.util.StringUtils;

/* JADX INFO: loaded from: classes5.dex */
class FetchProcess {
    private FetchConnection conn;
    private Map<String, Ref> localRefs;
    private final Collection<RefSpec> negativeRefSpecs;
    private final Collection<RefSpec> toFetch;
    private final Transport transport;
    private final HashMap<ObjectId, Ref> askFor = new HashMap<>();
    private final HashSet<ObjectId> have = new HashSet<>();
    private final ArrayList<TrackingRefUpdate> localUpdates = new ArrayList<>();
    private final ArrayList<FetchHeadRecord> fetchHeadUpdates = new ArrayList<>();
    private final ArrayList<PackLock> packLocks = new ArrayList<>();

    FetchProcess(Transport transport, Collection<RefSpec> collection) {
        this.transport = transport;
        this.toFetch = (Collection) collection.stream().filter(new FetchProcess$$ExternalSyntheticLambda0()).collect(Collectors.toList());
        this.negativeRefSpecs = (Collection) collection.stream().filter(new FetchProcess$$ExternalSyntheticLambda1()).collect(Collectors.toList());
    }

    static /* synthetic */ boolean lambda$0(RefSpec refSpec) {
        return !refSpec.isNegative();
    }

    void execute(ProgressMonitor progressMonitor, FetchResult fetchResult, String str) throws NotSupportedException, TransportException {
        this.askFor.clear();
        this.localUpdates.clear();
        this.fetchHeadUpdates.clear();
        this.packLocks.clear();
        this.localRefs = null;
        try {
            try {
                executeImp(progressMonitor, fetchResult, str);
                try {
                    Iterator<PackLock> it = this.packLocks.iterator();
                    while (it.hasNext()) {
                        it.next().unlock();
                    }
                } catch (Throwable th) {
                    throw new TransportException(th.getMessage(), th);
                }
            } catch (Throwable th2) {
                try {
                    Iterator<PackLock> it2 = this.packLocks.iterator();
                    while (it2.hasNext()) {
                        it2.next().unlock();
                    }
                    throw th2;
                } catch (Throwable th3) {
                    if (0 != 0) {
                        th3.addSuppressed(null);
                    }
                    throw new TransportException(th3.getMessage(), th3);
                }
            }
        } catch (NotSupportedException | TransportException e) {
            throw e;
        }
    }

    private boolean isInitialBranchMissing(Map<String, Ref> map, String str) {
        return (StringUtils.isEmptyOrNull(str) || map.isEmpty() || map.containsKey(str) || map.containsKey(new StringBuilder(Constants.R_HEADS).append(str).toString()) || map.containsKey(new StringBuilder(Constants.R_TAGS).append(str).toString())) ? false : true;
    }

    private void executeImp(ProgressMonitor progressMonitor, FetchResult fetchResult, String str) throws NotSupportedException, TransportException {
        boolean zDidFetchIncludeTags;
        String str2 = "HEAD";
        TagOpt tagOpt = this.transport.getTagOpt();
        Throwable th = null;
        String str3 = tagOpt == TagOpt.NO_TAGS ? null : Constants.R_TAGS;
        try {
            Ref refExactRef = this.transport.local.exactRef("HEAD");
            ObjectId objectId = refExactRef != null ? refExactRef.getObjectId() : null;
            if (objectId != null && !objectId.equals((AnyObjectId) ObjectId.zeroId())) {
                str2 = null;
            }
        } catch (IOException unused) {
        }
        FetchConnection fetchConnectionOpenFetch = this.transport.openFetch(this.toFetch, str3, str2);
        this.conn = fetchConnectionOpenFetch;
        try {
            Map<String, Ref> refsMap = fetchConnectionOpenFetch.getRefsMap();
            if (isInitialBranchMissing(refsMap, str)) {
                throw new TransportException(MessageFormat.format(JGitText.get().remoteBranchNotFound, str));
            }
            fetchResult.setAdvertisedRefs(this.transport.getURI(), refsMap);
            fetchResult.peerUserAgent = this.conn.getPeerUserAgent();
            HashSet hashSet = new HashSet();
            for (RefSpec refSpec : this.toFetch) {
                if (refSpec.getSource() == null) {
                    throw new TransportException(MessageFormat.format(JGitText.get().sourceRefNotSpecifiedForRefspec, refSpec));
                }
                if (refSpec.isWildcard()) {
                    expandWildcard(refSpec, hashSet);
                } else {
                    expandSingle(refSpec, hashSet);
                }
            }
            Collection<Ref> collectionEmptyList = Collections.emptyList();
            if (tagOpt == TagOpt.AUTO_FOLLOW) {
                collectionEmptyList = expandAutoFollowTags();
            } else if (tagOpt == TagOpt.FETCH_TAGS) {
                expandFetchTags();
            }
            if (this.askFor.isEmpty() || askForIsComplete()) {
                zDidFetchIncludeTags = false;
            } else {
                fetchObjects(progressMonitor);
                zDidFetchIncludeTags = this.conn.didFetchIncludeTags();
                closeConnection(fetchResult);
            }
            if (tagOpt == TagOpt.AUTO_FOLLOW && !collectionEmptyList.isEmpty()) {
                this.have.addAll(this.askFor.keySet());
                this.askFor.clear();
                for (Ref ref : collectionEmptyList) {
                    ObjectId peeledObjectId = ref.getPeeledObjectId();
                    if (peeledObjectId == null) {
                        peeledObjectId = ref.getObjectId();
                    }
                    if (localHasObject(peeledObjectId)) {
                        wantTag(ref);
                    }
                }
                if (!this.askFor.isEmpty() && (!zDidFetchIncludeTags || !askForIsComplete())) {
                    reopenConnection();
                    if (!this.askFor.isEmpty()) {
                        fetchObjects(progressMonitor);
                    }
                }
            }
            closeConnection(fetchResult);
            BatchRefUpdate allowNonFastForwards = this.transport.local.getRefDatabase().newBatchUpdate().setAllowNonFastForwards(true);
            if (str == null) {
                allowNonFastForwards.setRefLogMessage("fetch", true);
            }
            try {
                RevWalk revWalk = new RevWalk(this.transport.local);
                try {
                    revWalk.setRetainBody(false);
                    if (progressMonitor instanceof BatchingProgressMonitor) {
                        ((BatchingProgressMonitor) progressMonitor).setDelayStart(250L, TimeUnit.MILLISECONDS);
                    }
                    if (this.transport.isRemoveDeletedRefs()) {
                        deleteStaleTrackingRefs(fetchResult, allowNonFastForwards);
                    }
                    addUpdateBatchCommands(fetchResult, allowNonFastForwards);
                    for (ReceiveCommand receiveCommand : allowNonFastForwards.getCommands()) {
                        receiveCommand.updateType(revWalk);
                        if (receiveCommand.getType() == ReceiveCommand.Type.UPDATE_NONFASTFORWARD && (receiveCommand instanceof TrackingRefUpdate.Command) && !((TrackingRefUpdate.Command) receiveCommand).canForceUpdate()) {
                            receiveCommand.setResult(ReceiveCommand.Result.REJECTED_NONFASTFORWARD);
                        }
                    }
                    if (this.transport.isDryRun()) {
                        for (ReceiveCommand receiveCommand2 : allowNonFastForwards.getCommands()) {
                            if (receiveCommand2.getResult() == ReceiveCommand.Result.NOT_ATTEMPTED) {
                                receiveCommand2.setResult(ReceiveCommand.Result.OK);
                            }
                        }
                    } else {
                        allowNonFastForwards.execute(revWalk, progressMonitor);
                    }
                    revWalk.close();
                    if (this.fetchHeadUpdates.isEmpty()) {
                        return;
                    }
                    try {
                        updateFETCH_HEAD(fetchResult);
                    } catch (IOException e) {
                        throw new TransportException(MessageFormat.format(JGitText.get().failureUpdatingFETCH_HEAD, e.getMessage()), e);
                    }
                } catch (Throwable th2) {
                    revWalk.close();
                    throw th2;
                }
            } catch (Throwable th3) {
                if (0 == 0) {
                    throw th3;
                }
                if (null != th3) {
                    try {
                        th.addSuppressed(th3);
                    } catch (TransportException e2) {
                        throw e2;
                    } catch (IOException e3) {
                        throw new TransportException(MessageFormat.format(JGitText.get().failureUpdatingTrackingRef, getFirstFailedRefName(allowNonFastForwards), e3.getMessage()), e3);
                    }
                }
                throw null;
            }
        } catch (Throwable th4) {
            closeConnection(fetchResult);
            throw th4;
        }
    }

    private void addUpdateBatchCommands(FetchResult fetchResult, BatchRefUpdate batchRefUpdate) throws TransportException {
        HashMap map = new HashMap();
        for (TrackingRefUpdate trackingRefUpdate : this.localUpdates) {
            ObjectId objectId = (ObjectId) map.get(trackingRefUpdate.getLocalName());
            if (objectId == null) {
                map.put(trackingRefUpdate.getLocalName(), trackingRefUpdate.getNewObjectId());
                fetchResult.add(trackingRefUpdate);
                batchRefUpdate.addCommand(trackingRefUpdate.asReceiveCommand());
            } else if (!objectId.equals((AnyObjectId) trackingRefUpdate.getNewObjectId())) {
                throw new TransportException(MessageFormat.format(JGitText.get().duplicateRef, trackingRefUpdate.getLocalName()));
            }
        }
    }

    private void fetchObjects(ProgressMonitor progressMonitor) throws TransportException {
        try {
            this.conn.setPackLockMessage("jgit fetch " + String.valueOf(this.transport.uri));
            this.conn.fetch(progressMonitor, this.askFor.values(), this.have);
            this.packLocks.addAll(this.conn.getPackLocks());
            if (this.transport.isCheckFetchedObjects() && !this.conn.didFetchTestConnectivity() && !askForIsComplete()) {
                throw new TransportException(this.transport.getURI(), JGitText.get().peerDidNotSupplyACompleteObjectGraph);
            }
        } catch (Throwable th) {
            this.packLocks.addAll(this.conn.getPackLocks());
            throw th;
        }
    }

    private void closeConnection(FetchResult fetchResult) {
        FetchConnection fetchConnection = this.conn;
        if (fetchConnection != null) {
            fetchConnection.close();
            fetchResult.addMessages(this.conn.getMessages());
            this.conn = null;
        }
    }

    private void reopenConnection() throws NotSupportedException, TransportException {
        if (this.conn != null) {
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator<Ref> it = this.askFor.values().iterator();
        while (it.hasNext()) {
            String name = it.next().getName();
            hashSet.add(name);
            hashSet.add(Constants.R_REFS + name);
            hashSet.add(Constants.R_HEADS + name);
            hashSet.add(Constants.R_TAGS + name);
        }
        this.conn = this.transport.openFetch(Collections.emptyList(), (String[]) hashSet.toArray(new String[0]));
        HashMap map = new HashMap();
        for (Ref ref : this.conn.getRefs()) {
            map.put(ref.getObjectId(), ref);
        }
        ArrayList<Ref> arrayList = new ArrayList(this.askFor.values());
        this.askFor.clear();
        for (Ref ref2 : arrayList) {
            Ref ref3 = (Ref) map.get(ref2.getObjectId());
            if (ref3 != null) {
                this.askFor.put(ref3.getObjectId(), ref3);
            } else {
                removeFetchHeadRecord(ref2.getObjectId());
                removeTrackingRefUpdate(ref2.getObjectId());
            }
        }
    }

    private void removeTrackingRefUpdate(ObjectId objectId) {
        Iterator<TrackingRefUpdate> it = this.localUpdates.iterator();
        while (it.hasNext()) {
            if (it.next().getNewObjectId().equals((AnyObjectId) objectId)) {
                it.remove();
            }
        }
    }

    private void removeFetchHeadRecord(ObjectId objectId) {
        Iterator<FetchHeadRecord> it = this.fetchHeadUpdates.iterator();
        while (it.hasNext()) {
            if (it.next().newValue.equals((AnyObjectId) objectId)) {
                it.remove();
            }
        }
    }

    private void updateFETCH_HEAD(FetchResult fetchResult) throws IOException {
        File directory = this.transport.local.getDirectory();
        if (directory == null) {
            return;
        }
        LockFile lockFile = new LockFile(new File(directory, Constants.FETCH_HEAD));
        try {
            if (lockFile.lock()) {
                Throwable th = null;
                try {
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(lockFile.getOutputStream(), StandardCharsets.UTF_8);
                    try {
                        for (FetchHeadRecord fetchHeadRecord : this.fetchHeadUpdates) {
                            fetchHeadRecord.write(outputStreamWriter);
                            fetchResult.add(fetchHeadRecord);
                        }
                        outputStreamWriter.close();
                        lockFile.commit();
                    } catch (Throwable th2) {
                        outputStreamWriter.close();
                        throw th2;
                    }
                } catch (Throwable th3) {
                    if (0 == 0) {
                        throw th3;
                    }
                    if (null != th3) {
                        th.addSuppressed(th3);
                    }
                    throw null;
                }
            }
            lockFile.unlock();
        } catch (Throwable th4) {
            lockFile.unlock();
            throw th4;
        }
    }

    private boolean askForIsComplete() throws TransportException {
        Throwable th = null;
        try {
            try {
                ObjectWalk objectWalk = new ObjectWalk(this.transport.local);
                try {
                    Iterator<ObjectId> it = this.askFor.keySet().iterator();
                    boolean z = false;
                    while (true) {
                        boolean z2 = true;
                        if (!it.hasNext()) {
                            break;
                        }
                        RevObject any = objectWalk.parseAny(it.next());
                        objectWalk.markStart(any);
                        if (any.getType() != 1) {
                            z2 = false;
                        }
                        z |= z2;
                    }
                    if (z) {
                        Iterator<Ref> it2 = localRefs().values().iterator();
                        while (it2.hasNext()) {
                            objectWalk.markUninteresting(objectWalk.parseAny(it2.next().getObjectId()));
                        }
                        objectWalk.checkConnectivity();
                    }
                    objectWalk.close();
                    return this.transport.getDepth() == null;
                } catch (Throwable th2) {
                    objectWalk.close();
                    throw th2;
                }
            } catch (Throwable th3) {
                if (0 == 0) {
                    throw th3;
                }
                if (null == th3) {
                    throw null;
                }
                th.addSuppressed(th3);
                throw null;
            }
        } catch (MissingObjectException unused) {
            return false;
        } catch (IOException e) {
            throw new TransportException(JGitText.get().unableToCheckConnectivity, e);
        }
    }

    private void expandWildcard(RefSpec refSpec, Set<Ref> set) throws TransportException {
        for (Ref ref : this.conn.getRefs()) {
            if (refSpec.matchSource(ref)) {
                RefSpec refSpecExpandFromSource = refSpec.expandFromSource(ref);
                if (!matchNegativeRefSpec(refSpecExpandFromSource) && set.add(ref)) {
                    want(ref, refSpecExpandFromSource);
                }
            }
        }
    }

    private void expandSingle(RefSpec refSpec, Set<Ref> set) throws TransportException {
        String source = refSpec.getSource();
        if (ObjectId.isId(source)) {
            want(ObjectId.fromString(source));
            return;
        }
        Ref ref = this.conn.getRef(source);
        if (ref == null) {
            throw new TransportException(MessageFormat.format(JGitText.get().remoteDoesNotHaveSpec, source));
        }
        if (matchNegativeRefSpec(refSpec) || !set.add(ref)) {
            return;
        }
        want(ref, refSpec);
    }

    private boolean matchNegativeRefSpec(RefSpec refSpec) {
        for (RefSpec refSpec2 : this.negativeRefSpecs) {
            if (refSpec2.getSource() != null && refSpec.getSource() != null && refSpec2.matchSource(refSpec.getSource())) {
                return true;
            }
            if (refSpec2.getDestination() != null && refSpec.getDestination() != null && refSpec2.matchDestination(refSpec.getDestination())) {
                return true;
            }
        }
        return false;
    }

    private boolean localHasObject(ObjectId objectId) throws TransportException {
        try {
            return this.transport.local.getObjectDatabase().has(objectId);
        } catch (IOException e) {
            throw new TransportException(MessageFormat.format(JGitText.get().readingObjectsFromLocalRepositoryFailed, e.getMessage()), e);
        }
    }

    private Collection<Ref> expandAutoFollowTags() throws TransportException {
        ArrayList arrayList = new ArrayList();
        Map<String, Ref> mapLocalRefs = localRefs();
        for (Ref ref : this.conn.getRefs()) {
            if (isTag(ref) && mapLocalRefs.get(ref.getName()) == null) {
                ObjectId peeledObjectId = ref.getPeeledObjectId();
                if (peeledObjectId == null) {
                    peeledObjectId = ref.getObjectId();
                }
                if (this.askFor.containsKey(peeledObjectId) || localHasObject(peeledObjectId)) {
                    wantTag(ref);
                } else {
                    arrayList.add(ref);
                }
            }
        }
        return arrayList;
    }

    private void expandFetchTags() throws TransportException {
        ObjectId objectId;
        Ref ref;
        Map<String, Ref> mapLocalRefs = localRefs();
        for (Ref ref2 : this.conn.getRefs()) {
            if (isTag(ref2) && (objectId = ref2.getObjectId()) != null && ((ref = mapLocalRefs.get(ref2.getName())) == null || !objectId.equals((AnyObjectId) ref.getObjectId()))) {
                wantTag(ref2);
            }
        }
    }

    private void wantTag(Ref ref) throws TransportException {
        want(ref, new RefSpec().setSource(ref.getName()).setDestination(ref.getName()).setForceUpdate(true));
    }

    private void want(Ref ref, RefSpec refSpec) throws TransportException {
        ObjectId objectId = ref.getObjectId();
        if (objectId == null) {
            throw new NullPointerException(MessageFormat.format(JGitText.get().transportProvidedRefWithNoObjectId, ref.getName()));
        }
        if (refSpec.getDestination() != null) {
            TrackingRefUpdate trackingRefUpdateCreateUpdate = createUpdate(refSpec, objectId);
            if (objectId.equals((AnyObjectId) trackingRefUpdateCreateUpdate.getOldObjectId()) && this.transport.getDepth() == null) {
                return;
            } else {
                this.localUpdates.add(trackingRefUpdateCreateUpdate);
            }
        }
        this.askFor.put(objectId, ref);
        FetchHeadRecord fetchHeadRecord = new FetchHeadRecord();
        fetchHeadRecord.newValue = objectId;
        fetchHeadRecord.notForMerge = refSpec.getDestination() != null;
        fetchHeadRecord.sourceName = ref.getName();
        fetchHeadRecord.sourceURI = this.transport.getURI();
        this.fetchHeadUpdates.add(fetchHeadRecord);
    }

    private void want(ObjectId objectId) {
        this.askFor.put(objectId, new ObjectIdRef.Unpeeled(Ref.Storage.NETWORK, objectId.name(), objectId));
    }

    private TrackingRefUpdate createUpdate(RefSpec refSpec, ObjectId objectId) throws TransportException {
        ObjectId objectIdZeroId;
        Ref ref = localRefs().get(refSpec.getDestination());
        if (ref != null && ref.getObjectId() != null) {
            objectIdZeroId = ref.getObjectId();
        } else {
            objectIdZeroId = ObjectId.zeroId();
        }
        return new TrackingRefUpdate(refSpec.isForceUpdate(), refSpec.getSource(), refSpec.getDestination(), objectIdZeroId, objectId);
    }

    private Map<String, Ref> localRefs() throws TransportException {
        if (this.localRefs == null) {
            try {
                this.localRefs = this.transport.local.getRefDatabase().getRefs("");
            } catch (IOException e) {
                throw new TransportException(JGitText.get().cannotListRefs, e);
            }
        }
        return this.localRefs;
    }

    private void deleteStaleTrackingRefs(FetchResult fetchResult, BatchRefUpdate batchRefUpdate) throws IOException {
        HashSet hashSet = new HashSet();
        for (Ref ref : localRefs().values()) {
            if (!ref.isSymbolic()) {
                String name = ref.getName();
                for (RefSpec refSpec : this.toFetch) {
                    if (refSpec.matchDestination(name)) {
                        RefSpec refSpecExpandFromDestination = refSpec.expandFromDestination(name);
                        if (fetchResult.getAdvertisedRef(refSpecExpandFromDestination.getSource()) == null && hashSet.add(ref)) {
                            deleteTrackingRef(fetchResult, batchRefUpdate, refSpecExpandFromDestination, ref);
                        }
                    }
                }
            }
        }
    }

    private void deleteTrackingRef(FetchResult fetchResult, BatchRefUpdate batchRefUpdate, RefSpec refSpec, Ref ref) {
        if (ref.getObjectId() == null) {
            return;
        }
        TrackingRefUpdate trackingRefUpdate = new TrackingRefUpdate(true, refSpec.getSource(), ref.getName(), ref.getObjectId(), ObjectId.zeroId());
        fetchResult.add(trackingRefUpdate);
        batchRefUpdate.addCommand(trackingRefUpdate.asReceiveCommand());
    }

    private static boolean isTag(Ref ref) {
        return isTag(ref.getName());
    }

    private static boolean isTag(String str) {
        return str.startsWith(Constants.R_TAGS);
    }

    private static String getFirstFailedRefName(BatchRefUpdate batchRefUpdate) {
        for (ReceiveCommand receiveCommand : batchRefUpdate.getCommands()) {
            if (receiveCommand.getResult() != ReceiveCommand.Result.OK) {
                return receiveCommand.getRefName();
            }
        }
        return "";
    }
}
