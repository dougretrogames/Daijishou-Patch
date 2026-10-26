package org.eclipse.jgit.errors;

import java.io.IOException;
import org.eclipse.jgit.transport.URIish;

/* INFO: loaded from: classes5.dex */
public class TransportException extends IOException {
    private static final long serialVersionUID = 1;

    public TransportException(URIish uRIish, String str) {
        super(String.valueOf(uRIish.setPass(null)) + ": " + str);
    }

    public TransportException(URIish uRIish, String str, Throwable th) {
        this(String.valueOf(uRIish.setPass(null)) + ": " + str, th);
    }

    public TransportException(String str) {
        super(str);
    }

    public TransportException(String str, Throwable th) {
        super(str);
        initCause(th);
    }
}
