package org.eclipse.jgit.api;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidConfigurationException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.dircache.DirCacheCheckout;
import org.eclipse.jgit.errors.ConfigInvalidException;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.lib.RefUpdate;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.merge.MergeStrategy;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.submodule.SubmoduleWalk;
import org.eclipse.jgit.treewalk.filter.PathFilterGroup;

/* JADX INFO: loaded from: classes5.dex */
public class SubmoduleUpdateCommand extends TransportCommand<SubmoduleUpdateCommand, Collection<String>> {
    private CloneCommand.Callback callback;
    private boolean fetch;
    private FetchCommand.Callback fetchCallback;
    private ProgressMonitor monitor;
    private final Collection<String> paths;
    private MergeStrategy strategy;

    public SubmoduleUpdateCommand(Repository repository) {
        super(repository);
        this.strategy = MergeStrategy.RECURSIVE;
        this.fetch = false;
        this.paths = new ArrayList();
    }

    public SubmoduleUpdateCommand setProgressMonitor(ProgressMonitor progressMonitor) {
        this.monitor = progressMonitor;
        return this;
    }

    public SubmoduleUpdateCommand setFetch(boolean z) {
        this.fetch = z;
        return this;
    }

    public SubmoduleUpdateCommand addPath(String str) {
        this.paths.add(str);
        return this;
    }

    private Repository getOrCloneSubmodule(SubmoduleWalk submoduleWalk, String str) throws GitAPIException, IOException {
        Repository repository = submoduleWalk.getRepository();
        if (repository == null) {
            CloneCommand.Callback callback = this.callback;
            if (callback != null) {
                callback.cloningSubmodule(submoduleWalk.getPath());
            }
            CloneCommand cloneCommandCloneRepository = Git.cloneRepository();
            configure(cloneCommandCloneRepository);
            cloneCommandCloneRepository.setURI(str);
            cloneCommandCloneRepository.setDirectory(submoduleWalk.getDirectory());
            cloneCommandCloneRepository.setGitDir(new File(new File(this.repo.getCommonDirectory(), Constants.MODULES), submoduleWalk.getPath()));
            ProgressMonitor progressMonitor = this.monitor;
            if (progressMonitor != null) {
                cloneCommandCloneRepository.setProgressMonitor(progressMonitor);
            }
            return cloneCommandCloneRepository.call().getRepository();
        }
        if (this.fetch) {
            FetchCommand.Callback callback2 = this.fetchCallback;
            if (callback2 != null) {
                callback2.fetchingSubmodule(submoduleWalk.getPath());
            }
            FetchCommand fetchCommandFetch = Git.wrap(repository).fetch();
            ProgressMonitor progressMonitor2 = this.monitor;
            if (progressMonitor2 != null) {
                fetchCommandFetch.setProgressMonitor(progressMonitor2);
            }
            configure(fetchCommandFetch);
            fetchCommandFetch.call();
        }
        return repository;
    }

