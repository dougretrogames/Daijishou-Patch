package com.google.auth.oauth2;

import com.google.api.client.http.HttpResponseException;
import com.google.api.client.json.GenericJson;
import com.google.common.base.Preconditions;
import java.io.IOException;
import javax.annotation.Nullable;

/* INFO: loaded from: classes3.dex */
class OAuthException extends GoogleAuthException {
    private final String errorCode;

    @Nullable
    private final String errorDescription;

    @Nullable
    private final String errorUri;

    OAuthException(String str, @Nullable String str2, @Nullable String str3) {
        this.errorCode = (String) Preconditions.checkNotNull(str);
        this.errorDescription = str2;
        this.errorUri = str3;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder sb = new StringBuilder("Error code " + this.errorCode);
        if (this.errorDescription != null) {
            sb.append(": ").append(this.errorDescription);
        }
        if (this.errorUri != null) {
            sb.append(" - ").append(this.errorUri);
        }
        return sb.toString();
    }

    String getErrorCode() {
        return this.errorCode;
    }

    @Nullable
    String getErrorDescription() {
        return this.errorDescription;
    }

    @Nullable
    String getErrorUri() {
        return this.errorUri;
    }

    static OAuthException createFromHttpResponseException(HttpResponseException httpResponseException) throws IOException {
        GenericJson genericJson = (GenericJson) OAuth2Utils.JSON_FACTORY.createJsonParser(httpResponseException.getContent()).parseAndClose(GenericJson.class);
        return new OAuthException((String) genericJson.get("error"), genericJson.containsKey("error_description") ? (String) genericJson.get("error_description") : null, genericJson.containsKey("error_uri") ? (String) genericJson.get("error_uri") : null);
    }
}
