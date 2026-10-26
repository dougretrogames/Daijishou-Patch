package org.eclipse.jgit.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.errors.ConfigInvalidException;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.StoredConfig;
import org.eclipse.jgit.submodule.SubmoduleWalk;
import org.eclipse.jgit.treewalk.filter.PathFilterGroup;

/* INFO: loaded from: classes5.dex */
public class SubmoduleSyncCommand extends GitCommand<Map<String, String>> {
    private final Collection<String> paths;

    public SubmoduleSyncCommand(Repository repository) {
        super(repository);
        this.paths = new ArrayList();
    }

    public SubmoduleSyncCommand addPath(String str) {
        this.paths.add(str);
        return this;
    }

    protected String getHeadBranch(Repository repository) throws IOException {
        Ref refExactRef = repository.exactRef("HEAD");
        if (refExactRef == null || !refExactRef.isSymbolic()) {
            return null;
        }
        return Repository.shortenRefName(refExactRef.getLeaf().getName());
    }

    @Override // org.eclipse.jgit.api.GitCommand, java.util.concurrent.Callable
    public Map<String, String> call() throws GitAPIException {
        checkCallable();
        Throwable th = null;
        try {
            SubmoduleWalk submoduleWalkForIndex = SubmoduleWalk.forIndex(this.repo);
            try {
                if (!this.paths.isEmpty()) {
                    submoduleWalkForIndex.setFilter(PathFilterGroup.createFromStrings(this.paths));
                }
                HashMap map = new HashMap();
                StoredConfig config = this.repo.getConfig();
                while (submoduleWalkForIndex.next()) {
                    String remoteUrl = submoduleWalkForIndex.getRemoteUrl();
                    if (remoteUrl != null) {
                        String path = submoduleWalkForIndex.getPath();
                        config.setString(ConfigConstants.CONFIG_SUBMODULE_SECTION, path, "url", remoteUrl);
                        map.put(path, remoteUrl);
                        try {
                            Repository repository = submoduleWalkForIndex.getRepository();
                            if (repository != null) {
                                try {
                                    StoredConfig config2 = repository.getConfig();
                                    String headBranch = getHeadBranch(repository);
                                    String string = headBranch != null ? config2.getString(ConfigConstants.CONFIG_BRANCH_SECTION, headBranch, "remote") : null;
                                    if (string == null) {
                                        string = "origin";
                                    }
                                    config2.setString("remote", string, "url", remoteUrl);
                                    config2.save();
                                    if (repository != null) {
                                        repository.close();
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (repository == null) {
                                        throw th;
                                    }
                                    repository.close();
                                    throw th;
                                }
                            } else if (repository != null) {
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
                if (!map.isEmpty()) {
                    config.save();
                }
                if (submoduleWalkForIndex != null) {
                    submoduleWalkForIndex.close();
                }
                return map;
            } catch (Throwable th4) {
                if (submoduleWalkForIndex == null) {
                    throw th4;
                }
                submoduleWalkForIndex.close();
                throw th4;
            }
        } catch (Throwable th5) {
            if (th == null) {
                throw th5;
            }
            if (th != th5) {
                try {
                    th.addSuppressed(th5);
                } catch (IOException | ConfigInvalidException e) {
                    throw new JGitInternalException(e.getMessage(), e);
                }
            }
            throw th;
        }
    }
}
