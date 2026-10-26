package org.eclipse.jgit.transport;

import java.io.IOException;
import java.io.InputStream;
import org.eclipse.jgit.errors.NotSupportedException;
import org.eclipse.jgit.errors.TransportException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.Repository;

/* INFO: loaded from: classes5.dex */
public class TransportBundleStream extends Transport implements TransportBundle {
    private InputStream src;

    public TransportBundleStream(Repository repository, URIish uRIish, InputStream inputStream) {
        super(repository, uRIish);
        this.src = inputStream;
    }

    @Override // org.eclipse.jgit.transport.Transport
    public FetchConnection openFetch() throws TransportException {
        if (this.src == null) {
            throw new TransportException(this.uri, JGitText.get().onlyOneFetchSupported);
        }
        try {
            return new BundleFetchConnection(this, this.src);
        } finally {
            this.src = null;
        }
    }

    @Override // org.eclipse.jgit.transport.Transport
    public PushConnection openPush() throws NotSupportedException {
        throw new NotSupportedException(JGitText.get().pushIsNotSupportedForBundleTransport);
    }

    @Override // org.eclipse.jgit.transport.Transport, java.lang.AutoCloseable
    public void close() {
        InputStream inputStream = this.src;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            } finally {
                this.src = null;
            }
        }
    }
}
