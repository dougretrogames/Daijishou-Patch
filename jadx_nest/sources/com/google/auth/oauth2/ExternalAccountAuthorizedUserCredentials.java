package com.google.auth.oauth2;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.UrlEncodedContent;
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Preconditions;
import com.google.auth.http.HttpTransportFactory;
import com.google.common.base.MoreObjects;
import com.google.common.io.BaseEncoding;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class ExternalAccountAuthorizedUserCredentials extends GoogleCredentials {
    static final String EXTERNAL_ACCOUNT_AUTHORIZED_USER_FILE_TYPE = "external_account_authorized_user";
    private static final String PARSE_ERROR_PREFIX = "Error parsing token refresh response. ";
    private static final long serialVersionUID = -2181779590486283287L;
    private final String audience;
    private final String clientId;
    private final String clientSecret;
    private String refreshToken;
    private final String revokeUrl;
    private final String tokenInfoUrl;
    private final String tokenUrl;
    private transient HttpTransportFactory transportFactory;
    private final String transportFactoryClassName;

    /* synthetic */ ExternalAccountAuthorizedUserCredentials(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private ExternalAccountAuthorizedUserCredentials(Builder builder) {
        super(builder);
        HttpTransportFactory httpTransportFactory = (HttpTransportFactory) MoreObjects.firstNonNull(builder.transportFactory, getFromServiceLoader(HttpTransportFactory.class, OAuth2Utils.HTTP_TRANSPORT_FACTORY));
        this.transportFactory = httpTransportFactory;
        this.transportFactoryClassName = httpTransportFactory.getClass().getName();
        this.audience = builder.audience;
        this.refreshToken = builder.refreshToken;
        this.tokenUrl = builder.tokenUrl;
        this.tokenInfoUrl = builder.tokenInfoUrl;
        this.revokeUrl = builder.revokeUrl;
        this.clientId = builder.clientId;
        this.clientSecret = builder.clientSecret;
        Preconditions.checkState(getAccessToken() != null || canRefresh(), "ExternalAccountAuthorizedUserCredentials must be initialized with an access token or fields to enable refresh: ('refresh_token', 'token_url', 'client_id', 'client_secret').");
    }

    public static ExternalAccountAuthorizedUserCredentials fromStream(InputStream inputStream) throws IOException {
        com.google.common.base.Preconditions.checkNotNull(inputStream);
        return fromStream(inputStream, OAuth2Utils.HTTP_TRANSPORT_FACTORY);
    }

    public static ExternalAccountAuthorizedUserCredentials fromStream(InputStream inputStream, HttpTransportFactory httpTransportFactory) throws IOException {
        com.google.common.base.Preconditions.checkNotNull(inputStream);
        com.google.common.base.Preconditions.checkNotNull(httpTransportFactory);
        try {
            return fromJson((GenericJson) new JsonObjectParser(OAuth2Utils.JSON_FACTORY).parseAndClose(inputStream, StandardCharsets.UTF_8, GenericJson.class), httpTransportFactory);
        } catch (ClassCastException | IllegalArgumentException e) {
            throw new CredentialFormatException("Invalid input stream provided.", e);
        }
    }

    @Override // com.google.auth.oauth2.OAuth2Credentials
    public AccessToken refreshAccessToken() throws IOException {
        if (!canRefresh()) {
            throw new IllegalStateException("Unable to refresh ExternalAccountAuthorizedUserCredentials. All of 'refresh_token','token_url', 'client_id', 'client_secret' are required to refresh.");
        }
        try {
            HttpResponse httpResponseExecute = buildRefreshRequest().execute();
            GenericData genericData = (GenericData) httpResponseExecute.parseAs(GenericData.class);
            httpResponseExecute.disconnect();
            String strValidateString = OAuth2Utils.validateString(genericData, "access_token", PARSE_ERROR_PREFIX);
            Date date = new Date(this.clock.currentTimeMillis() + (((long) OAuth2Utils.validateInt32(genericData, "expires_in", PARSE_ERROR_PREFIX)) * 1000));
            String strValidateOptionalString = OAuth2Utils.validateOptionalString(genericData, "refresh_token", PARSE_ERROR_PREFIX);
            if (strValidateOptionalString != null && strValidateOptionalString.trim().length() > 0) {
                this.refreshToken = strValidateOptionalString;
            }
            return AccessToken.newBuilder().setExpirationTime(date).setTokenValue(strValidateString).build();
        } catch (HttpResponseException e) {
            throw OAuthException.createFromHttpResponseException(e);
        }
    }

    @Nullable
    public String getAudience() {
        return this.audience;
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
    public String getRevokeUrl() {
        return this.revokeUrl;
    }

    @Nullable
    public String getTokenUrl() {
        return this.tokenUrl;
    }

    @Nullable
    public String getTokenInfoUrl() {
        return this.tokenInfoUrl;
    }

    @Nullable
    public String getRefreshToken() {
        return this.refreshToken;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Override // com.google.auth.oauth2.GoogleCredentials, com.google.auth.oauth2.OAuth2Credentials
    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), getAccessToken(), this.clientId, this.clientSecret, this.refreshToken, this.tokenUrl, this.tokenInfoUrl, this.revokeUrl, this.audience, this.transportFactoryClassName, this.quotaProjectId);
    }

    @Override // com.google.auth.oauth2.GoogleCredentials, com.google.auth.oauth2.OAuth2Credentials
    public String toString() {
        return MoreObjects.toStringHelper(this).add("requestMetadata", getRequestMetadataInternal()).add("temporaryAccess", getAccessToken()).add("clientId", this.clientId).add("clientSecret", this.clientSecret).add("refreshToken", this.refreshToken).add("tokenUrl", this.tokenUrl).add("tokenInfoUrl", this.tokenInfoUrl).add("revokeUrl", this.revokeUrl).add("audience", this.audience).add("transportFactoryClassName", this.transportFactoryClassName).add("quotaProjectId", this.quotaProjectId).toString();
    }

    @Override // com.google.auth.oauth2.GoogleCredentials, com.google.auth.oauth2.OAuth2Credentials
    public boolean equals(Object obj) {
        if (!(obj instanceof ExternalAccountAuthorizedUserCredentials)) {
            return false;
        }
        ExternalAccountAuthorizedUserCredentials externalAccountAuthorizedUserCredentials = (ExternalAccountAuthorizedUserCredentials) obj;
        return super.equals(externalAccountAuthorizedUserCredentials) && Objects.equals(getAccessToken(), externalAccountAuthorizedUserCredentials.getAccessToken()) && Objects.equals(this.clientId, externalAccountAuthorizedUserCredentials.clientId) && Objects.equals(this.clientSecret, externalAccountAuthorizedUserCredentials.clientSecret) && Objects.equals(this.refreshToken, externalAccountAuthorizedUserCredentials.refreshToken) && Objects.equals(this.tokenUrl, externalAccountAuthorizedUserCredentials.tokenUrl) && Objects.equals(this.tokenInfoUrl, externalAccountAuthorizedUserCredentials.tokenInfoUrl) && Objects.equals(this.revokeUrl, externalAccountAuthorizedUserCredentials.revokeUrl) && Objects.equals(this.audience, externalAccountAuthorizedUserCredentials.audience) && Objects.equals(this.transportFactoryClassName, externalAccountAuthorizedUserCredentials.transportFactoryClassName) && Objects.equals(this.quotaProjectId, externalAccountAuthorizedUserCredentials.quotaProjectId);
    }

    @Override // com.google.auth.oauth2.GoogleCredentials, com.google.auth.oauth2.OAuth2Credentials
    public Builder toBuilder() {
        return new Builder(this);
    }

    static ExternalAccountAuthorizedUserCredentials fromJson(Map<String, Object> map, HttpTransportFactory httpTransportFactory) throws IOException {
        String str = (String) map.get("audience");
        String str2 = (String) map.get("refresh_token");
        String str3 = (String) map.get("token_url");
        String str4 = (String) map.get("token_info_url");
        String str5 = (String) map.get("revoke_url");
        String str6 = (String) map.get("client_id");
        String str7 = (String) map.get("client_secret");
        String str8 = (String) map.get("quota_project_id");
        return newBuilder().setAudience(str).setRefreshToken(str2).setTokenUrl(str3).setTokenInfoUrl(str4).setRevokeUrl(str5).setClientId(str6).setClientSecret(str7).setRefreshToken(str2).setHttpTransportFactory(httpTransportFactory).setQuotaProjectId(str8).setUniverseDomain((String) map.get("universe_domain")).build();
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.transportFactory = (HttpTransportFactory) newInstance(this.transportFactoryClassName);
    }

    private boolean canRefresh() {
        String str;
        String str2;
        String str3;
        String str4 = this.refreshToken;
        return str4 != null && str4.trim().length() > 0 && (str = this.tokenUrl) != null && str.trim().length() > 0 && (str2 = this.clientId) != null && str2.trim().length() > 0 && (str3 = this.clientSecret) != null && str3.trim().length() > 0;
    }

    private HttpRequest buildRefreshRequest() throws IOException {
        GenericData genericData = new GenericData();
        genericData.set("grant_type", "refresh_token");
        genericData.set("refresh_token", this.refreshToken);
        HttpRequest httpRequestBuildPostRequest = this.transportFactory.create().createRequestFactory().buildPostRequest(new GenericUrl(this.tokenUrl), new UrlEncodedContent(genericData));
        httpRequestBuildPostRequest.setParser(new JsonObjectParser(OAuth2Utils.JSON_FACTORY));
        httpRequestBuildPostRequest.getHeaders().setAuthorization(String.format("Basic %s", BaseEncoding.base64().encode(String.format("%s:%s", this.clientId, this.clientSecret).getBytes(StandardCharsets.UTF_8))));
        return httpRequestBuildPostRequest;
    }

    public static class Builder extends GoogleCredentials.Builder {
        private String audience;
        private String clientId;
        private String clientSecret;
        private String refreshToken;
        private String revokeUrl;
        private String tokenInfoUrl;
        private String tokenUrl;
        private HttpTransportFactory transportFactory;

        protected Builder() {
        }

        protected Builder(ExternalAccountAuthorizedUserCredentials externalAccountAuthorizedUserCredentials) {
            super(externalAccountAuthorizedUserCredentials);
            this.transportFactory = externalAccountAuthorizedUserCredentials.transportFactory;
            this.audience = externalAccountAuthorizedUserCredentials.audience;
            this.refreshToken = externalAccountAuthorizedUserCredentials.refreshToken;
            this.tokenUrl = externalAccountAuthorizedUserCredentials.tokenUrl;
            this.tokenInfoUrl = externalAccountAuthorizedUserCredentials.tokenInfoUrl;
            this.revokeUrl = externalAccountAuthorizedUserCredentials.revokeUrl;
            this.clientId = externalAccountAuthorizedUserCredentials.clientId;
            this.clientSecret = externalAccountAuthorizedUserCredentials.clientSecret;
        }

        public Builder setHttpTransportFactory(HttpTransportFactory httpTransportFactory) {
            this.transportFactory = httpTransportFactory;
            return this;
        }

        public Builder setAudience(String str) {
            this.audience = str;
            return this;
        }

        public Builder setTokenUrl(String str) {
            this.tokenUrl = str;
            return this;
        }

        public Builder setTokenInfoUrl(String str) {
            this.tokenInfoUrl = str;
            return this;
        }

        public Builder setRevokeUrl(String str) {
            this.revokeUrl = str;
            return this;
        }

        public Builder setRefreshToken(String str) {
            this.refreshToken = str;
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

        @Override // com.google.auth.oauth2.GoogleCredentials.Builder
        public Builder setQuotaProjectId(String str) {
            super.setQuotaProjectId(str);
            return this;
        }

        @Override // com.google.auth.oauth2.GoogleCredentials.Builder, com.google.auth.oauth2.OAuth2Credentials.Builder
        public Builder setAccessToken(AccessToken accessToken) {
            super.setAccessToken(accessToken);
            return this;
        }

        @Override // com.google.auth.oauth2.GoogleCredentials.Builder
        public Builder setUniverseDomain(String str) {
            super.setUniverseDomain(str);
            return this;
        }

        @Override // com.google.auth.oauth2.GoogleCredentials.Builder, com.google.auth.oauth2.OAuth2Credentials.Builder
        public ExternalAccountAuthorizedUserCredentials build() {
            return new ExternalAccountAuthorizedUserCredentials(this, null);
        }
    }
}
