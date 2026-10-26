package org.eclipse.jgit.api.errors;

import org.eclipse.jgit.internal.JGitText;

/* INFO: loaded from: classes5.dex */
public class UnmergedPathsException extends GitAPIException {
    private static final long serialVersionUID = 1;

    public UnmergedPathsException() {
        this(null);
    }

    public UnmergedPathsException(Throwable th) {
        super(JGitText.get().unmergedPaths, th);
    }

    public UnmergedPathsException(String str, Throwable th) {
        super(str, th);
    }
}
