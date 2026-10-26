package com.google.auth.oauth2;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* INFO: loaded from: classes3.dex */
public class AwsCredentialSource extends ExternalAccountCredentials.CredentialSource {
    static final String IMDSV2_SESSION_TOKEN_URL_FIELD_NAME = "imdsv2_session_token_url";
    static final long serialVersionUID = -4180558200808134436L;
    final String imdsv2SessionTokenUrl;
    final String regionUrl;
    final String regionalCredentialVerificationUrl;
    final String url;

    public AwsCredentialSource(Map<String, Object> map) {
        super(map);
        if (!map.containsKey("regional_cred_verification_url")) {
            throw new IllegalArgumentException("A regional_cred_verification_url representing the GetCallerIdentity action URL must be specified.");
        }
        Matcher matcher = Pattern.compile("(aws)([\\d]+)").matcher((String) map.get("environment_id"));
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid AWS environment ID.");
        }
        int i = Integer.parseInt(matcher.group(2));
        if (i != 1) {
            throw new IllegalArgumentException(String.format("AWS version %s is not supported in the current build.", Integer.valueOf(i)));
        }
        this.regionUrl = (String) map.get("region_url");
        this.url = (String) map.get("url");
        this.regionalCredentialVerificationUrl = (String) map.get("regional_cred_verification_url");
        if (map.containsKey(IMDSV2_SESSION_TOKEN_URL_FIELD_NAME)) {
            this.imdsv2SessionTokenUrl = (String) map.get(IMDSV2_SESSION_TOKEN_URL_FIELD_NAME);
        } else {
            this.imdsv2SessionTokenUrl = null;
        }
    }
}
