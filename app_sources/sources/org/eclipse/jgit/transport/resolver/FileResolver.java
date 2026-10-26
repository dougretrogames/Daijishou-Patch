package org.eclipse.jgit.transport.resolver;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.eclipse.jgit.errors.RepositoryNotFoundException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.RepositoryCache;
import org.eclipse.jgit.util.FS;
import org.eclipse.jgit.util.StringUtils;

/* INFO: loaded from: classes5.dex */
public class FileResolver<C> implements RepositoryResolver<C> {
    private volatile boolean exportAll;
    private final Collection<File> exportBase;
    private final Map<String, Repository> exports;

    public FileResolver() {
        this.exports = new ConcurrentHashMap();
        this.exportBase = new CopyOnWriteArrayList();
    }

    public FileResolver(File file, boolean z) {
        this();
        exportDirectory(file);
        setExportAll(z);
    }

    @Override // org.eclipse.jgit.transport.resolver.RepositoryResolver
    public Repository open(C c, String str) throws ServiceNotEnabledException, RepositoryNotFoundException {
        if (isUnreasonableName(str)) {
            throw new RepositoryNotFoundException(str);
        }
        Repository repository = this.exports.get(StringUtils.nameWithDotGit(str));
        if (repository != null) {
            repository.incrementOpen();
            return repository;
        }
        Iterator<File> it = this.exportBase.iterator();
        while (it.hasNext()) {
            File fileResolve = RepositoryCache.FileKey.resolve(new File(it.next(), str), FS.DETECTED);
            if (fileResolve != null) {
                try {
                    Repository repositoryOpen = RepositoryCache.open(RepositoryCache.FileKey.exact(fileResolve, FS.DETECTED), true);
                    try {
                        if (isExportOk(c, str, repositoryOpen)) {
                            return repositoryOpen;
                        }
                        throw new ServiceNotEnabledException();
                    } catch (IOException e) {
                        e = e;
                        repositoryOpen.close();
                        throw new RepositoryNotFoundException(str, e);
                    } catch (RuntimeException e2) {
                        e = e2;
                        repositoryOpen.close();
                        throw new RepositoryNotFoundException(str, e);
                    } catch (ServiceNotEnabledException e3) {
                        repositoryOpen.close();
                        throw e3;
                    }
                } catch (IOException e4) {
                    throw new RepositoryNotFoundException(str, e4);
                }
            }
        }
        if (this.exportBase.size() == 1) {
            throw new RepositoryNotFoundException(str, new RepositoryNotFoundException(new File(this.exportBase.iterator().next(), str)));
        }
        throw new RepositoryNotFoundException(str);
    }

    public boolean isExportAll() {
        return this.exportAll;
    }

    public void setExportAll(boolean z) {
        this.exportAll = z;
    }

    public void exportRepository(String str, Repository repository) {
        this.exports.put(StringUtils.nameWithDotGit(str), repository);
    }

    public void exportDirectory(File file) {
        this.exportBase.add(file);
    }

    protected boolean isExportOk(C c, String str, Repository repository) throws IOException {
        if (isExportAll()) {
            return true;
        }
        if (repository.getDirectory() != null) {
            return new File(repository.getDirectory(), "git-daemon-export-ok").exists();
        }
        return false;
    }

    private static boolean isUnreasonableName(String str) {
        return str.length() == 0 || str.indexOf(92) >= 0 || new File(str).isAbsolute() || str.startsWith("../") || str.contains("/../") || str.contains("/./") || str.contains("//");
    }
}
