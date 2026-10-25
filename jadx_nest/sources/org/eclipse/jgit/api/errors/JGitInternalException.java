package org.eclipse.jgit.api.errors;

/* JADX INFO: loaded from: classes5.dex */
public class JGitInternalException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public JGitInternalException(String str, Throwable th) {
        super(str, th);
    }

    public JGitInternalException(String str) {
        super(str);
    }
}
