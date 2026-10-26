package org.eclipse.jgit.api;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.MessageFormat;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import org.eclipse.jgit.annotations.Nullable;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidConfigurationException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.errors.ConfigInvalidException;
import org.eclipse.jgit.errors.NoRemoteRepositoryException;
import org.eclipse.jgit.errors.NotSupportedException;
import org.eclipse.jgit.errors.TransportException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.NullProgressMonitor;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.StoredConfig;
import org.eclipse.jgit.lib.SubmoduleConfig;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.submodule.SubmoduleWalk;
import org.eclipse.jgit.transport.FetchResult;
import org.eclipse.jgit.transport.RefSpec;
import org.eclipse.jgit.transport.TagOpt;
import org.eclipse.jgit.transport.Transport;

/* INFO: loaded from: classes5.dex */
public class FetchCommand extends TransportCommand<FetchCommand, FetchResult> {
    private Callback callback;
    private boolean checkFetchedObjects;
    private Instant deepenSince;
    private Integer depth;
    private boolean dryRun;
    private String initialBranch;
    private boolean isForceUpdate;
    private ProgressMonitor monitor;
    private List<RefSpec> refSpecs;
    private String remote;
    private Boolean removeDeletedRefs;
    private List<String> shallowExcludes;
    private SubmoduleConfig.FetchRecurseSubmodulesMode submoduleRecurseMode;
    private TagOpt tagOption;
    private boolean thin;
    private boolean unshallow;

    public interface Callback {
        void fetchingSubmodule(String str);
    }

    protected FetchCommand(Repository repository) {
        super(repository);
        this.remote = "origin";
        this.monitor = NullProgressMonitor.INSTANCE;
        this.thin = true;
        this.submoduleRecurseMode = null;
        this.shallowExcludes = new ArrayList();
        this.refSpecs = new ArrayList(3);
    }

    private SubmoduleConfig.FetchRecurseSubmodulesMode getRecurseMode(String str) {
        SubmoduleConfig.FetchRecurseSubmodulesMode fetchRecurseSubmodulesMode = this.submoduleRecurseMode;
        if (fetchRecurseSubmodulesMode != null) {
            return fetchRecurseSubmodulesMode;
        }
        SubmoduleConfig.FetchRecurseSubmodulesMode fetchRecurseSubmodulesMode2 = (SubmoduleConfig.FetchRecurseSubmodulesMode) this.repo.getConfig().getEnum(SubmoduleConfig.FetchRecurseSubmodulesMode.valuesCustom(), ConfigConstants.CONFIG_SUBMODULE_SECTION, str, ConfigConstants.CONFIG_KEY_FETCH_RECURSE_SUBMODULES, null);
        if (fetchRecurseSubmodulesMode2 != null) {
            return fetchRecurseSubmodulesMode2;
        }
        SubmoduleConfig.FetchRecurseSubmodulesMode fetchRecurseSubmodulesMode3 = (SubmoduleConfig.FetchRecurseSubmodulesMode) this.repo.getConfig().getEnum(SubmoduleConfig.FetchRecurseSubmodulesMode.valuesCustom(), "fetch", null, ConfigConstants.CONFIG_KEY_RECURSE_SUBMODULES, null);
        return fetchRecurseSubmodulesMode3 != null ? fetchRecurseSubmodulesMode3 : SubmoduleConfig.FetchRecurseSubmodulesMode.ON_DEMAND;
    }

