package org.eclipse.jgit.internal.storage.dfs;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.locks.ReentrantLock;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.internal.storage.reftable.MergedReftable;
import org.eclipse.jgit.internal.storage.reftable.ReftableConfig;
import org.eclipse.jgit.internal.storage.reftable.ReftableDatabase;
import org.eclipse.jgit.lib.BatchRefUpdate;
import org.eclipse.jgit.lib.NullProgressMonitor;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.transport.ReceiveCommand;
import org.eclipse.jgit.util.RefList;
import org.eclipse.jgit.util.RefMap;

/* INFO: loaded from: classes5.dex */
public class DfsReftableDatabase extends DfsRefDatabase {
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$transport$ReceiveCommand$Result;
    private DfsReader ctx;
    final ReftableDatabase reftableDatabase;
    private DfsReftableStack stack;

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsRefDatabase
    protected void cachePeeledState(Ref ref, Ref ref2) {
    }

    protected boolean compactDuringCommit() {
        return true;
    }

    @Override // org.eclipse.jgit.lib.RefDatabase
    public boolean hasVersioning() {
        return true;
    }

    @Override // org.eclipse.jgit.lib.RefDatabase
    public boolean performsAtomicTransactions() {
        return true;
    }

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsRefDatabase
    void removed(String str) {
    }

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsRefDatabase
    void stored(Ref ref) {
    }

    static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$transport$ReceiveCommand$Result() {
        int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$transport$ReceiveCommand$Result;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[ReceiveCommand.Result.valuesCustom().length];
        try {
            iArr2[ReceiveCommand.Result.LOCK_FAILURE.ordinal()] = 8;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[ReceiveCommand.Result.NOT_ATTEMPTED.ordinal()] = 1;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[ReceiveCommand.Result.OK.ordinal()] = 9;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[ReceiveCommand.Result.REJECTED_CURRENT_BRANCH.ordinal()] = 5;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[ReceiveCommand.Result.REJECTED_MISSING_OBJECT.ordinal()] = 6;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[ReceiveCommand.Result.REJECTED_NOCREATE.ordinal()] = 2;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            iArr2[ReceiveCommand.Result.REJECTED_NODELETE.ordinal()] = 3;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            iArr2[ReceiveCommand.Result.REJECTED_NONFASTFORWARD.ordinal()] = 4;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            iArr2[ReceiveCommand.Result.REJECTED_OTHER_REASON.ordinal()] = 7;
        } catch (NoSuchFieldError unused9) {
        }
        $SWITCH_TABLE$org$eclipse$jgit$transport$ReceiveCommand$Result = iArr2;
        return iArr2;
    }

    /* INFO: renamed from: org.eclipse.jgit.internal.storage.dfs.DfsReftableDatabase$1, reason: invalid class name */
    class AnonymousClass1 extends ReftableDatabase {
        AnonymousClass1() {
        }

        @Override // org.eclipse.jgit.internal.storage.reftable.ReftableDatabase
        public MergedReftable openMergedReftable() throws IOException {
            ReentrantLock lock = DfsReftableDatabase.this.getLock();
            lock.lock();
            try {
                return new MergedReftable(DfsReftableDatabase.this.stack().readers());
            } finally {
                lock.unlock();
            }
        }
    }

    protected DfsReftableDatabase(DfsRepository dfsRepository) {
        super(dfsRepository);
        this.reftableDatabase = new AnonymousClass1();
        this.stack = null;
    }

    @Override // org.eclipse.jgit.lib.RefDatabase
    public BatchRefUpdate newBatchUpdate() {
        return new DfsReftableBatchRefUpdate(this, getRepository().getObjectDatabase());
    }

    public ReftableConfig getReftableConfig() {
        return new ReftableConfig(getRepository());
    }

    protected ReentrantLock getLock() {
        return this.reftableDatabase.getLock();
    }

