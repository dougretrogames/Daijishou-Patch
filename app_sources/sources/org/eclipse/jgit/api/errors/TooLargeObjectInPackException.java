package org.eclipse.jgit.api.errors;

/* INFO: loaded from: classes5.dex */
public class TooLargeObjectInPackException extends TransportException {
    private static final long serialVersionUID = 1;

    public TooLargeObjectInPackException(String str) {
        super(str);
    }

    public TooLargeObjectInPackException(String str, Throwable th) {
        super(str, th);
    }
}
