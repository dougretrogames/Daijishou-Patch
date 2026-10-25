package org.eclipse.jgit.api.errors;

/* JADX INFO: loaded from: classes5.dex */
public class TooLargePackException extends TransportException {
    private static final long serialVersionUID = 1;

    public TooLargePackException(String str) {
        super(str);
    }

    public TooLargePackException(String str, Throwable th) {
        super(str, th);
    }
}
