package org.eclipse.jgit.internal.storage.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import org.eclipse.jgit.api.PackRefsCommand;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.events.RefsChangedEvent;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.storage.reftable.MergedReftable;
import org.eclipse.jgit.internal.storage.reftable.ReftableBatchRefUpdate;
import org.eclipse.jgit.internal.storage.reftable.ReftableDatabase;
import org.eclipse.jgit.internal.storage.reftable.ReftableWriter;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.BatchRefUpdate;
import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectIdRef;
import org.eclipse.jgit.lib.PersonIdent;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.RefDatabase;
import org.eclipse.jgit.lib.RefRename;
import org.eclipse.jgit.lib.RefUpdate;
import org.eclipse.jgit.lib.ReflogEntry;
import org.eclipse.jgit.lib.ReflogReader;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.SymbolicRef;
import org.eclipse.jgit.revwalk.RevObject;
import org.eclipse.jgit.revwalk.RevTag;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.transport.ReceiveCommand;
import org.eclipse.jgit.util.FileUtils;
import org.eclipse.jgit.util.RefList;
import org.eclipse.jgit.util.RefMap;

/* JADX INFO: loaded from: classes5.dex */
public class FileReftableDatabase extends RefDatabase {
    private final FileRepository fileRepository;
    private final ReftableDatabase reftableDatabase;
    private final FileReftableStack reftableStack;

    @Override // org.eclipse.jgit.lib.RefDatabase
    public boolean performsAtomicTransactions() {
        return true;
    }

    FileReftableDatabase(FileRepository fileRepository) throws IOException {
        this(fileRepository, new File(new File(fileRepository.getCommonDirectory(), "reftable"), Constants.TABLES_LIST));
    }

    FileReftableDatabase(FileRepository fileRepository, File file) throws IOException {
        this.fileRepository = fileRepository;
        this.reftableStack = new FileReftableStack(file, new File(fileRepository.getCommonDirectory(), "reftable"), new FileReftableDatabase$$ExternalSyntheticLambda2(this), new FileReftableDatabase$$ExternalSyntheticLambda3(this));
        this.reftableDatabase = new AnonymousClass1();
    }

    /* JADX INFO: renamed from: lambda$0$org-eclipse-jgit-internal-storage-file-FileReftableDatabase, reason: not valid java name */
    /* synthetic */ void m5687x15fe7d06() {
        this.fileRepository.fireEvent(new RefsChangedEvent());
    }

    /* JADX INFO: renamed from: org.eclipse.jgit.internal.storage.file.FileReftableDatabase$1, reason: invalid class name */
    class AnonymousClass1 extends ReftableDatabase {
        AnonymousClass1() {
        }

        @Override // org.eclipse.jgit.internal.storage.reftable.ReftableDatabase
        public MergedReftable openMergedReftable() throws IOException {
            return FileReftableDatabase.this.reftableStack.getMergedReftable();
        }
    }

    /* JADX INFO: renamed from: lambda$1$org-eclipse-jgit-internal-storage-file-FileReftableDatabase, reason: not valid java name */
    /* synthetic */ Config m5688xd0741d87() {
        return this.fileRepository.getConfig();
    }

    ReflogReader getReflogReader(String str) throws IOException {
        return this.reftableDatabase.getReflogReader(str);
    }

    public static boolean isReftable(File file) {
        return new File(file, "reftable").isDirectory();
    }

    @Override // org.eclipse.jgit.lib.RefDatabase
    public boolean hasFastTipsWithSha1() throws IOException {
        return this.reftableDatabase.hasFastTipsWithSha1();
    }

    @Override // org.eclipse.jgit.lib.RefDatabase
    public void packRefs(ProgressMonitor progressMonitor, PackRefsCommand packRefsCommand) throws IOException {
        progressMonitor.beginTask(JGitText.get().packRefs, 1);
        try {
            compactFully();
        } finally {
            progressMonitor.endTask();
        }
    }

