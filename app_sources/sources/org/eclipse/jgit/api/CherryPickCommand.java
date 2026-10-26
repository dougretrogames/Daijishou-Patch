package org.eclipse.jgit.api;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.CollectionUtils;
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
import org.eclipse.jgit.merge.ContentMergeStrategy;
import org.eclipse.jgit.merge.MergeMessageFormatter;
import org.eclipse.jgit.merge.MergeStrategy;
import org.eclipse.jgit.merge.Merger;
import org.eclipse.jgit.merge.ResolveMerger;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.treewalk.FileTreeIterator;

/* INFO: loaded from: classes5.dex */
public class CherryPickCommand extends GitCommand<CherryPickResult> {
    private List<Ref> commits;
    private ContentMergeStrategy contentStrategy;
    private Integer mainlineParentNumber;
    private CherryPickCommitMessageProvider messageProvider;
    private ProgressMonitor monitor;
    private boolean noCommit;
    private String ourCommitName;
    private String reflogPrefix;
    private MergeStrategy strategy;

    protected CherryPickCommand(Repository repository) {
        super(repository);
        this.reflogPrefix = "cherry-pick:";
        this.commits = new ArrayList();
        this.ourCommitName = null;
        this.messageProvider = CherryPickCommitMessageProvider.ORIGINAL;
        this.strategy = MergeStrategy.RECURSIVE;
        this.noCommit = false;
        this.monitor = NullProgressMonitor.INSTANCE;
    }

