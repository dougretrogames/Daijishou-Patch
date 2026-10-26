package com.google.api.client.googleapis.services;

import com.google.api.client.googleapis.batch.BatchRequest;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.util.ObjectParser;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Strings;
import com.google.api.services.kgsearch.v1.Kgsearch;
import com.google.auth.Credentials;
import com.google.auth.http.HttpCredentialsAdapter;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.lingala.zip4j.util.InternalZipConstants;
import org.eclipse.jgit.lib.BranchConfig;

/* INFO: loaded from: classes3.dex */
public abstract class AbstractGoogleClient {
    private static final String GOOGLE_CLOUD_UNIVERSE_DOMAIN = "GOOGLE_CLOUD_UNIVERSE_DOMAIN";
    private static final Logger logger = Logger.getLogger(AbstractGoogleClient.class.getName());
    private final String applicationName;
    private final String batchPath;
    private final GoogleClientRequestInitializer googleClientRequestInitializer;
    private final HttpRequestInitializer httpRequestInitializer;
    private final ObjectParser objectParser;
    private final HttpRequestFactory requestFactory;
    private final String rootUrl;
    private final String servicePath;
    private final boolean suppressPatternChecks;
    private final boolean suppressRequiredParameterChecks;
    private final String universeDomain;

    protected AbstractGoogleClient(Builder builder) {
        HttpRequestFactory httpRequestFactoryCreateRequestFactory;
        this.googleClientRequestInitializer = builder.googleClientRequestInitializer;
        this.universeDomain = determineUniverseDomain(builder);
        this.rootUrl = normalizeRootUrl(determineEndpoint(builder));
        this.servicePath = normalizeServicePath(builder.servicePath);
        this.batchPath = builder.batchPath;
        if (Strings.isNullOrEmpty(builder.applicationName)) {
            logger.warning("Application name is not set. Call Builder#setApplicationName.");
        }
        this.applicationName = builder.applicationName;
        if (builder.httpRequestInitializer == null) {
            httpRequestFactoryCreateRequestFactory = builder.transport.createRequestFactory();
        } else {
            httpRequestFactoryCreateRequestFactory = builder.transport.createRequestFactory(builder.httpRequestInitializer);
        }
        this.requestFactory = httpRequestFactoryCreateRequestFactory;
        this.objectParser = builder.objectParser;
        this.suppressPatternChecks = builder.suppressPatternChecks;
        this.suppressRequiredParameterChecks = builder.suppressRequiredParameterChecks;
        this.httpRequestInitializer = builder.httpRequestInitializer;
    }

    private String determineUniverseDomain(Builder builder) {
        String str = builder.universeDomain;
        if (str == null) {
            str = System.getenv(GOOGLE_CLOUD_UNIVERSE_DOMAIN);
        }
        return str == null ? Credentials.GOOGLE_DEFAULT_UNIVERSE : str;
    }

    private String determineEndpoint(Builder builder) {
        boolean zContains = builder.rootUrl.contains(".mtls.");
        if (zContains && !this.universeDomain.equals(Credentials.GOOGLE_DEFAULT_UNIVERSE)) {
            throw new IllegalStateException("mTLS is not supported in any universe other than googleapis.com");
        }
        if (builder.isUserConfiguredEndpoint || builder.serviceName == null) {
            return builder.rootUrl;
        }
        return zContains ? "https://" + builder.serviceName + ".mtls." + this.universeDomain + InternalZipConstants.ZIP_FILE_SEPARATOR : "https://" + builder.serviceName + BranchConfig.LOCAL_REPOSITORY + this.universeDomain + InternalZipConstants.ZIP_FILE_SEPARATOR;
    }

    public void validateUniverseDomain() throws IOException {
        HttpRequestInitializer httpRequestInitializer = this.httpRequestInitializer;
        if (httpRequestInitializer instanceof HttpCredentialsAdapter) {
            String universeDomain = ((HttpCredentialsAdapter) httpRequestInitializer).getCredentials().getUniverseDomain();
            if (!universeDomain.equals(getUniverseDomain())) {
                throw new IllegalStateException(String.format("The configured universe domain (%s) does not match the universe domain found in the credentials (%s). If you haven't configured the universe domain explicitly, `googleapis.com` is the default.", getUniverseDomain(), universeDomain));
            }
        }
    }

    public final String getRootUrl() {
        return this.rootUrl;
    }

    public final String getServicePath() {
        return this.servicePath;
    }

    public final String getBaseUrl() {
        return this.rootUrl + this.servicePath;
    }

    public final String getApplicationName() {
        return this.applicationName;
    }

    public final HttpRequestFactory getRequestFactory() {
        return this.requestFactory;
    }

    public final GoogleClientRequestInitializer getGoogleClientRequestInitializer() {
        return this.googleClientRequestInitializer;
    }

    public final String getUniverseDomain() {
        return this.universeDomain;
    }

    public ObjectParser getObjectParser() {
        return this.objectParser;
    }

