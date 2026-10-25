package org.eclipse.jgit.hooks;

import java.io.IOException;
import java.io.PrintStream;
import org.eclipse.jgit.api.errors.AbortedByHookException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.util.ProcessResult;

/* JADX INFO: loaded from: classes5.dex */
public class PostCommitHook extends GitHook<Void> {
    public static final String NAME = "post-commit";

    @Override // org.eclipse.jgit.hooks.GitHook
    protected void handleError(String str, ProcessResult processResult) throws AbortedByHookException {
    }

    protected PostCommitHook(Repository repository, PrintStream printStream) {
        super(repository, printStream);
    }

    protected PostCommitHook(Repository repository, PrintStream printStream, PrintStream printStream2) {
        super(repository, printStream, printStream2);
    }

    @Override // org.eclipse.jgit.hooks.GitHook, java.util.concurrent.Callable
    public Void call() throws AbortedByHookException, IOException {
        doRun();
        return null;
    }

    @Override // org.eclipse.jgit.hooks.GitHook
    public String getHookName() {
        return NAME;
    }
}
