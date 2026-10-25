package org.eclipse.jgit.api;

import java.text.MessageFormat;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.Repository;

/* JADX INFO: loaded from: classes5.dex */
public abstract class GitCommand<T> implements Callable<T> {
    private AtomicBoolean callable = new AtomicBoolean(true);
    protected final Repository repo;

    @Override // java.util.concurrent.Callable
    public abstract T call() throws GitAPIException;

    protected GitCommand(Repository repository) {
        this.repo = repository;
    }

    public Repository getRepository() {
        return this.repo;
    }

    protected void setCallable(boolean z) {
        this.callable.set(z);
    }

    protected void checkCallable() {
        if (!this.callable.get()) {
            throw new IllegalStateException(MessageFormat.format(JGitText.get().commandWasCalledInTheWrongState, getClass().getName()));
        }
    }
}
