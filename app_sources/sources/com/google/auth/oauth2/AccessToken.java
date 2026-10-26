package com.google.auth.oauth2;

import com.google.common.base.MoreObjects;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/* INFO: loaded from: classes3.dex */
public class AccessToken implements Serializable {
    private static final long serialVersionUID = -8514239465808977353L;
    private final Long expirationTimeMillis;
    private final List<String> scopes;
    private final String tokenValue;

    /* synthetic */ AccessToken(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public AccessToken(String str, Date date) {
        this.tokenValue = str;
        this.expirationTimeMillis = date == null ? null : Long.valueOf(date.getTime());
        this.scopes = new ArrayList();
    }

    private AccessToken(Builder builder) {
        this.tokenValue = builder.getTokenValue();
        Date expirationTime = builder.getExpirationTime();
        this.expirationTimeMillis = expirationTime == null ? null : Long.valueOf(expirationTime.getTime());
        this.scopes = builder.getScopes();
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Builder toBuilder() {
        return new Builder(this);
    }

    public List<String> getScopes() {
        return this.scopes;
    }

    public String getTokenValue() {
        return this.tokenValue;
    }

    public Date getExpirationTime() {
        if (this.expirationTimeMillis == null) {
            return null;
        }
        return new Date(this.expirationTimeMillis.longValue());
    }

    Long getExpirationTimeMillis() {
        return this.expirationTimeMillis;
    }

    public int hashCode() {
        return Objects.hash(this.tokenValue, this.expirationTimeMillis, this.scopes);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("tokenValue", this.tokenValue).add("expirationTimeMillis", this.expirationTimeMillis).add("scopes", this.scopes).toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AccessToken)) {
            return false;
        }
        AccessToken accessToken = (AccessToken) obj;
        return Objects.equals(this.tokenValue, accessToken.tokenValue) && Objects.equals(this.expirationTimeMillis, accessToken.expirationTimeMillis) && Objects.equals(this.scopes, accessToken.scopes);
    }

    public static class Builder {
        private Date expirationTime;
        private List<String> scopes;
        private String tokenValue;

        protected Builder() {
            this.scopes = new ArrayList();
        }

        protected Builder(AccessToken accessToken) {
            this.scopes = new ArrayList();
            this.tokenValue = accessToken.getTokenValue();
            this.expirationTime = accessToken.getExpirationTime();
            this.scopes = accessToken.getScopes();
        }

        public String getTokenValue() {
            return this.tokenValue;
        }

        public List<String> getScopes() {
            return this.scopes;
        }

        public Date getExpirationTime() {
            return this.expirationTime;
        }

        public Builder setTokenValue(String str) {
            this.tokenValue = str;
            return this;
        }

        public Builder setScopes(String str) {
            if (str != null && str.trim().length() > 0) {
                this.scopes = Arrays.asList(str.split(" "));
            }
            return this;
        }

        public Builder setScopes(List<String> list) {
            if (list == null) {
                this.scopes = new ArrayList();
                return this;
            }
            this.scopes = list;
            return this;
        }

        public Builder setExpirationTime(Date date) {
            this.expirationTime = date;
            return this;
        }

        public AccessToken build() {
            return new AccessToken(this, (AnonymousClass1) null);
        }
    }
}
