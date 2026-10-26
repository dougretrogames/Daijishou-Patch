package org.eclipse.jgit.api.errors;

/* INFO: loaded from: classes5.dex */
public class EmptyCommitException extends GitAPIException {
    private static final long serialVersionUID = 1;

    public EmptyCommitException(String str, Throwable th) {
        super(str, th);
    }

    public EmptyCommitException(String str) {
        super(str);
    }
}
