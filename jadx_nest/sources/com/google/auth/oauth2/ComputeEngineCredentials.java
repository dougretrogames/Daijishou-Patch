package com.google.auth.oauth2;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.util.GenericData;
import com.google.auth.Credentials;
import com.google.auth.ServiceAccountSigner;
import com.google.auth.http.HttpTransportFactory;
import com.google.common.base.Joiner;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableSet;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: loaded from: classes3.dex */
public class ComputeEngineCredentials extends GoogleCredentials implements ServiceAccountSigner, IdTokenProvider {
    static final int COMPUTE_PING_CONNECTION_TIMEOUT_MS = 500;
    static final String DEFAULT_METADATA_SERVER_URL = "http://metadata.google.internal";
    private static final String GOOGLE = "Google";
    private static final String LINUX = "linux";
    static final int MAX_COMPUTE_PING_TRIES = 3;
    private static final String METADATA_FLAVOR = "Metadata-Flavor";
    private static final String PARSE_ERROR_ACCOUNT = "Error parsing service account response. ";
    private static final String PARSE_ERROR_PREFIX = "Error parsing token refresh response. ";
    static final String SIGN_BLOB_URL_FORMAT = "https://iamcredentials.googleapis.com/v1/projects/-/serviceAccounts/%s:signBlob";
    private static final String WINDOWS = "windows";
    private static final long serialVersionUID = -4113476462526554235L;
    private final Collection<String> scopes;
    private transient String serviceAccountEmail;
    private transient HttpTransportFactory transportFactory;
    private final String transportFactoryClassName;
    private String universeDomainFromMetadata;
    static final Duration COMPUTE_EXPIRATION_MARGIN = Duration.ofMinutes(3);
    static final Duration COMPUTE_REFRESH_MARGIN = Duration.ofMinutes(3).plusSeconds(45);
    private static final Logger LOGGER = Logger.getLogger(ComputeEngineCredentials.class.getName());

