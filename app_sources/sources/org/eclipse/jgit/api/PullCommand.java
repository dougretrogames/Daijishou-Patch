package org.eclipse.jgit.api;

import java.io.IOException;
import java.text.MessageFormat;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.api.errors.CanceledException;
import org.eclipse.jgit.api.errors.InvalidConfigurationException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.api.errors.RefNotAdvertisedException;
import org.eclipse.jgit.api.errors.RefNotFoundException;
import org.eclipse.jgit.api.errors.WrongRepositoryStateException;
import org.eclipse.jgit.dircache.DirCacheCheckout;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.BranchConfig;
import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.NullProgressMonitor;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.RefUpdate;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.RepositoryState;
import org.eclipse.jgit.lib.StoredConfig;
import org.eclipse.jgit.lib.SubmoduleConfig;
import org.eclipse.jgit.merge.ContentMergeStrategy;
import org.eclipse.jgit.merge.MergeStrategy;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.transport.FetchResult;
import org.eclipse.jgit.transport.TagOpt;

/* INFO: loaded from: classes5.dex */
public class PullCommand extends TransportCommand<PullCommand, PullResult> {
    private static final String DOT = ".";
    private ContentMergeStrategy contentStrategy;
    private MergeCommand.FastForwardMode fastForwardMode;
    private ProgressMonitor monitor;
    private BranchConfig.BranchRebaseMode pullRebaseMode;
    private String remote;
    private String remoteBranchName;
    private MergeStrategy strategy;
    private SubmoduleConfig.FetchRecurseSubmodulesMode submoduleRecurseMode;
    private TagOpt tagOption;

    protected PullCommand(Repository repository) {
        super(repository);
        this.monitor = NullProgressMonitor.INSTANCE;
        this.pullRebaseMode = null;
        this.strategy = MergeStrategy.RECURSIVE;
        this.submoduleRecurseMode = null;
    }

    public PullCommand setProgressMonitor(ProgressMonitor progressMonitor) {
        if (progressMonitor == null) {
            progressMonitor = NullProgressMonitor.INSTANCE;
        }
        this.monitor = progressMonitor;
        return this;
    }

    public PullCommand setRebase(boolean z) {
        BranchConfig.BranchRebaseMode branchRebaseMode;
        checkCallable();
        if (z) {
            branchRebaseMode = BranchConfig.BranchRebaseMode.REBASE;
        } else {
            branchRebaseMode = BranchConfig.BranchRebaseMode.NONE;
        }
        this.pullRebaseMode = branchRebaseMode;
        return this;
    }

    public PullCommand setRebase(BranchConfig.BranchRebaseMode branchRebaseMode) {
        checkCallable();
        this.pullRebaseMode = branchRebaseMode;
        return this;
    }

