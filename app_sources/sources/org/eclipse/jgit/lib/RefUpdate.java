package org.eclipse.jgit.lib;

import java.io.IOException;
import java.text.MessageFormat;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevObject;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.transport.PushCertificate;
import org.eclipse.jgit.util.References;

/* INFO: loaded from: classes5.dex */
public abstract class RefUpdate {
    private boolean detachingSymbolicRef;
    private ObjectId expValue;
    private boolean force;
    private boolean forceRefLog;
    private ObjectId newValue;
    private ObjectId oldValue;
    private PushCertificate pushCert;
    private final Ref ref;
    private PersonIdent refLogIdent;
    private boolean refLogIncludeResult;
    private Result result = Result.NOT_ATTEMPTED;
    private boolean checkConflicting = true;
    private String refLogMessage = "";

    public enum Result {
        NOT_ATTEMPTED,
        LOCK_FAILURE,
        NO_CHANGE,
        NEW,
        FORCED,
        FAST_FORWARD,
        REJECTED,
        REJECTED_CURRENT_BRANCH,
        IO_FAILURE,
        RENAMED,
        REJECTED_MISSING_OBJECT,
        REJECTED_OTHER_REASON;

        /* INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static Result[] valuesCustom() {
            Result[] resultArrValuesCustom = values();
            int length = resultArrValuesCustom.length;
            Result[] resultArr = new Result[length];
            System.arraycopy(resultArrValuesCustom, 0, resultArr, 0, length);
            return resultArr;
        }
    }

    protected abstract Result doDelete(Result result) throws IOException;

    protected abstract Result doLink(String str) throws IOException;

    protected abstract Result doUpdate(Result result) throws IOException;

    protected abstract RefDatabase getRefDatabase();

    protected abstract Repository getRepository();

    protected abstract boolean tryLock(boolean z) throws IOException;

    protected abstract void unlock();

    protected RefUpdate(Ref ref) {
        this.ref = ref;
        this.oldValue = ref.getObjectId();
    }

    public String getName() {
        return getRef().getName();
    }

    public Ref getRef() {
        return this.ref;
    }

    public ObjectId getNewObjectId() {
        return this.newValue;
    }

    public void setDetachingSymbolicRef() {
        this.detachingSymbolicRef = true;
    }

    public boolean isDetachingSymbolicRef() {
        return this.detachingSymbolicRef;
    }

    public void setNewObjectId(AnyObjectId anyObjectId) {
        this.newValue = anyObjectId.copy();
    }

    public ObjectId getExpectedOldObjectId() {
        return this.expValue;
    }

    public void setExpectedOldObjectId(AnyObjectId anyObjectId) {
        this.expValue = anyObjectId != null ? anyObjectId.toObjectId() : null;
    }

    public boolean isForceUpdate() {
        return this.force;
    }

    public void setForceUpdate(boolean z) {
        this.force = z;
    }

    public PersonIdent getRefLogIdent() {
        return this.refLogIdent;
    }

    public void setRefLogIdent(PersonIdent personIdent) {
        this.refLogIdent = personIdent;
    }

    public String getRefLogMessage() {
        return this.refLogMessage;
    }

    protected boolean isRefLogIncludingResult() {
        return this.refLogIncludeResult;
    }

    public void setRefLogMessage(String str, boolean z) {
        if (str == null && !z) {
            disableRefLog();
            return;
        }
        if (str == null && z) {
            this.refLogMessage = "";
            this.refLogIncludeResult = true;
        } else {
            this.refLogMessage = str;
            this.refLogIncludeResult = z;
        }
    }

    public void disableRefLog() {
        this.refLogMessage = null;
        this.refLogIncludeResult = false;
    }

    public void setForceRefLog(boolean z) {
        this.forceRefLog = z;
    }

    protected boolean isForceRefLog() {
        return this.forceRefLog;
    }

    public ObjectId getOldObjectId() {
        return this.oldValue;
    }

    protected void setOldObjectId(ObjectId objectId) {
        this.oldValue = objectId;
    }

    public void setPushCertificate(PushCertificate pushCertificate) {
        this.pushCert = pushCertificate;
    }

    protected PushCertificate getPushCertificate() {
        return this.pushCert;
    }

    public Result getResult() {
        return this.result;
    }

    private void requireCanDoUpdate() {
        if (this.newValue == null) {
            throw new IllegalStateException(JGitText.get().aNewObjectIdIsRequired);
        }
    }

    public Result forceUpdate() throws IOException {
        this.force = true;
        return update();
    }

    public Result update() throws IOException {
        Throwable th = null;
        try {
            RevWalk revWalk = new RevWalk(getRepository());
            try {
                revWalk.setRetainBody(false);
                return update(revWalk);
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

    public Result update(RevWalk revWalk) throws IOException {
        requireCanDoUpdate();
        try {
            Result resultUpdateImpl = updateImpl(revWalk, new AnonymousClass1());
            this.result = resultUpdateImpl;
            return resultUpdateImpl;
        } catch (IOException e) {
            this.result = Result.IO_FAILURE;
            throw e;
        }
    }

    /* INFO: renamed from: org.eclipse.jgit.lib.RefUpdate$1, reason: invalid class name */
    class AnonymousClass1 extends Store {
        AnonymousClass1() {
            super(null);
        }

