package org.eclipse.jgit.api;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import net.lingala.zip4j.util.InternalZipConstants;
import org.eclipse.jgit.api.errors.CanceledException;
import org.eclipse.jgit.api.errors.ConcurrentRefUpdateException;
import org.eclipse.jgit.api.errors.EmptyCommitException;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.api.errors.NoFilepatternException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.api.errors.NoMessageException;
import org.eclipse.jgit.api.errors.UnmergedPathsException;
import org.eclipse.jgit.api.errors.UnsupportedSigningFormatException;
import org.eclipse.jgit.api.errors.WrongRepositoryStateException;
import org.eclipse.jgit.dircache.DirCache;
import org.eclipse.jgit.dircache.DirCacheBuildIterator;
import org.eclipse.jgit.dircache.DirCacheBuilder;
import org.eclipse.jgit.dircache.DirCacheEntry;
import org.eclipse.jgit.dircache.DirCacheIterator;
import org.eclipse.jgit.errors.UnmergedPathException;
import org.eclipse.jgit.hooks.CommitMsgHook;
import org.eclipse.jgit.hooks.Hooks;
import org.eclipse.jgit.hooks.PostCommitHook;
import org.eclipse.jgit.hooks.PreCommitHook;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.BranchConfig;
import org.eclipse.jgit.lib.CommitBuilder;
import org.eclipse.jgit.lib.CommitConfig;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.FileMode;
import org.eclipse.jgit.lib.GpgConfig;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectInserter;
import org.eclipse.jgit.lib.PersonIdent;
import org.eclipse.jgit.lib.RefUpdate;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.RepositoryState;
import org.eclipse.jgit.lib.Signer;
import org.eclipse.jgit.lib.Signers;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevObject;
import org.eclipse.jgit.revwalk.RevTag;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.treewalk.CanonicalTreeParser;
import org.eclipse.jgit.treewalk.FileTreeIterator;
import org.eclipse.jgit.treewalk.TreeWalk;
import org.eclipse.jgit.util.ChangeIdUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* INFO: loaded from: classes5.dex */
public class CommitCommand extends GitCommand<RevCommit> {
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$lib$RefUpdate$Result;
    private static final Logger log = LoggerFactory.getLogger((Class<?>) CommitCommand.class);
    private boolean all;
    private Boolean allowEmpty;
    private boolean amend;
    private PersonIdent author;
    private boolean cleanDefaultIsStrip;
    private CommitConfig.CleanupMode cleanupMode;
    private Character commentChar;
    private PersonIdent committer;
    private CredentialsProvider credentialsProvider;
    private GpgConfig gpgConfig;
    private HashMap<String, PrintStream> hookErrRedirect;
    private HashMap<String, PrintStream> hookOutRedirect;
    private boolean insertChangeId;
    private String message;
    private boolean noVerify;
    private List<String> only;
    private boolean[] onlyProcessed;
    private List<ObjectId> parents;
    private String reflogComment;
    private Boolean signCommit;
    private Signer signer;
    private String signingKey;
    private boolean useDefaultReflogMessage;

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

    protected CommitCommand(Repository repository) {
        super(repository);
        this.only = new ArrayList();
        this.parents = new ArrayList();
        this.useDefaultReflogMessage = true;
        this.hookOutRedirect = new HashMap<>(3);
        this.hookErrRedirect = new HashMap<>(3);
        this.cleanupMode = CommitConfig.CleanupMode.VERBATIM;
        this.cleanDefaultIsStrip = true;
        this.credentialsProvider = CredentialsProvider.getDefault();
    }

