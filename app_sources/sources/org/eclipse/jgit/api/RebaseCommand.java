package org.eclipse.jgit.api;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.commons.codec.language.Soundex;
import org.apache.http.message.TokenParser;
import org.eclipse.jgit.api.errors.CheckoutConflictException;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRebaseStepException;
import org.eclipse.jgit.api.errors.InvalidRefNameException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.api.errors.RefAlreadyExistsException;
import org.eclipse.jgit.api.errors.RefNotFoundException;
import org.eclipse.jgit.api.errors.StashApplyFailureException;
import org.eclipse.jgit.api.errors.UnmergedPathsException;
import org.eclipse.jgit.api.errors.WrongRepositoryStateException;
import org.eclipse.jgit.diff.DiffFormatter;
import org.eclipse.jgit.dircache.DirCache;
import org.eclipse.jgit.dircache.DirCacheCheckout;
import org.eclipse.jgit.dircache.DirCacheIterator;
import org.eclipse.jgit.errors.RevisionSyntaxException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.AbbreviatedObjectId;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.CommitConfig;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.NullProgressMonitor;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectReader;
import org.eclipse.jgit.lib.PersonIdent;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.lib.RebaseTodoLine;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.RefUpdate;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.RepositoryState;
import org.eclipse.jgit.merge.ContentMergeStrategy;
import org.eclipse.jgit.merge.MergeStrategy;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevSort;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.revwalk.filter.RevFilter;
import org.eclipse.jgit.submodule.SubmoduleWalk;
import org.eclipse.jgit.treewalk.TreeWalk;
import org.eclipse.jgit.treewalk.filter.TreeFilter;
import org.eclipse.jgit.util.FileUtils;
import org.eclipse.jgit.util.IO;
import org.eclipse.jgit.util.RawParseUtils;

/* INFO: loaded from: classes5.dex */
public class RebaseCommand extends GitCommand<RebaseResult> {
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$api$CherryPickResult$CherryPickStatus = null;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$api$RebaseCommand$Operation = null;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$lib$RebaseTodoLine$Action = null;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$lib$RefUpdate$Result = null;
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$lib$RepositoryState = null;
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String AMEND = "amend";
    private static final String AUTHOR_SCRIPT = "author-script";
    private static final String AUTOSTASH = "autostash";
    private static final String AUTOSTASH_MSG = "On {0}: autostash";
    private static final String CURRENT_COMMIT = "current-commit";
    private static final String DONE = "done";
    private static final String GIT_AUTHOR_DATE = "GIT_AUTHOR_DATE";
    private static final String GIT_AUTHOR_EMAIL = "GIT_AUTHOR_EMAIL";
    private static final String GIT_AUTHOR_NAME = "GIT_AUTHOR_NAME";
    private static final String GIT_REBASE_TODO = "git-rebase-todo";
    private static final String HEAD_NAME = "head-name";
    private static final String INTERACTIVE = "interactive";
    private static final String MESSAGE = "message";
    private static final String MESSAGE_FIXUP = "message-fixup";
    private static final String MESSAGE_SQUASH = "message-squash";
    private static final String ONTO = "onto";
    private static final String ONTO_NAME = "onto_name";
    private static final String PATCH = "patch";
    private static final String QUIET = "quiet";
    private static final String REBASE_APPLY = "rebase-apply";
    private static final String REBASE_HEAD = "orig-head";
    private static final String REBASE_HEAD_LEGACY = "head";
    public static final String REBASE_MERGE = "rebase-merge";
    private static final String REFLOG_PREFIX = "rebase:";
    private static final String REWRITTEN = "rewritten";
    public static final String STOPPED_SHA = "stopped-sha";
    private CommitConfig commitConfig;
    private ContentMergeStrategy contentStrategy;
    private InteractiveHandler interactiveHandler;
    private boolean lastStepWasForward;
    private ProgressMonitor monitor;
    private RevCommit newHead;
    private Operation operation;
    private boolean preserveMerges;
    private final RebaseState rebaseState;
    private boolean stopAfterInitialization;
    private MergeStrategy strategy;
    private RevCommit upstreamCommit;
    private String upstreamCommitName;
    private final RevWalk walk;

    public interface InteractiveHandler {
        String modifyCommitMessage(String str);

        void prepareSteps(List<RebaseTodoLine> list);
    }

    public enum Operation {
        BEGIN,
        CONTINUE,
        SKIP,
        ABORT,
        PROCESS_STEPS;