    /* synthetic */ ComputeEngineCredentials(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private ComputeEngineCredentials(Builder builder) {
        super(builder);
        this.universeDomainFromMetadata = null;
        HttpTransportFactory httpTransportFactory = (HttpTransportFactory) MoreObjects.firstNonNull(builder.getHttpTransportFactory(), getFromServiceLoader(HttpTransportFactory.class, OAuth2Utils.HTTP_TRANSPORT_FACTORY));
        this.transportFactory = httpTransportFactory;
        this.transportFactoryClassName = httpTransportFactory.getClass().getName();
        Collection<String> defaultScopes = builder.scopes;
        defaultScopes = (defaultScopes == null || defaultScopes.isEmpty()) ? builder.getDefaultScopes() : defaultScopes;
        if (defaultScopes == null) {
            this.scopes = ImmutableSet.of();
            return;
        }
        ArrayList arrayList = new ArrayList(defaultScopes);
        arrayList.removeAll(Arrays.asList("", null));
        this.scopes = ImmutableSet.copyOf((Collection) arrayList);
    }

    @Override // com.google.auth.oauth2.GoogleCredentials
    public GoogleCredentials createScoped(Collection<String> collection) {
        return new ComputeEngineCredentials(toBuilder().setHttpTransportFactory(this.transportFactory).setScopes(collection));
    }

    @Override // com.google.auth.oauth2.GoogleCredentials
    public GoogleCredentials createScoped(Collection<String> collection, Collection<String> collection2) {
        return new ComputeEngineCredentials(newBuilder().setHttpTransportFactory(this.transportFactory).setScopes(collection).setDefaultScopes(collection2));
    }

    public static ComputeEngineCredentials create() {
        return new ComputeEngineCredentials(newBuilder());
    }

    public final Collection<String> getScopes() {
        return this.scopes;
    }

    String createTokenUrlWithScopes() {
        GenericUrl genericUrl = new GenericUrl(getTokenServerEncodedUrl());
        if (!this.scopes.isEmpty()) {
            genericUrl.set("scopes", (Object) Joiner.on(AbstractJsonLexerKt.COMMA).join(this.scopes));
        }
        return genericUrl.toString();
    }

    @Override // com.google.auth.oauth2.GoogleCredentials, com.google.auth.Credentials
    public String getUniverseDomain() throws IOException {
        if (isExplicitUniverseDomain()) {
            return super.getUniverseDomain();
        }
        synchronized (this) {
            String str = this.universeDomainFromMetadata;
            if (str != null) {
                return str;
            }
            String universeDomainFromMetadata = getUniverseDomainFromMetadata();
            synchronized (this) {
                this.universeDomainFromMetadata = universeDomainFromMetadata;
            }
            return universeDomainFromMetadata;
        }
    }

    private String getUniverseDomainFromMetadata() throws IOException {
        HttpResponse metadataResponse = getMetadataResponse(getUniverseDomainUrl());
        int statusCode = metadataResponse.getStatusCode();
        if (statusCode == 404) {
            return Credentials.GOOGLE_DEFAULT_UNIVERSE;
        }
        if (statusCode != 200) {
            throw new GoogleAuthException(true, new IOException(String.format("Unexpected Error code %s trying to get universe domain from Compute Engine metadata for the default service account: %s", Integer.valueOf(statusCode), metadataResponse.parseAsString())));
        }
        String asString = metadataResponse.parseAsString();
        return asString.isEmpty() ? Credentials.GOOGLE_DEFAULT_UNIVERSE : asString;
    }

    @Override // com.google.auth.oauth2.OAuth2Credentials
    public AccessToken refreshAccessToken() throws IOException {
        HttpResponse metadataResponse = getMetadataResponse(createTokenUrlWithScopes());
        int statusCode = metadataResponse.getStatusCode();
        if (statusCode == 404) {
            throw new IOException(String.format("Error code %s trying to get security access token from Compute Engine metadata for the default service account. This may be because the virtual machine instance does not have permission scopes specified. It is possible to skip checking for Compute Engine metadata by specifying the environment  variable NO_GCE_CHECK=true.", Integer.valueOf(statusCode)));
        }
        if (statusCode != 200) {
            throw new IOException(String.format("Unexpected Error code %s trying to get security access token from Compute Engine metadata for the default service account: %s", Integer.valueOf(statusCode), metadataResponse.parseAsString()));
        }
        if (metadataResponse.getContent() == null) {
            throw new IOException("Empty content from metadata token server request.");
        }
        GenericData genericData = (GenericData) metadataResponse.parseAs(GenericData.class);
        return new AccessToken(OAuth2Utils.validateString(genericData, "access_token", PARSE_ERROR_PREFIX), new Date(this.clock.currentTimeMillis() + ((long) (OAuth2Utils.validateInt32(genericData, "expires_in", PARSE_ERROR_PREFIX) * 1000))));
    }

    @Override // com.google.auth.oauth2.IdTokenProvider
    public IdToken idTokenWithAudience(String str, List<IdTokenProvider.Option> list) throws IOException {
        GenericUrl genericUrl = new GenericUrl(getIdentityDocumentUrl());
        if (list != null) {
            if (list.contains(IdTokenProvider.Option.FORMAT_FULL)) {
                genericUrl.set(ConfigConstants.CONFIG_KEY_FORMAT, (Object) "full");
            }
            if (list.contains(IdTokenProvider.Option.LICENSES_TRUE)) {
                genericUrl.set(ConfigConstants.CONFIG_KEY_FORMAT, (Object) "full");
                genericUrl.set("license", (Object) "TRUE");
            }
        }
        genericUrl.set("audience", (Object) str);
        HttpResponse metadataResponse = getMetadataResponse(genericUrl.toString());
        if (metadataResponse.getContent() == null) {
            throw new IOException("Empty content from metadata token server request.");
        }
        return IdToken.create(metadataResponse.parseAsString());
    }

    private HttpResponse getMetadataResponse(String str) throws IOException {
        HttpRequest httpRequestBuildGetRequest = this.transportFactory.create().createRequestFactory().buildGetRequest(new GenericUrl(str));
        httpRequestBuildGetRequest.setParser(new JsonObjectParser(OAuth2Utils.JSON_FACTORY));
        httpRequestBuildGetRequest.getHeaders().set(METADATA_FLAVOR, (Object) GOOGLE);
        httpRequestBuildGetRequest.setThrowExceptionOnExecuteError(false);
        try {
            HttpResponse httpResponseExecute = httpRequestBuildGetRequest.execute();
            if (httpResponseExecute.getStatusCode() != 503) {
                return httpResponseExecute;
            }
            throw GoogleAuthException.createWithTokenEndpointResponseException(new HttpResponseException(httpResponseExecute));
        } catch (UnknownHostException e) {
            throw new IOException("ComputeEngineCredentials cannot find the metadata server. This is likely because code is not running on Google Compute Engine.", e);
        }
    }

    static synchronized boolean isOnGce(HttpTransportFactory httpTransportFactory, DefaultCredentialsProvider defaultCredentialsProvider) {
        if (Boolean.parseBoolean(defaultCredentialsProvider.getEnv("NO_GCE_CHECK"))) {
            return false;
        }
        boolean zPingComputeEngineMetadata = pingComputeEngineMetadata(httpTransportFactory, defaultCredentialsProvider);
        if (!zPingComputeEngineMetadata) {
            zPingComputeEngineMetadata = checkStaticGceDetection(defaultCredentialsProvider);
        }
        if (!zPingComputeEngineMetadata) {
            LOGGER.log(Level.FINE, "Failed to detect whether running on Google Compute Engine.");
        }
        return zPingComputeEngineMetadata;
    }

    static boolean checkProductNameOnLinux(BufferedReader bufferedReader) throws IOException {
        return bufferedReader.readLine().trim().startsWith(GOOGLE);
    }

    static boolean checkStaticGceDetection(DefaultCredentialsProvider defaultCredentialsProvider) {
        String osName = defaultCredentialsProvider.getOsName();
        try {
            if (osName.startsWith(LINUX)) {
                return checkProductNameOnLinux(new BufferedReader(new InputStreamReader(defaultCredentialsProvider.readStream(new File("/sys/class/dmi/id/product_name")))));
            }
            osName.startsWith(WINDOWS);
            return false;
        } catch (IOException e) {
            LOGGER.log(Level.FINE, "Encountered an unexpected exception when checking SMBIOS value", (Throwable) e);
            return false;
        }
    }

    private static boolean pingComputeEngineMetadata(HttpTransportFactory httpTransportFactory, DefaultCredentialsProvider defaultCredentialsProvider) {
        GenericUrl genericUrl = new GenericUrl(getMetadataServerUrl(defaultCredentialsProvider));
        for (int i = 1; i <= 3; i++) {
            try {
                HttpRequest httpRequestBuildGetRequest = httpTransportFactory.create().createRequestFactory().buildGetRequest(genericUrl);
                httpRequestBuildGetRequest.setConnectTimeout(500);
                httpRequestBuildGetRequest.getHeaders().set(METADATA_FLAVOR, GOOGLE);
                HttpResponse httpResponseExecute = httpRequestBuildGetRequest.execute();
                try {
                    return OAuth2Utils.headersContainValue(httpResponseExecute.getHeaders(), METADATA_FLAVOR, GOOGLE);
                } finally {
                    httpResponseExecute.disconnect();
                }
            } catch (SocketTimeoutException unused) {
                continue;
            } catch (IOException e) {
                LOGGER.log(Level.FINE, "Encountered an unexpected exception when checking if running on Google Compute Engine using Metadata Service ping.", (Throwable) e);
            }
        }
        return false;
    }

    public static String getMetadataServerUrl(DefaultCredentialsProvider defaultCredentialsProvider) {
        String env = defaultCredentialsProvider.getEnv("GCE_METADATA_HOST");
        if (env != null) {
            return "http://" + env;
        }
        return DEFAULT_METADATA_SERVER_URL;
    }

    public static String getMetadataServerUrl() {
        return getMetadataServerUrl(DefaultCredentialsProvider.DEFAULT);
    }

    public static String getTokenServerEncodedUrl(DefaultCredentialsProvider defaultCredentialsProvider) {
        return getMetadataServerUrl(defaultCredentialsProvider) + "/computeMetadata/v1/instance/service-accounts/default/token";
    }

    public static String getTokenServerEncodedUrl() {
        return getTokenServerEncodedUrl(DefaultCredentialsProvider.DEFAULT);
    }

    public static String getUniverseDomainUrl() {
        return getMetadataServerUrl(DefaultCredentialsProvider.DEFAULT) + "/computeMetadata/v1/universe/universe_domain";
    }

    public static String getServiceAccountsUrl() {
        return getMetadataServerUrl(DefaultCredentialsProvider.DEFAULT) + "/computeMetadata/v1/instance/service-accounts/?recursive=true";
    }

    public static String getIdentityDocumentUrl() {
        return getMetadataServerUrl(DefaultCredentialsProvider.DEFAULT) + "/computeMetadata/v1/instance/service-accounts/default/identity";
    }

    @Override // com.google.auth.oauth2.GoogleCredentials, com.google.auth.oauth2.OAuth2Credentials
    public int hashCode() {
        return Objects.hash(this.transportFactoryClassName);
    }

    @Override // com.google.auth.oauth2.GoogleCredentials
    protected MoreObjects.ToStringHelper toStringHelper() {
        MoreObjects.ToStringHelper toStringHelperAdd;
        synchronized (this) {
            toStringHelperAdd = super.toStringHelper().add("transportFactoryClassName", this.transportFactoryClassName).add("scopes", this.scopes).add("universeDomainFromMetadata", this.universeDomainFromMetadata);
        }
        return toStringHelperAdd;
    }

    @Override // com.google.auth.oauth2.GoogleCredentials, com.google.auth.oauth2.OAuth2Credentials
    public boolean equals(Object obj) {
        if (!(obj instanceof ComputeEngineCredentials) || !super.equals(obj)) {
            return false;
        }
        ComputeEngineCredentials computeEngineCredentials = (ComputeEngineCredentials) obj;
        return Objects.equals(this.transportFactoryClassName, computeEngineCredentials.transportFactoryClassName) && Objects.equals(this.scopes, computeEngineCredentials.scopes) && Objects.equals(this.universeDomainFromMetadata, computeEngineCredentials.universeDomainFromMetadata);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.transportFactory = (HttpTransportFactory) newInstance(this.transportFactoryClassName);
    }

    @Override // com.google.auth.oauth2.GoogleCredentials, com.google.auth.oauth2.OAuth2Credentials
    public Builder toBuilder() {
        return new Builder(this);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Override // com.google.auth.ServiceAccountSigner
    public String getAccount() {
        if (this.serviceAccountEmail == null) {
            try {
                this.serviceAccountEmail = getDefaultServiceAccount();
            } catch (IOException e) {
                throw new RuntimeException("Failed to get service account", e);
            }
        }
        return this.serviceAccountEmail;
    }

    @Override // com.google.auth.ServiceAccountSigner
    public byte[] sign(byte[] bArr) {
        try {
            return IamUtils.sign(getAccount(), this, this.transportFactory.create(), bArr, Collections.emptyMap());
        } catch (ServiceAccountSigner.SigningException e) {
            throw e;
        } catch (RuntimeException e2) {
            throw new ServiceAccountSigner.SigningException("Signing failed", e2);
        }
    }

    private String getDefaultServiceAccount() throws IOException {
        HttpResponse metadataResponse = getMetadataResponse(getServiceAccountsUrl());
        int statusCode = metadataResponse.getStatusCode();
        if (statusCode == 404) {
            throw new IOException(String.format("Error code %s trying to get service accounts from Compute Engine metadata. This may be because the virtual machine instance does not have permission scopes specified.", Integer.valueOf(statusCode)));
        }
        if (statusCode != 200) {
            throw new IOException(String.format("Unexpected Error code %s trying to get service accounts from Compute Engine metadata: %s", Integer.valueOf(statusCode), metadataResponse.parseAsString()));
        }
        if (metadataResponse.getContent() == null) {
            throw new IOException("Empty content from metadata token server request.");
        }
        return OAuth2Utils.validateString(OAuth2Utils.validateMap((GenericData) metadataResponse.parseAs(GenericData.class), "default", PARSE_ERROR_ACCOUNT), "email", PARSE_ERROR_ACCOUNT);
    }

    public static class Builder extends GoogleCredentials.Builder {
        private Collection<String> defaultScopes;
        private Collection<String> scopes;
        private HttpTransportFactory transportFactory;

        protected Builder() {
            setRefreshMargin(ComputeEngineCredentials.COMPUTE_REFRESH_MARGIN);
            setExpirationMargin(ComputeEngineCredentials.COMPUTE_EXPIRATION_MARGIN);
        }

        protected Builder(ComputeEngineCredentials computeEngineCredentials) {
            super(computeEngineCredentials);
            this.transportFactory = computeEngineCredentials.transportFactory;
            this.scopes = computeEngineCredentials.scopes;
        }

        public Builder setHttpTransportFactory(HttpTransportFactory httpTransportFactory) {
            this.transportFactory = httpTransportFactory;
            return this;
        }

        public Builder setScopes(Collection<String> collection) {
            this.scopes = collection;
            return this;
        }

        public Builder setDefaultScopes(Collection<String> collection) {
            this.defaultScopes = collection;
            return this;
        }

        @Override // com.google.auth.oauth2.GoogleCredentials.Builder
        public Builder setUniverseDomain(String str) {
            this.universeDomain = str;
            return this;
        }

        @Override // com.google.auth.oauth2.GoogleCredentials.Builder
        public Builder setQuotaProjectId(String str) {
            this.quotaProjectId = str;
            return this;
        }

        public HttpTransportFactory getHttpTransportFactory() {
            return this.transportFactory;
        }

        public Collection<String> getScopes() {
            return this.scopes;
        }

        public Collection<String> getDefaultScopes() {
            return this.defaultScopes;
        }

        @Override // com.google.auth.oauth2.GoogleCredentials.Builder, com.google.auth.oauth2.OAuth2Credentials.Builder
        public ComputeEngineCredentials build() {
            return new ComputeEngineCredentials(this, null);
        }
    }
}
