package org.eclipse.jgit.api.errors;

/* JADX INFO: loaded from: classes5.dex */
public class NoHeadException extends GitAPIException {
    private static final long serialVersionUID = 1;

    public NoHeadException(String str, Throwable th) {
        super(str, th);
    }

    public NoHeadException(String str) {
        super(str);
    }
}
