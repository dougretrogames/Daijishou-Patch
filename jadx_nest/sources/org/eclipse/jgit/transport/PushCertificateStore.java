package org.eclipse.jgit.transport;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.eclipse.jgit.dircache.DirCache;
import org.eclipse.jgit.dircache.DirCacheEditor;
import org.eclipse.jgit.dircache.DirCacheEntry;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.BatchRefUpdate;
import org.eclipse.jgit.lib.CommitBuilder;
import org.eclipse.jgit.lib.FileMode;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectInserter;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.ObjectStream;
import org.eclipse.jgit.lib.PersonIdent;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.RefUpdate;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.treewalk.TreeWalk;
import org.eclipse.jgit.treewalk.filter.AndTreeFilter;
import org.eclipse.jgit.treewalk.filter.PathFilter;
import org.eclipse.jgit.treewalk.filter.PathFilterGroup;
import org.eclipse.jgit.treewalk.filter.TreeFilter;

/* JADX INFO: loaded from: classes5.dex */
public class PushCertificateStore implements AutoCloseable {
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$lib$RefUpdate$Result = null;
    static final String REF_NAME = "refs/meta/push-certs";
    RevCommit commit;
    private final Repository db;
    private final List<PendingCert> pending = new ArrayList();
    ObjectReader reader;

