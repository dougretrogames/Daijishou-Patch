package org.eclipse.jgit.transport.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.TrustManager;

/* INFO: loaded from: classes5.dex */
public interface HttpConnection {
    public static final int HTTP_11_MOVED_PERM = 308;
    public static final int HTTP_11_MOVED_TEMP = 307;
    public static final int HTTP_FORBIDDEN = 403;
    public static final int HTTP_MOVED_PERM = 301;
    public static final int HTTP_MOVED_TEMP = 302;
    public static final int HTTP_NOT_AUTHORITATIVE = 203;
    public static final int HTTP_NOT_FOUND = 404;
    public static final int HTTP_OK = 200;
    public static final int HTTP_SEE_OTHER = 303;
    public static final int HTTP_UNAUTHORIZED = 401;

    void configure(KeyManager[] keyManagerArr, TrustManager[] trustManagerArr, SecureRandom secureRandom) throws NoSuchAlgorithmException, KeyManagementException;

    void connect() throws IOException;

    int getContentLength();

    String getContentType();

    String getHeaderField(String str);

    List<String> getHeaderFields(String str);

    Map<String, List<String>> getHeaderFields();

    InputStream getInputStream() throws IOException;

    OutputStream getOutputStream() throws IOException;

    String getRequestMethod();

    int getResponseCode() throws IOException;

    String getResponseMessage() throws IOException;

    URL getURL();

    void setChunkedStreamingMode(int i);

    void setConnectTimeout(int i);

    void setDoOutput(boolean z);

    void setFixedLengthStreamingMode(int i);

    void setHostnameVerifier(HostnameVerifier hostnameVerifier) throws NoSuchAlgorithmException, KeyManagementException;

    void setInstanceFollowRedirects(boolean z);

    void setReadTimeout(int i);

    void setRequestMethod(String str) throws ProtocolException;

    void setRequestProperty(String str, String str2);

    void setUseCaches(boolean z);

    boolean usingProxy();
}
