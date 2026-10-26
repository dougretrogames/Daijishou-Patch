package com.google.auth.oauth2;

import java.io.Serializable;

/* INFO: loaded from: classes3.dex */
class ExternalAccountMetricsHandler implements Serializable {
    private static final String BYOID_METRICS_SECTION = "google-byoid-sdk";
    private static final String CONFIG_LIFETIME_KEY = "config-lifetime";
    private static final String IMPERSONATION_KEY = "sa-impersonation";
    private static final String SOURCE_KEY = "source";
    private final boolean configLifetime;
    private ExternalAccountCredentials credentials;
    private final boolean saImpersonation;

    ExternalAccountMetricsHandler(ExternalAccountCredentials externalAccountCredentials) {
        this.saImpersonation = externalAccountCredentials.getServiceAccountImpersonationUrl() != null;
        this.configLifetime = externalAccountCredentials.getServiceAccountImpersonationOptions().customTokenLifetimeRequested;
        this.credentials = externalAccountCredentials;
    }

    String getExternalAccountMetricsHeader() {
        return String.format("%s %s %s/%s %s/%s %s/%s", MetricsUtils.getLanguageAndAuthLibraryVersions(), BYOID_METRICS_SECTION, SOURCE_KEY, this.credentials.getCredentialSourceType(), IMPERSONATION_KEY, Boolean.valueOf(this.saImpersonation), CONFIG_LIFETIME_KEY, Boolean.valueOf(this.configLifetime));
    }
}