        /* INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static Operation[] valuesCustom() {
            Operation[] operationArrValuesCustom = values();
            int length = operationArrValuesCustom.length;
            Operation[] operationArr = new Operation[length];
            System.arraycopy(operationArrValuesCustom, 0, operationArr, 0, length);
            return operationArr;
        }
    }

    static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$api$CherryPickResult$CherryPickStatus() {
        int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$api$CherryPickResult$CherryPickStatus;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[CherryPickResult.CherryPickStatus.values().length];
        try {
            iArr2[CherryPickResult.CherryPickStatus.CONFLICTING.ordinal()] = 3;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[CherryPickResult.CherryPickStatus.FAILED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[CherryPickResult.CherryPickStatus.OK.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        $SWITCH_TABLE$org$eclipse$jgit$api$CherryPickResult$CherryPickStatus = iArr2;
        return iArr2;
    }

    static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$api$RebaseCommand$Operation() {
        int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$api$RebaseCommand$Operation;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[Operation.valuesCustom().length];
        try {
            iArr2[Operation.ABORT.ordinal()] = 4;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[Operation.BEGIN.ordinal()] = 1;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[Operation.CONTINUE.ordinal()] = 2;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[Operation.PROCESS_STEPS.ordinal()] = 5;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[Operation.SKIP.ordinal()] = 3;
        } catch (NoSuchFieldError unused5) {
        }
        $SWITCH_TABLE$org$eclipse$jgit$api$RebaseCommand$Operation = iArr2;
        return iArr2;
    }

    static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$lib$RebaseTodoLine$Action() {
        int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$lib$RebaseTodoLine$Action;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[RebaseTodoLine.Action.valuesCustom().length];
        try {
            iArr2[RebaseTodoLine.Action.COMMENT.ordinal()] = 6;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[RebaseTodoLine.Action.EDIT.ordinal()] = 3;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[RebaseTodoLine.Action.FIXUP.ordinal()] = 5;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[RebaseTodoLine.Action.PICK.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[RebaseTodoLine.Action.REWORD.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[RebaseTodoLine.Action.SQUASH.ordinal()] = 4;
        } catch (NoSuchFieldError unused6) {
        }
        $SWITCH_TABLE$org$eclipse$jgit$lib$RebaseTodoLine$Action = iArr2;
        return iArr2;
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

    static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$lib$RepositoryState() {
        int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$lib$RepositoryState;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[RepositoryState.values().length];
        try {
            iArr2[RepositoryState.APPLY.ordinal()] = 11;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[RepositoryState.BARE.ordinal()] = 1;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[RepositoryState.BISECTING.ordinal()] = 14;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[RepositoryState.CHERRY_PICKING.ordinal()] = 5;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[RepositoryState.CHERRY_PICKING_RESOLVED.ordinal()] = 6;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[RepositoryState.MERGING.ordinal()] = 3;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            iArr2[RepositoryState.MERGING_RESOLVED.ordinal()] = 4;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            iArr2[RepositoryState.REBASING.ordinal()] = 9;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            iArr2[RepositoryState.REBASING_INTERACTIVE.ordinal()] = 13;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            iArr2[RepositoryState.REBASING_MERGE.ordinal()] = 12;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            iArr2[RepositoryState.REBASING_REBASING.ordinal()] = 10;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            iArr2[RepositoryState.REVERTING.ordinal()] = 7;
        } catch (NoSuchFieldError unused12) {
        }
        try {
            iArr2[RepositoryState.REVERTING_RESOLVED.ordinal()] = 8;
        } catch (NoSuchFieldError unused13) {
        }
        try {
            iArr2[RepositoryState.SAFE.ordinal()] = 2;
        } catch (NoSuchFieldError unused14) {
        }
        $SWITCH_TABLE$org$eclipse$jgit$lib$RepositoryState = iArr2;
        return iArr2;
    }

    protected RebaseCommand(Repository repository) {
        super(repository);
        this.operation = Operation.BEGIN;
        this.monitor = NullProgressMonitor.INSTANCE;
        this.stopAfterInitialization = false;
        this.strategy = MergeStrategy.RECURSIVE;
        this.preserveMerges = false;
        this.walk = new RevWalk(repository);
        this.rebaseState = new RebaseState(repository.getDirectory());
    }

    /* WARN: Code duplicated, block: B:20:0x004f A[Catch: IOException -> 0x01cf, CheckoutConflictException -> 0x01da, TRY_LEAVE, TryCatch #1 {CheckoutConflictException -> 0x01da, blocks: (B:3:0x001e, B:45:0x00f0, B:47:0x00f8, B:49:0x00ff, B:51:0x0105, B:53:0x0128, B:55:0x0130, B:58:0x014a, B:60:0x0158, B:61:0x015b, B:64:0x0161, B:66:0x0164, B:68:0x016a, B:69:0x0170, B:71:0x0182, B:73:0x0193, B:75:0x0199, B:76:0x01a9, B:77:0x01b0, B:79:0x01b6, B:81:0x01bf, B:15:0x003d, B:18:0x0045, B:19:0x004e, B:20:0x004f, B:21:0x0057, B:24:0x0064, B:23:0x0062, B:25:0x007f, B:27:0x0086, B:33:0x00c5, B:35:0x00cd, B:38:0x00d2, B:40:0x00d8, B:41:0x00da, B:43:0x00e6, B:29:0x009a, B:31:0x00b4), top: B:92:0x001e }] */
    /* WARN: Code duplicated, block: B:29:0x009a A[Catch: IOException -> 0x01cf, CheckoutConflictException -> 0x01da, TryCatch #1 {CheckoutConflictException -> 0x01da, blocks: (B:3:0x001e, B:45:0x00f0, B:47:0x00f8, B:49:0x00ff, B:51:0x0105, B:53:0x0128, B:55:0x0130, B:58:0x014a, B:60:0x0158, B:61:0x015b, B:64:0x0161, B:66:0x0164, B:68:0x016a, B:69:0x0170, B:71:0x0182, B:73:0x0193, B:75:0x0199, B:76:0x01a9, B:77:0x01b0, B:79:0x01b6, B:81:0x01bf, B:15:0x003d, B:18:0x0045, B:19:0x004e, B:20:0x004f, B:21:0x0057, B:24:0x0064, B:23:0x0062, B:25:0x007f, B:27:0x0086, B:33:0x00c5, B:35:0x00cd, B:38:0x00d2, B:40:0x00d8, B:41:0x00da, B:43:0x00e6, B:29:0x009a, B:31:0x00b4), top: B:92:0x001e }] */
    /* WARN: Code duplicated, block: B:31:0x00b4 A[Catch: IOException -> 0x01cf, CheckoutConflictException -> 0x01da, TryCatch #1 {CheckoutConflictException -> 0x01da, blocks: (B:3:0x001e, B:45:0x00f0, B:47:0x00f8, B:49:0x00ff, B:51:0x0105, B:53:0x0128, B:55:0x0130, B:58:0x014a, B:60:0x0158, B:61:0x015b, B:64:0x0161, B:66:0x0164, B:68:0x016a, B:69:0x0170, B:71:0x0182, B:73:0x0193, B:75:0x0199, B:76:0x01a9, B:77:0x01b0, B:79:0x01b6, B:81:0x01bf, B:15:0x003d, B:18:0x0045, B:19:0x004e, B:20:0x004f, B:21:0x0057, B:24:0x0064, B:23:0x0062, B:25:0x007f, B:27:0x0086, B:33:0x00c5, B:35:0x00cd, B:38:0x00d2, B:40:0x00d8, B:41:0x00da, B:43:0x00e6, B:29:0x009a, B:31:0x00b4), top: B:92:0x001e }] */
    @Override // org.eclipse.jgit.api.GitCommand, java.util.concurrent.Callable
    public RebaseResult call() throws GitAPIException {
        Status statusCall;
        RebaseResult rebaseResultProcessStep;
        this.newHead = null;
        this.lastStepWasForward = false;
        checkCallable();
        checkParameters();
        this.commitConfig = (CommitConfig) this.repo.getConfig().get(CommitConfig.KEY);
        try {
            try {
                int i = $SWITCH_TABLE$org$eclipse$jgit$api$RebaseCommand$Operation()[this.operation.ordinal()];
                if (i == 1) {
                    autoStash();
                    if (!this.stopAfterInitialization) {
                        RevWalk revWalk = this.walk;
                        if (!revWalk.isMergedInto(revWalk.parseCommit(this.repo.resolve("HEAD")), this.upstreamCommit)) {
                            statusCall = Git.wrap(this.repo).status().setIgnoreSubmodules(SubmoduleWalk.IgnoreSubmoduleMode.ALL).call();
                            if (statusCall.hasUncommittedChanges()) {
                                ArrayList arrayList = new ArrayList();
                                arrayList.addAll(statusCall.getUncommittedChanges());
                                return RebaseResult.uncommittedChanges(arrayList);
                            }
                        }
                    } else {
                        statusCall = Git.wrap(this.repo).status().setIgnoreSubmodules(SubmoduleWalk.IgnoreSubmoduleMode.ALL).call();
                        if (statusCall.hasUncommittedChanges()) {
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.addAll(statusCall.getUncommittedChanges());
                            return RebaseResult.uncommittedChanges(arrayList2);
                        }
                    }
                    RebaseResult rebaseResultInitFilesAndRewind = initFilesAndRewind();
                    if (this.stopAfterInitialization) {
                        return RebaseResult.INTERACTIVE_PREPARED_RESULT;
                    }
                    if (rebaseResultInitFilesAndRewind != null) {
                        if (!autoStashApply()) {
                            rebaseResultInitFilesAndRewind = RebaseResult.STASH_APPLY_CONFLICTS_RESULT;
                        }
                        if (this.rebaseState.getDir().exists()) {
                            FileUtils.delete(this.rebaseState.getDir(), 1);
                        }
                        return rebaseResultInitFilesAndRewind;
                    }
                } else if (i == 2 || i == 3) {
                    String file = this.rebaseState.readFile(ONTO);
                    try {
                        this.upstreamCommitName = this.rebaseState.readFile(ONTO_NAME);
                    } catch (FileNotFoundException unused) {
                        this.upstreamCommitName = file;
                    }
                    this.upstreamCommit = this.walk.parseCommit(this.repo.resolve(file));
                    this.preserveMerges = this.rebaseState.getRewrittenDir().isDirectory();
                } else {
                    if (i == 4) {
                        try {
                            return abort(RebaseResult.ABORTED_RESULT);
                        } catch (IOException e) {
                            throw new JGitInternalException(e.getMessage(), e);
                        }
                    }
                    if (i == 5) {
                        String file2 = this.rebaseState.readFile(ONTO);
                        this.upstreamCommitName = this.rebaseState.readFile(ONTO_NAME);
                        this.upstreamCommit = this.walk.parseCommit(this.repo.resolve(file2));
                        this.preserveMerges = this.rebaseState.getRewrittenDir().isDirectory();
                    }
                }
                if (this.monitor.isCancelled()) {
                    return abort(RebaseResult.ABORTED_RESULT);
                }
                if (this.operation == Operation.CONTINUE) {
                    this.newHead = continueRebase();
                    List<RebaseTodoLine> rebaseTodo = this.repo.readRebaseTodo(this.rebaseState.getPath("done"), true);
                    RebaseTodoLine rebaseTodoLine = rebaseTodo.get(rebaseTodo.size() - 1);
                    if (this.newHead != null && rebaseTodoLine.getAction() != RebaseTodoLine.Action.PICK && (rebaseResultProcessStep = processStep(new RebaseTodoLine(rebaseTodoLine.getAction(), AbbreviatedObjectId.fromObjectId(this.newHead), rebaseTodoLine.getShortMessage()), false)) != null) {
                        return rebaseResultProcessStep;
                    }
                    File file3 = this.rebaseState.getFile(AMEND);
                    boolean zExists = file3.exists();
                    if (zExists) {
                        FileUtils.delete(file3);
                    }
                    if (this.newHead == null && !zExists) {
                        return RebaseResult.NOTHING_TO_COMMIT_RESULT;
                    }
                }
                if (this.operation == Operation.SKIP) {
                    this.newHead = checkoutCurrentHead();
                }
                List<RebaseTodoLine> rebaseTodo2 = this.repo.readRebaseTodo(this.rebaseState.getPath(GIT_REBASE_TODO), false);
                if (rebaseTodo2.isEmpty()) {
                    return finishRebase(this.walk.parseCommit(this.repo.resolve("HEAD")), false);
                }
                if (isInteractive()) {
                    this.interactiveHandler.prepareSteps(rebaseTodo2);
                    this.repo.writeRebaseTodoFile(this.rebaseState.getPath(GIT_REBASE_TODO), rebaseTodo2, false);
                }
                checkSteps(rebaseTodo2);
                for (RebaseTodoLine rebaseTodoLine2 : rebaseTodo2) {
                    popSteps(1);
                    RebaseResult rebaseResultProcessStep2 = processStep(rebaseTodoLine2, true);
                    if (rebaseResultProcessStep2 != null) {
                        return rebaseResultProcessStep2;
                    }
                }
                return finishRebase(this.newHead, this.lastStepWasForward);
            } catch (CheckoutConflictException e2) {
                return RebaseResult.conflicts(e2.getConflictingPaths());
            }
        } catch (IOException e3) {
            throw new JGitInternalException(e3.getMessage(), e3);
        }
    }