    /* JADX WARN: Code duplicated, block: B:54:0x00ef A[Catch: all -> 0x00f3, TRY_ENTER, TryCatch #4 {all -> 0x00f3, blocks: (B:3:0x0004, B:11:0x0028, B:54:0x00ef, B:55:0x00f2, B:4:0x000a, B:6:0x0012, B:7:0x001b, B:8:0x0020, B:13:0x002c, B:16:0x0033, B:33:0x00c3, B:49:0x00e6, B:51:0x00eb), top: B:72:0x0004, inners: #6 }] */
    @Override // org.eclipse.jgit.api.GitCommand, java.util.concurrent.Callable
    public Collection<String> call() throws Throwable {
        String configUrl;
        checkCallable();
        Throwable th = null;
        try {
            SubmoduleWalk submoduleWalkForIndex = SubmoduleWalk.forIndex(this.repo);
            try {
                if (!this.paths.isEmpty()) {
                    submoduleWalkForIndex.setFilter(PathFilterGroup.createFromStrings(this.paths));
                }
                ArrayList arrayList = new ArrayList();
                while (submoduleWalkForIndex.next()) {
                    if (submoduleWalkForIndex.getModulesPath() != null && (configUrl = submoduleWalkForIndex.getConfigUrl()) != null) {
                        try {
                            Repository orCloneSubmodule = getOrCloneSubmodule(submoduleWalkForIndex, configUrl);
                            try {
                                RevWalk revWalk = new RevWalk(orCloneSubmodule);
                                try {
                                    RevCommit commit = revWalk.parseCommit(submoduleWalkForIndex.getObjectId());
                                    String configUpdate = submoduleWalkForIndex.getConfigUpdate();
                                    if ("merge".equals(configUpdate)) {
                                        MergeCommand mergeCommand = new MergeCommand(orCloneSubmodule);
                                        mergeCommand.include(commit);
                                        mergeCommand.setProgressMonitor(this.monitor);
                                        mergeCommand.setStrategy(this.strategy);
                                        mergeCommand.call();
                                    } else if ("rebase".equals(configUpdate)) {
                                        RebaseCommand rebaseCommand = new RebaseCommand(orCloneSubmodule);
                                        rebaseCommand.setUpstream(commit);
                                        rebaseCommand.setProgressMonitor(this.monitor);
                                        rebaseCommand.setStrategy(this.strategy);
                                        rebaseCommand.call();
                                    } else {
                                        DirCacheCheckout dirCacheCheckout = new DirCacheCheckout(orCloneSubmodule, orCloneSubmodule.lockDirCache(), commit.getTree());
                                        dirCacheCheckout.setFailOnConflict(true);
                                        dirCacheCheckout.setProgressMonitor(this.monitor);
                                        dirCacheCheckout.checkout();
                                        RefUpdate refUpdateUpdateRef = orCloneSubmodule.updateRef("HEAD", true);
                                        refUpdateUpdateRef.setNewObjectId(commit);
                                        refUpdateUpdateRef.forceUpdate();
                                        CloneCommand.Callback callback = this.callback;
                                        if (callback != null) {
                                            callback.checkingOut(commit, submoduleWalkForIndex.getPath());
                                        }
                                    }
                                    revWalk.close();
                                    if (orCloneSubmodule != null) {
                                        orCloneSubmodule.close();
                                    }
                                    arrayList.add(submoduleWalkForIndex.getPath());
                                } catch (Throwable th2) {
                                    th = th2;
                                    revWalk.close();
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                if (th == null) {
                                    th = th3;
                                } else if (th != th3) {
                                    th.addSuppressed(th3);
                                }
                                if (orCloneSubmodule == null) {
                                    throw th;
                                }
                                orCloneSubmodule.close();
                                throw th;
                                if (submoduleWalkForIndex != null) {
                                    submoduleWalkForIndex.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th4) {
                            if (th == null) {
                                th = th4;
                                throw th;
                            }
                            if (th == th4) {
                                throw th;
                            }
                            th.addSuppressed(th4);
                            throw th;
                        }
                    }
                }
                if (submoduleWalkForIndex != null) {
                    submoduleWalkForIndex.close();
                }
                return arrayList;
            } catch (Throwable th5) {
                if (submoduleWalkForIndex != null) {
                    submoduleWalkForIndex.close();
                }
                throw th5;
            }
        } catch (Throwable th6) {
            if (th == null) {
                throw th6;
            }
            if (th == th6) {
                throw th;
            }
            try {
                th.addSuppressed(th6);
                throw th;
            } catch (IOException e) {
                throw new JGitInternalException(e.getMessage(), e);
            } catch (ConfigInvalidException e2) {
                throw new InvalidConfigurationException(e2.getMessage(), e2);
            }
        }
    }

    public SubmoduleUpdateCommand setStrategy(MergeStrategy mergeStrategy) {
        this.strategy = mergeStrategy;
        return this;
    }

    public SubmoduleUpdateCommand setCallback(CloneCommand.Callback callback) {
        this.callback = callback;
        return this;
    }

    public SubmoduleUpdateCommand setFetchCallback(FetchCommand.Callback callback) {
        this.fetchCallback = callback;
        return this;
    }
}
