package org.eclipse.jgit.internal.storage.dfs;

import java.io.IOException;
import org.eclipse.jgit.lib.ObjectIdRef;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.RefUpdate;
import org.eclipse.jgit.lib.SymbolicRef;
import org.eclipse.jgit.revwalk.RevObject;
import org.eclipse.jgit.revwalk.RevTag;
import org.eclipse.jgit.revwalk.RevWalk;

/* INFO: loaded from: classes5.dex */
final class DfsRefUpdate extends RefUpdate {
    private Ref dstRef;
    private final DfsRefDatabase refdb;
    private RevWalk rw;

    @Override // org.eclipse.jgit.lib.RefUpdate
    protected void unlock() {
    }

    DfsRefUpdate(DfsRefDatabase dfsRefDatabase, Ref ref) {
        super(ref);
        this.refdb = dfsRefDatabase;
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // org.eclipse.jgit.lib.RefUpdate
    public DfsRefDatabase getRefDatabase() {
        return this.refdb;
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // org.eclipse.jgit.lib.RefUpdate
    public DfsRepository getRepository() {
        return this.refdb.getRepository();
    }

    @Override // org.eclipse.jgit.lib.RefUpdate
    protected boolean tryLock(boolean z) throws IOException {
        Ref ref = getRef();
        this.dstRef = ref;
        if (z) {
            this.dstRef = ref.getLeaf();
        }
        if (this.dstRef.isSymbolic()) {
            setOldObjectId(null);
            return true;
        }
        setOldObjectId(this.dstRef.getObjectId());
        return true;
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
    protected RefUpdate.Result doUpdate(RefUpdate.Result result) throws IOException {
        Ref peeledNonTag;
        RevObject any = this.rw.parseAny(getNewObjectId());
        if (any instanceof RevTag) {
            peeledNonTag = new ObjectIdRef.PeeledTag(Ref.Storage.PACKED, this.dstRef.getName(), getNewObjectId(), this.rw.peel(any).copy());
        } else {
            peeledNonTag = new ObjectIdRef.PeeledNonTag(Ref.Storage.PACKED, this.dstRef.getName(), getNewObjectId());
        }
        if (getRefDatabase().compareAndPut(this.dstRef, peeledNonTag)) {
            getRefDatabase().stored(peeledNonTag);
            return result;
        }
        return RefUpdate.Result.LOCK_FAILURE;
    }

    @Override // org.eclipse.jgit.lib.RefUpdate
    protected RefUpdate.Result doDelete(RefUpdate.Result result) throws IOException {
        if (getRefDatabase().compareAndRemove(this.dstRef)) {
            getRefDatabase().removed(this.dstRef.getName());
            return result;
        }
        return RefUpdate.Result.LOCK_FAILURE;
    }

    @Override // org.eclipse.jgit.lib.RefUpdate
    protected RefUpdate.Result doLink(String str) throws IOException {
        SymbolicRef symbolicRef = new SymbolicRef(this.dstRef.getName(), new ObjectIdRef.Unpeeled(Ref.Storage.NEW, str, null));
        if (getRefDatabase().compareAndPut(this.dstRef, symbolicRef)) {
            getRefDatabase().stored(symbolicRef);
            if (this.dstRef.getStorage() == Ref.Storage.NEW) {
                return RefUpdate.Result.NEW;
            }
            return RefUpdate.Result.FORCED;
        }
        return RefUpdate.Result.LOCK_FAILURE;
    }
}