        @Override // org.eclipse.jgit.lib.RefUpdate.Store
        Result execute(Result result) throws IOException {
            return result == Result.NO_CHANGE ? result : RefUpdate.this.doUpdate(result);
        }
    }

    public Result delete() throws IOException {
        Throwable th = null;
        try {
            RevWalk revWalk = new RevWalk(getRepository());
            try {
                revWalk.setRetainBody(false);
                return delete(revWalk);
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

    public Result delete(RevWalk revWalk) throws IOException {
        String name;
        if (this.detachingSymbolicRef) {
            name = getRef().getName();
        } else {
            name = getRef().getLeaf().getName();
        }
        if (name.startsWith(Constants.R_HEADS) && !getRepository().isBare()) {
            Ref refExactRef = getRefDatabase().exactRef("HEAD");
            while (refExactRef != null && refExactRef.isSymbolic()) {
                refExactRef = refExactRef.getTarget();
                if (name.equals(refExactRef.getName())) {
                    Result result = Result.REJECTED_CURRENT_BRANCH;
                    this.result = result;
                    return result;
                }
            }
        }
        try {
            Result resultUpdateImpl = updateImpl(revWalk, new AnonymousClass2());
            this.result = resultUpdateImpl;
            return resultUpdateImpl;
        } catch (IOException e) {
            this.result = Result.IO_FAILURE;
            throw e;
        }
    }

    /* INFO: renamed from: org.eclipse.jgit.lib.RefUpdate$2, reason: invalid class name */
    class AnonymousClass2 extends Store {
        AnonymousClass2() {
            super(null);
        }

        @Override // org.eclipse.jgit.lib.RefUpdate.Store
        Result execute(Result result) throws IOException {
            return RefUpdate.this.doDelete(result);
        }
    }

    public Result link(String str) throws IOException {
        if (!str.startsWith(Constants.R_REFS)) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.get().illegalArgumentNotA, Constants.R_REFS));
        }
        if (this.checkConflicting && getRefDatabase().isNameConflicting(getName())) {
            return Result.LOCK_FAILURE;
        }
        try {
            try {
                if (!tryLock(false)) {
                    Result result = Result.LOCK_FAILURE;
                    unlock();
                    return result;
                }
                Ref refExactRef = getRefDatabase().exactRef(getName());
                if (refExactRef != null && refExactRef.isSymbolic() && str.equals(refExactRef.getTarget().getName())) {
                    Result result2 = Result.NO_CHANGE;
                    this.result = result2;
                    unlock();
                    return result2;
                }
                if (refExactRef != null && refExactRef.getObjectId() != null) {
                    setOldObjectId(refExactRef.getObjectId());
                }
                Ref refExactRef2 = getRefDatabase().exactRef(str);
                if (refExactRef2 != null && refExactRef2.getObjectId() != null) {
                    setNewObjectId(refExactRef2.getObjectId());
                }
                Result resultDoLink = doLink(str);
                this.result = resultDoLink;
                unlock();
                return resultDoLink;
            } catch (IOException e) {
                this.result = Result.IO_FAILURE;
                throw e;
            }
        } catch (Throwable th) {
            unlock();
            throw th;
        }
    }

