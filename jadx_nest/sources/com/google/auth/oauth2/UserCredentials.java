package com.google.auth.oauth2;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.UrlEncodedContent;
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Preconditions;
import com.google.auth.http.HttpTransportFactory;
import com.google.common.base.MoreObjects;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class UserCredentials extends GoogleCredentials implements IdTokenProvider {
    private static final String GRANT_TYPE = "refresh_token";
    private static final String PARSE_ERROR_PREFIX = "Error parsing token refresh response. ";
    private static final long serialVersionUID = -4800758775038679176L;
    private final String clientId;
    private final String clientSecret;
    private final String refreshToken;
    private final URI tokenServerUri;
    private transient HttpTransportFactory transportFactory;
    private final String transportFactoryClassName;

    /* synthetic */ UserCredentials(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private UserCredentials(Builder builder) {
        super(builder);
        this.clientId = (String) Preconditions.checkNotNull(builder.clientId);
        this.clientSecret = (String) Preconditions.checkNotNull(builder.clientSecret);
        this.refreshToken = builder.refreshToken;
        this.transportFactory = (HttpTransportFactory) MoreObjects.firstNonNull(builder.transportFactory, getFromServiceLoader(HttpTransportFactory.class, OAuth2Utils.HTTP_TRANSPORT_FACTORY));
        this.tokenServerUri = builder.tokenServerUri == null ? OAuth2Utils.TOKEN_SERVER_URI : builder.tokenServerUri;
        this.transportFactoryClassName = this.transportFactory.getClass().getName();
        Preconditions.checkState((builder.getAccessToken() == null && builder.refreshToken == null) ? false : true, "Either accessToken or refreshToken must not be null");
    }

    static UserCredentials fromJson(Map<String, Object> map, HttpTransportFactory httpTransportFactory) throws IOException {
        String str = (String) map.get("client_id");
        String str2 = (String) map.get("client_secret");
        String str3 = (String) map.get(GRANT_TYPE);
        String str4 = (String) map.get("quota_project_id");
        if (str == null || str2 == null || str3 == null) {
            throw new IOException("Error reading user credential from JSON,  expecting 'client_id', 'client_secret' and 'refresh_token'.");
        }
        return newBuilder().setClientId(str).setClientSecret(str2).setRefreshToken(str3).setAccessToken((AccessToken) null).setHttpTransportFactory(httpTransportFactory).setTokenServerUri(null).setQuotaProjectId(str4).build();
    }

    public static UserCredentials fromStream(InputStream inputStream) throws IOException {
        return fromStream(inputStream, OAuth2Utils.HTTP_TRANSPORT_FACTORY);
    }

    public static UserCredentials fromStream(InputStream inputStream, HttpTransportFactory httpTransportFactory) throws IOException {
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(httpTransportFactory);
        GenericJson genericJson = (GenericJson) new JsonObjectParser(OAuth2Utils.JSON_FACTORY).parseAndClose(inputStream, StandardCharsets.UTF_8, GenericJson.class);
        String str = (String) genericJson.get("type");
        if (str == null) {
            throw new IOException("Error reading credentials from stream, 'type' field not specified.");
        }
        if ("authorized_user".equals(str)) {
            return fromJson(genericJson, httpTransportFactory);
        }
        throw new IOException(String.format("Error reading credentials from stream, 'type' value '%s' not recognized. Expecting '%s'.", str, "authorized_user"));
    }

    @Override // com.google.auth.oauth2.OAuth2Credentials
    public AccessToken refreshAccessToken() throws IOException {
        GenericData genericDataDoRefreshAccessToken = doRefreshAccessToken();
        String strValidateString = OAuth2Utils.validateString(genericDataDoRefreshAccessToken, "access_token", PARSE_ERROR_PREFIX);
        long jCurrentTimeMillis = this.clock.currentTimeMillis() + ((long) (OAuth2Utils.validateInt32(genericDataDoRefreshAccessToken, "expires_in", PARSE_ERROR_PREFIX) * 1000));
        return AccessToken.newBuilder().setExpirationTime(new Date(jCurrentTimeMillis)).setTokenValue(strValidateString).setScopes(OAuth2Utils.validateOptionalString(genericDataDoRefreshAccessToken, "scope", PARSE_ERROR_PREFIX)).build();
    }

    @Override // com.google.auth.oauth2.IdTokenProvider
    public IdToken idTokenWithAudience(String str, List<IdTokenProvider.Option> list) throws IOException {
        GenericData genericDataDoRefreshAccessToken = doRefreshAccessToken();
        if (genericDataDoRefreshAccessToken.containsKey("id_token")) {
            return IdToken.create(OAuth2Utils.validateString(genericDataDoRefreshAccessToken, "id_token", PARSE_ERROR_PREFIX));
        }
        throw new IOException("UserCredentials can obtain an id token only when authenticated through gcloud running 'gcloud auth login --update-adc' or 'gcloud auth application-default login'. The latter form would not work for Cloud Run, but would still generate an id token.");
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final String getClientSecret() {
        return this.clientSecret;
    }

    public final String getRefreshToken() {
        return this.refreshToken;
    }

    private GenericData doRefreshAccessToken() throws IOException {
        if (this.refreshToken == null) {
            throw new IllegalStateException("UserCredentials instance cannot refresh because there is no refresh token.");
        }
        GenericData genericData = new GenericData();
        genericData.set("client_id", this.clientId);
        genericData.set("client_secret", this.clientSecret);
        genericData.set(GRANT_TYPE, this.refreshToken);
        genericData.set("grant_type", GRANT_TYPE);
        HttpRequest httpRequestBuildPostRequest = this.transportFactory.create().createRequestFactory().buildPostRequest(new GenericUrl(this.tokenServerUri), new UrlEncodedContent(genericData));
        httpRequestBuildPostRequest.setParser(new JsonObjectParser(OAuth2Utils.JSON_FACTORY));
        try {
            return (GenericData) httpRequestBuildPostRequest.execute().parseAs(GenericData.class);
        } catch (HttpResponseException e) {
            throw GoogleAuthException.createWithTokenEndpointResponseException(e);
        } catch (IOException e2) {
            throw GoogleAuthException.createWithTokenEndpointIOException(e2);
        }
    }

    private InputStream getUserCredentialsStream() throws IOException {
        GenericJson genericJson = new GenericJson();
        genericJson.put("type", (Object) "authorized_user");
        String str = this.refreshToken;
        if (str != null) {
            genericJson.put(GRANT_TYPE, (Object) str);
        }
        URI uri = this.tokenServerUri;
        if (uri != null) {
            genericJson.put("token_server_uri", (Object) uri);
        }
        String str2 = this.clientId;
        if (str2 != null) {
            genericJson.put("client_id", (Object) str2);
        }
        String str3 = this.clientSecret;
        if (str3 != null) {
            genericJson.put("client_secret", (Object) str3);
        }
        if (this.quotaProjectId != null) {
            genericJson.put("quota_project", (Object) this.clientSecret);
        }
        genericJson.setFactory(OAuth2Utils.JSON_FACTORY);
        return new ByteArrayInputStream(genericJson.toPrettyString().getBytes(StandardCharsets.UTF_8));
    }

    public void save(String str) throws IOException {
        OAuth2Utils.writeInputStreamToFile(getUserCredentialsStream(), str);
    }

    @Override // com.google.auth.oauth2.GoogleCredentials, com.google.auth.oauth2.OAuth2Credentials
    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), getAccessToken(), this.clientId, this.clientSecret, this.refreshToken, this.tokenServerUri, this.transportFactoryClassName, this.quotaProjectId);
    }

    @Override // com.google.auth.oauth2.GoogleCredentials, com.google.auth.oauth2.OAuth2Credentials
    public String toString() {
        return MoreObjects.toStringHelper(this).add("requestMetadata", getRequestMetadataInternal()).add("temporaryAccess", getAccessToken()).add("clientId", this.clientId).add("refreshToken", this.refreshToken).add("tokenServerUri", this.tokenServerUri).add("transportFactoryClassName", this.transportFactoryClassName).add("quotaProjectId", this.quotaProjectId).toString();
    }

    @Override // com.google.auth.oauth2.GoogleCredentials, com.google.auth.oauth2.OAuth2Credentials
    public boolean equals(Object obj) {
        if (!(obj instanceof UserCredentials)) {
            return false;
        }
        UserCredentials userCredentials = (UserCredentials) obj;
        return super.equals(userCredentials) && Objects.equals(getAccessToken(), userCredentials.getAccessToken()) && Objects.equals(this.clientId, userCredentials.clientId) && Objects.equals(this.clientSecret, userCredentials.clientSecret) && Objects.equals(this.refreshToken, userCredentials.refreshToken) && Objects.equals(this.tokenServerUri, userCredentials.tokenServerUri) && Objects.equals(this.transportFactoryClassName, userCredentials.transportFactoryClassName) && Objects.equals(this.quotaProjectId, userCredentials.quotaProjectId);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.transportFactory = (HttpTransportFactory) newInstance(this.transportFactoryClassName);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Override // com.google.auth.oauth2.GoogleCredentials, com.google.auth.oauth2.OAuth2Credentials
    public Builder toBuilder() {
        return new Builder(this);
    }

    public static class Builder extends GoogleCredentials.Builder {
        private String clientId;
        private String clientSecret;
        private String refreshToken;
        private URI tokenServerUri;
        private HttpTransportFactory transportFactory;

        protected Builder() {
        }

        protected Builder(UserCredentials userCredentials) {
            super(userCredentials);
            this.clientId = userCredentials.clientId;
            this.clientSecret = userCredentials.clientSecret;
            this.refreshToken = userCredentials.refreshToken;
            this.transportFactory = userCredentials.transportFactory;
            this.tokenServerUri = userCredentials.tokenServerUri;
        }

        public Builder setClientId(String str) {
            this.clientId = str;
            return this;
        }

        public Builder setClientSecret(String str) {
            this.clientSecret = str;
            return this;
        }

        public Builder setRefreshToken(String str) {
            this.refreshToken = str;
            return this;
        }

        public Builder setTokenServerUri(URI uri) {
            this.tokenServerUri = uri;
            return this;
        }

        public Builder setHttpTransportFactory(HttpTransportFactory httpTransportFactory) {
            this.transportFactory = httpTransportFactory;
            return this;
        }

        @Override // com.google.auth.oauth2.GoogleCredentials.Builder, com.google.auth.oauth2.OAuth2Credentials.Builder
        public Builder setAccessToken(AccessToken accessToken) {
            super.setAccessToken(accessToken);
            return this;
        }

        @Override // com.google.auth.oauth2.OAuth2Credentials.Builder
        public Builder setExpirationMargin(Duration duration) {
            super.setExpirationMargin(duration);
            return this;
        }

        @Override // com.google.auth.oauth2.OAuth2Credentials.Builder
        public Builder setRefreshMargin(Duration duration) {
            super.setRefreshMargin(duration);
            return this;
        }

        @Override // com.google.auth.oauth2.GoogleCredentials.Builder
        public Builder setQuotaProjectId(String str) {
            super.setQuotaProjectId(str);
            return this;
        }

        public String getClientId() {
            return this.clientId;
        }

        public String getClientSecret() {
            return this.clientSecret;
        }

        public String getRefreshToken() {
            return this.refreshToken;
        }

        public URI getTokenServerUri() {
            return this.tokenServerUri;
        }

        public HttpTransportFactory getHttpTransportFactory() {
            return this.transportFactory;
        }

        @Override // com.google.auth.oauth2.GoogleCredentials.Builder, com.google.auth.oauth2.OAuth2Credentials.Builder
        public UserCredentials build() {
            return new UserCredentials(this, null);
        }
    }
}
