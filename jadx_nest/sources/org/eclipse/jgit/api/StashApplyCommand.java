package org.eclipse.jgit.api;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashSet;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRefNameException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.api.errors.StashApplyFailureException;
import org.eclipse.jgit.api.errors.WrongRepositoryStateException;
import org.eclipse.jgit.dircache.Checkout;
import org.eclipse.jgit.dircache.DirCache;
import org.eclipse.jgit.dircache.DirCacheBuilder;
import org.eclipse.jgit.dircache.DirCacheCheckout;
import org.eclipse.jgit.dircache.DirCacheEntry;
import org.eclipse.jgit.dircache.DirCacheIterator;
import org.eclipse.jgit.errors.CheckoutConflictException;
import org.eclipse.jgit.events.WorkingTreeModifiedEvent;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.CoreConfig;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.RepositoryState;
import org.eclipse.jgit.merge.ContentMergeStrategy;
import org.eclipse.jgit.merge.MergeStrategy;
import org.eclipse.jgit.merge.Merger;
import org.eclipse.jgit.merge.ResolveMerger;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevTree;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.treewalk.AbstractTreeIterator;
import org.eclipse.jgit.treewalk.FileTreeIterator;
import org.eclipse.jgit.treewalk.TreeWalk;

/* JADX INFO: loaded from: classes5.dex */
public class StashApplyCommand extends GitCommand<ObjectId> {
    private static final String DEFAULT_REF = "stash@{0}";
    private ContentMergeStrategy contentStrategy;
    private boolean ignoreRepositoryState;
    private boolean restoreIndex;
    private boolean restoreUntracked;
    private String stashRef;
    private MergeStrategy strategy;

    public StashApplyCommand(Repository repository) {
        super(repository);
        this.restoreIndex = true;
        this.restoreUntracked = true;
        this.strategy = MergeStrategy.RECURSIVE;
    }

    public StashApplyCommand setStashRef(String str) {
        this.stashRef = str;
        return this;
    }

    public StashApplyCommand ignoreRepositoryState(boolean z) {
        this.ignoreRepositoryState = z;
        return this;
    }

