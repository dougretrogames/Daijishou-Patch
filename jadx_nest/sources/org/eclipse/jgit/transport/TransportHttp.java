package org.eclipse.jgit.transport;

import androidx.webkit.ProxyConfig;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpCookie;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.InvalidPathException;
import java.security.GeneralSecurityException;
import java.security.cert.CertPathBuilderException;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertificateException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.SSLHandshakeException;
import kotlin.text.Typography;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.commons.collections4.CollectionUtils;
import org.eclipse.jgit.errors.ConfigInvalidException;
import org.eclipse.jgit.errors.NoRemoteRepositoryException;
import org.eclipse.jgit.errors.NotSupportedException;
import org.eclipse.jgit.errors.PackProtocolException;
import org.eclipse.jgit.errors.TransportException;
import org.eclipse.jgit.internal.JGitText;
import org.eclipse.jgit.internal.storage.file.RefDirectory;
import org.eclipse.jgit.internal.transport.http.NetscapeCookieFile;
import org.eclipse.jgit.internal.transport.http.NetscapeCookieFileCache;
import org.eclipse.jgit.lib.BranchConfig;
import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.ObjectIdRef;
import org.eclipse.jgit.lib.ProgressMonitor;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.lib.StoredConfig;
import org.eclipse.jgit.lib.SymbolicRef;
import org.eclipse.jgit.transport.http.HttpConnection;
import org.eclipse.jgit.transport.http.HttpConnectionFactory;
import org.eclipse.jgit.transport.http.HttpConnectionFactory2;
import org.eclipse.jgit.util.FS;
import org.eclipse.jgit.util.HttpSupport;
import org.eclipse.jgit.util.IO;
import org.eclipse.jgit.util.RawParseUtils;
import org.eclipse.jgit.util.StringUtils;
import org.eclipse.jgit.util.SystemReader;
import org.eclipse.jgit.util.TemporaryBuffer;
import org.eclipse.jgit.util.io.DisabledOutputStream;
import org.eclipse.jgit.util.io.UnionInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;

/* INFO: loaded from: classes5.dex */
public class TransportHttp extends HttpTransport implements WalkTransport, PackTransport {
    private static final String SVC_RECEIVE_PACK = "git-receive-pack";
    private static final String SVC_UPLOAD_PACK = "git-upload-pack";
    private HttpAuthMethod authMethod;
    private URL baseUrl;
    private final NetscapeCookieFile cookieFile;
    private URIish currentUri;
    private HttpConnectionFactory factory;
    private boolean factoryUsed;
    private HttpConnectionFactory2.GitSession gitSession;
    private Map<String, String> headers;
    private final HttpConfig http;
    private URL objectsUrl;
    private final ProxySelector proxySelector;
    private final Set<HttpCookie> relevantCookies;
    private boolean sslFailure;
    private boolean sslVerify;
    private boolean useSmartHttp;
    private static final Logger LOG = LoggerFactory.getLogger((Class<?>) TransportHttp.class);
    private static final byte[] VERSION = "version".getBytes(StandardCharsets.US_ASCII);
    static final TransportProtocol PROTO_HTTP = new AnonymousClass1();
    static final TransportProtocol PROTO_FTP = new AnonymousClass2();

    public enum AcceptEncoding {
        UNSPECIFIED,
        GZIP;

        /* INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static AcceptEncoding[] valuesCustom() {
            AcceptEncoding[] acceptEncodingArrValuesCustom = values();
            int length = acceptEncodingArrValuesCustom.length;
            AcceptEncoding[] acceptEncodingArr = new AcceptEncoding[length];
            System.arraycopy(acceptEncodingArrValuesCustom, 0, acceptEncodingArr, 0, length);
            return acceptEncodingArr;
        }
    }

    /* INFO: renamed from: org.eclipse.jgit.transport.TransportHttp$1, reason: invalid class name */
    class AnonymousClass1 extends TransportProtocol {
        private final String[] schemeNames;
        private final Set<String> schemeSet;

        @Override // org.eclipse.jgit.transport.TransportProtocol
        public int getDefaultPort() {
            return 80;
        }

        AnonymousClass1() {
            String[] strArr = {"http", ProxyConfig.MATCH_HTTPS};
            this.schemeNames = strArr;
            this.schemeSet = Collections.unmodifiableSet(new LinkedHashSet(Arrays.asList(strArr)));
        }

        @Override // org.eclipse.jgit.transport.TransportProtocol
        public String getName() {
            return JGitText.get().transportProtoHTTP;
        }

        @Override // org.eclipse.jgit.transport.TransportProtocol
        public Set<String> getSchemes() {
            return this.schemeSet;
        }

        @Override // org.eclipse.jgit.transport.TransportProtocol
        public Set<TransportProtocol.URIishField> getRequiredFields() {
            return Collections.unmodifiableSet(EnumSet.of(TransportProtocol.URIishField.HOST, TransportProtocol.URIishField.PATH));
        }

        @Override // org.eclipse.jgit.transport.TransportProtocol
        public Set<TransportProtocol.URIishField> getOptionalFields() {
            return Collections.unmodifiableSet(EnumSet.of(TransportProtocol.URIishField.USER, TransportProtocol.URIishField.PASS, TransportProtocol.URIishField.PORT));
        }

        @Override // org.eclipse.jgit.transport.TransportProtocol
        public Transport open(URIish uRIish, Repository repository, String str) throws NotSupportedException {
            return new TransportHttp(repository, uRIish);
        }

        @Override // org.eclipse.jgit.transport.TransportProtocol
        public Transport open(URIish uRIish) throws NotSupportedException {
            return new TransportHttp(uRIish);
        }
    }

    /* INFO: renamed from: org.eclipse.jgit.transport.TransportHttp$2, reason: invalid class name */
    class AnonymousClass2 extends TransportProtocol {
        @Override // org.eclipse.jgit.transport.TransportProtocol
        public int getDefaultPort() {
            return 21;
        }

        AnonymousClass2() {
        }

        @Override // org.eclipse.jgit.transport.TransportProtocol
        public String getName() {
            return JGitText.get().transportProtoFTP;
        }

        @Override // org.eclipse.jgit.transport.TransportProtocol
        public Set<String> getSchemes() {
            return Collections.singleton("ftp");
        }

        @Override // org.eclipse.jgit.transport.TransportProtocol
        public Set<TransportProtocol.URIishField> getRequiredFields() {
            return Collections.unmodifiableSet(EnumSet.of(TransportProtocol.URIishField.HOST, TransportProtocol.URIishField.PATH));
        }

        @Override // org.eclipse.jgit.transport.TransportProtocol
        public Set<TransportProtocol.URIishField> getOptionalFields() {
            return Collections.unmodifiableSet(EnumSet.of(TransportProtocol.URIishField.USER, TransportProtocol.URIishField.PASS, TransportProtocol.URIishField.PORT));
        }

        @Override // org.eclipse.jgit.transport.TransportProtocol
        public Transport open(URIish uRIish, Repository repository, String str) throws NotSupportedException {
            return new TransportHttp(repository, uRIish);
        }
    }

    TransportHttp(Repository repository, URIish uRIish) throws NotSupportedException {
        super(repository, uRIish);
        this.useSmartHttp = true;
        this.authMethod = HttpAuthMethod.Type.NONE.method(null);
        this.sslFailure = false;
        setURI(uRIish);
        HttpConfig httpConfig = new HttpConfig(repository.getConfig(), uRIish);
        this.http = httpConfig;
        this.proxySelector = ProxySelector.getDefault();
        this.sslVerify = httpConfig.isSslVerify();
        NetscapeCookieFile cookieFileFromConfig = getCookieFileFromConfig(httpConfig);
        this.cookieFile = cookieFileFromConfig;
        this.relevantCookies = filterCookies(cookieFileFromConfig, this.baseUrl);
        this.factory = HttpTransport.getConnectionFactory();
    }