    public void compactFully() throws IOException {
        ReentrantLock lock = this.reftableDatabase.getLock();
        lock.lock();
        try {
            this.reftableStack.compactFully();
            this.reftableDatabase.clearCache();
        } finally {
            lock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ReentrantLock getLock() {
        return this.reftableDatabase.getLock();
    }

    @Override // org.eclipse.jgit.lib.RefDatabase
    public BatchRefUpdate newBatchUpdate() {
        return new FileReftableBatchRefUpdate(this, this.fileRepository);
    }

    @Override // org.eclipse.jgit.lib.RefDatabase
    public RefUpdate newUpdate(String str, boolean z) throws IOException {
        Ref refExactRef = exactRef(str);
        boolean z2 = false;
        if (refExactRef == null) {
            refExactRef = new ObjectIdRef.Unpeeled(Ref.Storage.NEW, str, null);
        } else if (z && refExactRef.isSymbolic()) {
            z2 = true;
        }
        FileReftableRefUpdate fileReftableRefUpdate = new FileReftableRefUpdate(refExactRef);
        if (z2) {
            fileReftableRefUpdate.setDetachingSymbolicRef();
        }
        return fileReftableRefUpdate;
    }

    @Override // org.eclipse.jgit.lib.RefDatabase
    public Ref exactRef(String str) throws IOException {
        return this.reftableDatabase.exactRef(str);
    }

    @Override // org.eclipse.jgit.lib.RefDatabase
    public List<Ref> getRefs() throws IOException {
        return super.getRefs();
    }

    @Override // org.eclipse.jgit.lib.RefDatabase
    public Map<String, Ref> getRefs(String str) throws IOException {
        List<Ref> refsByPrefix = this.reftableDatabase.getRefsByPrefix(str);
        RefList.Builder builder = new RefList.Builder(refsByPrefix.size());
        Iterator<Ref> it = refsByPrefix.iterator();
        while (it.hasNext()) {
            builder.add(it.next());
        }
        return new RefMap(str, builder.toRefList(), RefList.emptyList(), RefList.emptyList());
    }

    @Override // org.eclipse.jgit.lib.RefDatabase
    public List<Ref> getRefsByPrefixWithExclusions(String str, Set<String> set) throws IOException {
        return this.reftableDatabase.getRefsByPrefixWithExclusions(str, set);
    }

    @Override // org.eclipse.jgit.lib.RefDatabase
    public List<Ref> getAdditionalRefs() throws IOException {
        return Collections.emptyList();
    }

    @Override // org.eclipse.jgit.lib.RefDatabase
    public Ref peel(Ref ref) throws IOException {
        Ref leaf = ref.getLeaf();
        return (leaf.isPeeled() || leaf.getObjectId() == null) ? ref : recreate(ref, doPeel(leaf), hasVersioning());
    }

    private Ref doPeel(Ref ref) throws IOException {
        Throwable th = null;
        try {
            RevWalk revWalk = new RevWalk(this.fileRepository);
            try {
                RevObject any = revWalk.parseAny(ref.getObjectId());
                if (any instanceof RevTag) {
                    return new ObjectIdRef.PeeledTag(ref.getStorage(), ref.getName(), ref.getObjectId(), revWalk.peel(any).copy(), hasVersioning() ? ref.getUpdateIndex() : -1L);
                }
                Ref.Storage storage = ref.getStorage();
                String name = ref.getName();
                long updateIndex = -1;
                ObjectId objectId = ref.getObjectId();
                if (hasVersioning()) {
                    updateIndex = ref.getUpdateIndex();
                }
                return new ObjectIdRef.PeeledNonTag(storage, name, objectId, updateIndex);
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

    private static Ref recreate(Ref ref, Ref ref2, boolean z) {
        if (!ref.isSymbolic()) {
            return ref2;
        }
        return new SymbolicRef(ref.getName(), recreate(ref.getTarget(), ref2, z), z ? ref.getUpdateIndex() : -1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    class FileRefRename extends RefRename {
        FileRefRename(RefUpdate refUpdate, RefUpdate refUpdate2) {
            super(refUpdate, refUpdate2);
        }

        void writeRename(ReftableWriter reftableWriter) throws IOException {
            long jNextUpdateIndex = FileReftableDatabase.this.reftableDatabase.nextUpdateIndex();
            reftableWriter.setMinUpdateIndex(jNextUpdateIndex).setMaxUpdateIndex(jNextUpdateIndex).begin();
            ArrayList arrayList = new ArrayList(3);
            Ref ref = this.destination.getRef();
            Ref refExactRef = FileReftableDatabase.this.exactRef("HEAD");
            if (refExactRef != null && refExactRef.isSymbolic() && refExactRef.getLeaf().getName().equals(this.source.getName())) {
                arrayList.add(new SymbolicRef("HEAD", ref, jNextUpdateIndex));
            }
            ObjectId objectId = this.source.getRef().getObjectId();
            arrayList.add(new ObjectIdRef.PeeledNonTag(Ref.Storage.NEW, this.destination.getName(), objectId));
            arrayList.add(new ObjectIdRef.Unpeeled(Ref.Storage.NEW, this.source.getName(), null));
            reftableWriter.sortAndWriteRefs(arrayList);
            PersonIdent refLogIdent = this.destination.getRefLogIdent();
            if (refLogIdent == null) {
                refLogIdent = new PersonIdent(FileReftableDatabase.this.fileRepository);
            }
            PersonIdent personIdent = refLogIdent;
            if (this.destination.getRefLogMessage().isEmpty()) {
                return;
            }
            List<String> list = (List) arrayList.stream().map(new FileReftableDatabase$FileRefRename$$ExternalSyntheticLambda1()).collect(Collectors.toList());
            Collections.sort(list);
            for (String str : list) {
                reftableWriter.writeLog(str, jNextUpdateIndex, personIdent, ("HEAD".equals(str) || str.equals(this.source.getName())) ? objectId : ObjectId.zeroId(), ("HEAD".equals(str) || str.equals(this.destination.getName())) ? objectId : ObjectId.zeroId(), this.destination.getRefLogMessage());
            }
        }

        @Override // org.eclipse.jgit.lib.RefRename
        protected RefUpdate.Result doRename() throws IOException {
            Ref refExactRef = FileReftableDatabase.this.exactRef(this.source.getName());
            if (FileReftableDatabase.this.exactRef(this.destination.getName()) != null || refExactRef == null || !this.source.getOldObjectId().equals((AnyObjectId) refExactRef.getObjectId())) {
                return RefUpdate.Result.LOCK_FAILURE;
            }
            if (refExactRef.isSymbolic()) {
                return RefUpdate.Result.IO_FAILURE;
            }
            if (!FileReftableDatabase.this.addReftable(new FileReftableDatabase$FileRefRename$$ExternalSyntheticLambda0(this))) {
                return RefUpdate.Result.LOCK_FAILURE;
            }
            return RefUpdate.Result.RENAMED;
        }
    }

    @Override // org.eclipse.jgit.lib.RefDatabase
    public RefRename newRename(String str, String str2) throws IOException {
        return new FileRefRename(newUpdate(str, true), newUpdate(str2, true));
    }

    @Override // org.eclipse.jgit.lib.RefDatabase
    public boolean isNameConflicting(String str) throws IOException {
        return this.reftableDatabase.isNameConflicting(str, new TreeSet<>(), new HashSet());
    }

    @Override // org.eclipse.jgit.lib.RefDatabase
    public void close() {
        this.reftableStack.close();
    }

    @Override // org.eclipse.jgit.lib.RefDatabase
    public void create() throws IOException {
        FileUtils.mkdir(new File(this.fileRepository.getCommonDirectory(), "reftable"), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean addReftable(FileReftableStack.Writer writer) throws IOException {
        if (!this.reftableStack.addReftable(writer)) {
            this.reftableStack.reload();
            this.reftableDatabase.clearCache();
            return false;
        }
        this.reftableDatabase.clearCache();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    class FileReftableBatchRefUpdate extends ReftableBatchRefUpdate {
        FileReftableBatchRefUpdate(FileReftableDatabase fileReftableDatabase, Repository repository) {
            super(fileReftableDatabase, fileReftableDatabase.reftableDatabase, fileReftableDatabase.getLock(), repository);
        }

        @Override // org.eclipse.jgit.internal.storage.reftable.ReftableBatchRefUpdate
        protected void applyUpdates(List<Ref> list, List<ReceiveCommand> list2) throws IOException {
            if (FileReftableDatabase.this.addReftable(new FileReftableDatabase$FileReftableBatchRefUpdate$$ExternalSyntheticLambda0(this, list, list2))) {
                return;
            }
            for (ReceiveCommand receiveCommand : list2) {
                if (receiveCommand.getResult() == ReceiveCommand.Result.NOT_ATTEMPTED) {
                    receiveCommand.setResult(RefUpdate.Result.LOCK_FAILURE);
                }
            }
        }

        /* JADX INFO: renamed from: lambda$0$org-eclipse-jgit-internal-storage-file-FileReftableDatabase$FileReftableBatchRefUpdate, reason: not valid java name */
        /* synthetic */ void m5689xc260f837(List list, List list2, ReftableWriter reftableWriter) throws IOException {
            write(reftableWriter, list, list2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class FileReftableRefUpdate extends RefUpdate {
        private Ref dstRef;
        private RevWalk rw;

        @Override // org.eclipse.jgit.lib.RefUpdate
        protected void unlock() {
        }

        FileReftableRefUpdate(Ref ref) {
            super(ref);
        }

        @Override // org.eclipse.jgit.lib.RefUpdate
        protected RefDatabase getRefDatabase() {
            return FileReftableDatabase.this;
        }

        @Override // org.eclipse.jgit.lib.RefUpdate
        protected Repository getRepository() {
            return FileReftableDatabase.this.fileRepository;
        }

        @Override // org.eclipse.jgit.lib.RefUpdate
        public RefUpdate.Result update(RevWalk revWalk) throws IOException {
            try {
                this.rw = revWalk;
                return super.update(revWalk);
            } finally {
                this.rw = null;
            }
        }

        @Override // org.eclipse.jgit.lib.RefUpdate
        protected boolean tryLock(boolean z) throws IOException {
            Ref ref = getRef();
            this.dstRef = ref;
            if (z) {
                this.dstRef = ref.getLeaf();
            }
            Ref refExactRef = FileReftableDatabase.this.exactRef(this.dstRef.getName());
            if (refExactRef == null) {
                return true;
            }
            setOldObjectId(refExactRef.getObjectId());
            return true;
        }

        /* JADX WARN: Code duplicated, block: B:9:0x003c  */
        void writeUpdate(ReftableWriter reftableWriter) throws IOException {
            Ref peeledNonTag;
            if (this.rw == null || ObjectId.zeroId().equals((AnyObjectId) getNewObjectId())) {
                peeledNonTag = null;
            } else {
                RevObject any = this.rw.parseAny(getNewObjectId());
                if (any instanceof RevTag) {
                    peeledNonTag = new ObjectIdRef.PeeledTag(Ref.Storage.PACKED, this.dstRef.getName(), getNewObjectId(), this.rw.peel(any).copy());
                } else {
                    peeledNonTag = null;
                }
            }
            if (peeledNonTag == null) {
                peeledNonTag = new ObjectIdRef.PeeledNonTag(Ref.Storage.PACKED, this.dstRef.getName(), getNewObjectId());
            }
            long jNextUpdateIndex = FileReftableDatabase.this.reftableDatabase.nextUpdateIndex();
            reftableWriter.setMinUpdateIndex(jNextUpdateIndex).setMaxUpdateIndex(jNextUpdateIndex).begin().writeRef(peeledNonTag);
            ObjectId oldObjectId = getOldObjectId();
            if (oldObjectId == null) {
                oldObjectId = ObjectId.zeroId();
            }
            reftableWriter.writeLog(this.dstRef.getName(), jNextUpdateIndex, getRefLogIdent(), oldObjectId, getNewObjectId(), getRefLogMessage());
        }

        @Override // org.eclipse.jgit.lib.RefUpdate
        public PersonIdent getRefLogIdent() {
            PersonIdent refLogIdent = super.getRefLogIdent();
            return refLogIdent == null ? new PersonIdent(getRepository()) : refLogIdent;
        }

        void writeDelete(ReftableWriter reftableWriter) throws IOException {
            ObjectIdRef.Unpeeled unpeeled = new ObjectIdRef.Unpeeled(Ref.Storage.NEW, this.dstRef.getName(), null);
            long jNextUpdateIndex = FileReftableDatabase.this.reftableDatabase.nextUpdateIndex();
            reftableWriter.setMinUpdateIndex(jNextUpdateIndex).setMaxUpdateIndex(jNextUpdateIndex).begin().writeRef(unpeeled);
            ObjectId objectIdZeroId = ObjectId.zeroId();
            Ref refExactRef = FileReftableDatabase.this.exactRef(this.dstRef.getName());
            if (refExactRef != null) {
                Ref leaf = refExactRef.getLeaf();
                if (leaf.getObjectId() != null) {
                    objectIdZeroId = leaf.getObjectId();
                }
            }
            reftableWriter.writeLog(this.dstRef.getName(), jNextUpdateIndex, getRefLogIdent(), objectIdZeroId, ObjectId.zeroId(), getRefLogMessage());
        }

        @Override // org.eclipse.jgit.lib.RefUpdate
        protected RefUpdate.Result doUpdate(RefUpdate.Result result) throws IOException {
            if (isRefLogIncludingResult()) {
                setRefLogMessage(getRefLogMessage() + ": " + result.toString(), false);
            }
            return !FileReftableDatabase.this.addReftable(new FileReftableDatabase$FileReftableRefUpdate$$ExternalSyntheticLambda0(this)) ? RefUpdate.Result.LOCK_FAILURE : result;
        }

        @Override // org.eclipse.jgit.lib.RefUpdate
        protected RefUpdate.Result doDelete(RefUpdate.Result result) throws IOException {
            if (isRefLogIncludingResult()) {
                setRefLogMessage(getRefLogMessage() + ": " + result.toString(), false);
            }
            return !FileReftableDatabase.this.addReftable(new FileReftableDatabase$FileReftableRefUpdate$$ExternalSyntheticLambda1(this)) ? RefUpdate.Result.LOCK_FAILURE : result;
        }

        void writeLink(ReftableWriter reftableWriter) throws IOException {
            long jNextUpdateIndex = FileReftableDatabase.this.reftableDatabase.nextUpdateIndex();
            reftableWriter.setMinUpdateIndex(jNextUpdateIndex).setMaxUpdateIndex(jNextUpdateIndex).begin().writeRef(this.dstRef);
            ObjectId objectIdZeroId = ObjectId.zeroId();
            Ref refExactRef = FileReftableDatabase.this.exactRef(this.dstRef.getName());
            if (refExactRef != null) {
                Ref leaf = refExactRef.getLeaf();
                if (leaf.getObjectId() != null) {
                    objectIdZeroId = leaf.getObjectId();
                }
            }
            ObjectId objectId = objectIdZeroId;
            Ref leaf2 = this.dstRef.getLeaf();
            ObjectId objectIdZeroId2 = ObjectId.zeroId();
            if (leaf2.getObjectId() != null) {
                objectIdZeroId2 = leaf2.getObjectId();
            }
            reftableWriter.writeLog(this.dstRef.getName(), jNextUpdateIndex, getRefLogIdent(), objectId, objectIdZeroId2, getRefLogMessage());
        }

        @Override // org.eclipse.jgit.lib.RefUpdate
        protected RefUpdate.Result doLink(String str) throws IOException {
            if (isRefLogIncludingResult()) {
                setRefLogMessage(getRefLogMessage() + ": " + RefUpdate.Result.FORCED.toString(), false);
            }
            boolean z = FileReftableDatabase.this.exactRef(getName()) != null;
            this.dstRef = new SymbolicRef(getName(), new ObjectIdRef.Unpeeled(Ref.Storage.NEW, str, null), FileReftableDatabase.this.reftableDatabase.nextUpdateIndex());
            if (FileReftableDatabase.this.addReftable(new FileReftableDatabase$FileReftableRefUpdate$$ExternalSyntheticLambda2(this))) {
                return z ? RefUpdate.Result.FORCED : RefUpdate.Result.NEW;
            }
            return RefUpdate.Result.LOCK_FAILURE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void writeConvertTable(Repository repository, ReftableWriter reftableWriter, boolean z) throws IOException {
        List<Ref> refs = repository.getRefDatabase().getRefs();
        int iMax = 0;
        if (z) {
            Iterator<Ref> it = refs.iterator();
            while (it.hasNext()) {
                ReflogReader reflogReader = repository.getReflogReader(it.next().getName());
                if (reflogReader != null) {
                    iMax = Math.max(reflogReader.getReverseEntries().size(), iMax);
                }
            }
        }
        int i = iMax;
        reftableWriter.setMinUpdateIndex(1L).setMaxUpdateIndex(i + 1).begin();
        Throwable th = null;
        try {
            RevWalk revWalk = new RevWalk(repository);
            try {
                ArrayList arrayList = new ArrayList(refs.size());
                Iterator<Ref> it2 = refs.iterator();
                while (it2.hasNext()) {
                    arrayList.add(refForWrite(revWalk, it2.next()));
                }
                reftableWriter.sortAndWriteRefs(arrayList);
                revWalk.close();
                if (z) {
                    for (Ref ref : refs) {
                        long j = i;
                        ReflogReader reflogReader2 = repository.getReflogReader(ref.getName());
                        if (reflogReader2 != null) {
                            long j2 = j;
                            for (ReflogEntry reflogEntry : reflogReader2.getReverseEntries()) {
                                reftableWriter.writeLog(ref.getName(), j2, reflogEntry.getWho(), reflogEntry.getOldId(), reflogEntry.getNewId(), reflogEntry.getComment());
                                j2--;
                            }
                        }
                    }
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
                th.addSuppressed(th3);
            }
            throw null;
        }
    }

    private static Ref refForWrite(RevWalk revWalk, Ref ref) throws IOException {
        RevObject revObjectPeel = null;
        if (ref.isSymbolic()) {
            return new SymbolicRef(ref.getName(), new ObjectIdRef.Unpeeled(Ref.Storage.NEW, ref.getTarget().getName(), null));
        }
        ObjectId objectId = ref.getObjectId();
        try {
            RevObject any = revWalk.parseAny(objectId);
            if (any instanceof RevTag) {
                revObjectPeel = revWalk.peel(any);
            }
        } catch (MissingObjectException unused) {
        }
        if (revObjectPeel != null) {
            return new ObjectIdRef.PeeledTag(Ref.Storage.PACKED, ref.getName(), objectId, revObjectPeel.copy());
        }
        return new ObjectIdRef.PeeledNonTag(Ref.Storage.PACKED, ref.getName(), objectId);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static FileReftableDatabase convertFrom(FileRepository fileRepository, boolean z) throws IOException {
        File file = null;
        Object[] objArr = 0;
        try {
            File file2 = new File(fileRepository.getCommonDirectory(), "reftable");
            File file3 = new File(file2, Constants.TABLES_LIST);
            try {
                if (!file2.isDirectory()) {
                    file2.mkdir();
                }
                try {
                    FileReftableStack fileReftableStack = new FileReftableStack(file3, file2, null, new FileReftableDatabase$$ExternalSyntheticLambda0(fileRepository));
                    try {
                        fileReftableStack.addReftable(new FileReftableDatabase$$ExternalSyntheticLambda1(fileRepository, z));
                        return null;
                    } finally {
                        fileReftableStack.close();
                    }
                } catch (Throwable th) {
                    if (0 == 0) {
                        throw th;
                    }
                    if (null != th) {
                        (objArr == true ? 1 : 0).addSuppressed(th);
                    }
                    throw null;
                }
            } catch (Throwable th2) {
                th = th2;
                file = file3;
                if (file != null) {
                    file.delete();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
