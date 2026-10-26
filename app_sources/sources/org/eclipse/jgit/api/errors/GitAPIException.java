package org.eclipse.jgit.api.errors;

/* INFO: loaded from: classes5.dex */
public abstract class GitAPIException extends Exception {
    private static final long serialVersionUID = 1;

    protected GitAPIException(String str, Throwable th) {
        super(str, th);
    }

    protected GitAPIException(String str) {
        super(str);
    }
}