    /* INFO: Access modifiers changed from: private */
    public URL toURL(URIish uRIish) throws MalformedURLException {
        String string = uRIish.toString();
        if (!string.endsWith(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
            string = string + InternalZipConstants.ZIP_FILE_SEPARATOR;
        }
        return new URL(string);
    }

    protected void setURI(URIish uRIish) throws NotSupportedException {
        try {
            this.currentUri = uRIish;
            this.baseUrl = toURL(uRIish);
            this.objectsUrl = new URL(this.baseUrl, "objects/");
        } catch (MalformedURLException e) {
            throw new NotSupportedException(MessageFormat.format(JGitText.get().invalidURL, uRIish), e);
        }
    }

    TransportHttp(URIish uRIish) throws NotSupportedException {
        super(uRIish);
        this.useSmartHttp = true;
        this.authMethod = HttpAuthMethod.Type.NONE.method(null);
        this.sslFailure = false;
        setURI(uRIish);
        HttpConfig httpConfig = new HttpConfig(uRIish);
        this.http = httpConfig;
        this.proxySelector = ProxySelector.getDefault();
        this.sslVerify = httpConfig.isSslVerify();
        NetscapeCookieFile cookieFileFromConfig = getCookieFileFromConfig(httpConfig);
        this.cookieFile = cookieFileFromConfig;
        this.relevantCookies = filterCookies(cookieFileFromConfig, this.baseUrl);
        this.factory = HttpTransport.getConnectionFactory();
    }

    public void setUseSmartHttp(boolean z) {
        this.useSmartHttp = z;
    }

    /* WARN: Multi-variable type inference failed */
    private FetchConnection getConnection(HttpConnection httpConnection, InputStream inputStream, String str, Collection<RefSpec> collection, String... strArr) throws IOException {
        BaseConnection baseConnectionNewDumbConnection;
        if (isSmartHttp(httpConnection, str)) {
            if (!inputStream.markSupported()) {
                inputStream = new BufferedInputStream(inputStream);
            }
            readSmartHeaders(inputStream, str);
            baseConnectionNewDumbConnection = new SmartHttpFetchConnection(inputStream, collection, strArr);
        } else {
            baseConnectionNewDumbConnection = newDumbConnection(inputStream);
        }
        baseConnectionNewDumbConnection.setPeerUserAgent(httpConnection.getHeaderField("Server"));
        return (FetchConnection) baseConnectionNewDumbConnection;
    }

    public void setHttpConnectionFactory(HttpConnectionFactory httpConnectionFactory) {
        if (this.factoryUsed) {
            throw new IllegalStateException(JGitText.get().httpFactoryInUse);
        }
        this.factory = httpConnectionFactory;
    }

    public HttpConnectionFactory getHttpConnectionFactory() {
        return this.factory;
    }

    public void setPreemptiveBasicAuthentication(String str, String str2) {
        if (this.factoryUsed) {
            throw new IllegalStateException(JGitText.get().httpPreAuthTooLate);
        }
        if (StringUtils.isEmptyOrNull(str) || StringUtils.isEmptyOrNull(str2)) {
            this.authMethod = authFromUri(this.currentUri);
            return;
        }
        HttpAuthMethod httpAuthMethodMethod = HttpAuthMethod.Type.BASIC.method(null);
        httpAuthMethodMethod.authorize(str, str2);
        this.authMethod = httpAuthMethodMethod;
    }

    @Override // org.eclipse.jgit.transport.Transport
    public FetchConnection openFetch() throws TransportException, NotSupportedException {
        return openFetch(Collections.emptyList(), new String[0]);
    }

    /* WARN: Code duplicated, block: B:35:0x003e A[DONT_INVERT] */
    /* WARN: Code duplicated, block: B:60:0x0040 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* WARN: Code duplicated, block: B:67:? A[RETURN, SYNTHETIC] */
    /* WARN: Unreachable blocks removed: 2, instructions: 2 */
    @Override // org.eclipse.jgit.transport.Transport
    public FetchConnection openFetch(Collection<RefSpec> collection, String... strArr) throws Throwable {
        IOException iOException;
        Throwable th;
        try {
            TransferConfig.ProtocolVersion protocolVersion = this.protocol;
            if (protocolVersion == null) {
                try {
                    protocolVersion = TransferConfig.ProtocolVersion.V2;
                } catch (NotSupportedException e) {
                    e = e;
                    throw e;
                } catch (TransportException e2) {
                    e = e2;
                    throw e;
                } catch (IOException e3) {
                    iOException = e3;
                    this = this;
                    throw new TransportException(this.uri, JGitText.get().errorReadingInfoRefs, iOException);
                }
            }
            HttpConnection httpConnectionConnect = connect("git-upload-pack", protocolVersion);
            Throwable th2 = null;
            try {
                try {
                    InputStream inputStreamOpenInputStream = openInputStream(httpConnectionConnect);
                    try {
                        return getConnection(httpConnectionConnect, inputStreamOpenInputStream, "git-upload-pack", collection, strArr);
                    } finally {
                        if (inputStreamOpenInputStream != null) {
                            inputStreamOpenInputStream.close();
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    th = th;
                    if (0 != 0) {
                        throw th;
                    }
                    if (null != th) {
                        try {
                            th2.addSuppressed(th);
                        } catch (NotSupportedException e4) {
                            e = e4;
                            throw e;
                        } catch (TransportException e5) {
                            e = e5;
                            throw e;
                        } catch (IOException e6) {
                            e = e6;
                            iOException = e;
                            throw new TransportException(this.uri, JGitText.get().errorReadingInfoRefs, iOException);
                        }
                    }
                    throw null;
                }
            } catch (Throwable th4) {
                th = th4;
                th = th;
                if (0 != 0) {
                    throw th;
                }
                if (null != th) {
                    th2.addSuppressed(th);
                }
                throw null;
            }
        } catch (NotSupportedException e7) {
            e = e7;
            throw e;
        } catch (TransportException e8) {
            e = e8;
            throw e;
        } catch (IOException e9) {
            e = e9;
        }
    }

    private WalkFetchConnection newDumbConnection(InputStream inputStream) throws IOException {
        HttpObjectDB httpObjectDB = new HttpObjectDB(this.objectsUrl);
        Throwable th = null;
        try {
            BufferedReader bufferedReader = toBufferedReader(inputStream);
            try {
                Map<String, Ref> advertisedImpl = httpObjectDB.readAdvertisedImpl(bufferedReader);
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (!advertisedImpl.containsKey("HEAD")) {
                    HttpConnection httpConnectionHttpOpen = httpOpen("GET", new URL(this.baseUrl, "HEAD"), AcceptEncoding.GZIP);
                    int iResponse = HttpSupport.response(httpConnectionHttpOpen);
                    if (iResponse == 200) {
                        try {
                            BufferedReader bufferedReader2 = toBufferedReader(openInputStream(httpConnectionHttpOpen));
                            try {
                                String line = bufferedReader2.readLine();
                                if (line != null && line.startsWith(RefDirectory.SYMREF)) {
                                    String strSubstring = line.substring(RefDirectory.SYMREF.length());
                                    Ref unpeeled = advertisedImpl.get(strSubstring);
                                    if (unpeeled == null) {
                                        unpeeled = new ObjectIdRef.Unpeeled(Ref.Storage.NEW, strSubstring, null);
                                    }
                                    SymbolicRef symbolicRef = new SymbolicRef("HEAD", unpeeled);
                                    advertisedImpl.put(symbolicRef.getName(), symbolicRef);
                                } else if (line != null && ObjectId.isId(line)) {
                                    ObjectIdRef.Unpeeled unpeeled2 = new ObjectIdRef.Unpeeled(Ref.Storage.NETWORK, "HEAD", ObjectId.fromString(line));
                                    advertisedImpl.put(unpeeled2.getName(), unpeeled2);
                                }
                                if (bufferedReader2 != null) {
                                    bufferedReader2.close();
                                }
                            } catch (Throwable th2) {
                                if (bufferedReader2 == null) {
                                    throw th2;
                                }
                                bufferedReader2.close();
                                throw th2;
                            }
                        } catch (Throwable th3) {
                            if (0 == 0) {
                                throw th3;
                            }
                            if (null != th3) {
                                th.addSuppressed(th3);
                            }
                            throw null;
                        }
                    } else if (iResponse != 404) {
                        throw new TransportException(this.uri, MessageFormat.format(JGitText.get().cannotReadHEAD, Integer.valueOf(iResponse), httpConnectionHttpOpen.getResponseMessage()));
                    }
                }
                WalkFetchConnection walkFetchConnection = new WalkFetchConnection(this, httpObjectDB);
                walkFetchConnection.available(advertisedImpl);
                return walkFetchConnection;
            } catch (Throwable th4) {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th4;
            }
        } catch (Throwable th5) {
            if (0 == 0) {
                throw th5;
            }
            if (null != th5) {
                th.addSuppressed(th5);
            }
            throw null;
        }
    }

    private BufferedReader toBufferedReader(InputStream inputStream) {
        return new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
    }

    @Override // org.eclipse.jgit.transport.Transport
    public PushConnection openPush() throws NotSupportedException, TransportException {
        try {
            HttpConnection httpConnectionConnect = connect("git-receive-pack");
            Throwable th = null;
            try {
                InputStream inputStreamOpenInputStream = openInputStream(httpConnectionConnect);
                try {
                    if (isSmartHttp(httpConnectionConnect, "git-receive-pack")) {
                        PushConnection pushConnectionSmartPush = smartPush("git-receive-pack", httpConnectionConnect, inputStreamOpenInputStream);
                        if (inputStreamOpenInputStream != null) {
                            inputStreamOpenInputStream.close();
                        }
                        return pushConnectionSmartPush;
                    }
                    if (!this.useSmartHttp) {
                        throw new NotSupportedException(JGitText.get().smartHTTPPushDisabled);
                    }
                    throw new NotSupportedException(JGitText.get().remoteDoesNotSupportSmartHTTPPush);
                } catch (Throwable th2) {
                    if (inputStreamOpenInputStream == null) {
                        throw th2;
                    }
                    inputStreamOpenInputStream.close();
                    throw th2;
                }
            } catch (Throwable th3) {
                if (0 == 0) {
                    throw th3;
                }
                if (null != th3) {
                    th.addSuppressed(th3);
                }
                throw null;
            }
        } catch (NotSupportedException e) {
            throw e;
        } catch (TransportException e2) {
            throw e2;
        } catch (IOException e3) {
            throw new TransportException(this.uri, JGitText.get().errorReadingInfoRefs, e3);
        }
    }

    private PushConnection smartPush(String str, HttpConnection httpConnection, InputStream inputStream) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        readSmartHeaders(bufferedInputStream, str);
        SmartHttpPushConnection smartHttpPushConnection = new SmartHttpPushConnection(bufferedInputStream);
        smartHttpPushConnection.setPeerUserAgent(httpConnection.getHeaderField("Server"));
        return smartHttpPushConnection;
    }

    @Override // org.eclipse.jgit.transport.Transport, java.lang.AutoCloseable
    public void close() {
        HttpConnectionFactory2.GitSession gitSession = this.gitSession;
        if (gitSession != null) {
            gitSession.close();
            this.gitSession = null;
        }
    }

    public void setAdditionalHeaders(Map<String, String> map) {
        this.headers = map;
    }

    public Map<String, String> getAdditionalHeaders() {
        return Collections.unmodifiableMap(this.headers);
    }

    /* INFO: Access modifiers changed from: private */
    public NoRemoteRepositoryException createNotFoundException(URIish uRIish, URL url, String str) {
        String str2;
        if (str != null && !str.isEmpty()) {
            str2 = MessageFormat.format(JGitText.get().uriNotFoundWithMessage, url, str);
        } else {
            str2 = MessageFormat.format(JGitText.get().uriNotFound, url);
        }
        return new NoRemoteRepositoryException(uRIish, str2);
    }

    private HttpAuthMethod authFromUri(URIish uRIish) {
        String user = uRIish.getUser();
        String pass = uRIish.getPass();
        if (user != null && pass != null) {
            try {
                String strDecode = URLDecoder.decode(user.replace(Marker.ANY_NON_NULL_MARKER, "%2B"), StandardCharsets.UTF_8.name());
                String strDecode2 = URLDecoder.decode(pass.replace(Marker.ANY_NON_NULL_MARKER, "%2B"), StandardCharsets.UTF_8.name());
                HttpAuthMethod httpAuthMethodMethod = HttpAuthMethod.Type.BASIC.method(null);
                httpAuthMethodMethod.authorize(strDecode, strDecode2);
                return httpAuthMethodMethod;
            } catch (UnsupportedEncodingException | IllegalArgumentException unused) {
                LOG.warn(JGitText.get().httpUserInfoDecodeError, uRIish);
            }
        }
        return HttpAuthMethod.Type.NONE.method(null);
    }

    private HttpConnection connect(String str) throws TransportException, NotSupportedException {
        return connect(str, null);
    }

    private HttpConnection connect(String str, TransferConfig.ProtocolVersion protocolVersion) throws NotSupportedException, TransportException {
        URL serviceURL = getServiceURL(str);
        if (HttpAuthMethod.Type.NONE.equals(this.authMethod.getType())) {
            this.authMethod = authFromUri(this.currentUri);
        }
        int i = 0;
        HashSet hashSet = null;
        while (true) {
            int i2 = 1;
            while (true) {
                try {
                    try {
                        HttpConnection httpConnectionHttpOpen = httpOpen("GET", serviceURL, AcceptEncoding.GZIP);
                        if (this.useSmartHttp) {
                            httpConnectionHttpOpen.setRequestProperty("Accept", ("application/x-" + str + "-advertisement") + ", */*");
                        } else {
                            httpConnectionHttpOpen.setRequestProperty("Accept", "*/*");
                        }
                        if (TransferConfig.ProtocolVersion.V2.equals(protocolVersion)) {
                            httpConnectionHttpOpen.setRequestProperty(GitProtocolConstants.PROTOCOL_HEADER, GitProtocolConstants.VERSION_2_REQUEST);
                        }
                        int iResponse = HttpSupport.response(httpConnectionHttpOpen);
                        processResponseCookies(httpConnectionHttpOpen);
                        if (iResponse == 200) {
                            if (this.authMethod.getType() == HttpAuthMethod.Type.NONE && httpConnectionHttpOpen.getHeaderField("WWW-Authenticate") != null) {
                                this.authMethod = HttpAuthMethod.scanResponse(httpConnectionHttpOpen, hashSet);
                            }
                            return httpConnectionHttpOpen;
                        }
                        if (iResponse == 401) {
                            HttpAuthMethod httpAuthMethodScanResponse = HttpAuthMethod.scanResponse(httpConnectionHttpOpen, hashSet);
                            this.authMethod = httpAuthMethodScanResponse;
                            if (httpAuthMethodScanResponse.getType() == HttpAuthMethod.Type.NONE) {
                                throw new TransportException(this.uri, MessageFormat.format(JGitText.get().authenticationNotSupported, this.uri));
                            }
                            CredentialsProvider credentialsProvider = getCredentialsProvider();
                            if (credentialsProvider == null) {
                                throw new TransportException(this.uri, JGitText.get().noCredentialsProvider);
                            }
                            if (i2 > 1) {
                                credentialsProvider.reset(this.currentUri);
                            }
                            if (3 < i2 || !this.authMethod.authorize(this.currentUri, credentialsProvider)) {
                                throw new TransportException(this.uri, JGitText.get().notAuthorized);
                            }
                            i2++;
                        } else {
                            if (iResponse != 307 && iResponse != 308) {
                                if (iResponse == 403) {
                                    throw new TransportException(this.uri, MessageFormat.format(JGitText.get().serviceNotPermitted, this.baseUrl, str));
                                }
                                if (iResponse == 404) {
                                    throw createNotFoundException(this.uri, serviceURL, httpConnectionHttpOpen.getResponseMessage());
                                }
                                switch (iResponse) {
                                    case 301:
                                    case 302:
                                    case 303:
                                        break;
                                    default:
                                        throw new TransportException(this.uri, iResponse + " " + httpConnectionHttpOpen.getResponseMessage());
                                }
                            }
                            if (this.http.getFollowRedirects() == HttpConfig.HttpRedirectMode.FALSE) {
                                throw new TransportException(this.uri, MessageFormat.format(JGitText.get().redirectsOff, Integer.valueOf(iResponse)));
                            }
                            int i3 = i + 1;
                            try {
                                setURI(redirect(serviceURL, httpConnectionHttpOpen.getHeaderField("Location"), Constants.INFO_REFS, i));
                                serviceURL = getServiceURL(str);
                                i2 = 1;
                                i = i3;
                            } catch (SSLHandshakeException e) {
                                e = e;
                                i = i3;
                                handleSslFailure(e);
                            } catch (IOException e2) {
                                e = e2;
                                i = i3;
                                if (this.authMethod.getType() != HttpAuthMethod.Type.NONE) {
                                    if (hashSet == null) {
                                        hashSet = new HashSet();
                                    }
                                    hashSet.add(this.authMethod.getType());
                                    this.authMethod = HttpAuthMethod.Type.NONE.method(null);
                                } else {
                                    throw new TransportException(this.uri, MessageFormat.format(JGitText.get().cannotOpenService, str), e);
                                }
                            }
                        }
                    } catch (SSLHandshakeException e3) {
                        e = e3;
                    } catch (IOException e4) {
                        e = e4;
                    }
                } catch (InterruptedIOException e5) {
                    throw new TransportException(this.uri, MessageFormat.format(JGitText.get().connectionTimeOut, serviceURL.getHost()), e5);
                } catch (SocketException e6) {
                    throw new TransportException(this.uri, JGitText.get().connectionFailed, e6);
                } catch (NotSupportedException e7) {
                    throw e7;
                } catch (TransportException e8) {
                    throw e8;
                }
            }
            hashSet.add(this.authMethod.getType());
            this.authMethod = HttpAuthMethod.Type.NONE.method(null);
        }
    }

    void processResponseCookies(HttpConnection httpConnection) {
        if (this.cookieFile == null || !this.http.getSaveCookies()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        List<String> headerFields = httpConnection.getHeaderFields("Set-Cookie");
        if (!headerFields.isEmpty()) {
            arrayList.addAll(extractCookies("Set-Cookie", headerFields));
        }
        List<String> headerFields2 = httpConnection.getHeaderFields("Set-Cookie2");
        if (!headerFields2.isEmpty()) {
            arrayList.addAll(extractCookies("Set-Cookie2", headerFields2));
        }
        if (arrayList.isEmpty()) {
            return;
        }
        try {
            this.cookieFile.getCookies(false).addAll(arrayList);
            this.cookieFile.write(this.baseUrl);
            this.relevantCookies.addAll(arrayList);
        } catch (IOException | IllegalArgumentException | InterruptedException e) {
            LOG.warn(MessageFormat.format(JGitText.get().couldNotPersistCookies, this.cookieFile.getPath()), e);
        }
    }

    private List<HttpCookie> extractCookies(String str, List<String> list) {
        ArrayList<HttpCookie> arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.addAll(HttpCookie.parse(str + CollectionUtils.COLON + it.next()));
        }
        for (HttpCookie httpCookie : arrayList) {
            String domain = httpCookie.getDomain();
            if (domain != null && domain.startsWith(BranchConfig.LOCAL_REPOSITORY)) {
                httpCookie.setDomain(domain.substring(1));
            }
        }
        return arrayList;
    }

    private static class CredentialItems {
        CredentialItem.YesNoType always;
        CredentialItem.YesNoType forRepo;
        CredentialItem.InformationalMessage message;
        CredentialItem.YesNoType now;

        /* synthetic */ CredentialItems(TransportHttpIA transportHttpIA) {
            this();
        }

        private CredentialItems() {
        }

        public CredentialItem[] items() {
            CredentialItem.YesNoType yesNoType = this.forRepo;
            if (yesNoType == null) {
                return new CredentialItem[]{this.message, this.now, this.always};
            }
            return new CredentialItem[]{this.message, this.now, yesNoType, this.always};
        }
    }

    /* INFO: Access modifiers changed from: private */
    public void handleSslFailure(Throwable th) throws TransportException {
        if (this.sslFailure || !trustInsecureSslConnection(th.getCause())) {
            throw new TransportException(this.uri, MessageFormat.format(JGitText.get().sslFailureExceptionMessage, this.currentUri.setPass(null)), th);
        }
        this.sslFailure = true;
    }

    private boolean trustInsecureSslConnection(Throwable th) {
        CredentialsProvider credentialsProvider;
        if (((th instanceof CertificateException) || (th instanceof CertPathBuilderException) || (th instanceof CertPathValidatorException)) && (credentialsProvider = getCredentialsProvider()) != null) {
            CredentialItems credentialItemsConstructSslTrustItems = constructSslTrustItems(th);
            CredentialItem[] credentialItemArrItems = credentialItemsConstructSslTrustItems.items();
            if (credentialsProvider.supports(credentialItemArrItems) && credentialsProvider.get(this.uri, credentialItemArrItems)) {
                boolean value = credentialItemsConstructSslTrustItems.now.getValue();
                boolean z = credentialItemsConstructSslTrustItems.forRepo != null && credentialItemsConstructSslTrustItems.forRepo.getValue();
                boolean value2 = credentialItemsConstructSslTrustItems.always.getValue();
                if (value || z || value2) {
                    this.sslVerify = false;
                    if (value2) {
                        updateSslVerifyUser(false);
                    } else if (z) {
                        updateSslVerify(this.local.getConfig(), false);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private CredentialItems constructSslTrustItems(Throwable th) {
        CredentialItems credentialItems = new CredentialItems(null);
        String str = MessageFormat.format(JGitText.get().sslFailureInfo, this.currentUri.setPass(null));
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = th.toString();
        }
        credentialItems.message = new CredentialItem.InformationalMessage(str + "\n" + MessageFormat.format(JGitText.get().sslFailureCause, localizedMessage) + "\n" + JGitText.get().sslFailureTrustExplanation);
        credentialItems.now = new CredentialItem.YesNoType(JGitText.get().sslTrustNow);
        if (this.local != null) {
            credentialItems.forRepo = new CredentialItem.YesNoType(MessageFormat.format(JGitText.get().sslTrustForRepo, this.local.getDirectory()));
        }
        credentialItems.always = new CredentialItem.YesNoType(JGitText.get().sslTrustAlways);
        return credentialItems;
    }

    private void updateSslVerify(StoredConfig storedConfig, boolean z) {
        String str = this.uri.getScheme() + "://" + this.uri.getHost();
        int port = this.uri.getPort();
        if (port > 0) {
            str = str + CollectionUtils.COLON + port;
        }
        storedConfig.setBoolean("http", str, HttpConfig.SSL_VERIFY_KEY, z);
        try {
            storedConfig.save();
        } catch (IOException e) {
            LOG.error(JGitText.get().sslVerifyCannotSave, (Throwable) e);
        }
    }

    /* WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class decompiler.core.dex.instructions.args.ArgType$UnknownArg
    	at decompiler.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at decompiler.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at decompiler.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at decompiler.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void updateSslVerifyUser(boolean z) {
        try {
            updateSslVerify(SystemReader.getInstance().getUserConfig(), z);
        } catch (IOException | ConfigInvalidException e) {
            LOG.error(e.getMessage(), (Throwable) e);
        }
    }

    /* INFO: Access modifiers changed from: private */
    public URIish redirect(URL url, String str, String str2, int i) throws TransportException {
        if (str == null || str.isEmpty()) {
            throw new TransportException(this.uri, MessageFormat.format(JGitText.get().redirectLocationMissing, this.baseUrl));
        }
        if (i >= this.http.getMaxRedirects()) {
            throw new TransportException(this.uri, MessageFormat.format(JGitText.get().redirectLimitExceeded, Integer.valueOf(this.http.getMaxRedirects()), this.baseUrl, str));
        }
        try {
            URI uri = new URI(str);
            boolean zIsEmptyOrNull = StringUtils.isEmptyOrNull(uri.getUserInfo());
            String host = url.getHost();
            URI uriResolve = url.toURI().resolve(uri);
            boolean z = (zIsEmptyOrNull && host.equals(uriResolve.getHost())) ? false : true;
            String aSCIIString = uriResolve.toASCIIString();
            if (!isValidRedirect(this.baseUrl, aSCIIString, str2)) {
                throw new TransportException(this.uri, MessageFormat.format(JGitText.get().redirectBlocked, this.baseUrl, aSCIIString));
            }
            URIish uRIish = new URIish(aSCIIString.substring(0, aSCIIString.indexOf(str2)));
            if (z) {
                this.authMethod = HttpAuthMethod.Type.NONE.method(null);
            }
            Logger logger = LOG;
            if (logger.isInfoEnabled()) {
                logger.info(MessageFormat.format(JGitText.get().redirectHttp, this.uri.setPass(null), Integer.valueOf(i), this.baseUrl, uRIish));
            }
            return uRIish;
        } catch (URISyntaxException e) {
            throw new TransportException(this.uri, MessageFormat.format(JGitText.get().invalidRedirectLocation, this.baseUrl, str), e);
        }
    }

    private boolean isValidRedirect(URL url, String str, String str2) {
        String lowerCase = url.getProtocol().toLowerCase(Locale.ROOT);
        int iIndexOf = str.indexOf("://");
        if (iIndexOf < 0) {
            return false;
        }
        String lowerCase2 = str.substring(0, iIndexOf).toLowerCase(Locale.ROOT);
        return (lowerCase.equals(lowerCase2) || ProxyConfig.MATCH_HTTPS.equals(lowerCase2)) && str.contains(str2);
    }

    private URL getServiceURL(String str) throws NotSupportedException {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(this.baseUrl);
            if (sb.charAt(sb.length() - 1) != '/') {
                sb.append('/');
            }
            sb.append(Constants.INFO_REFS);
            if (this.useSmartHttp) {
                sb.append(sb.indexOf("?") < 0 ? '?' : Typography.amp);
                sb.append("service=");
                sb.append(str);
            }
            return new URL(sb.toString());
        } catch (MalformedURLException e) {
            throw new NotSupportedException(MessageFormat.format(JGitText.get().invalidURL, this.uri), e);
        }
    }

    protected HttpConnection httpOpen(String str, URL url, AcceptEncoding acceptEncoding) throws IOException {
        if (str == null || url == null || acceptEncoding == null) {
            throw null;
        }
        Proxy proxyProxyFor = HttpSupport.proxyFor(this.proxySelector, url);
        this.factoryUsed = true;
        HttpConnection httpConnectionCreate = this.factory.create(url, proxyProxyFor);
        if (this.gitSession == null) {
            HttpConnectionFactory httpConnectionFactory = this.factory;
            if (httpConnectionFactory instanceof HttpConnectionFactory2) {
                this.gitSession = ((HttpConnectionFactory2) httpConnectionFactory).newSession();
            }
        }
        HttpConnectionFactory2.GitSession gitSession = this.gitSession;
        if (gitSession != null) {
            try {
                gitSession.configure(httpConnectionCreate, this.sslVerify);
            } catch (GeneralSecurityException e) {
                throw new IOException(e.getMessage(), e);
            }
        } else if (!this.sslVerify && ProxyConfig.MATCH_HTTPS.equals(url.getProtocol())) {
            HttpSupport.disableSslVerify(httpConnectionCreate);
        }
        httpConnectionCreate.setInstanceFollowRedirects(false);
        httpConnectionCreate.setRequestMethod(str);
        httpConnectionCreate.setUseCaches(false);
        if (acceptEncoding == AcceptEncoding.GZIP) {
            httpConnectionCreate.setRequestProperty("Accept-Encoding", HttpSupport.ENCODING_GZIP);
        }
        httpConnectionCreate.setRequestProperty("Pragma", "no-cache");
        if (this.http.getUserAgent() != null) {
            httpConnectionCreate.setRequestProperty("User-Agent", this.http.getUserAgent());
        } else if (UserAgent.get() != null) {
            httpConnectionCreate.setRequestProperty("User-Agent", UserAgent.get());
        }
        int timeout = getTimeout();
        if (timeout != -1) {
            int i = timeout * 1000;
            httpConnectionCreate.setConnectTimeout(i);
            httpConnectionCreate.setReadTimeout(i);
        }
        addHeaders(httpConnectionCreate, this.http.getExtraHeaders());
        if (!this.relevantCookies.isEmpty()) {
            setCookieHeader(httpConnectionCreate);
        }
        Map<String, String> map = this.headers;
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : this.headers.entrySet()) {
                httpConnectionCreate.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        this.authMethod.configureRequest(httpConnectionCreate);
        return httpConnectionCreate;
    }

    static void addHeaders(HttpConnection httpConnection, List<String> list) {
        for (String str : list) {
            int iIndexOf = str.indexOf(58);
            String strTrim = iIndexOf > 0 ? str.substring(0, iIndexOf).trim() : null;
            if (strTrim == null || strTrim.isEmpty()) {
                LOG.warn(MessageFormat.format(JGitText.get().invalidHeaderFormat, str));
            } else if (HttpSupport.scanToken(strTrim, 0) != strTrim.length()) {
                LOG.warn(MessageFormat.format(JGitText.get().invalidHeaderKey, str));
            } else {
                String strTrim2 = str.substring(iIndexOf + 1).trim();
                if (!StandardCharsets.US_ASCII.newEncoder().canEncode(strTrim2)) {
                    LOG.warn(MessageFormat.format(JGitText.get().invalidHeaderValue, str));
                } else {
                    httpConnection.setRequestProperty(strTrim, strTrim2);
                }
            }
        }
    }

    private void setCookieHeader(HttpConnection httpConnection) {
        StringBuilder sb = new StringBuilder();
        for (HttpCookie httpCookie : this.relevantCookies) {
            if (!httpCookie.hasExpired()) {
                if (sb.length() > 0) {
                    sb.append(';');
                }
                sb.append(httpCookie.toString());
            }
        }
        if (sb.length() > 0) {
            httpConnection.setRequestProperty("Cookie", sb.toString());
        }
    }

    final InputStream openInputStream(HttpConnection httpConnection) throws IOException {
        InputStream inputStream = httpConnection.getInputStream();
        return isGzipContent(httpConnection) ? new GZIPInputStream(inputStream) : inputStream;
    }

    IOException wrongContentType(String str, String str2) {
        return new TransportException(this.uri, MessageFormat.format(JGitText.get().expectedReceivedContentType, str, str2));
    }

    private NetscapeCookieFile getCookieFileFromConfig(HttpConfig httpConfig) {
        File fileResolve;
        String cookieFile = httpConfig.getCookieFile();
        if (!StringUtils.isEmptyOrNull(cookieFile)) {
            try {
                FS fs = this.local != null ? this.local.getFS() : FS.DETECTED;
                if (cookieFile.startsWith("~/")) {
                    fileResolve = fs.resolve(fs.userHome(), cookieFile.substring(2));
                } else {
                    File file = new File(cookieFile);
                    if (file.isAbsolute()) {
                        fileResolve = file;
                    } else {
                        fileResolve = fs.resolve(null, cookieFile);
                        LOG.warn(MessageFormat.format(JGitText.get().cookieFilePathRelative, fileResolve));
                    }
                }
                return NetscapeCookieFileCache.getInstance(httpConfig).getEntry(fileResolve.toPath());
            } catch (InvalidPathException e) {
                LOG.warn(MessageFormat.format(JGitText.get().couldNotReadCookieFile, cookieFile), (Throwable) e);
            }
        }
        return null;
    }

    private static Set<HttpCookie> filterCookies(NetscapeCookieFile netscapeCookieFile, URL url) {
        if (netscapeCookieFile != null) {
            return filterCookies(netscapeCookieFile.getCookies(true), url);
        }
        return Collections.emptySet();
    }

    private static Set<HttpCookie> filterCookies(Set<HttpCookie> set, URL url) {
        HashSet hashSet = new HashSet();
        for (HttpCookie httpCookie : set) {
            if (!httpCookie.hasExpired() && matchesCookieDomain(url.getHost(), httpCookie.getDomain()) && matchesCookiePath(url.getPath(), httpCookie.getPath()) && (!httpCookie.getSecure() || ProxyConfig.MATCH_HTTPS.equals(url.getProtocol()))) {
                hashSet.add(httpCookie);
            }
        }
        return hashSet;
    }

    static boolean matchesCookieDomain(String str, String str2) {
        String lowerCase = str2.toLowerCase(Locale.ROOT);
        String lowerCase2 = str.toLowerCase(Locale.ROOT);
        if (lowerCase2.equals(lowerCase)) {
            return true;
        }
        return lowerCase2.endsWith(lowerCase) && lowerCase2.charAt((lowerCase2.length() - lowerCase.length()) - 1) == '.';
    }

    static boolean matchesCookiePath(String str, String str2) {
        if (str2.equals(str)) {
            return true;
        }
        if (!str2.endsWith(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
            str2 = str2 + InternalZipConstants.ZIP_FILE_SEPARATOR;
        }
        return str.startsWith(str2);
    }

    private boolean isSmartHttp(HttpConnection httpConnection, String str) {
        return ("application/x-" + str + "-advertisement").equals(httpConnection.getContentType());
    }

    /* INFO: Access modifiers changed from: private */
    public boolean isGzipContent(HttpConnection httpConnection) {
        return HttpSupport.ENCODING_GZIP.equals(httpConnection.getHeaderField("Content-Encoding")) || HttpSupport.ENCODING_X_GZIP.equals(httpConnection.getHeaderField("Content-Encoding"));
    }

    private void readSmartHeaders(InputStream inputStream, String str) throws IOException {
        byte b;
        byte[] bArr = new byte[14];
        if (!inputStream.markSupported()) {
            throw new TransportException(this.uri, JGitText.get().inputStreamMustSupportMark);
        }
        inputStream.mark(14);
        IO.readFully(inputStream, bArr, 0, 14);
        if (Arrays.equals(Arrays.copyOfRange(bArr, 4, 11), VERSION) && (b = bArr[12]) >= 49 && b <= 57) {
            inputStream.reset();
            return;
        }
        if (bArr[4] != 35) {
            throw new TransportException(this.uri, MessageFormat.format(JGitText.get().expectedPktLineWithService, RawParseUtils.decode(bArr)));
        }
        inputStream.reset();
        PacketLineIn packetLineIn = new PacketLineIn(inputStream);
        String str2 = "# service=" + str;
        String string = packetLineIn.readString();
        if (!str2.equals(string)) {
            throw new TransportException(this.uri, MessageFormat.format(JGitText.get().expectedGot, str2, string));
        }
        while (!PacketLineIn.isEnd(packetLineIn.readString())) {
        }
    }

    class HttpObjectDB extends WalkRemoteObjectDatabase {
        private final URL httpObjectsUrl;

        @Override // org.eclipse.jgit.transport.WalkRemoteObjectDatabase
        void close() {
        }

        HttpObjectDB(URL url) {
            this.httpObjectsUrl = url;
        }

        @Override // org.eclipse.jgit.transport.WalkRemoteObjectDatabase
        URIish getURI() {
            return new URIish(this.httpObjectsUrl);
        }

        @Override // org.eclipse.jgit.transport.WalkRemoteObjectDatabase
        Collection<WalkRemoteObjectDatabase> getAlternates() throws IOException {
            try {
                try {
                    return readAlternates(Constants.INFO_HTTP_ALTERNATES);
                } catch (FileNotFoundException unused) {
                    return null;
                }
            } catch (FileNotFoundException unused2) {
                return readAlternates(Constants.INFO_ALTERNATES);
            }
        }

        @Override // org.eclipse.jgit.transport.WalkRemoteObjectDatabase
        WalkRemoteObjectDatabase openAlternate(String str) throws IOException {
            return TransportHttp.this.new HttpObjectDB(new URL(this.httpObjectsUrl, str));
        }

        @Override // org.eclipse.jgit.transport.WalkRemoteObjectDatabase
        BufferedReader openReader(String str) throws IOException {
            return new BufferedReader(new InputStreamReader(open(str, AcceptEncoding.GZIP).in, StandardCharsets.UTF_8));
        }

        @Override // org.eclipse.jgit.transport.WalkRemoteObjectDatabase
        Collection<String> getPackNames() throws IOException {
            ArrayList arrayList = new ArrayList();
            PackProtocolException packProtocolExceptionInvalidAdvertisement = null;
            try {
                BufferedReader bufferedReaderOpenReader = openReader("info/packs");
                while (true) {
                    try {
                        String line = bufferedReaderOpenReader.readLine();
                        if (line == null || line.length() == 0) {
                            break;
                            break;
                        }
                        if (!line.startsWith("P pack-") || !line.endsWith(".pack")) {
                            packProtocolExceptionInvalidAdvertisement = invalidAdvertisement(line);
                            throw packProtocolExceptionInvalidAdvertisement;
                        }
                        arrayList.add(line.substring(2));
                    } catch (Throwable th) {
                        if (bufferedReaderOpenReader != null) {
                            bufferedReaderOpenReader.close();
                        }
                        throw th;
                    }
                }
                if (bufferedReaderOpenReader != null) {
                    bufferedReaderOpenReader.close();
                    return arrayList;
                }
                return arrayList;
            } catch (Throwable th2) {
                if (packProtocolExceptionInvalidAdvertisement == null) {
                    throw th2;
                }
                if (packProtocolExceptionInvalidAdvertisement == th2) {
                    throw packProtocolExceptionInvalidAdvertisement;
                }
                try {
                    packProtocolExceptionInvalidAdvertisement.addSuppressed(th2);
                    throw packProtocolExceptionInvalidAdvertisement;
                } catch (FileNotFoundException unused) {
                }
            }
        }

        @Override // org.eclipse.jgit.transport.WalkRemoteObjectDatabase
        WalkRemoteObjectDatabase.FileStream open(String str) throws IOException {
            return open(str, AcceptEncoding.UNSPECIFIED);
        }

        WalkRemoteObjectDatabase.FileStream open(String str, AcceptEncoding acceptEncoding) throws IOException {
            URL url = new URL(this.httpObjectsUrl, str);
            HttpConnection httpConnectionHttpOpen = TransportHttp.this.httpOpen("GET", url, acceptEncoding);
            int iResponse = HttpSupport.response(httpConnectionHttpOpen);
            if (iResponse == 200) {
                InputStream inputStreamOpenInputStream = TransportHttp.this.openInputStream(httpConnectionHttpOpen);
                if (!TransportHttp.this.isGzipContent(httpConnectionHttpOpen)) {
                    return new WalkRemoteObjectDatabase.FileStream(inputStreamOpenInputStream, httpConnectionHttpOpen.getContentLength());
                }
                return new WalkRemoteObjectDatabase.FileStream(inputStreamOpenInputStream);
            }
            if (iResponse == 404) {
                throw new FileNotFoundException(url.toString());
            }
            throw new IOException(url.toString() + ": " + HttpSupport.response(httpConnectionHttpOpen) + " " + httpConnectionHttpOpen.getResponseMessage());
        }

        Map<String, Ref> readAdvertisedImpl(BufferedReader bufferedReader) throws IOException {
            TreeMap treeMap = new TreeMap();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    return treeMap;
                }
                int iIndexOf = line.indexOf(9);
                if (iIndexOf < 0) {
                    throw invalidAdvertisement(line);
                }
                String strSubstring = line.substring(iIndexOf + 1);
                ObjectId objectIdFromString = ObjectId.fromString(line.substring(0, iIndexOf));
                if (strSubstring.endsWith("^{}")) {
                    String strSubstring2 = strSubstring.substring(0, strSubstring.length() - 3);
                    Ref ref = (Ref) treeMap.get(strSubstring2);
                    if (ref == null) {
                        throw outOfOrderAdvertisement(strSubstring2);
                    }
                    if (ref.getPeeledObjectId() != null) {
                        throw duplicateAdvertisement(strSubstring2 + "^{}");
                    }
                    treeMap.put(strSubstring2, new ObjectIdRef.PeeledTag(Ref.Storage.NETWORK, strSubstring2, ref.getObjectId(), objectIdFromString));
                } else if (((Ref) treeMap.put(strSubstring, new ObjectIdRef.PeeledNonTag(Ref.Storage.NETWORK, strSubstring, objectIdFromString))) != null) {
                    throw duplicateAdvertisement(strSubstring);
                }
            }
        }

        private PackProtocolException outOfOrderAdvertisement(String str) {
            return new PackProtocolException(MessageFormat.format(JGitText.get().advertisementOfCameBefore, str, str));
        }

        private PackProtocolException invalidAdvertisement(String str) {
            return new PackProtocolException(MessageFormat.format(JGitText.get().invalidAdvertisementOf, str));
        }

        private PackProtocolException duplicateAdvertisement(String str) {
            return new PackProtocolException(MessageFormat.format(JGitText.get().duplicateAdvertisementsOf, str));
        }
    }

    class SmartHttpFetchConnection extends BasePackFetchConnection {
        private MultiRequestService svc;

        SmartHttpFetchConnection(TransportHttp transportHttp, InputStream inputStream) throws TransportException {
            this(inputStream, Collections.emptyList(), new String[0]);
        }

        SmartHttpFetchConnection(InputStream inputStream, Collection<RefSpec> collection, String... strArr) throws TransportException {
            super(TransportHttp.this);
            this.statelessRPC = true;
            init(inputStream, DisabledOutputStream.INSTANCE);
            this.outNeedsEnd = false;
            if (readAdvertisedRefs()) {
                return;
            }
            LongPollService longPollService = TransportHttp.this.new LongPollService("git-upload-pack", getProtocolVersion());
            init(longPollService.getInputStream(), longPollService.getOutputStream());
            lsRefs(collection, strArr);
        }

        @Override // org.eclipse.jgit.transport.BasePackFetchConnection
        protected void doFetch(ProgressMonitor progressMonitor, Collection<Ref> collection, Set<ObjectId> set, OutputStream outputStream) throws Throwable {
            Throwable th;
            MultiRequestService multiRequestService = TransportHttp.this.new MultiRequestService("git-upload-pack", getProtocolVersion());
            this.svc = multiRequestService;
            try {
                InputStream inputStream = multiRequestService.getInputStream();
                try {
                    Service.HttpOutputStream outputStream2 = this.svc.getOutputStream();
                    try {
                        init(inputStream, outputStream2);
                        super.doFetch(progressMonitor, collection, set, outputStream);
                        if (outputStream2 != null) {
                            outputStream2.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        this.svc = null;
                    } catch (Throwable th2) {
                        if (outputStream2 != null) {
                            try {
                                outputStream2.close();
                            } catch (Throwable th3) {
                                th = th2;
                                th = th3;
                                if (th != null) {
                                    if (th != th) {
                                        th.addSuppressed(th);
                                    }
                                    th = th;
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Throwable th4) {
                                        th = th;
                                        th = th4;
                                        try {
                                            if (th == null) {
                                                throw th;
                                            }
                                            if (th != th) {
                                                try {
                                                    th.addSuppressed(th);
                                                } catch (TransportException e) {
                                                    throw e;
                                                } catch (IOException e2) {
                                                    throw new TransportException(e2.getMessage(), e2);
                                                }
                                            }
                                            throw th;
                                        } catch (Throwable th5) {
                                            this.svc = null;
                                            throw th5;
                                        }
                                    }
                                }
                                throw th;
                            }
                        }
                        throw th2;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    th = null;
                }
            } catch (Throwable th7) {
                th = th7;
                th = null;
            }
        }

        @Override // org.eclipse.jgit.transport.BasePackFetchConnection
        protected void onReceivePack() {
            this.svc.finalRequest = true;
        }
    }

    class SmartHttpPushConnection extends BasePackPushConnection {
        SmartHttpPushConnection(InputStream inputStream) throws TransportException {
            super(TransportHttp.this);
            this.statelessRPC = true;
            init(inputStream, DisabledOutputStream.INSTANCE);
            this.outNeedsEnd = false;
            readAdvertisedRefs();
        }

        @Override // org.eclipse.jgit.transport.BasePackPushConnection
        protected void doPush(ProgressMonitor progressMonitor, Map<String, RemoteRefUpdate> map, OutputStream outputStream) throws TransportException {
            MultiRequestService multiRequestService = TransportHttp.this.new MultiRequestService("git-receive-pack", getProtocolVersion());
            Throwable th = null;
            try {
                InputStream inputStream = multiRequestService.getInputStream();
                try {
                    Service.HttpOutputStream outputStream2 = multiRequestService.getOutputStream();
                    try {
                        init(inputStream, outputStream2);
                        super.doPush(progressMonitor, map, outputStream);
                        if (outputStream2 != null) {
                            outputStream2.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    } catch (Throwable th2) {
                        if (outputStream2 == null) {
                            throw th2;
                        }
                        outputStream2.close();
                        throw th2;
                    }
                } catch (Throwable th3) {
                    if (0 == 0) {
                        th = th3;
                    } else if (null != th3) {
                        th.addSuppressed(th3);
                    }
                    if (inputStream == null) {
                        throw th;
                    }
                    inputStream.close();
                    throw th;
                }
            } catch (Throwable th4) {
                if (0 == 0) {
                    throw th4;
                }
                if (null != th4) {
                    try {
                        th.addSuppressed(th4);
                    } catch (TransportException e) {
                        throw e;
                    } catch (IOException e2) {
                        throw new TransportException(e2.getMessage(), e2);
                    }
                }
                throw null;
            }
        }
    }

    abstract class Service {
        private static volatile /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$transport$HttpAuthMethod$Type;
        protected HttpConnection conn;
        protected final HttpExecuteStream execute;
        final UnionInputStream in;
        protected HttpOutputStream out = new HttpOutputStream();
        protected final TransferConfig.ProtocolVersion protocolVersion;
        protected final String requestType;
        protected final String responseType;
        protected final String serviceName;

        abstract void execute() throws IOException;

        static /* synthetic */ int[] $SWITCH_TABLE$org$eclipse$jgit$transport$HttpAuthMethod$Type() {
            int[] iArr = $SWITCH_TABLE$org$eclipse$jgit$transport$HttpAuthMethod$Type;
            if (iArr != null) {
                return iArr;
            }
            int[] iArr2 = new int[HttpAuthMethod.Type.values().length];
            try {
                iArr2[HttpAuthMethod.Type.BASIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr2[HttpAuthMethod.Type.DIGEST.ordinal()] = 3;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr2[HttpAuthMethod.Type.NEGOTIATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[HttpAuthMethod.Type.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            $SWITCH_TABLE$org$eclipse$jgit$transport$HttpAuthMethod$Type = iArr2;
            return iArr2;
        }

        Service(String str, TransferConfig.ProtocolVersion protocolVersion) {
            this.serviceName = str;
            this.protocolVersion = protocolVersion;
            this.requestType = "application/x-" + str + "-request";
            this.responseType = "application/x-" + str + "-result";
            HttpExecuteStream httpExecuteStream = new HttpExecuteStream();
            this.execute = httpExecuteStream;
            this.in = new UnionInputStream(httpExecuteStream);
        }

        void openStream() throws IOException {
            HttpConnection httpConnectionHttpOpen = TransportHttp.this.httpOpen("POST", new URL(TransportHttp.this.baseUrl, this.serviceName), AcceptEncoding.GZIP);
            this.conn = httpConnectionHttpOpen;
            httpConnectionHttpOpen.setInstanceFollowRedirects(false);
            this.conn.setDoOutput(true);
            this.conn.setRequestProperty("Content-Type", this.requestType);
            this.conn.setRequestProperty("Accept", this.responseType);
            if (TransferConfig.ProtocolVersion.V2.equals(this.protocolVersion)) {
                this.conn.setRequestProperty(GitProtocolConstants.PROTOCOL_HEADER, GitProtocolConstants.VERSION_2_REQUEST);
            }
        }

        /* WARN: Code duplicated, block: B:121:0x023a  */
        /* WARN: Code duplicated, block: B:151:0x0155 A[SYNTHETIC] */
        /* WARN: Code duplicated, block: B:158:0x0247 A[SYNTHETIC] */
        /* WARN: Code duplicated, block: B:68:0x0120 A[DONT_INVERT] */
        /* WARN: Code duplicated, block: B:69:0x0122 A[Catch: IOException -> 0x0165, SSLHandshakeException -> 0x0169, InterruptedIOException -> 0x025a, InterruptedIOException | SocketException -> 0x025c, TryCatch #15 {SSLHandshakeException -> 0x0169, IOException -> 0x0165, blocks: (B:66:0x0118, B:69:0x0122, B:72:0x012e, B:74:0x0140, B:75:0x0145, B:76:0x0154, B:77:0x0155, B:78:0x0164), top: B:146:0x0118 }] */
        void sendRequest() throws Throwable {
            Throwable th;
            Throwable th2;
            CredentialsProvider credentialsProvider;
            TemporaryBuffer heap = new TemporaryBuffer.Heap(TransportHttp.this.http.getPostBuffer());
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(heap);
                try {
                    this.out.writeTo(gZIPOutputStream, null);
                    if (this.out.length() < heap.length()) {
                        heap = this.out;
                    }
                    gZIPOutputStream.close();
                    EnumSet enumSetNoneOf = EnumSet.noneOf(HttpAuthMethod.Type.class);
                    int i = 0;
                    HttpAuthMethod httpAuthMethod = null;
                    while (true) {
                        int i2 = 1;
                        while (true) {
                            try {
                                try {
                                    openStream();
                                    if (heap != this.out) {
                                        this.conn.setRequestProperty("Content-Encoding", HttpSupport.ENCODING_GZIP);
                                    }
                                    this.conn.setFixedLengthStreamingMode((int) heap.length());
                                    try {
                                        OutputStream outputStream = this.conn.getOutputStream();
                                        try {
                                            heap.writeTo(outputStream, null);
                                            if (outputStream != null) {
                                                outputStream.close();
                                            }
                                            int iResponse = HttpSupport.response(this.conn);
                                            if (iResponse == 301 || iResponse == 302 || iResponse == 307 || iResponse == 308) {
                                                if (TransportHttp.this.http.getFollowRedirects() != HttpConfig.HttpRedirectMode.TRUE) {
                                                    return;
                                                }
                                                TransportHttp transportHttp = TransportHttp.this;
                                                int i3 = i + 1;
                                                try {
                                                    transportHttp.currentUri = transportHttp.redirect(this.conn.getURL(), this.conn.getHeaderField("Location"), InternalZipConstants.ZIP_FILE_SEPARATOR + this.serviceName, i);
                                                    try {
                                                        TransportHttp transportHttp2 = TransportHttp.this;
                                                        transportHttp2.baseUrl = transportHttp2.toURL(transportHttp2.currentUri);
                                                        i = i3;
                                                    } catch (MalformedURLException e) {
                                                        throw new TransportException(TransportHttp.this.uri, MessageFormat.format(JGitText.get().invalidRedirectLocation, TransportHttp.this.baseUrl, TransportHttp.this.currentUri), e);
                                                    }
                                                } catch (SSLHandshakeException e2) {
                                                    e = e2;
                                                    i = i3;
                                                    TransportHttp.this.handleSslFailure(e);
                                                } catch (IOException e3) {
                                                    e = e3;
                                                    i = i3;
                                                    if (httpAuthMethod != null) {
                                                    }
                                                    if (TransportHttp.this.authMethod.getType() != HttpAuthMethod.Type.NONE) {
                                                        enumSetNoneOf.add(TransportHttp.this.authMethod.getType());
                                                    }
                                                    TransportHttp.this.authMethod = HttpAuthMethod.Type.NONE.method(null);
                                                    httpAuthMethod = TransportHttp.this.authMethod;
                                                }
                                            } else {
                                                if (iResponse != 401) {
                                                    if (iResponse == 403) {
                                                        throw new TransportException(TransportHttp.this.uri, MessageFormat.format(JGitText.get().serviceNotPermitted, TransportHttp.this.baseUrl, this.serviceName));
                                                    }
                                                    if (iResponse != 404) {
                                                        return;
                                                    }
                                                    TransportHttp transportHttp3 = TransportHttp.this;
                                                    throw transportHttp3.createNotFoundException(transportHttp3.uri, this.conn.getURL(), this.conn.getResponseMessage());
                                                }
                                                HttpAuthMethod httpAuthMethodScanResponse = HttpAuthMethod.scanResponse(this.conn, enumSetNoneOf);
                                                int i4 = $SWITCH_TABLE$org$eclipse$jgit$transport$HttpAuthMethod$Type()[httpAuthMethodScanResponse.getType().ordinal()];
                                                if (i4 == 1) {
                                                    throw new TransportException(TransportHttp.this.uri, MessageFormat.format(JGitText.get().authenticationNotSupported, this.conn.getURL()));
                                                }
                                                try {
                                                    if (i4 == 4) {
                                                        enumSetNoneOf.add(HttpAuthMethod.Type.NEGOTIATE);
                                                        if (httpAuthMethod != null) {
                                                            enumSetNoneOf.add(httpAuthMethod.getType());
                                                        }
                                                    } else {
                                                        enumSetNoneOf.add(HttpAuthMethod.Type.NEGOTIATE);
                                                        if (httpAuthMethod == null || httpAuthMethod.getType() != httpAuthMethodScanResponse.getType()) {
                                                            if (httpAuthMethod != null) {
                                                                enumSetNoneOf.add(httpAuthMethod.getType());
                                                            }
                                                        }
                                                        TransportHttp.this.authMethod = httpAuthMethodScanResponse;
                                                        credentialsProvider = TransportHttp.this.getCredentialsProvider();
                                                        if (credentialsProvider != null) {
                                                            throw new TransportException(TransportHttp.this.uri, JGitText.get().noCredentialsProvider);
                                                        }
                                                        if (i2 > 1) {
                                                            credentialsProvider.reset(TransportHttp.this.currentUri);
                                                        }
                                                        if (3 >= i2 || !TransportHttp.this.authMethod.authorize(TransportHttp.this.currentUri, credentialsProvider)) {
                                                            throw new TransportException(TransportHttp.this.uri, JGitText.get().notAuthorized);
                                                        }
                                                        i2++;
                                                        httpAuthMethod = httpAuthMethodScanResponse;
                                                    }
                                                    credentialsProvider = TransportHttp.this.getCredentialsProvider();
                                                    if (credentialsProvider != null) {
                                                        throw new TransportException(TransportHttp.this.uri, JGitText.get().noCredentialsProvider);
                                                    }
                                                    if (i2 > 1) {
                                                        credentialsProvider.reset(TransportHttp.this.currentUri);
                                                    }
                                                    if (3 >= i2) {
                                                    }
                                                    throw new TransportException(TransportHttp.this.uri, JGitText.get().notAuthorized);
                                                } catch (SSLHandshakeException e4) {
                                                    e = e4;
                                                    httpAuthMethod = httpAuthMethodScanResponse;
                                                    TransportHttp.this.handleSslFailure(e);
                                                } catch (IOException e5) {
                                                    e = e5;
                                                    httpAuthMethod = httpAuthMethodScanResponse;
                                                    if (httpAuthMethod != null || TransportHttp.this.authMethod.getType() != HttpAuthMethod.Type.NONE) {
                                                        if (TransportHttp.this.authMethod.getType() != HttpAuthMethod.Type.NONE) {
                                                            enumSetNoneOf.add(TransportHttp.this.authMethod.getType());
                                                        }
                                                        TransportHttp.this.authMethod = HttpAuthMethod.Type.NONE.method(null);
                                                        httpAuthMethod = TransportHttp.this.authMethod;
                                                    } else {
                                                        throw e;
                                                    }
                                                }
                                                i2 = 1;
                                                TransportHttp.this.authMethod = httpAuthMethodScanResponse;
                                            }
                                        } catch (Throwable th3) {
                                            th2 = th3;
                                            if (outputStream != null) {
                                                try {
                                                    outputStream.close();
                                                } catch (Throwable th4) {
                                                    th = th4;
                                                    if (th2 == null) {
                                                        throw th;
                                                    }
                                                    if (th2 != th) {
                                                        th2.addSuppressed(th);
                                                    }
                                                    throw th2;
                                                }
                                            }
                                            throw th2;
                                        }
                                    } catch (Throwable th5) {
                                        th = th5;
                                        th2 = null;
                                    }
                                } catch (SSLHandshakeException e6) {
                                    e = e6;
                                } catch (IOException e7) {
                                    e = e7;
                                }
                            } catch (InterruptedIOException | SocketException e8) {
                                throw e8;
                            }
                        }
                        TransportHttp.this.authMethod = HttpAuthMethod.Type.NONE.method(null);
                        httpAuthMethod = TransportHttp.this.authMethod;
                    }
                } catch (Throwable th6) {
                    try {
                        gZIPOutputStream.close();
                        throw th6;
                    } catch (Throwable th7) {
                        th = th6;
                        th = th7;
                        if (th == null) {
                            throw th;
                        }
                        if (th != th) {
                            try {
                                th.addSuppressed(th);
                            } catch (IOException unused) {
                                heap = this.out;
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th8) {
                th = th8;
                th = null;
            }
        }

        void openResponse() throws IOException {
            int iResponse = HttpSupport.response(this.conn);
            if (iResponse != 200) {
                throw new TransportException(TransportHttp.this.uri, iResponse + " " + this.conn.getResponseMessage());
            }
            String contentType = this.conn.getContentType();
            if (this.responseType.equals(contentType)) {
                return;
            }
            this.conn.getInputStream().close();
            throw TransportHttp.this.wrongContentType(this.responseType, contentType);
        }

        HttpOutputStream getOutputStream() {
            return this.out;
        }

        InputStream getInputStream() {
            return this.in;
        }

        class HttpExecuteStream extends InputStream {
            HttpExecuteStream() {
            }

            @Override // java.io.InputStream
            public int read() throws IOException {
                Service.this.execute();
                return -1;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) throws IOException {
                Service.this.execute();
                return -1;
            }

            @Override // java.io.InputStream
            public long skip(long j) throws IOException {
                Service.this.execute();
                return 0L;
            }
        }

        class HttpOutputStream extends TemporaryBuffer {
            HttpOutputStream() {
                super(TransportHttp.this.http.getPostBuffer());
            }

            @Override // org.eclipse.jgit.util.TemporaryBuffer
            protected OutputStream overflow() throws IOException {
                Service.this.openStream();
                Service.this.conn.setChunkedStreamingMode(0);
                return Service.this.conn.getOutputStream();
            }
        }
    }

    class MultiRequestService extends Service {
        boolean finalRequest;

        MultiRequestService(String str, TransferConfig.ProtocolVersion protocolVersion) {
            super(str, protocolVersion);
        }

        @Override // org.eclipse.jgit.transport.TransportHttp.Service
        void execute() throws IOException {
            this.out.close();
            if (this.conn == null) {
                if (this.out.length() == 0) {
                    if (!this.finalRequest) {
                        throw new TransportException(TransportHttp.this.uri, JGitText.get().startingReadStageWithoutWrittenRequestDataPendingIsNotSupported);
                    }
                    return;
                }
                sendRequest();
            }
            this.out.reset();
            openResponse();
            this.in.add(TransportHttp.this.openInputStream(this.conn));
            if (!this.finalRequest) {
                this.in.add(this.execute);
            }
            this.conn = null;
        }
    }

    class LongPollService extends Service {
        LongPollService(String str, TransferConfig.ProtocolVersion protocolVersion) {
            super(str, protocolVersion);
        }

        @Override // org.eclipse.jgit.transport.TransportHttp.Service
        void execute() throws IOException {
            this.out.close();
            if (this.conn == null) {
                sendRequest();
            }
            openResponse();
            this.in.add(TransportHttp.this.openInputStream(this.conn));
        }
    }
}
