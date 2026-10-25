package org.eclipse.jgit.api;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.eclipse.jgit.api.errors.CannotDeleteCurrentBranchException;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.api.errors.NotMergedException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.NullProgressMonitor;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.RefUpdate;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.StoredConfig;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;

/* JADX INFO: loaded from: classes5.dex */
public class DeleteBranchCommand extends GitCommand<List<String>> {
    private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$lib$RefUpdate$Result;
    private final Set<String> branchNames;
    private boolean force;
    private ProgressMonitor monitor;

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

    protected DeleteBranchCommand(Repository repository) {
        super(repository);
        this.branchNames = new HashSet();
        this.monitor = NullProgressMonitor.INSTANCE;
    }

    @Override // org.eclipse.jgit.api.GitCommand, java.util.concurrent.Callable
    public List<String> call() throws GitAPIException {
        checkCallable();
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        if (this.branchNames.isEmpty()) {
            return arrayList;
        }
        try {
            deleteBranches(arrayList, hashSet);
            e = null;
        } catch (Exception e) {
            e = e;
        }
        this.monitor.beginTask(JGitText.get().updatingConfig, 1);
        try {
            updateConfig(hashSet, e);
            return arrayList;
        } finally {
            this.monitor.update(1);
            this.monitor.endTask();
        }
    }

    private void deleteBranches(List<String> list, Set<String> set) throws GitAPIException {
        try {
            String fullBranch = this.repo.getFullBranch();
            if (!this.force) {
                Throwable th = null;
                try {
                    RevWalk revWalk = new RevWalk(this.repo);
                    try {
                        RevCommit commit = revWalk.parseCommit(this.repo.resolve("HEAD"));
                        for (String str : this.branchNames) {
                            if (str != null && this.repo.findRef(str) != null && !revWalk.isMergedInto(revWalk.parseCommit(this.repo.resolve(str)), commit)) {
                                throw new NotMergedException();
                            }
                        }
                        revWalk.close();
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
            setCallable(false);
            this.monitor.start(2);
            this.monitor.beginTask(JGitText.get().deletingBranches, this.branchNames.size());
            try {
                for (String str2 : this.branchNames) {
                    if (str2 == null) {
                        this.monitor.update(1);
                    } else {
                        Ref refFindRef = this.repo.findRef(str2);
                        if (refFindRef == null) {
                            this.monitor.update(1);
                        } else {
                            String name = refFindRef.getName();
                            if (name.equals(fullBranch)) {
                                throw new CannotDeleteCurrentBranchException(MessageFormat.format(JGitText.get().cannotDeleteCheckedOutBranch, str2));
                            }
                            RefUpdate refUpdateUpdateRef = this.repo.updateRef(name);
                            refUpdateUpdateRef.setRefLogMessage("branch deleted", false);
                            refUpdateUpdateRef.setForceUpdate(true);
                            RefUpdate.Result resultDelete = refUpdateUpdateRef.delete();
                            int i = $SWITCH_TABLE$org$eclipse$jgit$lib$RefUpdate$Result()[resultDelete.ordinal()];
                            if (i == 2 || i == 7 || i == 9) {
                                throw new JGitInternalException(MessageFormat.format(JGitText.get().deleteBranchUnexpectedResult, resultDelete.name()));
                            }
                            list.add(name);
                            if (name.startsWith(Constants.R_HEADS)) {
                                set.add(name.substring(Constants.R_HEADS.length()));
                            }
                            this.monitor.update(1);
                            if (this.monitor.isCancelled()) {
                                break;
                            }
                        }
                    }
                }
                this.monitor.endTask();
            } catch (Throwable th4) {
                this.monitor.endTask();
                throw th4;
            }
        } catch (IOException e) {
            throw new JGitInternalException(e.getMessage(), e);
        }
    }

    private void updateConfig(Set<String> set, Exception exc) throws GitAPIException {
        if (!set.isEmpty()) {
            try {
                StoredConfig config = this.repo.getConfig();
                Iterator<String> it = set.iterator();
                boolean zRemoveSection = false;
                while (it.hasNext()) {
                    zRemoveSection |= config.removeSection(ConfigConstants.CONFIG_BRANCH_SECTION, it.next());
                }
                if (zRemoveSection) {
                    config.save();
                }
            } catch (IOException e) {
                e = e;
            }
        }
        e = null;
        if (exc == null) {
            if (e != null) {
                throw new JGitInternalException(e.getMessage(), e);
            }
            return;
        }
        if (exc instanceof GitAPIException) {
            if (e != null) {
                exc.addSuppressed(e);
            }
            throw ((GitAPIException) exc);
        }
        if (exc instanceof RuntimeException) {
            if (e != null) {
                exc.addSuppressed(e);
            }
            throw ((RuntimeException) exc);
        }
        JGitInternalException jGitInternalException = new JGitInternalException(exc.getMessage(), exc);
        if (e != null) {
            jGitInternalException.addSuppressed(e);
            throw jGitInternalException;
        }
        throw jGitInternalException;
    }

    public DeleteBranchCommand setBranchNames(String... strArr) {
        checkCallable();
        this.branchNames.clear();
        this.branchNames.addAll(Arrays.asList(strArr));
        return this;
    }

    public DeleteBranchCommand setBranchNames(Collection<String> collection) {
        checkCallable();
        this.branchNames.clear();
        this.branchNames.addAll(collection);
        return this;
    }

    public DeleteBranchCommand setForce(boolean z) {
        checkCallable();
        this.force = z;
        return this;
    }

    public ProgressMonitor getProgressMonitor() {
        return this.monitor;
    }

    public DeleteBranchCommand setProgressMonitor(ProgressMonitor progressMonitor) {
        checkCallable();
        if (progressMonitor == null) {
            progressMonitor = NullProgressMonitor.INSTANCE;
        }
        this.monitor = progressMonitor;
        return this;
    }
}
