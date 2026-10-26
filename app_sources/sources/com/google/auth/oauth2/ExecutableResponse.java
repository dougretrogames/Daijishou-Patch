package com.google.auth.oauth2;

import com.google.api.client.json.GenericJson;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.Instant;
import javax.annotation.Nullable;

/* INFO: loaded from: classes3.dex */
class ExecutableResponse {
    private static final String SAML_SUBJECT_TOKEN_TYPE = "urn:ietf:params:oauth:token-type:saml2";

    @Nullable
    private String errorCode;

    @Nullable
    private String errorMessage;

    @Nullable
    private Long expirationTime;

    @Nullable
    private String subjectToken;
    private final boolean success;

    @Nullable
    private String tokenType;
    private final int version;

    ExecutableResponse(GenericJson genericJson) throws IOException {
        String str;
        if (!genericJson.containsKey("version")) {
            throw new PluggableAuthException("INVALID_EXECUTABLE_RESPONSE", "The executable response is missing the `version` field.");
        }
        if (!genericJson.containsKey("success")) {
            throw new PluggableAuthException("INVALID_EXECUTABLE_RESPONSE", "The executable response is missing the `success` field.");
        }
        this.version = parseIntField(genericJson.get("version"));
        boolean zBooleanValue = ((Boolean) genericJson.get("success")).booleanValue();
        this.success = zBooleanValue;
        if (zBooleanValue) {
            if (!genericJson.containsKey("token_type")) {
                throw new PluggableAuthException("INVALID_EXECUTABLE_RESPONSE", "The executable response is missing the `token_type` field.");
            }
            this.tokenType = (String) genericJson.get("token_type");
            if (genericJson.containsKey("expiration_time")) {
                this.expirationTime = Long.valueOf(parseLongField(genericJson.get("expiration_time")));
            }
            if (SAML_SUBJECT_TOKEN_TYPE.equals(this.tokenType)) {
                this.subjectToken = (String) genericJson.get("saml_response");
            } else {
                this.subjectToken = (String) genericJson.get("id_token");
            }
            String str2 = this.subjectToken;
            if (str2 == null || str2.isEmpty()) {
                throw new PluggableAuthException("INVALID_EXECUTABLE_RESPONSE", "The executable response does not contain a valid token.");
            }
            return;
        }
        this.errorCode = (String) genericJson.get("code");
        this.errorMessage = (String) genericJson.get("message");
        String str3 = this.errorCode;
        if (str3 == null || str3.isEmpty() || (str = this.errorMessage) == null || str.isEmpty()) {
            throw new PluggableAuthException("INVALID_EXECUTABLE_RESPONSE", "The executable response must contain `error` and `message` fields when unsuccessful.");
        }
    }

    int getVersion() {
        return this.version;
    }

    boolean isSuccessful() {
        return this.success;
    }

    boolean isExpired() {
        Long l = this.expirationTime;
        return l != null && l.longValue() <= Instant.now().getEpochSecond();
    }

    boolean isValid() {
        return isSuccessful() && !isExpired();
    }

    @Nullable
    Long getExpirationTime() {
        return this.expirationTime;
    }

    @Nullable
    String getTokenType() {
        return this.tokenType;
    }

    @Nullable
    String getSubjectToken() {
        return this.subjectToken;
    }

    @Nullable
    String getErrorCode() {
        return this.errorCode;
    }

    @Nullable
    String getErrorMessage() {
        return this.errorMessage;
    }

    private static int parseIntField(Object obj) {
        if (obj instanceof String) {
            return Integer.parseInt((String) obj);
        }
        if (obj instanceof BigDecimal) {
            return ((BigDecimal) obj).intValue();
        }
        return ((Integer) obj).intValue();
    }

    private static long parseLongField(Object obj) {
        if (obj instanceof String) {
            return Long.parseLong((String) obj);
        }
        if (obj instanceof BigDecimal) {
            return ((BigDecimal) obj).longValue();
        }
        return ((Long) obj).longValue();
    }
}
