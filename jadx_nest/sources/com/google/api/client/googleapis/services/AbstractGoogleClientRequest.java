package com.google.api.client.googleapis.services;

import com.google.api.client.googleapis.GoogleUtils;
import com.google.api.client.googleapis.MethodOverride;
import com.google.api.client.googleapis.batch.BatchCallback;
import com.google.api.client.googleapis.batch.BatchRequest;
import com.google.api.client.googleapis.media.MediaHttpDownloader;
import com.google.api.client.googleapis.media.MediaHttpUploader;
import com.google.api.client.http.AbstractInputStreamContent;
import com.google.api.client.http.EmptyContent;
import com.google.api.client.http.GZipEncoding;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.HttpResponseInterceptor;
import com.google.api.client.http.UriTemplate;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Preconditions;
import com.google.common.base.Joiner;
import com.google.common.base.StandardSystemProperty;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractGoogleClientRequest<T> extends GenericData {
    private static final String API_CLIENT_HEADER = "X-Goog-Api-Client";
    protected static final String API_VERSION_HEADER = "X-Goog-Api-Version";
    public static final String USER_AGENT_SUFFIX = "Google-API-Java-Client";
    private final AbstractGoogleClient abstractGoogleClient;
    private boolean disableGZipContent;
    private MediaHttpDownloader downloader;
    private final HttpContent httpContent;
    private HttpHeaders lastResponseHeaders;
    private String lastStatusMessage;
    private final String requestMethod;
    private Class<T> responseClass;
    private boolean returnRawInputStream;
    private MediaHttpUploader uploader;
    private final String uriTemplate;
    private HttpHeaders requestHeaders = new HttpHeaders();
    private int lastStatusCode = -1;

    protected AbstractGoogleClientRequest(AbstractGoogleClient abstractGoogleClient, String str, String str2, HttpContent httpContent, Class<T> cls) {
        this.responseClass = (Class) Preconditions.checkNotNull(cls);
        this.abstractGoogleClient = (AbstractGoogleClient) Preconditions.checkNotNull(abstractGoogleClient);
        this.requestMethod = (String) Preconditions.checkNotNull(str);
        this.uriTemplate = (String) Preconditions.checkNotNull(str2);
        this.httpContent = httpContent;
        String applicationName = abstractGoogleClient.getApplicationName();
        if (applicationName != null) {
            this.requestHeaders.setUserAgent(applicationName + " Google-API-Java-Client/" + GoogleUtils.VERSION);
        } else {
            this.requestHeaders.setUserAgent("Google-API-Java-Client/" + GoogleUtils.VERSION);
        }
        this.requestHeaders.set(API_CLIENT_HEADER, (Object) ApiClientVersion.DEFAULT_VERSION);
    }

    static class ApiClientVersion {
        static final String DEFAULT_VERSION = new ApiClientVersion().toString();
        private final String versionString;

        ApiClientVersion() {
            this(getJavaVersion(), StandardSystemProperty.OS_NAME.value(), StandardSystemProperty.OS_VERSION.value(), GoogleUtils.VERSION);
        }

        ApiClientVersion(String str, String str2, String str3, String str4) {
            StringBuilder sb = new StringBuilder("gl-java/");
            sb.append(formatSemver(str));
            sb.append(" gdcl/");
            sb.append(formatSemver(str4));
            if (str2 != null && str3 != null) {
                sb.append(" ");
                sb.append(formatName(str2));
                sb.append(InternalZipConstants.ZIP_FILE_SEPARATOR);
                sb.append(formatSemver(str3));
            }
            this.versionString = sb.toString();
        }

        public String toString() {
            String property = System.getProperty("org.graalvm.nativeimage.imagecode");
            if (property != null && property.equals("runtime")) {
                String[] strArrSplit = this.versionString.split(" ");
                if (strArrSplit.length > 0 && strArrSplit[0].startsWith("gl-java")) {
                    strArrSplit[0] = strArrSplit[0] + "-graalvm";
                    return Joiner.on(" ").join(strArrSplit);
                }
            }
            return this.versionString;
        }

        private static String getJavaVersion() {
            String property = System.getProperty("java.version");
            if (property == null) {
                return null;
            }
            String semver = formatSemver(property, null);
            if (semver != null) {
                return semver;
            }
            Matcher matcher = Pattern.compile("^(\\d+)[^\\d]?").matcher(property);
            if (matcher.find()) {
                return matcher.group(1) + ".0.0";
            }
            return null;
        }

        private static String formatName(String str) {
            return str.toLowerCase().replaceAll("[^\\w\\d\\-]", "-");
        }

        private static String formatSemver(String str) {
            return formatSemver(str, str);
        }

        private static String formatSemver(String str, String str2) {
            if (str == null) {
                return null;
            }
            Matcher matcher = Pattern.compile("(\\d+\\.\\d+\\.\\d+).*").matcher(str);
            return matcher.find() ? matcher.group(1) : str2;
        }
    }

    public final boolean getDisableGZipContent() {
        return this.disableGZipContent;
    }

    public final boolean getReturnRawInputSteam() {
        return this.returnRawInputStream;
    }

    public AbstractGoogleClientRequest<T> setDisableGZipContent(boolean z) {
        this.disableGZipContent = z;
        return this;
    }

    public AbstractGoogleClientRequest<T> setReturnRawInputStream(boolean z) {
        this.returnRawInputStream = z;
        return this;
    }

    public final String getRequestMethod() {
        return this.requestMethod;
    }

    public final String getUriTemplate() {
        return this.uriTemplate;
    }

    public final HttpContent getHttpContent() {
        return this.httpContent;
    }

    public AbstractGoogleClient getAbstractGoogleClient() {
        return this.abstractGoogleClient;
    }

    public final HttpHeaders getRequestHeaders() {
        return this.requestHeaders;
    }

    public AbstractGoogleClientRequest<T> setRequestHeaders(HttpHeaders httpHeaders) {
        this.requestHeaders = httpHeaders;
        return this;
    }

    String getApiVersionHeader() {
        return (String) this.requestHeaders.get(API_VERSION_HEADER);
    }

    public final HttpHeaders getLastResponseHeaders() {
        return this.lastResponseHeaders;
    }

    public final int getLastStatusCode() {
        return this.lastStatusCode;
    }

    public final String getLastStatusMessage() {
        return this.lastStatusMessage;
    }

    public final Class<T> getResponseClass() {
        return this.responseClass;
    }

    public final MediaHttpUploader getMediaHttpUploader() {
        return this.uploader;
    }

    protected final void initializeMediaUpload(AbstractInputStreamContent abstractInputStreamContent) {
        HttpRequestFactory requestFactory = this.abstractGoogleClient.getRequestFactory();
        MediaHttpUploader mediaHttpUploader = new MediaHttpUploader(abstractInputStreamContent, requestFactory.getTransport(), mediaUploadRequestUserAgentInitializer(this.abstractGoogleClient.getApplicationName(), requestFactory.getInitializer()));
        this.uploader = mediaHttpUploader;
        mediaHttpUploader.setInitiationRequestMethod(this.requestMethod);
        HttpContent httpContent = this.httpContent;
        if (httpContent != null) {
            this.uploader.setMetadata(httpContent);
        }
    }

    /* JADX INFO: renamed from: com.google.api.client.googleapis.services.AbstractGoogleClientRequest$1, reason: invalid class name */
    static class AnonymousClass1 implements HttpRequestInitializer {
        final /* synthetic */ String val$applicationName;

        AnonymousClass1(String str) {
            this.val$applicationName = str;
        }

        @Override // com.google.api.client.http.HttpRequestInitializer
        public void initialize(HttpRequest httpRequest) {
            httpRequest.getHeaders().setUserAgent(this.val$applicationName);
        }
    }

    private static HttpRequestInitializer mediaUploadRequestUserAgentInitializer(String str, HttpRequestInitializer httpRequestInitializer) {
        if (str == null) {
            return httpRequestInitializer;
        }
        if (httpRequestInitializer == null) {
            return new AnonymousClass1(str);
        }
        return new AnonymousClass2(httpRequestInitializer, str);
    }

    /* JADX INFO: renamed from: com.google.api.client.googleapis.services.AbstractGoogleClientRequest$2, reason: invalid class name */
    static class AnonymousClass2 implements HttpRequestInitializer {
        final /* synthetic */ String val$applicationName;
        final /* synthetic */ HttpRequestInitializer val$originalInitializer;

        AnonymousClass2(HttpRequestInitializer httpRequestInitializer, String str) {
            this.val$originalInitializer = httpRequestInitializer;
            this.val$applicationName = str;
        }

        @Override // com.google.api.client.http.HttpRequestInitializer
        public void initialize(HttpRequest httpRequest) throws IOException {
            this.val$originalInitializer.initialize(httpRequest);
            httpRequest.getHeaders().setUserAgent(this.val$applicationName);
        }
    }

    public final MediaHttpDownloader getMediaHttpDownloader() {
        return this.downloader;
    }

    protected final void initializeMediaDownload() {
        HttpRequestFactory requestFactory = this.abstractGoogleClient.getRequestFactory();
        this.downloader = new MediaHttpDownloader(requestFactory.getTransport(), requestFactory.getInitializer());
    }

    public GenericUrl buildHttpRequestUrl() {
        return new GenericUrl(UriTemplate.expand(this.abstractGoogleClient.getBaseUrl(), this.uriTemplate, this, true));
    }

    public HttpRequest buildHttpRequest() throws IOException {
        return buildHttpRequest(false);
    }

    protected HttpRequest buildHttpRequestUsingHead() throws IOException {
        return buildHttpRequest(true);
    }

    private HttpRequest buildHttpRequest(boolean z) throws IOException {
        boolean z2 = true;
        Preconditions.checkArgument(this.uploader == null);
        if (z && !this.requestMethod.equals("GET")) {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        HttpRequest httpRequestBuildRequest = getAbstractGoogleClient().getRequestFactory().buildRequest(z ? "HEAD" : this.requestMethod, buildHttpRequestUrl(), this.httpContent);
        new MethodOverride().intercept(httpRequestBuildRequest);
        httpRequestBuildRequest.setParser(getAbstractGoogleClient().getObjectParser());
        if (this.httpContent == null && (this.requestMethod.equals("POST") || this.requestMethod.equals("PUT") || this.requestMethod.equals("PATCH"))) {
            httpRequestBuildRequest.setContent(new EmptyContent());
        }
        httpRequestBuildRequest.getHeaders().putAll(this.requestHeaders);
        if (!this.disableGZipContent) {
            httpRequestBuildRequest.setEncoding(new GZipEncoding());
        }
        httpRequestBuildRequest.setResponseReturnRawInputStream(this.returnRawInputStream);
        httpRequestBuildRequest.setResponseInterceptor(new AnonymousClass3(httpRequestBuildRequest.getResponseInterceptor(), httpRequestBuildRequest));
        return httpRequestBuildRequest;
    }

    /* JADX INFO: renamed from: com.google.api.client.googleapis.services.AbstractGoogleClientRequest$3, reason: invalid class name */
    class AnonymousClass3 implements HttpResponseInterceptor {
        final /* synthetic */ HttpRequest val$httpRequest;
        final /* synthetic */ HttpResponseInterceptor val$responseInterceptor;

        AnonymousClass3(HttpResponseInterceptor httpResponseInterceptor, HttpRequest httpRequest) {
            this.val$responseInterceptor = httpResponseInterceptor;
            this.val$httpRequest = httpRequest;
        }

        @Override // com.google.api.client.http.HttpResponseInterceptor
        public void interceptResponse(HttpResponse httpResponse) throws IOException {
            HttpResponseInterceptor httpResponseInterceptor = this.val$responseInterceptor;
            if (httpResponseInterceptor != null) {
                httpResponseInterceptor.interceptResponse(httpResponse);
            }
            if (!httpResponse.isSuccessStatusCode() && this.val$httpRequest.getThrowExceptionOnExecuteError()) {
                throw AbstractGoogleClientRequest.this.newExceptionOnError(httpResponse);
            }
        }
    }

    public HttpResponse executeUnparsed() throws IOException {
        return executeUnparsed(false);
    }

    protected HttpResponse executeMedia() throws IOException {
        set("alt", (Object) "media");
        return executeUnparsed();
    }

    protected HttpResponse executeUsingHead() throws IOException {
        Preconditions.checkArgument(this.uploader == null);
        HttpResponse httpResponseExecuteUnparsed = executeUnparsed(true);
        httpResponseExecuteUnparsed.ignore();
        return httpResponseExecuteUnparsed;
    }

    private HttpResponse executeUnparsed(boolean z) throws IOException {
        HttpResponse httpResponseUpload;
        if (this.uploader == null) {
            httpResponseUpload = buildHttpRequest(z).execute();
        } else {
            GenericUrl genericUrlBuildHttpRequestUrl = buildHttpRequestUrl();
            boolean throwExceptionOnExecuteError = getAbstractGoogleClient().getRequestFactory().buildRequest(this.requestMethod, genericUrlBuildHttpRequestUrl, this.httpContent).getThrowExceptionOnExecuteError();
            httpResponseUpload = this.uploader.setInitiationHeaders(this.requestHeaders).setDisableGZipContent(this.disableGZipContent).upload(genericUrlBuildHttpRequestUrl);
            httpResponseUpload.getRequest().setParser(getAbstractGoogleClient().getObjectParser());
            if (throwExceptionOnExecuteError && !httpResponseUpload.isSuccessStatusCode()) {
                throw newExceptionOnError(httpResponseUpload);
            }
        }
        this.lastResponseHeaders = httpResponseUpload.getHeaders();
        this.lastStatusCode = httpResponseUpload.getStatusCode();
        this.lastStatusMessage = httpResponseUpload.getStatusMessage();
        return httpResponseUpload;
    }

    protected IOException newExceptionOnError(HttpResponse httpResponse) {
        return new HttpResponseException(httpResponse);
    }

    public T execute() throws IOException {
        return (T) executeUnparsed().parseAs((Class) this.responseClass);
    }

    public InputStream executeAsInputStream() throws IOException {
        return executeUnparsed().getContent();
    }

    protected InputStream executeMediaAsInputStream() throws IOException {
        return executeMedia().getContent();
    }

    public void executeAndDownloadTo(OutputStream outputStream) throws IOException {
        executeUnparsed().download(outputStream);
    }

    protected void executeMediaAndDownloadTo(OutputStream outputStream) throws IOException {
        MediaHttpDownloader mediaHttpDownloader = this.downloader;
        if (mediaHttpDownloader == null) {
            executeMedia().download(outputStream);
        } else {
            mediaHttpDownloader.download(buildHttpRequestUrl(), this.requestHeaders, outputStream);
        }
    }

    public final <E> void queue(BatchRequest batchRequest, Class<E> cls, BatchCallback<T, E> batchCallback) throws IOException {
        Preconditions.checkArgument(this.uploader == null, "Batching media requests is not supported");
        batchRequest.queue(buildHttpRequest(), getResponseClass(), cls, batchCallback);
    }

    @Override // com.google.api.client.util.GenericData
    public AbstractGoogleClientRequest<T> set(String str, Object obj) {
        return (AbstractGoogleClientRequest) super.set(str, obj);
    }

    protected final void checkRequiredParameter(Object obj, String str) {
        Preconditions.checkArgument(this.abstractGoogleClient.getSuppressRequiredParameterChecks() || obj != null, "Required parameter %s must be specified", str);
    }
}
