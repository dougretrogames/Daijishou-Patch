package org.eclipse.jgit.api;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.dircache.DirCache;
import org.eclipse.jgit.dircache.DirCacheBuildIterator;
import org.eclipse.jgit.dircache.DirCacheBuilder;
import org.eclipse.jgit.dircache.DirCacheCheckout;
import org.eclipse.jgit.dircache.DirCacheEntry;
import org.eclipse.jgit.dircache.DirCacheIterator;
import org.eclipse.jgit.errors.CheckoutConflictException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.NullProgressMonitor;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.RefUpdate;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.RepositoryState;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevTree;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.treewalk.AbstractTreeIterator;
import org.eclipse.jgit.treewalk.CanonicalTreeParser;
import org.eclipse.jgit.treewalk.EmptyTreeIterator;
import org.eclipse.jgit.treewalk.TreeWalk;
import org.eclipse.jgit.treewalk.filter.PathFilterGroup;

/* JADX INFO: loaded from: classes5.dex */
public class ResetCommand extends GitCommand<Ref> {
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$api$ResetCommand$ResetType;
    private Collection<String> filepaths;
    private boolean isReflogDisabled;
    private ResetType mode;
    private ProgressMonitor monitor;
    private String ref;

    public enum ResetType {
        SOFT,
        MIXED,
        HARD,
        MERGE,
        KEEP;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static ResetType[] valuesCustom() {
            ResetType[] resetTypeArrValuesCustom = values();
            int length = resetTypeArrValuesCustom.length;
            ResetType[] resetTypeArr = new ResetType[length];
            System.arraycopy(resetTypeArrValuesCustom, 0, resetTypeArr, 0, length);
            return resetTypeArr;
        }
    }

