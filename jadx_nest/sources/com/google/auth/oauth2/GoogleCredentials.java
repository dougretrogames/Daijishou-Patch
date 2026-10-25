package com.google.auth.oauth2;

import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.util.Preconditions;
import com.google.auth.Credentials;
import com.google.auth.http.HttpTransportFactory;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class GoogleCredentials extends OAuth2Credentials implements QuotaProjectIdProvider {
    static final String GDCH_SERVICE_ACCOUNT_FILE_TYPE = "gdch_service_account";
    static final String QUOTA_PROJECT_ID_HEADER_KEY = "x-goog-user-project";
    static final String SERVICE_ACCOUNT_FILE_TYPE = "service_account";
    static final String USER_FILE_TYPE = "authorized_user";
    private static final DefaultCredentialsProvider defaultCredentialsProvider = new DefaultCredentialsProvider();
    private static final long serialVersionUID = -1522852442442473691L;
    private final boolean isExplicitUniverseDomain;
    protected final String quotaProjectId;
    private final String universeDomain;

    public GoogleCredentials createDelegated(String str) {
        return this;
    }

    public GoogleCredentials createScoped(Collection<String> collection) {
        return this;
    }

    public GoogleCredentials createScoped(Collection<String> collection, Collection<String> collection2) {
        return this;
    }

    public boolean createScopedRequired() {
        return false;
    }

    public GoogleCredentials createWithCustomRetryStrategy(boolean z) {
        return this;
    }

    public static GoogleCredentials create(AccessToken accessToken) {
        return newBuilder().setAccessToken(accessToken).build();
    }

    public static GoogleCredentials create(String str, AccessToken accessToken) {
        return newBuilder().setAccessToken(accessToken).setUniverseDomain(str).build();
    }

    public static GoogleCredentials getApplicationDefault() throws IOException {
        return getApplicationDefault(OAuth2Utils.HTTP_TRANSPORT_FACTORY);
    }

    public static GoogleCredentials getApplicationDefault(HttpTransportFactory httpTransportFactory) throws IOException {
        Preconditions.checkNotNull(httpTransportFactory);
        return defaultCredentialsProvider.getDefaultCredentials(httpTransportFactory);
    }

    public static GoogleCredentials fromStream(InputStream inputStream) throws IOException {
        return fromStream(inputStream, OAuth2Utils.HTTP_TRANSPORT_FACTORY);
    }

    public static GoogleCredentials fromStream(InputStream inputStream, HttpTransportFactory httpTransportFactory) throws IOException {
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(httpTransportFactory);
        GenericJson genericJson = (GenericJson) new JsonObjectParser(OAuth2Utils.JSON_FACTORY).parseAndClose(inputStream, StandardCharsets.UTF_8, GenericJson.class);
        String str = (String) genericJson.get("type");
        if (str == null) {
            throw new IOException("Error reading credentials from stream, 'type' field not specified.");
        }
        if (USER_FILE_TYPE.equals(str)) {
            return UserCredentials.fromJson(genericJson, httpTransportFactory);
        }
        if (SERVICE_ACCOUNT_FILE_TYPE.equals(str)) {
            return ServiceAccountCredentials.fromJson(genericJson, httpTransportFactory);
        }
        if (GDCH_SERVICE_ACCOUNT_FILE_TYPE.equals(str)) {
            return GdchCredentials.fromJson(genericJson);
        }
        if ("external_account".equals(str)) {
            return ExternalAccountCredentials.fromJson(genericJson, httpTransportFactory);
        }
        if ("external_account_authorized_user".equals(str)) {
            return ExternalAccountAuthorizedUserCredentials.fromJson(genericJson, httpTransportFactory);
        }
        if ("impersonated_service_account".equals(str)) {
            return ImpersonatedCredentials.fromJson(genericJson, httpTransportFactory);
        }
        throw new IOException(String.format("Error reading credentials from stream, 'type' value '%s' not recognized. Valid values are '%s', '%s', '%s', '%s', '%s', '%s'.", str, USER_FILE_TYPE, SERVICE_ACCOUNT_FILE_TYPE, GDCH_SERVICE_ACCOUNT_FILE_TYPE, "external_account", "external_account_authorized_user", "impersonated_service_account"));
    }

    public GoogleCredentials createWithQuotaProject(String str) {
        return toBuilder().setQuotaProjectId(str).build();
    }

    @Override // com.google.auth.Credentials
    public String getUniverseDomain() throws IOException {
        return this.universeDomain;
    }

    protected boolean isExplicitUniverseDomain() {
        return this.isExplicitUniverseDomain;
    }

    boolean isDefaultUniverseDomain() {
        return this.universeDomain.equals(Credentials.GOOGLE_DEFAULT_UNIVERSE);
    }

    static Map<String, List<String>> addQuotaProjectIdToRequestMetadata(String str, Map<String, List<String>> map) {
        Preconditions.checkNotNull(map);
        HashMap map2 = new HashMap(map);
        if (str != null && !map.containsKey(QUOTA_PROJECT_ID_HEADER_KEY)) {
            map2.put(QUOTA_PROJECT_ID_HEADER_KEY, Collections.singletonList(str));
        }
        return Collections.unmodifiableMap(map2);
    }

    @Override // com.google.auth.oauth2.OAuth2Credentials
    protected Map<String, List<String>> getAdditionalHeaders() {
        Map<String, List<String>> additionalHeaders = super.getAdditionalHeaders();
        String quotaProjectId = getQuotaProjectId();
        return quotaProjectId != null ? addQuotaProjectIdToRequestMetadata(quotaProjectId, additionalHeaders) : additionalHeaders;
    }

    protected GoogleCredentials() {
        this(new Builder());
    }

    @Deprecated
    protected GoogleCredentials(AccessToken accessToken, String str) {
        this(newBuilder().setAccessToken(accessToken).setQuotaProjectId(str));
    }

    @Deprecated
    public GoogleCredentials(AccessToken accessToken) {
        this(accessToken, null);
    }

    protected GoogleCredentials(Builder builder) {
        super(builder.getAccessToken(), builder.getRefreshMargin(), builder.getExpirationMargin());
        this.quotaProjectId = builder.getQuotaProjectId();
        if (builder.universeDomain == null || builder.universeDomain.trim().isEmpty()) {
            this.universeDomain = Credentials.GOOGLE_DEFAULT_UNIVERSE;
            this.isExplicitUniverseDomain = false;
        } else {
            this.universeDomain = builder.getUniverseDomain();
            this.isExplicitUniverseDomain = true;
        }
    }

    @Deprecated
    protected GoogleCredentials(AccessToken accessToken, Duration duration, Duration duration2) {
        this((Builder) newBuilder().setAccessToken(accessToken).setRefreshMargin(duration).setExpirationMargin(duration2));
    }

    protected MoreObjects.ToStringHelper toStringHelper() {
        return MoreObjects.toStringHelper(this).omitNullValues().add("quotaProjectId", this.quotaProjectId).add("universeDomain", this.universeDomain).add("isExplicitUniverseDomain", this.isExplicitUniverseDomain);
    }

    @Override // com.google.auth.oauth2.OAuth2Credentials
    public String toString() {
        return toStringHelper().toString();
    }

    @Override // com.google.auth.oauth2.OAuth2Credentials
    public boolean equals(Object obj) {
        if (!(obj instanceof GoogleCredentials)) {
            return false;
        }
        GoogleCredentials googleCredentials = (GoogleCredentials) obj;
        return Objects.equals(this.quotaProjectId, googleCredentials.quotaProjectId) && Objects.equals(this.universeDomain, googleCredentials.universeDomain) && Objects.equals(Boolean.valueOf(this.isExplicitUniverseDomain), Boolean.valueOf(googleCredentials.isExplicitUniverseDomain));
    }

    @Override // com.google.auth.oauth2.OAuth2Credentials
    public int hashCode() {
        return Objects.hash(this.quotaProjectId, this.universeDomain, Boolean.valueOf(this.isExplicitUniverseDomain));
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Override // com.google.auth.oauth2.OAuth2Credentials
    public Builder toBuilder() {
        return new Builder(this);
    }

    @Override // com.google.auth.oauth2.QuotaProjectIdProvider
    public String getQuotaProjectId() {
        return this.quotaProjectId;
    }

    public GoogleCredentials createScoped(String... strArr) {
        return createScoped(ImmutableList.copyOf(strArr));
    }

    public static class Builder extends OAuth2Credentials.Builder {

        @Nullable
        protected String quotaProjectId;

        @Nullable
        protected String universeDomain;

        protected Builder() {
        }

        protected Builder(GoogleCredentials googleCredentials) {
            super(googleCredentials);
            this.quotaProjectId = googleCredentials.quotaProjectId;
            if (googleCredentials.isExplicitUniverseDomain) {
                this.universeDomain = googleCredentials.universeDomain;
            }
        }

        protected Builder(Builder builder) {
            setAccessToken(builder.getAccessToken());
            this.quotaProjectId = builder.quotaProjectId;
            this.universeDomain = builder.universeDomain;
        }

        @Override // com.google.auth.oauth2.OAuth2Credentials.Builder
        public GoogleCredentials build() {
            return new GoogleCredentials(this);
        }

        public Builder setQuotaProjectId(String str) {
            this.quotaProjectId = str;
            return this;
        }

        public Builder setUniverseDomain(String str) {
            this.universeDomain = str;
            return this;
        }

        public String getQuotaProjectId() {
            return this.quotaProjectId;
        }

        public String getUniverseDomain() {
            return this.universeDomain;
        }

        @Override // com.google.auth.oauth2.OAuth2Credentials.Builder
        public Builder setAccessToken(AccessToken accessToken) {
            super.setAccessToken(accessToken);
            return this;
        }
    }
}
