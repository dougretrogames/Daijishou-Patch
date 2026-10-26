package org.eclipse.jgit.transport;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.lingala.zip4j.util.InternalZipConstants;
import org.eclipse.jgit.errors.CompoundException;
import org.eclipse.jgit.errors.CorruptObjectException;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.errors.TransportException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.storage.file.ObjectDirectory;
import org.eclipse.jgit.internal.storage.file.PackIndex;
import org.eclipse.jgit.internal.storage.file.UnpackedObject;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.FileMode;
import org.eclipse.jgit.lib.MutableObjectId;
import org.eclipse.jgit.lib.ObjectChecker;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectInserter;
import org.eclipse.jgit.lib.ObjectLoader;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.DateRevQueue;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevFlag;
import org.eclipse.jgit.revwalk.RevObject;
import org.eclipse.jgit.revwalk.RevTag;
import org.eclipse.jgit.revwalk.RevTree;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.treewalk.TreeWalk;
import org.eclipse.jgit.util.FileUtils;

/* INFO: loaded from: classes5.dex */
class WalkFetchConnection extends BaseFetchConnection {
    private final RevFlag COMPLETE;
    private final RevFlag IN_WORK_QUEUE;
    private final RevFlag LOCALLY_SEEN;
    private final HashMap<ObjectId, List<Throwable>> fetchErrors;
    private final MutableObjectId idBuffer = new MutableObjectId();
    final ObjectInserter inserter;
    private int lastRemoteIdx;
    final Repository local;
    private final DateRevQueue localCommitQueue;
    String lockMessage;
    private final Deque<WalkRemoteObjectDatabase> noAlternatesYet;
    private final Deque<WalkRemoteObjectDatabase> noPacksYet;
    final ObjectChecker objCheck;
    final List<PackLock> packLocks;
    private final Set<String> packsConsidered;
    private final ObjectReader reader;
    private final List<WalkRemoteObjectDatabase> remotes;
    private final RevWalk revWalk;
    private final TreeWalk treeWalk;
    private final Map<String, RemotePack> unfetchedPacks;
    private Deque<ObjectId> workQueue;

    @Override // org.eclipse.jgit.transport.FetchConnection
    public boolean didFetchTestConnectivity() {
        return true;
    }

    /* WARN: Multi-variable type inference failed */
    WalkFetchConnection(WalkTransport walkTransport, WalkRemoteObjectDatabase walkRemoteObjectDatabase) {
        Transport transport = (Transport) walkTransport;
        Repository repository = transport.local;
        this.local = repository;
        this.objCheck = transport.getObjectChecker();
        ObjectInserter objectInserterNewObjectInserter = repository.newObjectInserter();
        this.inserter = objectInserterNewObjectInserter;
        ObjectReader objectReaderNewReader = objectInserterNewObjectInserter.newReader();
        this.reader = objectReaderNewReader;
        ArrayList arrayList = new ArrayList();
        this.remotes = arrayList;
        arrayList.add(walkRemoteObjectDatabase);
        this.unfetchedPacks = new LinkedHashMap();
        this.packsConsidered = new HashSet();
        ArrayDeque arrayDeque = new ArrayDeque();
        this.noPacksYet = arrayDeque;
        arrayDeque.add(walkRemoteObjectDatabase);
        ArrayDeque arrayDeque2 = new ArrayDeque();
        this.noAlternatesYet = arrayDeque2;
        arrayDeque2.add(walkRemoteObjectDatabase);
        this.fetchErrors = new HashMap<>();
        this.packLocks = new ArrayList(4);
        RevWalk revWalk = new RevWalk(objectReaderNewReader);
        this.revWalk = revWalk;
        revWalk.setRetainBody(false);
        this.treeWalk = new TreeWalk(objectReaderNewReader);
        this.COMPLETE = revWalk.newFlag("COMPLETE");
        this.IN_WORK_QUEUE = revWalk.newFlag("IN_WORK_QUEUE");
        this.LOCALLY_SEEN = revWalk.newFlag("LOCALLY_SEEN");
        this.localCommitQueue = new DateRevQueue();
        this.workQueue = new ArrayDeque();
    }

