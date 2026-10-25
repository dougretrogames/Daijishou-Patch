package org.eclipse.jgit.hooks;

import java.io.PrintStream;
import java.text.MessageFormat;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.util.LfsFactory;

/* JADX INFO: loaded from: classes5.dex */
public class Hooks {
    public static PreCommitHook preCommit(Repository repository, PrintStream printStream) {
        return new PreCommitHook(repository, printStream);
    }

    public static PreCommitHook preCommit(Repository repository, PrintStream printStream, PrintStream printStream2) {
        return new PreCommitHook(repository, printStream, printStream2);
    }

    public static PostCommitHook postCommit(Repository repository, PrintStream printStream) {
        return new PostCommitHook(repository, printStream);
    }

    public static PostCommitHook postCommit(Repository repository, PrintStream printStream, PrintStream printStream2) {
        return new PostCommitHook(repository, printStream, printStream2);
    }

    public static CommitMsgHook commitMsg(Repository repository, PrintStream printStream) {
        return new CommitMsgHook(repository, printStream);
    }

    public static CommitMsgHook commitMsg(Repository repository, PrintStream printStream, PrintStream printStream2) {
        return new CommitMsgHook(repository, printStream, printStream2);
    }

    public static PrePushHook prePush(Repository repository, PrintStream printStream) {
        PrePushHook prePushHook;
        if (LfsFactory.getInstance().isAvailable() && (prePushHook = LfsFactory.getInstance().getPrePushHook(repository, printStream)) != null) {
            if (prePushHook.isNativeHookPresent()) {
                if (printStream == null) {
                    printStream = System.out;
                }
                printStream.println(MessageFormat.format(JGitText.get().lfsHookConflict, repository));
            }
            return prePushHook;
        }
        return new PrePushHook(repository, printStream);
    }

    public static PrePushHook prePush(Repository repository, PrintStream printStream, PrintStream printStream2) {
        PrePushHook prePushHook;
        if (LfsFactory.getInstance().isAvailable() && (prePushHook = LfsFactory.getInstance().getPrePushHook(repository, printStream, printStream2)) != null) {
            if (prePushHook.isNativeHookPresent()) {
                if (printStream == null) {
                    printStream = System.out;
                }
                printStream.println(MessageFormat.format(JGitText.get().lfsHookConflict, repository));
            }
            return prePushHook;
        }
        return new PrePushHook(repository, printStream, printStream2);
    }
}
