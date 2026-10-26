package org.eclipse.jgit.api;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.api.errors.NoFilepatternException;
import org.eclipse.jgit.dircache.DirCache;
import org.eclipse.jgit.dircache.DirCacheBuildIterator;
import org.eclipse.jgit.dircache.DirCacheBuilder;
import org.eclipse.jgit.events.WorkingTreeModifiedEvent;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.treewalk.TreeWalk;
import org.eclipse.jgit.treewalk.filter.PathFilterGroup;

/* INFO: loaded from: classes5.dex */
public class RmCommand extends GitCommand<DirCache> {
    private boolean cached;
    private Collection<String> filepatterns;

    public RmCommand(Repository repository) {
        super(repository);
        this.cached = false;
        this.filepatterns = new ArrayList();
    }

    public RmCommand addFilepattern(String str) {
        checkCallable();
        this.filepatterns.add(str);
        return this;
    }

    public RmCommand setCached(boolean z) {
        checkCallable();
        this.cached = z;
        return this;
    }

    /* WARN: Code duplicated, block: B:45:0x00ad A[DONT_INVERT] */
    /* WARN: Code duplicated, block: B:75:0x00af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* WARN: Code duplicated, block: B:94:? A[RETURN, SYNTHETIC] */
    @Override // org.eclipse.jgit.api.GitCommand, java.util.concurrent.Callable
    public DirCache call() throws Throwable {
        DirCache dirCacheLockDirCache;
        Throwable th;
        if (this.filepatterns.isEmpty()) {
            throw new NoFilepatternException(JGitText.get().atLeastOnePatternIsRequired);
        }
        checkCallable();
        ArrayList arrayList = new ArrayList();
        try {
            TreeWalk treeWalk = new TreeWalk(this.repo);
            try {
                dirCacheLockDirCache = this.repo.lockDirCache();
                try {
                    DirCacheBuilder dirCacheBuilderBuilder = dirCacheLockDirCache.builder();
                    treeWalk.reset();
                    treeWalk.setRecursive(true);
                    treeWalk.setFilter(PathFilterGroup.createFromStrings(this.filepatterns));
                    treeWalk.addTree(new DirCacheBuildIterator(dirCacheBuilderBuilder));
                    while (treeWalk.next()) {
                        if (!this.cached && treeWalk.getFileMode(0).getObjectType() == 3) {
                            String pathString = treeWalk.getPathString();
                            if (delete(new File(this.repo.getWorkTree(), pathString))) {
                                arrayList.add(pathString);
                            }
                        }
                    }
                    dirCacheBuilderBuilder.commit();
                    setCallable(false);
                    try {
                        treeWalk.close();
                        if (dirCacheLockDirCache != null) {
                            try {
                                dirCacheLockDirCache.unlock();
                            } finally {
                                if (!arrayList.isEmpty()) {
                                    this.repo.fireEvent(new WorkingTreeModifiedEvent(null, arrayList));
                                }
                            }
                        }
                        return dirCacheLockDirCache;
                    } catch (Throwable th2) {
                        th = th2;
                        th = null;
                        try {
                            if (th != null) {
                                throw th;
                            }
                            if (th != th) {
                                try {
                                    th.addSuppressed(th);
                                } catch (IOException e) {
                                    throw new JGitInternalException(JGitText.get().exceptionCaughtDuringExecutionOfRmCommand, e);
                                }
                            }
                            throw th;
                        } catch (Throwable th3) {
                            if (dirCacheLockDirCache != null) {
                                try {
                                    dirCacheLockDirCache.unlock();
                                } finally {
                                    if (!arrayList.isEmpty()) {
                                        this.repo.fireEvent(new WorkingTreeModifiedEvent(null, arrayList));
                                    }
                                }
                            }
                            throw th3;
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    try {
                        treeWalk.close();
                        throw th;
                    } catch (Throwable th5) {
                        th = th5;
                        if (th != null) {
                            throw th;
                        }
                        if (th != th) {
                            th.addSuppressed(th);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                dirCacheLockDirCache = null;
            }
        } catch (Throwable th7) {
            th = th7;
            dirCacheLockDirCache = null;
            th = null;
        }
    }

    private boolean delete(File file) {
        boolean z = false;
        while (file != null && !file.equals(this.repo.getWorkTree()) && file.delete()) {
            file = file.getParentFile();
            z = true;
        }
        return z;
    }
}
