package org.eclipse.jgit.api;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.api.errors.MultipleParentsNotAllowedException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.dircache.DirCacheCheckout;
import org.eclipse.jgit.events.WorkingTreeModifiedEvent;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.CommitConfig;
import org.eclipse.jgit.lib.NullProgressMonitor;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectIdRef;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.merge.MergeMessageFormatter;
import org.eclipse.jgit.merge.MergeStrategy;
import org.eclipse.jgit.merge.ResolveMerger;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.treewalk.FileTreeIterator;

/* INFO: loaded from: classes5.dex */
public class RevertCommand extends GitCommand<RevCommit> {
    private List<Ref> commits;
    private MergeResult failingResult;
    private boolean insertChangeId;
    private ProgressMonitor monitor;
    private String ourCommitName;
    private List<Ref> revertedRefs;
    private MergeStrategy strategy;
    private List<String> unmergedPaths;

    protected RevertCommand(Repository repository) {
        super(repository);
        this.commits = new ArrayList();
        this.ourCommitName = null;
        this.revertedRefs = new ArrayList();
        this.strategy = MergeStrategy.RECURSIVE;
        this.monitor = NullProgressMonitor.INSTANCE;
    }

    @Override // org.eclipse.jgit.api.GitCommand, java.util.concurrent.Callable
    public RevCommit call() throws Throwable {
        checkCallable();
        Throwable th = null;
        try {
            RevWalk revWalk = new RevWalk(this.repo);
            try {
                Ref refExactRef = this.repo.exactRef("HEAD");
                if (refExactRef == null) {
                    throw new NoHeadException(JGitText.get().commitOnRepoWithoutHEADCurrentlyNotSupported);
                }
                RevCommit commit = revWalk.parseCommit(refExactRef.getObjectId());
                RevCommit revCommitCall = commit;
                for (Ref ref : this.commits) {
                    ObjectId peeledObjectId = ref.getPeeledObjectId();
                    if (peeledObjectId == null) {
                        peeledObjectId = ref.getObjectId();
                    }
                    RevCommit commit2 = revWalk.parseCommit(peeledObjectId);
                    if (commit2.getParentCount() != 1) {
                        throw new MultipleParentsNotAllowedException(MessageFormat.format(JGitText.get().canOnlyRevertCommitsWithOneParent, commit2.name(), Integer.valueOf(commit2.getParentCount())));
                    }
                    RevCommit parent = commit2.getParent(0);
                    revWalk.parseHeaders(parent);
                    String strCalculateOurName = calculateOurName(refExactRef);
                    String str = commit2.getId().abbreviate(7).name() + " " + commit2.getShortMessage();
                    ResolveMerger resolveMerger = (ResolveMerger) this.strategy.newMerger(this.repo);
                    resolveMerger.setWorkingTreeIterator(new FileTreeIterator(this.repo));
                    resolveMerger.setBase(commit2.getTree());
                    resolveMerger.setCommitNames(new String[]{"BASE", strCalculateOurName, str});
                    String str2 = "Revert \"" + commit2.getShortMessage() + "\"";
                    String str3 = str2 + "\n\nThis reverts commit " + commit2.getId().getName() + ".\n";
                    if (resolveMerger.merge(revCommitCall, parent)) {
                        if (!resolveMerger.getModifiedFiles().isEmpty()) {
                            this.repo.fireEvent(new WorkingTreeModifiedEvent(resolveMerger.getModifiedFiles(), null));
                        }
                        if (!AnyObjectId.isEqual(revCommitCall.getTree().getId(), resolveMerger.getResultTreeId())) {
                            DirCacheCheckout dirCacheCheckout = new DirCacheCheckout(this.repo, revCommitCall.getTree(), this.repo.lockDirCache(), resolveMerger.getResultTreeId());
                            dirCacheCheckout.setFailOnConflict(true);
                            dirCacheCheckout.setProgressMonitor(this.monitor);
                            dirCacheCheckout.checkout();
                            try {
                                Git git = new Git(getRepository());
                                try {
                                    revCommitCall = git.commit().setMessage(str3).setInsertChangeId(this.insertChangeId).setReflogComment("revert: " + str2).call();
                                    git.close();
                                    this.revertedRefs.add(ref);
                                    commit = revCommitCall;
                                } catch (Throwable th2) {
                                    th = th2;
                                    git.close();
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                if (th == null) {
                                    throw th3;
                                }
                                if (th != th3) {
                                    th.addSuppressed(th3);
                                }
                                throw th;
                            }
                        }
                    } else {
                        this.unmergedPaths = resolveMerger.getUnmergedPaths();
                        Map<String, ResolveMerger.MergeFailureReason> failingPaths = resolveMerger.getFailingPaths();
                        if (failingPaths != null) {
                            this.failingResult = new MergeResult(null, resolveMerger.getBaseCommitId(), new ObjectId[]{revCommitCall.getId(), parent.getId()}, MergeResult.MergeStatus.FAILED, this.strategy, resolveMerger.getMergeResults(), failingPaths, null);
                        } else {
                            this.failingResult = new MergeResult(null, resolveMerger.getBaseCommitId(), new ObjectId[]{revCommitCall.getId(), parent.getId()}, MergeResult.MergeStatus.CONFLICTING, this.strategy, resolveMerger.getMergeResults(), failingPaths, null);
                        }
                        if (!resolveMerger.failed() && !this.unmergedPaths.isEmpty()) {
                            String withConflicts = new MergeMessageFormatter().formatWithConflicts(str3, resolveMerger.getUnmergedPaths(), ((CommitConfig) this.repo.getConfig().get(CommitConfig.KEY)).getCommentChar(str3));
                            this.repo.writeRevertHead(commit2.getId());
                            this.repo.writeMergeCommitMsg(withConflicts);
                        }
                        revWalk.close();
                        return null;
                    }
                }
                revWalk.close();
                return commit;
            } catch (Throwable th4) {
                revWalk.close();
                throw th4;
            }
        } catch (Throwable th5) {
            if (th == null) {
                throw th5;
            }
            if (th != th5) {
                try {
                    th.addSuppressed(th5);
                } catch (IOException e) {
                    throw new JGitInternalException(MessageFormat.format(JGitText.get().exceptionCaughtDuringExecutionOfRevertCommand, e), e);
                }
            }
            throw th;
        }
    }

    public RevertCommand include(Ref ref) {
        checkCallable();
        this.commits.add(ref);
        return this;
    }

    public RevertCommand include(AnyObjectId anyObjectId) {
        return include(anyObjectId.getName(), anyObjectId);
    }

    public RevertCommand include(String str, AnyObjectId anyObjectId) {
        return include(new ObjectIdRef.Unpeeled(Ref.Storage.LOOSE, str, anyObjectId.copy()));
    }

    public RevertCommand setOurCommitName(String str) {
        this.ourCommitName = str;
        return this;
    }

    private String calculateOurName(Ref ref) {
        String str = this.ourCommitName;
        return str != null ? str : Repository.shortenRefName(ref.getTarget().getName());
    }

    public List<Ref> getRevertedRefs() {
        return this.revertedRefs;
    }

    public MergeResult getFailingResult() {
        return this.failingResult;
    }

    public List<String> getUnmergedPaths() {
        return this.unmergedPaths;
    }

    public RevertCommand setStrategy(MergeStrategy mergeStrategy) {
        this.strategy = mergeStrategy;
        return this;
    }

    public RevertCommand setProgressMonitor(ProgressMonitor progressMonitor) {
        if (progressMonitor == null) {
            progressMonitor = NullProgressMonitor.INSTANCE;
        }
        this.monitor = progressMonitor;
        return this;
    }

    public RevertCommand setInsertChangeId(boolean z) {
        this.insertChangeId = z;
        return this;
    }
}
