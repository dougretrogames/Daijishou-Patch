package org.eclipse.jgit.api;

import java.io.IOException;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.NullProgressMonitor;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.lib.Repository;

/* INFO: loaded from: classes5.dex */
public class PackRefsCommand extends GitCommand<String> {
    private boolean all;
    private ProgressMonitor monitor;

    public PackRefsCommand(Repository repository) {
        super(repository);
        this.monitor = NullProgressMonitor.INSTANCE;
    }

    public PackRefsCommand setProgressMonitor(ProgressMonitor progressMonitor) {
        this.monitor = progressMonitor;
        return this;
    }

    public PackRefsCommand setAll(boolean z) {
        this.all = z;
        return this;
    }

    public boolean isAll() {
        return this.all;
    }

    @Override // org.eclipse.jgit.api.GitCommand, java.util.concurrent.Callable
    public String call() throws GitAPIException {
        checkCallable();
        try {
            this.repo.getRefDatabase().packRefs(this.monitor, this);
            return JGitText.get().packRefsSuccessful;
        } catch (IOException e) {
            throw new JGitInternalException(JGitText.get().packRefsFailed, e);
        }
    }
}
