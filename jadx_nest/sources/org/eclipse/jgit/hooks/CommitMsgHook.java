package org.eclipse.jgit.hooks;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import org.eclipse.jgit.api.errors.AbortedByHookException;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.Repository;

/* INFO: loaded from: classes5.dex */
public class CommitMsgHook extends GitHook<String> {
    public static final String NAME = "commit-msg";
    private String commitMessage;

    protected CommitMsgHook(Repository repository, PrintStream printStream) {
        super(repository, printStream);
    }

    protected CommitMsgHook(Repository repository, PrintStream printStream, PrintStream printStream2) {
        super(repository, printStream, printStream2);
    }

    @Override // org.eclipse.jgit.hooks.GitHook, java.util.concurrent.Callable
    public String call() throws AbortedByHookException, IOException {
        if (this.commitMessage == null) {
            throw new IllegalStateException();
        }
        if (canRun()) {
            getRepository().writeCommitEditMsg(this.commitMessage);
            doRun();
            this.commitMessage = getRepository().readCommitEditMsg();
        }
        return this.commitMessage;
    }

    private boolean canRun() {
        return (getCommitEditMessageFilePath() == null || this.commitMessage == null) ? false : true;
    }

    @Override // org.eclipse.jgit.hooks.GitHook
    public String getHookName() {
        return NAME;
    }

    @Override // org.eclipse.jgit.hooks.GitHook
    protected String[] getParameters() {
        return new String[]{getCommitEditMessageFilePath()};
    }

    private String getCommitEditMessageFilePath() {
        File directory = getRepository().getDirectory();
        if (directory == null) {
            return null;
        }
        return Repository.stripWorkDir(getRepository().getWorkTree(), new File(directory, Constants.COMMIT_EDITMSG));
    }

    public CommitMsgHook setCommitMessage(String str) {
        this.commitMessage = str;
        return this;
    }
}
