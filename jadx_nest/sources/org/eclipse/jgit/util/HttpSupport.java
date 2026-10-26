package org.eclipse.jgit.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import net.lingala.zip4j.util.InternalZipConstants;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.transport.http.HttpConnection;
import org.eclipse.jgit.transport.http.NoCheckX509TrustManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* INFO: loaded from: classes5.dex */
public class HttpSupport {
    public static final String ENCODING_GZIP = "gzip";
    public static final String ENCODING_X_GZIP = "x-gzip";
    public static final String HDR_ACCEPT = "Accept";
    public static final String HDR_ACCEPT_ENCODING = "Accept-Encoding";
    public static final String HDR_ACCEPT_RANGES = "Accept-Ranges";
    public static final String HDR_AUTHORIZATION = "Authorization";
    public static final String HDR_CACHE_CONTROL = "Cache-Control";
    public static final String HDR_CONTENT_ENCODING = "Content-Encoding";
    public static final String HDR_CONTENT_LENGTH = "Content-Length";
    public static final String HDR_CONTENT_RANGE = "Content-Range";
    public static final String HDR_CONTENT_TYPE = "Content-Type";
    public static final String HDR_COOKIE = "Cookie";
    public static final String HDR_DATE = "Date";
    public static final String HDR_ETAG = "ETag";
    public static final String HDR_EXPIRES = "Expires";
    public static final String HDR_IF_MODIFIED_SINCE = "If-Modified-Since";
    public static final String HDR_IF_NONE_MATCH = "If-None-Match";
    public static final String HDR_IF_RANGE = "If-Range";
    public static final String HDR_LAST_MODIFIED = "Last-Modified";
    public static final String HDR_LOCATION = "Location";
    public static final String HDR_PRAGMA = "Pragma";
    public static final String HDR_RANGE = "Range";
    public static final String HDR_SERVER = "Server";
    public static final String HDR_SET_COOKIE = "Set-Cookie";
    public static final String HDR_SET_COOKIE2 = "Set-Cookie2";
    public static final String HDR_USER_AGENT = "User-Agent";
    public static final String HDR_WWW_AUTHENTICATE = "WWW-Authenticate";
    private static final Logger LOG = LoggerFactory.getLogger((Class<?>) HttpSupport.class);
    public static final String METHOD_GET = "GET";
    public static final String METHOD_HEAD = "HEAD";
    public static final String METHOD_POST = "POST";
    public static final String METHOD_PUT = "PUT";
    public static final String TEXT_PLAIN = "text/plain";
    private static Set<String> configuredHttpsProtocols;

    static /* synthetic */ boolean lambda$0(String str, SSLSession sSLSession) {
        return true;
    }

    public static void encode(StringBuilder sb, String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        try {
            sb.append(URLEncoder.encode(str, StandardCharsets.UTF_8.name()));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(JGitText.get().couldNotURLEncodeToUTF8, e);
        }
    }

    public static String urlEncode(String str, boolean z) {
        try {
            String strEncode = URLEncoder.encode(str, StandardCharsets.UTF_8.name());
            return z ? strEncode.replace("%2F", InternalZipConstants.ZIP_FILE_SEPARATOR) : strEncode;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(JGitText.get().couldNotURLEncodeToUTF8, e);
        }
    }

    public static int response(HttpConnection httpConnection) throws IOException {
        try {
            return httpConnection.getResponseCode();
        } catch (ConnectException e) {
            URL url = httpConnection.getURL();
            String host = url == null ? "<null>" : url.getHost();
            if ("Connection timed out: connect".equals(e.getMessage())) {
                throw new ConnectException(MessageFormat.format(JGitText.get().connectionTimeOut, host));
            }
            throw new ConnectException(e.getMessage() + " " + host);
        }
    }

    public static int response(HttpURLConnection httpURLConnection) throws IOException {
        try {
            return httpURLConnection.getResponseCode();
        } catch (ConnectException e) {
            URL url = httpURLConnection.getURL();
            String host = url == null ? "<null>" : url.getHost();
            if ("Connection timed out: connect".equals(e.getMessage())) {
                throw new ConnectException(MessageFormat.format(JGitText.get().connectionTimeOut, host));
            }
            throw new ConnectException(e.getMessage() + " " + host);
        }
    }

    public static String responseHeader(HttpConnection httpConnection, String str) throws IOException {
        return httpConnection.getHeaderField(str);
    }

    public static Proxy proxyFor(ProxySelector proxySelector, URL url) throws ConnectException {
        try {
            return proxySelector.select(new URI(url.getProtocol(), null, url.getHost(), url.getPort(), null, null, null)).get(0);
        } catch (URISyntaxException e) {
            ConnectException connectException = new ConnectException(MessageFormat.format(JGitText.get().cannotDetermineProxyFor, url));
            connectException.initCause(e);
            throw connectException;
        }
    }

    public static void disableSslVerify(HttpConnection httpConnection) throws IOException {
        try {
            httpConnection.configure(null, new TrustManager[]{new NoCheckX509TrustManager()}, null);
            httpConnection.setHostnameVerifier(new HttpSupport$$ExternalSyntheticLambda0());
        } catch (KeyManagementException | NoSuchAlgorithmException e) {
            throw new IOException(e.getMessage(), e);
        }
    }

    public static void configureTLS(SSLSocket sSLSocket) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList(sSLSocket.getEnabledProtocols()));
        for (String str : sSLSocket.getSupportedProtocols()) {
            if (str.startsWith("TLS")) {
                linkedHashSet.add(str);
            }
        }
        Set<String> configuredProtocols = getConfiguredProtocols();
        if (!configuredProtocols.isEmpty()) {
            linkedHashSet.retainAll(configuredProtocols);
        }
        if (linkedHashSet.isEmpty()) {
            return;
        }
        sSLSocket.setEnabledProtocols((String[]) linkedHashSet.toArray(new String[0]));
    }

    private static Set<String> getConfiguredProtocols() {
        Set<String> linkedHashSet = configuredHttpsProtocols;
        if (linkedHashSet == null) {
            String property = getProperty("https.protocols");
            if (StringUtils.isEmptyOrNull(property)) {
                linkedHashSet = Collections.emptySet();
            } else {
                linkedHashSet = new LinkedHashSet(Arrays.asList(property.split("\\s*,\\s*")));
            }
            configuredHttpsProtocols = linkedHashSet;
        }
        return linkedHashSet;
    }

    private static String getProperty(String str) {
        try {
            return SystemReader.getInstance().getProperty(str);
        } catch (SecurityException e) {
            LOG.warn(JGitText.get().failedReadHttpsProtocols, (Throwable) e);
            return null;
        }
    }

    public static int scanToken(String str, int i) {
        int length = str.length();
        if (i < 0 || i > length) {
            throw new IndexOutOfBoundsException();
        }
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '!' && cCharAt != '|' && cCharAt != '~' && cCharAt != '*' && cCharAt != '+' && cCharAt != '-' && cCharAt != '.') {
                switch (cCharAt) {
                    case '#':
                    case '$':
                    case '%':
                    case '&':
                    case '\'':
                        continue;
                    default:
                        switch (cCharAt) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                continue;
                            default:
                                switch (cCharAt) {
                                    case '^':
                                    case '_':
                                    case '`':
                                        continue;
                                    default:
                                        if ((cCharAt < 'a' || cCharAt > 'z') && (cCharAt < 'A' || cCharAt > 'Z')) {
                                            return i;
                                        }
                                        break;
                                }
                                break;
                        }
                        break;
                }
            }
            i++;
        }
        return i;
    }

    private HttpSupport() {
    }
}
