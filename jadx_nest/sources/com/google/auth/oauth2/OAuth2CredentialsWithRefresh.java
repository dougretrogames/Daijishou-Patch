package com.google.auth.oauth2;

import com.google.common.base.Preconditions;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class OAuth2CredentialsWithRefresh extends OAuth2Credentials {
    private final OAuth2RefreshHandler refreshHandler;

    public interface OAuth2RefreshHandler {
        AccessToken refreshAccessToken() throws IOException;
    }

    protected OAuth2CredentialsWithRefresh(Builder builder) {
        super(builder.getAccessToken(), builder.getRefreshMargin(), builder.getExpirationMargin());
        if (builder.getAccessToken() != null && builder.getAccessToken().getExpirationTime() == null) {
            throw new IllegalArgumentException("The provided access token must contain the expiration time.");
        }
        this.refreshHandler = (OAuth2RefreshHandler) Preconditions.checkNotNull(builder.refreshHandler);
    }

    protected OAuth2CredentialsWithRefresh(AccessToken accessToken, OAuth2RefreshHandler oAuth2RefreshHandler) {
        super(accessToken);
        if (accessToken != null && accessToken.getExpirationTime() == null) {
            throw new IllegalArgumentException("The provided access token must contain the expiration time.");
        }
        this.refreshHandler = (OAuth2RefreshHandler) Preconditions.checkNotNull(oAuth2RefreshHandler);
    }

    @Override // com.google.auth.oauth2.OAuth2Credentials
    public AccessToken refreshAccessToken() throws IOException {
        return this.refreshHandler.refreshAccessToken();
    }

    public OAuth2RefreshHandler getRefreshHandler() {
        return this.refreshHandler;
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    public static class Builder extends OAuth2Credentials.Builder {
        private OAuth2RefreshHandler refreshHandler;

        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        private Builder() {
        }

        @Override // com.google.auth.oauth2.OAuth2Credentials.Builder
        public Builder setAccessToken(AccessToken accessToken) {
            super.setAccessToken(accessToken);
            return this;
        }

        public Builder setRefreshHandler(OAuth2RefreshHandler oAuth2RefreshHandler) {
            this.refreshHandler = oAuth2RefreshHandler;
            return this;
        }

        @Override // com.google.auth.oauth2.OAuth2Credentials.Builder
        public OAuth2CredentialsWithRefresh build() {
            return new OAuth2CredentialsWithRefresh(this);
        }
    }
}