    @Override // org.eclipse.jgit.api.GitCommand, java.util.concurrent.Callable
    public CherryPickResult call() throws Throwable {
        Throwable th;
        boolean z;
        List<String> unmergedPaths;
        boolean zMerge;
        Map<String, ResolveMerger.MergeFailureReason> failingPaths;
        String fullMessage;
        CherryPickResult cherryPickResult;
        ArrayList arrayList = new ArrayList();
        checkCallable();
        try {
            RevWalk revWalk = new RevWalk(this.repo);
            try {
                try {
                    Ref refExactRef = this.repo.exactRef("HEAD");
                    if (refExactRef == null) {
                        throw new NoHeadException(JGitText.get().commitOnRepoWithoutHEADCurrentlyNotSupported);
                    }
                    RevCommit commit = revWalk.parseCommit(refExactRef.getObjectId());
                    for (Ref ref : this.commits) {
                        ObjectId peeledObjectId = ref.getPeeledObjectId();
                        if (peeledObjectId == null) {
                            peeledObjectId = ref.getObjectId();
                        }
                        RevCommit commit2 = revWalk.parseCommit(peeledObjectId);
                        RevCommit parentCommit = getParentCommit(commit2, revWalk);
                        String strCalculateOurName = calculateOurName(refExactRef);
                        String str = commit2.getId().abbreviate(7).name() + " " + commit2.getShortMessage();
                        Merger mergerNewMerger = this.strategy.newMerger(this.repo);
                        mergerNewMerger.setProgressMonitor(this.monitor);
                        if (mergerNewMerger instanceof ResolveMerger) {
                            ResolveMerger resolveMerger = (ResolveMerger) mergerNewMerger;
                            z = true;
                            resolveMerger.setContentMergeStrategy(this.contentStrategy);
                            resolveMerger.setCommitNames(new String[]{"BASE", strCalculateOurName, str});
                            resolveMerger.setWorkingTreeIterator(new FileTreeIterator(this.repo));
                            if (parentCommit != null) {
                                resolveMerger.setBase(parentCommit.getTree());
                            }
                            boolean zMerge2 = mergerNewMerger.merge(commit, commit2);
                            failingPaths = resolveMerger.getFailingPaths();
                            unmergedPaths = resolveMerger.getUnmergedPaths();
                            if (resolveMerger.getModifiedFiles().isEmpty()) {
                                zMerge = zMerge2;
                                th = null;
                            } else {
                                zMerge = zMerge2;
                                th = null;
                                this.repo.fireEvent(new WorkingTreeModifiedEvent(resolveMerger.getModifiedFiles(), null));
                            }
                        } else {
                            th = null;
                            z = true;
                            unmergedPaths = null;
                            zMerge = mergerNewMerger.merge(commit, commit2);
                            failingPaths = null;
                        }
                        if (zMerge) {
                            if (!AnyObjectId.isEqual(commit.getTree().getId(), mergerNewMerger.getResultTreeId())) {
                                DirCacheCheckout dirCacheCheckout = new DirCacheCheckout(this.repo, commit.getTree(), this.repo.lockDirCache(), mergerNewMerger.getResultTreeId());
                                dirCacheCheckout.setFailOnConflict(z);
                                dirCacheCheckout.setProgressMonitor(this.monitor);
                                dirCacheCheckout.checkout();
                                if (!this.noCommit) {
                                    try {
                                        Git git = new Git(getRepository());
                                        try {
                                            RevCommit revCommitCall = git.commit().setMessage(this.messageProvider.getCherryPickedCommitMessage(commit2)).setReflogComment(this.reflogPrefix + " " + commit2.getShortMessage()).setAuthor(commit2.getAuthorIdent()).setNoVerify(true).call();
                                            git.close();
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
                                arrayList.add(ref);
                            }
                        } else {
                            if (failingPaths != null && !failingPaths.isEmpty()) {
                                cherryPickResult = new CherryPickResult(failingPaths);
                            } else {
                                if (unmergedPaths != null) {
                                    CommitConfig commitConfig = (CommitConfig) this.repo.getConfig().get(CommitConfig.KEY);
                                    String fullMessage2 = commit2.getFullMessage();
                                    fullMessage = new MergeMessageFormatter().formatWithConflicts(fullMessage2, unmergedPaths, commitConfig.getCommentChar(fullMessage2));
                                } else {
                                    fullMessage = commit2.getFullMessage();
                                }
                                if (!this.noCommit) {
                                    this.repo.writeCherryPickHead(commit2.getId());
                                }
                                this.repo.writeMergeCommitMsg(fullMessage);
                                cherryPickResult = CherryPickResult.CONFLICT;
                            }
                            revWalk.close();
                            return cherryPickResult;
                        }
                    }
                    revWalk.close();
                    return new CherryPickResult(commit, arrayList);
                } catch (Throwable th4) {
                    revWalk.close();
                    throw th4;
                }
            } catch (Throwable th5) {
                th = th5;
                if (th == null) {
                    throw th;
                }
                if (th != th) {
                    try {
                        th.addSuppressed(th);
                    } catch (IOException e) {
                        throw new JGitInternalException(MessageFormat.format(JGitText.get().exceptionCaughtDuringExecutionOfCherryPickCommand, e), e);
                    }
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            th = null;
        }
    }

    private RevCommit getParentCommit(RevCommit revCommit, RevWalk revWalk) throws MultipleParentsNotAllowedException, IOException {
        RevCommit parent;
        Integer num = this.mainlineParentNumber;
        if (num == null) {
            int parentCount = revCommit.getParentCount();
            if (parentCount == 0) {
                return null;
            }
            if (parentCount != 1) {
                throw new MultipleParentsNotAllowedException(MessageFormat.format(JGitText.get().canOnlyCherryPickCommitsWithOneParent, revCommit.name(), Integer.valueOf(revCommit.getParentCount())));
            }
            parent = revCommit.getParent(0);
        } else {
            if (num.intValue() > revCommit.getParentCount()) {
                throw new JGitInternalException(MessageFormat.format(JGitText.get().commitDoesNotHaveGivenParent, revCommit, this.mainlineParentNumber));
            }
            parent = revCommit.getParent(this.mainlineParentNumber.intValue() - 1);
        }
        revWalk.parseHeaders(parent);
        return parent;
    }

    public CherryPickCommand include(Ref ref) {
        checkCallable();
        this.commits.add(ref);
        return this;
    }

    public CherryPickCommand include(AnyObjectId anyObjectId) {
        return include(anyObjectId.getName(), anyObjectId);
    }

    public CherryPickCommand include(String str, AnyObjectId anyObjectId) {
        return include(new ObjectIdRef.Unpeeled(Ref.Storage.LOOSE, str, anyObjectId.copy()));
    }

    public CherryPickCommand setOurCommitName(String str) {
        this.ourCommitName = str;
        return this;
    }

    public CherryPickCommand setCherryPickCommitMessageProvider(CherryPickCommitMessageProvider cherryPickCommitMessageProvider) {
        this.messageProvider = cherryPickCommitMessageProvider;
        return this;
    }

    public CherryPickCommand setReflogPrefix(String str) {
        this.reflogPrefix = str;
        return this;
    }

    public CherryPickCommand setStrategy(MergeStrategy mergeStrategy) {
        this.strategy = mergeStrategy;
        return this;
    }

    public CherryPickCommand setContentMergeStrategy(ContentMergeStrategy contentMergeStrategy) {
        this.contentStrategy = contentMergeStrategy;
        return this;
    }

    public CherryPickCommand setMainlineParentNumber(int i) {
        this.mainlineParentNumber = Integer.valueOf(i);
        return this;
    }

    public CherryPickCommand setNoCommit(boolean z) {
        this.noCommit = z;
        return this;
    }

    public CherryPickCommand setProgressMonitor(ProgressMonitor progressMonitor) {
        if (progressMonitor == null) {
            progressMonitor = NullProgressMonitor.INSTANCE;
        }
        this.monitor = progressMonitor;
        return this;
    }

    private String calculateOurName(Ref ref) {
        String str = this.ourCommitName;
        return str != null ? str : Repository.shortenRefName(ref.getTarget().getName());
    }

    public String toString() {
        return "CherryPickCommand [repo=" + String.valueOf(this.repo) + ",\ncommits=" + String.valueOf(this.commits) + ",\nmainlineParentNumber=" + String.valueOf(this.mainlineParentNumber) + ", noCommit=" + this.noCommit + ", ourCommitName=" + this.ourCommitName + ", reflogPrefix=" + this.reflogPrefix + ", strategy=" + String.valueOf(this.strategy) + CollectionUtils.DEFAULT_TOSTRING_SUFFIX;
    }
}