    protected DfsReftableStack stack() throws IOException {
        if (!getLock().isLocked()) {
            throw new IllegalStateException("most hold lock to access stack");
        }
        DfsObjDatabase objectDatabase = getRepository().getObjectDatabase();
        if (this.ctx == null) {
            this.ctx = objectDatabase.newReader();
        }
        if (this.stack == null) {
            this.stack = DfsReftableStack.open(this.ctx, Arrays.asList(objectDatabase.getReftables()));
        }
        return this.stack;
    }

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsRefDatabase, org.eclipse.jgit.lib.RefDatabase
    public boolean isNameConflicting(String str) throws IOException {
        return this.reftableDatabase.isNameConflicting(str, new TreeSet<>(), new HashSet());
    }

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsRefDatabase, org.eclipse.jgit.lib.RefDatabase
    public Ref exactRef(String str) throws IOException {
        return this.reftableDatabase.exactRef(str);
    }

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsRefDatabase, org.eclipse.jgit.lib.RefDatabase
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
    public List<Ref> getRefsByPrefix(String str) throws IOException {
        return this.reftableDatabase.getRefsByPrefix(str);
    }

    @Override // org.eclipse.jgit.lib.RefDatabase
    public List<Ref> getRefsByPrefixWithExclusions(String str, Set<String> set) throws IOException {
        return this.reftableDatabase.getRefsByPrefixWithExclusions(str, set);
    }

    @Override // org.eclipse.jgit.lib.RefDatabase
    public Set<Ref> getTipsWithSha1(ObjectId objectId) throws IOException {
        if (!getReftableConfig().isIndexObjects()) {
            return super.getTipsWithSha1(objectId);
        }
        return this.reftableDatabase.getTipsWithSha1(objectId);
    }

    @Override // org.eclipse.jgit.lib.RefDatabase
    public boolean hasFastTipsWithSha1() throws IOException {
        return this.reftableDatabase.hasFastTipsWithSha1();
    }

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsRefDatabase, org.eclipse.jgit.lib.RefDatabase
    public Ref peel(Ref ref) throws IOException {
        Ref leaf = ref.getLeaf();
        return (leaf.isPeeled() || leaf.getObjectId() == null) ? ref : recreate(ref, doPeel(leaf), hasVersioning());
    }

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsRefDatabase
    boolean exists() throws IOException {
        return getRepository().getObjectDatabase().getReftables().length > 0;
    }

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsRefDatabase
    void clearCache() {
        ReentrantLock lock = getLock();
        lock.lock();
        try {
            DfsReader dfsReader = this.ctx;
            if (dfsReader != null) {
                dfsReader.close();
                this.ctx = null;
            }
            this.reftableDatabase.clearCache();
            DfsReftableStack dfsReftableStack = this.stack;
            if (dfsReftableStack != null) {
                dfsReftableStack.close();
                this.stack = null;
            }
        } finally {
            lock.unlock();
        }
    }

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsRefDatabase
    protected boolean compareAndPut(Ref ref, @Nullable Ref ref2) throws IOException {
        ReceiveCommand command = ReftableDatabase.toCommand(ref, ref2);
        Throwable th = null;
        try {
            RevWalk revWalk = new RevWalk(getRepository());
            try {
                revWalk.setRetainBody(false);
                newBatchUpdate().setAllowNonFastForwards(true).addCommand(command).execute(revWalk, NullProgressMonitor.INSTANCE);
                revWalk.close();
                int i = $SWITCH_TABLE$org$eclipse$jgit$transport$ReceiveCommand$Result()[command.getResult().ordinal()];
                if (i != 7) {
                    return i == 9;
                }
                throw new IOException(command.getMessage());
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

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsRefDatabase
    protected boolean compareAndRemove(Ref ref) throws IOException {
        return compareAndPut(ref, null);
    }

    @Override // org.eclipse.jgit.internal.storage.dfs.DfsRefDatabase
    protected DfsRefDatabase.RefCache scanAllRefs() throws IOException {
        throw new UnsupportedOperationException();
    }
}
