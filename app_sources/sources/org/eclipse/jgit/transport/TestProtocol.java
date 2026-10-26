package org.eclipse.jgit.transport;

import java.net.URISyntaxException;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Set;
import org.eclipse.jgit.errors.NotSupportedException;
import org.eclipse.jgit.errors.TransportException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.resolver.ReceivePackFactory;
import org.eclipse.jgit.transport.resolver.UploadPackFactory;

/* INFO: loaded from: classes5.dex */
public class TestProtocol<C> extends TransportProtocol {
    private static final String SCHEME = "test";
    private static BasePackFetchConnection.FetchConfig fetchConfig;
    private final HashMap<URIish, TestProtocol<C>.Handle> handles = new HashMap<>();
    final ReceivePackFactory<C> receivePackFactory;
    final UploadPackFactory<C> uploadPackFactory;

    private class Handle {
        final Repository remote;
        final C req;

        Handle(C c, Repository repository) {
            this.req = c;
            this.remote = repository;
        }
    }

    public TestProtocol(UploadPackFactory<C> uploadPackFactory, ReceivePackFactory<C> receivePackFactory) {
        this.uploadPackFactory = uploadPackFactory;
        this.receivePackFactory = receivePackFactory;
    }

    @Override // org.eclipse.jgit.transport.TransportProtocol
    public String getName() {
        return JGitText.get().transportProtoTest;
    }

    @Override // org.eclipse.jgit.transport.TransportProtocol
    public Set<String> getSchemes() {
        return Collections.singleton(SCHEME);
    }

    @Override // org.eclipse.jgit.transport.TransportProtocol
    public Transport open(URIish uRIish, Repository repository, String str) throws NotSupportedException, TransportException {
        TestProtocol<C>.Handle handle = this.handles.get(uRIish);
        if (handle == null) {
            throw new NotSupportedException(MessageFormat.format(JGitText.get().URINotSupported, uRIish));
        }
        return new TransportInternal(repository, uRIish, handle);
    }

    @Override // org.eclipse.jgit.transport.TransportProtocol
    public Set<TransportProtocol.URIishField> getRequiredFields() {
        return EnumSet.of(TransportProtocol.URIishField.HOST, TransportProtocol.URIishField.PATH);
    }

    @Override // org.eclipse.jgit.transport.TransportProtocol
    public Set<TransportProtocol.URIishField> getOptionalFields() {
        return Collections.emptySet();
    }

    static void setFetchConfig(BasePackFetchConnection.FetchConfig fetchConfig2) {
        fetchConfig = fetchConfig2;
    }

    public synchronized URIish register(C c, Repository repository) {
        URIish uRIish;
        try {
            uRIish = new URIish("test://test/conn" + this.handles.size());
            this.handles.put(uRIish, new Handle(c, repository));
        } catch (URISyntaxException e) {
            throw new IllegalStateException(e);
        }
        return uRIish;
    }

    private class TransportInternal extends Transport implements PackTransport {
        private final TestProtocol<C>.Handle handle;

        @Override // org.eclipse.jgit.transport.Transport, java.lang.AutoCloseable
        public void close() {
        }

        TransportInternal(Repository repository, URIish uRIish, TestProtocol<C>.Handle handle) {
            super(repository, uRIish);
            this.handle = handle;
        }

        /* INFO: renamed from: org.eclipse.jgit.transport.TestProtocol$TransportInternal$1, reason: invalid class name */
        class AnonymousClass1 extends InternalFetchConnection<C> {
            AnonymousClass1(PackTransport packTransport, UploadPackFactory uploadPackFactory, Object obj, Repository repository) throws TransportException {
                super(packTransport, uploadPackFactory, obj, repository);
            }

            @Override // org.eclipse.jgit.transport.BasePackFetchConnection
            BasePackFetchConnection.FetchConfig getFetchConfig() {
                return TestProtocol.fetchConfig != null ? TestProtocol.fetchConfig : super.getFetchConfig();
            }
        }

        @Override // org.eclipse.jgit.transport.Transport
        public FetchConnection openFetch() throws NotSupportedException, TransportException {
            this.handle.remote.incrementOpen();
            return new AnonymousClass1(this, TestProtocol.this.uploadPackFactory, this.handle.req, this.handle.remote);
        }

        @Override // org.eclipse.jgit.transport.Transport
        public PushConnection openPush() throws NotSupportedException, TransportException {
            this.handle.remote.incrementOpen();
            return new InternalPushConnection(this, TestProtocol.this.receivePackFactory, this.handle.req, this.handle.remote);
        }
    }
}