    protected void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
        validateUniverseDomain();
        if (getGoogleClientRequestInitializer() != null) {
            getGoogleClientRequestInitializer().initialize(abstractGoogleClientRequest);
        }
    }

    public final BatchRequest batch() {
        return batch(null);
    }

    public final BatchRequest batch(HttpRequestInitializer httpRequestInitializer) {
        BatchRequest batchRequest = new BatchRequest(getRequestFactory().getTransport(), httpRequestInitializer);
        if (Strings.isNullOrEmpty(this.batchPath)) {
            batchRequest.setBatchUrl(new GenericUrl(getRootUrl() + Kgsearch.DEFAULT_BATCH_PATH));
            return batchRequest;
        }
        batchRequest.setBatchUrl(new GenericUrl(getRootUrl() + this.batchPath));
        return batchRequest;
    }

    public final boolean getSuppressPatternChecks() {
        return this.suppressPatternChecks;
    }

    public final boolean getSuppressRequiredParameterChecks() {
        return this.suppressRequiredParameterChecks;
    }

    static String normalizeRootUrl(String str) {
        Preconditions.checkNotNull(str, "root URL cannot be null.");
        return !str.endsWith(InternalZipConstants.ZIP_FILE_SEPARATOR) ? str + InternalZipConstants.ZIP_FILE_SEPARATOR : str;
    }

    static String normalizeServicePath(String str) {
        Preconditions.checkNotNull(str, "service path cannot be null");
        if (str.length() == 1) {
            Preconditions.checkArgument(InternalZipConstants.ZIP_FILE_SEPARATOR.equals(str), "service path must equal \"/\" if it is of length 1.");
            return "";
        }
        if (str.length() <= 0) {
            return str;
        }
        if (!str.endsWith(InternalZipConstants.ZIP_FILE_SEPARATOR)) {
            str = str + InternalZipConstants.ZIP_FILE_SEPARATOR;
        }
        return str.startsWith(InternalZipConstants.ZIP_FILE_SEPARATOR) ? str.substring(1) : str;
    }

    public static abstract class Builder {
        String applicationName;
        String batchPath;
        Pattern defaultEndpointRegex = Pattern.compile("https://([a-zA-Z]*)(\\.mtls)?\\.googleapis.com/?");
        GoogleClientRequestInitializer googleClientRequestInitializer;
        HttpRequestInitializer httpRequestInitializer;
        boolean isUserConfiguredEndpoint;
        final ObjectParser objectParser;
        String rootUrl;
        String serviceName;
        String servicePath;
        boolean suppressPatternChecks;
        boolean suppressRequiredParameterChecks;
        final HttpTransport transport;
        String universeDomain;

        public abstract AbstractGoogleClient build();

        protected Builder(HttpTransport httpTransport, String str, String str2, ObjectParser objectParser, HttpRequestInitializer httpRequestInitializer) {
            this.transport = (HttpTransport) Preconditions.checkNotNull(httpTransport);
            this.objectParser = objectParser;
            this.rootUrl = AbstractGoogleClient.normalizeRootUrl(str);
            this.servicePath = AbstractGoogleClient.normalizeServicePath(str2);
            this.httpRequestInitializer = httpRequestInitializer;
            Matcher matcher = this.defaultEndpointRegex.matcher(str);
            boolean zMatches = matcher.matches();
            this.isUserConfiguredEndpoint = !zMatches;
            this.serviceName = zMatches ? matcher.group(1) : null;
        }

        public final HttpTransport getTransport() {
            return this.transport;
        }

        public ObjectParser getObjectParser() {
            return this.objectParser;
        }

        public final String getRootUrl() {
            return this.rootUrl;
        }

        public Builder setRootUrl(String str) {
            this.isUserConfiguredEndpoint = true;
            this.rootUrl = AbstractGoogleClient.normalizeRootUrl(str);
            return this;
        }

        public final String getServicePath() {
            return this.servicePath;
        }

        public Builder setServicePath(String str) {
            this.servicePath = AbstractGoogleClient.normalizeServicePath(str);
            return this;
        }

        public Builder setBatchPath(String str) {
            this.batchPath = str;
            return this;
        }

        public final GoogleClientRequestInitializer getGoogleClientRequestInitializer() {
            return this.googleClientRequestInitializer;
        }

        public Builder setGoogleClientRequestInitializer(GoogleClientRequestInitializer googleClientRequestInitializer) {
            this.googleClientRequestInitializer = googleClientRequestInitializer;
            return this;
        }

        public final HttpRequestInitializer getHttpRequestInitializer() {
            return this.httpRequestInitializer;
        }

        public Builder setHttpRequestInitializer(HttpRequestInitializer httpRequestInitializer) {
            this.httpRequestInitializer = httpRequestInitializer;
            return this;
        }

        public final String getApplicationName() {
            return this.applicationName;
        }

        public Builder setApplicationName(String str) {
            this.applicationName = str;
            return this;
        }

        public final boolean getSuppressPatternChecks() {
            return this.suppressPatternChecks;
        }

        public Builder setSuppressPatternChecks(boolean z) {
            this.suppressPatternChecks = z;
            return this;
        }

        public final boolean getSuppressRequiredParameterChecks() {
            return this.suppressRequiredParameterChecks;
        }

        public Builder setSuppressRequiredParameterChecks(boolean z) {
            this.suppressRequiredParameterChecks = z;
            return this;
        }

        public Builder setSuppressAllChecks(boolean z) {
            return setSuppressPatternChecks(true).setSuppressRequiredParameterChecks(true);
        }

        public Builder setUniverseDomain(String str) {
            if (str != null && str.isEmpty()) {
                throw new IllegalArgumentException("The universe domain value cannot be empty.");
            }
            this.universeDomain = str;
            return this;
        }

        String getServiceName() {
            return this.serviceName;
        }
    }
}