    @Override // org.eclipse.jgit.transport.BaseFetchConnection
    protected void doFetch(ProgressMonitor progressMonitor, Collection<Ref> collection, Set<ObjectId> set) throws TransportException {
        markLocalRefsComplete(set);
        queueWants(collection);
        while (!progressMonitor.isCancelled() && !this.workQueue.isEmpty()) {
            ObjectId objectIdRemoveFirst = this.workQueue.removeFirst();
            if (!(objectIdRemoveFirst instanceof RevObject) || !((RevObject) objectIdRemoveFirst).has(this.COMPLETE)) {
                downloadObject(progressMonitor, objectIdRemoveFirst);
            }
            process(objectIdRemoveFirst);
        }
        try {
            this.inserter.flush();
        } catch (IOException e) {
            throw new TransportException(e.getMessage(), e);
        }
    }

    @Override // org.eclipse.jgit.transport.FetchConnection
    public Collection<PackLock> getPackLocks() {
        return this.packLocks;
    }

    @Override // org.eclipse.jgit.transport.FetchConnection
    public void setPackLockMessage(String str) {
        this.lockMessage = str;
    }

    @Override // org.eclipse.jgit.transport.BaseConnection, org.eclipse.jgit.transport.Connection, java.lang.AutoCloseable
    public void close() {
        this.inserter.close();
        this.reader.close();
        for (RemotePack remotePack : this.unfetchedPacks.values()) {
            if (remotePack.tmpIdx != null) {
                remotePack.tmpIdx.delete();
            }
        }
        Iterator<WalkRemoteObjectDatabase> it = this.remotes.iterator();
        while (it.hasNext()) {
            it.next().close();
        }
    }

    private void queueWants(Collection<Ref> collection) throws TransportException {
        HashSet hashSet = new HashSet();
        for (Ref ref : collection) {
            ObjectId objectId = ref.getObjectId();
            if (objectId == null) {
                throw new NullPointerException(MessageFormat.format(JGitText.get().transportProvidedRefWithNoObjectId, ref.getName()));
            }
            try {
                RevObject any = this.revWalk.parseAny(objectId);
                if (!any.has(this.COMPLETE) && hashSet.add(objectId)) {
                    any.add(this.IN_WORK_QUEUE);
                    this.workQueue.add(any);
                }
            } catch (MissingObjectException unused) {
                if (hashSet.add(objectId)) {
                    this.workQueue.add(objectId);
                }
            } catch (IOException e) {
                throw new TransportException(MessageFormat.format(JGitText.get().cannotRead, objectId.name()), e);
            }
        }
    }

    private void process(ObjectId objectId) throws TransportException {
        RevObject any;
        try {
            if (objectId instanceof RevObject) {
                any = (RevObject) objectId;
                if (any.has(this.COMPLETE)) {
                    return;
                } else {
                    this.revWalk.parseHeaders(any);
                }
            } else {
                any = this.revWalk.parseAny(objectId);
                if (any.has(this.COMPLETE)) {
                    return;
                }
            }
            int type = any.getType();
            if (type == 1) {
                processCommit(any);
            } else if (type == 2) {
                processTree(any);
            } else if (type == 3) {
                processBlob(any);
            } else if (type == 4) {
                processTag(any);
            } else {
                throw new TransportException(MessageFormat.format(JGitText.get().unknownObjectType, objectId.name()));
            }
            this.fetchErrors.remove(objectId);
        } catch (IOException e) {
            throw new TransportException(MessageFormat.format(JGitText.get().cannotRead, objectId.name()), e);
        }
    }

    private void processBlob(RevObject revObject) throws TransportException {
        try {
            if (this.reader.has(revObject, 3)) {
                revObject.add(this.COMPLETE);
                return;
            }
            throw new TransportException(MessageFormat.format(JGitText.get().cannotReadBlob, revObject.name()), new MissingObjectException(revObject, Constants.TYPE_BLOB));
        } catch (IOException e) {
            throw new TransportException(MessageFormat.format(JGitText.get().cannotReadBlob, revObject.name()), e);
        }
    }

