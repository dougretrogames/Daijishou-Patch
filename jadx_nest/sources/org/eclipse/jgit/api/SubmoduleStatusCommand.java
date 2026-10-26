package org.eclipse.jgit.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.errors.ConfigInvalidException;
import org.eclipse.jgit.lib.AnyObjectId;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.submodule.SubmoduleStatus;
import org.eclipse.jgit.submodule.SubmoduleStatusType;
import org.eclipse.jgit.submodule.SubmoduleWalk;
import org.eclipse.jgit.treewalk.filter.PathFilterGroup;

/* INFO: loaded from: classes5.dex */
public class SubmoduleStatusCommand extends GitCommand<Map<String, SubmoduleStatus>> {
    private final Collection<String> paths;

    public SubmoduleStatusCommand(Repository repository) {
        super(repository);
        this.paths = new ArrayList();
    }

    public SubmoduleStatusCommand addPath(String str) {
        this.paths.add(str);
        return this;
    }

    @Override // org.eclipse.jgit.api.GitCommand, java.util.concurrent.Callable
    public Map<String, SubmoduleStatus> call() throws GitAPIException {
        checkCallable();
        Throwable th = null;
        try {
            SubmoduleWalk submoduleWalkForIndex = SubmoduleWalk.forIndex(this.repo);
            try {
                if (!this.paths.isEmpty()) {
                    submoduleWalkForIndex.setFilter(PathFilterGroup.createFromStrings(this.paths));
                }
                HashMap map = new HashMap();
                while (submoduleWalkForIndex.next()) {
                    SubmoduleStatus status = getStatus(submoduleWalkForIndex);
                    map.put(status.getPath(), status);
                }
                return map;
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

    private SubmoduleStatus getStatus(SubmoduleWalk submoduleWalk) throws ConfigInvalidException, IOException {
        ObjectId objectId = submoduleWalk.getObjectId();
        String path = submoduleWalk.getPath();
        if (submoduleWalk.getModulesPath() == null) {
            return new SubmoduleStatus(SubmoduleStatusType.MISSING, path, objectId);
        }
        if (submoduleWalk.getConfigUrl() == null) {
            return new SubmoduleStatus(SubmoduleStatusType.UNINITIALIZED, path, objectId);
        }
        Throwable th = null;
        try {
            Repository repository = submoduleWalk.getRepository();
            try {
                if (repository == null) {
                    SubmoduleStatus submoduleStatus = new SubmoduleStatus(SubmoduleStatusType.UNINITIALIZED, path, objectId);
                    if (repository != null) {
                        repository.close();
                    }
                    return submoduleStatus;
                }
                ObjectId objectIdResolve = repository.resolve("HEAD");
                if (repository != null) {
                    repository.close();
                }
                if (objectIdResolve == null) {
                    return new SubmoduleStatus(SubmoduleStatusType.UNINITIALIZED, path, objectId, objectIdResolve);
                }
                if (!objectIdResolve.equals((AnyObjectId) objectId)) {
                    return new SubmoduleStatus(SubmoduleStatusType.REV_CHECKED_OUT, path, objectId, objectIdResolve);
                }
                return new SubmoduleStatus(SubmoduleStatusType.INITIALIZED, path, objectId, objectIdResolve);
            } catch (Throwable th2) {
                if (repository == null) {
                    throw th2;
                }
                repository.close();
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
}
