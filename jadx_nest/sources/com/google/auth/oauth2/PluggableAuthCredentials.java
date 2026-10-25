package com.google.auth.oauth2;

import com.google.auth.http.HttpTransportFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class PluggableAuthCredentials extends ExternalAccountCredentials {
    static final String PLUGGABLE_AUTH_METRICS_HEADER_VALUE = "executable";
    private final PluggableAuthCredentialSource config;
    private final ExecutableHandler handler;

    @Override // com.google.auth.oauth2.GoogleCredentials
    public /* bridge */ /* synthetic */ GoogleCredentials createScoped(Collection collection) {
        return createScoped((Collection<String>) collection);
    }

    PluggableAuthCredentials(Builder builder) {
        super(builder);
        this.config = (PluggableAuthCredentialSource) builder.credentialSource;
        if (builder.handler == null) {
            this.handler = new PluggableAuthHandler(getEnvironmentProvider());
        } else {
            this.handler = builder.handler;
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
        String command = this.config.getCommand();
        String outputFilePath = this.config.getOutputFilePath();
        int timeoutMs = this.config.getTimeoutMs();
        HashMap map = new HashMap();
        map.put("GOOGLE_EXTERNAL_ACCOUNT_AUDIENCE", getAudience());
        map.put("GOOGLE_EXTERNAL_ACCOUNT_TOKEN_TYPE", getSubjectTokenType());
        map.put("GOOGLE_EXTERNAL_ACCOUNT_INTERACTIVE", "0");
        if (getServiceAccountEmail() != null) {
            map.put("GOOGLE_EXTERNAL_ACCOUNT_IMPERSONATED_EMAIL", getServiceAccountEmail());
        }
        if (outputFilePath != null && !outputFilePath.isEmpty()) {
            map.put("GOOGLE_EXTERNAL_ACCOUNT_OUTPUT_FILE", outputFilePath);
        }
        return this.handler.retrieveTokenFromExecutable(new AnonymousClass1(command, map, timeoutMs, outputFilePath));
    }

    /* JADX INFO: renamed from: com.google.auth.oauth2.PluggableAuthCredentials$1, reason: invalid class name */
    class AnonymousClass1 implements ExecutableHandler.ExecutableOptions {
        final /* synthetic */ Map val$envMap;
        final /* synthetic */ String val$executableCommand;
        final /* synthetic */ int val$executableTimeoutMs;
        final /* synthetic */ String val$outputFilePath;

        AnonymousClass1(String str, Map map, int i, String str2) {
            this.val$executableCommand = str;
            this.val$envMap = map;
            this.val$executableTimeoutMs = i;
            this.val$outputFilePath = str2;
        }

        @Override // com.google.auth.oauth2.ExecutableHandler.ExecutableOptions
        public String getExecutableCommand() {
            return this.val$executableCommand;
        }

        @Override // com.google.auth.oauth2.ExecutableHandler.ExecutableOptions
        public Map<String, String> getEnvironmentMap() {
            return this.val$envMap;
        }

        @Override // com.google.auth.oauth2.ExecutableHandler.ExecutableOptions
        public int getExecutableTimeoutMs() {
            return this.val$executableTimeoutMs;
        }

        @Override // com.google.auth.oauth2.ExecutableHandler.ExecutableOptions
        @Nullable
        public String getOutputFilePath() {
            return this.val$outputFilePath;
        }
    }

    @Override // com.google.auth.oauth2.GoogleCredentials
    public PluggableAuthCredentials createScoped(Collection<String> collection) {
        return new PluggableAuthCredentials(newBuilder(this).setScopes(collection));
    }

    @Override // com.google.auth.oauth2.ExternalAccountCredentials
    String getCredentialSourceType() {
        return PLUGGABLE_AUTH_METRICS_HEADER_VALUE;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(PluggableAuthCredentials pluggableAuthCredentials) {
        return new Builder(pluggableAuthCredentials);
    }

    @Nullable
    ExecutableHandler getExecutableHandler() {
        return this.handler;
    }

    public static class Builder extends ExternalAccountCredentials.Builder {
        private ExecutableHandler handler;

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

        Builder(PluggableAuthCredentials pluggableAuthCredentials) {
            super(pluggableAuthCredentials);
            this.handler = pluggableAuthCredentials.handler;
        }

        public Builder setExecutableHandler(ExecutableHandler executableHandler) {
            this.handler = executableHandler;
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

        public Builder setCredentialSource(PluggableAuthCredentialSource pluggableAuthCredentialSource) {
            super.setCredentialSource((ExternalAccountCredentials.CredentialSource) pluggableAuthCredentialSource);
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

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.auth.oauth2.ExternalAccountCredentials.Builder
        public Builder setEnvironmentProvider(EnvironmentProvider environmentProvider) {
            super.setEnvironmentProvider(environmentProvider);
            return this;
        }

        @Override // com.google.auth.oauth2.ExternalAccountCredentials.Builder, com.google.auth.oauth2.GoogleCredentials.Builder, com.google.auth.oauth2.OAuth2Credentials.Builder
        public PluggableAuthCredentials build() {
            return new PluggableAuthCredentials(this);
        }
    }
}
