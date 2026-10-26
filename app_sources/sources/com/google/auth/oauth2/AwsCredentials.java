package com.google.auth.oauth2;

import com.google.api.client.json.GenericJson;
import com.google.auth.http.HttpTransportFactory;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* INFO: loaded from: classes3.dex */
public class AwsCredentials extends ExternalAccountCredentials {
    static final String AWS_METRICS_HEADER_VALUE = "aws";
    static final String DEFAULT_REGIONAL_CREDENTIAL_VERIFICATION_URL = "https://sts.{region}.amazonaws.com?Action=GetCallerIdentity&Version=2011-06-15";
    private static final long serialVersionUID = -3670131891574618105L;
    private final AwsSecurityCredentialsSupplier awsSecurityCredentialsSupplier;
    private final String metricsHeaderValue;

    @Nullable
    private final String regionalCredentialVerificationUrl;

    @Nullable
    private final String regionalCredentialVerificationUrlOverride;
    private final ExternalAccountSupplierContext supplierContext;

    AwsCredentials(Builder builder) {
        super(builder);
        this.supplierContext = ExternalAccountSupplierContext.newBuilder().setAudience(getAudience()).setSubjectTokenType(getSubjectTokenType()).build();
        if (builder.awsSecurityCredentialsSupplier != null && builder.credentialSource != null) {
            throw new IllegalArgumentException("AwsCredentials cannot have both an awsSecurityCredentialsSupplier and a credentialSource.");
        }
        if (builder.awsSecurityCredentialsSupplier == null && builder.credentialSource == null) {
            throw new IllegalArgumentException("An awsSecurityCredentialsSupplier or a credentialSource must be provided.");
        }
        AwsCredentialSource awsCredentialSource = (AwsCredentialSource) builder.credentialSource;
        String str = builder.regionalCredentialVerificationUrlOverride;
        this.regionalCredentialVerificationUrlOverride = str;
        if (str != null) {
            this.regionalCredentialVerificationUrl = str;
        } else if (awsCredentialSource != null) {
            this.regionalCredentialVerificationUrl = awsCredentialSource.regionalCredentialVerificationUrl;
        } else {
            this.regionalCredentialVerificationUrl = DEFAULT_REGIONAL_CREDENTIAL_VERIFICATION_URL;
        }
        if (builder.awsSecurityCredentialsSupplier == null) {
            this.awsSecurityCredentialsSupplier = new InternalAwsSecurityCredentialsSupplier(awsCredentialSource, getEnvironmentProvider(), this.transportFactory);
            this.metricsHeaderValue = AWS_METRICS_HEADER_VALUE;
        } else {
            this.awsSecurityCredentialsSupplier = builder.awsSecurityCredentialsSupplier;
            this.metricsHeaderValue = "programmatic";
        }
    }

    @Override // com.google.auth.oauth2.OAuth2Credentials
    public AccessToken refreshAccessToken() throws IOException {
        StsTokenExchangeRequest.Builder audience = StsTokenExchangeRequest.newBuilder(retrieveSubjectToken(), getSubjectTokenType()).setAudience(getAudience());
        Collection<String> scopes = getScopes();
        if (scopes != null && !scopes.isEmpty()) {
            audience.setScopes(new ArrayList(scopes));
        }
        return exchangeExternalCredentialForAccessToken(audience.build());
    }

    @Override // com.google.auth.oauth2.ExternalAccountCredentials
    public String retrieveSubjectToken() throws IOException {
        String region = this.awsSecurityCredentialsSupplier.getRegion(this.supplierContext);
        AwsSecurityCredentials credentials = this.awsSecurityCredentialsSupplier.getCredentials(this.supplierContext);
        HashMap map = new HashMap();
        map.put("x-goog-cloud-target-resource", getAudience());
        return buildSubjectToken(AwsRequestSigner.newBuilder(credentials, "POST", this.regionalCredentialVerificationUrl.replace("{region}", region), region).setAdditionalHeaders(map).build().sign());
    }