    @Override // org.eclipse.jgit.api.GitCommand, java.util.concurrent.Callable
    public PullResult call() throws Throwable {
        String string;
        FetchResult fetchResultCall;
        ObjectId objectIdResolve;
        PullResult pullResult;
        Ref advertisedRef;
        checkCallable();
        this.monitor.beginTask(JGitText.get().pullTaskName, 2);
        StoredConfig config = this.repo.getConfig();
        try {
            String fullBranch = this.repo.getFullBranch();
            Throwable th = null;
            String strSubstring = (fullBranch == null || !fullBranch.startsWith(Constants.R_HEADS)) ? null : fullBranch.substring(Constants.R_HEADS.length());
            if (this.remoteBranchName == null && strSubstring != null) {
                this.remoteBranchName = config.getString(ConfigConstants.CONFIG_BRANCH_SECTION, strSubstring, "merge");
            }
            if (this.remoteBranchName == null) {
                this.remoteBranchName = strSubstring;
            }
            if (this.remoteBranchName == null) {
                throw new NoHeadException(JGitText.get().cannotCheckoutFromUnbornBranch);
            }
            if (!this.repo.getRepositoryState().equals(RepositoryState.SAFE)) {
                throw new WrongRepositoryStateException(MessageFormat.format(JGitText.get().cannotPullOnARepoWithState, this.repo.getRepositoryState().name()));
            }
            if (this.remote == null && strSubstring != null) {
                this.remote = config.getString(ConfigConstants.CONFIG_BRANCH_SECTION, strSubstring, "remote");
            }
            if (this.remote == null) {
                this.remote = "origin";
            }
            if (this.pullRebaseMode == null && strSubstring != null) {
                this.pullRebaseMode = getRebaseMode(strSubstring, config);
            }
            boolean zEquals = this.remote.equals(".");
            if (!zEquals) {
                string = config.getString("remote", this.remote, "url");
                if (string == null) {
                    throw new InvalidConfigurationException(MessageFormat.format(JGitText.get().missingConfigurationForKey, "remote." + this.remote + ".url"));
                }
                if (this.monitor.isCancelled()) {
                    throw new CanceledException(MessageFormat.format(JGitText.get().operationCanceled, JGitText.get().pullTaskName));
                }
                FetchCommand recurseSubmodules = new FetchCommand(this.repo).setRemote(this.remote).setProgressMonitor(this.monitor).setTagOpt(this.tagOption).setRecurseSubmodules(this.submoduleRecurseMode);
                configure(recurseSubmodules);
                fetchResultCall = recurseSubmodules.call();
            } else {
                string = JGitText.get().localRepository;
                fetchResultCall = null;
            }
            this.monitor.update(1);
            if (this.monitor.isCancelled()) {
                throw new CanceledException(MessageFormat.format(JGitText.get().operationCanceled, JGitText.get().pullTaskName));
            }
            if (zEquals) {
                try {
                    objectIdResolve = this.repo.resolve(this.remoteBranchName);
                    if (objectIdResolve == null) {
                        throw new RefNotFoundException(MessageFormat.format(JGitText.get().refNotResolved, this.remoteBranchName));
                    }
                } catch (IOException e) {
                    throw new JGitInternalException(JGitText.get().exceptionCaughtDuringExecutionOfPullCommand, e);
                }
            } else {
                if (fetchResultCall != null) {
                    advertisedRef = fetchResultCall.getAdvertisedRef(this.remoteBranchName);
                    if (advertisedRef == null) {
                        advertisedRef = fetchResultCall.getAdvertisedRef(Constants.R_HEADS + this.remoteBranchName);
                    }
                } else {
                    advertisedRef = null;
                }
                if (advertisedRef == null) {
                    throw new RefNotAdvertisedException(MessageFormat.format(JGitText.get().couldNotGetAdvertisedRef, this.remote, this.remoteBranchName));
                }
                objectIdResolve = advertisedRef.getObjectId();
            }
            String str = MessageFormat.format(JGitText.get().upstreamBranchName, Repository.shortenRefName(this.remoteBranchName), string);
            if (this.pullRebaseMode != BranchConfig.BranchRebaseMode.NONE) {
                try {
                    Ref refExactRef = this.repo.exactRef("HEAD");
                    if (refExactRef == null) {
                        throw new NoHeadException(JGitText.get().commitOnRepoWithoutHEADCurrentlyNotSupported);
                    }
                    if (refExactRef.getObjectId() == null) {
                        try {
                            RevWalk revWalk = new RevWalk(this.repo);
                            try {
                                RevCommit commit = revWalk.parseCommit(objectIdResolve);
                                DirCacheCheckout dirCacheCheckout = new DirCacheCheckout(this.repo, this.repo.lockDirCache(), commit.getTree());
                                dirCacheCheckout.setFailOnConflict(true);
                                dirCacheCheckout.setProgressMonitor(this.monitor);
                                dirCacheCheckout.checkout();
                                RefUpdate refUpdateUpdateRef = this.repo.updateRef(refExactRef.getTarget().getName());
                                refUpdateUpdateRef.setNewObjectId(objectIdResolve);
                                refUpdateUpdateRef.setExpectedOldObjectId(null);
                                refUpdateUpdateRef.setRefLogMessage("initial pull", false);
                                if (refUpdateUpdateRef.update() != RefUpdate.Result.NEW) {
                                    throw new NoHeadException(JGitText.get().commitOnRepoWithoutHEADCurrentlyNotSupported);
                                }
                                this.monitor.endTask();
                                PullResult pullResult2 = new PullResult(fetchResultCall, this.remote, RebaseResult.result(RebaseResult.Status.FAST_FORWARD, commit));
                                revWalk.close();
                                return pullResult2;
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
                    pullResult = new PullResult(fetchResultCall, this.remote, new RebaseCommand(this.repo).setUpstream(objectIdResolve).setProgressMonitor(this.monitor).setUpstreamName(str).setOperation(RebaseCommand.Operation.BEGIN).setStrategy(this.strategy).setContentMergeStrategy(this.contentStrategy).setPreserveMerges(this.pullRebaseMode == BranchConfig.BranchRebaseMode.MERGES).call());
                } catch (IOException e2) {
                    throw new JGitInternalException(JGitText.get().exceptionCaughtDuringExecutionOfPullCommand, e2);
                } catch (NoHeadException e3) {
                    throw e3;
                }
            } else {
                MergeResult mergeResultCall = new MergeCommand(this.repo).include(str, objectIdResolve).setProgressMonitor(this.monitor).setStrategy(this.strategy).setContentMergeStrategy(this.contentStrategy).setFastForward(getFastForwardMode()).call();
                this.monitor.update(1);
                pullResult = new PullResult(fetchResultCall, this.remote, mergeResultCall);
            }
            this.monitor.endTask();
            return pullResult;
        } catch (IOException e4) {
            throw new JGitInternalException(JGitText.get().exceptionCaughtDuringExecutionOfPullCommand, e4);
        }
    }

    public PullCommand setRemote(String str) {
        checkCallable();
        this.remote = str;
        return this;
    }

    public PullCommand setRemoteBranchName(String str) {
        checkCallable();
        this.remoteBranchName = str;
        return this;
    }

    public String getRemote() {
        return this.remote;
    }

    public String getRemoteBranchName() {
        return this.remoteBranchName;
    }

    public PullCommand setStrategy(MergeStrategy mergeStrategy) {
        this.strategy = mergeStrategy;
        return this;
    }

    public PullCommand setContentMergeStrategy(ContentMergeStrategy contentMergeStrategy) {
        this.contentStrategy = contentMergeStrategy;
        return this;
    }

    public PullCommand setTagOpt(TagOpt tagOpt) {
        checkCallable();
        this.tagOption = tagOpt;
        return this;
    }

    public PullCommand setFastForward(@Nullable MergeCommand.FastForwardMode fastForwardMode) {
        checkCallable();
        this.fastForwardMode = fastForwardMode;
        return this;
    }

    public PullCommand setRecurseSubmodules(@Nullable SubmoduleConfig.FetchRecurseSubmodulesMode fetchRecurseSubmodulesMode) {
        this.submoduleRecurseMode = fetchRecurseSubmodulesMode;
        return this;
    }

    public static BranchConfig.BranchRebaseMode getRebaseMode(String str, Config config) {
        BranchConfig.BranchRebaseMode branchRebaseMode = (BranchConfig.BranchRebaseMode) config.getEnum(BranchConfig.BranchRebaseMode.values(), ConfigConstants.CONFIG_BRANCH_SECTION, str, "rebase", null);
        return branchRebaseMode == null ? (BranchConfig.BranchRebaseMode) config.getEnum(BranchConfig.BranchRebaseMode.values(), ConfigConstants.CONFIG_PULL_SECTION, null, "rebase", BranchConfig.BranchRebaseMode.NONE) : branchRebaseMode;
    }

    private MergeCommand.FastForwardMode getFastForwardMode() {
        MergeCommand.FastForwardMode fastForwardMode = this.fastForwardMode;
        if (fastForwardMode != null) {
            return fastForwardMode;
        }
        MergeCommand.FastForwardMode.Merge merge = (MergeCommand.FastForwardMode.Merge) this.repo.getConfig().getEnum(MergeCommand.FastForwardMode.Merge.valuesCustom(), ConfigConstants.CONFIG_PULL_SECTION, null, ConfigConstants.CONFIG_KEY_FF, null);
        if (merge != null) {
            return MergeCommand.FastForwardMode.valueOf(merge);
        }
        return null;
    }
}
