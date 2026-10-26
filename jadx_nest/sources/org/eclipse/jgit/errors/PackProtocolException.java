package org.eclipse.jgit.errors;

import org.eclipse.jgit.transport.URIish;

/* INFO: loaded from: classes5.dex */
public class PackProtocolException extends TransportException {
    private static final long serialVersionUID = 1;

    public PackProtocolException(URIish uRIish, String str) {
        super(String.valueOf(uRIish) + ": " + str);
    }

    public PackProtocolException(URIish uRIish, String str, Throwable th) {
        this(String.valueOf(uRIish) + ": " + str, th);
    }

    public PackProtocolException(String str) {
        super(str);
    }

    public PackProtocolException(String str, Throwable th) {
        super(str);
        initCause(th);
    }
}
