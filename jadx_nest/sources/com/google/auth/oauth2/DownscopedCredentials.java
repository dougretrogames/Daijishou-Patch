package com.google.auth.oauth2;

import com.google.auth.Credentials;
import com.google.auth.http.HttpTransportFactory;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class DownscopedCredentials extends OAuth2Credentials {
    private final String TOKEN_EXCHANGE_URL_FORMAT;
    private final CredentialAccessBoundary credentialAccessBoundary;
    private final GoogleCredentials sourceCredential;
    private final String tokenExchangeEndpoint;
    private final transient HttpTransportFactory transportFactory;
    private final String universeDomain;

    /* synthetic */ DownscopedCredentials(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private DownscopedCredentials(Builder builder) {
        this.TOKEN_EXCHANGE_URL_FORMAT = "https://sts.{universe_domain}/v1/token";
        this.transportFactory = (HttpTransportFactory) MoreObjects.firstNonNull(builder.transportFactory, getFromServiceLoader(HttpTransportFactory.class, OAuth2Utils.HTTP_TRANSPORT_FACTORY));
        GoogleCredentials googleCredentials = (GoogleCredentials) Preconditions.checkNotNull(builder.sourceCredential);
        this.sourceCredential = googleCredentials;
        this.credentialAccessBoundary = (CredentialAccessBoundary) Preconditions.checkNotNull(builder.credentialAccessBoundary);
        if (builder.universeDomain == null || builder.universeDomain.trim().isEmpty()) {
            this.universeDomain = Credentials.GOOGLE_DEFAULT_UNIVERSE;
        } else {
            this.universeDomain = builder.universeDomain;
        }
        try {
            if (!this.universeDomain.equals(googleCredentials.getUniverseDomain())) {
                throw new IllegalArgumentException("The downscoped credential's universe domain must be the same as the source credential.");
            }
            this.tokenExchangeEndpoint = "https://sts.{universe_domain}/v1/token".replace("{universe_domain}", this.universeDomain);
        } catch (IOException e) {
            throw new IllegalStateException("Error occurred when attempting to retrieve source credential universe domain.", e);
        }
    }

    @Override // com.google.auth.oauth2.OAuth2Credentials
    public AccessToken refreshAccessToken() throws IOException {
        try {
            this.sourceCredential.refreshIfExpired();
            AccessToken accessToken = StsRequestHandler.newBuilder(this.tokenExchangeEndpoint, StsTokenExchangeRequest.newBuilder(this.sourceCredential.getAccessToken().getTokenValue(), "urn:ietf:params:oauth:token-type:access_token").setRequestTokenType("urn:ietf:params:oauth:token-type:access_token").build(), this.transportFactory.create().createRequestFactory()).setInternalOptions(this.credentialAccessBoundary.toJson()).build().exchangeToken().getAccessToken();
            if (accessToken.getExpirationTime() == null) {
                AccessToken accessToken2 = this.sourceCredential.getAccessToken();
                if (accessToken2.getExpirationTime() != null) {
                    return new AccessToken(accessToken.getTokenValue(), accessToken2.getExpirationTime());
                }
            }
            return accessToken;
        } catch (IOException e) {
            throw new IOException("Unable to refresh the provided source credential.", e);
        }
    }

    public GoogleCredentials getSourceCredentials() {
        return this.sourceCredential;
    }

    public CredentialAccessBoundary getCredentialAccessBoundary() {
        return this.credentialAccessBoundary;
    }

    @Override // com.google.auth.Credentials
    public String getUniverseDomain() {
        return this.universeDomain;
    }

    HttpTransportFactory getTransportFactory() {
        return this.transportFactory;
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    public static class Builder extends OAuth2Credentials.Builder {
        private CredentialAccessBoundary credentialAccessBoundary;
        private GoogleCredentials sourceCredential;
        private HttpTransportFactory transportFactory;
        private String universeDomain;

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
        }

        public Builder setSourceCredential(GoogleCredentials googleCredentials) {
            this.sourceCredential = googleCredentials;
            return this;
        }

        public Builder setCredentialAccessBoundary(CredentialAccessBoundary credentialAccessBoundary) {
            this.credentialAccessBoundary = credentialAccessBoundary;
            return this;
        }

        public Builder setHttpTransportFactory(HttpTransportFactory httpTransportFactory) {
            this.transportFactory = httpTransportFactory;
            return this;
        }

        public Builder setUniverseDomain(String str) {
            this.universeDomain = str;
            return this;
        }

        @Override // com.google.auth.oauth2.OAuth2Credentials.Builder
        public DownscopedCredentials build() {
            return new DownscopedCredentials(this, null);
        }
    }
}
