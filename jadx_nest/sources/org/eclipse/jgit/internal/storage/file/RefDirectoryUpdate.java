package org.eclipse.jgit.internal.storage.file;

import java.io.IOException;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.RefUpdate;
import org.eclipse.jgit.lib.ReflogEntry;
import org.eclipse.jgit.lib.Repository;

/* JADX INFO: loaded from: classes5.dex */
class RefDirectoryUpdate extends RefUpdate {
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$lib$RefUpdate$Result;
    private final RefDirectory database;
    private LockFile lock;
    private boolean shouldDeref;

    protected void doAfterLocking(String str) {
    }

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

    RefDirectoryUpdate(RefDirectory refDirectory, Ref ref) {
        super(ref);
        this.database = refDirectory;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.eclipse.jgit.lib.RefUpdate
    public RefDirectory getRefDatabase() {
        return this.database;
    }

    @Override // org.eclipse.jgit.lib.RefUpdate
    protected Repository getRepository() {
        return this.database.getRepository();
    }

    @Override // org.eclipse.jgit.lib.RefUpdate
    protected boolean tryLock(boolean z) throws IOException {
        this.shouldDeref = z;
        Ref ref = getRef();
        if (z) {
            ref = ref.getLeaf();
        }
        String name = ref.getName();
        LockFile lockFile = new LockFile(this.database.fileFor(name));
        this.lock = lockFile;
        if (!lockFile.lock()) {
            return false;
        }
        doAfterLocking(name);
        Ref refFindRef = this.database.findRef(name);
        setOldObjectId(refFindRef != null ? refFindRef.getObjectId() : null);
        return true;
    }

    @Override // org.eclipse.jgit.lib.RefUpdate
    protected void unlock() {
        LockFile lockFile = this.lock;
        if (lockFile != null) {
            lockFile.unlock();
            this.lock = null;
        }
    }

    @Override // org.eclipse.jgit.lib.RefUpdate
    protected RefUpdate.Result doUpdate(RefUpdate.Result result) throws IOException {
        String resultString;
        this.lock.setFSync(((WriteConfig) this.database.getRepository().getConfig().get(WriteConfig.KEY)).getFSyncRefFiles());
        this.lock.setNeedStatInformation(true);
        this.lock.write(getNewObjectId());
        String refLogMessage = getRefLogMessage();
        if (refLogMessage != null) {
            if (isRefLogIncludingResult() && (resultString = toResultString(result)) != null) {
                refLogMessage = refLogMessage.length() > 0 ? refLogMessage + ": " + resultString : resultString;
            }
            this.database.log(isForceRefLog(), this, refLogMessage, this.shouldDeref);
        }
        if (!this.lock.commit()) {
            return RefUpdate.Result.LOCK_FAILURE;
        }
        this.database.stored(this, this.lock.getCommitSnapshot());
        return result;
    }

    private String toResultString(RefUpdate.Result result) {
        int i = $SWITCH_TABLE$org$eclipse$jgit$lib$RefUpdate$Result()[result.ordinal()];
        if (i == 4) {
            return ReflogEntry.PREFIX_CREATED;
        }
        if (i == 5) {
            return ReflogEntry.PREFIX_FORCED_UPDATE;
        }
        if (i != 6) {
            return null;
        }
        return ReflogEntry.PREFIX_FAST_FORWARD;
    }

    @Override // org.eclipse.jgit.lib.RefUpdate
    protected RefUpdate.Result doDelete(RefUpdate.Result result) throws IOException {
        if (getRef().getStorage() != Ref.Storage.NEW) {
            this.database.delete(this);
        }
        return result;
    }

    @Override // org.eclipse.jgit.lib.RefUpdate
    protected RefUpdate.Result doLink(String str) throws IOException {
        this.lock.setFSync(((WriteConfig) this.database.getRepository().getConfig().get(WriteConfig.KEY)).getFSyncRefFiles());
        this.lock.setNeedStatInformation(true);
        this.lock.write(Constants.encode(RefDirectory.SYMREF + str + "\n"));
        String refLogMessage = getRefLogMessage();
        if (refLogMessage != null) {
            this.database.log(isForceRefLog(), this, refLogMessage, false);
        }
        if (!this.lock.commit()) {
            return RefUpdate.Result.LOCK_FAILURE;
        }
        this.database.storedSymbolicRef(this, this.lock.getCommitSnapshot(), str);
        if (getRef().getStorage() == Ref.Storage.NEW) {
            return RefUpdate.Result.NEW;
        }
        return RefUpdate.Result.FORCED;
    }
}
