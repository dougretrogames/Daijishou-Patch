package org.eclipse.jgit.errors;

import org.eclipse.jgit.internal.JGitText;

/* JADX INFO: loaded from: classes5.dex */
public class RevWalkException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public RevWalkException(Throwable th) {
        super(JGitText.get().walkFailure, th);
    }
}
