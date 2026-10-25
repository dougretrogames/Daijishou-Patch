package org.eclipse.jgit.internal.transport.http;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes5.dex */
public abstract class DelegatingSSLSocketFactory extends SSLSocketFactory {
    private final SSLSocketFactory delegate;

    protected abstract void configure(SSLSocket sSLSocket) throws IOException;

    public DelegatingSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.delegate = sSLSocketFactory;
    }

    @Override // javax.net.SocketFactory
    public SSLSocket createSocket() throws IOException {
        return prepare(this.delegate.createSocket());
    }

    @Override // javax.net.SocketFactory
    public SSLSocket createSocket(String str, int i) throws IOException {
        return prepare(this.delegate.createSocket(str, i));
    }

    @Override // javax.net.SocketFactory
    public SSLSocket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        return prepare(this.delegate.createSocket(str, i, inetAddress, i2));
    }

    @Override // javax.net.SocketFactory
    public SSLSocket createSocket(InetAddress inetAddress, int i) throws IOException {
        return prepare(this.delegate.createSocket(inetAddress, i));
    }

    @Override // javax.net.SocketFactory
    public SSLSocket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return prepare(this.delegate.createSocket(inetAddress, i, inetAddress2, i2));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public SSLSocket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        return prepare(this.delegate.createSocket(socket, str, i, z));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.delegate.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.delegate.getSupportedCipherSuites();
    }

    private SSLSocket prepare(Socket socket) throws IOException {
        SSLSocket sSLSocket = (SSLSocket) socket;
        configure(sSLSocket);
        return sSLSocket;
    }
}
