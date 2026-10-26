package org.eclipse.jgit.transport;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.http.message.TokenParser;
import org.eclipse.jgit.errors.NotSupportedException;
import org.eclipse.jgit.errors.TransportException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.lib.Repository;

/* INFO: loaded from: classes5.dex */
class TransportGitAnon extends TcpTransport implements PackTransport {
    static final int GIT_PORT = 9418;
    static final TransportProtocol PROTO_GIT = new AnonymousClass1();

    @Override // org.eclipse.jgit.transport.Transport, java.lang.AutoCloseable
    public void close() {
    }

    /* INFO: renamed from: org.eclipse.jgit.transport.TransportGitAnon$1, reason: invalid class name */
    class AnonymousClass1 extends TransportProtocol {
        @Override // org.eclipse.jgit.transport.TransportProtocol
        public int getDefaultPort() {
            return 9418;
        }

        AnonymousClass1() {
        }

        @Override // org.eclipse.jgit.transport.TransportProtocol
        public String getName() {
            return JGitText.get().transportProtoGitAnon;
        }

        @Override // org.eclipse.jgit.transport.TransportProtocol
        public Set<String> getSchemes() {
            return Collections.singleton("git");
        }

        @Override // org.eclipse.jgit.transport.TransportProtocol
        public Set<TransportProtocol.URIishField> getRequiredFields() {
            return Collections.unmodifiableSet(EnumSet.of(TransportProtocol.URIishField.HOST, TransportProtocol.URIishField.PATH));
        }

        @Override // org.eclipse.jgit.transport.TransportProtocol
        public Set<TransportProtocol.URIishField> getOptionalFields() {
            return Collections.unmodifiableSet(EnumSet.of(TransportProtocol.URIishField.PORT));
        }

        @Override // org.eclipse.jgit.transport.TransportProtocol
        public Transport open(URIish uRIish, Repository repository, String str) throws NotSupportedException {
            return new TransportGitAnon(repository, uRIish);
        }

        @Override // org.eclipse.jgit.transport.TransportProtocol
        public Transport open(URIish uRIish) throws NotSupportedException, TransportException {
            return new TransportGitAnon(uRIish);
        }
    }

    TransportGitAnon(Repository repository, URIish uRIish) {
        super(repository, uRIish);
    }

    TransportGitAnon(URIish uRIish) {
        super(uRIish);
    }

    @Override // org.eclipse.jgit.transport.Transport
    public FetchConnection openFetch() throws TransportException {
        return new TcpFetchConnection(this);
    }

    @Override // org.eclipse.jgit.transport.Transport
    public FetchConnection openFetch(Collection<RefSpec> collection, String... strArr) throws NotSupportedException, TransportException {
        return new TcpFetchConnection(collection, strArr);
    }

    @Override // org.eclipse.jgit.transport.Transport
    public PushConnection openPush() throws TransportException {
        return new TcpPushConnection();
    }

    Socket openConnection() throws TransportException {
        int timeout = getTimeout() > 0 ? getTimeout() * 1000 : 0;
        int port = this.uri.getPort() > 0 ? this.uri.getPort() : 9418;
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress(InetAddress.getByName(this.uri.getHost()), port), timeout);
            return socket;
        } catch (IOException e) {
            try {
                socket.close();
            } catch (IOException unused) {
            }
            if (e instanceof UnknownHostException) {
                throw new TransportException(this.uri, JGitText.get().unknownHost);
            }
            if (e instanceof ConnectException) {
                throw new TransportException(this.uri, e.getMessage());
            }
            throw new TransportException(this.uri, e.getMessage(), e);
        }
    }

    void service(String str, PacketLineOut packetLineOut, TransferConfig.ProtocolVersion protocolVersion) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(TokenParser.SP);
        sb.append(this.uri.getPath());
        sb.append("\u0000host=");
        sb.append(this.uri.getHost());
        if (this.uri.getPort() > 0 && this.uri.getPort() != 9418) {
            sb.append(CollectionUtils.COLON);
            sb.append(this.uri.getPort());
        }
        sb.append((char) 0);
        if (TransferConfig.ProtocolVersion.V2.equals(protocolVersion)) {
            sb.append("\u0000version=2\u0000");
        }
        packetLineOut.writeString(sb.toString());
        packetLineOut.flush();
    }

    class TcpFetchConnection extends BasePackFetchConnection {
        private Socket sock;

        TcpFetchConnection(TransportGitAnon transportGitAnon) throws TransportException {
            this(Collections.emptyList(), new String[0]);
        }

        TcpFetchConnection(Collection<RefSpec> collection, String... strArr) throws TransportException {
            super(TransportGitAnon.this);
            Socket socketOpenConnection = TransportGitAnon.this.openConnection();
            this.sock = socketOpenConnection;
            try {
                init(new BufferedInputStream(socketOpenConnection.getInputStream()), new BufferedOutputStream(this.sock.getOutputStream()));
                TransferConfig.ProtocolVersion protocolVersion = TransportGitAnon.this.protocol;
                TransportGitAnon.this.service(RemoteConfig.DEFAULT_UPLOAD_PACK, this.pckOut, protocolVersion == null ? TransferConfig.ProtocolVersion.V2 : protocolVersion);
                if (readAdvertisedRefs()) {
                    return;
                }
                lsRefs(collection, strArr);
            } catch (IOException e) {
                close();
                throw new TransportException(this.uri, JGitText.get().remoteHungUpUnexpectedly, e);
            }
        }

        @Override // org.eclipse.jgit.transport.BasePackFetchConnection, org.eclipse.jgit.transport.BasePackConnection, org.eclipse.jgit.transport.BaseConnection, org.eclipse.jgit.transport.Connection, java.lang.AutoCloseable
        public void close() {
            super.close();
            Socket socket = this.sock;
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException unused) {
                } finally {
                    this.sock = null;
                }
            }
        }
    }

    class TcpPushConnection extends BasePackPushConnection {
        private Socket sock;

        TcpPushConnection() throws TransportException {
            super(TransportGitAnon.this);
            Socket socketOpenConnection = TransportGitAnon.this.openConnection();
            this.sock = socketOpenConnection;
            try {
                init(new BufferedInputStream(socketOpenConnection.getInputStream()), new BufferedOutputStream(this.sock.getOutputStream()));
                TransportGitAnon.this.service(RemoteConfig.DEFAULT_RECEIVE_PACK, this.pckOut, null);
                readAdvertisedRefs();
            } catch (IOException e) {
                close();
                throw new TransportException(this.uri, JGitText.get().remoteHungUpUnexpectedly, e);
            }
        }

        @Override // org.eclipse.jgit.transport.BasePackPushConnection, org.eclipse.jgit.transport.BasePackConnection, org.eclipse.jgit.transport.BaseConnection, org.eclipse.jgit.transport.Connection, java.lang.AutoCloseable
        public void close() {
            super.close();
            Socket socket = this.sock;
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException unused) {
                } finally {
                    this.sock = null;
                }
            }
        }
    }
}