    static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$api$ResetCommand$ResetType() {
        int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$api$ResetCommand$ResetType;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[ResetType.valuesCustom().length];
        try {
            iArr2[ResetType.HARD.ordinal()] = 3;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[ResetType.KEEP.ordinal()] = 5;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[ResetType.MERGE.ordinal()] = 4;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[ResetType.MIXED.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[ResetType.SOFT.ordinal()] = 1;
        } catch (NoSuchFieldError unused5) {
        }
        $SWITCH_TABLE$org$eclipse$jgit$api$ResetCommand$ResetType = iArr2;
        return iArr2;
    }

    public ResetCommand(Repository repository) {
        super(repository);
        this.ref = null;
        this.filepaths = new ArrayList();
        this.monitor = NullProgressMonitor.INSTANCE;
    }

    @Override // org.eclipse.jgit.api.GitCommand, java.util.concurrent.Callable
    public Ref call() throws Throwable {
        checkCallable();
        try {
            RepositoryState repositoryState = this.repo.getRepositoryState();
            boolean z = true;
            boolean z2 = repositoryState.equals(RepositoryState.MERGING) || repositoryState.equals(RepositoryState.MERGING_RESOLVED);
            boolean z3 = repositoryState.equals(RepositoryState.CHERRY_PICKING) || repositoryState.equals(RepositoryState.CHERRY_PICKING_RESOLVED);
            if (!repositoryState.equals(RepositoryState.REVERTING) && !repositoryState.equals(RepositoryState.REVERTING_RESOLVED)) {
                z = false;
            }
            ObjectId objectIdResolveRefToCommitId = resolveRefToCommitId();
            if (this.ref != null && objectIdResolveRefToCommitId == null) {
                throw new JGitInternalException(MessageFormat.format(JGitText.get().invalidRefName, this.ref));
            }
            RevTree tree = objectIdResolveRefToCommitId != null ? parseCommit(objectIdResolveRefToCommitId).getTree() : null;
            if (!this.filepaths.isEmpty()) {
                resetIndexForPaths(tree);
                setCallable(false);
                return this.repo.exactRef("HEAD");
            }
            if (objectIdResolveRefToCommitId != null) {
                RefUpdate refUpdateUpdateRef = this.repo.updateRef("HEAD");
                refUpdateUpdateRef.setNewObjectId(objectIdResolveRefToCommitId);
                String strShortenRefName = Repository.shortenRefName(getRefOrHEAD());
                if (this.isReflogDisabled) {
                    refUpdateUpdateRef.disableRefLog();
                } else {
                    refUpdateUpdateRef.setRefLogMessage(strShortenRefName + ": updating HEAD", false);
                }
                if (refUpdateUpdateRef.forceUpdate() == RefUpdate.Result.LOCK_FAILURE) {
                    throw new JGitInternalException(MessageFormat.format(JGitText.get().cannotLock, refUpdateUpdateRef.getName()));
                }
                ObjectId oldObjectId = refUpdateUpdateRef.getOldObjectId();
                if (oldObjectId != null) {
                    this.repo.writeOrigHead(oldObjectId);
                }
            }
            Ref refExactRef = this.repo.exactRef("HEAD");
            if (this.mode == null) {
                this.mode = ResetType.MIXED;
            }
            int i = $SWITCH_TABLE$org$eclipse$jgit$api$ResetCommand$ResetType()[this.mode.ordinal()];
            if (i == 2) {
                resetIndex(tree);
            } else if (i == 3) {
                checkoutIndex(tree);
            } else if (i == 4 || i == 5) {
                throw new UnsupportedOperationException();
            }
            if (this.mode != ResetType.SOFT) {
                if (z2) {
                    resetMerge();
                } else if (z3) {
                    resetCherryPick();
                } else if (z) {
                    resetRevert();
                } else if (this.repo.readSquashCommitMsg() != null) {
                    this.repo.writeSquashCommitMsg(null);
                }
            }
            setCallable(false);
            return refExactRef;
        } catch (IOException e) {
            throw new JGitInternalException(MessageFormat.format(JGitText.get().exceptionCaughtDuringExecutionOfResetCommand, e.getMessage()), e);
        }
    }

    private RevCommit parseCommit(ObjectId objectId) {
        Throwable th = null;
        try {
            RevWalk revWalk = new RevWalk(this.repo);
            try {
                return revWalk.parseCommit(objectId);
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
            try {
                th.addSuppressed(th2);
                throw null;
            } catch (IOException e) {
                throw new JGitInternalException(MessageFormat.format(JGitText.get().cannotReadCommit, objectId.toString()), e);
            }
            throw new JGitInternalException(MessageFormat.format(JGitText.get().cannotReadCommit, objectId.toString()), e);
        }
    }

    private ObjectId resolveRefToCommitId() {
        try {
            return this.repo.resolve(getRefOrHEAD() + "^{commit}");
        } catch (IOException e) {
            throw new JGitInternalException(MessageFormat.format(JGitText.get().cannotRead, getRefOrHEAD()), e);
        }
    }

    public ResetCommand setRef(String str) {
        this.ref = str;
        return this;
    }

    public ResetCommand setMode(ResetType resetType) {
        if (!this.filepaths.isEmpty()) {
            throw new JGitInternalException(MessageFormat.format(JGitText.get().illegalCombinationOfArguments, "[--mixed | --soft | --hard]", "<paths>..."));
        }
        this.mode = resetType;
        return this;
    }

    public ResetCommand addPath(String str) {
        if (this.mode != null) {
            throw new JGitInternalException(MessageFormat.format(JGitText.get().illegalCombinationOfArguments, "<paths>...", "[--mixed | --soft | --hard]"));
        }
        this.filepaths.add(str);
        return this;
    }

    public ResetCommand disableRefLog(boolean z) {
        this.isReflogDisabled = z;
        return this;
    }

    public boolean isReflogDisabled() {
        return this.isReflogDisabled;
    }

    private String getRefOrHEAD() {
        String str = this.ref;
        return str != null ? str : "HEAD";
    }

    public ResetCommand setProgressMonitor(ProgressMonitor progressMonitor) {
        if (progressMonitor == null) {
            progressMonitor = NullProgressMonitor.INSTANCE;
        }
        this.monitor = progressMonitor;
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x007b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:47:0x007d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:60:? A[RETURN, SYNTHETIC] */
    private void resetIndexForPaths(ObjectId objectId) throws Throwable {
        Throwable th = null;
        DirCache dirCache = null;
        try {
            try {
                TreeWalk treeWalk = new TreeWalk(this.repo);
                try {
                    DirCache dirCacheLockDirCache = this.repo.lockDirCache();
                    try {
                        DirCacheBuilder dirCacheBuilderBuilder = dirCacheLockDirCache.builder();
                        treeWalk.addTree(new DirCacheBuildIterator(dirCacheBuilderBuilder));
                        if (objectId != null) {
                            treeWalk.addTree(objectId);
                        } else {
                            treeWalk.addTree(new EmptyTreeIterator());
                        }
                        treeWalk.setFilter(PathFilterGroup.createFromStrings(this.filepaths));
                        treeWalk.setRecursive(true);
                        while (treeWalk.next()) {
                            CanonicalTreeParser canonicalTreeParser = (CanonicalTreeParser) treeWalk.getTree(1, CanonicalTreeParser.class);
                            if (canonicalTreeParser != null) {
                                DirCacheEntry dirCacheEntry = new DirCacheEntry(treeWalk.getRawPath());
                                dirCacheEntry.setFileMode(canonicalTreeParser.getEntryFileMode());
                                dirCacheEntry.setObjectId(canonicalTreeParser.getEntryObjectId());
                                dirCacheBuilderBuilder.add(dirCacheEntry);
                            }
                        }
                        dirCacheBuilderBuilder.commit();
                        treeWalk.close();
                        if (dirCacheLockDirCache != null) {
                            dirCacheLockDirCache.unlock();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        Throwable th3 = th;
                        treeWalk.close();
                        throw th3;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (Throwable th5) {
                th = th5;
                try {
                    if (0 != 0) {
                        throw th;
                    }
                    if (null != th) {
                        try {
                            th.addSuppressed(th);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    throw null;
                } catch (Throwable th6) {
                    if (0 != 0) {
                        dirCache.unlock();
                    }
                    throw th6;
                }
            }
        } catch (Throwable th7) {
            th = th7;
            if (0 != 0) {
                throw th;
            }
            if (null != th) {
                th.addSuppressed(th);
            }
            throw null;
        }
    }

    private void resetIndex(ObjectId objectId) throws IOException {
        DirCache dirCacheLockDirCache = this.repo.lockDirCache();
        Throwable th = null;
        try {
            TreeWalk treeWalk = new TreeWalk(this.repo);
            try {
                DirCacheBuilder dirCacheBuilderBuilder = dirCacheLockDirCache.builder();
                if (objectId != null) {
                    treeWalk.addTree(objectId);
                } else {
                    treeWalk.addTree(new EmptyTreeIterator());
                }
                treeWalk.addTree(new DirCacheIterator(dirCacheLockDirCache));
                treeWalk.setRecursive(true);
                while (treeWalk.next()) {
                    AbstractTreeIterator tree = treeWalk.getTree(0, AbstractTreeIterator.class);
                    if (tree != null) {
                        DirCacheEntry dirCacheEntry = new DirCacheEntry(treeWalk.getRawPath());
                        dirCacheEntry.setFileMode(tree.getEntryFileMode());
                        dirCacheEntry.setObjectIdFromRaw(tree.idBuffer(), tree.idOffset());
                        DirCacheIterator dirCacheIterator = (DirCacheIterator) treeWalk.getTree(1, DirCacheIterator.class);
                        if (dirCacheIterator != null && dirCacheIterator.idEqual(tree)) {
                            DirCacheEntry dirCacheEntry2 = dirCacheIterator.getDirCacheEntry();
                            dirCacheEntry.setLastModified(dirCacheEntry2.getLastModifiedInstant());
                            dirCacheEntry.setLength(dirCacheEntry2.getLength());
                        }
                        dirCacheBuilderBuilder.add(dirCacheEntry);
                    }
                }
                dirCacheBuilderBuilder.commit();
                treeWalk.close();
                dirCacheLockDirCache.unlock();
            } catch (Throwable th2) {
                treeWalk.close();
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
                    dirCacheLockDirCache.unlock();
                    throw th4;
                }
            }
            throw null;
        }
    }

    private void checkoutIndex(ObjectId objectId) throws GitAPIException, IOException {
        DirCache dirCacheLockDirCache = this.repo.lockDirCache();
        try {
            DirCacheCheckout dirCacheCheckout = new DirCacheCheckout(this.repo, dirCacheLockDirCache, objectId);
            dirCacheCheckout.setFailOnConflict(false);
            dirCacheCheckout.setProgressMonitor(this.monitor);
            try {
                dirCacheCheckout.checkout();
                dirCacheLockDirCache.unlock();
            } catch (CheckoutConflictException e) {
                throw new org.eclipse.jgit.api.errors.CheckoutConflictException(dirCacheCheckout.getConflicts(), e);
            }
        } catch (Throwable th) {
            dirCacheLockDirCache.unlock();
            throw th;
        }
    }

    private void resetMerge() throws IOException {
        this.repo.writeMergeHeads(null);
        this.repo.writeMergeCommitMsg(null);
    }

    private void resetCherryPick() throws IOException {
        this.repo.writeCherryPickHead(null);
        this.repo.writeMergeCommitMsg(null);
    }

    private void resetRevert() throws IOException {
        this.repo.writeRevertHead(null);
        this.repo.writeMergeCommitMsg(null);
    }

    public String toString() {
        return "ResetCommand [repo=" + String.valueOf(this.repo) + ", ref=" + this.ref + ", mode=" + String.valueOf(this.mode) + ", isReflogDisabled=" + this.isReflogDisabled + ", filepaths=" + String.valueOf(this.filepaths) + CollectionUtils.DEFAULT_TOSTRING_SUFFIX;
    }
}
