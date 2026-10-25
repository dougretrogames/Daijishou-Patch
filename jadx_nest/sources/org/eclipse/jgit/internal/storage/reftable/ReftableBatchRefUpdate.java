package org.eclipse.jgit.internal.storage.reftable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.locks.Lock;
import java.util.stream.Collectors;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.BatchRefUpdate;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectIdRef;
import org.eclipse.jgit.lib.PersonIdent;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.RefDatabase;
import org.eclipse.jgit.lib.ReflogEntry;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.SymbolicRef;
import org.eclipse.jgit.revwalk.RevObject;
import org.eclipse.jgit.revwalk.RevTag;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.transport.ReceiveCommand;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ReftableBatchRefUpdate extends BatchRefUpdate {
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$transport$ReceiveCommand$Type;
    private final Lock lock;
    private final ReftableDatabase refDb;
    private final Repository repository;

    protected abstract void applyUpdates(List<Ref> list, List<ReceiveCommand> list2) throws IOException;

    static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$transport$ReceiveCommand$Type() {
        int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$transport$ReceiveCommand$Type;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[ReceiveCommand.Type.valuesCustom().length];
        try {
            iArr2[ReceiveCommand.Type.CREATE.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[ReceiveCommand.Type.DELETE.ordinal()] = 4;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[ReceiveCommand.Type.UPDATE.ordinal()] = 2;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[ReceiveCommand.Type.UPDATE_NONFASTFORWARD.ordinal()] = 3;
        } catch (NoSuchFieldError unused4) {
        }
        $SWITCH_TABLE$org$eclipse$jgit$transport$ReceiveCommand$Type = iArr2;
        return iArr2;
    }

    protected ReftableBatchRefUpdate(RefDatabase refDatabase, ReftableDatabase reftableDatabase, Lock lock, Repository repository) {
        super(refDatabase);
        this.refDb = reftableDatabase;
        this.lock = lock;
        this.repository = repository;
    }

    @Override // org.eclipse.jgit.lib.BatchRefUpdate
    public void execute(RevWalk revWalk, ProgressMonitor progressMonitor, List<String> list) {
        List<ReceiveCommand> pending = getPending();
        if (pending.isEmpty()) {
            return;
        }
        if (list != null) {
            setPushOptions(list);
        }
        try {
            if (checkObjectExistence(revWalk, pending) && checkNonFastForwards(revWalk, getPending())) {
                pending = getPending();
                this.lock.lock();
                try {
                    if (checkExpected(pending) && checkConflicting(getPending())) {
                        pending = getPending();
                        if (blockUntilTimestamps(MAX_WAIT)) {
                            applyUpdates(toNewRefs(revWalk, pending), pending);
                            for (ReceiveCommand receiveCommand : pending) {
                                if (receiveCommand.getResult() == ReceiveCommand.Result.NOT_ATTEMPTED) {
                                    receiveCommand.setResult(ReceiveCommand.Result.OK);
                                }
                            }
                        }
                    }
                    this.lock.unlock();
                } catch (Throwable th) {
                    this.lock.unlock();
                    throw th;
                }
            }
        } catch (IOException unused) {
            pending.get(0).setResult(ReceiveCommand.Result.LOCK_FAILURE, "io error");
            ReceiveCommand.abort(pending);
        }
    }

    private List<ReceiveCommand> getPending() {
        return ReceiveCommand.filter(getCommands(), ReceiveCommand.Result.NOT_ATTEMPTED);
    }

    private boolean checkObjectExistence(RevWalk revWalk, List<ReceiveCommand> list) throws IOException {
        for (ReceiveCommand receiveCommand : list) {
            try {
                if (!receiveCommand.getNewId().equals((AnyObjectId) ObjectId.zeroId())) {
                    revWalk.parseAny(receiveCommand.getNewId());
                }
            } catch (MissingObjectException unused) {
                receiveCommand.setResult(ReceiveCommand.Result.REJECTED_MISSING_OBJECT);
                if (isAtomic()) {
                    ReceiveCommand.abort(list);
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkNonFastForwards(RevWalk revWalk, List<ReceiveCommand> list) throws IOException {
        if (isAllowNonFastForwards()) {
            return true;
        }
        for (ReceiveCommand receiveCommand : list) {
            receiveCommand.updateType(revWalk);
            if (receiveCommand.getType() == ReceiveCommand.Type.UPDATE_NONFASTFORWARD) {
                receiveCommand.setResult(ReceiveCommand.Result.REJECTED_NONFASTFORWARD);
                if (isAtomic()) {
                    ReceiveCommand.abort(list);
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkConflicting(List<ReceiveCommand> list) throws IOException {
        TreeSet<String> treeSet = new TreeSet<>();
        Set<String> set = (Set) list.stream().filter(new ReftableBatchRefUpdate$$ExternalSyntheticLambda0()).map(new ReftableBatchRefUpdate$$ExternalSyntheticLambda1()).collect(Collectors.toSet());
        boolean z = true;
        for (ReceiveCommand receiveCommand : list) {
            if (receiveCommand.getType() != ReceiveCommand.Type.DELETE) {
                String refName = receiveCommand.getRefName();
                if (this.refDb.isNameConflicting(refName, treeSet, set)) {
                    if (isAtomic()) {
                        receiveCommand.setResult(ReceiveCommand.Result.REJECTED_OTHER_REASON, JGitText.get().transactionAborted);
                    } else {
                        receiveCommand.setResult(ReceiveCommand.Result.LOCK_FAILURE);
                    }
                    z = false;
                }
                treeSet.add(refName);
            }
        }
        if (isAtomic()) {
            if (!z) {
                list.stream().filter(new ReftableBatchRefUpdate$$ExternalSyntheticLambda2()).forEach(new ReftableBatchRefUpdate$$ExternalSyntheticLambda3());
            }
            return z;
        }
        Iterator<ReceiveCommand> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().getResult() == ReceiveCommand.Result.NOT_ATTEMPTED) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ boolean lambda$0(ReceiveCommand receiveCommand) {
        return receiveCommand.getType() == ReceiveCommand.Type.DELETE;
    }

    static /* synthetic */ boolean lambda$2(ReceiveCommand receiveCommand) {
        return receiveCommand.getResult() == ReceiveCommand.Result.NOT_ATTEMPTED;
    }

    private boolean checkExpected(List<ReceiveCommand> list) throws IOException {
        for (ReceiveCommand receiveCommand : list) {
            if (!matchOld(receiveCommand, this.refDb.exactRef(receiveCommand.getRefName()))) {
                receiveCommand.setResult(ReceiveCommand.Result.LOCK_FAILURE);
                if (isAtomic()) {
                    ReceiveCommand.abort(list);
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean matchOld(ReceiveCommand receiveCommand, @Nullable Ref ref) {
        if (ref == null) {
            return AnyObjectId.isEqual(ObjectId.zeroId(), receiveCommand.getOldId()) && receiveCommand.getOldSymref() == null;
        }
        if (ref.isSymbolic()) {
            return ref.getTarget().getName().equals(receiveCommand.getOldSymref());
        }
        ObjectId objectId = ref.getObjectId();
        if (objectId == null) {
            objectId = ObjectId.zeroId();
        }
        return receiveCommand.getOldId().equals((AnyObjectId) objectId);
    }

    protected void write(ReftableWriter reftableWriter, List<Ref> list, List<ReceiveCommand> list2) throws IOException {
        long jNextUpdateIndex = this.refDb.nextUpdateIndex();
        reftableWriter.setMinUpdateIndex(jNextUpdateIndex).setMaxUpdateIndex(jNextUpdateIndex).begin().sortAndWriteRefs(list);
        if (isRefLogDisabled()) {
            return;
        }
        writeLog(reftableWriter, jNextUpdateIndex, list2);
    }

    private void writeLog(ReftableWriter reftableWriter, long j, List<ReceiveCommand> list) throws IOException {
        String resultString;
        HashMap map = new HashMap();
        ArrayList<String> arrayList = new ArrayList(list.size());
        for (ReceiveCommand receiveCommand : list) {
            ReftableWriter reftableWriter2 = reftableWriter;
            map.put(receiveCommand.getRefName(), receiveCommand);
            arrayList.add(receiveCommand.getRefName());
            reftableWriter = reftableWriter2;
            j = j;
        }
        Collections.sort(arrayList);
        PersonIdent refLogIdent = getRefLogIdent();
        if (refLogIdent == null) {
            refLogIdent = new PersonIdent(this.repository);
        }
        PersonIdent personIdent = refLogIdent;
        for (String str : arrayList) {
            ReceiveCommand receiveCommand2 = (ReceiveCommand) map.get(str);
            if (!isRefLogDisabled(receiveCommand2)) {
                String refLogMessage = getRefLogMessage(receiveCommand2);
                if (isRefLogIncludingResult(receiveCommand2) && (resultString = toResultString(receiveCommand2)) != null) {
                    refLogMessage = refLogMessage.isEmpty() ? resultString : refLogMessage + ": " + resultString;
                }
                reftableWriter.writeLog(str, j, personIdent, receiveCommand2.getOldId(), receiveCommand2.getNewId(), refLogMessage);
            }
        }
    }

    private String toResultString(ReceiveCommand receiveCommand) {
        int i = $SWITCH_TABLE$org$eclipse$jgit$transport$ReceiveCommand$Type()[receiveCommand.getType().ordinal()];
        if (i == 1) {
            return ReflogEntry.PREFIX_CREATED;
        }
        if (i == 2) {
            return isAllowNonFastForwards() ? ReflogEntry.PREFIX_FORCED_UPDATE : ReflogEntry.PREFIX_FAST_FORWARD;
        }
        if (i != 3) {
            return null;
        }
        return ReflogEntry.PREFIX_FORCED_UPDATE;
    }

    private static List<Ref> toNewRefs(RevWalk revWalk, List<ReceiveCommand> list) throws IOException {
        ArrayList arrayList = new ArrayList(list.size());
        for (ReceiveCommand receiveCommand : list) {
            if (receiveCommand.getResult() == ReceiveCommand.Result.NOT_ATTEMPTED) {
                String refName = receiveCommand.getRefName();
                ObjectId newId = receiveCommand.getNewId();
                String newSymref = receiveCommand.getNewSymref();
                if (AnyObjectId.isEqual(ObjectId.zeroId(), newId) && newSymref == null) {
                    arrayList.add(new ObjectIdRef.Unpeeled(Ref.Storage.NEW, refName, null));
                } else if (newSymref != null) {
                    arrayList.add(new SymbolicRef(refName, new ObjectIdRef.Unpeeled(Ref.Storage.NEW, newSymref, null)));
                } else {
                    RevObject any = revWalk.parseAny(newId);
                    RevObject revObjectPeel = any instanceof RevTag ? revWalk.peel(any) : null;
                    if (revObjectPeel != null) {
                        arrayList.add(new ObjectIdRef.PeeledTag(Ref.Storage.PACKED, refName, newId, revObjectPeel.copy()));
                    } else {
                        arrayList.add(new ObjectIdRef.PeeledNonTag(Ref.Storage.PACKED, refName, newId));
                    }
                }
            }
        }
        return arrayList;
    }
}
