package com.google.auth.oauth2;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
final class StsTokenExchangeResponse {
    private final AccessToken accessToken;

    @Nullable
    private final Long expiresInSeconds;
    private final String issuedTokenType;

    @Nullable
    private final String refreshToken;

    @Nullable
    private final List<String> scopes;
    private final String tokenType;

    /* synthetic */ StsTokenExchangeResponse(String str, String str2, String str3, Long l, String str4, List list, AnonymousClass1 anonymousClass1) {
        this(str, str2, str3, l, str4, list);
    }

    private StsTokenExchangeResponse(String str, String str2, String str3, @Nullable Long l, @Nullable String str4, @Nullable List<String> list) {
        Preconditions.checkNotNull(str);
        this.expiresInSeconds = l;
        Long lValueOf = l == null ? null : Long.valueOf(System.currentTimeMillis() + (l.longValue() * 1000));
        this.accessToken = new AccessToken(str, lValueOf != null ? new Date(lValueOf.longValue()) : null);
        this.issuedTokenType = (String) Preconditions.checkNotNull(str2);
        this.tokenType = (String) Preconditions.checkNotNull(str3);
        this.refreshToken = str4;
        this.scopes = list;
    }

    public static Builder newBuilder(String str, String str2, String str3) {
        return new Builder(str, str2, str3, null);
    }

    public AccessToken getAccessToken() {
        return this.accessToken;
    }

    public String getIssuedTokenType() {
        return this.issuedTokenType;
    }

    public String getTokenType() {
        return this.tokenType;
    }

    @Nullable
    public Long getExpiresInSeconds() {
        return this.expiresInSeconds;
    }

    @Nullable
    public String getRefreshToken() {
        return this.refreshToken;
    }

    @Nullable
    public List<String> getScopes() {
        if (this.scopes == null) {
            return null;
        }
        return new ArrayList(this.scopes);
    }

    public static class Builder {
        private final String accessToken;

        @Nullable
        private Long expiresInSeconds;
        private final String issuedTokenType;

        @Nullable
        private String refreshToken;

        @Nullable
        private List<String> scopes;
        private final String tokenType;

        /* synthetic */ Builder(String str, String str2, String str3, AnonymousClass1 anonymousClass1) {
            this(str, str2, str3);
        }

        private Builder(String str, String str2, String str3) {
            this.accessToken = str;
            this.issuedTokenType = str2;
            this.tokenType = str3;
        }

        public Builder setExpiresInSeconds(long j) {
            this.expiresInSeconds = Long.valueOf(j);
            return this;
        }

        public Builder setRefreshToken(String str) {
            this.refreshToken = str;
            return this;
        }

        public Builder setScopes(List<String> list) {
            if (list != null) {
                this.scopes = new ArrayList(list);
            }
            return this;
        }

        public StsTokenExchangeResponse build() {
            return new StsTokenExchangeResponse(this.accessToken, this.issuedTokenType, this.tokenType, this.expiresInSeconds, this.refreshToken, this.scopes, null);
        }
    }
}