    private void processTree(RevObject revObject) throws TransportException {
        try {
            this.treeWalk.reset(revObject);
            while (this.treeWalk.next()) {
                FileMode fileMode = this.treeWalk.getFileMode(0);
                int objectType = fileMode.getObjectType();
                if (objectType == 2 || objectType == 3) {
                    this.treeWalk.getObjectId(this.idBuffer, 0);
                    needs(this.revWalk.lookupAny(this.idBuffer, objectType));
                } else if (!FileMode.GITLINK.equals(fileMode)) {
                    this.treeWalk.getObjectId(this.idBuffer, 0);
                    throw new CorruptObjectException(MessageFormat.format(JGitText.get().invalidModeFor, fileMode, this.idBuffer.name(), this.treeWalk.getPathString(), revObject.getId().name()));
                }
            }
            revObject.add(this.COMPLETE);
        } catch (IOException e) {
            throw new TransportException(MessageFormat.format(JGitText.get().cannotReadTree, revObject.name()), e);
        }
    }

    private void processCommit(RevObject revObject) throws TransportException {
        RevCommit revCommit = (RevCommit) revObject;
        markLocalCommitsComplete(revCommit.getCommitTime());
        needs(revCommit.getTree());
        for (RevCommit revCommit2 : revCommit.getParents()) {
            needs(revCommit2);
        }
        revObject.add(this.COMPLETE);
    }

    private void processTag(RevObject revObject) {
        needs(((RevTag) revObject).getObject());
        revObject.add(this.COMPLETE);
    }

    private void needs(RevObject revObject) {
        if (revObject.has(this.COMPLETE) || revObject.has(this.IN_WORK_QUEUE)) {
            return;
        }
        revObject.add(this.IN_WORK_QUEUE);
        this.workQueue.add(revObject);
    }

    private void downloadObject(ProgressMonitor progressMonitor, AnyObjectId anyObjectId) throws TransportException {
        if (alreadyHave(anyObjectId)) {
            return;
        }
        while (!downloadPackedObject(progressMonitor, anyObjectId)) {
            String strName = anyObjectId.name();
            String str = strName.substring(0, 2) + InternalZipConstants.ZIP_FILE_SEPARATOR + strName.substring(2);
            for (int i = this.lastRemoteIdx; i < this.remotes.size(); i++) {
                if (downloadLooseObject(anyObjectId, str, this.remotes.get(i))) {
                    this.lastRemoteIdx = i;
                    return;
                }
            }
            for (int i2 = 0; i2 < this.lastRemoteIdx; i2++) {
                if (downloadLooseObject(anyObjectId, str, this.remotes.get(i2))) {
                    this.lastRemoteIdx = i2;
                    return;
                }
            }
            while (!this.noPacksYet.isEmpty()) {
                WalkRemoteObjectDatabase walkRemoteObjectDatabaseRemoveFirst = this.noPacksYet.removeFirst();
                try {
                    try {
                        progressMonitor.beginTask(JGitText.get().listingPacks, 0);
                        Collection<String> packNames = walkRemoteObjectDatabaseRemoveFirst.getPackNames();
                        progressMonitor.endTask();
                        if (packNames != null && !packNames.isEmpty()) {
                            for (String str2 : packNames) {
                                if (this.packsConsidered.add(str2)) {
                                    this.unfetchedPacks.put(str2, new RemotePack(walkRemoteObjectDatabaseRemoveFirst, str2));
                                }
                            }
                            if (downloadPackedObject(progressMonitor, anyObjectId)) {
                                return;
                            }
                        }
                    } catch (IOException e) {
                        recordError(anyObjectId, e);
                        progressMonitor.endTask();
                    }
                } catch (Throwable th) {
                    progressMonitor.endTask();
                    throw th;
                }
            }
            Collection<WalkRemoteObjectDatabase> collectionExpandOneAlternate = expandOneAlternate(anyObjectId, progressMonitor);
            if (collectionExpandOneAlternate != null && !collectionExpandOneAlternate.isEmpty()) {
                for (WalkRemoteObjectDatabase walkRemoteObjectDatabase : collectionExpandOneAlternate) {
                    this.remotes.add(walkRemoteObjectDatabase);
                    this.noPacksYet.add(walkRemoteObjectDatabase);
                    this.noAlternatesYet.add(walkRemoteObjectDatabase);
                }
            } else {
                List<Throwable> list = this.fetchErrors.get(anyObjectId);
                TransportException transportException = new TransportException(MessageFormat.format(JGitText.get().cannotGet, anyObjectId.name()));
                if (list != null && !list.isEmpty()) {
                    if (list.size() == 1) {
                        transportException.initCause(list.get(0));
                    } else {
                        transportException.initCause(new CompoundException(list));
                    }
                }
                throw transportException;
            }
        }
    }

