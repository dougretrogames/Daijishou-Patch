package com.google.auth.oauth2;

import androidx.core.os.EnvironmentCompat;
import androidx.webkit.ProxyConfig;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonObjectParser;
import com.google.auth.RequestMetadataCallback;
import com.google.auth.http.HttpTransportFactory;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ExternalAccountCredentials extends GoogleCredentials {
    private static final String CLOUD_PLATFORM_SCOPE = "https://www.googleapis.com/auth/cloud-platform";
    static final String DEFAULT_TOKEN_URL = "https://sts.googleapis.com/v1/token";
    static final String EXECUTABLE_SOURCE_KEY = "executable";
    static final String EXTERNAL_ACCOUNT_FILE_TYPE = "external_account";
    static final String PROGRAMMATIC_METRICS_HEADER_VALUE = "programmatic";
    private static final long serialVersionUID = 8049126194174465023L;
    private final String audience;

    @Nullable
    private final String clientId;

    @Nullable
    private final String clientSecret;
    private final CredentialSource credentialSource;
    private EnvironmentProvider environmentProvider;

    @Nullable
    protected ImpersonatedCredentials impersonatedCredentials;
    private ExternalAccountMetricsHandler metricsHandler;
    private final Collection<String> scopes;
    private final ServiceAccountImpersonationOptions serviceAccountImpersonationOptions;

    @Nullable
    private final String serviceAccountImpersonationUrl;
    private final String subjectTokenType;

    @Nullable
    private final String tokenInfoUrl;
    private final String tokenUrl;
    protected transient HttpTransportFactory transportFactory;
    private final String transportFactoryClassName;

    @Nullable
    private final String workforcePoolUserProject;

    public abstract String retrieveSubjectToken() throws IOException;

    protected ExternalAccountCredentials(HttpTransportFactory httpTransportFactory, String str, String str2, String str3, CredentialSource credentialSource, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable Collection<String> collection) {
        this(httpTransportFactory, str, str2, str3, credentialSource, str4, str5, str6, str7, str8, collection, null);
    }

    protected ExternalAccountCredentials(HttpTransportFactory httpTransportFactory, String str, String str2, String str3, CredentialSource credentialSource, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable Collection<String> collection, @Nullable EnvironmentProvider environmentProvider) {
        super(null, str6);
        HttpTransportFactory httpTransportFactory2 = (HttpTransportFactory) MoreObjects.firstNonNull(httpTransportFactory, getFromServiceLoader(HttpTransportFactory.class, OAuth2Utils.HTTP_TRANSPORT_FACTORY));
        this.transportFactory = httpTransportFactory2;
        this.transportFactoryClassName = (String) Preconditions.checkNotNull(httpTransportFactory2.getClass().getName());
        this.audience = (String) Preconditions.checkNotNull(str);
        this.subjectTokenType = (String) Preconditions.checkNotNull(str2);
        this.tokenUrl = (String) Preconditions.checkNotNull(str3);
        this.credentialSource = (CredentialSource) Preconditions.checkNotNull(credentialSource);
        this.tokenInfoUrl = str4;
        this.serviceAccountImpersonationUrl = str5;
        this.clientId = str7;
        this.clientSecret = str8;
        this.scopes = (collection == null || collection.isEmpty()) ? Arrays.asList(CLOUD_PLATFORM_SCOPE) : collection;
        this.environmentProvider = environmentProvider == null ? SystemEnvironmentProvider.getInstance() : environmentProvider;
        this.workforcePoolUserProject = null;
        this.serviceAccountImpersonationOptions = new ServiceAccountImpersonationOptions(new HashMap());
        validateTokenUrl(str3);
        if (str5 != null) {
            validateServiceAccountImpersonationInfoUrl(str5);
        }
        this.metricsHandler = new ExternalAccountMetricsHandler(this);
    }

    protected ExternalAccountCredentials(Builder builder) {
        super(builder);
        HttpTransportFactory httpTransportFactory = (HttpTransportFactory) MoreObjects.firstNonNull(builder.transportFactory, getFromServiceLoader(HttpTransportFactory.class, OAuth2Utils.HTTP_TRANSPORT_FACTORY));
        this.transportFactory = httpTransportFactory;
        this.transportFactoryClassName = (String) Preconditions.checkNotNull(httpTransportFactory.getClass().getName());
        this.audience = (String) Preconditions.checkNotNull(builder.audience);
        this.subjectTokenType = (String) Preconditions.checkNotNull(builder.subjectTokenType);
        this.credentialSource = builder.credentialSource;
        this.tokenInfoUrl = builder.tokenInfoUrl;
        String str = builder.serviceAccountImpersonationUrl;
        this.serviceAccountImpersonationUrl = str;
        this.clientId = builder.clientId;
        this.clientSecret = builder.clientSecret;
        String str2 = builder.tokenUrl == null ? DEFAULT_TOKEN_URL : builder.tokenUrl;
        this.tokenUrl = str2;
        this.scopes = (builder.scopes == null || builder.scopes.isEmpty()) ? Arrays.asList(CLOUD_PLATFORM_SCOPE) : builder.scopes;
        this.environmentProvider = builder.environmentProvider == null ? SystemEnvironmentProvider.getInstance() : builder.environmentProvider;
        this.serviceAccountImpersonationOptions = builder.serviceAccountImpersonationOptions == null ? new ServiceAccountImpersonationOptions(new HashMap()) : builder.serviceAccountImpersonationOptions;
        String str3 = builder.workforcePoolUserProject;
        this.workforcePoolUserProject = str3;
        if (str3 != null && !isWorkforcePoolConfiguration()) {
            throw new IllegalArgumentException("The workforce_pool_user_project parameter should only be provided for a Workforce Pool configuration.");
        }
        validateTokenUrl(str2);
        if (str != null) {
            validateServiceAccountImpersonationInfoUrl(str);
        }
        this.metricsHandler = builder.metricsHandler == null ? new ExternalAccountMetricsHandler(this) : builder.metricsHandler;
    }

    ImpersonatedCredentials buildImpersonatedCredentials() {
        GoogleCredentials googleCredentialsBuild;
        if (this.serviceAccountImpersonationUrl == null) {
            return null;
        }
        if (this instanceof AwsCredentials) {
            googleCredentialsBuild = AwsCredentials.newBuilder((AwsCredentials) this).setServiceAccountImpersonationUrl((String) null).build();
        } else if (this instanceof PluggableAuthCredentials) {
            googleCredentialsBuild = PluggableAuthCredentials.newBuilder((PluggableAuthCredentials) this).setServiceAccountImpersonationUrl((String) null).build();
        } else {
            googleCredentialsBuild = IdentityPoolCredentials.newBuilder((IdentityPoolCredentials) this).setServiceAccountImpersonationUrl((String) null).build();
        }
        return ImpersonatedCredentials.newBuilder().setSourceCredentials(googleCredentialsBuild).setHttpTransportFactory(this.transportFactory).setTargetPrincipal(ImpersonatedCredentials.extractTargetPrincipal(this.serviceAccountImpersonationUrl)).setScopes(new ArrayList(this.scopes)).setLifetime(this.serviceAccountImpersonationOptions.lifetime).setIamEndpointOverride(this.serviceAccountImpersonationUrl).build();
    }

    @Override // com.google.auth.oauth2.OAuth2Credentials, com.google.auth.Credentials
    public void getRequestMetadata(URI uri, Executor executor, RequestMetadataCallback requestMetadataCallback) {
        super.getRequestMetadata(uri, executor, new AnonymousClass1(requestMetadataCallback));
    }

    /* JADX INFO: renamed from: com.google.auth.oauth2.ExternalAccountCredentials$1, reason: invalid class name */
    class AnonymousClass1 implements RequestMetadataCallback {
        final /* synthetic */ RequestMetadataCallback val$callback;

        AnonymousClass1(RequestMetadataCallback requestMetadataCallback) {
            this.val$callback = requestMetadataCallback;
        }

        @Override // com.google.auth.RequestMetadataCallback
        public void onSuccess(Map<String, List<String>> map) {
            this.val$callback.onSuccess(GoogleCredentials.addQuotaProjectIdToRequestMetadata(ExternalAccountCredentials.this.quotaProjectId, map));
        }

        @Override // com.google.auth.RequestMetadataCallback
        public void onFailure(Throwable th) {
            this.val$callback.onFailure(th);
        }
    }

    @Override // com.google.auth.oauth2.OAuth2Credentials, com.google.auth.Credentials
    public Map<String, List<String>> getRequestMetadata(URI uri) throws IOException {
        return addQuotaProjectIdToRequestMetadata(this.quotaProjectId, super.getRequestMetadata(uri));
    }

    public static ExternalAccountCredentials fromStream(InputStream inputStream) throws IOException {
        return fromStream(inputStream, OAuth2Utils.HTTP_TRANSPORT_FACTORY);
    }

    public static ExternalAccountCredentials fromStream(InputStream inputStream, HttpTransportFactory httpTransportFactory) throws IOException {
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(httpTransportFactory);
        try {
            return fromJson((GenericJson) new JsonObjectParser(OAuth2Utils.JSON_FACTORY).parseAndClose(inputStream, StandardCharsets.UTF_8, GenericJson.class), httpTransportFactory);
        } catch (ClassCastException | IllegalArgumentException e) {
            throw new CredentialFormatException("An invalid input stream was provided.", e);
        }
    }

    static ExternalAccountCredentials fromJson(Map<String, Object> map, HttpTransportFactory httpTransportFactory) {
        Preconditions.checkNotNull(map);
        Preconditions.checkNotNull(httpTransportFactory);
        String str = (String) map.get("audience");
        String str2 = (String) map.get("subject_token_type");
        String str3 = (String) map.get("token_url");
        Map map2 = (Map) map.get("credential_source");
        String str4 = (String) map.get("service_account_impersonation_url");
        String str5 = (String) map.get("token_info_url");
        String str6 = (String) map.get("client_id");
        String str7 = (String) map.get("client_secret");
        String str8 = (String) map.get("quota_project_id");
        String str9 = (String) map.get("workforce_pool_user_project");
        String str10 = (String) map.get("universe_domain");
        Map<String, Object> map3 = (Map) map.get("service_account_impersonation");
        if (map3 == null) {
            map3 = new HashMap<>();
        }
        if (isAwsCredential(map2)) {
            return AwsCredentials.newBuilder().setHttpTransportFactory(httpTransportFactory).setAudience(str).setSubjectTokenType(str2).setTokenUrl(str3).setTokenInfoUrl(str5).setCredentialSource(new AwsCredentialSource(map2)).setServiceAccountImpersonationUrl(str4).setQuotaProjectId(str8).setClientId(str6).setClientSecret(str7).setServiceAccountImpersonationOptions(map3).setUniverseDomain(str10).build();
        }
        if (isPluggableAuthCredential(map2)) {
            return PluggableAuthCredentials.newBuilder().setHttpTransportFactory(httpTransportFactory).setAudience(str).setSubjectTokenType(str2).setTokenUrl(str3).setTokenInfoUrl(str5).setCredentialSource(new PluggableAuthCredentialSource(map2)).setServiceAccountImpersonationUrl(str4).setQuotaProjectId(str8).setClientId(str6).setClientSecret(str7).setWorkforcePoolUserProject(str9).setServiceAccountImpersonationOptions(map3).setUniverseDomain(str10).build();
        }
        return IdentityPoolCredentials.newBuilder().setHttpTransportFactory(httpTransportFactory).setAudience(str).setSubjectTokenType(str2).setTokenUrl(str3).setTokenInfoUrl(str5).setCredentialSource(new IdentityPoolCredentialSource(map2)).setServiceAccountImpersonationUrl(str4).setQuotaProjectId(str8).setClientId(str6).setClientSecret(str7).setWorkforcePoolUserProject(str9).setServiceAccountImpersonationOptions(map3).setUniverseDomain(str10).build();
    }

    private static boolean isPluggableAuthCredential(Map<String, Object> map) {
        return map.containsKey(EXECUTABLE_SOURCE_KEY);
    }

    private static boolean isAwsCredential(Map<String, Object> map) {
        return map.containsKey("environment_id") && ((String) map.get("environment_id")).startsWith("aws");
    }

    private boolean shouldBuildImpersonatedCredential() {
        return this.serviceAccountImpersonationUrl != null && this.impersonatedCredentials == null;
    }

    protected AccessToken exchangeExternalCredentialForAccessToken(StsTokenExchangeRequest stsTokenExchangeRequest) throws IOException {
        if (shouldBuildImpersonatedCredential()) {
            this.impersonatedCredentials = buildImpersonatedCredentials();
        }
        ImpersonatedCredentials impersonatedCredentials = this.impersonatedCredentials;
        if (impersonatedCredentials != null) {
            return impersonatedCredentials.refreshAccessToken();
        }
        StsRequestHandler.Builder builderNewBuilder = StsRequestHandler.newBuilder(this.tokenUrl, stsTokenExchangeRequest, this.transportFactory.create().createRequestFactory());
        if (isWorkforcePoolConfiguration()) {
            GenericJson genericJson = new GenericJson();
            genericJson.setFactory(OAuth2Utils.JSON_FACTORY);
            genericJson.put("userProject", (Object) this.workforcePoolUserProject);
            builderNewBuilder.setInternalOptions(genericJson.toString());
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("x-goog-api-client", (Object) this.metricsHandler.getExternalAccountMetricsHeader());
        builderNewBuilder.setHeaders(httpHeaders);
        if (stsTokenExchangeRequest.getInternalOptions() != null) {
            builderNewBuilder.setInternalOptions(stsTokenExchangeRequest.getInternalOptions());
        }
        return builderNewBuilder.build().exchangeToken().getAccessToken();
    }

    public String getAudience() {
        return this.audience;
    }

    public String getSubjectTokenType() {
        return this.subjectTokenType;
    }

    public String getTokenUrl() {
        return this.tokenUrl;
    }

    public String getTokenInfoUrl() {
        return this.tokenInfoUrl;
    }

    public CredentialSource getCredentialSource() {
        return this.credentialSource;
    }

    @Nullable
    public String getServiceAccountImpersonationUrl() {
        return this.serviceAccountImpersonationUrl;
    }

    @Nullable
    public String getServiceAccountEmail() {
        String str = this.serviceAccountImpersonationUrl;
        if (str == null || str.isEmpty()) {
            return null;
        }
        return ImpersonatedCredentials.extractTargetPrincipal(this.serviceAccountImpersonationUrl);
    }

    @Nullable
    public String getClientId() {
        return this.clientId;
    }

    @Nullable
    public String getClientSecret() {
        return this.clientSecret;
    }

    @Nullable
    public Collection<String> getScopes() {
        return this.scopes;
    }

    @Nullable
    public String getWorkforcePoolUserProject() {
        return this.workforcePoolUserProject;
    }

    @Nullable
    public ServiceAccountImpersonationOptions getServiceAccountImpersonationOptions() {
        return this.serviceAccountImpersonationOptions;
    }

    String getCredentialSourceType() {
        return EnvironmentCompat.MEDIA_UNKNOWN;
    }

    EnvironmentProvider getEnvironmentProvider() {
        return this.environmentProvider;
    }

    public boolean isWorkforcePoolConfiguration() {
        return this.workforcePoolUserProject != null && Pattern.compile("^//iam.googleapis.com/locations/.+/workforcePools/.+/providers/.+$").matcher(getAudience()).matches();
    }

    static void validateTokenUrl(String str) {
        if (!isValidUrl(str)) {
            throw new IllegalArgumentException("The provided token URL is invalid.");
        }
    }

    static void validateServiceAccountImpersonationInfoUrl(String str) {
        if (!isValidUrl(str)) {
            throw new IllegalArgumentException("The provided service account impersonation URL is invalid.");
        }
    }

    private static boolean isValidUrl(String str) {
        try {
            URI uriCreate = URI.create(str);
            return (uriCreate.getScheme() == null || uriCreate.getHost() == null || !ProxyConfig.MATCH_HTTPS.equals(uriCreate.getScheme().toLowerCase(Locale.US))) ? false : true;
        } catch (Exception unused) {
        }
    }

    static final class ServiceAccountImpersonationOptions implements Serializable {
        private static final int DEFAULT_TOKEN_LIFETIME_SECONDS = 3600;
        private static final int MAXIMUM_TOKEN_LIFETIME_SECONDS = 43200;
        private static final int MINIMUM_TOKEN_LIFETIME_SECONDS = 600;
        private static final String TOKEN_LIFETIME_SECONDS_KEY = "token_lifetime_seconds";
        private static final long serialVersionUID = 4250771921886280953L;
        final boolean customTokenLifetimeRequested;
        private final int lifetime;

        ServiceAccountImpersonationOptions(Map<String, Object> map) {
            boolean zContainsKey = map.containsKey(TOKEN_LIFETIME_SECONDS_KEY);
            this.customTokenLifetimeRequested = zContainsKey;
            if (!zContainsKey) {
                this.lifetime = DEFAULT_TOKEN_LIFETIME_SECONDS;
                return;
            }
            try {
                Object obj = map.get(TOKEN_LIFETIME_SECONDS_KEY);
                if (obj instanceof BigDecimal) {
                    this.lifetime = ((BigDecimal) obj).intValue();
                } else if (map.get(TOKEN_LIFETIME_SECONDS_KEY) instanceof Integer) {
                    this.lifetime = ((Integer) obj).intValue();
                } else {
                    this.lifetime = Integer.parseInt((String) obj);
                }
                int i = this.lifetime;
                if (i < 600 || i > MAXIMUM_TOKEN_LIFETIME_SECONDS) {
                    throw new IllegalArgumentException(String.format("The \"token_lifetime_seconds\" field must be between %s and %s seconds.", 600, Integer.valueOf(MAXIMUM_TOKEN_LIFETIME_SECONDS)));
                }
            } catch (ArithmeticException | NumberFormatException e) {
                throw new IllegalArgumentException("Value of \"token_lifetime_seconds\" field could not be parsed into an integer.", e);
            }
        }

        int getLifetime() {
            return this.lifetime;
        }
    }

    public static abstract class Builder extends GoogleCredentials.Builder {
        protected String audience;

        @Nullable
        protected String clientId;

        @Nullable
        protected String clientSecret;
        protected CredentialSource credentialSource;
        protected EnvironmentProvider environmentProvider;

        @Nullable
        protected ExternalAccountMetricsHandler metricsHandler;

        @Nullable
        protected Collection<String> scopes;

        @Nullable
        protected ServiceAccountImpersonationOptions serviceAccountImpersonationOptions;

        @Nullable
        protected String serviceAccountImpersonationUrl;
        protected String subjectTokenType;
        protected String tokenInfoUrl;
        protected String tokenUrl;
        protected HttpTransportFactory transportFactory;

        @Nullable
        @Deprecated
        protected String universeDomain;

        @Nullable
        protected String workforcePoolUserProject;

        @Override // com.google.auth.oauth2.GoogleCredentials.Builder, com.google.auth.oauth2.OAuth2Credentials.Builder
        public abstract ExternalAccountCredentials build();

        protected Builder() {
        }

        protected Builder(ExternalAccountCredentials externalAccountCredentials) {
            super(externalAccountCredentials);
            this.transportFactory = externalAccountCredentials.transportFactory;
            this.audience = externalAccountCredentials.audience;
            this.subjectTokenType = externalAccountCredentials.subjectTokenType;
            this.tokenUrl = externalAccountCredentials.tokenUrl;
            this.tokenInfoUrl = externalAccountCredentials.tokenInfoUrl;
            this.serviceAccountImpersonationUrl = externalAccountCredentials.serviceAccountImpersonationUrl;
            this.credentialSource = externalAccountCredentials.credentialSource;
            this.clientId = externalAccountCredentials.clientId;
            this.clientSecret = externalAccountCredentials.clientSecret;
            this.scopes = externalAccountCredentials.scopes;
            this.environmentProvider = externalAccountCredentials.environmentProvider;
            this.workforcePoolUserProject = externalAccountCredentials.workforcePoolUserProject;
            this.serviceAccountImpersonationOptions = externalAccountCredentials.serviceAccountImpersonationOptions;
            this.metricsHandler = externalAccountCredentials.metricsHandler;
        }

        public Builder setHttpTransportFactory(HttpTransportFactory httpTransportFactory) {
            this.transportFactory = httpTransportFactory;
            return this;
        }

        public Builder setAudience(String str) {
            this.audience = str;
            return this;
        }

        public Builder setSubjectTokenType(String str) {
            this.subjectTokenType = str;
            return this;
        }

        public Builder setSubjectTokenType(SubjectTokenTypes subjectTokenTypes) {
            this.subjectTokenType = subjectTokenTypes.value;
            return this;
        }

        public Builder setTokenUrl(String str) {
            this.tokenUrl = str;
            return this;
        }

        public Builder setCredentialSource(CredentialSource credentialSource) {
            this.credentialSource = credentialSource;
            return this;
        }

        public Builder setServiceAccountImpersonationUrl(String str) {
            this.serviceAccountImpersonationUrl = str;
            return this;
        }

        public Builder setTokenInfoUrl(String str) {
            this.tokenInfoUrl = str;
            return this;
        }

        @Override // com.google.auth.oauth2.GoogleCredentials.Builder
        public Builder setQuotaProjectId(String str) {
            super.setQuotaProjectId(str);
            return this;
        }

        public Builder setClientId(String str) {
            this.clientId = str;
            return this;
        }

        public Builder setClientSecret(String str) {
            this.clientSecret = str;
            return this;
        }

        public Builder setScopes(Collection<String> collection) {
            this.scopes = collection;
            return this;
        }

        public Builder setWorkforcePoolUserProject(String str) {
            this.workforcePoolUserProject = str;
            return this;
        }

        public Builder setServiceAccountImpersonationOptions(Map<String, Object> map) {
            this.serviceAccountImpersonationOptions = new ServiceAccountImpersonationOptions(map);
            return this;
        }

        @Override // com.google.auth.oauth2.GoogleCredentials.Builder
        public Builder setUniverseDomain(String str) {
            super.setUniverseDomain(str);
            return this;
        }

        Builder setEnvironmentProvider(EnvironmentProvider environmentProvider) {
            this.environmentProvider = environmentProvider;
            return this;
        }
    }

    public enum SubjectTokenTypes {
        AWS4("urn:ietf:params:aws:token-type:aws4_request"),
        JWT("urn:ietf:params:oauth:token-type:jwt"),
        SAML2("urn:ietf:params:oauth:token-type:saml2"),
        ID_TOKEN("urn:ietf:params:oauth:token-type:id_token");

        public final String value;

        SubjectTokenTypes(String str) {
            this.value = str;
        }
    }

    static abstract class CredentialSource implements Serializable {
        private static final long serialVersionUID = 8204657811562399944L;

        CredentialSource(Map<String, Object> map) {
            Preconditions.checkNotNull(map);
        }
    }
}
