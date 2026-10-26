package com.google.auth.oauth2;

import javax.annotation.Nullable;

/* INFO: loaded from: classes3.dex */
public class AwsSecurityCredentials {
    private final String accessKeyId;
    private final String secretAccessKey;

    @Nullable
    private final String sessionToken;

    public AwsSecurityCredentials(String str, String str2, @Nullable String str3) {
        this.accessKeyId = str;
        this.secretAccessKey = str2;
        this.sessionToken = str3;
    }

    public String getAccessKeyId() {
        return this.accessKeyId;
    }

    public String getSecretAccessKey() {
        return this.secretAccessKey;
    }

    @Nullable
    public String getSessionToken() {
        return this.sessionToken;
    }
}
