package org.eclipse.jgit.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.errors.NoWorkTreeException;
import org.eclipse.jgit.lib.IndexDiff;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.submodule.SubmoduleWalk;
import org.eclipse.jgit.treewalk.FileTreeIterator;
import org.eclipse.jgit.treewalk.WorkingTreeIterator;
import org.eclipse.jgit.treewalk.filter.PathFilterGroup;

/* JADX INFO: loaded from: classes5.dex */
public class StatusCommand extends GitCommand<Status> {
    private SubmoduleWalk.IgnoreSubmoduleMode ignoreSubmoduleMode;
    private List<String> paths;
    private ProgressMonitor progressMonitor;
    private WorkingTreeIterator workingTreeIt;

    protected StatusCommand(Repository repository) {
        super(repository);
        this.paths = null;
        this.progressMonitor = null;
        this.ignoreSubmoduleMode = null;
    }

    public StatusCommand setIgnoreSubmodules(SubmoduleWalk.IgnoreSubmoduleMode ignoreSubmoduleMode) {
        this.ignoreSubmoduleMode = ignoreSubmoduleMode;
        return this;
    }

    public StatusCommand addPath(String str) {
        if (this.paths == null) {
            this.paths = new ArrayList();
        }
        this.paths.add(str);
        return this;
    }

    public List<String> getPaths() {
        return this.paths;
    }

    @Override // org.eclipse.jgit.api.GitCommand, java.util.concurrent.Callable
    public Status call() throws NoWorkTreeException, GitAPIException {
        if (this.workingTreeIt == null) {
            this.workingTreeIt = new FileTreeIterator(this.repo);
        }
        try {
            IndexDiff indexDiff = new IndexDiff(this.repo, "HEAD", this.workingTreeIt);
            SubmoduleWalk.IgnoreSubmoduleMode ignoreSubmoduleMode = this.ignoreSubmoduleMode;
            if (ignoreSubmoduleMode != null) {
                indexDiff.setIgnoreSubmoduleMode(ignoreSubmoduleMode);
            }
            List<String> list = this.paths;
            if (list != null) {
                indexDiff.setFilter(PathFilterGroup.createFromStrings(list));
            }
            ProgressMonitor progressMonitor = this.progressMonitor;
            if (progressMonitor == null) {
                indexDiff.diff();
            } else {
                indexDiff.diff(progressMonitor, 0, 0, "");
            }
            return new Status(indexDiff);
        } catch (IOException e) {
            throw new JGitInternalException(e.getMessage(), e);
        }
    }

    public StatusCommand setWorkingTreeIt(WorkingTreeIterator workingTreeIterator) {
        this.workingTreeIt = workingTreeIterator;
        return this;
    }

    public StatusCommand setProgressMonitor(ProgressMonitor progressMonitor) {
        this.progressMonitor = progressMonitor;
        return this;
    }
}
