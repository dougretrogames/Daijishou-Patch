package org.eclipse.jgit.api.errors;

/* INFO: loaded from: classes5.dex */
public class InvalidRefNameException extends GitAPIException {
    private static final long serialVersionUID = 1;

    public InvalidRefNameException(String str) {
        super(str);
    }

    public InvalidRefNameException(String str, Throwable th) {
        super(str, th);
    }
}