    private boolean alreadyHave(AnyObjectId anyObjectId) throws TransportException {
        try {
            return this.reader.has(anyObjectId);
        } catch (IOException e) {
            throw new TransportException(MessageFormat.format(JGitText.get().cannotReadObject, anyObjectId.name()), e);
        }
    }

    private boolean downloadPackedObject(ProgressMonitor progressMonitor, AnyObjectId anyObjectId) throws TransportException {
        HashSet hashSet = new HashSet();
        try {
            return downloadPackedObject(progressMonitor, anyObjectId, hashSet);
        } finally {
            Map<String, RemotePack> map = this.unfetchedPacks;
            map.getClass();
            hashSet.forEach(new WalkFetchConnection$$ExternalSyntheticLambda0(map));
        }
    }

    private boolean downloadPackedObject(ProgressMonitor progressMonitor, AnyObjectId anyObjectId, Set<String> set) throws TransportException {
        for (Map.Entry<String, RemotePack> entry : this.unfetchedPacks.entrySet()) {
            if (progressMonitor.isCancelled()) {
                break;
            }
            RemotePack value = entry.getValue();
            try {
                value.openIndex(progressMonitor);
                if (progressMonitor.isCancelled()) {
                    return false;
                }
                if (value.index.hasObject(anyObjectId)) {
                    try {
                        try {
                            value.downloadPack(progressMonitor);
                            try {
                                if (value.tmpIdx != null) {
                                    FileUtils.delete(value.tmpIdx);
                                }
                                set.add(entry.getKey());
                                if (!alreadyHave(anyObjectId)) {
                                    recordError(anyObjectId, new FileNotFoundException(MessageFormat.format(JGitText.get().objectNotFoundIn, anyObjectId.name(), value.packName)));
                                } else {
                                    for (ObjectId objectId : swapFetchQueue()) {
                                        if (value.index.hasObject(objectId)) {
                                            process(objectId);
                                        } else {
                                            this.workQueue.add(objectId);
                                        }
                                    }
                                    return true;
                                }
                            } catch (Throwable th) {
                                throw new TransportException(th.getMessage(), th);
                            }
                        } catch (IOException e) {
                            recordError(anyObjectId, e);
                            try {
                                if (value.tmpIdx != null) {
                                    FileUtils.delete(value.tmpIdx);
                                }
                                set.add(entry.getKey());
                            } catch (Throwable th2) {
                                th2.addSuppressed(e);
                                throw new TransportException(th2.getMessage(), th2);
                            }
                        }
                    } catch (Throwable th3) {
                        try {
                            if (value.tmpIdx != null) {
                                FileUtils.delete(value.tmpIdx);
                            }
                            set.add(entry.getKey());
                            throw th3;
                        } catch (Throwable th4) {
                            throw new TransportException(th4.getMessage(), th4);
                        }
                    }
                } else {
                    continue;
                }
            } catch (IOException e2) {
                recordError(anyObjectId, e2);
                set.add(entry.getKey());
            }
        }
        return false;
    }

    private Deque<ObjectId> swapFetchQueue() {
        Deque<ObjectId> deque = this.workQueue;
        this.workQueue = new ArrayDeque();
        return deque;
    }

    private boolean downloadLooseObject(AnyObjectId anyObjectId, String str, WalkRemoteObjectDatabase walkRemoteObjectDatabase) throws TransportException {
        try {
            verifyAndInsertLooseObject(anyObjectId, walkRemoteObjectDatabase.open(str).toArray());
            return true;
        } catch (FileNotFoundException e) {
            recordError(anyObjectId, e);
            return false;
        } catch (IOException e2) {
            throw new TransportException(MessageFormat.format(JGitText.get().cannotDownload, anyObjectId.name()), e2);
        }
    }