    @Override // com.google.auth.oauth2.GoogleCredentials
    public GoogleCredentials createScoped(Collection<String> collection) {
        return new AwsCredentials(newBuilder(this).setScopes(collection));
    }

    @Override // com.google.auth.oauth2.ExternalAccountCredentials
    String getCredentialSourceType() {
        return this.metricsHeaderValue;
    }

    private String buildSubjectToken(AwsRequestSignature awsRequestSignature) throws UnsupportedEncodingException {
        Map<String, String> canonicalHeaders = awsRequestSignature.getCanonicalHeaders();
        ArrayList arrayList = new ArrayList();
        for (String str : canonicalHeaders.keySet()) {
            arrayList.add(formatTokenHeaderForSts(str, canonicalHeaders.get(str)));
        }
        arrayList.add(formatTokenHeaderForSts("Authorization", awsRequestSignature.getAuthorizationHeader()));
        arrayList.add(formatTokenHeaderForSts("x-goog-cloud-target-resource", getAudience()));
        GenericJson genericJson = new GenericJson();
        genericJson.setFactory(OAuth2Utils.JSON_FACTORY);
        genericJson.put("headers", (Object) arrayList);
        genericJson.put("method", (Object) awsRequestSignature.getHttpMethod());
        genericJson.put("url", (Object) this.regionalCredentialVerificationUrl.replace("{region}", awsRequestSignature.getRegion()));
        return URLEncoder.encode(genericJson.toString(), "UTF-8");
    }

    String getRegionalCredentialVerificationUrl() {
        return this.regionalCredentialVerificationUrl;
    }

    String getEnv(String str) {
        return System.getenv(str);
    }

    AwsSecurityCredentialsSupplier getAwsSecurityCredentialsSupplier() {
        return this.awsSecurityCredentialsSupplier;
    }

    @Nullable
    public String getRegionalCredentialVerificationUrlOverride() {
        return this.regionalCredentialVerificationUrlOverride;
    }

