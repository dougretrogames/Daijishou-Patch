package org.eclipse.jgit.api.errors;

/* JADX INFO: loaded from: classes5.dex */
public class NoMessageException extends GitAPIException {
    private static final long serialVersionUID = 1;

    public NoMessageException(String str, Throwable th) {
        super(str, th);
    }

    public NoMessageException(String str) {
        super(str);
    }
}