    @Override // org.eclipse.jgit.api.GitCommand, java.util.concurrent.Callable
    public RevCommit call() throws GitAPIException {
        CommitConfig commitConfig;
        checkCallable();
        Collections.sort(this.only);
        Throwable th = null;
        try {
            RevWalk revWalk = new RevWalk(this.repo);
            try {
                RepositoryState repositoryState = this.repo.getRepositoryState();
                if (!repositoryState.canCommit()) {
                    throw new WrongRepositoryStateException(MessageFormat.format(JGitText.get().cannotCommitOnARepoWithState, repositoryState.name()));
                }
                if (!this.noVerify) {
                    Hooks.preCommit(this.repo, this.hookOutRedirect.get(PreCommitHook.NAME), this.hookErrRedirect.get(PreCommitHook.NAME)).call();
                }
                processOptions(repositoryState, revWalk);
                if (this.all && !this.repo.isBare()) {
                    try {
                        Git git = new Git(this.repo);
                        try {
                            git.add().addFilepattern(BranchConfig.LOCAL_REPOSITORY).setUpdate(true).call();
                            git.close();
                        } catch (Throwable th2) {
                            git.close();
                            throw th2;
                        }
                    } catch (Throwable th3) {
                        if (0 == 0) {
                            throw th3;
                        }
                        if (null != th3) {
                            try {
                                th.addSuppressed(th3);
                            } catch (NoFilepatternException e) {
                                throw new JGitInternalException(e.getMessage(), e);
                            }
                        }
                        throw null;
                    }
                }
                if (this.repo.exactRef("HEAD") == null) {
                    throw new NoHeadException(JGitText.get().commitOnRepoWithoutHEADCurrentlyNotSupported);
                }
                ObjectId objectIdResolve = this.repo.resolve("HEAD^{commit}");
                if (objectIdResolve == null && this.amend) {
                    throw new WrongRepositoryStateException(JGitText.get().commitAmendOnInitialNotPossible);
                }
                char cCharValue = 0;
                if (objectIdResolve != null) {
                    if (this.amend) {
                        RevCommit commit = revWalk.parseCommit(objectIdResolve);
                        for (RevCommit revCommit : commit.getParents()) {
                            this.parents.add(revCommit.getId());
                        }
                        if (this.author == null) {
                            this.author = commit.getAuthorIdent();
                        }
                    } else {
                        this.parents.add(0, objectIdResolve);
                    }
                }
                if (!this.noVerify) {
                    this.message = Hooks.commitMsg(this.repo, this.hookOutRedirect.get(CommitMsgHook.NAME), this.hookErrRedirect.get(CommitMsgHook.NAME)).setCommitMessage(this.message).call();
                }
                if (CommitConfig.CleanupMode.DEFAULT.equals(this.cleanupMode)) {
                    commitConfig = (CommitConfig) this.repo.getConfig().get(CommitConfig.KEY);
                    this.cleanupMode = commitConfig.resolve(this.cleanupMode, this.cleanDefaultIsStrip);
                } else {
                    commitConfig = null;
                }
                if (CommitConfig.CleanupMode.STRIP.equals(this.cleanupMode) || CommitConfig.CleanupMode.SCISSORS.equals(this.cleanupMode)) {
                    Character ch = this.commentChar;
                    if (ch == null) {
                        if (commitConfig == null) {
                            commitConfig = (CommitConfig) this.repo.getConfig().get(CommitConfig.KEY);
                        }
                        if (commitConfig.isAutoCommentChar()) {
                            this.cleanupMode = CommitConfig.CleanupMode.WHITESPACE;
                        } else {
                            cCharValue = commitConfig.getCommentChar();
                        }
                    } else {
                        cCharValue = ch.charValue();
                    }
                }
                this.message = CommitConfig.cleanText(this.message, this.cleanupMode, cCharValue);
                DirCache dirCacheLockDirCache = this.repo.lockDirCache();
                try {
                    ObjectInserter objectInserterNewObjectInserter = this.repo.newObjectInserter();
                    try {
                        if (!this.only.isEmpty()) {
                            dirCacheLockDirCache = createTemporaryIndex(objectIdResolve, dirCacheLockDirCache, revWalk);
                        }
                        ObjectId objectIdWriteTree = dirCacheLockDirCache.writeTree(objectInserterNewObjectInserter);
                        if (this.insertChangeId) {
                            insertChangeId(objectIdWriteTree);
                        }
                        checkIfEmpty(revWalk, objectIdResolve, objectIdWriteTree);
                        CommitBuilder commitBuilder = new CommitBuilder();
                        commitBuilder.setCommitter(this.committer);
                        commitBuilder.setAuthor(this.author);
                        commitBuilder.setMessage(this.message);
                        commitBuilder.setParentIds(this.parents);
                        commitBuilder.setTreeId(objectIdWriteTree);
                        if (this.signCommit.booleanValue()) {
                            sign(commitBuilder);
                        }
                        ObjectId objectIdInsert = objectInserterNewObjectInserter.insert(commitBuilder);
                        objectInserterNewObjectInserter.flush();
                        RevCommit commit2 = revWalk.parseCommit(objectIdInsert);
                        updateRef(repositoryState, objectIdResolve, commit2, objectIdInsert);
                        if (objectInserterNewObjectInserter != null) {
                            objectInserterNewObjectInserter.close();
                        }
                        dirCacheLockDirCache.unlock();
                        try {
                            Hooks.postCommit(this.repo, this.hookOutRedirect.get(PostCommitHook.NAME), this.hookErrRedirect.get(PostCommitHook.NAME)).call();
                        } catch (Exception e2) {
                            log.error(MessageFormat.format(JGitText.get().postCommitHookFailed, e2.getMessage()), (Throwable) e2);
                        }
                        revWalk.close();
                        return commit2;
                    } catch (Throwable th4) {
                        if (objectInserterNewObjectInserter == null) {
                            throw th4;
                        }
                        objectInserterNewObjectInserter.close();
                        throw th4;
                    }
                } catch (Throwable th5) {
                    if (0 == 0) {
                        throw th5;
                    }
                    if (null != th5) {
                        try {
                            th.addSuppressed(th5);
                        } catch (Throwable th6) {
                            dirCacheLockDirCache.unlock();
                            throw th6;
                        }
                    }
                    throw null;
                }
            } catch (Throwable th7) {
                revWalk.close();
                throw th7;
            }
        } catch (Throwable th8) {
            if (0 == 0) {
                throw th8;
            }
            if (null != th8) {
                try {
                    th.addSuppressed(th8);
                } catch (UnmergedPathException e3) {
                    throw new UnmergedPathsException(e3);
                } catch (IOException e4) {
                    throw new JGitInternalException(JGitText.get().exceptionCaughtDuringExecutionOfCommitCommand, e4);
                }
            }
            throw null;
        }
    }

