package com.google.auth.oauth2;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.json.JsonHttpContent;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.util.GenericData;
import com.google.auth.ServiceAccountSigner;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.http.HttpTransportFactory;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* INFO: loaded from: classes3.dex */
public class ImpersonatedCredentials extends GoogleCredentials implements ServiceAccountSigner, IdTokenProvider {
    private static final String CLOUD_PLATFORM_SCOPE = "https://www.googleapis.com/auth/cloud-platform";
    private static final int DEFAULT_LIFETIME_IN_SECONDS = 3600;
    private static final String IAM_ACCESS_TOKEN_ENDPOINT = "https://iamcredentials.googleapis.com/v1/projects/-/serviceAccounts/%s:generateAccessToken";
    static final String IMPERSONATED_CREDENTIALS_FILE_TYPE = "impersonated_service_account";
    private static final String RFC3339 = "yyyy-MM-dd'T'HH:mm:ssX";
    private static final int TWELVE_HOURS_IN_SECONDS = 43200;
    private static final long serialVersionUID = -2133257318957488431L;
    private transient Calendar calendar;
    private List<String> delegates;
    private String iamEndpointOverride;
    private int lifetime;
    private List<String> scopes;
    private GoogleCredentials sourceCredentials;
    private String targetPrincipal;
    private transient HttpTransportFactory transportFactory;
    private final String transportFactoryClassName;

