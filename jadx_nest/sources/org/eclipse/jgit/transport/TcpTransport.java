package org.eclipse.jgit.transport;

import org.eclipse.jgit.lib.Repository;

/* JADX INFO: loaded from: classes5.dex */
public abstract class TcpTransport extends Transport {
    protected TcpTransport(Repository repository, URIish uRIish) {
        super(repository, uRIish);
    }

    protected TcpTransport(URIish uRIish) {
        super(uRIish);
    }
}