    private void autoStash() throws GitAPIException, IOException {
        if (this.repo.getConfig().getBoolean("rebase", "autostash", false)) {
            RevCommit revCommitCall = Git.wrap(this.repo).stashCreate().setRef(null).setWorkingDirectoryMessage(MessageFormat.format(AUTOSTASH_MSG, Repository.shortenRefName(getHeadName(getHead())))).call();
            if (revCommitCall != null) {
                FileUtils.mkdir(this.rebaseState.getDir());
                this.rebaseState.createFile("autostash", revCommitCall.getName());
            }
        }
    }

    private boolean autoStashApply() throws Throwable {
        Throwable th;
        if (this.rebaseState.getFile("autostash").exists()) {
            String file = this.rebaseState.readFile("autostash");
            Throwable th2 = null;
            try {
                Git gitWrap = Git.wrap(this.repo);
                try {
                    gitWrap.stashApply().setStashRef(file).ignoreRepositoryState(true).setStrategy(this.strategy).call();
                    if (gitWrap != null) {
                        gitWrap.close();
                        return true;
                    }
                } catch (Throwable th3) {
                    if (gitWrap != null) {
                        try {
                            gitWrap.close();
                        } catch (Throwable th4) {
                            th = th3;
                            th = th4;
                            if (th == null) {
                                throw th;
                            }
                            if (th != th) {
                                try {
                                    try {
                                        th.addSuppressed(th);
                                    } catch (StashApplyFailureException unused) {
                                        RevWalk revWalk = new RevWalk(this.repo);
                                        try {
                                            RevCommit commit = revWalk.parseCommit(this.repo.resolve(file));
                                            updateStashRef(commit, commit.getAuthorIdent(), commit.getShortMessage());
                                            return false;
                                        } finally {
                                            revWalk.close();
                                        }
                                    }
                                } catch (Throwable th5) {
                                    if (0 == 0) {
                                        throw th5;
                                    }
                                    if (null != th5) {
                                        th2.addSuppressed(th5);
                                    }
                                    throw null;
                                }
                            }
                            throw th;
                        }
                    }
                    throw th3;
                }
            } catch (Throwable th6) {
                th = th6;
                th = null;
            }
        }
        return true;
    }

    private void updateStashRef(ObjectId objectId, PersonIdent personIdent, String str) throws IOException {
        Ref refExactRef = this.repo.exactRef(Constants.R_STASH);
        RefUpdate refUpdateUpdateRef = this.repo.updateRef(Constants.R_STASH);
        refUpdateUpdateRef.setNewObjectId(objectId);
        refUpdateUpdateRef.setRefLogIdent(personIdent);
        refUpdateUpdateRef.setRefLogMessage(str, false);
        refUpdateUpdateRef.setForceRefLog(true);
        if (refExactRef != null) {
            refUpdateUpdateRef.setExpectedOldObjectId(refExactRef.getObjectId());
        } else {
            refUpdateUpdateRef.setExpectedOldObjectId(ObjectId.zeroId());
        }
        refUpdateUpdateRef.forceUpdate();
    }