    static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$lib$RefUpdate$Result() {
        int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$lib$RefUpdate$Result;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[RefUpdate.Result.valuesCustom().length];
        try {
            iArr2[RefUpdate.Result.FAST_FORWARD.ordinal()] = 6;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[RefUpdate.Result.FORCED.ordinal()] = 5;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[RefUpdate.Result.IO_FAILURE.ordinal()] = 9;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[RefUpdate.Result.LOCK_FAILURE.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[RefUpdate.Result.NEW.ordinal()] = 4;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[RefUpdate.Result.NOT_ATTEMPTED.ordinal()] = 1;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            iArr2[RefUpdate.Result.NO_CHANGE.ordinal()] = 3;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            iArr2[RefUpdate.Result.REJECTED.ordinal()] = 7;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            iArr2[RefUpdate.Result.REJECTED_CURRENT_BRANCH.ordinal()] = 8;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            iArr2[RefUpdate.Result.REJECTED_MISSING_OBJECT.ordinal()] = 11;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            iArr2[RefUpdate.Result.REJECTED_OTHER_REASON.ordinal()] = 12;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            iArr2[RefUpdate.Result.RENAMED.ordinal()] = 10;
        } catch (NoSuchFieldError unused12) {
        }
        $SWITCH_TABLE$org$eclipse$jgit$lib$RefUpdate$Result = iArr2;
        return iArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class PendingCert {
        PushCertificate cert;
        PersonIdent ident;
        Collection<ReceiveCommand> matching;

        PendingCert(PushCertificate pushCertificate, PersonIdent personIdent, Collection<ReceiveCommand> collection) {
            this.cert = pushCertificate;
            this.ident = personIdent;
            this.matching = collection;
        }
    }

    public PushCertificateStore(Repository repository) {
        this.db = repository;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        ObjectReader objectReader = this.reader;
        if (objectReader != null) {
            objectReader.close();
            this.reader = null;
            this.commit = null;
        }
    }

    public PushCertificate get(String str) throws IOException {
        if (this.reader == null) {
            load();
        }
        Throwable th = null;
        try {
            TreeWalk treeWalkNewTreeWalk = newTreeWalk(str);
            try {
                return read(treeWalkNewTreeWalk);
            } finally {
                if (treeWalkNewTreeWalk != null) {
                    treeWalkNewTreeWalk.close();
                }
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            if (null != th2) {
                th.addSuppressed(th2);
            }
            throw null;
        }
    }

    /* JADX INFO: renamed from: org.eclipse.jgit.transport.PushCertificateStore$1, reason: invalid class name */
    class AnonymousClass1 implements Iterator<PushCertificate> {
        private PushCertificate next;
        private final String path;
        private RevWalk rw;

        AnonymousClass1(String str) {
            String strPathName = PushCertificateStore.pathName(str);
            this.path = strPathName;
            try {
                if (PushCertificateStore.this.reader == null) {
                    PushCertificateStore.this.load();
                }
                if (PushCertificateStore.this.commit != null) {
                    RevWalk revWalk = new RevWalk(PushCertificateStore.this.reader);
                    this.rw = revWalk;
                    revWalk.setTreeFilter(AndTreeFilter.create(PathFilterGroup.create(Collections.singleton(PathFilter.create(strPathName))), TreeFilter.ANY_DIFF));
                    this.rw.setRewriteParents(false);
                    RevWalk revWalk2 = this.rw;
                    revWalk2.markStart(revWalk2.parseCommit(PushCertificateStore.this.commit));
                    return;
                }
                this.rw = null;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() throws Throwable {
            RevWalk revWalk;
            RevWalk revWalk2;
            Throwable th;
            try {
                PushCertificate pushCertificate = this.next;
                if (pushCertificate == null) {
                    RevWalk revWalk3 = this.rw;
                    if (revWalk3 == null) {
                        if (pushCertificate == null && revWalk3 != null) {
                            revWalk3.close();
                            this.rw = null;
                        }
                        return false;
                    }
                    try {
                        RevCommit next = revWalk3.next();
                        if (next != null) {
                            try {
                                TreeWalk treeWalkForPath = TreeWalk.forPath(this.rw.getObjectReader(), this.path, next.getTree());
                                try {
                                    this.next = PushCertificateStore.read(treeWalkForPath);
                                    if (treeWalkForPath != null) {
                                        treeWalkForPath.close();
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (treeWalkForPath != null) {
                                        try {
                                            treeWalkForPath.close();
                                        } catch (Throwable th3) {
                                            th = th3;
                                            if (th == null) {
                                                throw th;
                                            }
                                            if (th != th) {
                                                th.addSuppressed(th);
                                            }
                                            throw th;
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                th = null;
                            }
                        } else {
                            this.next = null;
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                PushCertificate pushCertificate2 = this.next;
                boolean z = pushCertificate2 != null;
                if (pushCertificate2 == null && (revWalk2 = this.rw) != null) {
                    revWalk2.close();
                    this.rw = null;
                }
                return z;
            } catch (Throwable th5) {
                if (this.next == null && (revWalk = this.rw) != null) {
                    revWalk.close();
                    this.rw = null;
                }
                throw th5;
            }
        }

        @Override // java.util.Iterator
        public PushCertificate next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            PushCertificate pushCertificate = this.next;
            this.next = null;
            return pushCertificate;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public Iterable<PushCertificate> getAll(String str) {
        return new PushCertificateStore$$ExternalSyntheticLambda1(this, str);
    }

    /* JADX INFO: renamed from: lambda$0$org-eclipse-jgit-transport-PushCertificateStore, reason: not valid java name */
    /* synthetic */ Iterator m5811lambda$0$orgeclipsejgittransportPushCertificateStore(String str) {
        return new AnonymousClass1(str);
    }

    void load() throws IOException {
        close();
        this.reader = this.db.newObjectReader();
        Ref refExactRef = this.db.getRefDatabase().exactRef(REF_NAME);
        if (refExactRef == null) {
            return;
        }
        Throwable th = null;
        try {
            RevWalk revWalk = new RevWalk(this.reader);
            try {
                this.commit = revWalk.parseCommit(refExactRef.getObjectId());
            } finally {
                revWalk.close();
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            if (null != th2) {
                th.addSuppressed(th2);
            }
            throw null;
        }
    }

    static PushCertificate read(TreeWalk treeWalk) throws IOException {
        Throwable th = null;
        if (treeWalk == null || (treeWalk.getRawMode(0) & 32768) != 32768) {
            return null;
        }
        try {
            ObjectStream objectStreamOpenStream = treeWalk.getObjectReader().open(treeWalk.getObjectId(0), 3).openStream();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(objectStreamOpenStream, StandardCharsets.UTF_8));
                try {
                    PushCertificate pushCertificateFromReader = PushCertificateParser.fromReader(bufferedReader);
                    bufferedReader.close();
                    if (objectStreamOpenStream != null) {
                        objectStreamOpenStream.close();
                    }
                    return pushCertificateFromReader;
                } catch (Throwable th2) {
                    bufferedReader.close();
                    throw th2;
                }
            } catch (Throwable th3) {
                if (0 == 0) {
                    th = th3;
                } else if (null != th3) {
                    th.addSuppressed(th3);
                }
                if (objectStreamOpenStream == null) {
                    throw th;
                }
                objectStreamOpenStream.close();
                throw th;
            }
        } catch (Throwable th4) {
            if (0 == 0) {
                throw th4;
            }
            if (null != th4) {
                th.addSuppressed(th4);
            }
            throw null;
        }
    }

    public void put(PushCertificate pushCertificate, PersonIdent personIdent) {
        put(pushCertificate, personIdent, null);
    }

    public void put(PushCertificate pushCertificate, PersonIdent personIdent, Collection<ReceiveCommand> collection) {
        this.pending.add(new PendingCert(pushCertificate, personIdent, collection));
    }

    public RefUpdate.Result save() throws IOException {
        ObjectId objectIdWrite = write();
        if (objectIdWrite == null) {
            return RefUpdate.Result.NO_CHANGE;
        }
        Throwable th = null;
        try {
            ObjectInserter objectInserterNewObjectInserter = this.db.newObjectInserter();
            try {
                RefUpdate.Result resultUpdateRef = updateRef(objectIdWrite);
                int i = $SWITCH_TABLE$org$eclipse$jgit$lib$RefUpdate$Result()[resultUpdateRef.ordinal()];
                if (i == 3 || i == 4 || i == 6) {
                    this.pending.clear();
                }
                if (objectInserterNewObjectInserter != null) {
                    objectInserterNewObjectInserter.close();
                }
                close();
                return resultUpdateRef;
            } catch (Throwable th2) {
                if (objectInserterNewObjectInserter == null) {
                    throw th2;
                }
                objectInserterNewObjectInserter.close();
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
                    close();
                    throw th4;
                }
            }
            throw null;
        }
    }

    public boolean save(BatchRefUpdate batchRefUpdate) throws IOException {
        ObjectId objectIdWrite = write();
        if (objectIdWrite == null || objectIdWrite.equals((AnyObjectId) this.commit)) {
            return false;
        }
        ObjectId objectIdZeroId = this.commit;
        if (objectIdZeroId == null) {
            objectIdZeroId = ObjectId.zeroId();
        }
        batchRefUpdate.addCommand(new ReceiveCommand(objectIdZeroId, objectIdWrite, REF_NAME));
        return true;
    }

    public void clear() {
        this.pending.clear();
    }

    private ObjectId write() throws IOException {
        Throwable th = null;
        if (this.pending.isEmpty()) {
            return null;
        }
        if (this.reader == null) {
            load();
        }
        sortPending(this.pending);
        ObjectId objectIdSaveCert = this.commit;
        DirCache dirCacheNewDirCache = newDirCache();
        try {
            ObjectInserter objectInserterNewObjectInserter = this.db.newObjectInserter();
            try {
                Iterator<PendingCert> it = this.pending.iterator();
                while (it.hasNext()) {
                    objectIdSaveCert = saveCert(objectInserterNewObjectInserter, dirCacheNewDirCache, it.next(), objectIdSaveCert);
                }
                objectInserterNewObjectInserter.flush();
                return objectIdSaveCert;
            } finally {
                if (objectInserterNewObjectInserter != null) {
                    objectInserterNewObjectInserter.close();
                }
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            if (null != th2) {
                th.addSuppressed(th2);
            }
            throw null;
        }
    }

    private static void sortPending(List<PendingCert> list) {
        Collections.sort(list, new PushCertificateStore$$ExternalSyntheticLambda0());
    }

    private DirCache newDirCache() throws IOException {
        RevCommit revCommit = this.commit;
        if (revCommit != null) {
            return DirCache.read(this.reader, revCommit.getTree());
        }
        return DirCache.newInCore();
    }

    private ObjectId saveCert(ObjectInserter objectInserter, DirCache dirCache, PendingCert pendingCert, ObjectId objectId) throws IOException {
        HashMap map;
        if (pendingCert.matching != null) {
            map = new HashMap();
            for (ReceiveCommand receiveCommand : pendingCert.matching) {
                if (map.put(receiveCommand.getRefName(), receiveCommand) != null) {
                    throw new IllegalStateException();
                }
            }
        } else {
            map = null;
        }
        DirCacheEditor dirCacheEditorEditor = dirCache.editor();
        ObjectId objectIdInsert = objectInserter.insert(3, (pendingCert.cert.toText() + pendingCert.cert.getSignature()).getBytes(StandardCharsets.UTF_8));
        boolean z = false;
        for (ReceiveCommand receiveCommand2 : pendingCert.cert.getCommands()) {
            if (map == null || commandsEqual(receiveCommand2, (ReceiveCommand) map.get(receiveCommand2.getRefName()))) {
                dirCacheEditorEditor.add(new AnonymousClass2(pathName(receiveCommand2.getRefName()), objectIdInsert));
                z = true;
            }
        }
        if (!z) {
            return objectId;
        }
        dirCacheEditorEditor.finish();
        CommitBuilder commitBuilder = new CommitBuilder();
        commitBuilder.setAuthor(pendingCert.ident);
        commitBuilder.setCommitter(pendingCert.ident);
        commitBuilder.setTreeId(dirCache.writeTree(objectInserter));
        if (objectId != null) {
            commitBuilder.setParentId(objectId);
        } else {
            commitBuilder.setParentIds(Collections.emptyList());
        }
        commitBuilder.setMessage(buildMessage(pendingCert.cert));
        return objectInserter.insert(1, commitBuilder.build());
    }

    /* JADX INFO: renamed from: org.eclipse.jgit.transport.PushCertificateStore$2, reason: invalid class name */
    class AnonymousClass2 extends DirCacheEditor.PathEdit {
        private final /* synthetic */ ObjectId val$certId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, ObjectId objectId) {
            super(str);
            this.val$certId = objectId;
        }

        @Override // org.eclipse.jgit.dircache.DirCacheEditor.PathEdit
        public void apply(DirCacheEntry dirCacheEntry) {
            dirCacheEntry.setFileMode(FileMode.REGULAR_FILE);
            dirCacheEntry.setObjectId(this.val$certId);
        }
    }

    private static boolean commandsEqual(ReceiveCommand receiveCommand, ReceiveCommand receiveCommand2) {
        if (receiveCommand == null || receiveCommand2 == null) {
            return receiveCommand == receiveCommand2;
        }
        return receiveCommand.getRefName().equals(receiveCommand2.getRefName()) && receiveCommand.getOldId().equals((AnyObjectId) receiveCommand2.getOldId()) && receiveCommand.getNewId().equals((AnyObjectId) receiveCommand2.getNewId());
    }

    private RefUpdate.Result updateRef(ObjectId objectId) throws IOException {
        RefUpdate refUpdateUpdateRef = this.db.updateRef(REF_NAME);
        AnyObjectId anyObjectIdZeroId = this.commit;
        if (anyObjectIdZeroId == null) {
            anyObjectIdZeroId = ObjectId.zeroId();
        }
        refUpdateUpdateRef.setExpectedOldObjectId(anyObjectIdZeroId);
        refUpdateUpdateRef.setNewObjectId(objectId);
        List<PendingCert> list = this.pending;
        refUpdateUpdateRef.setRefLogIdent(list.get(list.size() - 1).ident);
        refUpdateUpdateRef.setRefLogMessage(JGitText.get().storePushCertReflog, false);
        Throwable th = null;
        try {
            RevWalk revWalk = new RevWalk(this.reader);
            try {
                return refUpdateUpdateRef.update(revWalk);
            } finally {
                revWalk.close();
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            if (null == th2) {
                throw null;
            }
            th.addSuppressed(th2);
            throw null;
        }
    }

    private TreeWalk newTreeWalk(String str) throws IOException {
        if (this.commit == null) {
            return null;
        }
        return TreeWalk.forPath(this.reader, pathName(str), this.commit.getTree());
    }

    static String pathName(String str) {
        return str + "@{cert}";
    }

    private static String buildMessage(PushCertificate pushCertificate) {
        StringBuilder sb = new StringBuilder();
        if (pushCertificate.getCommands().size() == 1) {
            sb.append(MessageFormat.format(JGitText.get().storePushCertOneRef, pushCertificate.getCommands().get(0).getRefName()));
        } else {
            sb.append(MessageFormat.format(JGitText.get().storePushCertMultipleRefs, Integer.valueOf(pushCertificate.getCommands().size())));
        }
        return sb.append('\n').toString();
    }
}
