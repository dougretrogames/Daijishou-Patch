package org.eclipse.jgit.errors;

import org.eclipse.jgit.transport.URIish;

/* JADX INFO: loaded from: classes5.dex */
public class RemoteRepositoryException extends TransportException {
    private static final long serialVersionUID = 1;

    public RemoteRepositoryException(URIish uRIish, String str) {
        super(uRIish, str);
    }
}
