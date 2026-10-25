package com.google.auth.oauth2;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
class AwsRequestSignature {
    private String authorizationHeader;
    private AwsSecurityCredentials awsSecurityCredentials;
    private Map<String, String> canonicalHeaders;
    private String credentialScope;
    private String date;
    private String httpMethod;
    private String region;
    private String signature;
    private String url;

    /* synthetic */ AwsRequestSignature(AwsSecurityCredentials awsSecurityCredentials, Map map, String str, String str2, String str3, String str4, String str5, String str6, String str7, AnonymousClass1 anonymousClass1) {
        this(awsSecurityCredentials, map, str, str2, str3, str4, str5, str6, str7);
    }

    private AwsRequestSignature(AwsSecurityCredentials awsSecurityCredentials, Map<String, String> map, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.awsSecurityCredentials = awsSecurityCredentials;
        this.canonicalHeaders = map;
        this.signature = str;
        this.credentialScope = str2;
        this.url = str3;
        this.httpMethod = str4;
        this.date = str5;
        this.region = str6;
        this.authorizationHeader = str7;
    }

    String getSignature() {
        return this.signature;
    }

    String getCredentialScope() {
        return this.credentialScope;
    }

    AwsSecurityCredentials getSecurityCredentials() {
        return this.awsSecurityCredentials;
    }

    String getUrl() {
        return this.url;
    }

    String getHttpMethod() {
        return this.httpMethod;
    }

    Map<String, String> getCanonicalHeaders() {
        return new HashMap(this.canonicalHeaders);
    }

    String getDate() {
        return this.date;
    }

    String getRegion() {
        return this.region;
    }

    String getAuthorizationHeader() {
        return this.authorizationHeader;
    }

    static class Builder {
        private String authorizationHeader;
        private AwsSecurityCredentials awsSecurityCredentials;
        private Map<String, String> canonicalHeaders;
        private String credentialScope;
        private String date;
        private String httpMethod;
        private String region;
        private String signature;
        private String url;

        Builder() {
        }

        Builder setSignature(String str) {
            this.signature = str;
            return this;
        }

        Builder setCredentialScope(String str) {
            this.credentialScope = str;
            return this;
        }

        Builder setSecurityCredentials(AwsSecurityCredentials awsSecurityCredentials) {
            this.awsSecurityCredentials = awsSecurityCredentials;
            return this;
        }

        Builder setUrl(String str) {
            this.url = str;
            return this;
        }

        Builder setHttpMethod(String str) {
            this.httpMethod = str;
            return this;
        }

        Builder setCanonicalHeaders(Map<String, String> map) {
            this.canonicalHeaders = new HashMap(map);
            return this;
        }

        Builder setDate(String str) {
            this.date = str;
            return this;
        }

        Builder setRegion(String str) {
            this.region = str;
            return this;
        }

        Builder setAuthorizationHeader(String str) {
            this.authorizationHeader = str;
            return this;
        }

        AwsRequestSignature build() {
            return new AwsRequestSignature(this.awsSecurityCredentials, this.canonicalHeaders, this.signature, this.credentialScope, this.url, this.httpMethod, this.date, this.region, this.authorizationHeader, null);
        }
    }
}