    private void verifyAndInsertLooseObject(AnyObjectId anyObjectId, byte[] bArr) throws IOException {
        try {
            ObjectLoader objectLoader = UnpackedObject.parse(bArr, anyObjectId);
            int type = objectLoader.getType();
            byte[] cachedBytes = objectLoader.getCachedBytes();
            ObjectChecker objectChecker = this.objCheck;
            if (objectChecker != null) {
                try {
                    objectChecker.check(anyObjectId, type, cachedBytes);
                } catch (CorruptObjectException e) {
                    throw new TransportException(MessageFormat.format(JGitText.get().transportExceptionInvalid, Constants.typeString(type), anyObjectId.name(), e.getMessage()));
                }
            }
            ObjectId objectIdInsert = this.inserter.insert(type, cachedBytes);
            if (!AnyObjectId.isEqual(anyObjectId, objectIdInsert)) {
                throw new TransportException(MessageFormat.format(JGitText.get().incorrectHashFor, anyObjectId.name(), objectIdInsert.name(), Constants.typeString(type), Integer.valueOf(bArr.length)));
            }
        } catch (CorruptObjectException e2) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException(anyObjectId.name());
            fileNotFoundException.initCause(e2);
            throw fileNotFoundException;
        }
    }

    private Collection<WalkRemoteObjectDatabase> expandOneAlternate(AnyObjectId anyObjectId, ProgressMonitor progressMonitor) {
        while (!this.noAlternatesYet.isEmpty()) {
            WalkRemoteObjectDatabase walkRemoteObjectDatabaseRemoveFirst = this.noAlternatesYet.removeFirst();
            try {
                try {
                    progressMonitor.beginTask(JGitText.get().listingAlternates, 0);
                    Collection<WalkRemoteObjectDatabase> alternates = walkRemoteObjectDatabaseRemoveFirst.getAlternates();
                    if (alternates == null || alternates.isEmpty()) {
                        progressMonitor.endTask();
                    } else {
                        progressMonitor.endTask();
                        return alternates;
                    }
                } catch (IOException e) {
                    recordError(anyObjectId, e);
                }
            } catch (Throwable th) {
                progressMonitor.endTask();
                throw th;
            }
        }
        return null;
    }

    private void markLocalRefsComplete(Set<ObjectId> set) throws TransportException {
        try {
            for (Ref ref : this.local.getRefDatabase().getRefs()) {
                try {
                    markLocalObjComplete(this.revWalk.parseAny(ref.getObjectId()));
                } catch (IOException e) {
                    throw new TransportException(MessageFormat.format(JGitText.get().localRefIsMissingObjects, ref.getName()), e);
                }
            }
            for (ObjectId objectId : set) {
                try {
                    markLocalObjComplete(this.revWalk.parseAny(objectId));
                } catch (IOException e2) {
                    throw new TransportException(MessageFormat.format(JGitText.get().transportExceptionMissingAssumed, objectId.name()), e2);
                }
            }
        } catch (IOException e3) {
            throw new TransportException(e3.getMessage(), e3);
        }
    }

    private void markLocalObjComplete(RevObject revObject) throws IOException {
        while (revObject.getType() == 4) {
            revObject.add(this.COMPLETE);
            revObject = ((RevTag) revObject).getObject();
            this.revWalk.parseHeaders(revObject);
        }
        int type = revObject.getType();
        if (type == 1) {
            pushLocalCommit((RevCommit) revObject);
        } else if (type == 2) {
            markTreeComplete((RevTree) revObject);
        } else {
            if (type != 3) {
                return;
            }
            revObject.add(this.COMPLETE);
        }
    }

    private void markLocalCommitsComplete(int i) throws TransportException {
        while (true) {
            try {
                RevCommit revCommitPeek = this.localCommitQueue.peek();
                if (revCommitPeek != null && revCommitPeek.getCommitTime() >= i) {
                    this.localCommitQueue.next();
                    markTreeComplete(revCommitPeek.getTree());
                    for (RevCommit revCommit : revCommitPeek.getParents()) {
                        pushLocalCommit(revCommit);
                    }
                }
                return;
            } catch (IOException e) {
                throw new TransportException(JGitText.get().localObjectsIncomplete, e);
            }
        }
    }

    private void pushLocalCommit(RevCommit revCommit) throws IOException {
        if (revCommit.has(this.LOCALLY_SEEN)) {
            return;
        }
        this.revWalk.parseHeaders(revCommit);
        revCommit.add(this.LOCALLY_SEEN);
        revCommit.add(this.COMPLETE);
        revCommit.carry(this.COMPLETE);
        this.localCommitQueue.add(revCommit);
    }

    private void markTreeComplete(RevTree revTree) throws IOException {
        if (revTree.has(this.COMPLETE)) {
            return;
        }
        revTree.add(this.COMPLETE);
        this.treeWalk.reset(revTree);
        while (this.treeWalk.next()) {
            FileMode fileMode = this.treeWalk.getFileMode(0);
            int objectType = fileMode.getObjectType();
            if (objectType == 2) {
                this.treeWalk.getObjectId(this.idBuffer, 0);
                RevObject revObjectLookupAny = this.revWalk.lookupAny(this.idBuffer, objectType);
                if (!revObjectLookupAny.has(this.COMPLETE)) {
                    revObjectLookupAny.add(this.COMPLETE);
                    this.treeWalk.enterSubtree();
                }
            } else if (objectType == 3) {
                this.treeWalk.getObjectId(this.idBuffer, 0);
                this.revWalk.lookupAny(this.idBuffer, objectType).add(this.COMPLETE);
            } else if (!FileMode.GITLINK.equals(fileMode)) {
                this.treeWalk.getObjectId(this.idBuffer, 0);
                throw new CorruptObjectException(MessageFormat.format(JGitText.get().corruptObjectInvalidMode3, fileMode, this.idBuffer.name(), this.treeWalk.getPathString(), revTree.name()));
            }
        }
    }

    private void recordError(AnyObjectId anyObjectId, Throwable th) {
        ObjectId objectIdCopy = anyObjectId.copy();
        List<Throwable> arrayList = this.fetchErrors.get(objectIdCopy);
        if (arrayList == null) {
            arrayList = new ArrayList<>(2);
            this.fetchErrors.put(objectIdCopy, arrayList);
        }
        arrayList.add(th);
    }

    private class RemotePack {
        final WalkRemoteObjectDatabase connection;
        final String idxName;
        PackIndex index;
        final String packName;
        File tmpIdx;

        RemotePack(WalkRemoteObjectDatabase walkRemoteObjectDatabase, String str) {
            this.connection = walkRemoteObjectDatabase;
            this.packName = str;
            String strSubstring = str.substring(0, str.length() - 5) + ".idx";
            this.idxName = strSubstring;
            strSubstring = strSubstring.startsWith("pack-") ? strSubstring.substring(5) : strSubstring;
            strSubstring = strSubstring.endsWith(".idx") ? strSubstring.substring(0, strSubstring.length() - 4) : strSubstring;
            if (WalkFetchConnection.this.local.getObjectDatabase() instanceof ObjectDirectory) {
                this.tmpIdx = new File(((ObjectDirectory) WalkFetchConnection.this.local.getObjectDatabase()).getDirectory(), "walk-" + strSubstring + ".walkidx");
            }
        }

        /* WARN: Bottom block not found for handler: all -> 0x00c7 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void openIndex(org.eclipse.jgit.lib.ProgressMonitor r9) throws java.io.IOException {
            /*
                Method dump skipped, instruction units count: 214
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jgit.transport.WalkFetchConnection.RemotePack.openIndex(org.eclipse.jgit.lib.ProgressMonitor):void");
        }

        void downloadPack(ProgressMonitor progressMonitor) throws IOException {
            WalkRemoteObjectDatabase.FileStream fileStreamOpen = this.connection.open("pack/" + this.packName);
            try {
                PackParser packParserNewPackParser = WalkFetchConnection.this.inserter.newPackParser(fileStreamOpen.in);
                packParserNewPackParser.setAllowThin(false);
                packParserNewPackParser.setObjectChecker(WalkFetchConnection.this.objCheck);
                packParserNewPackParser.setLockMessage(WalkFetchConnection.this.lockMessage);
                PackLock packLock = packParserNewPackParser.parse(progressMonitor);
                if (packLock != null) {
                    WalkFetchConnection.this.packLocks.add(packLock);
                }
            } finally {
                fileStreamOpen.in.close();
            }
        }
    }
}