    /* synthetic */ ImpersonatedCredentials(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public static ImpersonatedCredentials create(GoogleCredentials googleCredentials, String str, List<String> list, List<String> list2, int i, HttpTransportFactory httpTransportFactory) {
        return newBuilder().setSourceCredentials(googleCredentials).setTargetPrincipal(str).setDelegates(list).setScopes(list2).setLifetime(i).setHttpTransportFactory(httpTransportFactory).build();
    }

    public static ImpersonatedCredentials create(GoogleCredentials googleCredentials, String str, List<String> list, List<String> list2, int i, HttpTransportFactory httpTransportFactory, String str2) {
        return newBuilder().setSourceCredentials(googleCredentials).setTargetPrincipal(str).setDelegates(list).setScopes(list2).setLifetime(i).setHttpTransportFactory(httpTransportFactory).setQuotaProjectId(str2).build();
    }

    public static ImpersonatedCredentials create(GoogleCredentials googleCredentials, String str, List<String> list, List<String> list2, int i, HttpTransportFactory httpTransportFactory, String str2, String str3) {
        return newBuilder().setSourceCredentials(googleCredentials).setTargetPrincipal(str).setDelegates(list).setScopes(list2).setLifetime(i).setHttpTransportFactory(httpTransportFactory).setQuotaProjectId(str2).setIamEndpointOverride(str3).build();
    }

    public static ImpersonatedCredentials create(GoogleCredentials googleCredentials, String str, List<String> list, List<String> list2, int i) {
        return newBuilder().setSourceCredentials(googleCredentials).setTargetPrincipal(str).setDelegates(list).setScopes(list2).setLifetime(i).build();
    }

    static String extractTargetPrincipal(String str) {
        int iLastIndexOf = str.lastIndexOf(47);
        int iIndexOf = str.indexOf(":generateAccessToken");
        if (iLastIndexOf != -1 && iIndexOf != -1 && iLastIndexOf < iIndexOf) {
            return str.substring(iLastIndexOf + 1, iIndexOf);
        }
        throw new IllegalArgumentException("Unable to determine target principal from service account impersonation URL.");
    }

    @Override // com.google.auth.ServiceAccountSigner
    public String getAccount() {
        return this.targetPrincipal;
    }

    String getIamEndpointOverride() {
        return this.iamEndpointOverride;
    }

    List<String> getDelegates() {
        return this.delegates;
    }

    List<String> getScopes() {
        return this.scopes;
    }

    public GoogleCredentials getSourceCredentials() {
        return this.sourceCredentials;
    }

    int getLifetime() {
        return this.lifetime;
    }

    public void setTransportFactory(HttpTransportFactory httpTransportFactory) {
        this.transportFactory = httpTransportFactory;
    }

    @Override // com.google.auth.ServiceAccountSigner
    public byte[] sign(byte[] bArr) {
        return IamUtils.sign(getAccount(), this.sourceCredentials, this.transportFactory.create(), bArr, ImmutableMap.of("delegates", this.delegates));
    }

    static ImpersonatedCredentials fromJson(Map<String, Object> map, HttpTransportFactory httpTransportFactory) throws IOException {
        GoogleCredentials googleCredentialsFromJson;
        Preconditions.checkNotNull(map);
        Preconditions.checkNotNull(httpTransportFactory);
        try {
            String str = (String) map.get("service_account_impersonation_url");
            List<String> list = map.containsKey("delegates") ? (List) map.get("delegates") : null;
            Map map2 = (Map) map.get("source_credentials");
            String str2 = (String) map2.get("type");
            String str3 = (String) map.get("quota_project_id");
            String strExtractTargetPrincipal = extractTargetPrincipal(str);
            if ("authorized_user".equals(str2)) {
                googleCredentialsFromJson = UserCredentials.fromJson(map2, httpTransportFactory);
            } else if ("service_account".equals(str2)) {
                googleCredentialsFromJson = ServiceAccountCredentials.fromJson(map2, httpTransportFactory);
            } else {
                throw new IOException(String.format("A credential of type %s is not supported as source credential for impersonation.", str2));
            }
            return newBuilder().setSourceCredentials(googleCredentialsFromJson).setTargetPrincipal(strExtractTargetPrincipal).setDelegates(list).setScopes(new ArrayList()).setLifetime(DEFAULT_LIFETIME_IN_SECONDS).setHttpTransportFactory(httpTransportFactory).setQuotaProjectId(str3).setIamEndpointOverride(str).build();
        } catch (ClassCastException | IllegalArgumentException | NullPointerException e) {
            throw new CredentialFormatException("An invalid input stream was provided.", e);
        }
    }

    @Override // com.google.auth.oauth2.GoogleCredentials
    public boolean createScopedRequired() {
        List<String> list = this.scopes;
        return list == null || list.isEmpty();
    }

    @Override // com.google.auth.oauth2.GoogleCredentials
    public GoogleCredentials createScoped(Collection<String> collection) {
        return toBuilder().setScopes(new ArrayList(collection)).setLifetime(this.lifetime).setDelegates(this.delegates).setHttpTransportFactory(this.transportFactory).setQuotaProjectId(this.quotaProjectId).setIamEndpointOverride(this.iamEndpointOverride).build();
    }

    public ImpersonatedCredentials createWithCustomCalendar(Calendar calendar) {
        return toBuilder().setScopes(this.scopes).setLifetime(this.lifetime).setDelegates(this.delegates).setHttpTransportFactory(this.transportFactory).setQuotaProjectId(this.quotaProjectId).setIamEndpointOverride(this.iamEndpointOverride).setCalendar(calendar).build();
    }

    private ImpersonatedCredentials(Builder builder) {
        super(builder);
        this.sourceCredentials = builder.getSourceCredentials();
        this.targetPrincipal = builder.getTargetPrincipal();
        this.delegates = builder.getDelegates();
        this.scopes = builder.getScopes();
        this.lifetime = builder.getLifetime();
        this.transportFactory = (HttpTransportFactory) MoreObjects.firstNonNull(builder.getHttpTransportFactory(), getFromServiceLoader(HttpTransportFactory.class, OAuth2Utils.HTTP_TRANSPORT_FACTORY));
        this.iamEndpointOverride = builder.iamEndpointOverride;
        this.transportFactoryClassName = this.transportFactory.getClass().getName();
        this.calendar = builder.getCalendar();
        if (this.delegates == null) {
            this.delegates = new ArrayList();
        }
        if (this.scopes == null) {
            throw new IllegalStateException("Scopes cannot be null");
        }
        if (this.lifetime > TWELVE_HOURS_IN_SECONDS) {
            throw new IllegalStateException("lifetime must be less than or equal to 43200");
        }
    }

    @Override // com.google.auth.oauth2.OAuth2Credentials
    public AccessToken refreshAccessToken() throws IOException {
        if (this.sourceCredentials.getAccessToken() == null) {
            this.sourceCredentials = this.sourceCredentials.createScoped(Arrays.asList(CLOUD_PLATFORM_SCOPE));
        }
        try {
            this.sourceCredentials.refreshIfExpired();
            HttpTransport httpTransportCreate = this.transportFactory.create();
            JsonObjectParser jsonObjectParser = new JsonObjectParser(OAuth2Utils.JSON_FACTORY);
            HttpCredentialsAdapter httpCredentialsAdapter = new HttpCredentialsAdapter(this.sourceCredentials);
            HttpRequestFactory httpRequestFactoryCreateRequestFactory = httpTransportCreate.createRequestFactory();
            String str = this.iamEndpointOverride;
            if (str == null) {
                str = String.format(IAM_ACCESS_TOKEN_ENDPOINT, this.targetPrincipal);
            }
            HttpRequest httpRequestBuildPostRequest = httpRequestFactoryCreateRequestFactory.buildPostRequest(new GenericUrl(str), new JsonHttpContent(jsonObjectParser.getJsonFactory(), ImmutableMap.of("delegates", (String) this.delegates, "scope", (String) this.scopes, "lifetime", this.lifetime + "s")));
            httpCredentialsAdapter.initialize(httpRequestBuildPostRequest);
            httpRequestBuildPostRequest.setParser(jsonObjectParser);
            try {
                HttpResponse httpResponseExecute = httpRequestBuildPostRequest.execute();
                GenericData genericData = (GenericData) httpResponseExecute.parseAs(GenericData.class);
                httpResponseExecute.disconnect();
                String strValidateString = OAuth2Utils.validateString(genericData, "accessToken", "Expected to find an accessToken");
                String strValidateString2 = OAuth2Utils.validateString(genericData, "expireTime", "Expected to find an expireTime");
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(RFC3339);
                simpleDateFormat.setCalendar(this.calendar);
                try {
                    return new AccessToken(strValidateString, simpleDateFormat.parse(strValidateString2));
                } catch (ParseException e) {
                    throw new IOException("Error parsing expireTime: " + e.getMessage());
                }
            } catch (IOException e2) {
                throw new IOException("Error requesting access token", e2);
            }
        } catch (IOException e3) {
            throw new IOException("Unable to refresh sourceCredentials", e3);
        }
    }

    @Override // com.google.auth.oauth2.IdTokenProvider
    public IdToken idTokenWithAudience(String str, List<IdTokenProvider.Option> list) throws IOException {
        return IamUtils.getIdToken(getAccount(), this.sourceCredentials, this.transportFactory.create(), str, list != null && list.contains(IdTokenProvider.Option.INCLUDE_EMAIL), ImmutableMap.of("delegates", this.delegates));
    }

    @Override // com.google.auth.oauth2.GoogleCredentials, com.google.auth.oauth2.OAuth2Credentials
    public int hashCode() {
        return Objects.hash(this.sourceCredentials, this.targetPrincipal, this.delegates, this.scopes, Integer.valueOf(this.lifetime), this.quotaProjectId, this.iamEndpointOverride);
    }

    @Override // com.google.auth.oauth2.GoogleCredentials, com.google.auth.oauth2.OAuth2Credentials
    public String toString() {
        return MoreObjects.toStringHelper(this).add("sourceCredentials", this.sourceCredentials).add("targetPrincipal", this.targetPrincipal).add("delegates", this.delegates).add("scopes", this.scopes).add("lifetime", this.lifetime).add("transportFactoryClassName", this.transportFactoryClassName).add("quotaProjectId", this.quotaProjectId).add("iamEndpointOverride", this.iamEndpointOverride).toString();
    }

    @Override // com.google.auth.oauth2.GoogleCredentials, com.google.auth.oauth2.OAuth2Credentials
    public boolean equals(Object obj) {
        if (!(obj instanceof ImpersonatedCredentials)) {
            return false;
        }
        ImpersonatedCredentials impersonatedCredentials = (ImpersonatedCredentials) obj;
        return Objects.equals(this.sourceCredentials, impersonatedCredentials.sourceCredentials) && Objects.equals(this.targetPrincipal, impersonatedCredentials.targetPrincipal) && Objects.equals(this.delegates, impersonatedCredentials.delegates) && Objects.equals(this.scopes, impersonatedCredentials.scopes) && Objects.equals(Integer.valueOf(this.lifetime), Integer.valueOf(impersonatedCredentials.lifetime)) && Objects.equals(this.transportFactoryClassName, impersonatedCredentials.transportFactoryClassName) && Objects.equals(this.quotaProjectId, impersonatedCredentials.quotaProjectId) && Objects.equals(this.iamEndpointOverride, impersonatedCredentials.iamEndpointOverride);
    }

    @Override // com.google.auth.oauth2.GoogleCredentials, com.google.auth.oauth2.OAuth2Credentials
    public Builder toBuilder() {
        return new Builder(this.sourceCredentials, this.targetPrincipal);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder extends GoogleCredentials.Builder {
        private List<String> delegates;
        private String iamEndpointOverride;
        private List<String> scopes;
        private GoogleCredentials sourceCredentials;
        private String targetPrincipal;
        private HttpTransportFactory transportFactory;
        private int lifetime = ImpersonatedCredentials.DEFAULT_LIFETIME_IN_SECONDS;
        private Calendar calendar = Calendar.getInstance();

        protected Builder() {
        }

        protected Builder(GoogleCredentials googleCredentials, String str) {
            this.sourceCredentials = googleCredentials;
            this.targetPrincipal = str;
        }

        public Builder setSourceCredentials(GoogleCredentials googleCredentials) {
            this.sourceCredentials = googleCredentials;
            return this;
        }

        public GoogleCredentials getSourceCredentials() {
            return this.sourceCredentials;
        }

        public Builder setTargetPrincipal(String str) {
            this.targetPrincipal = str;
            return this;
        }

        public String getTargetPrincipal() {
            return this.targetPrincipal;
        }

        public Builder setDelegates(List<String> list) {
            this.delegates = list;
            return this;
        }

        public List<String> getDelegates() {
            return this.delegates;
        }

        public Builder setScopes(List<String> list) {
            this.scopes = list;
            return this;
        }

        public List<String> getScopes() {
            return this.scopes;
        }

        public Builder setLifetime(int i) {
            if (i == 0) {
                i = ImpersonatedCredentials.DEFAULT_LIFETIME_IN_SECONDS;
            }
            this.lifetime = i;
            return this;
        }

        public int getLifetime() {
            return this.lifetime;
        }

        public Builder setHttpTransportFactory(HttpTransportFactory httpTransportFactory) {
            this.transportFactory = httpTransportFactory;
            return this;
        }

        public HttpTransportFactory getHttpTransportFactory() {
            return this.transportFactory;
        }

        @Override // com.google.auth.oauth2.GoogleCredentials.Builder
        public Builder setQuotaProjectId(String str) {
            super.setQuotaProjectId(str);
            return this;
        }

        public Builder setIamEndpointOverride(String str) {
            this.iamEndpointOverride = str;
            return this;
        }

        public Builder setCalendar(Calendar calendar) {
            this.calendar = calendar;
            return this;
        }

        public Calendar getCalendar() {
            return this.calendar;
        }

        @Override // com.google.auth.oauth2.GoogleCredentials.Builder, com.google.auth.oauth2.OAuth2Credentials.Builder
        public ImpersonatedCredentials build() {
            return new ImpersonatedCredentials(this, null);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.transportFactory = (HttpTransportFactory) newInstance(this.transportFactoryClassName);
    }
}
