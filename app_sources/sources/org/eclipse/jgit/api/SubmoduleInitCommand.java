package org.eclipse.jgit.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.errors.ConfigInvalidException;
import org.eclipse.jgit.lib.ConfigConstants;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.StoredConfig;
import org.eclipse.jgit.submodule.SubmoduleWalk;
import org.eclipse.jgit.treewalk.filter.PathFilterGroup;

/* INFO: loaded from: classes5.dex */
public class SubmoduleInitCommand extends GitCommand<Collection<String>> {
    private final Collection<String> paths;

    public SubmoduleInitCommand(Repository repository) {
        super(repository);
        this.paths = new ArrayList();
    }

    public SubmoduleInitCommand addPath(String str) {
        this.paths.add(str);
        return this;
    }

    @Override // org.eclipse.jgit.api.GitCommand, java.util.concurrent.Callable
    public Collection<String> call() throws GitAPIException {
        checkCallable();
        Throwable th = null;
        try {
            SubmoduleWalk submoduleWalkForIndex = SubmoduleWalk.forIndex(this.repo);
            try {
                if (!this.paths.isEmpty()) {
                    submoduleWalkForIndex.setFilter(PathFilterGroup.createFromStrings(this.paths));
                }
                StoredConfig config = this.repo.getConfig();
                ArrayList arrayList = new ArrayList();
                while (submoduleWalkForIndex.next()) {
                    if (submoduleWalkForIndex.getConfigUrl() == null) {
                        String path = submoduleWalkForIndex.getPath();
                        String moduleName = submoduleWalkForIndex.getModuleName();
                        String remoteUrl = submoduleWalkForIndex.getRemoteUrl();
                        String modulesUpdate = submoduleWalkForIndex.getModulesUpdate();
                        if (remoteUrl != null) {
                            config.setString(ConfigConstants.CONFIG_SUBMODULE_SECTION, moduleName, "url", remoteUrl);
                        }
                        if (modulesUpdate != null) {
                            config.setString(ConfigConstants.CONFIG_SUBMODULE_SECTION, moduleName, ConfigConstants.CONFIG_KEY_UPDATE, modulesUpdate);
                        }
                        if (remoteUrl != null || modulesUpdate != null) {
                            arrayList.add(path);
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    config.save();
                }
                return arrayList;
            } finally {
                if (submoduleWalkForIndex != null) {
                    submoduleWalkForIndex.close();
                }
            }
        } catch (Throwable th2) {
            if (0 == 0) {
                throw th2;
            }
            if (null == th2) {
                throw null;
            }
            try {
                th.addSuppressed(th2);
                throw null;
            } catch (IOException | ConfigInvalidException e) {
                throw new JGitInternalException(e.getMessage(), e);
            }
            throw new JGitInternalException(e.getMessage(), e);
        }
    }
}