    private Result updateImpl(RevWalk revWalk, Store store) throws IOException {
        if (this.oldValue == null && this.checkConflicting && getRefDatabase().isNameConflicting(getName())) {
            return Result.LOCK_FAILURE;
        }
        try {
            if (!tryLock(!this.detachingSymbolicRef)) {
                Result result = Result.LOCK_FAILURE;
                unlock();
                return result;
            }
            if (this.expValue != null) {
                ObjectId objectIdZeroId = this.oldValue;
                if (objectIdZeroId == null) {
                    objectIdZeroId = ObjectId.zeroId();
                }
                if (!AnyObjectId.isEqual(this.expValue, objectIdZeroId)) {
                    Result result2 = Result.LOCK_FAILURE;
                    unlock();
                    return result2;
                }
            }
            try {
                RevObject revObjectSafeParseNew = safeParseNew(revWalk, this.newValue);
                ObjectId objectId = this.oldValue;
                if (objectId == null) {
                    Result resultExecute = store.execute(Result.NEW);
                    unlock();
                    return resultExecute;
                }
                RevObject revObjectSafeParseOld = safeParseOld(revWalk, objectId);
                if (References.isSameObject(revObjectSafeParseNew, revObjectSafeParseOld) && !this.detachingSymbolicRef) {
                    Result resultExecute2 = store.execute(Result.NO_CHANGE);
                    unlock();
                    return resultExecute2;
                }
                if (isForceUpdate()) {
                    Result resultExecute3 = store.execute(Result.FORCED);
                    unlock();
                    return resultExecute3;
                }
                if ((revObjectSafeParseNew instanceof RevCommit) && (revObjectSafeParseOld instanceof RevCommit) && revWalk.isMergedInto((RevCommit) revObjectSafeParseOld, (RevCommit) revObjectSafeParseNew)) {
                    Result resultExecute4 = store.execute(Result.FAST_FORWARD);
                    unlock();
                    return resultExecute4;
                }
                Result result3 = Result.REJECTED;
                unlock();
                return result3;
            } catch (MissingObjectException unused) {
                Result result4 = Result.REJECTED_MISSING_OBJECT;
                unlock();
                return result4;
            }
        } catch (Throwable th) {
            unlock();
            throw th;
        }
    }

    public void setCheckConflicting(boolean z) {
        this.checkConflicting = z;
    }

    private static RevObject safeParseNew(RevWalk revWalk, AnyObjectId anyObjectId) throws IOException {
        if (anyObjectId == null || ObjectId.zeroId().equals(anyObjectId)) {
            return null;
        }
        return revWalk.parseAny(anyObjectId);
    }

    private static RevObject safeParseOld(RevWalk revWalk, AnyObjectId anyObjectId) throws IOException {
        if (anyObjectId != null) {
            try {
                return revWalk.parseAny(anyObjectId);
            } catch (MissingObjectException unused) {
            }
        }
        return null;
    }

    private static abstract class Store {
        /* synthetic */ Store(RefUpdateIA refUpdateIA) {
            this();
        }

        abstract Result execute(Result result) throws IOException;

        private Store() {
        }
    }
}
