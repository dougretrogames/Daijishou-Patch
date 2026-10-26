package org.eclipse.jgit.transport;

import org.eclipse.jgit.errors.TransportException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.util.FS;

/* INFO: loaded from: classes5.dex */
public abstract class SshTransport extends TcpTransport {
    private SshSessionFactory sch;
    private RemoteSession sock;

    protected SshTransport(Repository repository, URIish uRIish) {
        super(repository, uRIish);
        this.sch = SshSessionFactory.getInstance();
    }

    protected SshTransport(URIish uRIish) {
        super(uRIish);
        this.sch = SshSessionFactory.getInstance();
    }

    public void setSshSessionFactory(SshSessionFactory sshSessionFactory) {
        if (sshSessionFactory == null) {
            throw new NullPointerException(JGitText.get().theFactoryMustNotBeNull);
        }
        if (this.sock != null) {
            throw new IllegalStateException(JGitText.get().anSSHSessionHasBeenAlreadyCreated);
        }
        this.sch = sshSessionFactory;
    }

    public SshSessionFactory getSshSessionFactory() {
        return this.sch;
    }

    protected RemoteSession getSession() throws TransportException {
        RemoteSession remoteSession = this.sock;
        if (remoteSession != null) {
            return remoteSession;
        }
        RemoteSession session = this.sch.getSession(this.uri, getCredentialsProvider(), this.local == null ? FS.detect() : this.local.getFS(), getTimeout() > 0 ? getTimeout() * 1000 : 0);
        this.sock = session;
        return session;
    }

    @Override // org.eclipse.jgit.transport.Transport, java.lang.AutoCloseable
    public void close() {
        RemoteSession remoteSession = this.sock;
        if (remoteSession != null) {
            try {
                this.sch.releaseSession(remoteSession);
            } finally {
                this.sock = null;
            }
        }
    }
}