    private void checkIfEmpty(RevWalk revWalk, ObjectId objectId, ObjectId objectId2) throws EmptyCommitException, IOException {
        if (objectId == null || this.allowEmpty.booleanValue()) {
            return;
        }
        RevCommit commit = revWalk.parseCommit(objectId);
        commit.getTree();
        if (objectId2.equals((AnyObjectId) commit.getTree())) {
            throw new EmptyCommitException(JGitText.get().emptyCommit);
        }
    }

    private void sign(CommitBuilder commitBuilder) throws IOException, CanceledException, UnsupportedSigningFormatException {
        if (this.signer == null) {
            Signer signer = Signers.get(this.gpgConfig.getKeyFormat());
            this.signer = signer;
            if (signer == null) {
                throw new UnsupportedSigningFormatException(MessageFormat.format(JGitText.get().signatureTypeUnknown, this.gpgConfig.getKeyFormat().toConfigValue()));
            }
        }
        if (this.signingKey == null) {
            this.signingKey = this.gpgConfig.getSigningKey();
        }
        this.signer.signObject(this.repo, this.gpgConfig, commitBuilder, this.committer, this.signingKey, this.credentialsProvider);
    }

    private void updateRef(RepositoryState repositoryState, ObjectId objectId, RevCommit revCommit, ObjectId objectId2) throws ConcurrentRefUpdateException, IOException {
        String str;
        RefUpdate refUpdateUpdateRef = this.repo.updateRef("HEAD");
        refUpdateUpdateRef.setNewObjectId(objectId2);
        if (!this.useDefaultReflogMessage) {
            refUpdateUpdateRef.setRefLogMessage(this.reflogComment, false);
        } else {
            if (this.amend) {
                str = "commit (amend): ";
            } else {
                str = this.parents.isEmpty() ? "commit (initial): " : "commit: ";
            }
            refUpdateUpdateRef.setRefLogMessage(str + revCommit.getShortMessage(), false);
        }
        if (objectId != null) {
            refUpdateUpdateRef.setExpectedOldObjectId(objectId);
        } else {
            refUpdateUpdateRef.setExpectedOldObjectId(ObjectId.zeroId());
        }
        RefUpdate.Result resultForceUpdate = refUpdateUpdateRef.forceUpdate();
        int i = $SWITCH_TABLE$org$eclipse$jgit$lib$RefUpdate$Result()[resultForceUpdate.ordinal()];
        if (i != 2) {
            if (i == 4 || i == 5 || i == 6) {
                setCallable(false);
                if (repositoryState == RepositoryState.MERGING_RESOLVED || isMergeDuringRebase(repositoryState)) {
                    this.repo.writeMergeCommitMsg(null);
                    this.repo.writeMergeHeads(null);
                    return;
                } else if (repositoryState == RepositoryState.CHERRY_PICKING_RESOLVED) {
                    this.repo.writeMergeCommitMsg(null);
                    this.repo.writeCherryPickHead(null);
                    return;
                } else {
                    if (repositoryState == RepositoryState.REVERTING_RESOLVED) {
                        this.repo.writeMergeCommitMsg(null);
                        this.repo.writeRevertHead(null);
                        return;
                    }
                    return;
                }
            }
            if (i != 7) {
                throw new JGitInternalException(MessageFormat.format(JGitText.get().updatingRefFailed, "HEAD", objectId2.toString(), resultForceUpdate));
            }
        }
        throw new ConcurrentRefUpdateException(JGitText.get().couldNotLockHEAD, refUpdateUpdateRef.getRef(), resultForceUpdate);
    }

