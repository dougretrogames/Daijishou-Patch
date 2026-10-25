package org.eclipse.jgit.transport.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import org.eclipse.jgit.internal.transport.http.DelegatingSSLSocketFactory;
import org.eclipse.jgit.util.HttpSupport;

/* JADX INFO: loaded from: classes5.dex */
public class JDKHttpConnection implements HttpConnection {
    HttpURLConnection wrappedUrlConnection;

    JDKHttpConnection(HttpURLConnection httpURLConnection) {
        this.wrappedUrlConnection = httpURLConnection;
    }

    protected JDKHttpConnection(URL url) throws IOException {
        this.wrappedUrlConnection = (HttpURLConnection) url.openConnection();
    }

    protected JDKHttpConnection(URL url, Proxy proxy) throws IOException {
        this.wrappedUrlConnection = (HttpURLConnection) url.openConnection(proxy);
    }

    @Override // org.eclipse.jgit.transport.http.HttpConnection
    public int getResponseCode() throws IOException {
        return this.wrappedUrlConnection.getResponseCode();
    }

    @Override // org.eclipse.jgit.transport.http.HttpConnection
    public URL getURL() {
        return this.wrappedUrlConnection.getURL();
    }

    @Override // org.eclipse.jgit.transport.http.HttpConnection
    public String getResponseMessage() throws IOException {
        return this.wrappedUrlConnection.getResponseMessage();
    }

    @Override // org.eclipse.jgit.transport.http.HttpConnection
    public Map<String, List<String>> getHeaderFields() {
        return this.wrappedUrlConnection.getHeaderFields();
    }

    @Override // org.eclipse.jgit.transport.http.HttpConnection
    public void setRequestProperty(String str, String str2) {
        this.wrappedUrlConnection.setRequestProperty(str, str2);
    }

    @Override // org.eclipse.jgit.transport.http.HttpConnection
    public void setRequestMethod(String str) throws ProtocolException {
        this.wrappedUrlConnection.setRequestMethod(str);
    }

    @Override // org.eclipse.jgit.transport.http.HttpConnection
    public void setUseCaches(boolean z) {
        this.wrappedUrlConnection.setUseCaches(z);
    }

    @Override // org.eclipse.jgit.transport.http.HttpConnection
    public void setConnectTimeout(int i) {
        this.wrappedUrlConnection.setConnectTimeout(i);
    }

    @Override // org.eclipse.jgit.transport.http.HttpConnection
    public void setReadTimeout(int i) {
        this.wrappedUrlConnection.setReadTimeout(i);
    }

    @Override // org.eclipse.jgit.transport.http.HttpConnection
    public String getContentType() {
        return this.wrappedUrlConnection.getContentType();
    }

    @Override // org.eclipse.jgit.transport.http.HttpConnection
    public InputStream getInputStream() throws IOException {
        return this.wrappedUrlConnection.getInputStream();
    }

    @Override // org.eclipse.jgit.transport.http.HttpConnection
    public String getHeaderField(String str) {
        return this.wrappedUrlConnection.getHeaderField(str);
    }

    @Override // org.eclipse.jgit.transport.http.HttpConnection
    public List<String> getHeaderFields(String str) {
        return mapValuesToListIgnoreCase(str, this.wrappedUrlConnection.getHeaderFields());
    }

    private static List<String> mapValuesToListIgnoreCase(String str, Map<String, List<String>> map) {
        ArrayList arrayList = new ArrayList();
        map.entrySet().stream().filter(new JDKHttpConnection$$ExternalSyntheticLambda0(str)).filter(new JDKHttpConnection$$ExternalSyntheticLambda1()).forEach(new JDKHttpConnection$$ExternalSyntheticLambda2(arrayList));
        return arrayList;
    }

    static /* synthetic */ boolean lambda$1(Map.Entry entry) {
        return entry.getValue() != null;
    }

    @Override // org.eclipse.jgit.transport.http.HttpConnection
    public int getContentLength() {
        return this.wrappedUrlConnection.getContentLength();
    }

    @Override // org.eclipse.jgit.transport.http.HttpConnection
    public void setInstanceFollowRedirects(boolean z) {
        this.wrappedUrlConnection.setInstanceFollowRedirects(z);
    }

    @Override // org.eclipse.jgit.transport.http.HttpConnection
    public void setDoOutput(boolean z) {
        this.wrappedUrlConnection.setDoOutput(z);
    }

    @Override // org.eclipse.jgit.transport.http.HttpConnection
    public void setFixedLengthStreamingMode(int i) {
        this.wrappedUrlConnection.setFixedLengthStreamingMode(i);
    }

    @Override // org.eclipse.jgit.transport.http.HttpConnection
    public OutputStream getOutputStream() throws IOException {
        return this.wrappedUrlConnection.getOutputStream();
    }

    @Override // org.eclipse.jgit.transport.http.HttpConnection
    public void setChunkedStreamingMode(int i) {
        this.wrappedUrlConnection.setChunkedStreamingMode(i);
    }

    @Override // org.eclipse.jgit.transport.http.HttpConnection
    public String getRequestMethod() {
        return this.wrappedUrlConnection.getRequestMethod();
    }

    @Override // org.eclipse.jgit.transport.http.HttpConnection
    public boolean usingProxy() {
        return this.wrappedUrlConnection.usingProxy();
    }

    @Override // org.eclipse.jgit.transport.http.HttpConnection
    public void connect() throws IOException {
        this.wrappedUrlConnection.connect();
    }

    @Override // org.eclipse.jgit.transport.http.HttpConnection
    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        ((HttpsURLConnection) this.wrappedUrlConnection).setHostnameVerifier(hostnameVerifier);
    }

    @Override // org.eclipse.jgit.transport.http.HttpConnection
    public void configure(KeyManager[] keyManagerArr, TrustManager[] trustManagerArr, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        sSLContext.init(keyManagerArr, trustManagerArr, secureRandom);
        ((HttpsURLConnection) this.wrappedUrlConnection).setSSLSocketFactory(new AnonymousClass1(sSLContext.getSocketFactory()));
    }

    /* JADX INFO: renamed from: org.eclipse.jgit.transport.http.JDKHttpConnection$1, reason: invalid class name */
    class AnonymousClass1 extends DelegatingSSLSocketFactory {
        AnonymousClass1(SSLSocketFactory sSLSocketFactory) {
            super(sSLSocketFactory);
        }

        @Override // org.eclipse.jgit.internal.transport.http.DelegatingSSLSocketFactory
        protected void configure(SSLSocket sSLSocket) throws IOException {
            HttpSupport.configureTLS(sSLSocket);
        }
    }
}