    private static GenericJson formatTokenHeaderForSts(String str, String str2) {
        GenericJson genericJson = new GenericJson();
        genericJson.setFactory(OAuth2Utils.JSON_FACTORY);
        genericJson.put("key", (Object) str);
        genericJson.put("value", (Object) str2);
        return genericJson;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(AwsCredentials awsCredentials) {
        return new Builder(awsCredentials);
    }

    public static class Builder extends ExternalAccountCredentials.Builder {
        private AwsSecurityCredentialsSupplier awsSecurityCredentialsSupplier;
        private String regionalCredentialVerificationUrlOverride;

        @Override // com.google.auth.oauth2.ExternalAccountCredentials.Builder
        public /* bridge */ /* synthetic */ ExternalAccountCredentials.Builder setScopes(Collection collection) {
            return setScopes((Collection<String>) collection);
        }

        @Override // com.google.auth.oauth2.ExternalAccountCredentials.Builder
        public /* bridge */ /* synthetic */ ExternalAccountCredentials.Builder setServiceAccountImpersonationOptions(Map map) {
            return setServiceAccountImpersonationOptions((Map<String, Object>) map);
        }

        Builder() {
        }

        Builder(AwsCredentials awsCredentials) {
            super(awsCredentials);
            if (this.credentialSource == null) {
                this.awsSecurityCredentialsSupplier = awsCredentials.awsSecurityCredentialsSupplier;
            }
            this.regionalCredentialVerificationUrlOverride = awsCredentials.regionalCredentialVerificationUrlOverride;
        }

        public Builder setAwsSecurityCredentialsSupplier(AwsSecurityCredentialsSupplier awsSecurityCredentialsSupplier) {
            this.awsSecurityCredentialsSupplier = awsSecurityCredentialsSupplier;
            return this;
        }

        public Builder setRegionalCredentialVerificationUrlOverride(String str) {
            this.regionalCredentialVerificationUrlOverride = str;
            return this;
        }

        @Override // com.google.auth.oauth2.ExternalAccountCredentials.Builder
        public Builder setHttpTransportFactory(HttpTransportFactory httpTransportFactory) {
            super.setHttpTransportFactory(httpTransportFactory);
            return this;
        }

        @Override // com.google.auth.oauth2.ExternalAccountCredentials.Builder
        public Builder setAudience(String str) {
            super.setAudience(str);
            return this;
        }

        @Override // com.google.auth.oauth2.ExternalAccountCredentials.Builder
        public Builder setSubjectTokenType(String str) {
            super.setSubjectTokenType(str);
            return this;
        }

        @Override // com.google.auth.oauth2.ExternalAccountCredentials.Builder
        public Builder setSubjectTokenType(ExternalAccountCredentials.SubjectTokenTypes subjectTokenTypes) {
            super.setSubjectTokenType(subjectTokenTypes);
            return this;
        }

        @Override // com.google.auth.oauth2.ExternalAccountCredentials.Builder
        public Builder setTokenUrl(String str) {
            super.setTokenUrl(str);
            return this;
        }

        public Builder setCredentialSource(AwsCredentialSource awsCredentialSource) {
            super.setCredentialSource((ExternalAccountCredentials.CredentialSource) awsCredentialSource);
            return this;
        }

        @Override // com.google.auth.oauth2.ExternalAccountCredentials.Builder
        public Builder setServiceAccountImpersonationUrl(String str) {
            super.setServiceAccountImpersonationUrl(str);
            return this;
        }

        @Override // com.google.auth.oauth2.ExternalAccountCredentials.Builder
        public Builder setTokenInfoUrl(String str) {
            super.setTokenInfoUrl(str);
            return this;
        }

        @Override // com.google.auth.oauth2.ExternalAccountCredentials.Builder, com.google.auth.oauth2.GoogleCredentials.Builder
        public Builder setQuotaProjectId(String str) {
            super.setQuotaProjectId(str);
            return this;
        }

        @Override // com.google.auth.oauth2.ExternalAccountCredentials.Builder
        public Builder setClientId(String str) {
            super.setClientId(str);
            return this;
        }

        @Override // com.google.auth.oauth2.ExternalAccountCredentials.Builder
        public Builder setClientSecret(String str) {
            super.setClientSecret(str);
            return this;
        }

        @Override // com.google.auth.oauth2.ExternalAccountCredentials.Builder
        public Builder setScopes(Collection<String> collection) {
            super.setScopes(collection);
            return this;
        }

        @Override // com.google.auth.oauth2.ExternalAccountCredentials.Builder
        public Builder setWorkforcePoolUserProject(String str) {
            super.setWorkforcePoolUserProject(str);
            return this;
        }

        @Override // com.google.auth.oauth2.ExternalAccountCredentials.Builder
        public Builder setServiceAccountImpersonationOptions(Map<String, Object> map) {
            super.setServiceAccountImpersonationOptions(map);
            return this;
        }

        @Override // com.google.auth.oauth2.ExternalAccountCredentials.Builder, com.google.auth.oauth2.GoogleCredentials.Builder
        public Builder setUniverseDomain(String str) {
            super.setUniverseDomain(str);
            return this;
        }

        /* INFO: Access modifiers changed from: package-private */
        @Override // com.google.auth.oauth2.ExternalAccountCredentials.Builder
        public Builder setEnvironmentProvider(EnvironmentProvider environmentProvider) {
            super.setEnvironmentProvider(environmentProvider);
            return this;
        }

        @Override // com.google.auth.oauth2.ExternalAccountCredentials.Builder, com.google.auth.oauth2.GoogleCredentials.Builder, com.google.auth.oauth2.OAuth2Credentials.Builder
        public AwsCredentials build() {
            return new AwsCredentials(this);
        }
    }
}
