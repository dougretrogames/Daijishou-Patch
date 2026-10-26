package org.eclipse.jgit.api.errors;

/* INFO: loaded from: classes5.dex */
public class TransportException extends GitAPIException {
    private static final long serialVersionUID = 1;

    public TransportException(String str) {
        super(str);
    }

    public TransportException(String str, Throwable th) {
        super(str, th);
    }
}
