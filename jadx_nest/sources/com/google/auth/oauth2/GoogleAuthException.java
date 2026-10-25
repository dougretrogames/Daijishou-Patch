package com.google.auth.oauth2;

import com.google.api.client.http.HttpResponseException;
import com.google.auth.Retryable;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
class GoogleAuthException extends IOException implements Retryable {
    private final boolean isRetryable;
    private final int retryCount;

    GoogleAuthException(boolean z, int i, String str, Throwable th) {
        super(str, th);
        this.isRetryable = z;
        this.retryCount = i;
    }

    GoogleAuthException(boolean z, int i, Throwable th) {
        super(th);
        this.isRetryable = z;
        this.retryCount = i;
    }

    GoogleAuthException(boolean z, Throwable th) {
        super(th);
        this.isRetryable = z;
        this.retryCount = 0;
    }

    GoogleAuthException(Throwable th) {
        this(false, th);
    }

    GoogleAuthException() {
        this.isRetryable = false;
        this.retryCount = 0;
    }

    static GoogleAuthException createWithTokenEndpointResponseException(HttpResponseException httpResponseException, String str) {
        boolean zContains = OAuth2Utils.TOKEN_ENDPOINT_RETRYABLE_STATUS_CODES.contains(Integer.valueOf(httpResponseException.getStatusCode()));
        int attemptCount = httpResponseException.getAttemptCount() - 1;
        if (str == null) {
            return new GoogleAuthException(zContains, attemptCount, httpResponseException);
        }
        return new GoogleAuthException(zContains, attemptCount, str, httpResponseException);
    }

    static GoogleAuthException createWithTokenEndpointResponseException(HttpResponseException httpResponseException) {
        return createWithTokenEndpointResponseException(httpResponseException, null);
    }

    static GoogleAuthException createWithTokenEndpointIOException(IOException iOException, String str) {
        if (str == null) {
            return new GoogleAuthException(true, 3, iOException);
        }
        return new GoogleAuthException(true, 3, str, iOException);
    }

    static GoogleAuthException createWithTokenEndpointIOException(IOException iOException) {
        return createWithTokenEndpointIOException(iOException, null);
    }

    @Override // com.google.auth.Retryable
    public boolean isRetryable() {
        return this.isRetryable;
    }

    @Override // com.google.auth.Retryable
    public int getRetryCount() {
        return this.retryCount;
    }
}
