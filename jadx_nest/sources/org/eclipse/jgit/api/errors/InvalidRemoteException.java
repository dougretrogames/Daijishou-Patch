package org.eclipse.jgit.api.errors;

/* INFO: loaded from: classes5.dex */
public class InvalidRemoteException extends GitAPIException {
    private static final long serialVersionUID = 1;

    public InvalidRemoteException(String str) {
        super(str);
    }

    public InvalidRemoteException(String str, Throwable th) {
        super(str, th);
    }
}
