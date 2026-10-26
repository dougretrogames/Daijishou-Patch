package com.google.auth.oauth2;

import com.google.auth.http.HttpTransportFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* INFO: loaded from: classes3.dex */
public class IdentityPoolCredentials extends ExternalAccountCredentials {
    static final String FILE_METRICS_HEADER_VALUE = "file";
    static final String URL_METRICS_HEADER_VALUE = "url";
    private static final long serialVersionUID = 2471046175477275881L;
    private final String metricsHeaderValue;
    private final IdentityPoolSubjectTokenSupplier subjectTokenSupplier;
    private final ExternalAccountSupplierContext supplierContext;

    @Override // com.google.auth.oauth2.GoogleCredentials
    public /* bridge */ /* synthetic */ GoogleCredentials createScoped(Collection collection) {
        return createScoped((Collection<String>) collection);
    }

    IdentityPoolCredentials(Builder builder) {
        super(builder);
        IdentityPoolCredentialSource identityPoolCredentialSource = (IdentityPoolCredentialSource) builder.credentialSource;
        this.supplierContext = ExternalAccountSupplierContext.newBuilder().setAudience(getAudience()).setSubjectTokenType(getSubjectTokenType()).build();
        if (builder.subjectTokenSupplier != null && identityPoolCredentialSource != null) {
            throw new IllegalArgumentException("IdentityPoolCredentials cannot have both a subjectTokenSupplier and a credentialSource.");
        }
        if (builder.subjectTokenSupplier == null && identityPoolCredentialSource == null) {
            throw new IllegalArgumentException("A subjectTokenSupplier or a credentialSource must be provided.");
        }
        if (builder.subjectTokenSupplier == null) {
            if (identityPoolCredentialSource.credentialSourceType == IdentityPoolCredentialSource.IdentityPoolCredentialSourceType.FILE) {
                this.subjectTokenSupplier = new FileIdentityPoolSubjectTokenSupplier(identityPoolCredentialSource);
                this.metricsHeaderValue = FILE_METRICS_HEADER_VALUE;
                return;
            } else {
                this.subjectTokenSupplier = new UrlIdentityPoolSubjectTokenSupplier(identityPoolCredentialSource, this.transportFactory);
                this.metricsHeaderValue = "url";
                return;
            }
        }
        this.subjectTokenSupplier = builder.subjectTokenSupplier;
        this.metricsHeaderValue = "programmatic";
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
        return this.subjectTokenSupplier.getSubjectToken(this.supplierContext);
    }

    @Override // com.google.auth.oauth2.ExternalAccountCredentials
    String getCredentialSourceType() {
        return this.metricsHeaderValue;
    }

    IdentityPoolSubjectTokenSupplier getIdentityPoolSubjectTokenSupplier() {
        return this.subjectTokenSupplier;
    }

    @Override // com.google.auth.oauth2.GoogleCredentials
    public IdentityPoolCredentials createScoped(Collection<String> collection) {
        return new IdentityPoolCredentials(newBuilder(this).setScopes(collection));
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(IdentityPoolCredentials identityPoolCredentials) {
        return new Builder(identityPoolCredentials);
    }

    public static class Builder extends ExternalAccountCredentials.Builder {
        private IdentityPoolSubjectTokenSupplier subjectTokenSupplier;

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

        Builder(IdentityPoolCredentials identityPoolCredentials) {
            super(identityPoolCredentials);
            if (this.credentialSource == null) {
                this.subjectTokenSupplier = identityPoolCredentials.subjectTokenSupplier;
            }
        }

        public Builder setSubjectTokenSupplier(IdentityPoolSubjectTokenSupplier identityPoolSubjectTokenSupplier) {
            this.subjectTokenSupplier = identityPoolSubjectTokenSupplier;
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

        public Builder setCredentialSource(IdentityPoolCredentialSource identityPoolCredentialSource) {
            super.setCredentialSource((ExternalAccountCredentials.CredentialSource) identityPoolCredentialSource);
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
        public IdentityPoolCredentials build() {
            return new IdentityPoolCredentials(this);
        }
    }
}
