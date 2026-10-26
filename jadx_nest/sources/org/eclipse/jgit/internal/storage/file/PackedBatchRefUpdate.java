package org.eclipse.jgit.internal.storage.file;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.errors.LockFailedException;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.BatchRefUpdate;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectIdRef;
import org.eclipse.jgit.lib.PersonIdent;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.ReflogEntry;
import org.eclipse.jgit.revwalk.RevObject;
import org.eclipse.jgit.revwalk.RevTag;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.transport.ReceiveCommand;
import org.eclipse.jgit.util.RefList;

/* INFO: loaded from: classes5.dex */
class PackedBatchRefUpdate extends BatchRefUpdate {
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$transport$ReceiveCommand$Type;
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private RefDirectory refdb;
    private boolean shouldLockLooseRefs;

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

    PackedBatchRefUpdate(RefDirectory refDirectory) {
        this(refDirectory, true);
    }

    PackedBatchRefUpdate(RefDirectory refDirectory, boolean z) {
        super(refDirectory);
        this.refdb = refDirectory;
        this.shouldLockLooseRefs = z;
    }

    /* WARN: Code duplicated, block: B:85:0x0143 A[Catch: all -> 0x014e, TRY_LEAVE, TryCatch #10 {all -> 0x014e, blocks: (B:83:0x013e, B:85:0x0143), top: B:105:0x013e }] */
    /* WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class decompiler.core.dex.instructions.args.ArgType$UnknownArg
    	at decompiler.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at decompiler.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at decompiler.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // org.eclipse.jgit.lib.BatchRefUpdate
    public void execute(RevWalk revWalk, ProgressMonitor progressMonitor, List<String> list) throws Throwable {
        LockFile lockFile;
        LockFile lockFile2;
        Map<String, LockFile> mapLockLooseRefs;
        if (!isAtomic()) {
            super.execute(revWalk, progressMonitor, list);
            return;
        }
        List<ReceiveCommand> listFilter = ReceiveCommand.filter(getCommands(), ReceiveCommand.Result.NOT_ATTEMPTED);
        if (listFilter.isEmpty()) {
            return;
        }
        if (listFilter.size() == 1) {
            super.execute(revWalk, progressMonitor, list);
            return;
        }
        if (containsSymrefs(listFilter)) {
            reject(listFilter.get(0), ReceiveCommand.Result.REJECTED_OTHER_REASON, JGitText.get().atomicSymRefNotSupported, listFilter);
            return;
        }
        if (!blockUntilTimestamps(MAX_WAIT)) {
            return;
        }
        if (list != null) {
            setPushOptions(list);
        }
        if (!checkConflictingNames(listFilter) || !checkObjectExistence(revWalk, listFilter) || !checkNonFastForwards(revWalk, listFilter)) {
            return;
        }
        try {
            this.refdb.pack((List<String>) listFilter.stream().map(new PackedBatchRefUpdate$$ExternalSyntheticLambda0()).collect(Collectors.toList()));
            this.refdb.inProcessPackedRefsLock.lock();
            Map<String, LockFile> map = null;
            lockFileLockPackedRefsOrThrow = null;
            LockFile lockFileLockPackedRefsOrThrow = null;
            map = null;
            try {
                if (this.refdb.isInClone() || !this.shouldLockLooseRefs) {
                    mapLockLooseRefs = null;
                } else {
                    mapLockLooseRefs = lockLooseRefs(listFilter);
                    if (mapLockLooseRefs == null) {
                        try {
                            unlockAll(mapLockLooseRefs);
                            return;
                        } finally {
                            this.refdb.inProcessPackedRefsLock.unlock();
                        }
                    }
                    try {
                        this.refdb.pack(mapLockLooseRefs);
                    } catch (LockFailedException unused) {
                        lockFile2 = lockFileLockPackedRefsOrThrow;
                        map = mapLockLooseRefs;
                        try {
                            lockFailure(listFilter.get(0), listFilter);
                            try {
                                unlockAll(map);
                                if (lockFile2 != null) {
                                    lockFile2.unlock();
                                }
                                return;
                            } finally {
                                this.refdb.inProcessPackedRefsLock.unlock();
                            }
                        } catch (Throwable th) {
                            lockFile = lockFile2;
                            th = th;
                            try {
                                unlockAll(map);
                                if (lockFile != null) {
                                    lockFile.unlock();
                                }
                                throw th;
                            } finally {
                                this.refdb.inProcessPackedRefsLock.unlock();
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        Map<String, LockFile> map2 = mapLockLooseRefs;
                        lockFile = lockFileLockPackedRefsOrThrow;
                        map = map2;
                        unlockAll(map);
                        if (lockFile != null) {
                            lockFile.unlock();
                        }
                        throw th;
                    }
                }
                lockFileLockPackedRefsOrThrow = this.refdb.lockPackedRefsOrThrow();
                RefDirectory.PackedRefList packedRefListRefreshPackedRefs = this.refdb.refreshPackedRefs();
                RefList<Ref> refListApplyUpdates = applyUpdates(revWalk, packedRefListRefreshPackedRefs, listFilter);
                if (refListApplyUpdates == null) {
                    try {
                        unlockAll(mapLockLooseRefs);
                        if (lockFileLockPackedRefsOrThrow != null) {
                            lockFileLockPackedRefsOrThrow.unlock();
                        }
                        return;
                    } finally {
                        this.refdb.inProcessPackedRefsLock.unlock();
                    }
                }
                this.refdb.commitPackedRefs(lockFileLockPackedRefsOrThrow, refListApplyUpdates, packedRefListRefreshPackedRefs, true);
                try {
                    unlockAll(mapLockLooseRefs);
                    if (lockFileLockPackedRefsOrThrow != null) {
                        lockFileLockPackedRefsOrThrow.unlock();
                    }
                    this.refdb.inProcessPackedRefsLock.unlock();
                    this.refdb.fireRefsChanged();
                    listFilter.forEach(new PackedBatchRefUpdate$$ExternalSyntheticLambda1());
                    writeReflog(listFilter);
                } catch (Throwable th3) {
                    this.refdb.inProcessPackedRefsLock.unlock();
                    throw th3;
                }
            } catch (LockFailedException unused2) {
                lockFile2 = null;
            } catch (Throwable th4) {
                th = th4;
                lockFile = null;
            }
        } catch (LockFailedException unused3) {
            lockFailure(listFilter.get(0), listFilter);
        }
    }

    private static boolean containsSymrefs(List<ReceiveCommand> list) {
        for (ReceiveCommand receiveCommand : list) {
            if (receiveCommand.getOldSymref() != null || receiveCommand.getNewSymref() != null) {
                return true;
            }
        }
        return false;
    }

    private boolean checkConflictingNames(List<ReceiveCommand> list) throws IOException {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        for (ReceiveCommand receiveCommand : list) {
            if (receiveCommand.getType() != ReceiveCommand.Type.DELETE) {
                hashSet.add(receiveCommand.getRefName());
                addPrefixesTo(receiveCommand.getRefName(), hashSet2);
            } else {
                hashSet3.add(receiveCommand.getRefName());
            }
        }
        for (String str : this.refdb.getRefs("").keySet()) {
            if (!hashSet3.contains(str)) {
                hashSet.add(str);
                addPrefixesTo(str, hashSet2);
            }
        }
        for (ReceiveCommand receiveCommand2 : list) {
            if (receiveCommand2.getType() != ReceiveCommand.Type.DELETE && hashSet2.contains(receiveCommand2.getRefName())) {
                lockFailure(receiveCommand2, list);
                return false;
            }
            Iterator<String> it = getPrefixes(receiveCommand2.getRefName()).iterator();
            while (it.hasNext()) {
                if (hashSet.contains(it.next())) {
                    lockFailure(receiveCommand2, list);
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkObjectExistence(RevWalk revWalk, List<ReceiveCommand> list) throws IOException {
        for (ReceiveCommand receiveCommand : list) {
            try {
                if (!receiveCommand.getNewId().equals((AnyObjectId) ObjectId.zeroId())) {
                    revWalk.parseAny(receiveCommand.getNewId());
                }
            } catch (MissingObjectException unused) {
                reject(receiveCommand, ReceiveCommand.Result.REJECTED_MISSING_OBJECT, list);
                return false;
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
                reject(receiveCommand, ReceiveCommand.Result.REJECTED_NONFASTFORWARD, list);
                return false;
            }
        }
        return true;
    }

    @Nullable
    private Map<String, LockFile> lockLooseRefs(List<ReceiveCommand> list) throws IOException {
        ReceiveCommand next;
        LockFile lockFile;
        HashMap map = new HashMap();
        try {
            Iterator<Integer> it = this.refdb.getRetrySleepMs().iterator();
            ReceiveCommand receiveCommand = null;
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                unlockAll(map);
                map.clear();
                RefDirectory.sleep(iIntValue);
                Iterator<ReceiveCommand> it2 = list.iterator();
                do {
                    if (it2.hasNext()) {
                        next = it2.next();
                        String refName = next.getRefName();
                        lockFile = new LockFile(this.refdb.fileFor(refName));
                        if (map.put(refName, lockFile) != null) {
                            throw new IOException(MessageFormat.format(JGitText.get().duplicateRef, refName));
                        }
                    } else {
                        unlockAll(null);
                        return map;
                    }
                } while (lockFile.lock());
                receiveCommand = next;
            }
            unlockAll(map);
            if (receiveCommand == null) {
                receiveCommand = list.get(0);
            }
            lockFailure(receiveCommand, list);
            return null;
        } catch (Throwable th) {
            unlockAll(map);
            throw th;
        }
    }

    private static RefList<Ref> applyUpdates(RevWalk revWalk, RefList<Ref> refList, List<ReceiveCommand> list) throws IOException {
        int iCompareTo;
        Collections.sort(list, Comparator.comparing(new PackedBatchRefUpdate$$ExternalSyntheticLambda0()));
        Iterator<ReceiveCommand> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i2 = $SWITCH_TABLE$org$eclipse$jgit$transport$ReceiveCommand$Type()[it.next().getType().ordinal()];
            if (i2 == 1) {
                i++;
            } else if (i2 == 4) {
                i--;
            }
        }
        RefList.Builder builder = new RefList.Builder(refList.size() + i);
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 < refList.size() || i4 < list.size()) {
                Ref ref = i3 < refList.size() ? refList.get(i3) : null;
                ReceiveCommand receiveCommand = i4 < list.size() ? list.get(i4) : null;
                if (ref != null && receiveCommand != null) {
                    iCompareTo = ref.getName().compareTo(receiveCommand.getRefName());
                } else if (ref == null) {
                    iCompareTo = 1;
                } else {
                    iCompareTo = receiveCommand == null ? -1 : 0;
                }
                if (iCompareTo < 0) {
                    builder.add(ref);
                } else if (iCompareTo > 0) {
                    if (receiveCommand.getType() != ReceiveCommand.Type.CREATE) {
                        lockFailure(receiveCommand, list);
                        return null;
                    }
                    builder.add(peeledRef(revWalk, receiveCommand));
                    i4++;
                } else {
                    if (!receiveCommand.getOldId().equals((AnyObjectId) ref.getObjectId())) {
                        lockFailure(receiveCommand, list);
                        return null;
                    }
                    if (receiveCommand.getType() != ReceiveCommand.Type.DELETE) {
                        builder.add(peeledRef(revWalk, receiveCommand));
                    }
                    i4++;
                }
                i3++;
            } else {
                return builder.toRefList();
            }
        }
    }

    private void writeReflog(List<ReceiveCommand> list) {
        String resultString;
        PersonIdent refLogIdent = getRefLogIdent();
        if (refLogIdent == null) {
            refLogIdent = new PersonIdent(this.refdb.getRepository());
        }
        PersonIdent personIdent = refLogIdent;
        for (ReceiveCommand receiveCommand : list) {
            if (receiveCommand.getResult() == ReceiveCommand.Result.OK) {
                String refName = receiveCommand.getRefName();
                if (receiveCommand.getType() == ReceiveCommand.Type.DELETE) {
                    try {
                        RefDirectory.delete(this.refdb.logFor(refName), RefDirectory.levelsIn(refName));
                    } catch (IOException unused) {
                    }
                } else if (!isRefLogDisabled(receiveCommand)) {
                    String refLogMessage = getRefLogMessage(receiveCommand);
                    if (isRefLogIncludingResult(receiveCommand) && (resultString = toResultString(receiveCommand)) != null) {
                        refLogMessage = refLogMessage.isEmpty() ? resultString : refLogMessage + ": " + resultString;
                    }
                    new ReflogWriter(this.refdb, isForceRefLog(receiveCommand)).log(refName, receiveCommand.getOldId(), receiveCommand.getNewId(), personIdent, refLogMessage);
                }
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

    private static Ref peeledRef(RevWalk revWalk, ReceiveCommand receiveCommand) throws IOException {
        ObjectId objectIdCopy = receiveCommand.getNewId().copy();
        RevObject any = revWalk.parseAny(objectIdCopy);
        if (any instanceof RevTag) {
            return new ObjectIdRef.PeeledTag(Ref.Storage.PACKED, receiveCommand.getRefName(), objectIdCopy, revWalk.peel(any).copy());
        }
        return new ObjectIdRef.PeeledNonTag(Ref.Storage.PACKED, receiveCommand.getRefName(), objectIdCopy);
    }

    private static void unlockAll(@Nullable Map<?, LockFile> map) {
        if (map != null) {
            map.values().forEach(new PackedBatchRefUpdate$$ExternalSyntheticLambda2());
        }
    }

    private static void lockFailure(ReceiveCommand receiveCommand, List<ReceiveCommand> list) {
        reject(receiveCommand, ReceiveCommand.Result.LOCK_FAILURE, list);
    }

    private static void reject(ReceiveCommand receiveCommand, ReceiveCommand.Result result, List<ReceiveCommand> list) {
        reject(receiveCommand, result, null, list);
    }

    private static void reject(ReceiveCommand receiveCommand, ReceiveCommand.Result result, String str, List<ReceiveCommand> list) {
        receiveCommand.setResult(result, str);
        for (ReceiveCommand receiveCommand2 : list) {
            if (receiveCommand2.getResult() == ReceiveCommand.Result.OK) {
                receiveCommand2.setResult(ReceiveCommand.Result.NOT_ATTEMPTED);
            }
        }
        ReceiveCommand.abort(list);
    }
}