    private ObjectId getStashId() throws GitAPIException {
        String str = this.stashRef;
        if (str == null) {
            str = DEFAULT_REF;
        }
        try {
            ObjectId objectIdResolve = this.repo.resolve(str);
            if (objectIdResolve != null) {
                return objectIdResolve;
            }
            throw new InvalidRefNameException(MessageFormat.format(JGitText.get().stashResolveFailed, str));
        } catch (IOException e) {
            throw new InvalidRefNameException(MessageFormat.format(JGitText.get().stashResolveFailed, str), e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:107:0x0208 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:117:0x021b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:119:? A[Catch: all -> 0x020c, SYNTHETIC, TRY_LEAVE, TryCatch #5 {all -> 0x020c, blocks: (B:87:0x0210, B:88:0x0213, B:83:0x0208), top: B:107:0x0208 }] */
    /* JADX WARN: Code duplicated, block: B:120:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:81:0x0204  */
    /* JADX WARN: Code duplicated, block: B:82:0x0206 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:87:0x0210 A[Catch: all -> 0x020c, TryCatch #5 {all -> 0x020c, blocks: (B:87:0x0210, B:88:0x0213, B:83:0x0208), top: B:107:0x0208 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x0219 A[DONT_INVERT] */
    @Override // org.eclipse.jgit.api.GitCommand, java.util.concurrent.Callable
    public ObjectId call() throws Throwable {
        Throwable th;
        Throwable th2;
        boolean zMerge;
        checkCallable();
        if (!this.ignoreRepositoryState && this.repo.getRepositoryState() != RepositoryState.SAFE) {
            throw new WrongRepositoryStateException(MessageFormat.format(JGitText.get().stashApplyOnUnsafeRepository, this.repo.getRepositoryState()));
        }
        try {
            ObjectReader objectReaderNewObjectReader = this.repo.newObjectReader();
            try {
                RevWalk revWalk = new RevWalk(objectReaderNewObjectReader);
                try {
                    ObjectId objectIdResolve = this.repo.resolve("HEAD");
                    if (objectIdResolve == null) {
                        throw new NoHeadException(JGitText.get().stashApplyWithoutHead);
                    }
                    ObjectId stashId = getStashId();
                    RevCommit commit = revWalk.parseCommit(stashId);
                    if (commit.getParentCount() < 2 || commit.getParentCount() > 3) {
                        throw new JGitInternalException(MessageFormat.format(JGitText.get().stashCommitIncorrectNumberOfParents, stashId.name(), Integer.valueOf(commit.getParentCount())));
                    }
                    ObjectId objectIdResolve2 = this.repo.resolve("HEAD^{tree}");
                    RevCommit commit2 = revWalk.parseCommit(commit.getParent(1));
                    RevCommit parent = commit.getParent(0);
                    RevCommit commit3 = (this.restoreUntracked && commit.getParentCount() == 3) ? revWalk.parseCommit(commit.getParent(2)) : null;
                    Merger mergerNewMerger = this.strategy.newMerger(this.repo);
                    if (mergerNewMerger instanceof ResolveMerger) {
                        ResolveMerger resolveMerger = (ResolveMerger) mergerNewMerger;
                        resolveMerger.setCommitNames(new String[]{"stashed HEAD", "HEAD", Constants.STASH});
                        resolveMerger.setBase(parent);
                        resolveMerger.setWorkingTreeIterator(new FileTreeIterator(this.repo));
                        resolveMerger.setContentMergeStrategy(this.contentStrategy);
                        zMerge = resolveMerger.merge(objectIdResolve, commit);
                        List<String> modifiedFiles = resolveMerger.getModifiedFiles();
                        if (!modifiedFiles.isEmpty()) {
                            this.repo.fireEvent(new WorkingTreeModifiedEvent(modifiedFiles, null));
                        }
                    } else {
                        zMerge = mergerNewMerger.merge(objectIdResolve, commit);
                    }
                    if (zMerge) {
                        DirCacheCheckout dirCacheCheckout = new DirCacheCheckout(this.repo, objectIdResolve2, this.repo.lockDirCache(), mergerNewMerger.getResultTreeId());
                        dirCacheCheckout.setFailOnConflict(true);
                        dirCacheCheckout.checkout();
                        if (this.restoreIndex) {
                            Merger mergerNewMerger2 = this.strategy.newMerger(this.repo, true);
                            if (mergerNewMerger2 instanceof ResolveMerger) {
                                ResolveMerger resolveMerger2 = (ResolveMerger) mergerNewMerger2;
                                resolveMerger2.setCommitNames(new String[]{"stashed HEAD", "HEAD", "stashed index"});
                                resolveMerger2.setBase(parent);
                                resolveMerger2.setContentMergeStrategy(this.contentStrategy);
                            }
                            if (mergerNewMerger2.merge(objectIdResolve, commit2)) {
                                resetIndex(revWalk.parseTree(mergerNewMerger2.getResultTreeId()));
                            } else {
                                throw new StashApplyFailureException(JGitText.get().stashApplyConflict);
                            }
                        }
                        if (commit3 != null) {
                            Merger mergerNewMerger3 = this.strategy.newMerger(this.repo, true);
                            if (mergerNewMerger3 instanceof ResolveMerger) {
                                ResolveMerger resolveMerger3 = (ResolveMerger) mergerNewMerger3;
                                resolveMerger3.setCommitNames(new String[]{AbstractJsonLexerKt.NULL, "HEAD", "untracked files"});
                                th = null;
                                resolveMerger3.setBase(null);
                                resolveMerger3.setContentMergeStrategy(this.contentStrategy);
                            } else {
                                th = null;
                            }
                            if (mergerNewMerger3.merge(objectIdResolve, commit3)) {
                                try {
                                    resetUntracked(revWalk.parseTree(commit3));
                                } catch (CheckoutConflictException e) {
                                    throw new StashApplyFailureException(JGitText.get().stashApplyConflict, e);
                                }
                            } else {
                                throw new StashApplyFailureException(JGitText.get().stashApplyConflict);
                            }
                        } else {
                            th = null;
                        }
                        try {
                            revWalk.close();
                            if (objectReaderNewObjectReader == null) {
                                return stashId;
                            }
                            try {
                                objectReaderNewObjectReader.close();
                                return stashId;
                            } catch (Throwable th3) {
                                th = th3;
                                th2 = th;
                                if (th2 != null) {
                                    throw th;
                                }
                                if (th2 != th) {
                                    try {
                                        th2.addSuppressed(th);
                                    } catch (IOException e2) {
                                        throw new JGitInternalException(JGitText.get().stashApplyFailed, e2);
                                    } catch (JGitInternalException e3) {
                                        throw e3;
                                    }
                                }
                                throw th2;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            th2 = th;
                            if (th2 == null) {
                                th2 = th;
                            } else if (th2 != th) {
                                try {
                                    th2.addSuppressed(th);
                                } catch (Throwable th5) {
                                    th = th5;
                                    if (th2 != null) {
                                        throw th;
                                    }
                                    if (th2 != th) {
                                        th2.addSuppressed(th);
                                    }
                                    throw th2;
                                }
                            }
                            if (objectReaderNewObjectReader != null) {
                                throw th2;
                            }
                            objectReaderNewObjectReader.close();
                            throw th2;
                        }
                    } else {
                        throw new StashApplyFailureException(JGitText.get().stashApplyConflict);
                    }
                } catch (Throwable th6) {
                    th2 = th6;
                    try {
                        revWalk.close();
                        throw th2;
                    } catch (Throwable th7) {
                        th = th7;
                        if (th2 == null) {
                            th2 = th;
                        } else if (th2 != th) {
                            th2.addSuppressed(th);
                        }
                        if (objectReaderNewObjectReader != null) {
                            throw th2;
                        }
                        objectReaderNewObjectReader.close();
                        throw th2;
                    }
                }
            } catch (Throwable th8) {
                th = th8;
                th = null;
            }
        } catch (Throwable th9) {
            th = th9;
            th = null;
        }
    }

    public StashApplyCommand setRestoreIndex(boolean z) {
        this.restoreIndex = z;
        return this;
    }

    public StashApplyCommand setStrategy(MergeStrategy mergeStrategy) {
        this.strategy = mergeStrategy;
        return this;
    }

    public StashApplyCommand setContentMergeStrategy(ContentMergeStrategy contentMergeStrategy) {
        checkCallable();
        this.contentStrategy = contentMergeStrategy;
        return this;
    }

    public StashApplyCommand setRestoreUntracked(boolean z) {
        this.restoreUntracked = z;
        return this;
    }

    private void resetIndex(RevTree revTree) throws IOException {
        DirCache dirCacheLockDirCache = this.repo.lockDirCache();
        Throwable th = null;
        try {
            TreeWalk treeWalk = new TreeWalk(this.repo);
            try {
                DirCacheBuilder dirCacheBuilderBuilder = dirCacheLockDirCache.builder();
                treeWalk.addTree(revTree);
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

    /* JADX WARN: Code duplicated, block: B:43:0x00b7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:64:0x00b9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:? A[RETURN, SYNTHETIC] */
    private void resetUntracked(RevTree revTree) throws Throwable {
        Throwable th;
        Throwable th2;
        Throwable th3;
        HashSet hashSet = new HashSet();
        Checkout recursiveDeletion = new Checkout(this.repo).setRecursiveDeletion(true);
        try {
            TreeWalk treeWalk = new TreeWalk(this.repo);
            try {
                treeWalk.addTree(revTree);
                treeWalk.addTree(new FileTreeIterator(this.repo));
                treeWalk.setRecursive(true);
                ObjectReader objectReader = treeWalk.getObjectReader();
                while (treeWalk.next()) {
                    AbstractTreeIterator tree = treeWalk.getTree(0, AbstractTreeIterator.class);
                    if (tree != null) {
                        CoreConfig.EolStreamType eolStreamType = treeWalk.getEolStreamType(TreeWalk.OperationType.CHECKOUT_OP);
                        DirCacheEntry dirCacheEntry = new DirCacheEntry(treeWalk.getRawPath());
                        dirCacheEntry.setFileMode(tree.getEntryFileMode());
                        dirCacheEntry.setObjectIdFromRaw(tree.idBuffer(), tree.idOffset());
                        FileTreeIterator fileTreeIterator = (FileTreeIterator) treeWalk.getTree(1, FileTreeIterator.class);
                        String pathString = dirCacheEntry.getPathString();
                        if (fileTreeIterator != null) {
                            try {
                                if (fileTreeIterator.isModified(dirCacheEntry, true, objectReader)) {
                                    throw new CheckoutConflictException(pathString);
                                }
                            } catch (Throwable th4) {
                                th3 = th4;
                                this = this;
                                try {
                                    treeWalk.close();
                                    throw th3;
                                } catch (Throwable th5) {
                                    th2 = th3;
                                    th = th5;
                                    if (th2 != null) {
                                        throw th;
                                    }
                                    if (th2 != th) {
                                        try {
                                            th2.addSuppressed(th);
                                        } catch (Throwable th6) {
                                            if (hashSet.isEmpty()) {
                                                throw th6;
                                            }
                                            this.repo.fireEvent(new WorkingTreeModifiedEvent(hashSet, null));
                                            throw th6;
                                        }
                                    }
                                    throw th2;
                                }
                            }
                        }
                        this = this;
                        try {
                            this.checkoutPath(dirCacheEntry, pathString, objectReader, recursiveDeletion, new DirCacheCheckout.CheckoutMetadata(eolStreamType, null));
                            hashSet.add(pathString);
                        } catch (Throwable th7) {
                            th = th7;
                            th3 = th;
                            treeWalk.close();
                            throw th3;
                        }
                    }
                }
                try {
                    treeWalk.close();
                    if (hashSet.isEmpty()) {
                        return;
                    }
                    this.repo.fireEvent(new WorkingTreeModifiedEvent(hashSet, null));
                } catch (Throwable th8) {
                    th = th8;
                    th2 = null;
                    if (th2 != null) {
                        throw th;
                    }
                    if (th2 != th) {
                        th2.addSuppressed(th);
                    }
                    throw th2;
                }
            } catch (Throwable th9) {
                th = th9;
                this = this;
            }
        } catch (Throwable th10) {
            th = th10;
        }
    }

    private void checkoutPath(DirCacheEntry dirCacheEntry, String str, ObjectReader objectReader, Checkout checkout, DirCacheCheckout.CheckoutMetadata checkoutMetadata) {
        try {
            checkout.checkout(dirCacheEntry, checkoutMetadata, objectReader, str);
        } catch (IOException e) {
            throw new JGitInternalException(MessageFormat.format(JGitText.get().checkoutConflictWithFile, dirCacheEntry.getPathString()), e);
        }
    }
}