    private void insertChangeId(ObjectId objectId) {
        ObjectId objectIdComputeChangeId = ChangeIdUtil.computeChangeId(objectId, !this.parents.isEmpty() ? this.parents.get(0) : null, this.author, this.committer, this.message);
        String strInsertId = ChangeIdUtil.insertId(this.message, objectIdComputeChangeId);
        this.message = strInsertId;
        if (objectIdComputeChangeId != null) {
            this.message = strInsertId.replaceAll("\nChange-Id: I" + ObjectId.zeroId().getName() + "\n", "\nChange-Id: I" + objectIdComputeChangeId.getName() + "\n");
        }
    }

    /* WARN: Code duplicated, block: B:87:0x0182 A[PHI: r14 r17 r19
  0x0182: PHI (r14v5 org.eclipse.jgit.lib.ObjectInserter) = 
  (r14v1 org.eclipse.jgit.lib.ObjectInserter)
  (r14v8 org.eclipse.jgit.lib.ObjectInserter)
  (r14v8 org.eclipse.jgit.lib.ObjectInserter)
  (r14v8 org.eclipse.jgit.lib.ObjectInserter)
 binds: [B:86:0x0180, B:64:0x0150, B:66:0x0156, B:68:0x0160] A[DONT_GENERATE, DONT_INLINE]
  0x0182: PHI (r17v7 int) = (r17v4 int), (r17v9 int), (r17v9 int), (r17v9 int) binds: [B:86:0x0180, B:64:0x0150, B:66:0x0156, B:68:0x0160] A[DONT_GENERATE, DONT_INLINE]
  0x0182: PHI (r19v6 boolean) = (r19v3 boolean), (r19v7 boolean), (r19v7 boolean), (r19v7 boolean) binds: [B:86:0x0180, B:64:0x0150, B:66:0x0156, B:68:0x0160] A[DONT_GENERATE, DONT_INLINE]] */
    /* WARN: Code duplicated, block: B:88:0x0184 A[PHI: r14 r17 r19 r21
  0x0184: PHI (r14v3 org.eclipse.jgit.lib.ObjectInserter) = 
  (r14v1 org.eclipse.jgit.lib.ObjectInserter)
  (r14v1 org.eclipse.jgit.lib.ObjectInserter)
  (r14v8 org.eclipse.jgit.lib.ObjectInserter)
  (r14v8 org.eclipse.jgit.lib.ObjectInserter)
 binds: [B:85:0x017e, B:86:0x0180, B:63:0x014e, B:68:0x0160] A[DONT_GENERATE, DONT_INLINE]
  0x0184: PHI (r17v5 int) = (r17v4 int), (r17v4 int), (r17v9 int), (r17v9 int) binds: [B:85:0x017e, B:86:0x0180, B:63:0x014e, B:68:0x0160] A[DONT_GENERATE, DONT_INLINE]
  0x0184: PHI (r19v4 boolean) = (r19v3 boolean), (r19v3 boolean), (r19v7 boolean), (r19v7 boolean) binds: [B:85:0x017e, B:86:0x0180, B:63:0x014e, B:68:0x0160] A[DONT_GENERATE, DONT_INLINE]
  0x0184: PHI (r21v4 boolean) = (r21v3 boolean), (r21v3 boolean), (r21v5 boolean), (r21v5 boolean) binds: [B:85:0x017e, B:86:0x0180, B:63:0x014e, B:68:0x0160] A[DONT_GENERATE, DONT_INLINE]] */
    /* WARN: Multi-variable type inference failed */
    /* WARN: Type inference failed for: r10v6, types: [org.eclipse.jgit.treewalk.AbstractTreeIterator, org.eclipse.jgit.treewalk.FileTreeIterator] */
    /* WARN: Type inference failed for: r13v0 */
    /* WARN: Type inference failed for: r13v1, types: [java.lang.Object] */
    /* WARN: Type inference failed for: r13v2 */
    /* WARN: Type inference failed for: r13v3 */
    /* WARN: Type inference failed for: r13v5 */
    /* WARN: Type inference failed for: r15v1, types: [java.lang.String] */
    /* WARN: Type inference failed for: r18v0, types: [org.eclipse.jgit.api.CommitCommand] */
    /* WARN: Type inference failed for: r5v17 */
    /* WARN: Type inference failed for: r5v7 */
    /* WARN: Type inference failed for: r5v8, types: [org.eclipse.jgit.treewalk.AbstractTreeIterator, org.eclipse.jgit.treewalk.CanonicalTreeParser] */
    /* WARN: Type inference failed for: r6v0, types: [org.eclipse.jgit.treewalk.TreeWalk] */
    /* WARN: Type inference failed for: r8v0, types: [org.eclipse.jgit.treewalk.AbstractTreeIterator, org.eclipse.jgit.treewalk.FileTreeIterator] */
    private DirCache createTemporaryIndex(ObjectId objectId, DirCache dirCache, RevWalk revWalk) throws Throwable {
        Throwable th;
        int i;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Throwable th2;
        DirCacheBuilder dirCacheBuilderBuilder = dirCache.builder();
        DirCache dirCacheNewInCore = DirCache.newInCore();
        DirCacheBuilder dirCacheBuilderBuilder2 = dirCacheNewInCore.builder();
        this.onlyProcessed = new boolean[this.only.size()];
        try {
            ?? treeWalk = new TreeWalk(this.repo);
            try {
                treeWalk.setOperationType(TreeWalk.OperationType.CHECKIN_OP);
                int iAddTree = treeWalk.addTree(new DirCacheBuildIterator(dirCacheBuilderBuilder));
                ?? fileTreeIterator = new FileTreeIterator(this.repo);
                int i2 = 0;
                fileTreeIterator.setDirCacheIterator(treeWalk, 0);
                int iAddTree2 = treeWalk.addTree(fileTreeIterator);
                int i3 = -1;
                int iAddTree3 = objectId != null ? treeWalk.addTree(revWalk.parseTree(objectId)) : -1;
                boolean z5 = true;
                treeWalk.setRecursive(true);
                boolean z6 = true;
                ?? r13 = 0;
                ObjectInserter objectInserterNewObjectInserter = null;
                while (treeWalk.next()) {
                    ?? pathString = treeWalk.getPathString();
                    int iLookupOnly = lookupOnly(pathString);
                    ?? r5 = iAddTree3 != i3 ? (CanonicalTreeParser) treeWalk.getTree(iAddTree3, CanonicalTreeParser.class) : 0;
                    DirCacheIterator dirCacheIterator = (DirCacheIterator) treeWalk.getTree(iAddTree, DirCacheIterator.class);
                    if (iLookupOnly >= 0) {
                        ?? r10 = (FileTreeIterator) treeWalk.getTree(iAddTree2, FileTreeIterator.class);
                        if ((dirCacheIterator == null && r5 == 0) || pathString.equals(r13)) {
                            i = iAddTree3;
                            z = z5;
                            z2 = z6;
                        } else {
                            if (r10 != 0) {
                                DirCacheEntry dirCacheEntry = new DirCacheEntry((String) pathString);
                                z3 = z5;
                                z4 = z6;
                                dirCacheEntry.setLength(r10.getEntryLength());
                                dirCacheEntry.setLastModified(r10.getEntryLastModifiedInstant());
                                dirCacheEntry.setFileMode(r10.getIndexFileMode(dirCacheIterator));
                                if ((dirCacheIterator != null && r10.idEqual(dirCacheIterator)) || (r5 != 0 && r10.idEqual(r5))) {
                                    dirCacheEntry.setObjectId(r10.getEntryObjectId());
                                } else {
                                    if (FileMode.GITLINK.equals(dirCacheEntry.getFileMode())) {
                                        dirCacheEntry.setObjectId(r10.getEntryObjectId());
                                    } else {
                                        if (objectInserterNewObjectInserter == null) {
                                            objectInserterNewObjectInserter = this.repo.newObjectInserter();
                                        }
                                        long entryContentLength = r10.getEntryContentLength();
                                        try {
                                            InputStream inputStreamOpenEntryStream = r10.openEntryStream();
                                            i = iAddTree3;
                                            try {
                                                dirCacheEntry.setObjectId(objectInserterNewObjectInserter.insert(3, entryContentLength, inputStreamOpenEntryStream));
                                                if (inputStreamOpenEntryStream != null) {
                                                    inputStreamOpenEntryStream.close();
                                                }
                                            } catch (Throwable th3) {
                                                th2 = th3;
                                                if (inputStreamOpenEntryStream == null) {
                                                    throw th2;
                                                }
                                                try {
                                                    inputStreamOpenEntryStream.close();
                                                    throw th2;
                                                } catch (Throwable th4) {
                                                    th = th4;
                                                    if (th2 == null) {
                                                        throw th;
                                                    }
                                                    if (th2 != th) {
                                                        th2.addSuppressed(th);
                                                    }
                                                    throw th2;
                                                }
                                            }
                                        } catch (Throwable th5) {
                                            th = th5;
                                            th2 = null;
                                        }
                                    }
                                    dirCacheBuilderBuilder.add(dirCacheEntry);
                                    dirCacheBuilderBuilder2.add(dirCacheEntry);
                                    if (z4 || (r5 != 0 && r5.idEqual(r10) && r5.getEntryRawMode() == r10.getEntryRawMode())) {
                                        z6 = z4;
                                    } else {
                                        z6 = false;
                                    }
                                }
                                i = iAddTree3;
                                dirCacheBuilderBuilder.add(dirCacheEntry);
                                dirCacheBuilderBuilder2.add(dirCacheEntry);
                                if (z4) {
                                }
                                z6 = z4;
                            } else {
                                i = iAddTree3;
                                z3 = z5;
                                z4 = z6;
                                if (!z4 || r5 == 0) {
                                    z6 = z4;
                                } else {
                                    z6 = false;
                                }
                            }
                            this.onlyProcessed[iLookupOnly] = z3;
                            z5 = z3;
                            r13 = pathString;
                        }
                        iAddTree3 = i;
                        i2 = 0;
                        i3 = -1;
                        r13 = r13;
                    } else {
                        i = iAddTree3;
                        z = z5;
                        z2 = z6;
                        if (r5 != 0) {
                            DirCacheEntry dirCacheEntry2 = new DirCacheEntry((String) pathString);
                            dirCacheEntry2.setObjectId(r5.getEntryObjectId());
                            dirCacheEntry2.setFileMode(r5.getEntryFileMode());
                            dirCacheBuilderBuilder2.add(dirCacheEntry2);
                        }
                        if (dirCacheIterator != null) {
                            dirCacheBuilderBuilder.add(dirCacheIterator.getDirCacheEntry());
                        }
                    }
                    z5 = z;
                    z6 = z2;
                    iAddTree3 = i;
                    i2 = 0;
                    i3 = -1;
                    r13 = r13;
                }
                treeWalk.close();
                while (true) {
                    boolean[] zArr = this.onlyProcessed;
                    if (i2 < zArr.length) {
                        if (!zArr[i2]) {
                            throw new JGitInternalException(MessageFormat.format(JGitText.get().entryNotFoundByPath, this.only.get(i2)));
                        }
                        i2++;
                    } else {
                        if (z6 && !this.allowEmpty.booleanValue()) {
                            throw new JGitInternalException(JGitText.get().emptyCommit);
                        }
                        dirCacheBuilderBuilder.commit();
                        dirCacheBuilderBuilder2.finish();
                        return dirCacheNewInCore;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                try {
                    treeWalk.close();
                    throw th;
                } catch (Throwable th7) {
                    th = th7;
                    if (th == null) {
                        throw th;
                    }
                    if (th != th) {
                        th.addSuppressed(th);
                    }
                    throw th;
                }
            }
        } catch (Throwable th8) {
            th = th8;
            th = null;
        }
    }

    private int lookupOnly(String str) {
        while (true) {
            int iBinarySearch = Collections.binarySearch(this.only, str);
            if (iBinarySearch >= 0) {
                return iBinarySearch;
            }
            int iLastIndexOf = str.lastIndexOf(47);
            if (iLastIndexOf < 1) {
                return -1;
            }
            str = str.substring(0, iLastIndexOf);
        }
    }

    private void processOptions(RepositoryState repositoryState, RevWalk revWalk) throws NoMessageException, UnsupportedSigningFormatException {
        if (this.committer == null) {
            this.committer = new PersonIdent(this.repo);
        }
        if (this.author == null && !this.amend) {
            this.author = this.committer;
        }
        if (this.allowEmpty == null) {
            this.allowEmpty = this.only.isEmpty() ? Boolean.TRUE : Boolean.FALSE;
        }
        if (repositoryState == RepositoryState.MERGING_RESOLVED || isMergeDuringRebase(repositoryState)) {
            try {
                List<ObjectId> mergeHeads = this.repo.readMergeHeads();
                this.parents = mergeHeads;
                if (mergeHeads != null) {
                    for (int i = 0; i < this.parents.size(); i++) {
                        RevObject any = revWalk.parseAny(this.parents.get(i));
                        if (any instanceof RevTag) {
                            this.parents.set(i, revWalk.peel(any));
                        }
                    }
                }
                if (this.message == null) {
                    try {
                        this.message = this.repo.readMergeCommitMsg();
                    } catch (IOException e) {
                        throw new JGitInternalException(MessageFormat.format(JGitText.get().exceptionOccurredDuringReadingOfGIT_DIR, Constants.MERGE_MSG, e), e);
                    }
                }
            } catch (IOException e2) {
                throw new JGitInternalException(MessageFormat.format(JGitText.get().exceptionOccurredDuringReadingOfGIT_DIR, Constants.MERGE_HEAD, e2), e2);
            }
        } else if (repositoryState == RepositoryState.SAFE && this.message == null) {
            try {
                String squashCommitMsg = this.repo.readSquashCommitMsg();
                this.message = squashCommitMsg;
                if (squashCommitMsg != null) {
                    this.repo.writeSquashCommitMsg(null);
                }
            } catch (IOException e3) {
                throw new JGitInternalException(MessageFormat.format(JGitText.get().exceptionOccurredDuringReadingOfGIT_DIR, Constants.MERGE_MSG, e3), e3);
            }
        }
        if (this.message == null) {
            throw new NoMessageException(JGitText.get().commitMessageNotSpecified);
        }
        if (this.gpgConfig == null) {
            this.gpgConfig = new GpgConfig(this.repo.getConfig());
        }
        if (this.signCommit == null) {
            this.signCommit = this.gpgConfig.isSignCommits() ? Boolean.TRUE : Boolean.FALSE;
        }
    }

    private boolean isMergeDuringRebase(RepositoryState repositoryState) {
        if (repositoryState != RepositoryState.REBASING_INTERACTIVE && repositoryState != RepositoryState.REBASING_MERGE) {
            return false;
        }
        try {
            return this.repo.readMergeHeads() != null;
        } catch (IOException e) {
            throw new JGitInternalException(MessageFormat.format(JGitText.get().exceptionOccurredDuringReadingOfGIT_DIR, Constants.MERGE_HEAD, e), e);
        }
    }

    public CommitCommand setMessage(String str) {
        checkCallable();
        this.message = str;
        return this;
    }

    public CommitCommand setCleanupMode(CommitConfig.CleanupMode cleanupMode) {
        checkCallable();
        this.cleanupMode = cleanupMode;
        return this;
    }

    public CommitCommand setDefaultClean(boolean z) {
        checkCallable();
        this.cleanDefaultIsStrip = z;
        return this;
    }

    public CommitCommand setCommentCharacter(Character ch) {
        checkCallable();
        this.commentChar = ch;
        return this;
    }

    public CommitCommand setAllowEmpty(boolean z) {
        this.allowEmpty = Boolean.valueOf(z);
        return this;
    }

    public String getMessage() {
        return this.message;
    }

    public CommitCommand setCommitter(PersonIdent personIdent) {
        checkCallable();
        this.committer = personIdent;
        return this;
    }

    public CommitCommand setCommitter(String str, String str2) {
        checkCallable();
        return setCommitter(new PersonIdent(str, str2));
    }

    public PersonIdent getCommitter() {
        return this.committer;
    }

    public CommitCommand setAuthor(PersonIdent personIdent) {
        checkCallable();
        this.author = personIdent;
        return this;
    }

    public CommitCommand setAuthor(String str, String str2) {
        checkCallable();
        return setAuthor(new PersonIdent(str, str2));
    }

    public PersonIdent getAuthor() {
        return this.author;
    }

    public CommitCommand setAll(boolean z) {
        checkCallable();
        if (z && !this.only.isEmpty()) {
            throw new JGitInternalException(MessageFormat.format(JGitText.get().illegalCombinationOfArguments, "--all", "--only"));
        }
        this.all = z;
        return this;
    }

    public CommitCommand setAmend(boolean z) {
        checkCallable();
        this.amend = z;
        return this;
    }

    public CommitCommand setOnly(String str) {
        checkCallable();
        if (this.all) {
            throw new JGitInternalException(MessageFormat.format(JGitText.get().illegalCombinationOfArguments, "--only", "--all"));
        }
        if (str.endsWith(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
            str = str.substring(0, str.length() - 1);
        }
        if (!this.only.contains(str)) {
            this.only.add(str);
        }
        return this;
    }

    public CommitCommand setInsertChangeId(boolean z) {
        checkCallable();
        this.insertChangeId = z;
        return this;
    }

    public CommitCommand setReflogComment(String str) {
        this.reflogComment = str;
        this.useDefaultReflogMessage = false;
        return this;
    }

    public CommitCommand setNoVerify(boolean z) {
        this.noVerify = z;
        return this;
    }

    public CommitCommand setHookOutputStream(PrintStream printStream) {
        setHookOutputStream(PreCommitHook.NAME, printStream);
        setHookOutputStream(CommitMsgHook.NAME, printStream);
        setHookOutputStream(PostCommitHook.NAME, printStream);
        return this;
    }

    public CommitCommand setHookErrorStream(PrintStream printStream) {
        setHookErrorStream(PreCommitHook.NAME, printStream);
        setHookErrorStream(CommitMsgHook.NAME, printStream);
        setHookErrorStream(PostCommitHook.NAME, printStream);
        return this;
    }

    public CommitCommand setHookOutputStream(String str, PrintStream printStream) {
        if (!PreCommitHook.NAME.equals(str) && !CommitMsgHook.NAME.equals(str) && !PostCommitHook.NAME.equals(str)) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.get().illegalHookName, str));
        }
        this.hookOutRedirect.put(str, printStream);
        return this;
    }

    public CommitCommand setHookErrorStream(String str, PrintStream printStream) {
        if (!PreCommitHook.NAME.equals(str) && !CommitMsgHook.NAME.equals(str) && !PostCommitHook.NAME.equals(str)) {
            throw new IllegalArgumentException(MessageFormat.format(JGitText.get().illegalHookName, str));
        }
        this.hookErrRedirect.put(str, printStream);
        return this;
    }

    public CommitCommand setSigningKey(String str) {
        checkCallable();
        this.signingKey = str;
        return this;
    }

    public CommitCommand setSign(Boolean bool) {
        checkCallable();
        this.signCommit = bool;
        return this;
    }

    public CommitCommand setSigner(Signer signer) {
        checkCallable();
        this.signer = signer;
        return this;
    }

    public CommitCommand setGpgConfig(GpgConfig gpgConfig) {
        checkCallable();
        this.gpgConfig = gpgConfig;
        return this;
    }

    public CommitCommand setCredentialsProvider(CredentialsProvider credentialsProvider) {
        this.credentialsProvider = credentialsProvider;
        return this;
    }
}
