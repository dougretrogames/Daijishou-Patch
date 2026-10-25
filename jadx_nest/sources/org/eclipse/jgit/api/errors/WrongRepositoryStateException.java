package org.eclipse.jgit.api.errors;

/* JADX INFO: loaded from: classes5.dex */
public class WrongRepositoryStateException extends GitAPIException {
    private static final long serialVersionUID = 1;

    public WrongRepositoryStateException(String str, Throwable th) {
        super(str, th);
    }

    public WrongRepositoryStateException(String str) {
        super(str);
    }
}
