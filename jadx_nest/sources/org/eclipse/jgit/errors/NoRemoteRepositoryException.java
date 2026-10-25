package org.eclipse.jgit.errors;

import org.eclipse.jgit.transport.URIish;

/* JADX INFO: loaded from: classes5.dex */
public class NoRemoteRepositoryException extends TransportException {
    private static final long serialVersionUID = 1;

    public NoRemoteRepositoryException(URIish uRIish, String str) {
        super(uRIish, str);
    }

    public NoRemoteRepositoryException(URIish uRIish, String str, Throwable th) {
        super(uRIish, str, th);
    }
}