    private RebaseResult processStep(RebaseTodoLine rebaseTodoLine, boolean z) throws GitAPIException, IOException {
        boolean z2;
        int i;
        Throwable th = null;
        if (RebaseTodoLine.Action.COMMENT.equals(rebaseTodoLine.getAction())) {
            return null;
        }
        if (this.preserveMerges && z && (RebaseTodoLine.Action.EDIT.equals(rebaseTodoLine.getAction()) || RebaseTodoLine.Action.PICK.equals(rebaseTodoLine.getAction()))) {
            writeRewrittenHashes();
        }
        Collection<ObjectId> collectionResolve = this.repo.newObjectReader().resolve(rebaseTodoLine.getCommit());
        if (collectionResolve.size() != 1) {
            throw new JGitInternalException(JGitText.get().cannotResolveUniquelyAbbrevObjectId);
        }
        RevCommit commit = this.walk.parseCommit(collectionResolve.iterator().next());
        if (z) {
            if (this.monitor.isCancelled()) {
                return RebaseResult.result(RebaseResult.Status.STOPPED, commit);
            }
            RebaseResult rebaseResultCherryPickCommit = cherryPickCommit(commit);
            if (rebaseResultCherryPickCommit != null) {
                return rebaseResultCherryPickCommit;
            }
        }
        int i2 = $SWITCH_TABLE$org$eclipse$jgit$lib$RebaseTodoLine$Action()[rebaseTodoLine.getAction().ordinal()];
        if (i2 == 2) {
            String fullMessage = commit.getFullMessage();
            boolean[] zArr = new boolean[1];
            String strEditCommitMessage = editCommitMessage(zArr, fullMessage, this.commitConfig.resolve(CommitConfig.CleanupMode.DEFAULT, true), this.commitConfig.getCommentChar(fullMessage));
            try {
                Git git = new Git(this.repo);
                try {
                    this.newHead = git.commit().setMessage(strEditCommitMessage).setAmend(true).setNoVerify(true).setInsertChangeId(zArr[0]).call();
                    return null;
                } finally {
                    git.close();
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
        if (i2 == 3) {
            this.rebaseState.createFile(AMEND, commit.name());
            return stop(commit, RebaseResult.Status.EDIT);
        }
        if (i2 != 4) {
            if (i2 == 5) {
                z2 = false;
            }
            return null;
        }
        z2 = true;
        resetSoftToParent();
        List<RebaseTodoLine> rebaseTodo = this.repo.readRebaseTodo(this.rebaseState.getPath(GIT_REBASE_TODO), false);
        boolean zIsEmpty = rebaseTodo.isEmpty();
        boolean z3 = (zIsEmpty || (i = $SWITCH_TABLE$org$eclipse$jgit$lib$RebaseTodoLine$Action()[rebaseTodo.get(0).getAction().ordinal()]) == 4 || i == 5) ? zIsEmpty : true;
        File file = this.rebaseState.getFile(MESSAGE_FIXUP);
        File file2 = this.rebaseState.getFile(MESSAGE_SQUASH);
        if (z2 && file.exists()) {
            file.delete();
        }
        this.newHead = doSquashFixup(z2, commit, z3, file, file2);
        return null;
    }

    private String editCommitMessage(boolean[] zArr, String str, CommitConfig.CleanupMode cleanupMode, char c) {
        String strModifyCommitMessage;
        InteractiveHandler interactiveHandler = this.interactiveHandler;
        if (interactiveHandler instanceof InteractiveHandler2) {
            InteractiveHandler2.ModifyResult modifyResultEditCommitMessage = ((InteractiveHandler2) interactiveHandler).editCommitMessage(str, cleanupMode, c);
            strModifyCommitMessage = modifyResultEditCommitMessage.getMessage();
            CommitConfig.CleanupMode cleanupMode2 = modifyResultEditCommitMessage.getCleanupMode();
            if (!CommitConfig.CleanupMode.DEFAULT.equals(cleanupMode2)) {
                cleanupMode = cleanupMode2;
            }
            zArr[0] = modifyResultEditCommitMessage.shouldAddChangeId();
        } else {
            strModifyCommitMessage = interactiveHandler.modifyCommitMessage(str);
            cleanupMode = CommitConfig.CleanupMode.STRIP;
            zArr[0] = false;
        }
        return CommitConfig.cleanText(strModifyCommitMessage, cleanupMode, c);
    }

    private RebaseResult cherryPickCommit(RevCommit revCommit) throws GitAPIException, IOException {
        RebaseResult rebaseResultCherryPickCommitFlattening;
        try {
            this.monitor.beginTask(MessageFormat.format(JGitText.get().applyingCommit, revCommit.getShortMessage()), 0);
            if (this.preserveMerges) {
                rebaseResultCherryPickCommitFlattening = cherryPickCommitPreservingMerges(revCommit);
            } else {
                rebaseResultCherryPickCommitFlattening = cherryPickCommitFlattening(revCommit);
            }
            return rebaseResultCherryPickCommitFlattening;
        } finally {
            this.monitor.endTask();
        }
    }

    private RebaseResult cherryPickCommitFlattening(RevCommit revCommit) throws GitAPIException, IOException {
        RebaseResult rebaseResultStop;
        RevCommit revCommitTryFastForward = tryFastForward(revCommit);
        this.newHead = revCommitTryFastForward;
        boolean z = revCommitTryFastForward != null;
        this.lastStepWasForward = z;
        Throwable th = null;
        if (!z) {
            String ourCommitName = getOurCommitName();
            try {
                Git git = new Git(this.repo);
                try {
                    CherryPickResult cherryPickResultCall = git.cherryPick().include(revCommit).setOurCommitName(ourCommitName).setReflogPrefix(REFLOG_PREFIX).setStrategy(this.strategy).setContentMergeStrategy(this.contentStrategy).call();
                    int i = $SWITCH_TABLE$org$eclipse$jgit$api$CherryPickResult$CherryPickStatus()[cherryPickResultCall.getStatus().ordinal()];
                    if (i != 1) {
                        if (i != 2) {
                            if (i == 3) {
                                rebaseResultStop = stop(revCommit, RebaseResult.Status.STOPPED);
                            }
                        } else if (this.operation == Operation.BEGIN) {
                            rebaseResultStop = abort(RebaseResult.failed(cherryPickResultCall.getFailingPaths()));
                        } else {
                            rebaseResultStop = stop(revCommit, RebaseResult.Status.STOPPED);
                        }
                        return rebaseResultStop;
                    }
                    this.newHead = cherryPickResultCall.getNewHead();
                } finally {
                    git.close();
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
        return null;
    }

    private RebaseResult cherryPickCommitPreservingMerges(RevCommit revCommit) throws GitAPIException, IOException {
        RebaseResult rebaseResultStop;
        writeCurrentCommit(revCommit);
        List<RevCommit> newParents = getNewParents(revCommit);
        boolean zEquals = true;
        for (int i = 1; i < revCommit.getParentCount(); i++) {
            zEquals &= newParents.get(i).equals((AnyObjectId) revCommit.getParent(i));
        }
        Throwable th = null;
        RevCommit revCommitTryFastForward = zEquals ? tryFastForward(revCommit) : null;
        this.newHead = revCommitTryFastForward;
        boolean z = revCommitTryFastForward != null;
        this.lastStepWasForward = z;
        if (!z) {
            ObjectId objectId = getHead().getObjectId();
            if (!AnyObjectId.isEqual(objectId, newParents.get(0))) {
                checkoutCommit(objectId.getName(), newParents.get(0));
            }
            try {
                Git git = new Git(this.repo);
                try {
                    if (zEquals) {
                        boolean z2 = revCommit.getParentCount() > 1;
                        CherryPickCommand contentMergeStrategy = git.cherryPick().include(revCommit).setOurCommitName(getOurCommitName()).setReflogPrefix(REFLOG_PREFIX).setStrategy(this.strategy).setContentMergeStrategy(this.contentStrategy);
                        if (z2) {
                            contentMergeStrategy.setMainlineParentNumber(1);
                            contentMergeStrategy.setNoCommit(true);
                            writeMergeInfo(revCommit, newParents);
                        }
                        CherryPickResult cherryPickResultCall = contentMergeStrategy.call();
                        int i2 = $SWITCH_TABLE$org$eclipse$jgit$api$CherryPickResult$CherryPickStatus()[cherryPickResultCall.getStatus().ordinal()];
                        if (i2 != 1) {
                            if (i2 != 2) {
                                if (i2 == 3) {
                                    rebaseResultStop = stop(revCommit, RebaseResult.Status.STOPPED);
                                }
                            } else if (this.operation == Operation.BEGIN) {
                                rebaseResultStop = abort(RebaseResult.failed(cherryPickResultCall.getFailingPaths()));
                            } else {
                                rebaseResultStop = stop(revCommit, RebaseResult.Status.STOPPED);
                            }
                            git.close();
                            return rebaseResultStop;
                        }
                        if (z2) {
                            CommitCommand commitCommandCommit = git.commit();
                            commitCommandCommit.setAuthor(revCommit.getAuthorIdent());
                            commitCommandCommit.setReflogComment("rebase: " + revCommit.getShortMessage());
                            this.newHead = commitCommandCommit.call();
                        } else {
                            this.newHead = cherryPickResultCall.getNewHead();
                        }
                        git.close();
                    } else {
                        MergeCommand commit = git.merge().setFastForward(MergeCommand.FastForwardMode.NO_FF).setProgressMonitor(this.monitor).setStrategy(this.strategy).setContentMergeStrategy(this.contentStrategy).setCommit(false);
                        for (int i3 = 1; i3 < revCommit.getParentCount(); i3++) {
                            commit.include(newParents.get(i3));
                        }
                        MergeResult mergeResultCall = commit.call();
                        if (mergeResultCall.getMergeStatus().isSuccessful()) {
                            CommitCommand commitCommandCommit2 = git.commit();
                            commitCommandCommit2.setAuthor(revCommit.getAuthorIdent());
                            commitCommandCommit2.setMessage(revCommit.getFullMessage());
                            commitCommandCommit2.setReflogComment("rebase: " + revCommit.getShortMessage());
                            this.newHead = commitCommandCommit2.call();
                            git.close();
                        } else {
                            if (this.operation == Operation.BEGIN && mergeResultCall.getMergeStatus() == MergeResult.MergeStatus.FAILED) {
                                rebaseResultStop = abort(RebaseResult.failed(mergeResultCall.getFailingPaths()));
                            } else {
                                rebaseResultStop = stop(revCommit, RebaseResult.Status.STOPPED);
                            }
                            git.close();
                            return rebaseResultStop;
                        }
                    }
                } catch (Throwable th2) {
                    git.close();
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
        return null;
    }

    private void writeMergeInfo(RevCommit revCommit, List<RevCommit> list) throws IOException {
        this.repo.writeMergeHeads(list.subList(1, list.size()));
        this.repo.writeMergeCommitMsg(revCommit.getFullMessage());
    }

    private List<RevCommit> getNewParents(RevCommit revCommit) throws IOException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < revCommit.getParentCount(); i++) {
            String name = revCommit.getParent(i).getName();
            if (!new File(this.rebaseState.getRewrittenDir(), name).exists()) {
                arrayList.add(revCommit.getParent(i));
            } else {
                String file = RebaseState.readFile(this.rebaseState.getRewrittenDir(), name);
                if (file.length() == 0) {
                    arrayList.add(this.walk.parseCommit(this.repo.resolve("HEAD")));
                } else {
                    arrayList.add(this.walk.parseCommit(ObjectId.fromString(file)));
                }
            }
        }
        return arrayList;
    }

    private void writeCurrentCommit(RevCommit revCommit) throws IOException {
        RebaseState.appendToFile(this.rebaseState.getFile(CURRENT_COMMIT), revCommit.name());
    }

    private void writeRewrittenHashes() throws RefNotFoundException, RevisionSyntaxException, IOException {
        File file = this.rebaseState.getFile(CURRENT_COMMIT);
        if (file.exists()) {
            String name = getHead().getObjectId().getName();
            for (String str : this.rebaseState.readFile(CURRENT_COMMIT).split("\n")) {
                RebaseState.createFile(this.rebaseState.getRewrittenDir(), str, name);
            }
            FileUtils.delete(file);
        }
    }

    private RebaseResult finishRebase(RevCommit revCommit, boolean z) throws Throwable {
        updateHead(this.rebaseState.readFile(HEAD_NAME), revCommit, this.upstreamCommit);
        boolean zAutoStashApply = autoStashApply();
        getRepository().autoGC(this.monitor);
        FileUtils.delete(this.rebaseState.getDir(), 1);
        if (!zAutoStashApply) {
            return RebaseResult.STASH_APPLY_CONFLICTS_RESULT;
        }
        if (z || revCommit == null) {
            return RebaseResult.FAST_FORWARD_RESULT;
        }
        return RebaseResult.OK_RESULT;
    }

    private void checkSteps(List<RebaseTodoLine> list) throws InvalidRebaseStepException, IOException {
        if (list.isEmpty()) {
            return;
        }
        if (RebaseTodoLine.Action.SQUASH.equals(list.get(0).getAction()) || RebaseTodoLine.Action.FIXUP.equals(list.get(0).getAction())) {
            if (!this.rebaseState.getFile("done").exists() || this.rebaseState.readFile("done").trim().length() == 0) {
                throw new InvalidRebaseStepException(MessageFormat.format(JGitText.get().cannotSquashFixupWithoutPreviousCommit, list.get(0).getAction().name()));
            }
        }
    }

    private RevCommit doSquashFixup(boolean z, RevCommit revCommit, boolean z2, File file, File file2) throws GitAPIException, IOException {
        if (!file2.exists()) {
            RevCommit commit = this.walk.parseCommit(this.repo.resolve("HEAD"));
            initializeSquashFixupFile(MESSAGE_SQUASH, commit.getFullMessage());
            if (!z) {
                this.rebaseState.createFile(MESSAGE_FIXUP, commit.getFullMessage());
            }
        }
        String file3 = this.rebaseState.readFile(MESSAGE_SQUASH);
        this.rebaseState.createFile(MESSAGE_SQUASH, composeSquashMessage(z, revCommit, file3, parseSquashFixupSequenceCount(file3) + 1));
        return squashIntoPrevious(!file.exists(), z2);
    }

    private void resetSoftToParent() throws GitAPIException, IOException {
        Ref refExactRef = this.repo.exactRef(Constants.ORIG_HEAD);
        Throwable th = null;
        ObjectId objectId = refExactRef == null ? null : refExactRef.getObjectId();
        try {
            Git gitWrap = Git.wrap(this.repo);
            try {
                gitWrap.reset().setMode(ResetCommand.ResetType.SOFT).setRef("HEAD~1").call();
                if (gitWrap != null) {
                    gitWrap.close();
                }
                this.repo.writeOrigHead(objectId);
            } catch (Throwable th2) {
                if (gitWrap != null) {
                    gitWrap.close();
                }
                throw th2;
            }
        } catch (Throwable th3) {
            if (0 == 0) {
                throw th3;
            }
            if (null == th3) {
                throw null;
            }
            try {
                th.addSuppressed(th3);
                throw null;
            } catch (Throwable th4) {
                this.repo.writeOrigHead(objectId);
                throw th4;
            }
            this.repo.writeOrigHead(objectId);
            throw th4;
        }
    }

    private RevCommit squashIntoPrevious(boolean z, boolean z2) throws GitAPIException, IOException {
        String file;
        RevCommit revCommitCall;
        if (z2 && !z) {
            file = this.rebaseState.readFile(MESSAGE_FIXUP);
        } else {
            file = this.rebaseState.readFile(MESSAGE_SQUASH);
        }
        Throwable th = null;
        try {
            Git git = new Git(this.repo);
            try {
                if (z2) {
                    boolean[] zArr = new boolean[1];
                    if (z) {
                        file = editCommitMessage(zArr, file, CommitConfig.CleanupMode.STRIP, file.charAt(0));
                    }
                    revCommitCall = git.commit().setMessage(file).setAmend(true).setNoVerify(true).setInsertChangeId(zArr[0]).call();
                    this.rebaseState.getFile(MESSAGE_SQUASH).delete();
                    this.rebaseState.getFile(MESSAGE_FIXUP).delete();
                } else {
                    revCommitCall = git.commit().setMessage(file).setAmend(true).setNoVerify(true).call();
                }
                git.close();
                return revCommitCall;
            } catch (Throwable th2) {
                git.close();
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

    private String composeSquashMessage(boolean z, RevCommit revCommit, String str, int i) {
        StringBuilder sb = new StringBuilder();
        String ordinal = getOrdinal(i);
        char cCharAt = str.charAt(0);
        String fullMessage = revCommit.getFullMessage();
        if (!z) {
            sb.append(cCharAt).append(" This is a combination of ").append(i).append(" commits.\n");
            sb.append(str.substring(str.indexOf(10) + 1));
            sb.append('\n');
            sb.append(cCharAt).append(" The ").append(i).append(ordinal).append(" commit message will be skipped:\n").append(cCharAt).append(TokenParser.SP);
            sb.append(fullMessage.replaceAll("([\n\r])", "$1" + cCharAt + " "));
        } else {
            if (this.commitConfig.isAutoCommentChar()) {
                char commentChar = this.commitConfig.getCommentChar(CommitConfig.cleanText(str, CommitConfig.CleanupMode.STRIP, cCharAt) + "\n" + fullMessage);
                if (commentChar != cCharAt) {
                    str = replaceCommentChar(str, cCharAt, commentChar);
                    cCharAt = commentChar;
                }
            }
            sb.append(cCharAt).append(" This is a combination of ").append(i).append(" commits.\n");
            sb.append(str.substring(str.indexOf(10) + 1));
            sb.append('\n');
            sb.append(cCharAt).append(" This is the ").append(i).append(ordinal).append(" commit message:\n");
            sb.append(fullMessage);
        }
        return sb.toString();
    }

    private String replaceCommentChar(String str, char c, char c2) {
        return str.replaceAll("(?m)^(\\h*)" + c, "$1" + c2);
    }

    private static String getOrdinal(int i) {
        int i2 = i % 10;
        if (i2 == 1) {
            return "st";
        }
        if (i2 == 2) {
            return "nd";
        }
        if (i2 == 3) {
            return "rd";
        }
        return "th";
    }

    static int parseSquashFixupSequenceCount(String str) {
        Matcher matcher = Pattern.compile("This is a combination of (.*) commits").matcher(str.substring(0, str.indexOf(10)));
        if (!matcher.find()) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(matcher.group(1));
    }

    private void initializeSquashFixupFile(String str, String str2) throws IOException {
        char commentChar = this.commitConfig.getCommentChar(str2);
        this.rebaseState.createFile(str, commentChar + " This is a combination of 1 commits.\n" + commentChar + " The first commit's message is:\n" + str2);
    }

    private String getOurCommitName() {
        return "Upstream, based on " + Repository.shortenRefName(this.upstreamCommitName);
    }

    private void updateHead(String str, RevCommit revCommit, RevCommit revCommit2) throws IOException {
        if (str.startsWith(Constants.R_REFS)) {
            RefUpdate refUpdateUpdateRef = this.repo.updateRef(str);
            refUpdateUpdateRef.setNewObjectId(revCommit);
            refUpdateUpdateRef.setRefLogMessage("rebase finished: " + str + " onto " + revCommit2.getName(), false);
            int i = $SWITCH_TABLE$org$eclipse$jgit$lib$RefUpdate$Result()[refUpdateUpdateRef.forceUpdate().ordinal()];
            if (i != 3 && i != 5 && i != 6) {
                throw new JGitInternalException(JGitText.get().updatingHeadFailed);
            }
            RefUpdate refUpdateUpdateRef2 = this.repo.updateRef("HEAD");
            refUpdateUpdateRef2.setRefLogMessage("rebase finished: returning to " + str, false);
            int i2 = $SWITCH_TABLE$org$eclipse$jgit$lib$RefUpdate$Result()[refUpdateUpdateRef2.link(str).ordinal()];
            if (i2 != 3 && i2 != 5 && i2 != 6) {
                throw new JGitInternalException(JGitText.get().updatingHeadFailed);
            }
        }
    }

    private RevCommit checkoutCurrentHead() throws NoHeadException, IOException {
        ObjectId objectIdResolve = this.repo.resolve("HEAD^{tree}");
        if (objectIdResolve == null) {
            throw new NoHeadException(JGitText.get().cannotRebaseWithoutCurrentHead);
        }
        DirCache dirCacheLockDirCache = this.repo.lockDirCache();
        try {
            DirCacheCheckout dirCacheCheckout = new DirCacheCheckout(this.repo, dirCacheLockDirCache, objectIdResolve);
            dirCacheCheckout.setFailOnConflict(false);
            dirCacheCheckout.setProgressMonitor(this.monitor);
            if (dirCacheCheckout.checkout()) {
                Iterator<String> it = dirCacheCheckout.getToBeDeleted().iterator();
                while (it.hasNext()) {
                    File file = new File(this.repo.getWorkTree(), it.next());
                    if (this.repo.getFS().exists(file)) {
                        FileUtils.delete(file, 3);
                    }
                }
            }
            dirCacheLockDirCache.unlock();
            Throwable th = null;
            try {
                RevWalk revWalk = new RevWalk(this.repo);
                try {
                    return revWalk.parseCommit(this.repo.resolve("HEAD"));
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
        } catch (Throwable th3) {
            dirCacheLockDirCache.unlock();
            throw th3;
        }
    }

    private RevCommit continueRebase() throws GitAPIException, IOException {
        DirCache dirCache = this.repo.readDirCache();
        if (dirCache.hasUnmergedPaths()) {
            throw new UnmergedPathsException();
        }
        Throwable th = null;
        try {
            TreeWalk treeWalk = new TreeWalk(this.repo);
            try {
                treeWalk.reset();
                treeWalk.setRecursive(true);
                treeWalk.addTree(new DirCacheIterator(dirCache));
                ObjectId objectIdResolve = this.repo.resolve("HEAD^{tree}");
                if (objectIdResolve == null) {
                    throw new NoHeadException(JGitText.get().cannotRebaseWithoutCurrentHead);
                }
                treeWalk.addTree(objectIdResolve);
                treeWalk.setFilter(TreeFilter.ANY_DIFF);
                boolean next = treeWalk.next();
                treeWalk.close();
                if (!next) {
                    return null;
                }
                try {
                    Git git = new Git(this.repo);
                    try {
                        CommitCommand commitCommandCommit = git.commit();
                        commitCommandCommit.setMessage(this.rebaseState.readFile(MESSAGE));
                        commitCommandCommit.setAuthor(parseAuthor());
                        return commitCommandCommit.call();
                    } finally {
                        git.close();
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
            } catch (Throwable th3) {
                treeWalk.close();
                throw th3;
            }
        } catch (Throwable th4) {
            if (0 == 0) {
                throw th4;
            }
            if (null != th4) {
                th.addSuppressed(th4);
            }
            throw null;
        }
    }

    private PersonIdent parseAuthor() throws IOException {
        File file = this.rebaseState.getFile(AUTHOR_SCRIPT);
        try {
            return parseAuthor(IO.readFully(file));
        } catch (FileNotFoundException e) {
            if (file.exists()) {
                throw e;
            }
            return null;
        }
    }

    private RebaseResult stop(RevCommit revCommit, RebaseResult.Status status) throws IOException {
        this.rebaseState.createFile(AUTHOR_SCRIPT, toAuthorScript(revCommit.getAuthorIdent()));
        this.rebaseState.createFile(MESSAGE, revCommit.getFullMessage());
        Throwable th = null;
        if (revCommit.getParentCount() > 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                DiffFormatter diffFormatter = new DiffFormatter(byteArrayOutputStream);
                try {
                    diffFormatter.setRepository(this.repo);
                    diffFormatter.format(revCommit.getParent(0), revCommit);
                    diffFormatter.close();
                    this.rebaseState.createFile(PATCH, new String(byteArrayOutputStream.toByteArray(), StandardCharsets.UTF_8));
                } catch (Throwable th2) {
                    diffFormatter.close();
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
        } else {
            this.rebaseState.createFile(PATCH, "");
        }
        this.rebaseState.createFile(STOPPED_SHA, this.repo.newObjectReader().abbreviate(revCommit).name());
        this.repo.writeCherryPickHead(null);
        return RebaseResult.result(status, revCommit);
    }

    String toAuthorScript(PersonIdent personIdent) {
        StringBuilder sb = new StringBuilder(100);
        sb.append("GIT_AUTHOR_NAME='");
        sb.append(personIdent.getName());
        sb.append("'\nGIT_AUTHOR_EMAIL='");
        sb.append(personIdent.getEmailAddress());
        sb.append("'\nGIT_AUTHOR_DATE='@");
        String externalString = personIdent.toExternalString();
        sb.append(externalString.substring(externalString.lastIndexOf(62) + 2));
        sb.append("'\n");
        return sb.toString();
    }

    private void popSteps(int i) throws IOException {
        if (i == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (RebaseTodoLine rebaseTodoLine : this.repo.readRebaseTodo(this.rebaseState.getPath(GIT_REBASE_TODO), true)) {
            if (arrayList2.size() >= i || RebaseTodoLine.Action.COMMENT.equals(rebaseTodoLine.getAction())) {
                arrayList.add(rebaseTodoLine);
            } else {
                arrayList2.add(rebaseTodoLine);
            }
        }
        this.repo.writeRebaseTodoFile(this.rebaseState.getPath(GIT_REBASE_TODO), arrayList, false);
        if (arrayList2.isEmpty()) {
            return;
        }
        this.repo.writeRebaseTodoFile(this.rebaseState.getPath("done"), arrayList2, true);
    }

    private RebaseResult initFilesAndRewind() throws GitAPIException, IOException {
        Ref head = getHead();
        ObjectId objectId = head.getObjectId();
        if (objectId == null) {
            throw new RefNotFoundException(MessageFormat.format(JGitText.get().refNotResolved, "HEAD"));
        }
        String headName = getHeadName(head);
        RevCommit revCommitLookupCommit = this.walk.lookupCommit(objectId);
        RevCommit revCommitLookupCommit2 = this.walk.lookupCommit(this.upstreamCommit.getId());
        if (!isInteractive() && this.walk.isMergedInto(revCommitLookupCommit2, revCommitLookupCommit)) {
            return RebaseResult.UP_TO_DATE_RESULT;
        }
        if (!isInteractive() && this.walk.isMergedInto(revCommitLookupCommit, revCommitLookupCommit2)) {
            this.monitor.beginTask(MessageFormat.format(JGitText.get().resettingHead, this.upstreamCommit.getShortMessage()), 0);
            checkoutCommit(headName, this.upstreamCommit);
            this.monitor.endTask();
            updateHead(headName, this.upstreamCommit, revCommitLookupCommit2);
            return RebaseResult.FAST_FORWARD_RESULT;
        }
        this.monitor.beginTask(JGitText.get().obtainingCommitsForCherryPick, 0);
        FileUtils.mkdir(this.rebaseState.getDir(), true);
        this.repo.writeOrigHead(objectId);
        this.rebaseState.createFile(REBASE_HEAD, objectId.name());
        this.rebaseState.createFile(REBASE_HEAD_LEGACY, objectId.name());
        this.rebaseState.createFile(HEAD_NAME, headName);
        this.rebaseState.createFile(ONTO, this.upstreamCommit.name());
        this.rebaseState.createFile(ONTO_NAME, this.upstreamCommitName);
        if (isInteractive() || this.preserveMerges) {
            this.rebaseState.createFile(INTERACTIVE, "");
        }
        this.rebaseState.createFile("quiet", "");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new RebaseTodoLine("# Created by EGit: rebasing " + objectId.name() + " onto " + this.upstreamCommit.name()));
        List<RevCommit> listCalculatePickList = calculatePickList(revCommitLookupCommit);
        ObjectReader objectReader = this.walk.getObjectReader();
        for (RevCommit revCommit : listCalculatePickList) {
            arrayList.add(new RebaseTodoLine(RebaseTodoLine.Action.PICK, objectReader.abbreviate(revCommit), revCommit.getShortMessage()));
        }
        this.repo.writeRebaseTodoFile(this.rebaseState.getPath(GIT_REBASE_TODO), arrayList, false);
        this.monitor.endTask();
        this.monitor.beginTask(MessageFormat.format(JGitText.get().rewinding, this.upstreamCommit.getShortMessage()), 0);
        try {
            if (!checkoutCommit(headName, this.upstreamCommit)) {
                FileUtils.delete(this.rebaseState.getDir(), 1);
            }
            this.monitor.endTask();
            return null;
        } catch (Throwable th) {
            FileUtils.delete(this.rebaseState.getDir(), 1);
            throw th;
        }
    }

    private List<RevCommit> calculatePickList(RevCommit revCommit) throws IOException {
        ArrayList arrayList = new ArrayList();
        Throwable th = null;
        try {
            RevWalk revWalk = new RevWalk(this.repo);
            try {
                revWalk.sort(RevSort.TOPO_KEEP_BRANCH_TOGETHER, true);
                revWalk.sort(RevSort.COMMIT_TIME_DESC, true);
                revWalk.markUninteresting(revWalk.lookupCommit(this.upstreamCommit));
                revWalk.markStart(revWalk.lookupCommit(revCommit));
                for (RevCommit revCommit2 : revWalk) {
                    if (this.preserveMerges || revCommit2.getParentCount() <= 1) {
                        arrayList.add(revCommit2);
                    }
                }
                revWalk.close();
                Collections.reverse(arrayList);
                if (this.preserveMerges) {
                    File rewrittenDir = this.rebaseState.getRewrittenDir();
                    FileUtils.mkdir(rewrittenDir, false);
                    this.walk.reset();
                    this.walk.setRevFilter(RevFilter.MERGE_BASE);
                    this.walk.markStart(this.upstreamCommit);
                    this.walk.markStart(revCommit);
                    while (true) {
                        RevCommit next = this.walk.next();
                        if (next == null) {
                            break;
                        }
                        RebaseState.createFile(rewrittenDir, next.getName(), this.upstreamCommit.getName());
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        RevCommit revCommit3 = (RevCommit) it.next();
                        int parentCount = revCommit3.getParentCount();
                        if (parentCount != 0) {
                            int i = 0;
                            while (true) {
                                if (i < parentCount) {
                                    if (new File(rewrittenDir, revCommit3.getParent(i).getName()).exists()) {
                                        new File(rewrittenDir, revCommit3.getName()).createNewFile();
                                        break;
                                    }
                                    i++;
                                } else {
                                    it.remove();
                                    break;
                                }
                            }
                        } else {
                            new File(rewrittenDir, revCommit3.getName()).createNewFile();
                        }
                    }
                }
                return arrayList;
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

    private static String getHeadName(Ref ref) {
        if (ref.isSymbolic()) {
            return ref.getTarget().getName();
        }
        return ref.getObjectId().getName();
    }

    private Ref getHead() throws RefNotFoundException, IOException {
        Ref refExactRef = this.repo.exactRef("HEAD");
        if (refExactRef == null || refExactRef.getObjectId() == null) {
            throw new RefNotFoundException(MessageFormat.format(JGitText.get().refNotResolved, "HEAD"));
        }
        return refExactRef;
    }

    private boolean isInteractive() {
        return this.interactiveHandler != null;
    }

    public RevCommit tryFastForward(RevCommit revCommit) throws GitAPIException, IOException {
        Ref head = getHead();
        ObjectId objectId = head.getObjectId();
        if (objectId == null) {
            throw new RefNotFoundException(MessageFormat.format(JGitText.get().refNotResolved, "HEAD"));
        }
        RevCommit revCommitLookupCommit = this.walk.lookupCommit(objectId);
        return this.walk.isMergedInto(revCommit, revCommitLookupCommit) ? revCommit : tryFastForward(getHeadName(head), revCommitLookupCommit, revCommit);
    }

    private RevCommit tryFastForward(String str, RevCommit revCommit, RevCommit revCommit2) throws GitAPIException, IOException {
        boolean z = false;
        for (RevCommit revCommit3 : revCommit2.getParents()) {
            if (revCommit3.equals((AnyObjectId) revCommit)) {
                z = true;
            }
        }
        if (!z) {
            return null;
        }
        CheckoutCommand checkoutCommand = new CheckoutCommand(this.repo);
        try {
            checkoutCommand.setProgressMonitor(this.monitor);
            checkoutCommand.setName(revCommit2.name()).call();
            if (str.startsWith(Constants.R_HEADS)) {
                RefUpdate refUpdateUpdateRef = this.repo.updateRef(str);
                refUpdateUpdateRef.setExpectedOldObjectId(revCommit);
                refUpdateUpdateRef.setNewObjectId(revCommit2);
                refUpdateUpdateRef.setRefLogMessage("Fast-forward from " + revCommit.name() + " to " + revCommit2.name(), false);
                int i = $SWITCH_TABLE$org$eclipse$jgit$lib$RefUpdate$Result()[refUpdateUpdateRef.update(this.walk).ordinal()];
                if (i != 3 && i != 5 && i != 6) {
                    throw new IOException("Could not fast-forward");
                }
            }
            return revCommit2;
        } catch (CheckoutConflictException | InvalidRefNameException | RefAlreadyExistsException | RefNotFoundException e) {
            throw new JGitInternalException(e.getMessage(), e);
        }
    }

    private void checkParameters() throws WrongRepositoryStateException {
        if (this.operation == Operation.PROCESS_STEPS && this.rebaseState.getFile("done").exists()) {
            throw new WrongRepositoryStateException(MessageFormat.format(JGitText.get().wrongRepositoryState, this.repo.getRepositoryState().name()));
        }
        if (this.operation != Operation.BEGIN) {
            switch ($SWITCH_TABLE$org$eclipse$jgit$lib$RepositoryState()[this.repo.getRepositoryState().ordinal()]) {
                case 9:
                case 10:
                case 12:
                case 13:
                    return;
                case 11:
                default:
                    throw new WrongRepositoryStateException(MessageFormat.format(JGitText.get().wrongRepositoryState, this.repo.getRepositoryState().name()));
            }
        } else {
            if ($SWITCH_TABLE$org$eclipse$jgit$lib$RepositoryState()[this.repo.getRepositoryState().ordinal()] == 2) {
                if (this.upstreamCommit == null) {
                    throw new JGitInternalException(MessageFormat.format(JGitText.get().missingRequiredParameter, "upstream"));
                }
                return;
            }
            throw new WrongRepositoryStateException(MessageFormat.format(JGitText.get().wrongRepositoryState, this.repo.getRepositoryState().name()));
        }
    }

    private RebaseResult abort(RebaseResult rebaseResult) throws GitAPIException, IOException {
        String strName;
        DirCacheCheckout dirCacheCheckout;
        RefUpdate.Result resultForceUpdate;
        ObjectId originalHead = getOriginalHead();
        if (originalHead != null) {
            try {
                strName = originalHead.name();
            } catch (Throwable th) {
                this.monitor.endTask();
                throw th;
            }
        } else {
            strName = null;
        }
        this.monitor.beginTask(MessageFormat.format(JGitText.get().abortingRebase, strName), 0);
        if (strName == null) {
            throw new JGitInternalException(JGitText.get().abortingRebaseFailedNoOrigHead);
        }
        RevCommit commit = this.walk.parseCommit(this.repo.resolve(strName));
        if (rebaseResult.getStatus().equals(RebaseResult.Status.FAILED)) {
            dirCacheCheckout = new DirCacheCheckout(this.repo, this.walk.parseCommit(this.repo.resolve("HEAD")).getTree(), this.repo.lockDirCache(), commit.getTree());
        } else {
            dirCacheCheckout = new DirCacheCheckout(this.repo, this.repo.lockDirCache(), commit.getTree());
        }
        dirCacheCheckout.setFailOnConflict(false);
        dirCacheCheckout.checkout();
        this.walk.close();
        this.monitor.endTask();
        try {
            String file = this.rebaseState.readFile(HEAD_NAME);
            this.monitor.beginTask(MessageFormat.format(JGitText.get().resettingHead, file), 0);
            RefUpdate refUpdateUpdateRef = this.repo.updateRef("HEAD", false);
            refUpdateUpdateRef.setRefLogMessage("rebase: aborting", false);
            if (file.startsWith(Constants.R_REFS)) {
                resultForceUpdate = refUpdateUpdateRef.link(file);
            } else {
                refUpdateUpdateRef.setNewObjectId(originalHead);
                resultForceUpdate = refUpdateUpdateRef.forceUpdate();
            }
            int i = $SWITCH_TABLE$org$eclipse$jgit$lib$RefUpdate$Result()[resultForceUpdate.ordinal()];
            if (i != 3 && i != 5 && i != 6) {
                throw new JGitInternalException(JGitText.get().abortingRebaseFailed);
            }
            boolean zAutoStashApply = autoStashApply();
            FileUtils.delete(this.rebaseState.getDir(), 1);
            this.repo.writeCherryPickHead(null);
            this.repo.writeMergeHeads(null);
            if (!zAutoStashApply) {
                rebaseResult = RebaseResult.STASH_APPLY_CONFLICTS_RESULT;
            }
            this.monitor.endTask();
            return rebaseResult;
        } catch (Throwable th2) {
            this.monitor.endTask();
            throw th2;
        }
    }

    private ObjectId getOriginalHead() throws IOException {
        try {
            try {
                return ObjectId.fromString(this.rebaseState.readFile(REBASE_HEAD));
            } catch (FileNotFoundException unused) {
                return ObjectId.fromString(this.rebaseState.readFile(REBASE_HEAD_LEGACY));
            }
        } catch (FileNotFoundException unused2) {
            return this.repo.readOrigHead();
        }
    }

    private boolean checkoutCommit(String str, RevCommit revCommit) throws CheckoutConflictException, IOException {
        try {
            RevCommit commit = this.walk.parseCommit(this.repo.resolve("HEAD"));
            DirCacheCheckout dirCacheCheckout = new DirCacheCheckout(this.repo, commit.getTree(), this.repo.lockDirCache(), revCommit.getTree());
            dirCacheCheckout.setFailOnConflict(true);
            dirCacheCheckout.setProgressMonitor(this.monitor);
            try {
                dirCacheCheckout.checkout();
                RefUpdate refUpdateUpdateRef = this.repo.updateRef("HEAD", true);
                refUpdateUpdateRef.setExpectedOldObjectId(commit);
                refUpdateUpdateRef.setNewObjectId(revCommit);
                refUpdateUpdateRef.setRefLogMessage("checkout: moving from " + Repository.shortenRefName(str) + " to " + revCommit.getName(), false);
                int i = $SWITCH_TABLE$org$eclipse$jgit$lib$RefUpdate$Result()[refUpdateUpdateRef.forceUpdate().ordinal()];
                if (i != 3 && i != 5 && i != 6) {
                    throw new IOException(JGitText.get().couldNotRewindToUpstreamCommit);
                }
                this.walk.close();
                this.monitor.endTask();
                return true;
            } catch (org.eclipse.jgit.errors.CheckoutConflictException e) {
                throw new CheckoutConflictException(dirCacheCheckout.getConflicts(), e);
            }
        } catch (Throwable th) {
            this.walk.close();
            this.monitor.endTask();
            throw th;
        }
    }

    public RebaseCommand setUpstream(RevCommit revCommit) {
        this.upstreamCommit = revCommit;
        this.upstreamCommitName = revCommit.name();
        return this;
    }

    public RebaseCommand setUpstream(AnyObjectId anyObjectId) {
        try {
            this.upstreamCommit = this.walk.parseCommit(anyObjectId);
            this.upstreamCommitName = anyObjectId.name();
            return this;
        } catch (IOException e) {
            throw new JGitInternalException(MessageFormat.format(JGitText.get().couldNotReadObjectWhileParsingCommit, anyObjectId.name()), e);
        }
    }

    public RebaseCommand setUpstream(String str) throws RefNotFoundException {
        try {
            if (this.repo.resolve(str) == null) {
                throw new RefNotFoundException(MessageFormat.format(JGitText.get().refNotResolved, str));
            }
            this.upstreamCommit = this.walk.parseCommit(this.repo.resolve(str));
            this.upstreamCommitName = str;
            return this;
        } catch (IOException e) {
            throw new JGitInternalException(e.getMessage(), e);
        }
    }

    public RebaseCommand setUpstreamName(String str) {
        if (this.upstreamCommit == null) {
            throw new IllegalStateException("setUpstreamName must be called after setUpstream.");
        }
        this.upstreamCommitName = str;
        return this;
    }

    public RebaseCommand setOperation(Operation operation) {
        this.operation = operation;
        return this;
    }

    public RebaseCommand setProgressMonitor(ProgressMonitor progressMonitor) {
        if (progressMonitor == null) {
            progressMonitor = NullProgressMonitor.INSTANCE;
        }
        this.monitor = progressMonitor;
        return this;
    }

    public RebaseCommand runInteractively(InteractiveHandler interactiveHandler) {
        return runInteractively(interactiveHandler, false);
    }

    public RebaseCommand runInteractively(InteractiveHandler interactiveHandler, boolean z) {
        this.stopAfterInitialization = z;
        this.interactiveHandler = interactiveHandler;
        return this;
    }

    public RebaseCommand setStrategy(MergeStrategy mergeStrategy) {
        this.strategy = mergeStrategy;
        return this;
    }

    public RebaseCommand setContentMergeStrategy(ContentMergeStrategy contentMergeStrategy) {
        this.contentStrategy = contentMergeStrategy;
        return this;
    }

    public RebaseCommand setPreserveMerges(boolean z) {
        this.preserveMerges = z;
        return this;
    }

    public interface InteractiveHandler2 extends InteractiveHandler {

        public interface ModifyResult {
            CommitConfig.CleanupMode getCleanupMode();

            String getMessage();

            boolean shouldAddChangeId();
        }

        ModifyResult editCommitMessage(String str, CommitConfig.CleanupMode cleanupMode, char c);

        @Override // org.eclipse.jgit.api.RebaseCommand.InteractiveHandler
        default String modifyCommitMessage(String str) {
            if (str == null) {
                str = "";
            }
            return editCommitMessage(str, CommitConfig.CleanupMode.STRIP, '#').getMessage();
        }
    }

    PersonIdent parseAuthor(byte[] bArr) {
        int iNextLF;
        int next;
        if (bArr.length == 0) {
            return null;
        }
        HashMap map = new HashMap();
        int i = 0;
        while (i < bArr.length && (iNextLF = RawParseUtils.nextLF(bArr, i)) != i && (next = RawParseUtils.next(bArr, i, '=')) != iNextLF) {
            map.put(RawParseUtils.decode(bArr, i, next - 1), RawParseUtils.decode(bArr, next + 1, iNextLF - 2));
            i = iNextLF;
        }
        String str = (String) map.get("GIT_AUTHOR_NAME");
        String str2 = (String) map.get("GIT_AUTHOR_EMAIL");
        String str3 = (String) map.get(GIT_AUTHOR_DATE);
        long j = Long.parseLong(str3.substring(str3.startsWith("@") ? 1 : 0, str3.indexOf(32))) * 1000;
        String strSubstring = str3.substring(str3.indexOf(32) + 1);
        int i2 = ((Integer.parseInt(strSubstring.substring(1, 3)) * 60) + Integer.parseInt(strSubstring.substring(3, 5))) * (strSubstring.charAt(0) == '+' ? 1 : -1);
        if (str == null || str2 == null) {
            return null;
        }
        return new PersonIdent(str, str2, j, i2);
    }

    private static class RebaseState {
        private File dir;
        private final File repoDirectory;

        public RebaseState(File file) {
            this.repoDirectory = file;
        }

        public File getDir() {
            if (this.dir == null) {
                File file = new File(this.repoDirectory, RebaseCommand.REBASE_APPLY);
                if (file.exists()) {
                    this.dir = file;
                } else {
                    this.dir = new File(this.repoDirectory, RebaseCommand.REBASE_MERGE);
                }
            }
            return this.dir;
        }

        public File getRewrittenDir() {
            return new File(getDir(), RebaseCommand.REWRITTEN);
        }

        public String readFile(String str) throws IOException {
            try {
                return readFile(getDir(), str);
            } catch (FileNotFoundException e) {
                if (RebaseCommand.ONTO_NAME.equals(str)) {
                    File file = getFile(RebaseCommand.ONTO_NAME.replace('_', Soundex.SILENT_MARKER));
                    if (file.exists()) {
                        return readFile(file);
                    }
                }
                throw e;
            }
        }

        public void createFile(String str, String str2) throws IOException {
            createFile(getDir(), str, str2);
        }

        public File getFile(String str) {
            return new File(getDir(), str);
        }

        public String getPath(String str) {
            return getDir().getName() + InternalZipConstants.ZIP_FILE_SEPARATOR + str;
        }

        private static String readFile(File file) throws IOException {
            byte[] fully = IO.readFully(file);
            return RawParseUtils.decode(fully, 0, RawParseUtils.prevLF(fully, fully.length) + 1);
        }

        /* INFO: Access modifiers changed from: private */
        public static String readFile(File file, String str) throws IOException {
            return readFile(new File(file, str));
        }

        /* INFO: Access modifiers changed from: private */
        public static void createFile(File file, String str, String str2) throws IOException {
            File file2 = new File(file, str);
            Throwable th = null;
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    fileOutputStream.write(str2.getBytes(StandardCharsets.UTF_8));
                    fileOutputStream.write(10);
                } finally {
                    fileOutputStream.close();
                }
            } catch (Throwable th2) {
                if (0 == 0) {
                    throw th2;
                }
                if (null == th2) {
                    throw null;
                }
                th.addSuppressed(th2);
            }
        }

        /* INFO: Access modifiers changed from: private */
        public static void appendToFile(File file, String str) throws IOException {
            Throwable th = null;
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file, true);
                try {
                    fileOutputStream.write(str.getBytes(StandardCharsets.UTF_8));
                    fileOutputStream.write(10);
                } finally {
                    fileOutputStream.close();
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
    }
}
