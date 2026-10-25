package org.eclipse.jgit.errors;

import org.eclipse.jgit.internal.JGitText;

/* JADX INFO: loaded from: classes5.dex */
public class NoWorkTreeException extends IllegalStateException {
    private static final long serialVersionUID = 1;

    public NoWorkTreeException() {
        super(JGitText.get().bareRepositoryNoWorkdirAndIndex);
    }
}