    private void fetchSubmodules(FetchResult fetchResult) throws Throwable {
        Throwable th = null;
        try {
            SubmoduleWalk submoduleWalk = new SubmoduleWalk(this.repo);
            try {
                RevWalk revWalk = new RevWalk(this.repo);
                try {
                    ObjectId objectIdResolve = this.repo.resolve(Constants.FETCH_HEAD);
                    if (objectIdResolve != null && revWalk.parseAny(objectIdResolve).getType() != 3) {
                        submoduleWalk.setTree(revWalk.parseTree(objectIdResolve));
                        while (submoduleWalk.next()) {
                            try {
                                Repository repository = submoduleWalk.getRepository();
                                if (repository != null) {
                                    try {
                                        if (submoduleWalk.getModulesPath() != null && submoduleWalk.getConfigUrl() != null) {
                                            SubmoduleConfig.FetchRecurseSubmodulesMode recurseMode = getRecurseMode(submoduleWalk.getPath());
                                            if ((recurseMode == SubmoduleConfig.FetchRecurseSubmodulesMode.ON_DEMAND && !repository.getObjectDatabase().has(submoduleWalk.getObjectId())) || recurseMode == SubmoduleConfig.FetchRecurseSubmodulesMode.YES) {
                                                FetchCommand recurseSubmodules = new FetchCommand(repository).setProgressMonitor(this.monitor).setTagOpt(this.tagOption).setCheckFetchedObjects(this.checkFetchedObjects).setRemoveDeletedRefs(isRemoveDeletedRefs()).setThin(this.thin).setRefSpecs(applyOptions(this.refSpecs)).setDryRun(this.dryRun).setRecurseSubmodules(recurseMode);
                                                configure(recurseSubmodules);
                                                Callback callback = this.callback;
                                                if (callback != null) {
                                                    callback.fetchingSubmodule(submoduleWalk.getPath());
                                                }
                                                fetchResult.addSubmodule(submoduleWalk.getPath(), recurseSubmodules.call());
                                            }
                                            if (repository != null) {
                                                repository.close();
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (repository == null) {
                                            throw th;
                                        }
                                        repository.close();
                                        throw th;
                                        revWalk.close();
                                        throw th;
                                    }
                                }
                                if (repository != null) {
                                    repository.close();
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
                    }
                    revWalk.close();
                    submoduleWalk.close();
                } catch (Throwable th4) {
                    revWalk.close();
                    throw th4;
                }
            } catch (Throwable th5) {
                if (th == null) {
                    th = th5;
                } else if (th != th5) {
                    th.addSuppressed(th5);
                }
                submoduleWalk.close();
                throw th;
            }
        } catch (Throwable th6) {
            if (th == null) {
                throw th6;
            }
            if (th != th6) {
                try {
                    th.addSuppressed(th6);
                } catch (IOException e) {
                    throw new JGitInternalException(e.getMessage(), e);
                } catch (ConfigInvalidException e2) {
                    throw new InvalidConfigurationException(e2.getMessage(), e2);
                }
            }
            throw th;
        }
    }

    @Override // org.eclipse.jgit.api.GitCommand, java.util.concurrent.Callable
    public FetchResult call() throws GitAPIException {
        checkCallable();
        Throwable th = null;
        try {
            Transport transportOpen = Transport.open(this.repo, this.remote);
            try {
                transportOpen.setCheckFetchedObjects(this.checkFetchedObjects);
                transportOpen.setRemoveDeletedRefs(isRemoveDeletedRefs());
                transportOpen.setDryRun(this.dryRun);
                TagOpt tagOpt = this.tagOption;
                if (tagOpt != null) {
                    transportOpen.setTagOpt(tagOpt);
                }
                transportOpen.setFetchThin(this.thin);
                Integer num = this.depth;
                if (num != null) {
                    transportOpen.setDepth(num);
                }
                if (this.unshallow) {
                    if (this.depth != null) {
                        throw new IllegalStateException(JGitText.get().depthWithUnshallow);
                    }
                    transportOpen.setDepth(Integer.MAX_VALUE);
                }
                Instant instant = this.deepenSince;
                if (instant != null) {
                    transportOpen.setDeepenSince(instant);
                }
                transportOpen.setDeepenNots(this.shallowExcludes);
                configure(transportOpen);
                FetchResult fetchResultFetch = transportOpen.fetch(this.monitor, applyOptions(this.refSpecs), this.initialBranch);
                if (!this.repo.isBare()) {
                    fetchSubmodules(fetchResultFetch);
                }
                if (transportOpen != null) {
                    transportOpen.close();
                }
                return fetchResultFetch;
            } catch (Throwable th2) {
                if (transportOpen != null) {
                    transportOpen.close();
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
            } catch (URISyntaxException e) {
                throw new InvalidRemoteException(MessageFormat.format(JGitText.get().invalidRemote, this.remote), e);
            } catch (NoRemoteRepositoryException e2) {
                throw new InvalidRemoteException(MessageFormat.format(JGitText.get().invalidRemote, this.remote), e2);
            } catch (NotSupportedException e3) {
                throw new JGitInternalException(JGitText.get().exceptionCaughtDuringExecutionOfFetchCommand, e3);
            } catch (TransportException e4) {
                throw new org.eclipse.jgit.api.errors.TransportException(e4.getMessage(), e4);
            }
        }
    }

    private List<RefSpec> applyOptions(List<RefSpec> list) {
        if (!isForceUpdate()) {
            return list;
        }
        ArrayList arrayList = new ArrayList(3);
        Iterator<RefSpec> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().setForceUpdate(true));
        }
        return arrayList;
    }

    public FetchCommand setRecurseSubmodules(@Nullable SubmoduleConfig.FetchRecurseSubmodulesMode fetchRecurseSubmodulesMode) {
        checkCallable();
        this.submoduleRecurseMode = fetchRecurseSubmodulesMode;
        return this;
    }

    public FetchCommand setRemote(String str) {
        checkCallable();
        this.remote = str;
        return this;
    }

    public String getRemote() {
        return this.remote;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public boolean isCheckFetchedObjects() {
        return this.checkFetchedObjects;
    }

    public FetchCommand setCheckFetchedObjects(boolean z) {
        checkCallable();
        this.checkFetchedObjects = z;
        return this;
    }

    public boolean isRemoveDeletedRefs() {
        Boolean bool = this.removeDeletedRefs;
        if (bool != null) {
            return bool.booleanValue();
        }
        StoredConfig config = this.repo.getConfig();
        return config.getBoolean("remote", this.remote, ConfigConstants.CONFIG_KEY_PRUNE, config.getBoolean("fetch", null, ConfigConstants.CONFIG_KEY_PRUNE, false));
    }

    public FetchCommand setRemoveDeletedRefs(boolean z) {
        checkCallable();
        this.removeDeletedRefs = Boolean.valueOf(z);
        return this;
    }

    public ProgressMonitor getProgressMonitor() {
        return this.monitor;
    }

    public FetchCommand setProgressMonitor(ProgressMonitor progressMonitor) {
        checkCallable();
        if (progressMonitor == null) {
            progressMonitor = NullProgressMonitor.INSTANCE;
        }
        this.monitor = progressMonitor;
        return this;
    }

    public List<RefSpec> getRefSpecs() {
        return this.refSpecs;
    }

    public FetchCommand setRefSpecs(String... strArr) {
        return setRefSpecs((List<RefSpec>) Arrays.stream(strArr).map(new FetchCommand$$ExternalSyntheticLambda0()).collect(Collectors.toList()));
    }

    public FetchCommand setRefSpecs(RefSpec... refSpecArr) {
        return setRefSpecs(Arrays.asList(refSpecArr));
    }

    public FetchCommand setRefSpecs(List<RefSpec> list) {
        checkCallable();
        this.refSpecs.clear();
        this.refSpecs.addAll(list);
        return this;
    }

    public boolean isDryRun() {
        return this.dryRun;
    }

    public FetchCommand setDryRun(boolean z) {
        checkCallable();
        this.dryRun = z;
        return this;
    }

    public boolean isThin() {
        return this.thin;
    }

    public FetchCommand setThin(boolean z) {
        checkCallable();
        this.thin = z;
        return this;
    }

    public FetchCommand setTagOpt(TagOpt tagOpt) {
        checkCallable();
        this.tagOption = tagOpt;
        return this;
    }

    public FetchCommand setInitialBranch(String str) {
        this.initialBranch = str;
        return this;
    }

    public FetchCommand setCallback(Callback callback) {
        this.callback = callback;
        return this;
    }

    public boolean isForceUpdate() {
        return this.isForceUpdate;
    }

    public FetchCommand setForceUpdate(boolean z) {
        this.isForceUpdate = z;
        return this;
    }

    public FetchCommand setDepth(int i) {
        if (i < 1) {
            throw new IllegalArgumentException(JGitText.get().depthMustBeAt1);
        }
        this.depth = Integer.valueOf(i);
        return this;
    }

    public FetchCommand setShallowSince(OffsetDateTime offsetDateTime) {
        this.deepenSince = offsetDateTime.toInstant();
        return this;
    }

    public FetchCommand setShallowSince(Instant instant) {
        this.deepenSince = instant;
        return this;
    }

    public FetchCommand addShallowExclude(String str) {
        this.shallowExcludes.add(str);
        return this;
    }

    public FetchCommand addShallowExclude(ObjectId objectId) {
        this.shallowExcludes.add(objectId.name());
        return this;
    }

    public FetchCommand setUnshallow(boolean z) {
        this.unshallow = z;
        return this;
    }

    void setShallowExcludes(List<String> list) {
        this.shallowExcludes = list;
    }
}
